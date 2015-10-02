package com.ezql.parser.impl;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeFilterBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;

/**
 * A predicate builder utility for elasticsearch
 * 
 * @author puneet.jaiswal
 *
 */
public class ElasticSearchPredicateBuilder {

    static QueryBuilder buildQueryStringMatchQuery(String path, String field, String textTerms) {
	return QueryBuilders.queryStringQuery(textTerms).field(field).field("_all");
    }

    static QueryBuilder buildTextTermsMatchQuery(String path, String field, String textTerms, Operator op) {
	QueryBuilder qb = QueryBuilders.matchQuery(field, textTerms).operator(op);
	if (!"".equals(path)) {
	    return QueryBuilders.nestedQuery(path, qb);
	}
	return qb;
    }

    static QueryBuilder buildTermsMatchQuery(String path, String field, List<Object> values) {
	BoolQueryBuilder localShouldQueryBuilder = QueryBuilders.boolQuery();
	for (Object eq : values) {
	    localShouldQueryBuilder.should(QueryBuilders.matchQuery(field, eq));
	}
	if (!"".equals(path)) {
	    return QueryBuilders.nestedQuery(path, localShouldQueryBuilder);
	}
	return localShouldQueryBuilder;
    }

    static FilterBuilder filterGreaterThanPredicate(String path, String fieldName, Object low, boolean includeLow) {
	return buildRangePredicate(path, fieldName, low, null, includeLow, false);
    }

    static FilterBuilder filterLesserThanPredicate(String path, String fieldName, Object high, boolean includeHigh) {
	return buildRangePredicate(path, fieldName, null, high, false, includeHigh);
    }

    static FilterBuilder filterTermEqualsPredicate(String path, String fieldName, Object value) {
	FilterBuilder output;
	if (value == null) {
	    output = FilterBuilders.missingFilter(fieldName);
	} else {
	    output = FilterBuilders.termFilter(fieldName, value);
	}
	if (!"".equals(path)) {
	    return FilterBuilders.nestedFilter(path, output);
	}
	return output;
    }

    static FilterBuilder filterInPredicate(String path, String fieldName, List<Object> value) {
	FilterBuilder output;
	output = FilterBuilders.termsFilter(fieldName, value);
	if (!"".equals(path)) {
	    return FilterBuilders.nestedFilter(path, output);
	}
	return output;
    }

    static FilterBuilder filterNotEqualsPredicate(String path, String fieldName, Object value) {
	FilterBuilder output;
	if (value == null) {
	    output = FilterBuilders.existsFilter(fieldName);
	}
	FilterBuilder termFilter = FilterBuilders.termFilter(fieldName, value);
	output = FilterBuilders.notFilter(termFilter);
	if (!"".equals(path)) {
	    return FilterBuilders.nestedFilter(path, output);
	}
	return output;
    }

    static FilterBuilder filterNotInPredicate(String path, String fieldName, List<Object> value) {
	FilterBuilder output;
	FilterBuilder termFilter = FilterBuilders.termsFilter(fieldName, value);
	output = FilterBuilders.notFilter(termFilter);
	if (!"".equals(path)) {
	    return FilterBuilders.nestedFilter(path, output);
	}
	return output;
    }

    static FilterBuilder buildRangePredicate(String path, String fieldName, Object low, Object high,
	    boolean includeLow, boolean includeHigh) {
	if (low == null && high == null) {
	    return null;
	}
	RangeFilterBuilder rfb = FilterBuilders.rangeFilter(fieldName);
	if (low != null) {
	    if (includeLow) {
		rfb.gte(low);
	    } else {
		rfb.gt(low);
	    }
	}
	if (high != null) {
	    if (includeHigh) {
		rfb.lte(high);
	    } else {
		rfb.lte(high);
	    }
	}
	if (!"".equals(path)) {
	    return FilterBuilders.nestedFilter(path, rfb);
	}
	return rfb;
    }
}
