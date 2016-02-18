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
		CLASS=24, LOCAL=25, DOT=26, WITH=27, SYNC=28, INT=29, FUT=30, THIS=31, 
		CAPACITY=32, IF=33, ELSE=34, JOB=35, RETURN=36, ID=37, NUMBER=38, WS=39, 
		LINECOMENTS=40, BLOCKCOMENTS=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'('", "')'", "']'", "'['", "'}'", "'{'", "'+'", "'-'", "'*'", 
		"'/'", "'&&'", "'||'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'!'", 
		"'='", "','", "';'", "'new'", "'Class'", "'local'", "'.'", "'with'", "'get'", 
		"'Int'", "'Fut'", "'this'", "'capacity'", "'if'", "'else'", "'job'", "'return'", 
		"ID", "NUMBER", "WS", "LINECOMENTS", "BLOCKCOMENTS"
	};
	public static final int
		RULE_program = 0, RULE_method = 1, RULE_parameter = 2, RULE_type = 3, 
		RULE_extendedType = 4, RULE_statementList = 5, RULE_statement = 6, RULE_assignment = 7, 
		RULE_varDecl = 8, RULE_jobStmt = 9, RULE_returnStmt = 10, RULE_sideEffectExp = 11, 
		RULE_asyncInvoc = 12, RULE_syncInvoc = 13, RULE_sync = 14, RULE_newcog = 15, 
		RULE_newlocal = 16, RULE_ifStmt = 17, RULE_exp = 18;
	public static final String[] ruleNames = {
		"program", "method", "parameter", "type", "extendedType", "statementList", 
		"statement", "assignment", "varDecl", "jobStmt", "returnStmt", "sideEffectExp", 
		"asyncInvoc", "syncInvoc", "sync", "newcog", "newlocal", "ifStmt", "exp"
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS || _la==INT) {
				{
				{
				setState(38); method();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(LCBRACK);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << INT) | (1L << FUT) | (1L << IF) | (1L << JOB) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(45); statement();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51); match(RCBRACK);
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
			setState(53); type();
			setState(54); match(ID);
			setState(55); match(LPAREN);
			setState(64);
			_la = _input.LA(1);
			if (_la==CLASS || _la==INT) {
				{
				setState(56); parameter();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(57); match(COMMA);
					setState(58); parameter();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(66); match(RPAREN);
			setState(67); match(LCBRACK);
			setState(68); statementList();
			setState(69); match(RCBRACK);
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
			setState(71); type();
			setState(72); match(ID);
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
		public TerminalNode INT() { return getToken(tmlParser.INT, 0); }
		public TerminalNode CLASS() { return getToken(tmlParser.CLASS, 0); }
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
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==CLASS || _la==INT) ) {
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
		int _la;
		try {
			setState(83);
			switch (_input.LA(1)) {
			case CLASS:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); type();
				}
				break;
			case FUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(77); match(FUT);
				setState(78); match(LT);
				setState(80);
				_la = _input.LA(1);
				if (_la==CLASS || _la==INT) {
					{
					setState(79); type();
					}
				}

				setState(82); match(GT);
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
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << INT) | (1L << FUT) | (1L << IF) | (1L << JOB) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(85); statement();
				}
				}
				setState(90);
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
		public JobStmtContext jobStmt() {
			return getRuleContext(JobStmtContext.class,0);
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
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91); varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94); jobStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95); returnStmt();
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
			setState(99);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << INT) | (1L << FUT))) != 0)) {
				{
				setState(98); extendedType();
				}
			}

			setState(101); match(ID);
			}
			setState(103); match(ASSIGN);
			setState(104); sideEffectExp();
			setState(105); match(SEMI);
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
			setState(107); extendedType();
			setState(108); match(ID);
			setState(109); match(SEMI);
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

	public static class JobStmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(tmlParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(tmlParser.SEMI, 0); }
		public TerminalNode JOB() { return getToken(tmlParser.JOB, 0); }
		public TerminalNode RPAREN() { return getToken(tmlParser.RPAREN, 0); }
		public JobStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jobStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitJobStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JobStmtContext jobStmt() throws RecognitionException {
		JobStmtContext _localctx = new JobStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_jobStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(JOB);
			setState(112); match(LPAREN);
			setState(113); exp(0);
			setState(114); match(RPAREN);
			setState(115); match(SEMI);
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
		enterRule(_localctx, 20, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(RETURN);
			setState(118); exp(0);
			setState(119); match(SEMI);
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
		public NewlocalContext newlocal() {
			return getRuleContext(NewlocalContext.class,0);
		}
		public SyncInvocContext syncInvoc() {
			return getRuleContext(SyncInvocContext.class,0);
		}
		public AsyncInvocContext asyncInvoc() {
			return getRuleContext(AsyncInvocContext.class,0);
		}
		public NewcogContext newcog() {
			return getRuleContext(NewcogContext.class,0);
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
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121); exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122); asyncInvoc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(123); syncInvoc();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124); sync();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(125); newcog();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(126); newlocal();
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
			setState(129); ((AsyncInvocContext)_localctx).receiver = exp(0);
			setState(130); match(BANG);
			setState(131); match(ID);
			setState(132); match(LPAREN);
			setState(141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << THIS) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(133); exp(0);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134); match(COMMA);
					setState(135); exp(0);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

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

	public static class SyncInvocContext extends ParserRuleContext {
		public ExpContext receiver;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode DOT() { return getToken(tmlParser.DOT, 0); }
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
		public SyncInvocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syncInvoc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitSyncInvoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncInvocContext syncInvoc() throws RecognitionException {
		SyncInvocContext _localctx = new SyncInvocContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_syncInvoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); ((SyncInvocContext)_localctx).receiver = exp(0);
			setState(146); match(DOT);
			setState(147); match(ID);
			setState(148); match(LPAREN);
			setState(157);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << THIS) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(149); exp(0);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150); match(COMMA);
					setState(151); exp(0);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(159); match(RPAREN);
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
		enterRule(_localctx, 28, RULE_sync);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); exp(0);
			setState(162); match(DOT);
			setState(163); match(SYNC);
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

	public static class NewcogContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode WITH() { return getToken(tmlParser.WITH, 0); }
		public TerminalNode CLASS() { return getToken(tmlParser.CLASS, 0); }
		public TerminalNode NEW() { return getToken(tmlParser.NEW, 0); }
		public NewcogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newcog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitNewcog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewcogContext newcog() throws RecognitionException {
		NewcogContext _localctx = new NewcogContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_newcog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(NEW);
			setState(166); match(CLASS);
			setState(167); match(WITH);
			setState(168); exp(0);
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

	public static class NewlocalContext extends ParserRuleContext {
		public TerminalNode LOCAL() { return getToken(tmlParser.LOCAL, 0); }
		public TerminalNode CLASS() { return getToken(tmlParser.CLASS, 0); }
		public TerminalNode NEW() { return getToken(tmlParser.NEW, 0); }
		public NewlocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newlocal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitNewlocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewlocalContext newlocal() throws RecognitionException {
		NewlocalContext _localctx = new NewlocalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_newlocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); match(NEW);
			setState(171); match(LOCAL);
			setState(172); match(CLASS);
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
		enterRule(_localctx, 34, RULE_ifStmt);
		try {
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IfMultipleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174); match(IF);
				setState(175); match(LPAREN);
				setState(176); exp(0);
				setState(177); match(RPAREN);
				setState(178); match(LCBRACK);
				setState(179); ((IfMultipleContext)_localctx).thenBranch = statementList();
				setState(180); match(RCBRACK);
				setState(181); match(ELSE);
				setState(182); match(LCBRACK);
				setState(183); ((IfMultipleContext)_localctx).elseBranch = statementList();
				setState(184); match(RCBRACK);
				}
				break;
			case 2:
				_localctx = new IfSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186); match(IF);
				setState(187); match(LPAREN);
				setState(188); exp(0);
				setState(189); match(RPAREN);
				setState(190); ((IfSingleContext)_localctx).s1 = statement();
				setState(191); match(ELSE);
				setState(192); ((IfSingleContext)_localctx).s2 = statement();
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
	public static class ThisCapacityContext extends ExpContext {
		public TerminalNode DOT() { return getToken(tmlParser.DOT, 0); }
		public TerminalNode CAPACITY() { return getToken(tmlParser.CAPACITY, 0); }
		public TerminalNode THIS() { return getToken(tmlParser.THIS, 0); }
		public ThisCapacityContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tmlVisitor ) return ((tmlVisitor<? extends T>)visitor).visitThisCapacity(this);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197); match(NUMBER);
				}
				break;
			case 2:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198); match(ID);
				}
				break;
			case 3:
				{
				_localctx = new EnclosingExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199); match(LPAREN);
				setState(200); exp(0);
				setState(201); match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new ThisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203); match(THIS);
				}
				break;
			case 5:
				{
				_localctx = new ThisCapacityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204); match(THIS);
				setState(205); match(DOT);
				setState(206); match(CAPACITY);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExpContext(new ExpContext(_parentctx, _parentState));
						((BooleanExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(209);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(210);
						((BooleanExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BooleanExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(211); ((BooleanExpContext)_localctx).exp2 = exp(9);
						}
						break;
					case 2:
						{
						_localctx = new SumExpContext(new ExpContext(_parentctx, _parentState));
						((SumExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(212);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(213);
						((SumExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((SumExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(214); ((SumExpContext)_localctx).exp2 = exp(8);
						}
						break;
					case 3:
						{
						_localctx = new MultExpContext(new ExpContext(_parentctx, _parentState));
						((MultExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(215);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(216);
						((MultExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(217); ((MultExpContext)_localctx).exp2 = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new ComparissonExpContext(new ExpContext(_parentctx, _parentState));
						((ComparissonExpContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(218);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(219);
						((ComparissonExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GEG) | (1L << LEG) | (1L << EQUALS) | (1L << DISTINCT))) != 0)) ) {
							((ComparissonExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(220); ((ComparissonExpContext)_localctx).exp2 = exp(0);
						}
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		case 18: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00e5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\7\2\61\n\2\f"+
		"\2\16\2\64\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3>\n\3\f\3\16\3A\13"+
		"\3\5\3C\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5"+
		"\6S\n\6\3\6\5\6V\n\6\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\5\bc\n\b\3\t\5\tf\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0082"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u008b\n\16\f\16\16\16\u008e"+
		"\13\16\5\16\u0090\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7"+
		"\17\u009b\n\17\f\17\16\17\u009e\13\17\5\17\u00a0\n\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00c5\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00d2\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u00e0\n\24\f\24\16\24\u00e3\13\24\3\24"+
		"\2\3&\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\7\4\2\32\32\37"+
		"\37\3\2\r\16\3\2\t\n\3\2\13\f\3\2\17\24\u00ef\2+\3\2\2\2\4\67\3\2\2\2"+
		"\6I\3\2\2\2\bL\3\2\2\2\nU\3\2\2\2\fZ\3\2\2\2\16b\3\2\2\2\20e\3\2\2\2\22"+
		"m\3\2\2\2\24q\3\2\2\2\26w\3\2\2\2\30\u0081\3\2\2\2\32\u0083\3\2\2\2\34"+
		"\u0093\3\2\2\2\36\u00a3\3\2\2\2 \u00a7\3\2\2\2\"\u00ac\3\2\2\2$\u00c4"+
		"\3\2\2\2&\u00d1\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,.\3\2\2\2-+\3\2\2\2.\62\7\b\2\2/\61\5\16\b\2\60/\3\2\2\2\61\64\3"+
		"\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7"+
		"\7\2\2\66\3\3\2\2\2\678\5\b\5\289\7\'\2\29B\7\3\2\2:?\5\6\4\2;<\7\27\2"+
		"\2<>\5\6\4\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@C\3\2\2\2A?\3\2\2"+
		"\2B:\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\4\2\2EF\7\b\2\2FG\5\f\7\2GH\7\7\2"+
		"\2H\5\3\2\2\2IJ\5\b\5\2JK\7\'\2\2K\7\3\2\2\2LM\t\2\2\2M\t\3\2\2\2NV\5"+
		"\b\5\2OP\7 \2\2PR\7\20\2\2QS\5\b\5\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\7"+
		"\17\2\2UN\3\2\2\2UO\3\2\2\2V\13\3\2\2\2WY\5\16\b\2XW\3\2\2\2Y\\\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]c\5\22\n\2^c\5\20\t\2_c\5"+
		"$\23\2`c\5\24\13\2ac\5\26\f\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2"+
		"ba\3\2\2\2c\17\3\2\2\2df\5\n\6\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\'\2"+
		"\2hi\3\2\2\2ij\7\26\2\2jk\5\30\r\2kl\7\30\2\2l\21\3\2\2\2mn\5\n\6\2no"+
		"\7\'\2\2op\7\30\2\2p\23\3\2\2\2qr\7%\2\2rs\7\3\2\2st\5&\24\2tu\7\4\2\2"+
		"uv\7\30\2\2v\25\3\2\2\2wx\7&\2\2xy\5&\24\2yz\7\30\2\2z\27\3\2\2\2{\u0082"+
		"\5&\24\2|\u0082\5\32\16\2}\u0082\5\34\17\2~\u0082\5\36\20\2\177\u0082"+
		"\5 \21\2\u0080\u0082\5\"\22\2\u0081{\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2"+
		"\2\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\31\3\2"+
		"\2\2\u0083\u0084\5&\24\2\u0084\u0085\7\25\2\2\u0085\u0086\7\'\2\2\u0086"+
		"\u008f\7\3\2\2\u0087\u008c\5&\24\2\u0088\u0089\7\27\2\2\u0089\u008b\5"+
		"&\24\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0087\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\4\2\2\u0092"+
		"\33\3\2\2\2\u0093\u0094\5&\24\2\u0094\u0095\7\34\2\2\u0095\u0096\7\'\2"+
		"\2\u0096\u009f\7\3\2\2\u0097\u009c\5&\24\2\u0098\u0099\7\27\2\2\u0099"+
		"\u009b\5&\24\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u0097\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\4"+
		"\2\2\u00a2\35\3\2\2\2\u00a3\u00a4\5&\24\2\u00a4\u00a5\7\34\2\2\u00a5\u00a6"+
		"\7\36\2\2\u00a6\37\3\2\2\2\u00a7\u00a8\7\31\2\2\u00a8\u00a9\7\32\2\2\u00a9"+
		"\u00aa\7\35\2\2\u00aa\u00ab\5&\24\2\u00ab!\3\2\2\2\u00ac\u00ad\7\31\2"+
		"\2\u00ad\u00ae\7\33\2\2\u00ae\u00af\7\32\2\2\u00af#\3\2\2\2\u00b0\u00b1"+
		"\7#\2\2\u00b1\u00b2\7\3\2\2\u00b2\u00b3\5&\24\2\u00b3\u00b4\7\4\2\2\u00b4"+
		"\u00b5\7\b\2\2\u00b5\u00b6\5\f\7\2\u00b6\u00b7\7\7\2\2\u00b7\u00b8\7$"+
		"\2\2\u00b8\u00b9\7\b\2\2\u00b9\u00ba\5\f\7\2\u00ba\u00bb\7\7\2\2\u00bb"+
		"\u00c5\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd\u00be\7\3\2\2\u00be\u00bf\5&\24"+
		"\2\u00bf\u00c0\7\4\2\2\u00c0\u00c1\5\16\b\2\u00c1\u00c2\7$\2\2\u00c2\u00c3"+
		"\5\16\b\2\u00c3\u00c5\3\2\2\2\u00c4\u00b0\3\2\2\2\u00c4\u00bc\3\2\2\2"+
		"\u00c5%\3\2\2\2\u00c6\u00c7\b\24\1\2\u00c7\u00d2\7(\2\2\u00c8\u00d2\7"+
		"\'\2\2\u00c9\u00ca\7\3\2\2\u00ca\u00cb\5&\24\2\u00cb\u00cc\7\4\2\2\u00cc"+
		"\u00d2\3\2\2\2\u00cd\u00d2\7!\2\2\u00ce\u00cf\7!\2\2\u00cf\u00d0\7\34"+
		"\2\2\u00d0\u00d2\7\"\2\2\u00d1\u00c6\3\2\2\2\u00d1\u00c8\3\2\2\2\u00d1"+
		"\u00c9\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\u00e1\3\2"+
		"\2\2\u00d3\u00d4\f\n\2\2\u00d4\u00d5\t\3\2\2\u00d5\u00e0\5&\24\13\u00d6"+
		"\u00d7\f\t\2\2\u00d7\u00d8\t\4\2\2\u00d8\u00e0\5&\24\n\u00d9\u00da\f\b"+
		"\2\2\u00da\u00db\t\5\2\2\u00db\u00e0\5&\24\t\u00dc\u00dd\f\13\2\2\u00dd"+
		"\u00de\t\6\2\2\u00de\u00e0\5&\24\2\u00df\u00d3\3\2\2\2\u00df\u00d6\3\2"+
		"\2\2\u00df\u00d9\3\2\2\2\u00df\u00dc\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\'\3\2\2\2\u00e3\u00e1\3\2\2\2"+
		"\24+\62?BRUZbe\u0081\u008c\u008f\u009c\u009f\u00c4\u00d1\u00df\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}