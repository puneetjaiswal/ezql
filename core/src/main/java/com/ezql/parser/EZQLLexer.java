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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u0102\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\5\fj\n\f\3\r\3\r\3\r\3\r\5\rp\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16x\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0083\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u008d\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0095\n\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25"+
		"\u00a8\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u00b6\n\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u00c1"+
		"\n\31\3\32\3\32\3\32\3\32\5\32\u00c7\n\32\3\33\3\33\3\34\3\34\3\35\6\35"+
		"\u00ce\n\35\r\35\16\35\u00cf\3\35\6\35\u00d3\n\35\r\35\16\35\u00d4\3\35"+
		"\3\35\6\35\u00d9\n\35\r\35\16\35\u00da\3\35\3\35\6\35\u00df\n\35\r\35"+
		"\16\35\u00e0\5\35\u00e3\n\35\3\36\3\36\3\36\7\36\u00e8\n\36\f\36\16\36"+
		"\u00eb\13\36\3\36\3\36\3\37\6\37\u00f0\n\37\r\37\16\37\u00f1\3 \3 \3!"+
		"\3!\3!\3!\5!\u00fa\n!\3\"\6\"\u00fd\n\"\r\"\16\"\u00fe\3\"\3\"\3\u00e9"+
		"\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?\2A\2C!\3\2\5\t\2\f\f\17\17\"#*+..>@~~\3\2\62;\5\2\13\f\17\17\""+
		"\"\u011a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2"+
		"\tL\3\2\2\2\13R\3\2\2\2\rT\3\2\2\2\17V\3\2\2\2\21X\3\2\2\2\23[\3\2\2\2"+
		"\25a\3\2\2\2\27i\3\2\2\2\31o\3\2\2\2\33w\3\2\2\2\35\u0082\3\2\2\2\37\u0084"+
		"\3\2\2\2!\u008c\3\2\2\2#\u0094\3\2\2\2%\u0096\3\2\2\2\'\u009a\3\2\2\2"+
		")\u00a7\3\2\2\2+\u00b5\3\2\2\2-\u00b7\3\2\2\2/\u00b9\3\2\2\2\61\u00c0"+
		"\3\2\2\2\63\u00c6\3\2\2\2\65\u00c8\3\2\2\2\67\u00ca\3\2\2\29\u00e2\3\2"+
		"\2\2;\u00e4\3\2\2\2=\u00ef\3\2\2\2?\u00f3\3\2\2\2A\u00f9\3\2\2\2C\u00fc"+
		"\3\2\2\2EF\7~\2\2F\4\3\2\2\2GH\7=\2\2H\6\3\2\2\2IJ\7@\2\2JK\7@\2\2K\b"+
		"\3\2\2\2LM\7n\2\2MN\7k\2\2NO\7o\2\2OP\7k\2\2PQ\7v\2\2Q\n\3\2\2\2RS\7*"+
		"\2\2S\f\3\2\2\2TU\7.\2\2U\16\3\2\2\2VW\7+\2\2W\20\3\2\2\2XY\7d\2\2YZ\7"+
		"{\2\2Z\22\3\2\2\2[\\\7e\2\2\\]\7q\2\2]^\7w\2\2^_\7p\2\2_`\7v\2\2`\24\3"+
		"\2\2\2ab\7u\2\2bc\7w\2\2cd\7o\2\2d\26\3\2\2\2ef\7F\2\2fj\7D\2\2gh\7f\2"+
		"\2hj\7d\2\2ie\3\2\2\2ig\3\2\2\2j\30\3\2\2\2kp\5)\25\2lp\5+\26\2mp\5%\23"+
		"\2np\5\'\24\2ok\3\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\32\3\2\2\2qx\5"+
		"-\27\2rx\5/\30\2sx\5\61\31\2tx\5\63\32\2ux\5\65\33\2vx\5\67\34\2wq\3\2"+
		"\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\34\3\2\2\2yz\7"+
		"d\2\2z{\7g\2\2{|\7v\2\2|}\7y\2\2}~\7g\2\2~\177\7g\2\2\177\u0083\7p\2\2"+
		"\u0080\u0081\7>\2\2\u0081\u0083\7@\2\2\u0082y\3\2\2\2\u0082\u0080\3\2"+
		"\2\2\u0083\36\3\2\2\2\u0084\u0085\7C\2\2\u0085\u0086\7P\2\2\u0086\u0087"+
		"\7F\2\2\u0087 \3\2\2\2\u0088\u0089\7Q\2\2\u0089\u008d\7T\2\2\u008a\u008b"+
		"\7q\2\2\u008b\u008d\7t\2\2\u008c\u0088\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\"\3\2\2\2\u008e\u008f\7P\2\2\u008f\u0090\7Q\2\2\u0090\u0095\7V\2\2\u0091"+
		"\u0092\7p\2\2\u0092\u0093\7q\2\2\u0093\u0095\7v\2\2\u0094\u008e\3\2\2"+
		"\2\u0094\u0091\3\2\2\2\u0095$\3\2\2\2\u0096\u0097\7j\2\2\u0097\u0098\7"+
		"c\2\2\u0098\u0099\7u\2\2\u0099&\3\2\2\2\u009a\u009b\7e\2\2\u009b\u009c"+
		"\7q\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2\u009e\u009f\7c\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7u\2\2\u00a2(\3\2\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a8\7p\2\2\u00a5\u00a6\7K\2\2\u00a6\u00a8\7P\2\2"+
		"\u00a7\u00a3\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7"+
		"P\2\2\u00aa\u00ab\7Q\2\2\u00ab\u00ac\7V\2\2\u00ac\u00ad\7\"\2\2\u00ad"+
		"\u00ae\7K\2\2\u00ae\u00b6\7P\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7q\2\2"+
		"\u00b1\u00b2\7v\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b6"+
		"\7p\2\2\u00b5\u00a9\3\2\2\2\u00b5\u00af\3\2\2\2\u00b6,\3\2\2\2\u00b7\u00b8"+
		"\7?\2\2\u00b8.\3\2\2\2\u00b9\u00ba\7#\2\2\u00ba\u00bb\7?\2\2\u00bb\60"+
		"\3\2\2\2\u00bc\u00bd\7@\2\2\u00bd\u00c1\7?\2\2\u00be\u00bf\7?\2\2\u00bf"+
		"\u00c1\7@\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\62\3\2\2\2"+
		"\u00c2\u00c3\7>\2\2\u00c3\u00c7\7?\2\2\u00c4\u00c5\7?\2\2\u00c5\u00c7"+
		"\7>\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\64\3\2\2\2\u00c8"+
		"\u00c9\7@\2\2\u00c9\66\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb8\3\2\2\2\u00cc"+
		"\u00ce\5? \2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2"+
		"\2\u00cf\u00d0\3\2\2\2\u00d0\u00e3\3\2\2\2\u00d1\u00d3\5? \2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d8\7\60\2\2\u00d7\u00d9\5? \2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00e3\3\2\2\2\u00dc\u00de\7\60\2\2\u00dd\u00df\5? \2\u00de\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00cd\3\2\2\2\u00e2\u00d2\3\2\2\2\u00e2\u00dc\3\2"+
		"\2\2\u00e3:\3\2\2\2\u00e4\u00e9\7$\2\2\u00e5\u00e8\5A!\2\u00e6\u00e8\13"+
		"\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ed\7$\2\2\u00ed<\3\2\2\2\u00ee\u00f0\n\2\2\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		">\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4@\3\2\2\2\u00f5\u00f6\7^\2\2\u00f6"+
		"\u00fa\7$\2\2\u00f7\u00f8\7^\2\2\u00f8\u00fa\7^\2\2\u00f9\u00f5\3\2\2"+
		"\2\u00f9\u00f7\3\2\2\2\u00faB\3\2\2\2\u00fb\u00fd\t\4\2\2\u00fc\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\b\"\2\2\u0101D\3\2\2\2\27\2iow\u0082\u008c"+
		"\u0094\u00a7\u00b5\u00c0\u00c6\u00cf\u00d4\u00da\u00e0\u00e2\u00e7\u00e9"+
		"\u00f1\u00f9\u00fe\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}