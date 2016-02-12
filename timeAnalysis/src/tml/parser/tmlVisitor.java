// Generated from tml.g4 by ANTLR 4.4
package tml.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tmlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tmlParser#release}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease(@NotNull tmlParser.ReleaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull tmlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enclosingExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosingExp(@NotNull tmlParser.EnclosingExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull tmlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#acquire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcquire(@NotNull tmlParser.AcquireContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExp(@NotNull tmlParser.VarExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull tmlParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#extendedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedType(@NotNull tmlParser.ExtendedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(@NotNull tmlParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull tmlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExp(@NotNull tmlParser.ThisExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExp(@NotNull tmlParser.MultExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#sideEffectExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSideEffectExp(@NotNull tmlParser.SideEffectExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExp(@NotNull tmlParser.ValueExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull tmlParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExp(@NotNull tmlParser.BooleanExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull tmlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(@NotNull tmlParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#sync}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSync(@NotNull tmlParser.SyncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSingle}
	 * labeled alternative in {@link tmlParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSingle(@NotNull tmlParser.IfSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExp(@NotNull tmlParser.SumExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifMultiple}
	 * labeled alternative in {@link tmlParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfMultiple(@NotNull tmlParser.IfMultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#asyncInvoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsyncInvoc(@NotNull tmlParser.AsyncInvocContext ctx);
	/**
	 * Visit a parse tree produced by {@link tmlParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull tmlParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparissonExp}
	 * labeled alternative in {@link tmlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparissonExp(@NotNull tmlParser.ComparissonExpContext ctx);
}