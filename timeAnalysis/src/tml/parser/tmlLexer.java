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
		VM=24, DOT=25, RELEASE=26, SYNC=27, INT=28, FUT=29, THIS=30, IF=31, ELSE=32, 
		RETURN=33, ID=34, NUMBER=35, WS=36, LINECOMENTS=37, BLOCKCOMENTS=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'"
	};
	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "RSBRACK", "LSBRACK", "RCBRACK", "LCBRACK", "PLUS", 
		"MINUS", "MULT", "DIV", "AND", "OR", "GT", "LT", "GEG", "LEG", "EQUALS", 
		"DISTINCT", "BANG", "ASSIGN", "COMMA", "SEMI", "NEW", "VM", "DOT", "RELEASE", 
		"SYNC", "INT", "FUT", "THIS", "IF", "ELSE", "RETURN", "CHAR", "ID", "DIGIT", 
		"NUMBER", "WS", "LINECOMENTS", "BLOCKCOMENTS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u00e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\7$\u00bc\n$\f$\16$\u00bf\13$\3%\3%\3&"+
		"\6&\u00c4\n&\r&\16&\u00c5\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00d0\n(\f(\16"+
		"(\u00d3\13(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u00e0\n)\f)\16)\u00e3"+
		"\13)\3)\3)\3)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E\2G$I\2K%M&O\'Q(\3\2\b\4\2C\\c|\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\4\2,,\61\61\3\2,,\3\2\61\61\u00ee\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2G\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13"+
		"[\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27"+
		"g\3\2\2\2\31j\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!t\3\2\2\2#w"+
		"\3\2\2\2%z\3\2\2\2\'}\3\2\2\2)\177\3\2\2\2+\u0081\3\2\2\2-\u0083\3\2\2"+
		"\2/\u0085\3\2\2\2\61\u0089\3\2\2\2\63\u008c\3\2\2\2\65\u008e\3\2\2\2\67"+
		"\u0096\3\2\2\29\u009a\3\2\2\2;\u009e\3\2\2\2=\u00a2\3\2\2\2?\u00a7\3\2"+
		"\2\2A\u00aa\3\2\2\2C\u00af\3\2\2\2E\u00b6\3\2\2\2G\u00b8\3\2\2\2I\u00c0"+
		"\3\2\2\2K\u00c3\3\2\2\2M\u00c7\3\2\2\2O\u00cb\3\2\2\2Q\u00d6\3\2\2\2S"+
		"T\7*\2\2T\4\3\2\2\2UV\7+\2\2V\6\3\2\2\2WX\7_\2\2X\b\3\2\2\2YZ\7]\2\2Z"+
		"\n\3\2\2\2[\\\7\177\2\2\\\f\3\2\2\2]^\7}\2\2^\16\3\2\2\2_`\7-\2\2`\20"+
		"\3\2\2\2ab\7/\2\2b\22\3\2\2\2cd\7,\2\2d\24\3\2\2\2ef\7\61\2\2f\26\3\2"+
		"\2\2gh\7(\2\2hi\7(\2\2i\30\3\2\2\2jk\7~\2\2kl\7~\2\2l\32\3\2\2\2mn\7@"+
		"\2\2n\34\3\2\2\2op\7>\2\2p\36\3\2\2\2qr\7@\2\2rs\7?\2\2s \3\2\2\2tu\7"+
		">\2\2uv\7?\2\2v\"\3\2\2\2wx\7?\2\2xy\7?\2\2y$\3\2\2\2z{\7#\2\2{|\7?\2"+
		"\2|&\3\2\2\2}~\7#\2\2~(\3\2\2\2\177\u0080\7?\2\2\u0080*\3\2\2\2\u0081"+
		"\u0082\7.\2\2\u0082,\3\2\2\2\u0083\u0084\7=\2\2\u0084.\3\2\2\2\u0085\u0086"+
		"\7p\2\2\u0086\u0087\7g\2\2\u0087\u0088\7y\2\2\u0088\60\3\2\2\2\u0089\u008a"+
		"\7X\2\2\u008a\u008b\7O\2\2\u008b\62\3\2\2\2\u008c\u008d\7\60\2\2\u008d"+
		"\64\3\2\2\2\u008e\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7n\2\2\u0091"+
		"\u0092\7g\2\2\u0092\u0093\7c\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2"+
		"\u0095\66\3\2\2\2\u0096\u0097\7i\2\2\u0097\u0098\7g\2\2\u0098\u0099\7"+
		"v\2\2\u00998\3\2\2\2\u009a\u009b\7K\2\2\u009b\u009c\7p\2\2\u009c\u009d"+
		"\7v\2\2\u009d:\3\2\2\2\u009e\u009f\7H\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1"+
		"\7v\2\2\u00a1<\3\2\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5"+
		"\7k\2\2\u00a5\u00a6\7u\2\2\u00a6>\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9"+
		"\7h\2\2\u00a9@\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad"+
		"\7u\2\2\u00ad\u00ae\7g\2\2\u00aeB\3\2\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7t\2\2\u00b4"+
		"\u00b5\7p\2\2\u00b5D\3\2\2\2\u00b6\u00b7\t\2\2\2\u00b7F\3\2\2\2\u00b8"+
		"\u00bd\5E#\2\u00b9\u00bc\5E#\2\u00ba\u00bc\5I%\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00beH\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\4\62;\2\u00c1J\3\2"+
		"\2\2\u00c2\u00c4\5I%\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6L\3\2\2\2\u00c7\u00c8\t\3\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\b\'\2\2\u00caN\3\2\2\2\u00cb\u00cc\7\61\2\2"+
		"\u00cc\u00cd\7\61\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d0\n\4\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\b(\2\2\u00d5P\3\2\2\2\u00d6"+
		"\u00d7\7\61\2\2\u00d7\u00d8\7,\2\2\u00d8\u00e1\3\2\2\2\u00d9\u00e0\n\5"+
		"\2\2\u00da\u00db\7\61\2\2\u00db\u00e0\n\6\2\2\u00dc\u00dd\7,\2\2\u00dd"+
		"\u00e0\n\7\2\2\u00de\u00e0\5Q)\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2"+
		"\2\u00df\u00dc\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\7,\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b)"+
		"\2\2\u00e8R\3\2\2\2\t\2\u00bb\u00bd\u00c5\u00d1\u00df\u00e1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}