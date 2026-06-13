package VisitorFlask;
import ASTFlask.AtomExpression.*;
import ASTFlask.Proge;
import ASTFlask.Statment;
import ASTFlask.TheMainContintOfComplexStatment.*;
import ASTFlask.TheMainContintOfSimpleStatment.*;
import ASTFlask.TheMainExpressionStatment.AnnassignColon;
import ASTFlask.TheMainExpressionStatment.AugassignEqual;
import ASTFlask.TheMainExpressionStatment.Testlist_Start_ExpressionEqual;
import ASTFlask.TheMainExpressionStatment.Testlist_star_expr;
import antlrFlask.ProjectParser;
import antlrFlask.ProjectParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class Visitor extends ProjectParserBaseVisitor {
    @Override
    public Object visitProgeRoot(ProjectParser.ProgeRootContext ctx) {
        List<Statment> statements = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            org.antlr.v4.runtime.tree.ParseTree child = ctx.getChild(i);

            if (child instanceof TerminalNode) {
                continue;
            }
            Object result = visit(child);

            if (result instanceof Statment st) {
                statements.add(st);
            } else if (result instanceof List<?> list) {
                for (Object item : list) {
                    if (item instanceof Statment st) {
                        statements.add(st);
                    }
                }
            }
            else if (result instanceof DecoratedStatmentOfFunction decorated) {
                statements.add(decorated);
            }
        }

        return new Proge(statements, ctx.getStart().getLine());
    }


    @Override
    public Object visitSimpleStatement(ProjectParser.SimpleStatementContext ctx) {
        List<Statment> statements = new ArrayList<>();

        for (ProjectParser.Small_stmtContext sctx : ctx.simple_stmt().small_stmt()) {
            Statment stmt = (Statment) visit(sctx);
            if (stmt != null) statements.add(stmt);
        }

        return statements;
    }

    @Override
    public Object visitCompoundStatement(ProjectParser.CompoundStatementContext ctx) {
        return visit(ctx.compound_stmt());
    }

    @Override
    public Object visitExprStatement(ProjectParser.ExprStatementContext ctx) {
        return visit(ctx.expr_stmt());
    }

    @Override
    public Object visitDelStatement(ProjectParser.DelStatementContext ctx) {
        int line = ctx.getStart().getLine();
        List<ExpressionAtom> elements = new ArrayList<>();
        if (ctx.del_stmt().exprlist() != null) {
            for (ProjectParser.TestContext t : ctx.del_stmt().exprlist().test()) {
                elements.add((ExpressionAtom) visit(t));
            }
        }
        return new DeleteStatment(elements, line);
    }

    @Override
    public Object visitPassStatement(ProjectParser.PassStatementContext ctx) {
        return new PassStatment(ctx.getStart().getLine());
    }

    @Override
    public Object visitFlowStatement(ProjectParser.FlowStatementContext ctx) {
        int line = ctx.getStart().getLine();
        if (ctx.flow_stmt().BREAK() != null) return new FlowBreak(line);
        if (ctx.flow_stmt().CONTINUE() != null) return new FlowCountinue(line);
        if (ctx.flow_stmt().RETURN() != null) {
            List<ExpressionAtom> values = new ArrayList<>();
            if (ctx.flow_stmt().testlist() != null) {
                for (ProjectParser.TestContext testCtx : ctx.flow_stmt().testlist().test()) {
                    values.add((ExpressionAtom) visit(testCtx));
                }
            }
            return new FlowReturn(values, line);
        }
        return null;
    }

    @Override
    public Object visitImportStatement(ProjectParser.ImportStatementContext ctx) {
        int line = ctx.getStart().getLine();
        ProjectParser.Import_stmtContext stmt = ctx.import_stmt();
        List<ImportItem> items = new ArrayList<>();

        if (stmt.dotted_as_names() != null) {
            for (ProjectParser.Dotted_as_nameContext nctx : stmt.dotted_as_names().dotted_as_name()) {
                String name = nctx.dotted_name().getText();
                String alias = (nctx.AS() != null) ? nctx.NAME().getText() : null;
                items.add(new ImportItem(name, alias, line));
            }
            return new ImportName(items, line);
        }

        String module = stmt.dotted_name().getText();
        if (stmt.STAR() != null) items.add(new ImportItem("*", null, line));
        else if (stmt.import_as_names() != null) {
            for (ProjectParser.Import_as_nameContext ictx : stmt.import_as_names().import_as_name()) {
                String name = ictx.NAME(0).getText();
                String alias = (ictx.AS() != null) ? ictx.NAME(1).getText() : null;
                items.add(new ImportItem(name, alias, line));
            }
        }
        return new ImportFrom(module, items, line);
    }

    @Override
    public Object visitGlobalStatement(ProjectParser.GlobalStatementContext ctx) {
        int line = ctx.getStart().getLine();
        List<String> names = new ArrayList<>();
        for (int i = 0; ; i++) {
            TerminalNode nameNode = ctx.getToken(ProjectParser.NAME, i);
            if (nameNode == null) break;
            names.add(nameNode.getText());
        }
        return new GlobalStatment(names, line);
    }

    @Override
    public Object visitExprStmt(ProjectParser.ExprStmtContext ctx) {
        int line = ctx.getStart().getLine();

        var left = (ExpressionAtom) visit(ctx.testlist_star_expr(0));

        if (ctx.annAssign() != null) {
            return visit(ctx.annAssign());
        }

        if (ctx.augassign() != null) {
            ExpressionAtom value = (ExpressionAtom) visit(ctx.testlist_star_expr(1));
            String op = ctx.augassign().getText();
            return new AugassignEqual(left, op, value, line);
        }

        if (ctx.EQ() != null) {
            ExpressionAtom value = (ExpressionAtom) visit(ctx.testlist_star_expr(1));
            return new Testlist_Start_ExpressionEqual(left, value, line);
        }

        return new Testlist_star_expr(left, line);
    }

    @Override
    public Object visitAnnotatedAssign(ProjectParser.AnnotatedAssignContext ctx) {
        int line = ctx.getStart().getLine();

        ExpressionAtom target = (ExpressionAtom) visit(((ProjectParser.ExprStmtContext) ctx.getParent()).testlist_star_expr(0));

        ExpressionAtom value = null;
        if (ctx.test().size() > 1) value = (ExpressionAtom) visit(ctx.test(1));
        return new AnnassignColon(target, value, line);
    }

    @Override
    public Object visitAugassign(ProjectParser.AugassignContext ctx) {
        int line = ctx.getStart().getLine();
        String op = ctx.getText();
        ProjectParser.Expr_stmtContext parent = (ProjectParser.Expr_stmtContext) ctx.getParent();
        ExpressionAtom target = (ExpressionAtom) visit(parent.getChild(0));
        ExpressionAtom value = (ExpressionAtom) visit(parent.getChild(2));
        return new AugassignEqual(target, op, value, line);
    }

    @Override
    public Object visitTestlist_star_expr(ProjectParser.Testlist_star_exprContext ctx) {
        List<ExpressionAtom> exprs = new ArrayList<>();
        for (ProjectParser.TestContext tctx : ctx.test()) {
            exprs.add((ExpressionAtom) visit(tctx));
        }

        if (ctx.comp_for() != null) {

            return exprs.get(0);
        }

        if (exprs.size() == 1) {
            return exprs.get(0);
        } else {
            return new ListExprssion(exprs, ctx.getStart().getLine());
        }
    }

    @Override
    public Object visitTest(ProjectParser.TestContext ctx) {
        int line = ctx.getStart().getLine();
        if (ctx.IF() != null) {
            ExpressionAtom cond = (ExpressionAtom) visit(ctx.or_test(1));
            ExpressionAtom thenExpr = (ExpressionAtom) visit(ctx.or_test(0));
            ExpressionAtom elseExpr = (ExpressionAtom) visit(ctx.test());
            return new ThreeConditionExprssion(thenExpr, cond, elseExpr, line);
        } else return visit(ctx.or_test(0));
    }

    @Override
    public Object visitOr_test(ProjectParser.Or_testContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionAtom left = (ExpressionAtom) visit(ctx.and_test(0));
        for (int i = 1; i < ctx.and_test().size(); i++) {
            ExpressionAtom right = (ExpressionAtom) visit(ctx.and_test(i));
            left = new TwoOperationExprssion(left, "or", right, line);
        }
        return left;
    }

    @Override
    public Object visitAnd_test(ProjectParser.And_testContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionAtom left = (ExpressionAtom) visit(ctx.not_test(0));
        for (int i = 1; i < ctx.not_test().size(); i++) {
            ExpressionAtom right = (ExpressionAtom) visit(ctx.not_test(i));
            left = new TwoOperationExprssion(left, "and", right, line);
        }
        return left;
    }

    @Override
    public Object visitNot_test(ProjectParser.Not_testContext ctx) {
        int line = ctx.getStart().getLine();
        if (ctx.NOT() != null) {
            ExpressionAtom expr = (ExpressionAtom) visit(ctx.not_test());
            return new OneOperationExprssion("not", expr, line);
        } else return visit(ctx.comparison());
    }

    @Override
    public Object visitComparison(ProjectParser.ComparisonContext ctx) {
        int line = ctx.getStart().getLine();

        ExpressionAtom left = (ExpressionAtom) visit(ctx.arith_expr(0));

        if (ctx.comp_op().isEmpty()) {
            return left;
        }

        List<String> ops = new ArrayList<>();
        List<ExpressionAtom> rights = new ArrayList<>();

        for (int i = 0; i < ctx.comp_op().size(); i++) {
            String op = (String) visit(ctx.comp_op(i));
            ExpressionAtom right = (ExpressionAtom) visit(ctx.arith_expr(i + 1));
            ops.add(op);
            rights.add(right);
        }

        return new CompareExprssion(left, ops, rights, line);
    }

    @Override
    public Object visitComp_op(ProjectParser.Comp_opContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitFactor(ProjectParser.FactorContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.PLUS() != null || ctx.MINUS() != null || ctx.TILDE() != null) {
            String op = ctx.getChild(0).getText();
            ExpressionAtom expr = (ExpressionAtom) visit(ctx.factor());
            return new OneOperationExprssion(op, expr, line);
        } else {
            return visit(ctx.power());
        }
    }


    @Override
    public Object visitPower(ProjectParser.PowerContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionAtom base = (ExpressionAtom) visit(ctx.atom_expr());
        if (ctx.factor() != null) {
            ExpressionAtom exponent = (ExpressionAtom) visit(ctx.factor());
            return new PowerExprssion(base, exponent, line);
        }
        return base;
    }

    @Override
    public Object visitTerm(ProjectParser.TermContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionAtom left = (ExpressionAtom) visit(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.getChild(2*i - 1).getText();
            ExpressionAtom right = (ExpressionAtom) visit(ctx.factor(i));
            left = new TwoOperationExprssion(left, op, right, line);
        }

        return left;
    }

    @Override
    public Object visitArith_expr(ProjectParser.Arith_exprContext ctx) {
        int line = ctx.getStart().getLine();
        ExpressionAtom left = (ExpressionAtom) visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.getChild(2*i - 1).getText();
            ExpressionAtom right = (ExpressionAtom) visit(ctx.term(i));
            left = new TwoOperationExprssion(left, op, right, line);
        }

        return left;
    }
    @Override
    public Object visitAtom_expr(ProjectParser.Atom_exprContext ctx) {
        ExpressionAtom value = (ExpressionAtom) visit(ctx.atom());

        for (ProjectParser.TrailerContext t : ctx.trailer()) {
            value = processTrailer(value, t);
        }

        return value;
    }

    private ExpressionAtom processTrailer(ExpressionAtom object, ProjectParser.TrailerContext t) {
        int line = t.getStart().getLine();

        if (t instanceof ProjectParser.DotTrailerContext dot) {
            String property = dot.NAME().getText();
            return new AttributeOfVariable(object, property, line);
        }

        else if (t instanceof ProjectParser.SubscriptTrailerContext sub) {
            Object result = visit(sub);
            if (result instanceof List<?> subs) {
                for (Object subObj : subs) {
                    if (subObj instanceof ExpressionAtom index) {
                        object = new SubscriptOfAree(object, new SliceTowSubscriptOfAree(index, null, null, line), line);
                    } else if (subObj instanceof SliceTowSubscriptOfAree slice) {
                        object = new SubscriptOfAree(object, slice, line);
                    }
                }
            }
            return object;
        }

        else if (t instanceof ProjectParser.CallTrailerContext call) {
            List<ExpressionAtom> args = new ArrayList<>();
            if (call.arglist() != null) {
                Object result = visit(call.arglist());
                if (result instanceof List<?> list) {
                    for (Object o : list) {
                        if (o instanceof ExpressionAtom e) args.add(e);
                    }
                }
            }
            return new CallExprssion(object, args, line);
        }

        return object;
    }

    @Override
    public Object visitAtomParen(ProjectParser.AtomParenContext ctx) {
        int line = ctx.getStart().getLine();
        List<ExpressionAtom> items = new ArrayList<>();

        if (ctx.testlist_comp() != null) {
            Object result = visit(ctx.testlist_comp());

            if (result instanceof ComplexListOfFor) {
                ComplexListOfFor comp = (ComplexListOfFor) result;

                if (comp.type == TypeOfFor_Complex.GENERATOR) {
                    List<ExpressionAtom> compList = new ArrayList<>();
                    compList.add(comp);
                    return new TupleExprssion(compList, line);
                }

                items.add(comp);
                return new TupleExprssion(items, line);
            }

            if (result instanceof List<?> list) {
                for (Object o : list) {
                    if (o instanceof ExpressionAtom e) {
                        items.add(e);
                    }
                }
            } else if (result instanceof ExpressionAtom e) {
                items.add(e);
            }
        }

        return new TupleExprssion(items, line);
    }

    @Override
    public Object visitAtomList(ProjectParser.AtomListContext ctx) {
        int line = ctx.getStart().getLine();
        List<ExpressionAtom> items = new ArrayList<>();

        if (ctx.listmaker() != null) {
            Object result = visit(ctx.listmaker());

            if (result instanceof ComplexListOfFor) {
                ComplexListOfFor comp = (ComplexListOfFor) result;


                if (comp.type != TypeOfFor_Complex.LIST) {
                    comp.type = TypeOfFor_Complex.LIST;
                }


                return comp;
            }

            if (result instanceof List<?> list) {
                for (Object o : list) {
                    if (o instanceof ExpressionAtom e) {
                        items.add(e);
                    }
                }
            } else if (result instanceof ExpressionAtom e) {
                items.add(e);
            }
        }

        return new ListExprssion(items, line);
    }

    @Override
    public Object visitAtomDict(ProjectParser.AtomDictContext ctx) {
        int line = ctx.getStart().getLine();
        List<ExpressionAtom> keys = new ArrayList<>();
        List<ExpressionAtom> values = new ArrayList<>();

        if (ctx.dictmaker() != null) {
            Object result = visit(ctx.dictmaker());


            if (result instanceof ComplexListOfFor) {
                ComplexListOfFor comp = (ComplexListOfFor) result;
                if (comp.type != TypeOfFor_Complex.DICT) {
                    comp.type = TypeOfFor_Complex.DICT;
                }

                return comp;
            }

            if (result instanceof Map<?, ?> map) {
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    if (entry.getKey() instanceof ExpressionAtom) {
                        keys.add((ExpressionAtom) entry.getKey());
                    }
                    if (entry.getValue() instanceof ExpressionAtom) {
                        values.add((ExpressionAtom) entry.getValue());
                    }
                }
            }
        }

        return new DictionaryExprssion(keys, values, line);
    }

    @Override
    public Object visitAtomName(ProjectParser.AtomNameContext ctx) {
        int line = ctx.getStart().getLine();
        String name = ctx.getText();
        return new NameExpression(name, line);
    }

    @Override
    public Object visitAtomNumber(ProjectParser.AtomNumberContext ctx) {
        int line = ctx.getStart().getLine();
        String value = ctx.getText();
        return new NumberExpression(value, line);
    }

    @Override
    public Object visitAtomString(ProjectParser.AtomStringContext ctx) {
        int line = ctx.getStart().getLine();
        String value = ctx.getText();
        return new StringExpression(value, line);
    }

    @Override
    public Object visitAtomFString(ProjectParser.AtomFStringContext ctx) {
        int line = ctx.getStart().getLine();
        String value = ctx.getText();
        return new FStringExpression(value, line);
    }

    @Override
    public Object visitAtomTrue(ProjectParser.AtomTrueContext ctx) {
        int line = ctx.getStart().getLine();
        return new BooleanExpression(true, line);
    }

    @Override
    public Object visitAtomFalse(ProjectParser.AtomFalseContext ctx) {
        int line = ctx.getStart().getLine();
        return new BooleanExpression(false, line);
    }

    @Override
    public Object visitAtomNone(ProjectParser.AtomNoneContext ctx) {
        int line = ctx.getStart().getLine();
        return new NoneExpression(line);
    }
    @Override
    public Object visitCallTrailer(ProjectParser.CallTrailerContext ctx) {
        List<ExpressionAtom> args = new ArrayList<>();
        if (ctx.arglist() != null) {
            Object result = visit(ctx.arglist());
            if (result instanceof List<?> list) {
                for (Object o : list) {
                    if (o instanceof ExpressionAtom e) args.add(e);
                }
            }
        }
        return args;
    }

    @Override
    public Object visitSubscriptTrailer(ProjectParser.SubscriptTrailerContext ctx) {
        Object result = visit(ctx.subscriptlist());
        if (result instanceof List<?> list) return list;
        return new ArrayList<>();
    }

    @Override
    public Object visitDotTrailer(ProjectParser.DotTrailerContext ctx) {
        return null;
    }

    @Override
    public Object visitSubscriptlist(ProjectParser.SubscriptlistContext ctx) {
        List<Object> elements = new ArrayList<>();
        for (ProjectParser.SubscriptContext s : ctx.subscript()) {
            elements.add(visit(s));
        }
        return elements;
    }

    @Override
    public Object visitSubscript(ProjectParser.SubscriptContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.COLON() == null) {
            return visit(ctx.test(0));
        }

        ExpressionAtom start = null, end = null, step = null;
        if (ctx.test().size() >= 1) start = (ExpressionAtom) visit(ctx.test(0));
        if (ctx.test().size() >= 2) end = (ExpressionAtom) visit(ctx.test(1));
        if (ctx.test().size() == 3) step = (ExpressionAtom) visit(ctx.test(2));

        return new SliceTowSubscriptOfAree(start, end, step, line);
    }
    @Override
    public Object visitListmaker(ProjectParser.ListmakerContext ctx) {
        if (ctx.comp_for() != null) {
            ExpressionAtom body = (ExpressionAtom) visit(ctx.test(0));
            CoplexForExpression forClause = (CoplexForExpression) visit(ctx.comp_for());

            return new ComplexListOfFor(
                    TypeOfFor_Complex.LIST,
                    body,
                    Collections.singletonList(forClause),
                    ctx.getStart().getLine()
            );
        }

        List<Object> items = new ArrayList<>();
        for (var t : ctx.test()) {
            Object result = visit(t);
            if (result instanceof ExpressionAtom) {
                items.add(result);
            }
        }
        return items;
    }

    @Override
    public Object visitDictmaker(ProjectParser.DictmakerContext ctx) {
        if (ctx.comp_for() != null) {
            ExpressionAtom key = (ExpressionAtom) visit(ctx.test(0));
            ExpressionAtom value = (ExpressionAtom) visit(ctx.test(1));
            CoplexForExpression forClause = (CoplexForExpression) visit(ctx.comp_for());

            ComplexListOfFor node = new ComplexListOfFor(
                    TypeOfFor_Complex.DICT,
                    value,
                    Collections.singletonList(forClause),
                    ctx.getStart().getLine()
            );
            node.setKey(key);
            return node;
        }

        Map<Object, Object> map = new LinkedHashMap<>();
        for (int i = 0; i < ctx.test().size(); i += 2) {
            Object key = visit(ctx.test(i));
            Object value = visit(ctx.test(i + 1));
            map.put(key, value);
        }
        return map;
    }
    @Override
    public Object visitCompFor(ProjectParser.CompForContext ctx) {
        int line = ctx.getStart().getLine();

        Object targetObj = visit(ctx.exprlist());
        Object iterableObj = visit(ctx.testlist());

        ExpressionAtom target = null;
        ExpressionAtom iterable = null;

        if (targetObj instanceof List<?> targetList && !targetList.isEmpty()) {
            if (targetList.get(0) instanceof ExpressionAtom) {
                target = (ExpressionAtom) targetList.get(0);
            }
        } else if (targetObj instanceof ExpressionAtom) {
            target = (ExpressionAtom) targetObj;
        }

        if (iterableObj instanceof List<?> iterableList && !iterableList.isEmpty()) {
            if (iterableList.get(0) instanceof ExpressionAtom) {
                iterable = (ExpressionAtom) iterableList.get(0);
            }
        } else if (iterableObj instanceof ExpressionAtom) {
            iterable = (ExpressionAtom) iterableObj;
        }

        CoplexForExpression clause = new CoplexForExpression(target, iterable, new ArrayList<>(), line);

        if (ctx.test() != null && !ctx.test().isEmpty()) {
            for (var t : ctx.test()) {
                Object condObj = visit(t);
                if (condObj instanceof ExpressionAtom) {
                    clause.addCondition((ExpressionAtom) condObj);
                }
            }
        }

        return clause;
    }

    @Override
    public Object visitTestlist_comp(ProjectParser.Testlist_compContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.comp_for() != null) {
            ExpressionAtom first = (ExpressionAtom) visit(ctx.test(0));

            if (ctx.test().size() == 2) {
                ExpressionAtom key = (ExpressionAtom) visit(ctx.test(0));
                ExpressionAtom value = (ExpressionAtom) visit(ctx.test(1));

                CoplexForExpression clause = (CoplexForExpression) visit(ctx.comp_for());

                ComplexListOfFor comp = new ComplexListOfFor(
                        TypeOfFor_Complex.DICT,
                        value,
                        new ArrayList<>(),
                        line
                );
                comp.setKey(key);
                comp.addForClause(clause);

                return comp;
            }

            boolean isGenerator = false;
            if (ctx.getParent() instanceof ProjectParser.AtomParenContext) {
                isGenerator = true;
            }

            TypeOfFor_Complex type = isGenerator ? TypeOfFor_Complex.GENERATOR : TypeOfFor_Complex.LIST;

            CoplexForExpression clause = (CoplexForExpression) visit(ctx.comp_for());

            ComplexListOfFor comp = new ComplexListOfFor(type, first, new ArrayList<>(), line);
            comp.addForClause(clause);

            return comp;
        }

        List<ExpressionAtom> list = new ArrayList<>();
        for (ProjectParser.TestContext t : ctx.test()) {
            list.add((ExpressionAtom) visit(t));
        }
        return list;
    }
    @Override
    public Object visitArglist(ProjectParser.ArglistContext ctx) {
        List<Object> args = new ArrayList<>();

        for (ProjectParser.ArgumentContext argCtx : ctx.argument()) {
            Object arg = visit(argCtx);
            args.add(arg);
        }

        return args;
    }

    @Override
    public Object visitArgument(ProjectParser.ArgumentContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.test().size() == 1) {
            return visit(ctx.test(0));
        }

        Object keyObj = visit(ctx.test(0));
        Object valueObj = visit(ctx.test(1));

        String argName;
        if (keyObj instanceof NameExpression) {
            argName = ((NameExpression) keyObj).name;
        } else if (keyObj instanceof StringExpression) {
            argName = ((StringExpression) keyObj).value;
        } else {
            argName = keyObj.toString();
        }

        if (valueObj instanceof ExpressionAtom) {
            return new NameArgumentExpr(argName, (ExpressionAtom) valueObj, line);
        }

        return null;
    }

    @Override
    public Object visitDecorator(ProjectParser.DecoratorContext ctx) {
        int line = ctx.getStart().getLine();

        String decoratorName = ctx.dotted_name().getText();
        ExpressionAtom name = new NameExpression(decoratorName, line);

        List<ExpressionAtom> args = null;
        if (ctx.arglist() != null) {
            Object argsObj = visit(ctx.arglist());
            if (argsObj instanceof List<?>) {
                args = new ArrayList<>();
                for (Object a : (List<?>) argsObj) {
                    if (a instanceof ExpressionAtom) {
                        args.add((ExpressionAtom) a);
                    }
                }
            }
        }

        return new DecoratorOfFunction(name, args, line);
    }

    @Override
    public Object visitDecorated(ProjectParser.DecoratedContext ctx) {
        int line = ctx.getStart().getLine();

        List<DecoratorOfFunction> decorators = new ArrayList<>();
        for (ProjectParser.DecoratorContext decCtx : ctx.decorator()) {
            Object decObj = visit(decCtx);
            if (decObj instanceof DecoratorOfFunction) {
                decorators.add((DecoratorOfFunction) decObj);
            }
        }

        Statment stmt = null;

        if (ctx.funcdef() != null) {
            ProjectParser.FuncdefContext funcCtx = ctx.funcdef();
            String funcName = funcCtx.NAME().getText();

            List<ParametarToFunction> parameters = new ArrayList<>();
            if (funcCtx.parameters() != null) {
                Object p = visit(funcCtx.parameters());
                if (p instanceof List<?> list) {
                    for (Object item : list)
                        if (item instanceof ParametarToFunction param)
                            parameters.add(param);
                }
            }

            ExpressionAtom returnType = null;
            if (funcCtx.ARROW() != null && funcCtx.test() != null) {
                returnType = (ExpressionAtom) visit(funcCtx.test());
            }

            List<Statment> body = new ArrayList<>();
            if (funcCtx.suite() != null) {
                Object r = visit(funcCtx.suite());
                if (r instanceof List<?> list) {
                    for (Object s : list)
                        if (s instanceof Statment st)
                            body.add(st);
                }
            }

            stmt = new FounctionStatment(funcName, parameters, returnType, body, line);

        } else if (ctx.classdef() != null) {
            Object cObj = visit(ctx.classdef());
            if (cObj instanceof Statment) {
                stmt = (Statment) cObj;
            }
        }

        return new DecoratedStatmentOfFunction(decorators, stmt, line);
    }
    @Override
    public Object visitIf_stmt(ProjectParser.If_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        ExpressionAtom condition = null;
        Object condObj = visit(ctx.test(0));
        if (condObj instanceof ExpressionAtom) {
            condition = (ExpressionAtom) condObj;
        }

        List<Statment> body = new ArrayList<>();
        Object bodyResult = visit(ctx.suite(0));
        if (bodyResult instanceof List<?>) {
            for (Object stmt : (List<?>) bodyResult)
                if (stmt instanceof Statment) body.add((Statment) stmt);
        }

        List<ElifStatment> elifs = new ArrayList<>();
        int elifCount = ctx.ELIF().size();
        for (int i = 0; i < elifCount; i++) {
            ExpressionAtom elifCond = null;
            Object elifCondObj = visit(ctx.test(i + 1));
            if (elifCondObj instanceof ExpressionAtom) {
                elifCond = (ExpressionAtom) elifCondObj;
            }

            List<Statment> elifBody = new ArrayList<>();
            Object elifBodyResult = visit(ctx.suite(i + 1));
            if (elifBodyResult instanceof List<?>) {
                for (Object stmt : (List<?>) elifBodyResult)
                    if (stmt instanceof Statment) elifBody.add((Statment) stmt);
            }

            elifs.add(new ElifStatment(elifCond, elifBody, ctx.ELIF(i).getSymbol().getLine()));
        }

        List<Statment> elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = new ArrayList<>();
            Object elseResult = visit(ctx.suite(ctx.suite().size() - 1));
            if (elseResult instanceof List<?>) {
                for (Object stmt : (List<?>) elseResult)
                    if (stmt instanceof Statment) elseBody.add((Statment) stmt);
            }
        }

        return new IfStatment(condition, body, elifs, elseBody, line);
    }
    @Override
    public Object visitWhile_stmt(ProjectParser.While_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        ExpressionAtom condition = null;
        Object condObj = visit(ctx.test());
        if (condObj instanceof ExpressionAtom) {
            condition = (ExpressionAtom) condObj;
        }

        List<Statment> body = new ArrayList<>();
        Object bodyResult = visit(ctx.suite(0));
        if (bodyResult instanceof List<?>) {
            for (Object stmt : (List<?>) bodyResult)
                if (stmt instanceof Statment) body.add((Statment) stmt);
        }

        List<Statment> elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = new ArrayList<>();
            Object elseResult = visit(ctx.suite(1));
            if (elseResult instanceof List<?>) {
                for (Object stmt : (List<?>) elseResult)
                    if (stmt instanceof Statment) elseBody.add((Statment) stmt);
            }
        }

        return new WhileStatment(
                condition,
                body,
                elseBody,
                line
        );
    }

    @Override
    public Object visitFor_stmt(ProjectParser.For_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        ExpressionAtom target = null;
        Object targetObj = visit(ctx.exprlist());
        if (targetObj instanceof ExpressionAtom) {
            target = (ExpressionAtom) targetObj;
        }

        ExpressionAtom iterable = null;
        Object iterableObj = visit(ctx.testlist());
        if (iterableObj instanceof ExpressionAtom) {
            iterable = (ExpressionAtom) iterableObj;
        }

        List<Statment> body = new ArrayList<>();
        Object bodyResult = visit(ctx.suite(0));
        if (bodyResult instanceof List<?>) {
            for (Object stmt : (List<?>) bodyResult)
                if (stmt instanceof Statment) body.add((Statment) stmt);
        }

        List<Statment> elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = new ArrayList<>();
            Object elseResult = visit(ctx.suite(1));
            if (elseResult instanceof List<?>) {
                for (Object stmt : (List<?>) elseResult)
                    if (stmt instanceof Statment) elseBody.add((Statment) stmt);
            }
        }

        return new ForStatment(
                target,
                iterable,
                body,
                elseBody,
                line
        );
    }
    @Override
    public Object visitFuncdef(ProjectParser.FuncdefContext ctx) {
        String funcName = ctx.NAME().getText();
        int line = ctx.getStart().getLine();

        List<ParametarToFunction> parameters = new ArrayList<>();
        if (ctx.parameters() != null) {
            Object p = visit(ctx.parameters());
            if (p instanceof List<?> list) {
                for (Object item : list)
                    if (item instanceof ParametarToFunction param)
                        parameters.add(param);
            }
        }

        ExpressionAtom returnType = null;
        if (ctx.ARROW() != null && ctx.test() != null) {
            returnType = (ExpressionAtom) visit(ctx.test());
        }

        List<Statment> body = new ArrayList<>();
        if (ctx.suite() != null) {
            Object r = visit(ctx.suite());
            if (r instanceof List<?> list) {
                for (Object s : list)
                    if (s instanceof Statment st)
                        body.add(st);
            }
        }

        return new FounctionStatment(funcName, parameters, returnType, body, line);
    }
    @Override
    public Object visitFuncDefStmt(ProjectParser.FuncDefStmtContext ctx) {

        String funcName = ctx.funcdef().NAME().getText();

        List<ParametarToFunction> parameters = new ArrayList<>();
        if (ctx.funcdef().parameters() != null) {
            Object p = visit(ctx.funcdef().parameters());
            if (p instanceof List<?> list) {
                for (Object item : list)
                    if (item instanceof ParametarToFunction param)
                        parameters.add(param);
            }
        }

        ExpressionAtom returnType = null;
        if (ctx.funcdef().ARROW() != null && ctx.funcdef().test() != null) {
            returnType = (ExpressionAtom) visit(ctx.funcdef().test());
        }

        List<Statment> body = new ArrayList<>();
        if (ctx.funcdef().suite() != null) {
            Object r = visit(ctx.funcdef().suite());
            if (r instanceof List<?> list) {
                for (Object s : list)
                    if (s instanceof Statment st)
                        body.add(st);
            }
        }

        int line = ctx.getStart().getLine();

        return new FounctionStatment(
                funcName,
                parameters,
                returnType,
                body,
                line
        );
    }

    @Override
    public Object visitParameters(ProjectParser.ParametersContext ctx) {
        if (ctx.typedargslist() != null) {
            return visit(ctx.typedargslist());
        }
        return new ArrayList<ParametarToFunction>();
    }

    @Override
    public Object visitTypedargslist(ProjectParser.TypedargslistContext ctx) {
        List<ParametarToFunction> params = new ArrayList<>();

        for (int i = 0; i < ctx.tfpdef().size(); i++) {
            ProjectParser.TfpdefContext tfp = ctx.tfpdef(i);
            ParametarToFunction param = (ParametarToFunction) visit(tfp);

            if (ctx.EQ(i) != null) {
                ExpressionAtom defaultValue = (ExpressionAtom) visit(ctx.test(i));
                param.defaultValue = defaultValue;
            }

            params.add(param);
        }

        return params;
    }

    @Override
    public Object visitTfpdef(ProjectParser.TfpdefContext ctx) {
        String name = ctx.NAME().getText();
        int line = ctx.getStart().getLine();

        ExpressionAtom type = null;
        if (ctx.test() != null) {
            type = (ExpressionAtom) visit(ctx.test());
        }

        return new ParametarToFunction(name, type, null, line);
    }

    @Override
    public Object visitClassDefinition(ProjectParser.ClassDefinitionContext ctx) {

        String className = ctx.classdef().NAME().getText();

        List<ExpressionAtom> bases = new ArrayList<>();
        if (ctx.classdef().arglist() != null) {
            Object r = visit(ctx.classdef().arglist());
            if (r instanceof List<?> list) {
                for (Object base : list)
                    if (base instanceof ExpressionAtom) bases.add((ExpressionAtom) base);
            }
        }

        List<Statment> body = new ArrayList<>();
        Object b = visit(ctx.classdef().suite());
        if (b instanceof List<?> list) {
            for (Object item : list)
                if (item instanceof Statment st) body.add(st);
        }

        int line = ctx.getStart().getLine();

        return new ClassStatment(className, bases, body, line);
    }

    @Override
    public Object visitTry_stmt(ProjectParser.Try_stmtContext ctx) {

        int line = ctx.getStart().getLine();

        List<Statment> body = new ArrayList<>();
        Object result = visit(ctx.suite(0));
        if (result instanceof List<?>) {
            for (Object stmt : (List<?>) result) {
                if (stmt instanceof Statment) body.add((Statment) stmt);
            }
        }

        List<CatchStatment> handlers = new ArrayList<>();
        int handlerCount = ctx.EXCEPT().size();

        for (int i = 0; i < handlerCount; i++) {

            ExpressionAtom exceptionType = null;
            String exceptionVar = null;
            int suiteIndex = 1 + i;

            if (ctx.test(i) != null) {
                exceptionType = (ExpressionAtom) visit(ctx.test(i));

                if (ctx.NAME(i) != null) {
                    exceptionVar = ctx.NAME(i).getText();
                }
            }

            List<Statment> handlerBody = new ArrayList<>();
            result = visit(ctx.suite(suiteIndex));
            if (result instanceof List<?>) {
                for (Object stmt : (List<?>) result) {
                    if (stmt instanceof Statment) handlerBody.add((Statment) stmt);
                }
            }

            handlers.add(new CatchStatment(
                    exceptionType,
                    exceptionVar,
                    handlerBody,
                    ctx.EXCEPT(i).getSymbol().getLine()
            ));
        }

        List<Statment> elseBody = null;
        List<Statment> finallyBody = null;
        int suiteCount = ctx.suite().size();

        if (suiteCount > handlerCount + 1) {
            int lastSuiteIndex = suiteCount - 1;

            if (ctx.FINALLY() != null) {
                finallyBody = new ArrayList<>();
                result = visit(ctx.suite(lastSuiteIndex));
                if (result instanceof List<?>) {
                    for (Object stmt : (List<?>) result)
                        if (stmt instanceof Statment) finallyBody.add((Statment) stmt);
                }
            } else if (ctx.ELSE() != null) {
                elseBody = new ArrayList<>();
                result = visit(ctx.suite(lastSuiteIndex));
                if (result instanceof List<?>) {
                    for (Object stmt : (List<?>) result)
                        if (stmt instanceof Statment) elseBody.add((Statment) stmt);
                }
            }
        }

        return new TryStatment(body, handlers, elseBody, finallyBody, line);
    }

    @Override
    public Object visitWith_item(ProjectParser.With_itemContext ctx) {

        ExpressionAtom contextExpr = (ExpressionAtom) visit(ctx.test(0));

        ExpressionAtom optionalVar = null;
        if (ctx.test().size() > 1) {
            optionalVar = (ExpressionAtom) visit(ctx.test(1));
        }

        int line = ctx.getStart().getLine();

        return new WithItemStatment(contextExpr, optionalVar, line);
    }
    @Override
    public Object visitWith_stmt(ProjectParser.With_stmtContext ctx) {

        List<WithItemStatment> items = new ArrayList<>();
        for (ProjectParser.With_itemContext itemCtx : ctx.with_item()) {
            WithItemStatment wi = (WithItemStatment) visit(itemCtx);
            items.add(wi);
        }

        List<Statment> body = new ArrayList<>();
        if (ctx.suite() != null) {
            Object suiteResult = visit(ctx.suite());
            if (suiteResult instanceof List<?>) {
                for (Object st : (List<?>) suiteResult) {
                    if (st instanceof Statment) {
                        body.add((Statment) st);
                    }
                }
            }
        }

        int line = ctx.getStart().getLine();
        return new WithStatment(items, body, line);
    }

    @Override
    public Object visitSuite(ProjectParser.SuiteContext ctx) {
        List<Statment> statements = new ArrayList<>();

        if (ctx.simple_stmt() != null) {
            Object result = visit(ctx.simple_stmt());
            if (result instanceof Statment) {
                statements.add((Statment) result);
            } else if (result instanceof List<?>) {
                for (Object o : (List<?>) result) {
                    if (o instanceof Statment) {
                        statements.add((Statment) o);
                    }
                }
            }
            return statements;
        }

        for (ProjectParser.StatementContext sctx : ctx.statement()) {
            Object result = visit(sctx);
            if (result instanceof Statment) {
                statements.add((Statment) result);
            } else if (result instanceof List<?>) {
                for (Object o : (List<?>) result) {
                    if (o instanceof Statment) {
                        statements.add((Statment) o);
                    }
                }
            }
        }

        return statements;
    }

    @Override
    public Object visitExprlist(ProjectParser.ExprlistContext ctx) {
        List<ExpressionAtom> exprs = new ArrayList<>();

        for (ProjectParser.TestContext testCtx : ctx.test()) {
            Object result = visit(testCtx);
            if (result instanceof ExpressionAtom) {
                exprs.add((ExpressionAtom) result);
            }
        }

        if (exprs.size() == 1) {
            return exprs.get(0);
        }

        return exprs;
    }

    @Override
    public Object visitTestlist(ProjectParser.TestlistContext ctx) {
        List<ExpressionAtom> exprs = new ArrayList<>();

        for (ProjectParser.TestContext testCtx : ctx.test()) {
            Object result = visit(testCtx);
            if (result instanceof ExpressionAtom) {
                exprs.add((ExpressionAtom) result);
            }
        }

        if (exprs.size() == 1) {
            return exprs.get(0);
        }

        return exprs;
    }

}