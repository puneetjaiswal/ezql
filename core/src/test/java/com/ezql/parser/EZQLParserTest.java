package com.ezql.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EZQLParserTest {
    List<String> testQueries;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws IOException {
	testQueries = new ArrayList<>();
	InputStream ins = getClass().getResourceAsStream("/valid.ezql");
	BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
	String str = null;
	while ((str = reader.readLine()) != null) {
	    testQueries.add(str);
	}
    }

    @Test
    public void testParserFailure() throws Exception {
	int count = 0;
	List<String> failureQueries = new ArrayList<>();
	InputStream ins = getClass().getResourceAsStream("/invalid.ezql");
	BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
	String str = null;
	while ((str = reader.readLine()) != null) {
	    failureQueries.add(str);
	}
	int failureCount = 0;
	for (String input : failureQueries) {
	    System.out.println("Running example" + ++count + " input => " + input);
	    EZQLLexer lexer = new EZQLLexer(new ANTLRInputStream(input));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    EZQLParser parser = new EZQLParser(tokens);
	    try {
		parser.addErrorListener(new BaseErrorListener() {
		    @Override
		    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
			    int charPositionInLine, String msg, RecognitionException e) {
			throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
		    }
		});
		ParseTree parseTree = parser.statement();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new EZQLBaseListener(), parseTree);
		Assert.assertEquals(failureCount, failureQueries.size());
	    } catch (IllegalStateException e) {
		failureCount++;
		System.out.println("query [" + input + "] failed with message" + e.getMessage());
	    }
	}
    }

    @Test
    public void testParserSuccess() throws Exception {
	int count = 0;
	for (String input : testQueries) {
	    System.out.println("Running example" + ++count + " input => " + input);
	    EZQLLexer lexer = new EZQLLexer(new ANTLRInputStream(input));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    EZQLParser parser = new EZQLParser(tokens);
	    parser.addErrorListener(new BaseErrorListener() {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
			int charPositionInLine, String msg, RecognitionException e) {
		    throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
		}
	    });
	    ParseTree parseTree = parser.statement();
	    ParseTreeWalker walker = new ParseTreeWalker();
	    walker.walk(new EZQLBaseListener(), parseTree);
	}
    }
}
