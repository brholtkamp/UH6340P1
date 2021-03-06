// Generated from SQL.g by ANTLR 4.5

package com.UH6340.SQL;

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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NAME=10, CONSTANT=11, EVERYTHING=12, INTEGER=13, TYPE=14, WHITESPACE=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"NAME", "CONSTANT", "EVERYTHING", "INTEGER", "TYPE", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'CREATE'", "'('", "')'", "','", "'INSERT INTO'", "'SELECT'", "'FROM'", 
		"'WHERE'", "'='", null, null, "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "NAME", "CONSTANT", 
		"EVERYTHING", "INTEGER", "TYPE", "WHITESPACE"
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


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQL.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\7\13Q\n\13\f\13\16\13T\13\13\3\f\3\f\6"+
		"\fX\n\f\r\f\16\fY\3\f\3\f\3\r\3\r\3\16\6\16a\n\16\r\16\16\16b\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17n\n\17\3\20\6\20q\n\20\r\20\16"+
		"\20r\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21\3\2\5\4\2\62;c|\6\2\"\"\62;C\\c|\5\2\13\f\16"+
		"\17\"\"z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2"+
		"\2\5(\3\2\2\2\7*\3\2\2\2\t,\3\2\2\2\13.\3\2\2\2\r:\3\2\2\2\17A\3\2\2\2"+
		"\21F\3\2\2\2\23L\3\2\2\2\25N\3\2\2\2\27U\3\2\2\2\31]\3\2\2\2\33`\3\2\2"+
		"\2\35m\3\2\2\2\37p\3\2\2\2!\"\7E\2\2\"#\7T\2\2#$\7G\2\2$%\7C\2\2%&\7V"+
		"\2\2&\'\7G\2\2\'\4\3\2\2\2()\7*\2\2)\6\3\2\2\2*+\7+\2\2+\b\3\2\2\2,-\7"+
		".\2\2-\n\3\2\2\2./\7K\2\2/\60\7P\2\2\60\61\7U\2\2\61\62\7G\2\2\62\63\7"+
		"T\2\2\63\64\7V\2\2\64\65\7\"\2\2\65\66\7K\2\2\66\67\7P\2\2\678\7V\2\2"+
		"89\7Q\2\29\f\3\2\2\2:;\7U\2\2;<\7G\2\2<=\7N\2\2=>\7G\2\2>?\7E\2\2?@\7"+
		"V\2\2@\16\3\2\2\2AB\7H\2\2BC\7T\2\2CD\7Q\2\2DE\7O\2\2E\20\3\2\2\2FG\7"+
		"Y\2\2GH\7J\2\2HI\7G\2\2IJ\7T\2\2JK\7G\2\2K\22\3\2\2\2LM\7?\2\2M\24\3\2"+
		"\2\2NR\4c|\2OQ\t\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\26\3\2"+
		"\2\2TR\3\2\2\2UW\7)\2\2VX\t\3\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z[\3\2\2\2[\\\7)\2\2\\\30\3\2\2\2]^\7,\2\2^\32\3\2\2\2_a\4\62;\2`"+
		"_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\34\3\2\2\2de\7K\2\2ef\7P\2\2"+
		"fn\7V\2\2gh\7U\2\2hi\7V\2\2ij\7T\2\2jk\7K\2\2kl\7P\2\2ln\7I\2\2md\3\2"+
		"\2\2mg\3\2\2\2n\36\3\2\2\2oq\t\4\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2st\3\2\2\2tu\b\20\2\2u \3\2\2\2\t\2RWYbmr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}