// Generated from ./src/main/java/com/ezql/parser/EZQL.g4 by ANTLR 4.5
package com.ezql.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EZQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DB=11, MULTI_VAL_OPS=12, OPS=13, BETWEEN=14, AND=15, OR=16, NOT=17, 
		HAS=18, CONTAINS=19, IN=20, NOT_IN=21, EQ=22, NEQ=23, GTE=24, LTE=25, 
		GT=26, LT=27, NUMBER=28, QTEXT=29, UQTEXT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "DB", "MULTI_VAL_OPS", "OPS", "BETWEEN", "AND", "OR", "NOT", "HAS", 
		"CONTAINS", "IN", "NOT_IN", "EQ", "NEQ", "GTE", "LTE", "GT", "LT", "NUMBER", 
		"QTEXT", "UQTEXT", "DIGIT", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "';'", "'>>'", "'limit'", "'('", "','", "')'", "'by'", "'count'", 
		"'sum'", null, null, null, "'between'", "'AND'", null, null, "'has'", 
		"'contains'", null, null, "'='", "'!='", null, null, "'>'", "'<'"
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


	public EZQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EZQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00ff\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\5\fj\n\f\3\r\3\r\3\r\3\r\5\rp\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16x\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u008a\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0092\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00a5\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00b3\n\26\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u00be\n\31\3\32\3\32\3\32\3\32"+
		"\5\32\u00c4\n\32\3\33\3\33\3\34\3\34\3\35\6\35\u00cb\n\35\r\35\16\35\u00cc"+
		"\3\35\6\35\u00d0\n\35\r\35\16\35\u00d1\3\35\3\35\6\35\u00d6\n\35\r\35"+
		"\16\35\u00d7\3\35\3\35\6\35\u00dc\n\35\r\35\16\35\u00dd\5\35\u00e0\n\35"+
		"\3\36\3\36\3\36\7\36\u00e5\n\36\f\36\16\36\u00e8\13\36\3\36\3\36\3\37"+
		"\6\37\u00ed\n\37\r\37\16\37\u00ee\3 \3 \3!\3!\3!\3!\5!\u00f7\n!\3\"\6"+
		"\"\u00fa\n\"\r\"\16\"\u00fb\3\"\3\"\3\u00e6\2#\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?\2A\2C!\3\2\5\t\2\f"+
		"\f\17\17\"#*+..>@~~\3\2\62;\5\2\13\f\17\17\"\"\u0116\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tL\3\2\2\2\13R\3\2\2\2\rT\3"+
		"\2\2\2\17V\3\2\2\2\21X\3\2\2\2\23[\3\2\2\2\25a\3\2\2\2\27i\3\2\2\2\31"+
		"o\3\2\2\2\33w\3\2\2\2\35y\3\2\2\2\37\u0081\3\2\2\2!\u0089\3\2\2\2#\u0091"+
		"\3\2\2\2%\u0093\3\2\2\2\'\u0097\3\2\2\2)\u00a4\3\2\2\2+\u00b2\3\2\2\2"+
		"-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61\u00bd\3\2\2\2\63\u00c3\3\2\2\2\65\u00c5"+
		"\3\2\2\2\67\u00c7\3\2\2\29\u00df\3\2\2\2;\u00e1\3\2\2\2=\u00ec\3\2\2\2"+
		"?\u00f0\3\2\2\2A\u00f6\3\2\2\2C\u00f9\3\2\2\2EF\7~\2\2F\4\3\2\2\2GH\7"+
		"=\2\2H\6\3\2\2\2IJ\7@\2\2JK\7@\2\2K\b\3\2\2\2LM\7n\2\2MN\7k\2\2NO\7o\2"+
		"\2OP\7k\2\2PQ\7v\2\2Q\n\3\2\2\2RS\7*\2\2S\f\3\2\2\2TU\7.\2\2U\16\3\2\2"+
		"\2VW\7+\2\2W\20\3\2\2\2XY\7d\2\2YZ\7{\2\2Z\22\3\2\2\2[\\\7e\2\2\\]\7q"+
		"\2\2]^\7w\2\2^_\7p\2\2_`\7v\2\2`\24\3\2\2\2ab\7u\2\2bc\7w\2\2cd\7o\2\2"+
		"d\26\3\2\2\2ef\7F\2\2fj\7D\2\2gh\7f\2\2hj\7d\2\2ie\3\2\2\2ig\3\2\2\2j"+
		"\30\3\2\2\2kp\5)\25\2lp\5+\26\2mp\5%\23\2np\5\'\24\2ok\3\2\2\2ol\3\2\2"+
		"\2om\3\2\2\2on\3\2\2\2p\32\3\2\2\2qx\5-\27\2rx\5/\30\2sx\5\61\31\2tx\5"+
		"\63\32\2ux\5\65\33\2vx\5\67\34\2wq\3\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2"+
		"\2wu\3\2\2\2wv\3\2\2\2x\34\3\2\2\2yz\7d\2\2z{\7g\2\2{|\7v\2\2|}\7y\2\2"+
		"}~\7g\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\36\3\2\2\2\u0081\u0082\7"+
		"C\2\2\u0082\u0083\7P\2\2\u0083\u0084\7F\2\2\u0084 \3\2\2\2\u0085\u0086"+
		"\7Q\2\2\u0086\u008a\7T\2\2\u0087\u0088\7q\2\2\u0088\u008a\7t\2\2\u0089"+
		"\u0085\3\2\2\2\u0089\u0087\3\2\2\2\u008a\"\3\2\2\2\u008b\u008c\7P\2\2"+
		"\u008c\u008d\7Q\2\2\u008d\u0092\7V\2\2\u008e\u008f\7p\2\2\u008f\u0090"+
		"\7q\2\2\u0090\u0092\7v\2\2\u0091\u008b\3\2\2\2\u0091\u008e\3\2\2\2\u0092"+
		"$\3\2\2\2\u0093\u0094\7j\2\2\u0094\u0095\7c\2\2\u0095\u0096\7u\2\2\u0096"+
		"&\3\2\2\2\u0097\u0098\7e\2\2\u0098\u0099\7q\2\2\u0099\u009a\7p\2\2\u009a"+
		"\u009b\7v\2\2\u009b\u009c\7c\2\2\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2"+
		"\u009e\u009f\7u\2\2\u009f(\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a5\7p\2"+
		"\2\u00a2\u00a3\7K\2\2\u00a3\u00a5\7P\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7P\2\2\u00a7\u00a8\7Q\2\2\u00a8\u00a9"+
		"\7V\2\2\u00a9\u00aa\7\"\2\2\u00aa\u00ab\7K\2\2\u00ab\u00b3\7P\2\2\u00ac"+
		"\u00ad\7p\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7\"\2"+
		"\2\u00b0\u00b1\7k\2\2\u00b1\u00b3\7p\2\2\u00b2\u00a6\3\2\2\2\u00b2\u00ac"+
		"\3\2\2\2\u00b3,\3\2\2\2\u00b4\u00b5\7?\2\2\u00b5.\3\2\2\2\u00b6\u00b7"+
		"\7#\2\2\u00b7\u00b8\7?\2\2\u00b8\60\3\2\2\2\u00b9\u00ba\7@\2\2\u00ba\u00be"+
		"\7?\2\2\u00bb\u00bc\7?\2\2\u00bc\u00be\7@\2\2\u00bd\u00b9\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\u00c4\7?\2\2"+
		"\u00c1\u00c2\7?\2\2\u00c2\u00c4\7>\2\2\u00c3\u00bf\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\64\3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\66\3\2\2\2\u00c7\u00c8"+
		"\7>\2\2\u00c88\3\2\2\2\u00c9\u00cb\5? \2\u00ca\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00e0\3\2\2\2\u00ce"+
		"\u00d0\5? \2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\7\60\2\2\u00d4"+
		"\u00d6\5? \2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2"+
		"\2\u00d7\u00d8\3\2\2\2\u00d8\u00e0\3\2\2\2\u00d9\u00db\7\60\2\2\u00da"+
		"\u00dc\5? \2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00ca\3\2\2\2\u00df\u00cf"+
		"\3\2\2\2\u00df\u00d9\3\2\2\2\u00e0:\3\2\2\2\u00e1\u00e6\7$\2\2\u00e2\u00e5"+
		"\5A!\2\u00e3\u00e5\13\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7$\2\2\u00ea<\3\2\2\2\u00eb\u00ed"+
		"\n\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef>\3\2\2\2\u00f0\u00f1\t\3\2\2\u00f1@\3\2\2\2\u00f2"+
		"\u00f3\7^\2\2\u00f3\u00f7\7$\2\2\u00f4\u00f5\7^\2\2\u00f5\u00f7\7^\2\2"+
		"\u00f6\u00f2\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7B\3\2\2\2\u00f8\u00fa\t"+
		"\4\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b\"\2\2\u00feD\3\2\2\2"+
		"\26\2iow\u0089\u0091\u00a4\u00b2\u00bd\u00c3\u00cc\u00d1\u00d7\u00dd\u00df"+
		"\u00e4\u00e6\u00ee\u00f6\u00fb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}