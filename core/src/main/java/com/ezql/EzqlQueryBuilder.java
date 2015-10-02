package com.ezql;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.ezql.parser.EZQLLexer;
import com.ezql.parser.EZQLParser;
import com.ezql.parser.impl.EzqlToEsQueryListener;
import com.ezql.parser.util.FieldDetails;

public class EzqlQueryBuilder {

    public EzqlQueryContext buildQuery(String inputTestQuery, Map<String, FieldDetails> fieldsDataMap) {
	EzqlToEsQueryListener queryBuilder = new EzqlToEsQueryListener(fieldsDataMap);
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
	return queryBuilder.buildQuery();
    }
}
