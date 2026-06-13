// Generated from C:/Users/DELL/Desktop/CompilerFlaskAndJinja/src/antlrFlask/ProjectParser.g4 by ANTLR 4.13.2
package antlrFlask;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjectParser}.
 */
public interface ProjectParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code progeRoot}
	 * labeled alternative in {@link ProjectParser#proge}.
	 * @param ctx the parse tree
	 */
	void enterProgeRoot(ProjectParser.ProgeRootContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progeRoot}
	 * labeled alternative in {@link ProjectParser#proge}.
	 * @param ctx the parse tree
	 */
	void exitProgeRoot(ProjectParser.ProgeRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#empty_line}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_line(ProjectParser.Empty_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#empty_line}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_line(ProjectParser.Empty_lineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(ProjectParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(ProjectParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compoundStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(ProjectParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compoundStatement}
	 * labeled alternative in {@link ProjectParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(ProjectParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(ProjectParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(ProjectParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(ProjectParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(ProjectParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code delStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDelStatement(ProjectParser.DelStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code delStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDelStatement(ProjectParser.DelStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code passStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPassStatement(ProjectParser.PassStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code passStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPassStatement(ProjectParser.PassStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flowStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFlowStatement(ProjectParser.FlowStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flowStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFlowStatement(ProjectParser.FlowStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(ProjectParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(ProjectParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globalStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatement(ProjectParser.GlobalStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globalStatement}
	 * labeled alternative in {@link ProjectParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatement(ProjectParser.GlobalStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link ProjectParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(ProjectParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link ProjectParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(ProjectParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code annotatedAssign}
	 * labeled alternative in {@link ProjectParser#annAssign}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedAssign(ProjectParser.AnnotatedAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code annotatedAssign}
	 * labeled alternative in {@link ProjectParser#annAssign}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedAssign(ProjectParser.AnnotatedAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#augassign}.
	 * @param ctx the parse tree
	 */
	void enterAugassign(ProjectParser.AugassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#augassign}.
	 * @param ctx the parse tree
	 */
	void exitAugassign(ProjectParser.AugassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#testlist_star_expr}.
	 * @param ctx the parse tree
	 */
	void enterTestlist_star_expr(ProjectParser.Testlist_star_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#testlist_star_expr}.
	 * @param ctx the parse tree
	 */
	void exitTestlist_star_expr(ProjectParser.Testlist_star_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(ProjectParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(ProjectParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(ProjectParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(ProjectParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(ProjectParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(ProjectParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(ProjectParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(ProjectParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ProjectParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ProjectParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(ProjectParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(ProjectParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(ProjectParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(ProjectParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ProjectParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ProjectParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ProjectParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ProjectParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(ProjectParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(ProjectParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_expr(ProjectParser.Atom_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_expr(ProjectParser.Atom_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomParen}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomParen(ProjectParser.AtomParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomParen}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomParen(ProjectParser.AtomParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomList}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomList(ProjectParser.AtomListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomList}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomList(ProjectParser.AtomListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomDict}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomDict(ProjectParser.AtomDictContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomDict}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomDict(ProjectParser.AtomDictContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomName}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomName(ProjectParser.AtomNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomName}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomName(ProjectParser.AtomNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomNumber}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomNumber(ProjectParser.AtomNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomNumber}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomNumber(ProjectParser.AtomNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomString(ProjectParser.AtomStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomString(ProjectParser.AtomStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomFString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomFString(ProjectParser.AtomFStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomFString}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomFString(ProjectParser.AtomFStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomTrue}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomTrue(ProjectParser.AtomTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomTrue}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomTrue(ProjectParser.AtomTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomFalse}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomFalse(ProjectParser.AtomFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomFalse}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomFalse(ProjectParser.AtomFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomNone}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomNone(ProjectParser.AtomNoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomNone}
	 * labeled alternative in {@link ProjectParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomNone(ProjectParser.AtomNoneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterCallTrailer(ProjectParser.CallTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitCallTrailer(ProjectParser.CallTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptTrailer(ProjectParser.SubscriptTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptTrailer(ProjectParser.SubscriptTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterDotTrailer(ProjectParser.DotTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotTrailer}
	 * labeled alternative in {@link ProjectParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitDotTrailer(ProjectParser.DotTrailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#subscriptlist}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptlist(ProjectParser.SubscriptlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#subscriptlist}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptlist(ProjectParser.SubscriptlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(ProjectParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(ProjectParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#listmaker}.
	 * @param ctx the parse tree
	 */
	void enterListmaker(ProjectParser.ListmakerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#listmaker}.
	 * @param ctx the parse tree
	 */
	void exitListmaker(ProjectParser.ListmakerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#dictmaker}.
	 * @param ctx the parse tree
	 */
	void enterDictmaker(ProjectParser.DictmakerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#dictmaker}.
	 * @param ctx the parse tree
	 */
	void exitDictmaker(ProjectParser.DictmakerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compFor}
	 * labeled alternative in {@link ProjectParser#comp_for}.
	 * @param ctx the parse tree
	 */
	void enterCompFor(ProjectParser.CompForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compFor}
	 * labeled alternative in {@link ProjectParser#comp_for}.
	 * @param ctx the parse tree
	 */
	void exitCompFor(ProjectParser.CompForContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#testlist_comp}.
	 * @param ctx the parse tree
	 */
	void enterTestlist_comp(ProjectParser.Testlist_compContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#testlist_comp}.
	 * @param ctx the parse tree
	 */
	void exitTestlist_comp(ProjectParser.Testlist_compContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(ProjectParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(ProjectParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(ProjectParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(ProjectParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#del_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDel_stmt(ProjectParser.Del_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#del_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDel_stmt(ProjectParser.Del_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPass_stmt(ProjectParser.Pass_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPass_stmt(ProjectParser.Pass_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFlow_stmt(ProjectParser.Flow_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFlow_stmt(ProjectParser.Flow_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(ProjectParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(ProjectParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_name(ProjectParser.Dotted_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_name(ProjectParser.Dotted_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#dotted_as_names}.
	 * @param ctx the parse tree
	 */
	void enterDotted_as_names(ProjectParser.Dotted_as_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#dotted_as_names}.
	 * @param ctx the parse tree
	 */
	void exitDotted_as_names(ProjectParser.Dotted_as_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_as_name(ProjectParser.Dotted_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#dotted_as_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_as_name(ProjectParser.Dotted_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_names(ProjectParser.Import_as_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#import_as_names}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_names(ProjectParser.Import_as_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void enterImport_as_name(ProjectParser.Import_as_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#import_as_name}.
	 * @param ctx the parse tree
	 */
	void exitImport_as_name(ProjectParser.Import_as_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#global_stmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_stmt(ProjectParser.Global_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#global_stmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_stmt(ProjectParser.Global_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(ProjectParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(ProjectParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(ProjectParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(ProjectParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(ProjectParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(ProjectParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDefStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefStmt(ProjectParser.FuncDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDefStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefStmt(ProjectParser.FuncDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(ProjectParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(ProjectParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTryStmt(ProjectParser.TryStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTryStmt(ProjectParser.TryStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code withStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWithStmt(ProjectParser.WithStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code withStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWithStmt(ProjectParser.WithStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decoratedStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDecoratedStmt(ProjectParser.DecoratedStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decoratedStmt}
	 * labeled alternative in {@link ProjectParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDecoratedStmt(ProjectParser.DecoratedStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#decorated}.
	 * @param ctx the parse tree
	 */
	void enterDecorated(ProjectParser.DecoratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#decorated}.
	 * @param ctx the parse tree
	 */
	void exitDecorated(ProjectParser.DecoratedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(ProjectParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(ProjectParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(ProjectParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(ProjectParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(ProjectParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(ProjectParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(ProjectParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(ProjectParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(ProjectParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(ProjectParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ProjectParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ProjectParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void enterTypedargslist(ProjectParser.TypedargslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void exitTypedargslist(ProjectParser.TypedargslistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#tfpdef}.
	 * @param ctx the parse tree
	 */
	void enterTfpdef(ProjectParser.TfpdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#tfpdef}.
	 * @param ctx the parse tree
	 */
	void exitTfpdef(ProjectParser.TfpdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(ProjectParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(ProjectParser.ClassdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTry_stmt(ProjectParser.Try_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTry_stmt(ProjectParser.Try_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWith_stmt(ProjectParser.With_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWith_stmt(ProjectParser.With_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#with_item}.
	 * @param ctx the parse tree
	 */
	void enterWith_item(ProjectParser.With_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#with_item}.
	 * @param ctx the parse tree
	 */
	void exitWith_item(ProjectParser.With_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(ProjectParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(ProjectParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(ProjectParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(ProjectParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjectParser#testlist}.
	 * @param ctx the parse tree
	 */
	void enterTestlist(ProjectParser.TestlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjectParser#testlist}.
	 * @param ctx the parse tree
	 */
	void exitTestlist(ProjectParser.TestlistContext ctx);
}