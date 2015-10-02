// Generated from ./src/main/java/com/ezql/parser/EZQL.g4 by ANTLR 4.5
package com.ezql.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EZQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DB=11, MULTI_VAL_OPS=12, OPS=13, BETWEEN=14, AND=15, OR=16, NOT=17, 
		HAS=18, CONTAINS=19, IN=20, NOT_IN=21, EQ=22, NEQ=23, GTE=24, LTE=25, 
		GT=26, LT=27, NUMBER=28, QTEXT=29, UQTEXT=30, WS=31;
	public static final int
		RULE_statement = 0, RULE_selectdb = 1, RULE_limitclause = 2, RULE_expr = 3, 
		RULE_text_predicate = 4, RULE_predicate = 5, RULE_singleValuePredicate = 6, 
		RULE_multiValuePredicate = 7, RULE_rangePredicate = 8, RULE_low = 9, RULE_high = 10, 
		RULE_values = 11, RULE_field = 12, RULE_function_group_by = 13, RULE_text = 14, 
		RULE_function = 15, RULE_count_function = 16, RULE_sum_function = 17;
	public static final String[] ruleNames = {
		"statement", "selectdb", "limitclause", "expr", "text_predicate", "predicate", 
		"singleValuePredicate", "multiValuePredicate", "rangePredicate", "low", 
		"high", "values", "field", "function_group_by", "text", "function", "count_function", 
		"sum_function"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "';'", "'>>'", "'limit'", "'('", "','", "')'", "'by'", "'count'", 
		"'sum'", null, null, null, null, "'AND'", null, null, "'has'", "'contains'", 
		null, null, "'='", "'!='", null, null, "'>'", "'<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "DB", 
		"MULTI_VAL_OPS", "OPS", "BETWEEN", "AND", "OR", "NOT", "HAS", "CONTAINS", 
		"IN", "NOT_IN", "EQ", "NEQ", "GTE", "LTE", "GT", "LT", "NUMBER", "QTEXT", 
		"UQTEXT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EZQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EZQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatementContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SelectdbContext selectdb() {
			return getRuleContext(SelectdbContext.class,0);
		}
		public Function_group_byContext function_group_by() {
			return getRuleContext(Function_group_byContext.class,0);
		}
		public LimitclauseContext limitclause() {
			return getRuleContext(LimitclauseContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if (_la==DB) {
				{
				setState(36);
				selectdb();
				setState(37);
				match(T__0);
				}
			}

			setState(41);
			expr();
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					match(T__0);
					setState(43);
					expr();
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(53);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__8) {
				{
				setState(50);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(49);
					match(T__0);
					}
				}

				setState(52);
				function_group_by();
				}
			}

			setState(56);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(55);
				limitclause();
				}
			}

			setState(58);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectdbContext extends ParserRuleContext {
		public TerminalNode DB() { return getToken(EZQLParser.DB, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public SelectdbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectdb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterSelectdb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitSelectdb(this);
		}
	}

	public final SelectdbContext selectdb() throws RecognitionException {
		SelectdbContext _localctx = new SelectdbContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectdb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(DB);
			setState(61);
			match(T__2);
			setState(62);
			field();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitclauseContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(EZQLParser.NUMBER, 0); }
		public LimitclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterLimitclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitLimitclause(this);
		}
	}

	public final LimitclauseContext limitclause() throws RecognitionException {
		LimitclauseContext _localctx = new LimitclauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_limitclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__3);
			setState(65);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(EZQLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(EZQLParser.OR, i);
		}
		public Text_predicateContext text_predicate() {
			return getRuleContext(Text_predicateContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			int _alt;
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				predicate();
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(68);
						match(OR);
						setState(69);
						predicate();
						}
						} 
					}
					setState(74);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				text_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Text_predicateContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public Text_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterText_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitText_predicate(this);
		}
	}

	public final Text_predicateContext text_predicate() throws RecognitionException {
		Text_predicateContext _localctx = new Text_predicateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_text_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << QTEXT) | (1L << UQTEXT))) != 0)) {
				{
				{
				setState(78);
				text();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public SingleValuePredicateContext singleValuePredicate() {
			return getRuleContext(SingleValuePredicateContext.class,0);
		}
		public MultiValuePredicateContext multiValuePredicate() {
			return getRuleContext(MultiValuePredicateContext.class,0);
		}
		public RangePredicateContext rangePredicate() {
			return getRuleContext(RangePredicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		try {
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				singleValuePredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				multiValuePredicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				rangePredicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleValuePredicateContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode OPS() { return getToken(EZQLParser.OPS, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public SingleValuePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleValuePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterSingleValuePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitSingleValuePredicate(this);
		}
	}

	public final SingleValuePredicateContext singleValuePredicate() throws RecognitionException {
		SingleValuePredicateContext _localctx = new SingleValuePredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleValuePredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			field();
			setState(90);
			match(OPS);
			setState(91);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiValuePredicateContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode MULTI_VAL_OPS() { return getToken(EZQLParser.MULTI_VAL_OPS, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public MultiValuePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiValuePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterMultiValuePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitMultiValuePredicate(this);
		}
	}

	public final MultiValuePredicateContext multiValuePredicate() throws RecognitionException {
		MultiValuePredicateContext _localctx = new MultiValuePredicateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiValuePredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			field();
			setState(94);
			match(MULTI_VAL_OPS);
			setState(95);
			values();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangePredicateContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(EZQLParser.BETWEEN, 0); }
		public LowContext low() {
			return getRuleContext(LowContext.class,0);
		}
		public HighContext high() {
			return getRuleContext(HighContext.class,0);
		}
		public RangePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterRangePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitRangePredicate(this);
		}
	}

	public final RangePredicateContext rangePredicate() throws RecognitionException {
		RangePredicateContext _localctx = new RangePredicateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rangePredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			field();
			setState(98);
			match(BETWEEN);
			setState(99);
			match(T__4);
			setState(100);
			low();
			setState(101);
			match(T__5);
			setState(102);
			high();
			setState(103);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public LowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_low; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterLow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitLow(this);
		}
	}

	public final LowContext low() throws RecognitionException {
		LowContext _localctx = new LowContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_low);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HighContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public HighContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_high; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterHigh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitHigh(this);
		}
	}

	public final HighContext high() throws RecognitionException {
		HighContext _localctx = new HighContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_high);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitValues(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_values);
		int _la;
		try {
			setState(121);
			switch (_input.LA(1)) {
			case NUMBER:
			case QTEXT:
			case UQTEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				text();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(T__4);
				setState(111);
				text();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(112);
					match(T__5);
					setState(113);
					text();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode QTEXT() { return getToken(EZQLParser.QTEXT, 0); }
		public TerminalNode UQTEXT() { return getToken(EZQLParser.UQTEXT, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==QTEXT || _la==UQTEXT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_group_byContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public Function_group_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_group_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterFunction_group_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitFunction_group_by(this);
		}
	}

	public final Function_group_byContext function_group_by() throws RecognitionException {
		Function_group_byContext _localctx = new Function_group_byContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_group_by);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			function();
			setState(135);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(126);
				match(T__7);
				setState(127);
				field();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(128);
					match(T__5);
					setState(129);
					field();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(EZQLParser.NUMBER, 0); }
		public TerminalNode QTEXT() { return getToken(EZQLParser.QTEXT, 0); }
		public TerminalNode UQTEXT() { return getToken(EZQLParser.UQTEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << QTEXT) | (1L << UQTEXT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Count_functionContext extends ParserRuleContext {
		public Count_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_count_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterCount_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitCount_function(this);
		}
	}

	public final Count_functionContext count_function() throws RecognitionException {
		Count_functionContext _localctx = new Count_functionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_count_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sum_functionContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Sum_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).enterSum_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EZQLListener ) ((EZQLListener)listener).exitSum_function(this);
		}
	}

	public final Sum_functionContext sum_function() throws RecognitionException {
		Sum_functionContext _localctx = new Sum_functionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sum_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__9);
			setState(144);
			match(T__4);
			setState(145);
			field();
			setState(146);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0097\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\5\2*\n\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2"+
		"\3\2\5\2\65\n\2\3\2\5\28\n\2\3\2\5\2;\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\5\5O\n\5\3\6\7\6R\n\6"+
		"\f\6\16\6U\13\6\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7"+
		"\ru\n\r\f\r\16\rx\13\r\3\r\3\r\5\r|\n\r\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0085\n\17\f\17\16\17\u0088\13\17\5\17\u008a\n\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3J\2\24\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\37 \3\2\36 \u0092\2)\3\2\2\2\4"+
		">\3\2\2\2\6B\3\2\2\2\bN\3\2\2\2\nS\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20_"+
		"\3\2\2\2\22c\3\2\2\2\24k\3\2\2\2\26m\3\2\2\2\30{\3\2\2\2\32}\3\2\2\2\34"+
		"\177\3\2\2\2\36\u008b\3\2\2\2 \u008d\3\2\2\2\"\u008f\3\2\2\2$\u0091\3"+
		"\2\2\2&\'\5\4\3\2\'(\7\3\2\2(*\3\2\2\2)&\3\2\2\2)*\3\2\2\2*+\3\2\2\2+"+
		"\60\5\b\5\2,-\7\3\2\2-/\5\b\5\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61"+
		"\3\2\2\2\61\67\3\2\2\2\62\60\3\2\2\2\63\65\7\3\2\2\64\63\3\2\2\2\64\65"+
		"\3\2\2\2\65\66\3\2\2\2\668\5\34\17\2\67\64\3\2\2\2\678\3\2\2\28:\3\2\2"+
		"\29;\5\6\4\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\4\2\2=\3\3\2\2\2>?\7\r"+
		"\2\2?@\7\5\2\2@A\5\32\16\2A\5\3\2\2\2BC\7\6\2\2CD\7\36\2\2D\7\3\2\2\2"+
		"EJ\5\f\7\2FG\7\22\2\2GI\5\f\7\2HF\3\2\2\2IL\3\2\2\2JK\3\2\2\2JH\3\2\2"+
		"\2KO\3\2\2\2LJ\3\2\2\2MO\5\n\6\2NE\3\2\2\2NM\3\2\2\2O\t\3\2\2\2PR\5\36"+
		"\20\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\13\3\2\2\2US\3\2\2\2VZ"+
		"\5\16\b\2WZ\5\20\t\2XZ\5\22\n\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2"+
		"\2[\\\5\32\16\2\\]\7\17\2\2]^\5\36\20\2^\17\3\2\2\2_`\5\32\16\2`a\7\16"+
		"\2\2ab\5\30\r\2b\21\3\2\2\2cd\5\32\16\2de\7\20\2\2ef\7\7\2\2fg\5\24\13"+
		"\2gh\7\b\2\2hi\5\26\f\2ij\7\t\2\2j\23\3\2\2\2kl\5\36\20\2l\25\3\2\2\2"+
		"mn\5\36\20\2n\27\3\2\2\2o|\5\36\20\2pq\7\7\2\2qv\5\36\20\2rs\7\b\2\2s"+
		"u\5\36\20\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2"+
		"\2yz\7\t\2\2z|\3\2\2\2{o\3\2\2\2{p\3\2\2\2|\31\3\2\2\2}~\t\2\2\2~\33\3"+
		"\2\2\2\177\u0089\5 \21\2\u0080\u0081\7\n\2\2\u0081\u0086\5\32\16\2\u0082"+
		"\u0083\7\b\2\2\u0083\u0085\5\32\16\2\u0084\u0082\3\2\2\2\u0085\u0088\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u0080\3\2\2\2\u0089\u008a\3\2\2\2\u008a\35\3\2\2"+
		"\2\u008b\u008c\t\3\2\2\u008c\37\3\2\2\2\u008d\u008e\7\13\2\2\u008e!\3"+
		"\2\2\2\u008f\u0090\7\13\2\2\u0090#\3\2\2\2\u0091\u0092\7\f\2\2\u0092\u0093"+
		"\7\7\2\2\u0093\u0094\5\32\16\2\u0094\u0095\7\t\2\2\u0095%\3\2\2\2\17)"+
		"\60\64\67:JNSYv{\u0086\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}