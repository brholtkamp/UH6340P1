// Generated from SQL.g by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CREATE=1, INSERT=2, SELECT=3, FROM=4, WHERE=5, NAME=6, TYPE=7, COMMA=8, 
		NEWLINE=9, WHITESPACE=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'CREATE'", "'INSERT INTO'", "'SELECT'", "'FROM'", "'WHERE'", 
		"NAME", "TYPE", "','", "'\n'", "WHITESPACE"
	};
	public static final int
		RULE_tableCreation = 0, RULE_tableInsertion = 1, RULE_tableSelection = 2, 
		RULE_selection = 3, RULE_fieldOperation = 4, RULE_tables = 5, RULE_table = 6, 
		RULE_values = 7, RULE_value = 8;
	public static final String[] ruleNames = {
		"tableCreation", "tableInsertion", "tableSelection", "selection", "fieldOperation", 
		"tables", "table", "values", "value"
	};

	@Override
	public String getGrammarFileName() { return "SQL.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TableCreationContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(SQLParser.NEWLINE, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TableCreationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableCreation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTableCreation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTableCreation(this);
		}
	}

	public final TableCreationContext tableCreation() throws RecognitionException {
		TableCreationContext _localctx = new TableCreationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tableCreation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); match(CREATE);
			setState(19); table();
			setState(20); values();
			setState(21); match(NEWLINE);
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

	public static class TableInsertionContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(SQLParser.NEWLINE, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TableInsertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableInsertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTableInsertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTableInsertion(this);
		}
	}

	public final TableInsertionContext tableInsertion() throws RecognitionException {
		TableInsertionContext _localctx = new TableInsertionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tableInsertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(INSERT);
			setState(24); table();
			setState(25); values();
			setState(26); match(NEWLINE);
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

	public static class TableSelectionContext extends ParserRuleContext {
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TablesContext tables() {
			return getRuleContext(TablesContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public FieldOperationContext fieldOperation() {
			return getRuleContext(FieldOperationContext.class,0);
		}
		public TableSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTableSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTableSelection(this);
		}
	}

	public final TableSelectionContext tableSelection() throws RecognitionException {
		TableSelectionContext _localctx = new TableSelectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableSelection);
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); match(SELECT);
				setState(29); selection();
				setState(30); match(FROM);
				setState(31); tables();
				setState(32); match(WHERE);
				setState(33); fieldOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); match(SELECT);
				setState(36); selection();
				setState(37); match(FROM);
				setState(38); tables();
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

	public static class SelectionContext extends ParserRuleContext {
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitSelection(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class FieldOperationContext extends ParserRuleContext {
		public FieldOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterFieldOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitFieldOperation(this);
		}
	}

	public final FieldOperationContext fieldOperation() throws RecognitionException {
		FieldOperationContext _localctx = new FieldOperationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class TablesContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TablesContext tables() {
			return getRuleContext(TablesContext.class,0);
		}
		public TablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTables(this);
		}
	}

	public final TablesContext tables() throws RecognitionException {
		TablesContext _localctx = new TablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tables);
		try {
			setState(50);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); table();
				setState(47); tables();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); table();
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

	public static class TableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTable(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(NAME);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitValues(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_values);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); value();
				setState(55); values();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(NAME);
				setState(61); match(TYPE);
				setState(62); match(COMMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); match(NAME);
				setState(64); match(TYPE);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fF\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4+\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7\65\n\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\5\t=\n\t\3\n\3\n\3\n\3\n\3\n\5\nD\n\n\3\n\2\2\13\2\4\6\b"+
		"\n\f\16\20\22\2\2@\2\24\3\2\2\2\4\31\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n."+
		"\3\2\2\2\f\64\3\2\2\2\16\66\3\2\2\2\20<\3\2\2\2\22C\3\2\2\2\24\25\7\3"+
		"\2\2\25\26\5\16\b\2\26\27\5\20\t\2\27\30\7\13\2\2\30\3\3\2\2\2\31\32\7"+
		"\4\2\2\32\33\5\16\b\2\33\34\5\20\t\2\34\35\7\13\2\2\35\5\3\2\2\2\36\37"+
		"\7\5\2\2\37 \5\b\5\2 !\7\6\2\2!\"\5\f\7\2\"#\7\7\2\2#$\5\n\6\2$+\3\2\2"+
		"\2%&\7\5\2\2&\'\5\b\5\2\'(\7\6\2\2()\5\f\7\2)+\3\2\2\2*\36\3\2\2\2*%\3"+
		"\2\2\2+\7\3\2\2\2,-\3\2\2\2-\t\3\2\2\2./\3\2\2\2/\13\3\2\2\2\60\61\5\16"+
		"\b\2\61\62\5\f\7\2\62\65\3\2\2\2\63\65\5\16\b\2\64\60\3\2\2\2\64\63\3"+
		"\2\2\2\65\r\3\2\2\2\66\67\7\b\2\2\67\17\3\2\2\289\5\22\n\29:\5\20\t\2"+
		":=\3\2\2\2;=\5\22\n\2<8\3\2\2\2<;\3\2\2\2=\21\3\2\2\2>?\7\b\2\2?@\7\t"+
		"\2\2@D\7\n\2\2AB\7\b\2\2BD\7\t\2\2C>\3\2\2\2CA\3\2\2\2D\23\3\2\2\2\6*"+
		"\64<C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}