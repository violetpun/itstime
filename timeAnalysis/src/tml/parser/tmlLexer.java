// Generated from tml.g4 by ANTLR 4.4
package tml.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tmlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, RSBRACK=3, LSBRACK=4, RCBRACK=5, LCBRACK=6, PLUS=7, 
		MINUS=8, MULT=9, DIV=10, AND=11, OR=12, GT=13, LT=14, GEG=15, LEG=16, 
		EQUALS=17, DISTINCT=18, BANG=19, ASSIGN=20, COMMA=21, SEMI=22, NEW=23, 
		CLASS=24, LOCAL=25, DOT=26, WITH=27, SYNC=28, INT=29, FUT=30, THIS=31, 
		CAPACITY=32, IF=33, ELSE=34, JOB=35, RETURN=36, ID=37, NUMBER=38, WS=39, 
		LINECOMENTS=40, BLOCKCOMENTS=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'"
	};
	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "RSBRACK", "LSBRACK", "RCBRACK", "LCBRACK", "PLUS", 
		"MINUS", "MULT", "DIV", "AND", "OR", "GT", "LT", "GEG", "LEG", "EQUALS", 
		"DISTINCT", "BANG", "ASSIGN", "COMMA", "SEMI", "NEW", "CLASS", "LOCAL", 
		"DOT", "WITH", "SYNC", "INT", "FUT", "THIS", "CAPACITY", "IF", "ELSE", 
		"JOB", "RETURN", "CHAR", "ID", "DIGIT", "NUMBER", "WS", "LINECOMENTS", 
		"BLOCKCOMENTS"
	};


	public tmlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "tml.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u0102\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\7\'\u00d5\n\'\f\'\16\'\u00d8\13"+
		"\'\3(\3(\3)\6)\u00dd\n)\r)\16)\u00de\3*\3*\3*\3*\3+\3+\3+\3+\7+\u00e9"+
		"\n+\f+\16+\u00ec\13+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u00f9\n,\f,\16"+
		",\u00fc\13,\3,\3,\3,\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\'O\2Q(S)U*W+\3\2\b"+
		"\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2,,\61\61\3\2,,\3\2\61\61"+
		"\u0107\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2M\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2"+
		"\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31p\3"+
		"\2\2\2\33s\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!z\3\2\2\2#}\3\2\2\2%\u0080"+
		"\3\2\2\2\'\u0083\3\2\2\2)\u0085\3\2\2\2+\u0087\3\2\2\2-\u0089\3\2\2\2"+
		"/\u008b\3\2\2\2\61\u008f\3\2\2\2\63\u0095\3\2\2\2\65\u009b\3\2\2\2\67"+
		"\u009d\3\2\2\29\u00a2\3\2\2\2;\u00a6\3\2\2\2=\u00aa\3\2\2\2?\u00ae\3\2"+
		"\2\2A\u00b3\3\2\2\2C\u00bc\3\2\2\2E\u00bf\3\2\2\2G\u00c4\3\2\2\2I\u00c8"+
		"\3\2\2\2K\u00cf\3\2\2\2M\u00d1\3\2\2\2O\u00d9\3\2\2\2Q\u00dc\3\2\2\2S"+
		"\u00e0\3\2\2\2U\u00e4\3\2\2\2W\u00ef\3\2\2\2YZ\7*\2\2Z\4\3\2\2\2[\\\7"+
		"+\2\2\\\6\3\2\2\2]^\7_\2\2^\b\3\2\2\2_`\7]\2\2`\n\3\2\2\2ab\7\177\2\2"+
		"b\f\3\2\2\2cd\7}\2\2d\16\3\2\2\2ef\7-\2\2f\20\3\2\2\2gh\7/\2\2h\22\3\2"+
		"\2\2ij\7,\2\2j\24\3\2\2\2kl\7\61\2\2l\26\3\2\2\2mn\7(\2\2no\7(\2\2o\30"+
		"\3\2\2\2pq\7~\2\2qr\7~\2\2r\32\3\2\2\2st\7@\2\2t\34\3\2\2\2uv\7>\2\2v"+
		"\36\3\2\2\2wx\7@\2\2xy\7?\2\2y \3\2\2\2z{\7>\2\2{|\7?\2\2|\"\3\2\2\2}"+
		"~\7?\2\2~\177\7?\2\2\177$\3\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2"+
		"\2\u0082&\3\2\2\2\u0083\u0084\7#\2\2\u0084(\3\2\2\2\u0085\u0086\7?\2\2"+
		"\u0086*\3\2\2\2\u0087\u0088\7.\2\2\u0088,\3\2\2\2\u0089\u008a\7=\2\2\u008a"+
		".\3\2\2\2\u008b\u008c\7p\2\2\u008c\u008d\7g\2\2\u008d\u008e\7y\2\2\u008e"+
		"\60\3\2\2\2\u008f\u0090\7E\2\2\u0090\u0091\7n\2\2\u0091\u0092\7c\2\2\u0092"+
		"\u0093\7u\2\2\u0093\u0094\7u\2\2\u0094\62\3\2\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7q\2\2\u0097\u0098\7e\2\2\u0098\u0099\7c\2\2\u0099\u009a\7n\2\2"+
		"\u009a\64\3\2\2\2\u009b\u009c\7\60\2\2\u009c\66\3\2\2\2\u009d\u009e\7"+
		"y\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7j\2\2\u00a18"+
		"\3\2\2\2\u00a2\u00a3\7i\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5"+
		":\3\2\2\2\u00a6\u00a7\7K\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7v\2\2\u00a9"+
		"<\3\2\2\2\u00aa\u00ab\7H\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7v\2\2\u00ad"+
		">\3\2\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7j\2\2\u00b0\u00b1\7k\2\2\u00b1"+
		"\u00b2\7u\2\2\u00b2@\3\2\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7c\2\2\u00b5"+
		"\u00b6\7r\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7k\2\2"+
		"\u00b9\u00ba\7v\2\2\u00ba\u00bb\7{\2\2\u00bbB\3\2\2\2\u00bc\u00bd\7k\2"+
		"\2\u00bd\u00be\7h\2\2\u00beD\3\2\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7"+
		"n\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7g\2\2\u00c3F\3\2\2\2\u00c4\u00c5"+
		"\7l\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7d\2\2\u00c7H\3\2\2\2\u00c8\u00c9"+
		"\7t\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7w\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7p\2\2\u00ceJ\3\2\2\2\u00cf\u00d0\t\2\2\2\u00d0"+
		"L\3\2\2\2\u00d1\u00d6\5K&\2\u00d2\u00d5\5K&\2\u00d3\u00d5\5O(\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7N\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da"+
		"\4\62;\2\u00daP\3\2\2\2\u00db\u00dd\5O(\2\u00dc\u00db\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00dfR\3\2\2\2\u00e0"+
		"\u00e1\t\3\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b*\2\2\u00e3T\3\2\2\2\u00e4"+
		"\u00e5\7\61\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00ea\3\2\2\2\u00e7\u00e9\n"+
		"\4\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\b+"+
		"\2\2\u00eeV\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\7,\2\2\u00f1\u00fa"+
		"\3\2\2\2\u00f2\u00f9\n\5\2\2\u00f3\u00f4\7\61\2\2\u00f4\u00f9\n\6\2\2"+
		"\u00f5\u00f6\7,\2\2\u00f6\u00f9\n\7\2\2\u00f7\u00f9\5W,\2\u00f8\u00f2"+
		"\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2"+
		"\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7,\2\2\u00fe\u00ff\7\61\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\b,\2\2\u0101X\3\2\2\2\t\2\u00d4\u00d6\u00de"+
		"\u00ea\u00f8\u00fa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}