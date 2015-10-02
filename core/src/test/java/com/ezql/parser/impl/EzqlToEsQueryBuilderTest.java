package com.ezql.parser.impl;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ezql.EzqlQueryContext;
import com.ezql.parser.EZQLLexer;
import com.ezql.parser.EZQLParser;
import com.ezql.parser.util.FieldDetails;

public class EzqlToEsQueryBuilderTest {

    @Test
    public void testQueryBuilder() {
	Map<String, FieldDetails> fieldMetaDataMap = new HashMap<>();
	FieldDetails statusCode = new FieldDetails("statusCode", "httpData", "integer");
	FieldDetails hostName = new FieldDetails("hostName", "", "string");
	FieldDetails clusterName = new FieldDetails("clusterName", "", "string");
	FieldDetails field2 = new FieldDetails("field2", "customData.custom", "integer");
	FieldDetails field4 = new FieldDetails("field4", "customData.custom", "string");
	FieldDetails responseTime = new FieldDetails("responseTime", "customData.exitCall", "integer");
	FieldDetails message = new FieldDetails("message", "", "string");
	FieldDetails logLevel = new FieldDetails("logLevel", "", "string");
	fieldMetaDataMap.put("statuscode", statusCode);
	fieldMetaDataMap.put("hostname", hostName);
	fieldMetaDataMap.put("clustername", clusterName);
	fieldMetaDataMap.put("field2", field2);
	fieldMetaDataMap.put("field4", field4);
	fieldMetaDataMap.put("responsetime", responseTime);
	fieldMetaDataMap.put("message", message);
	fieldMetaDataMap.put("loglevel", logLevel);

	String inputTestQuery = "DB>>logs| statusCode=512 | error \"quoted text1\" failure|hostName=api03 "
		+ " or clusterName!=cl01 or field2=10 OR responseTime > 100| field4=\"quoted text\""
		+ " | logLevel in (WARN, INFO, FATAL)| message has (exception, timeout) | count by loglevel, hostname ;";

	System.out.println("Parsing query: " + inputTestQuery);
	EzqlToEsQueryListener queryBuilder = new EzqlToEsQueryListener(fieldMetaDataMap);
	EZQLLexer lexer = new EZQLLexer(new ANTLRInputStream(inputTestQuery));
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	EZQLParser parser = new EZQLParser(tokens);
	parser.addErrorListener(new BaseErrorListener() {
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
		    int charPositionInLine, String msg, RecognitionException e) {
		throw new IllegalStateException("failed to parse at line " + line + ", at position "
			+ charPositionInLine + " due to " + msg, e);
	    }
	});
	ParseTree parseTree = parser.statement();
	ParseTreeWalker walker = new ParseTreeWalker();
	walker.walk(queryBuilder, parseTree);
	EzqlQueryContext qb = queryBuilder.buildQuery();
	System.out.println(qb);
	Assert.assertNotNull(qb);
    }
}
