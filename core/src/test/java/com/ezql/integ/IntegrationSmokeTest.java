package com.ezql.integ;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ezql.EzqlQueryBuilder;
import com.ezql.EzqlQueryContext;
import com.ezql.parser.util.EsMappingUtil;
import com.ezql.parser.util.FieldDetails;

import static org.testng.Assert.*;

public class IntegrationSmokeTest {
    static final String INDEX_NAME = "myindex_" + System.currentTimeMillis();
    static final String USER_TYPE = "user";

    static final String DEFAULT_MAPPING = "{\"mappings\":{\"_default_\":{\"dynamic_templates\":["
	    + "{\"string_fields\":{\"mapping\":{\"type\":\"string\",\"index\":\"not_analyzed\"},"
	    + "\"match\":\"*\",\"match_mapping_type\":\"string\"}},"
	    + "{\"dates\":{\"match\":\".*Date|Timestamp|date|timestamp\",\"match_pattern\":\"regex\","
	    + "\"mapping\":{\"type\":\"date\", \"format\" : \"dateOptionalTime\" }}}]}}}";

    static final String[] USER_DATA_ARR = {
	    "{\"id\":1, \"user\":{\"name\":\"Obi Wan Kenobi\", \"designation\":\"jedi trainer\"}, \"logLevel\":\"ERROR\", \"host\" : \"api01\",\"message\":\"index compaction failure occurred\",\"timestamp\":\"2015-02-28T05:09:40.134-0700\" }",
	    "{\"id\":2, \"user\":{\"name\":\"Master yoda\", \"designation\":\"jedi head\"}, \"logLevel\":\"WARN\", \"host\" : \"api02\",\"message\":\"index compaction failure occurred. recovering.\",\"timestamp\":\"2015-02-28T05:09:41.134-0700\" }",
	    "{\"id\":3, \"user\":{\"name\":\"luke skywalker\", \"designation\":\"jedi padavan\"}, \"logLevel\":\"FATAL\", \"host\" : \"api03\",\"message\":\"index compaction failure occurred. Could not recovered. Shard failure\",\"timestamp\":\"2015-02-28T05:09:42.134-0700\" }",
	    "{\"id\":4, \"user\":{\"name\":\"puneet jaiswal\", \"designation\":\"mere mortal\"}, \"logLevel\":\"INFO\", \"host\" : \"api01\",\"message\":\"host api03 leader elected\",\"timestamp\":\"2015-02-28T05:09:43.134-0700\" }" };

    Node elasticSearchServer;
    Client elasticSearchClient;
    Map<String, FieldDetails> userFieldDataMap;
    EzqlQueryBuilder queryBuilder;

    @SuppressWarnings("unchecked")
    @BeforeClass(alwaysRun = true)
    public void start() throws Exception {
	// Start elasticsearch single node in memory instance.
	Settings settings = ImmutableSettings.settingsBuilder().put("index.gateway.type", "none")
		.put("index.indexing.slowlog.threshold.index.info", "0ms").put("index.search.slowlog.level", "info")
		.put("index.search.slowlog.threshold.query.trace", "0ms").put("index.store.type", "memory")
		.put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build();

	this.elasticSearchServer = NodeBuilder.nodeBuilder().local(true).settings(settings).node();
	this.elasticSearchClient = this.elasticSearchServer.client();
	this.elasticSearchClient.admin().indices().create(new CreateIndexRequest(INDEX_NAME).source(DEFAULT_MAPPING))
		.actionGet();

	// Ingest some data
	prepareDataForTesting(USER_DATA_ARR);

	// Refresh required, to view results immediately.
	elasticSearchClient.admin().indices().prepareRefresh().execute().actionGet();

	// Build field metadata map
	Map<String, Object> properties = (Map<String, Object>) elasticSearchClient.admin().indices()
		.prepareGetMappings(INDEX_NAME).setTypes(USER_TYPE).execute().get().getMappings().get(INDEX_NAME)
		.get(USER_TYPE).getSourceAsMap().get("properties");
	userFieldDataMap = EsMappingUtil.getFieldDetailsFromEsMapping(properties);
	queryBuilder = new EzqlQueryBuilder();
    }

    @Test
    public void testEzqlSimpleFilter() throws IOException {
	String query = "id =1 ;";
	SearchResponse response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 1);

	query = "id in (1,2,3) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 3);

	query = "id not in (1,2,3) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), USER_DATA_ARR.length - 3);

	query = "id in (1,2,3)|loglevel in (ERROR, WARN) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 2);

	query = "id in (1,2,3)|loglevel not in (ERROR, WARN) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 1);

	query = "id in (1,2,3)|loglevel=FATAL ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 1);

	query = "api03 ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 2);
    }

    @Test
    public void testEzqlFuzzyMatch() throws IOException {
	String query = "\"compaction failure\" index puneet ;";
	SearchResponse response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 4);

	query = "\"compaction failure\" index jaiswal | loglevel=INFO | host=api01 ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 1);

	query = "user.designation has (trainer, jedi, head) | host in (api01,api02,api03) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 3);

	query = "message contains (\"index\", compaction, leader) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 4);
    }

    @Test
    public void testEzqlNestedFilter() throws IOException {
	// Field Type object
	String query = "user.name =\"puneet jaiswal\" ;";
	SearchResponse response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 1);
	// TODO: add an actual nested type filter test
    }

    @Test
    public void testEzqlRangeFilter() throws IOException {
	// Field Type object
	String query = "id  > 1 | id <=4 | loglevel in (ERROR, FATAL, WARN, INFO) ;";
	SearchResponse response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 3);

	query = "id between (1,4) ;";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 4);

	query = "id between (1,4) | timestamp between (2015-02-28T05:09:40.134-0700, \"2015-02-28T05:09:43.134-0700\");";
	response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 4);
    }

    @Test
    public void testEzqlAggsCountBy() throws IOException {
	// Field Type object
	String query = "id  > 1 | id <=4 | logLevel in (ERROR, FATAL, WARN, INFO) | count by loglevel ;";
	SearchResponse response = executeQuery(buildQuery(query));
	assertEquals(response.getHits().totalHits(), 3);
	// TODO: test this
	// int ch = System.in.read();
	// while (ch != 'q') {
	// ch = System.in.read();
	// }
    }

    @AfterClass(alwaysRun = true)
    public void stop() throws InterruptedException {
	elasticSearchClient.admin().indices().prepareDelete(INDEX_NAME).execute().actionGet();
	elasticSearchClient.close();
	elasticSearchServer.stop();
    }

    @SuppressWarnings("rawtypes")
    SearchResponse executeQuery(EzqlQueryContext queryContext) {
	assertNotNull(queryContext);
	QueryBuilder qb = queryContext.getQb();
	assertNotNull(qb);
	SearchRequestBuilder srb = elasticSearchClient.prepareSearch(INDEX_NAME).setTypes(USER_TYPE)
		.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(qb);
	List<AggregationBuilder> aggs = queryContext.getAggs();
	if (aggs != null && aggs.size() > 0) {
	    for (AggregationBuilder a : aggs) {
		srb.addAggregation(a);
	    }
	}
	return srb.setFrom(0).setSize(queryContext.getLimit()).execute().actionGet();
    }

    private EzqlQueryContext buildQuery(String query) {
	return queryBuilder.buildQuery(query, userFieldDataMap);
    }

    private void prepareDataForTesting(String... jsonData) {
	for (String s : jsonData) {
	    IndexResponse response = elasticSearchClient.prepareIndex(INDEX_NAME, USER_TYPE).setSource(s).execute()
		    .actionGet();
	    assertNotNull(response.getId());
	}
    }
}
