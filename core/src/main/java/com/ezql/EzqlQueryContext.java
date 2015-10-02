package com.ezql;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;

public class EzqlQueryContext {
    String dataSource;
    QueryBuilder qb;
    @SuppressWarnings("rawtypes")
    List<AggregationBuilder> aggs;
    int limit = 500;

    public String getDataSource() {
	return dataSource;
    }

    public void setDataSource(String dataSource) {
	this.dataSource = dataSource;
    }

    public List<AggregationBuilder> getAggs() {
	return aggs;
    }

    public void setAggs(List<AggregationBuilder> aggs) {
	this.aggs = aggs;
    }

    public QueryBuilder getQb() {
	return qb;
    }

    public void setQb(QueryBuilder qb) {
	this.qb = qb;
    }

    public int getLimit() {
	return limit;
    }

    public void setLimit(int limit) {
	this.limit = limit;
    }
}
