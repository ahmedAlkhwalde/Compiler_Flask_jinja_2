// Generated from C:/Users/DELL/Desktop/CompilerFlaskAndJinja/src/antlrFlask/ProjectParser.g4 by ANTLR 4.13.2
package antlrFlask;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProjectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProjectParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code progeRoot}
	 * labeled alternative in {@link ProjectParser#proge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgeRoot(ProjectParser.ProgeRootContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#empty_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_line(ProjectParser.Empty_lineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(ProjectParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compoundStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(ProjectParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(ProjectParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(ProjectParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code delStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelStatement(ProjectParser.DelStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassStatement(ProjectParser.PassStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flowStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowStatement(ProjectParser.FlowStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(ProjectParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatement(ProjectParser.GlobalStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link ProjectParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(ProjectParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code annotatedAssign}
	 * labeled alternative in {@link ProjectParser#annAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotatedAssign(ProjectParser.AnnotatedAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#augassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugassign(ProjectParser.AugassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#testlist_star_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist_star_expr(ProjectParser.Testlist_star_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(ProjectParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(ProjectParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(ProjectParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(ProjectParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ProjectParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_op(ProjectParser.Comp_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(ProjectParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ProjectParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ProjectParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ProjectParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#atom_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_expr(ProjectParser.Atom_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomParen}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomParen(ProjectParser.AtomParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomList}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomList(ProjectParser.AtomListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomDict}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomDict(ProjectParser.AtomDictContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomName}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomName(ProjectParser.AtomNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomNumber}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomNumber(ProjectParser.AtomNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomString(ProjectParser.AtomStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomFString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomFString(ProjectParser.AtomFStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomTrue}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomTrue(ProjectParser.AtomTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomFalse}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomFalse(ProjectParser.AtomFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomNone}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomNone(ProjectParser.AtomNoneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallTrailer(ProjectParser.CallTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptTrailer(ProjectParser.SubscriptTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotTrailer(ProjectParser.DotTrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#subscriptlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptlist(ProjectParser.SubscriptlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(ProjectParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#listmaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListmaker(ProjectParser.ListmakerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#dictmaker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictmaker(ProjectParser.DictmakerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compFor}
	 * labeled alternative in {@link ProjectParser#comp_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompFor(ProjectParser.CompForContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#testlist_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist_comp(ProjectParser.Testlist_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(ProjectParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(ProjectParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#del_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDel_stmt(ProjectParser.Del_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#pass_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass_stmt(ProjectParser.Pass_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#flow_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_stmt(ProjectParser.Flow_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(ProjectParser.Import_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#dotted_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_name(ProjectParser.Dotted_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#dotted_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_names(ProjectParser.Dotted_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#dotted_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotted_as_name(ProjectParser.Dotted_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#import_as_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_names(ProjectParser.Import_as_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#import_as_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_as_name(ProjectParser.Import_as_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#global_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_stmt(ProjectParser.Global_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(ProjectParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(ProjectParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(ProjectParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDefStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefStmt(ProjectParser.FuncDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(ProjectParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tryStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStmt(ProjectParser.TryStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStmt(ProjectParser.WithStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decoratedStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratedStmt(ProjectParser.DecoratedStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#decorated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated(ProjectParser.DecoratedContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(ProjectParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(ProjectParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(ProjectParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(ProjectParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(ProjectParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ProjectParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#typedargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedargslist(ProjectParser.TypedargslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#tfpdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfpdef(ProjectParser.TfpdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(ProjectParser.ClassdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#try_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_stmt(ProjectParser.Try_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#with_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_stmt(ProjectParser.With_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#with_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_item(ProjectParser.With_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(ProjectParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(ProjectParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjectParser#testlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist(ProjectParser.TestlistContext ctx);
}