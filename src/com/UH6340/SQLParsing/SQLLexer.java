// Generated from SQL.g by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CREATE=1, INSERT=2, SELECT=3, FROM=4, WHERE=5, NAME=6, TYPE=7, COMMA=8, 
		NEWLINE=9, WHITESPACE=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'"
	};
	public static final String[] ruleNames = {
		"CREATE", "INSERT", "SELECT", "FROM", "WHERE", "NAME", "TYPE", "COMMA", 
		"NEWLINE", "WHITESPACE"
	};


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQL.g"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fW\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\6\7>\n\7\r\7\16\7?\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bK\n\b\3\t\3\t\3\n\3\n\3\13\6\13R\n\13\r\13\16\13S\3\13\3\13\2\2"+
		"\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\3\5\2\13\13\16\17"+
		"\"\"Y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2"+
		"\2\2\5\36\3\2\2\2\7*\3\2\2\2\t\61\3\2\2\2\13\66\3\2\2\2\r=\3\2\2\2\17"+
		"J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25Q\3\2\2\2\27\30\7E\2\2\30\31\7T\2"+
		"\2\31\32\7G\2\2\32\33\7C\2\2\33\34\7V\2\2\34\35\7G\2\2\35\4\3\2\2\2\36"+
		"\37\7K\2\2\37 \7P\2\2 !\7U\2\2!\"\7G\2\2\"#\7T\2\2#$\7V\2\2$%\7\"\2\2"+
		"%&\7K\2\2&\'\7P\2\2\'(\7V\2\2()\7Q\2\2)\6\3\2\2\2*+\7U\2\2+,\7G\2\2,-"+
		"\7N\2\2-.\7G\2\2./\7E\2\2/\60\7V\2\2\60\b\3\2\2\2\61\62\7H\2\2\62\63\7"+
		"T\2\2\63\64\7Q\2\2\64\65\7O\2\2\65\n\3\2\2\2\66\67\7Y\2\2\678\7J\2\28"+
		"9\7G\2\29:\7T\2\2:;\7G\2\2;\f\3\2\2\2<>\4c|\2=<\3\2\2\2>?\3\2\2\2?=\3"+
		"\2\2\2?@\3\2\2\2@\16\3\2\2\2AB\7K\2\2BC\7P\2\2CK\7V\2\2DE\7U\2\2EF\7V"+
		"\2\2FG\7T\2\2GH\7K\2\2HI\7P\2\2IK\7I\2\2JA\3\2\2\2JD\3\2\2\2K\20\3\2\2"+
		"\2LM\7.\2\2M\22\3\2\2\2NO\7\f\2\2O\24\3\2\2\2PR\t\2\2\2QP\3\2\2\2RS\3"+
		"\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\b\13\2\2V\26\3\2\2\2\6\2?JS\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}