package com.ezql.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ezql.EzqlQueryContext;
import com.ezql.parser.EZQLBaseListener;
import com.ezql.parser.EZQLParser;
import com.ezql.parser.EZQLParser.TextContext;
import com.ezql.parser.util.EsMappingUtil;
import com.ezql.parser.util.FieldDetails;

import org.antlr.v4.runtime.tree.ParseTree;
import org.elasticsearch.index.query.AndFilterBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;

import static com.ezql.parser.impl.ElasticSearchPredicateBuilder.*;

public final class EzqlToEsQueryListener extends EZQLBaseListener {

    EzqlQueryContext queryContext;

    Map<String, FieldDetails> fieldMetadataMap;

    @SuppressWarnings("rawtypes")
    List<AggregationBuilder> aggs;

    List<QueryBuilder> mustQueries;
    List<QueryBuilder> mustNotQueries;

    // version v1 is mostly built on filters.
    List<FilterBuilder> mustFilters;

    // to be collected at expr_exit and added in must filters.
    List<FilterBuilder> oredFilters;

    public EzqlToEsQueryListener(Map<String, FieldDetails> fieldMetadataMap) {
	mustFilters = new ArrayList<>();
	mustQueries = new ArrayList<>();
	mustNotQueries = new ArrayList<>();
	this.fieldMetadataMap = fieldMetadataMap;
	oredFilters = new ArrayList<>();
	queryContext = new EzqlQueryContext();
	aggs = new ArrayList<>();
    }

    public EzqlQueryContext buildQuery() {
	QueryBuilder qb;
	if (mustQueries.size() > 0 || mustNotQueries.size() > 0) {
	    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
	    for (QueryBuilder q : mustQueries) {
		if (q != null) {
		    boolQueryBuilder.must(q);
		}
	    }
	    for (QueryBuilder q : mustNotQueries) {
		if (q != null) {
		    boolQueryBuilder.mustNot(q);
		}
	    }
	    qb = boolQueryBuilder;
	} else {
	    qb = QueryBuilders.matchAllQuery();
	}
	if (mustFilters.size() > 0) {
	    AndFilterBuilder fb = FilterBuilders.andFilter();
	    for (FilterBuilder f : mustFilters) {
		if (f != null) {
		    fb.add(f);
		}
	    }
	    qb = QueryBuilders.filteredQuery(qb, fb);
	}
	queryContext.setQb(qb);
	queryContext.setAggs(aggs);
	return queryContext;
    }

    /*
     * ------------------------------- Actual parsing------------------
     * Predicates are always ORed in expr. Collect filters and OR them in
     * exit_expr. Expressions are always ANDed in stmt.
     */
    @Override
    public void exitSelectdb(EZQLParser.SelectdbContext ctx) {
	String dbName = stripQuotes(ctx.field().getText());
	queryContext.setDataSource(dbName);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void exitFunction_group_by(EZQLParser.Function_group_byContext ctx) {
	String function = ctx.function().getText();
	boolean singleAggs = false;
	// String resultType = "combined";
	// if (ctx.result_type() != null) {
	// resultType = stripQuotes(ctx.result_type().getText()).toLowerCase();
	// }
	// if (resultType.startsWith("separate")) {
	// singleAggs = false;
	// }
	// // TODO : till combined mode is fixed, we got to live with separate
	// aggs :) !
	// singleAggs = false;

	if (ctx.field().size() > 0) {
	    List<String> fields = new ArrayList<>();
	    for (ParseTree p : ctx.field()) {
		fields.add(stripQuotes(p.getText()));
	    }
	    AggregationBuilder tb = null;
	    for (String field : fields) {
		if (tb == null) {
		    tb = buildTermAggs(function, field);
		    if (tb != null) {
			aggs.add(tb);
		    }
		} else {
		    AggregationBuilder termsAgg = buildTermAggs(function, field);
		    if (termsAgg == null) {
			continue;
		    }
		    if (singleAggs) {
			tb.subAggregation(termsAgg);
			// supporting only two level of group by
			break;
		    } else {
			aggs.add(termsAgg);
		    }
		}
	    }
	}
    }

    @SuppressWarnings("rawtypes")
    AggregationBuilder buildTermAggs(String function, String field) {
	// function is count for now.
	// TODO: add support to sum/avg/min/max etc

	String fieldName = field;
	FieldDetails fieldMetadata = fieldMetadataMap.get(field.toLowerCase());
	if (fieldMetadata != null) {
	    fieldName = fieldMetadata.getFieldName();
	    String path = fieldMetadata.getNestedParent();
	    if (!"".equals(path)) {
		// TODO: support nested aggs
		NestedBuilder nestedBuilder = AggregationBuilders.nested(function + "_aggs_" + field).path(path);
		TermsBuilder tb = AggregationBuilders.terms(function + "_aggs_" + field).field(fieldName);
		nestedBuilder.subAggregation(tb);
		return null;
	    }
	}
	TermsBuilder tb = AggregationBuilders.terms(function + "_aggs_" + field);
	tb.field(fieldName);
	return tb;
    }

    @Override
    public void exitLimitclause(EZQLParser.LimitclauseContext ctx) {
	int limit = Integer.parseInt(stripQuotes(ctx.NUMBER().getText()));
	queryContext.setLimit(limit);
    }

    @Override
    public void exitExpr(EZQLParser.ExprContext ctx) {
	// Collect ored filters and add the resultant to andFilter group
	if (oredFilters.size() == 0) {
	    return;
	}
	if (oredFilters.size() == 1) {
	    mustFilters.addAll(oredFilters);
	}

	if (oredFilters.size() > 1) {
	    FilterBuilder[] fb = new FilterBuilder[0];
	    FilterBuilder oredFilter = FilterBuilders.orFilter(oredFilters.toArray(fb));
	    mustFilters.add(oredFilter);
	}
	oredFilters.clear();
    }

    @Override
    public void exitRangePredicate(EZQLParser.RangePredicateContext ctx) {
	String field = stripQuotes(ctx.field().getText());
	Object low = stripQuotes(ctx.low().getText());
	Object high = stripQuotes(ctx.high().getText());
	FieldDetails fieldMetadata = getFieldMetadata(field.toLowerCase());
	String path = "";
	if (fieldMetadata != null) {
	    path = fieldMetadata.getNestedParent();
	    field = fieldMetadata.getFieldName();
	    if (!"".equals(path)) {
		field = path + "." + field;
	    }
	    String type = fieldMetadata.getFieldType();
	    low = EsMappingUtil.getObjectFromString(type, low.toString());
	    high = EsMappingUtil.getObjectFromString(type, high.toString());
	}
	mustFilters.add(buildRangePredicate(path, field, low, high, true, true));
    }

    @Override
    public void exitText_predicate(EZQLParser.Text_predicateContext ctx) {
	List<ParseTree> children = ctx.children;
	if (children == null || children.size() == 0) {
	    return;
	}
	String query = "";
	for (ParseTree p : children) {
	    String text = stripQuotes(p.getText());
	    query += "".equals(query) ? text : (" " + text);
	}
	if (!query.equals("")) {
	    mustQueries.add(buildTextTermsMatchQuery("", "_all", query, Operator.OR));
	}
    }

    @Override
    public void exitSingleValuePredicate(EZQLParser.SingleValuePredicateContext ctx) {
	String field = stripQuotes(ctx.field().getText());
	String op = ctx.OPS().getText();
	String value = stripQuotes(ctx.text().getText().trim());
	buildSingleValuePredicate(field, op, value);
    }

    @Override
    public void exitMultiValuePredicate(EZQLParser.MultiValuePredicateContext ctx) {
	String field = stripQuotes(ctx.field().getText());
	String op = ctx.MULTI_VAL_OPS().getText();
	List<Object> values = new ArrayList<>();
	String allStringsForTextTerms = "";
	List<TextContext> textValues = ctx.values().text();
	for (TextContext text : textValues) {
	    String term = stripQuotes(text.getText());
	    values.add(term);
	    allStringsForTextTerms += "".equals(allStringsForTextTerms) ? term : (" " + term);
	}
	buildMultiValuePredicate(field, op, values, allStringsForTextTerms);
    }

    private void buildMultiValuePredicate(String field, String op, List<Object> vals, String allTerms) {
	if (vals.size() == 0) {
	    return;
	}
	String path = "";
	FieldDetails fieldMetadata = getFieldMetadata(field.toLowerCase());
	List<Object> values = vals;

	if (fieldMetadata != null) {
	    values = new ArrayList<>();
	    field = fieldMetadata.getFieldName();
	    path = fieldMetadata.getNestedParent();
	    if (!"".equals(path)) {
		values = new ArrayList<>();
		field = path + "." + field;
	    }
	    String type = fieldMetadata.getFieldType();
	    for (Object str : vals) {
		Object val = EsMappingUtil.getObjectFromString(type, str.toString());
		values.add(val);
	    }
	}

	switch (op) {
	case "has":
	case "contains":
	    mustQueries.add(buildQueryStringMatchQuery(path, field, allTerms));
	    // mustQueries.add(buildTextTermsMatchQuery(path, field, allTerms,
	    // Operator.OR));
	    break;
	case "in":
	    mustFilters.add(filterInPredicate(path, field, values));
	    break;
	case "not in":
	    mustFilters.add(filterNotInPredicate(path, field, values));
	    break;
	default:
	    throw new IllegalArgumentException("unknown multi value op : " + op);
	}
    }

    private void buildSingleValuePredicate(String field, String op, String val) {
	FilterBuilder result = null;
	String path = "";
	FieldDetails fieldMetadata = getFieldMetadata(field.toLowerCase());
	Object value = val;
	if (fieldMetadata != null) {
	    field = fieldMetadata.getFieldName();
	    path = fieldMetadata.getNestedParent();
	    if (!"".equals(path)) {
		field = path + "." + field;
	    }
	    String type = fieldMetadata.getFieldType();
	    value = EsMappingUtil.getObjectFromString(type, val);
	}
	switch (op) {
	case "=":
	    result = filterTermEqualsPredicate(path, field, value);
	    break;
	case "!=":
	    result = filterNotEqualsPredicate(path, field, value);
	    break;
	case ">":
	    result = filterGreaterThanPredicate(path, field, value, false);
	    break;
	case ">=":
	case "=>":
	    result = filterGreaterThanPredicate(path, field, value, true);
	    break;
	case "<":
	    result = filterLesserThanPredicate(path, field, value, false);
	    break;
	case "<=":
	case "=<":
	    result = filterLesserThanPredicate(path, field, value, true);
	    break;
	default:
	    throw new IllegalArgumentException("Unknown op " + op);
	}
	if (result != null) {
	    oredFilters.add(result);
	}
    }


    private FieldDetails getFieldMetadata(String field) {
	if (fieldMetadataMap == null) {
	    return null;
	}
	FieldDetails fieldDetails = fieldMetadataMap.get(field.toLowerCase());
	if (fieldDetails == null) {
	    throw new IllegalArgumentException("Field : [" + field + "] not found in field metadata");
	}
	return fieldDetails;
    }

    private String stripQuotes(String stringLiteral) {
	if (stringLiteral.startsWith("\"")) {
	    return stringLiteral.substring(1, stringLiteral.length() - 1);
	}
	if (stringLiteral.equals("null")) {
	    return null;
	}
	return stringLiteral;
    }
}
