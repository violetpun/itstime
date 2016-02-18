package tml.lang;

import java.util.LinkedList;
import java.util.List;

import tml.parser.tmlBaseVisitor;
import tml.parser.tmlParser;
import tml.lang.TmlElementBase;
import tml.lang.TmlExpNew;
import tml.parser.tmlParser;



public class TmlVisitorImpl
  extends tmlBaseVisitor<TmlElementBase>
{
  public TmlElementBase visitProgram(tmlParser.ProgramContext ctx)
  {
    TmlProgram program = new TmlProgram();
    
    List<tmlParser.MethodContext> methods = ctx.getRuleContexts(tmlParser.MethodContext.class);
    TmlMethod method;
    for (tmlParser.MethodContext mc : methods)
    {
      method = (TmlMethod)visitMethod(mc);
      program.AddMethod(method);
    }
    List<TmlStatement> mainStmts = new LinkedList<TmlStatement>();
    for (tmlParser.StatementContext sc : ctx.statement()) {
      mainStmts.add((TmlStatement)visitStatement(sc));
    }
    program.addMain(mainStmts);
    
    return program;
  }
  
  public TmlElementBase visitMethod(tmlParser.MethodContext ctx)
  {
    List<TmlArgument> arguments = new LinkedList<TmlArgument>();
    for (tmlParser.ParameterContext pc : ctx.parameter()) {
      arguments.add((TmlArgument)visitParameter(pc));
    }
    List<TmlStatement> stmts = new LinkedList<TmlStatement>();
    for (tmlParser.StatementContext sc : ctx.statementList().statement()) {
      stmts.add((TmlStatement)visitStatement(sc));
    }
    return new TmlMethod(ctx.ID().getText(), arguments, stmts, ctx.type().getText());
  }
  
  public TmlElementBase visitStatementList(tmlParser.StatementListContext ctx)
  {
    List<TmlStatement> stmts = new LinkedList<TmlStatement>();
    for (tmlParser.StatementContext sc : ctx.statement()) {
      stmts.add((TmlStatement)visitStatement(sc));
    }
    return new TmlStmtSeq(stmts);
  }
  
  public TmlElementBase visitParameter(tmlParser.ParameterContext ctx)
  {
    return new TmlArgument(ctx.type().getText(), ctx.ID().getText().toUpperCase());
  }
  
  public TmlElementBase visitVarDecl(tmlParser.VarDeclContext ctx)
  {
    return new TmlStmtVarDecl(ctx.extendedType().getText(), ctx.ID().getText().toUpperCase());
  }
  
  public TmlElementBase visitAssignment(tmlParser.AssignmentContext ctx)
  {
    TmlExpBase exp = (TmlExpBase)visitSideEffectExp(ctx.sideEffectExp());
    tmlParser.ExtendedTypeContext vc;
    if ((vc = ctx.extendedType()) != null)
    {
      TmlStmtVarDecl decl = new TmlStmtVarDecl(vc.getText(), ctx.ID().getText().toUpperCase());
      return new TmlStmtAssignment(decl, exp);
    }
    return new TmlStmtAssignment(ctx.ID().getText().toUpperCase(), exp);
  }
  
  public TmlElementBase visitIfMultiple(tmlParser.IfMultipleContext ctx)
  {
    TmlExpBase cond = (TmlExpBase)visit(ctx.exp());
    
    TmlStmtSeq stmtsThen = (TmlStmtSeq)visitStatementList(ctx.thenBranch);
    TmlStmtSeq stmtsElse = (TmlStmtSeq)visitStatementList(ctx.elseBranch);
    
    return new TmlStmtIf(cond, stmtsThen.getStmts(), stmtsElse.getStmts());
  }
  
  public TmlElementBase visitIfSingle(tmlParser.IfSingleContext ctx)
  {
    TmlExpBase cond = (TmlExpBase)visit(ctx.exp());
    
    List<TmlStatement> stmtsThen = new LinkedList<TmlStatement>();
    stmtsThen.add((TmlStatement)visitStatement(ctx.s1));
    
    List<TmlStatement> stmtsElse = new LinkedList<TmlStatement>();
    stmtsElse.add((TmlStatement)visitStatement(ctx.s2));
    
    return new TmlStmtIf(cond, stmtsThen, stmtsElse);
  }
  
  public TmlElementBase visitReturnStmt(tmlParser.ReturnStmtContext ctx)
  {
    TmlExpBase exp = (TmlExpBase)visit(ctx.exp());
    
    TmlStmtReturn ret = new TmlStmtReturn(exp);
    
    return ret;
  }
  
//  public TmlElementBase visitRelease(tmlParser.ReleaseContext ctx)
//  {
//    TmlStmtRelease rel = new TmlStmtRelease(ctx.ID().getText().toUpperCase());
//    
//    return rel;
//  }
  
  public TmlElementBase visitAsyncInvoc(tmlParser.AsyncInvocContext ctx)
  {
    List<TmlExpBase> all = new LinkedList<TmlExpBase>();
    for (tmlParser.ExpContext e : ctx.exp()) {
      all.add((TmlExpBase)visit(e));
    }
    return new TmlExpInvoke(ctx.ID().getText(), (TmlExpBase)all.get(0), all.subList(1, all.size()));
  }
  
  public TmlElementBase visitSync(tmlParser.SyncContext ctx)
  {
    TmlExpSync sync = new TmlExpSync((TmlExpBase)visit(ctx.exp()));
    
    return sync;
  }
  
  /* 
   * For creating an object in the local cog
   */
  public TmlElementBase visitNewlocal(tmlParser.NewlocalContext ctx)
  {
    return new TmlExpNewlocal();
  }
  
  /* 
   * For creating an object in a new cog
   */
  public TmlElementBase visitNewcog(tmlParser.NewcogContext ctx)
  {
    return new TmlExpNewcog();
  }
  
//  public TmlElementBase visitAcquire(tmlParser.AcquireContext ctx)
//  {
//    return new TmlExpNew();
//  }
  
  public TmlElementBase visitComparissonExp(tmlParser.ComparissonExpContext ctx)
  {
    return ctx.exp2 == null ? (TmlElementBase)visit(ctx.exp1) : new TmlExpBinary((TmlExpBase)visit(ctx.exp1), ctx.op.getText(), (TmlExpBase)visit(ctx.exp2));
  }
  
  public TmlElementBase visitBooleanExp(tmlParser.BooleanExpContext ctx)
  {
    return ctx.exp2 == null ? (TmlElementBase)visit(ctx.exp1) : new TmlExpBinary((TmlExpBase)visit(ctx.exp1), ctx.op.getText(), (TmlExpBase)visit(ctx.exp2));
  }
  
  public TmlElementBase visitSumExp(tmlParser.SumExpContext ctx)
  {
    return ctx.exp2 == null ? (TmlElementBase)visit(ctx.exp1) : new TmlExpBinary((TmlExpBase)visit(ctx.exp1), ctx.op.getText(), (TmlExpBase)visit(ctx.exp2));
  }
  
  public TmlElementBase visitMultExp(tmlParser.MultExpContext ctx)
  {
    return ctx.exp2 == null ? (TmlElementBase)visit(ctx.exp1) : new TmlExpBinary((TmlExpBase)visit(ctx.exp1), ctx.op.getText(), (TmlExpBase)visit(ctx.exp2));
  }
  
  public TmlElementBase visitEnclosingExp(tmlParser.EnclosingExpContext ctx)
  {
    return (TmlElementBase)visit(ctx.exp());
  }
  
  public TmlElementBase visitValueExp(tmlParser.ValueExpContext ctx)
  {
    return new TmlExpInt(Integer.parseInt(ctx.NUMBER().getText()));
  }
  
  public TmlElementBase visitVarExp(tmlParser.VarExpContext ctx)
  {
    return new TmlExpVar(ctx.ID().getText().toUpperCase());
  }
  
  public TmlElementBase visitThisExp(tmlParser.ThisExpContext ctx)
  {
    return new TmlExpThis();
  }
}

