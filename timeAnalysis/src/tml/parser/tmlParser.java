// Generated from tml.g4 by ANTLR 4.4
package tml.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tmlParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "']'", "'['", "'}'", "'{'", "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'!'", 
		"'='", "','", "';'", "'new'", "'VM'", "'.'", "'release'", "'get'", "'Int'", 
		"'Fut'", "'this'", "'if'", "'else'", "'return'", "ID", "NUMBER", "WS", 
		"LINECOMENTS", "BLOCKCOMENTS"
	};
	public static final int
		RULE_program = 0, RULE_method = 1, RULE_parameter = 2, RULE_type = 3, 
		RULE_extendedType = 4, RULE_statementList = 5, RULE_statement = 6, RULE_assignment = 7, 
		RULE_varDecl = 8, RULE_returnStmt = 9, RULE_release = 10, RULE_sideEffectExp = 11, 
		RULE_asyncInvoc = 12, RULE_sync = 13, RULE_acquire = 14, RULE_ifStmt = 15, 
		RULE_exp = 16;
	public static final String[] ruleNames = {
		"program", "method", "parameter", "type", "extendedType", "statementList", 
		"statement", "assignment", "varDecl", "returnStmt", "release", "sideEffectExp", 
		"asyncInvoc", "sync", "acquire", "ifStmt", "exp"
	};

	@Override
	public String getGrammarFileName() { return "tml.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode LCBRACK() { return getToken(tmlParser.LCBRACK, 0); }
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode RCBRACK() { return getToken(tmlParser.RCBRACK, 0); }
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VM || _la==INT) {
				{
				{
				setState(34); method();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40); match(LCBRACK);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VM) | (1L << RELEASE) | (1L << INT) | (1L << FUT) | (1L << IF) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(41); statement();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47); match(RCBRACK);
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TerminalNode LCBRACK() { return getToken(tmlParser.LCBRACK, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(tmlParser.COMMA); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public TerminalNode RCBRACK() { return getToken(tmlParser.RCBRACK, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(tmlParser.COMMA, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); type();
			setState(50); match(ID);
			setState(51); match(LPAREN);
			setState(60);
			_la = _input.LA(1);
			if (_la==VM || _la==INT) {
				{
				setState(52); parameter();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(53); match(COMMA);
					setState(54); parameter();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(62); match(RPAREN);
			setState(63); match(LCBRACK);
			setState(64); statementList();
			setState(65); match(RCBRACK);
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); type();
			setState(68); match(ID);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode VM() { return getToken(tmlParser.VM, 0); }
		public TerminalNode INT() { return getToken(tmlParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==VM || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ExtendedTypeContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(tmlParser.LT, 0); }
		public TerminalNode GT() { return getToken(tmlParser.GT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode FUT() { return getToken(tmlParser.FUT, 0); }
		public ExtendedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendedType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitExtendedType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendedTypeContext extendedType() throws RecognitionException {
		ExtendedTypeContext _localctx = new ExtendedTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extendedType);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case VM:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(72); type();
				}
				break;
			case FUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(FUT);
				setState(74); match(LT);
				setState(75); type();
				setState(76); match(GT);
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

	public static class StatementListContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VM) | (1L << RELEASE) | (1L << INT) | (1L << FUT) | (1L << IF) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(80); statement();
				}
				}
				setState(85);
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ReleaseContext release() {
			return getRuleContext(ReleaseContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86); varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88); ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89); returnStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90); release();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(tmlParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(tmlParser.SEMI, 0); }
		public SideEffectExpContext sideEffectExp() {
			return getRuleContext(SideEffectExpContext.class,0);
		}
		public ExtendedTypeContext extendedType() {
			return getRuleContext(ExtendedTypeContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(94);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VM) | (1L << INT) | (1L << FUT))) != 0)) {
				{
				setState(93); extendedType();
				}
			}

			setState(96); match(ID);
			}
			setState(98); match(ASSIGN);
			setState(99); sideEffectExp();
			setState(100); match(SEMI);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(tmlParser.SEMI, 0); }
		public ExtendedTypeContext extendedType() {
			return getRuleContext(ExtendedTypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); extendedType();
			setState(103); match(ID);
			setState(104); match(SEMI);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(tmlParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(tmlParser.SEMI, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(RETURN);
			setState(107); exp(0);
			setState(108); match(SEMI);
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

	public static class ReleaseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(tmlParser.SEMI, 0); }
		public TerminalNode RELEASE() { return getToken(tmlParser.RELEASE, 0); }
		public ReleaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitRelease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReleaseContext release() throws RecognitionException {
		ReleaseContext _localctx = new ReleaseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_release);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(RELEASE);
			setState(111); match(ID);
			setState(112); match(SEMI);
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

	public static class SideEffectExpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SyncContext sync() {
			return getRuleContext(SyncContext.class,0);
		}
		public AcquireContext acquire() {
			return getRuleContext(AcquireContext.class,0);
		}
		public AsyncInvocContext asyncInvoc() {
			return getRuleContext(AsyncInvocContext.class,0);
		}
		public SideEffectExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sideEffectExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitSideEffectExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SideEffectExpContext sideEffectExp() throws RecognitionException {
		SideEffectExpContext _localctx = new SideEffectExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sideEffectExp);
		try {
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114); exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); asyncInvoc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116); sync();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117); acquire();
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

	public static class AsyncInvocContext extends ParserRuleContext {
		public ExpContext receiver;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(tmlParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(tmlParser.COMMA, i);
		}
		public TerminalNode BANG() { return getToken(tmlParser.BANG, 0); }
		public AsyncInvocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asyncInvoc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitAsyncInvoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsyncInvocContext asyncInvoc() throws RecognitionException {
		AsyncInvocContext _localctx = new AsyncInvocContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_asyncInvoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); ((AsyncInvocContext)_localctx).receiver = exp(0);
			setState(121); match(BANG);
			setState(122); match(ID);
			setState(123); match(LPAREN);
			setState(132);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << THIS) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(124); exp(0);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125); match(COMMA);
					setState(126); exp(0);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134); match(RPAREN);
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

	public static class SyncContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(tmlParser.DOT, 0); }
		public TerminalNode SYNC() { return getToken(tmlParser.SYNC, 0); }
		public SyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sync; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitSync(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncContext sync() throws RecognitionException {
		SyncContext _localctx = new SyncContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sync);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); exp(0);
			setState(137); match(DOT);
			setState(138); match(SYNC);
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

	public static class AcquireContext extends ParserRuleContext {
		public TerminalNode VM() { return getToken(tmlParser.VM, 0); }
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public TerminalNode NEW() { return getToken(tmlParser.NEW, 0); }
		public AcquireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acquire; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitAcquire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcquireContext acquire() throws RecognitionException {
		AcquireContext _localctx = new AcquireContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_acquire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); match(NEW);
			setState(141); match(VM);
			setState(142); match(LPAREN);
			setState(143); match(RPAREN);
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

	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfSingleContext extends IfStmtContext {
		public StatementContext s1;
		public StatementContext s2;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(tmlParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(tmlParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IfSingleContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitIfSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfMultipleContext extends IfStmtContext {
		public StatementListContext thenBranch;
		public StatementListContext elseBranch;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> LCBRACK() { return getTokens(tmlParser.LCBRACK); }
		public TerminalNode ELSE() { return getToken(tmlParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(tmlParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public TerminalNode RCBRACK(int i) {
			return getToken(tmlParser.RCBRACK, i);
		}
		public List<StatementListContext> statementList() {
			return getRuleContexts(StatementListContext.class);
		}
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public TerminalNode LCBRACK(int i) {
			return getToken(tmlParser.LCBRACK, i);
		}
		public StatementListContext statementList(int i) {
			return getRuleContext(StatementListContext.class,i);
		}
		public List<TerminalNode> RCBRACK() { return getTokens(tmlParser.RCBRACK); }
		public IfMultipleContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitIfMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfMultipleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145); match(IF);
				setState(146); match(LPAREN);
				setState(147); exp(0);
				setState(148); match(RPAREN);
				setState(149); match(LCBRACK);
				setState(150); ((IfMultipleContext)_localctx).thenBranch = statementList();
				setState(151); match(RCBRACK);
				setState(152); match(ELSE);
				setState(153); match(LCBRACK);
				setState(154); ((IfMultipleContext)_localctx).elseBranch = statementList();
				setState(155); match(RCBRACK);
				}
				break;
			case 2:
				_localctx = new IfSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157); match(IF);
				setState(158); match(LPAREN);
				setState(159); exp(0);
				setState(160); match(RPAREN);
				setState(161); ((IfSingleContext)_localctx).s1 = statement();
				setState(162); match(ELSE);
				setState(163); ((IfSingleContext)_localctx).s2 = statement();
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(tmlParser.ID, 0); }
		public VarExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumExpContext extends ExpContext {
		public ExpContext exp1;
		public Token op;
		public ExpContext exp2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode PLUS() { return getToken(tmlParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(tmlParser.MINUS, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SumExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitSumExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExpContext extends ExpContext {
		public ExpContext exp1;
		public Token op;
		public ExpContext exp2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode AND() { return getToken(tmlParser.AND, 0); }
		public TerminalNode OR() { return getToken(tmlParser.OR, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BooleanExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitBooleanExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExpContext extends ExpContext {
		public TerminalNode THIS() { return getToken(tmlParser.THIS, 0); }
		public ThisExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitThisExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExpContext extends ExpContext {
		public ExpContext exp1;
		public Token op;
		public ExpContext exp2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode MULT() { return getToken(tmlParser.MULT, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(tmlParser.DIV, 0); }
		public MultExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitMultExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnclosingExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public EnclosingExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitEnclosingExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparissonExpContext extends ExpContext {
		public ExpContext exp1;
		public Token op;
		public ExpContext exp2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode LEG() { return getToken(tmlParser.LEG, 0); }
		public TerminalNode EQUALS() { return getToken(tmlParser.EQUALS, 0); }
		public TerminalNode LT() { return getToken(tmlParser.LT, 0); }
		public TerminalNode GT() { return getToken(tmlParser.GT, 0); }
		public TerminalNode DISTINCT() { return getToken(tmlParser.DISTINCT, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode GEG() { return getToken(tmlParser.GEG, 0); }
		public ComparissonExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitComparissonExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExpContext extends ExpContext {
		public TerminalNode NUMBER() { return getToken(tmlParser.NUMBER, 0); }
		public ValueExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitValueExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				_localctx = new ValueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(168); match(NUMBER);
				}
				break;
			case ID:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169); match(ID);
				}
				break;
			case LPAREN:
				{
				_localctx = new EnclosingExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170); match(LPAREN);
				setState(171); exp(0);
				setState(172); match(RPAREN);
				}
				break;
			case THIS:
				{
				_localctx = new ThisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174); match(THIS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExpContext(new ExpContext(_parentctx, _parentState));
						((BooleanExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(177);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(178);
						((BooleanExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BooleanExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(179); ((BooleanExpContext)_localctx).exp2 = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new SumExpContext(new ExpContext(_parentctx, _parentState));
						((SumExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(180);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(181);
						((SumExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((SumExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(182); ((SumExpContext)_localctx).exp2 = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new MultExpContext(new ExpContext(_parentctx, _parentState));
						((MultExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(183);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(184);
						((MultExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(185); ((MultExpContext)_localctx).exp2 = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new ComparissonExpContext(new ExpContext(_parentctx, _parentState));
						((ComparissonExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(186);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(187);
						((ComparissonExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GEG) | (1L << LEG) | (1L << EQUALS) | (1L << DISTINCT))) != 0)) ) {
							((ComparissonExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(188); ((ComparissonExpContext)_localctx).exp2 = exp(0);
						}
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 5);
		case 3: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u00c5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\5\3?\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6Q\n\6\3\7\7\7"+
		"T\n\7\f\7\16\7W\13\7\3\b\3\b\3\b\3\b\3\b\5\b^\n\b\3\t\5\ta\n\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\5\ry\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0082"+
		"\n\16\f\16\16\16\u0085\13\16\5\16\u0087\n\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a8"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b2\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00c0\n\22\f\22"+
		"\16\22\u00c3\13\22\3\22\2\3\"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"\2\7\4\2\32\32\36\36\3\2\r\16\3\2\t\n\3\2\13\f\3\2\17\24\u00cb\2\'"+
		"\3\2\2\2\4\63\3\2\2\2\6E\3\2\2\2\bH\3\2\2\2\nP\3\2\2\2\fU\3\2\2\2\16]"+
		"\3\2\2\2\20`\3\2\2\2\22h\3\2\2\2\24l\3\2\2\2\26p\3\2\2\2\30x\3\2\2\2\32"+
		"z\3\2\2\2\34\u008a\3\2\2\2\36\u008e\3\2\2\2 \u00a7\3\2\2\2\"\u00b1\3\2"+
		"\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'"+
		"\3\2\2\2*.\7\b\2\2+-\5\16\b\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2"+
		"\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\7\2\2\62\3\3\2\2\2\63\64\5\b\5\2\64"+
		"\65\7$\2\2\65>\7\3\2\2\66;\5\6\4\2\678\7\27\2\28:\5\6\4\29\67\3\2\2\2"+
		":=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2\2=;\3\2\2\2>\66\3\2\2\2>?\3\2\2"+
		"\2?@\3\2\2\2@A\7\4\2\2AB\7\b\2\2BC\5\f\7\2CD\7\7\2\2D\5\3\2\2\2EF\5\b"+
		"\5\2FG\7$\2\2G\7\3\2\2\2HI\t\2\2\2I\t\3\2\2\2JQ\5\b\5\2KL\7\37\2\2LM\7"+
		"\20\2\2MN\5\b\5\2NO\7\17\2\2OQ\3\2\2\2PJ\3\2\2\2PK\3\2\2\2Q\13\3\2\2\2"+
		"RT\5\16\b\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\r\3\2\2\2WU\3\2\2"+
		"\2X^\5\22\n\2Y^\5\20\t\2Z^\5 \21\2[^\5\24\13\2\\^\5\26\f\2]X\3\2\2\2]"+
		"Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\17\3\2\2\2_a\5\n\6\2`_\3\2\2"+
		"\2`a\3\2\2\2ab\3\2\2\2bc\7$\2\2cd\3\2\2\2de\7\26\2\2ef\5\30\r\2fg\7\30"+
		"\2\2g\21\3\2\2\2hi\5\n\6\2ij\7$\2\2jk\7\30\2\2k\23\3\2\2\2lm\7#\2\2mn"+
		"\5\"\22\2no\7\30\2\2o\25\3\2\2\2pq\7\34\2\2qr\7$\2\2rs\7\30\2\2s\27\3"+
		"\2\2\2ty\5\"\22\2uy\5\32\16\2vy\5\34\17\2wy\5\36\20\2xt\3\2\2\2xu\3\2"+
		"\2\2xv\3\2\2\2xw\3\2\2\2y\31\3\2\2\2z{\5\"\22\2{|\7\25\2\2|}\7$\2\2}\u0086"+
		"\7\3\2\2~\u0083\5\"\22\2\177\u0080\7\27\2\2\u0080\u0082\5\"\22\2\u0081"+
		"\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086~\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\4\2\2\u0089\33\3\2\2\2\u008a"+
		"\u008b\5\"\22\2\u008b\u008c\7\33\2\2\u008c\u008d\7\35\2\2\u008d\35\3\2"+
		"\2\2\u008e\u008f\7\31\2\2\u008f\u0090\7\32\2\2\u0090\u0091\7\3\2\2\u0091"+
		"\u0092\7\4\2\2\u0092\37\3\2\2\2\u0093\u0094\7!\2\2\u0094\u0095\7\3\2\2"+
		"\u0095\u0096\5\"\22\2\u0096\u0097\7\4\2\2\u0097\u0098\7\b\2\2\u0098\u0099"+
		"\5\f\7\2\u0099\u009a\7\7\2\2\u009a\u009b\7\"\2\2\u009b\u009c\7\b\2\2\u009c"+
		"\u009d\5\f\7\2\u009d\u009e\7\7\2\2\u009e\u00a8\3\2\2\2\u009f\u00a0\7!"+
		"\2\2\u00a0\u00a1\7\3\2\2\u00a1\u00a2\5\"\22\2\u00a2\u00a3\7\4\2\2\u00a3"+
		"\u00a4\5\16\b\2\u00a4\u00a5\7\"\2\2\u00a5\u00a6\5\16\b\2\u00a6\u00a8\3"+
		"\2\2\2\u00a7\u0093\3\2\2\2\u00a7\u009f\3\2\2\2\u00a8!\3\2\2\2\u00a9\u00aa"+
		"\b\22\1\2\u00aa\u00b2\7%\2\2\u00ab\u00b2\7$\2\2\u00ac\u00ad\7\3\2\2\u00ad"+
		"\u00ae\5\"\22\2\u00ae\u00af\7\4\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b2\7"+
		" \2\2\u00b1\u00a9\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00c1\3\2\2\2\u00b3\u00b4\f\t\2\2\u00b4\u00b5\t\3"+
		"\2\2\u00b5\u00c0\5\"\22\n\u00b6\u00b7\f\b\2\2\u00b7\u00b8\t\4\2\2\u00b8"+
		"\u00c0\5\"\22\t\u00b9\u00ba\f\7\2\2\u00ba\u00bb\t\5\2\2\u00bb\u00c0\5"+
		"\"\22\b\u00bc\u00bd\f\n\2\2\u00bd\u00be\t\6\2\2\u00be\u00c0\5\"\22\2\u00bf"+
		"\u00b3\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00bc\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"#\3\2\2\2\u00c3\u00c1\3\2\2\2\21\'.;>PU]`x\u0083\u0086\u00a7\u00b1\u00bf"+
		"\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}