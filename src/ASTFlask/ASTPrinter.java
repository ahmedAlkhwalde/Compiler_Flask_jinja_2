package ASTFlask;

import ASTFlask.AtomExpression.*;
import ASTFlask.TheMainContintOfComplexStatment.*;
import ASTFlask.TheMainContintOfSimpleStatment.*;
import ASTFlask.TheMainExpressionStatment.AnnassignColon;
import ASTFlask.TheMainExpressionStatment.AugassignEqual;
import ASTFlask.TheMainExpressionStatment.Testlist_Start_ExpressionEqual;
import ASTFlask.TheMainExpressionStatment.Testlist_star_expr;

public class ASTPrinter {

    public static String printTree(Proge program) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ABSTRACT SYNTAX TREE ===\n");
        sb.append("Total statements: ").append(program.statements.size()).append("\n");
        sb.append("============================\n");

        for (int i = 0; i < program.statements.size(); i++) {
            sb.append("\n").append(i + 1).append(". ");
            printStatement(program.statements.get(i), sb, 0);
        }

        return sb.toString();
    }

    public static void printStatement(Statment stmt, StringBuilder sb, int depth) {
        String indent = "  ".repeat(depth);
        String nodeType = stmt.getClass().getSimpleName();

        sb.append(indent).append("└─ ").append(nodeType)
                .append(" [line ").append(stmt.getLine()).append("]\n");

        printStatementDetails(stmt, sb, depth + 1);
    }

    public static void printStatementDetails(Statment stmt, StringBuilder sb, int depth) {
        String indent = "  ".repeat(depth);
        String nodeType = stmt.getClass().getSimpleName();

        try {
            switch (nodeType) {

                case "ImportName":
                    ImportName importStmt = (ImportName) stmt;
                    sb.append(indent).append("├─ Type: import\n");
                    sb.append(indent).append("├─ Items (").append(importStmt.items.size()).append("):\n");
                    for (ImportItem item : importStmt.items) {
                        sb.append(indent).append("│  └─ ");
                        if (item.alias != null) {
                            sb.append(item.name).append(" as ").append(item.alias);
                        } else {
                            sb.append(item.name);
                        }
                        sb.append("\n");
                    }
                    break;

                case "ImportFrom":
                    ImportFrom importFrom = (ImportFrom) stmt;
                    sb.append(indent).append("├─ Type: from ... import\n");
                    sb.append(indent).append("├─ Module: ").append(importFrom.module).append("\n");
                    sb.append(indent).append("├─ Items (").append(importFrom.items.size()).append("):\n");
                    for (ImportItem item : importFrom.items) {
                        sb.append(indent).append("│  └─ ");
                        if (item.alias != null) {
                            sb.append(item.name).append(" as ").append(item.alias);
                        } else {
                            sb.append(item.name);
                        }
                        sb.append("\n");
                    }
                    break;

                case "Testlist_Start_ExpressionEqual":
                    Testlist_Start_ExpressionEqual assign = (Testlist_Start_ExpressionEqual) stmt;
                    sb.append(indent).append("├─ Type: assignment\n");
                    sb.append(indent).append("├─ Target:\n");
                    printExpression(assign.target, sb, depth + 2);
                    sb.append(indent).append("└─ Value:\n");
                    printExpression(assign.value, sb, depth + 2);
                    break;

                case "AugassignEqual":
                    AugassignEqual augAssign = (AugassignEqual) stmt;
                    sb.append(indent).append("├─ Type: augmented assignment\n");
                    sb.append(indent).append("├─ Operator: ").append(augAssign.operator).append("\n");
                    sb.append(indent).append("├─ Target:\n");
                    printExpression(augAssign.target, sb, depth + 2);
                    sb.append(indent).append("└─ Value:\n");
                    printExpression(augAssign.value, sb, depth + 2);
                    break;

                case "AnnassignColon":
                    AnnassignColon annAssign = (AnnassignColon) stmt;
                    sb.append(indent).append("├─ Type: annotated assignment\n");
                    sb.append(indent).append("├─ Target:\n");
                    printExpression(annAssign.target, sb, depth + 2);
                    if (annAssign.value != null) {
                        sb.append(indent).append("└─ Value:\n");
                        printExpression(annAssign.value, sb, depth + 2);
                    }
                    break;

                case "Testlist_star_expr":
                    Testlist_star_expr exprOnly = (Testlist_star_expr) stmt;
                    sb.append(indent).append("├─ Type: expression statement\n");
                    sb.append(indent).append("└─ Expression:\n");
                    printExpression(exprOnly.expr, sb, depth + 2);
                    break;

                // === FLOW CONTROL ===
                case "FlowBreak":
                    sb.append(indent).append("└─ Type: break statement\n");
                    break;

                case "FlowCountinue":
                    sb.append(indent).append("└─ Type: continue statement\n");
                    break;

                case "FlowReturn":
                    FlowReturn returnStmt = (FlowReturn) stmt;
                    sb.append(indent).append("├─ Type: return statement\n");
                    if (returnStmt.values != null && !returnStmt.values.isEmpty()) {
                        sb.append(indent).append("└─ Values (").append(returnStmt.values.size()).append("):\n");
                        for (ExpressionAtom value : returnStmt.values) {
                            printExpression(value, sb, depth + 2);
                        }
                    }
                    break;

                case "PassStatment":
                    sb.append(indent).append("└─ Type: pass statement\n");
                    break;

                case "DeleteStatment":
                    DeleteStatment delStmt = (DeleteStatment) stmt;
                    sb.append(indent).append("├─ Type: delete statement\n");
                    if (delStmt.elementsTdelete != null && !delStmt.elementsTdelete.isEmpty()) {
                        sb.append(indent).append("└─ Elements (").append(delStmt.elementsTdelete.size()).append("):\n");
                        for (ExpressionAtom elem : delStmt.elementsTdelete) {
                            printExpression(elem, sb, depth + 2);
                        }
                    }
                    break;

                case "GlobalStatment":
                    GlobalStatment globalStmt = (GlobalStatment) stmt;
                    sb.append(indent).append("├─ Type: global statement\n");
                    sb.append(indent).append("└─ Names: ").append(globalStmt.names).append("\n");
                    break;

                // === COMPLEX STATEMENTS ===
                case "FounctionStatment":
                    FounctionStatment func = (FounctionStatment) stmt;
                    sb.append(indent).append("├─ Type: function definition\n");
                    sb.append(indent).append("├─ Name: ").append(func.name).append("\n");

                    if (func.params != null && !func.params.isEmpty()) {
                        sb.append(indent).append("├─ Parameters (").append(func.params.size()).append("):\n");
                        for (ParametarToFunction param : func.params) {
                            sb.append(indent).append("│  └─ ").append(param.name);
                            if (param.type != null) {
                                sb.append(": ").append(param.type);
                            }
                            if (param.defaultValue != null) {
                                sb.append(" = ").append(param.defaultValue);
                            }
                            sb.append("\n");
                        }
                    }

                    if (func.returnType != null) {
                        sb.append(indent).append("├─ Return type: ").append(func.returnType).append("\n");
                    }

                    if (func.body != null && !func.body.isEmpty()) {
                        sb.append(indent).append("└─ Body (").append(func.body.size()).append(" statements):\n");
                        for (Statment bodyStmt : func.body) {
                            printStatement(bodyStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "IfStatment":
                    IfStatment ifStmt = (IfStatment) stmt;
                    sb.append(indent).append("├─ Type: if statement\n");
                    sb.append(indent).append("├─ Condition:\n");
                    printExpression(ifStmt.condition, sb, depth + 2);

                    if (ifStmt.body != null && !ifStmt.body.isEmpty()) {
                        sb.append(indent).append("├─ Then body (").append(ifStmt.body.size()).append(" statements):\n");
                        for (Statment thenStmt : ifStmt.body) {
                            printStatement(thenStmt, sb, depth + 2);
                        }
                    }

                    if (ifStmt.elifs != null && !ifStmt.elifs.isEmpty()) {
                        sb.append(indent).append("├─ Elifs (").append(ifStmt.elifs.size()).append("):\n");
                        for (ElifStatment elif : ifStmt.elifs) {
                            sb.append(indent).append("│  ├─ Elif condition:\n");
                            printExpression(elif.condition, sb, depth + 3);
                            sb.append(indent).append("│  └─ Body (").append(elif.body.size()).append(" statements):\n");
                            for (Statment elifBodyStmt : elif.body) {
                                printStatement(elifBodyStmt, sb, depth + 3);
                            }
                        }
                    }

                    if (ifStmt.elseBody != null && !ifStmt.elseBody.isEmpty()) {
                        sb.append(indent).append("└─ Else body (").append(ifStmt.elseBody.size()).append(" statements):\n");
                        for (Statment elseStmt : ifStmt.elseBody) {
                            printStatement(elseStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "ForStatment":
                    ForStatment forStmt = (ForStatment) stmt;
                    sb.append(indent).append("├─ Type: for loop\n");
                    sb.append(indent).append("├─ Target:\n");
                    printExpression(forStmt.target, sb, depth + 2);
                    sb.append(indent).append("├─ Iterable:\n");
                    printExpression(forStmt.iterable, sb, depth + 2);

                    if (forStmt.body != null && !forStmt.body.isEmpty()) {
                        sb.append(indent).append("├─ Body (").append(forStmt.body.size()).append(" statements):\n");
                        for (Statment bodyStmt : forStmt.body) {
                            printStatement(bodyStmt, sb, depth + 2);
                        }
                    }

                    if (forStmt.elseBody != null && !forStmt.elseBody.isEmpty()) {
                        sb.append(indent).append("└─ Else body (").append(forStmt.elseBody.size()).append(" statements):\n");
                        for (Statment elseStmt : forStmt.elseBody) {
                            printStatement(elseStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "WhileStatment":
                    WhileStatment whileStmt = (WhileStatment) stmt;
                    sb.append(indent).append("├─ Type: while loop\n");
                    sb.append(indent).append("├─ Condition:\n");
                    printExpression(whileStmt.condition, sb, depth + 2);

                    if (whileStmt.body != null && !whileStmt.body.isEmpty()) {
                        sb.append(indent).append("├─ Body (").append(whileStmt.body.size()).append(" statements):\n");
                        for (Statment bodyStmt : whileStmt.body) {
                            printStatement(bodyStmt, sb, depth + 2);
                        }
                    }

                    if (whileStmt.elseBody != null && !whileStmt.elseBody.isEmpty()) {
                        sb.append(indent).append("└─ Else body (").append(whileStmt.elseBody.size()).append(" statements):\n");
                        for (Statment elseStmt : whileStmt.elseBody) {
                            printStatement(elseStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "TryStatment":
                    TryStatment tryStmt = (TryStatment) stmt;
                    sb.append(indent).append("├─ Type: try statement\n");

                    if (tryStmt.body != null && !tryStmt.body.isEmpty()) {
                        sb.append(indent).append("├─ Try body (").append(tryStmt.body.size()).append(" statements):\n");
                        for (Statment tryBodyStmt : tryStmt.body) {
                            printStatement(tryBodyStmt, sb, depth + 2);
                        }
                    }

                    if (tryStmt.handlers != null && !tryStmt.handlers.isEmpty()) {
                        sb.append(indent).append("├─ Except handlers (").append(tryStmt.handlers.size()).append("):\n");
                        for (CatchStatment handler : tryStmt.handlers) {
                            sb.append(indent).append("│  ├─ Exception: ").append(handler.exceptionType).append("\n");
                            if (handler.varName != null) {
                                sb.append(indent).append("│  ├─ Variable: ").append(handler.varName).append("\n");
                            }
                            if (handler.body != null && !handler.body.isEmpty()) {
                                sb.append(indent).append("│  └─ Handler body (").append(handler.body.size()).append(" statements):\n");
                                for (Statment handlerStmt : handler.body) {
                                    printStatement(handlerStmt, sb, depth + 3);
                                }
                            }
                        }
                    }

                    if (tryStmt.elseBody != null && !tryStmt.elseBody.isEmpty()) {
                        sb.append(indent).append("├─ Else body (").append(tryStmt.elseBody.size()).append(" statements):\n");
                        for (Statment elseStmt : tryStmt.elseBody) {
                            printStatement(elseStmt, sb, depth + 2);
                        }
                    }

                    if (tryStmt.finallyBody != null && !tryStmt.finallyBody.isEmpty()) {
                        sb.append(indent).append("└─ Finally body (").append(tryStmt.finallyBody.size()).append(" statements):\n");
                        for (Statment finallyStmt : tryStmt.finallyBody) {
                            printStatement(finallyStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "WithStatment":
                    WithStatment withStmt = (WithStatment) stmt;
                    sb.append(indent).append("├─ Type: with statement\n");

                    if (withStmt.items != null && !withStmt.items.isEmpty()) {
                        sb.append(indent).append("├─ Items (").append(withStmt.items.size()).append("):\n");
                        for (WithItemStatment item : withStmt.items) {
                            sb.append(indent).append("│  ├─ Context:\n");
                            printExpression(item.contextExpr, sb, depth + 3);
                            if (item.optionalVar != null) {
                                sb.append(indent).append("│  └─ Variable:\n");
                                printExpression(item.optionalVar, sb, depth + 3);
                            }
                        }
                    }

                    if (withStmt.body != null && !withStmt.body.isEmpty()) {
                        sb.append(indent).append("└─ Body (").append(withStmt.body.size()).append(" statements):\n");
                        for (Statment bodyStmt : withStmt.body) {
                            printStatement(bodyStmt, sb, depth + 2);
                        }
                    }
                    break;

                case "ClassStatment":
                    ClassStatment classStmt = (ClassStatment) stmt;
                    sb.append(indent).append("├─ Type: class definition\n");
                    sb.append(indent).append("├─ Name: ").append(classStmt.name).append("\n");

                    if (classStmt.bases != null && !classStmt.bases.isEmpty()) {
                        sb.append(indent).append("├─ Bases (").append(classStmt.bases.size()).append("):\n");
                        for (ExpressionAtom base : classStmt.bases) {
                            printExpression(base, sb, depth + 2);
                        }
                    }

                    if (classStmt.body != null && !classStmt.body.isEmpty()) {
                        sb.append(indent).append("└─ Body (").append(classStmt.body.size()).append(" statements):\n");
                        for (Statment bodyStmt : classStmt.body) {
                            printStatement(bodyStmt, sb, depth + 2);
                        }
                    }
                    break;
                case "DecoratedStatmentOfFunction":
                    DecoratedStatmentOfFunction decorated = (DecoratedStatmentOfFunction) stmt;
                    sb.append(indent).append("├─ Type: decorated function\n");

                    if (decorated.decorators != null && !decorated.decorators.isEmpty()) {
                        sb.append(indent).append("├─ Decorators:\n");
                        for (DecoratorOfFunction decorator : decorated.decorators) {
                            sb.append(indent).append("│  └─ @");

                            if (decorator.name instanceof NameExpression) {
                                sb.append(((NameExpression) decorator.name).name);
                            } else {
                                sb.append(decorator.name);
                            }

                            if (decorator.args != null && !decorator.args.isEmpty()) {
                                sb.append("(");
                                for (int j = 0; j < decorator.args.size(); j++) {
                                    if (j > 0) sb.append(", ");
                                    ExpressionAtom arg = decorator.args.get(j);
                                    if (arg instanceof StringExpression) {
                                        sb.append(((StringExpression) arg).value);
                                    } else {
                                        sb.append(arg);
                                    }
                                }
                                sb.append(")");
                            }
                            sb.append("\n");
                        }
                    }

                    if (decorated.statement != null && decorated.statement instanceof FounctionStatment) {
                        // هنا غيرت اسم المتغير من func إلى functionDef لتجنب التعارض
                        FounctionStatment functionDef = (FounctionStatment) decorated.statement;
                        sb.append(indent).append("├─ Function: ").append(functionDef.name).append("\n");

                        if (functionDef.params != null && !functionDef.params.isEmpty()) {
                            sb.append(indent).append("├─ Parameters:\n");
                            for (ParametarToFunction param : functionDef.params) {
                                sb.append(indent).append("│  └─ ").append(param.name);
                                if (param.type != null) sb.append(": ").append(param.type);
                                if (param.defaultValue != null) sb.append(" = ").append(param.defaultValue);
                                sb.append("\n");
                            }
                        }

                        if (functionDef.body != null && !functionDef.body.isEmpty()) {
                            sb.append(indent).append("└─ Body (").append(functionDef.body.size()).append(" statements):\n");
                            for (Statment bodyStmt : functionDef.body) {
                                printStatement(bodyStmt, sb, depth + 2);
                            }
                        }
                    } else if (decorated.statement != null) {
                        sb.append(indent).append("├─ Decorated statement:\n");
                        printStatement(decorated.statement, sb, depth + 2);
                    }
                    break;
                default:
                    sb.append(indent).append("└─ Details: ").append(stmt.toString()).append("\n");
            }
        } catch (ClassCastException e) {
            sb.append(indent).append("└─ [Error in printing: ").append(e.getMessage()).append("]\n");
        }

    }

    private static void printExpression(ExpressionAtom expr, StringBuilder sb, int depth) {
        if (expr == null) {
            String indent = "  ".repeat(depth);
            sb.append(indent).append("└─ null\n");
            return;
        }

        String indent = "  ".repeat(depth);
        String nodeType = expr.getClass().getSimpleName();

        sb.append(indent).append("└─ ").append(nodeType).append(": ");

        try {
            switch (nodeType) {
                case "NameExpression":
                    NameExpression nameExpr = (NameExpression) expr;
                    sb.append(nameExpr.name).append("\n");
                    break;

                case "NumberExpression":
                    NumberExpression numExpr = (NumberExpression) expr;
                    sb.append(numExpr.value).append("\n");
                    break;

                case "StringExpression":
                    StringExpression strExpr = (StringExpression) expr;
                    sb.append(strExpr.value).append("\n");
                    break;

                case "FStringExpression":
                    FStringExpression fstrExpr = (FStringExpression) expr;
                    // عرض مختصر للـ f-string
                    String fstrValue = fstrExpr.value;
                    if (fstrValue.length() > 30) {
                        fstrValue = fstrValue.substring(0, 27) + "...";
                    }
                    sb.append("f-string: ").append(fstrValue).append("\n");
                    break;

                case "BooleanExpression":
                    BooleanExpression boolExpr = (BooleanExpression) expr;
                    sb.append(boolExpr.value).append("\n");
                    break;

                case "NoneExpression":
                    sb.append("None\n");
                    break;

                case "ListExprssion":
                    ListExprssion listExpr = (ListExprssion) expr;
                    sb.append("[").append(listExpr.items.size()).append(" items]\n");
                    if (listExpr.items != null && !listExpr.items.isEmpty()) {
                        for (int i = 0; i < listExpr.items.size(); i++) {
                            sb.append(indent).append("  ").append(i).append(". ");
                            printExpression(listExpr.items.get(i), sb, depth + 1);
                        }
                    }
                    break;

                case "TupleExprssion":
                    TupleExprssion tupleExpr = (TupleExprssion) expr;
                    sb.append("(").append(tupleExpr.items.size()).append(" items)\n");
                    if (tupleExpr.items != null && !tupleExpr.items.isEmpty()) {
                        for (int i = 0; i < tupleExpr.items.size(); i++) {
                            sb.append(indent).append("  ").append(i).append(". ");
                            printExpression(tupleExpr.items.get(i), sb, depth + 1);
                        }
                    }
                    break;

                case "DictionaryExprssion":
                    DictionaryExprssion dictExpr = (DictionaryExprssion) expr;
                    sb.append("{" + dictExpr.keys.size() + " key-value pairs}\n");
                    if (dictExpr.keys != null && dictExpr.values != null) {
                        for (int i = 0; i < Math.min(dictExpr.keys.size(), dictExpr.values.size()); i++) {
                            sb.append(indent).append("  ").append(i).append(". Key: ");
                            printExpression(dictExpr.keys.get(i), sb, depth + 1);
                            sb.append(indent).append("    Value: ");
                            printExpression(dictExpr.values.get(i), sb, depth + 1);
                        }
                    }
                    break;

                case "CallExprssion":
                    CallExprssion callExpr = (CallExprssion) expr;
                    sb.append("call\n");
                    sb.append(indent).append("  ├─ Function: ");
                    printExpression(callExpr.function, sb, depth + 2);
                    if (callExpr.args != null && !callExpr.args.isEmpty()) {
                        sb.append(indent).append("  └─ Arguments (").append(callExpr.args.size()).append("):\n");
                        for (int i = 0; i < callExpr.args.size(); i++) {
                            sb.append(indent).append("      ").append(i).append(". ");
                            printExpression(callExpr.args.get(i), sb, depth + 3);
                        }
                    }
                    break;

                case "AttributeOfVariable":
                    AttributeOfVariable attrExpr = (AttributeOfVariable) expr;
                    sb.append("attribute access\n");
                    sb.append(indent).append("  ├─ Object: ");
                    printExpression(attrExpr.object, sb, depth + 2);
                    sb.append(indent).append("  └─ Property: ").append(attrExpr.property).append("\n");
                    break;

                case "SubscriptOfAree":
                    SubscriptOfAree subscriptExpr = (SubscriptOfAree) expr;
                    sb.append("subscript\n");
                    sb.append(indent).append("  ├─ Value: ");
                    printExpression(subscriptExpr.value, sb, depth + 2);
                    sb.append(indent).append("  └─ Slice: ").append(subscriptExpr.slice).append("\n");
                    break;

                case "TwoOperationExprssion":
                    TwoOperationExprssion binExpr = (TwoOperationExprssion) expr;
                    sb.append("binary operation: ").append(binExpr.op).append("\n");
                    sb.append(indent).append("  ├─ Left: ");
                    printExpression(binExpr.left, sb, depth + 2);
                    sb.append(indent).append("  └─ Right: ");
                    printExpression(binExpr.right, sb, depth + 2);
                    break;

                case "OneOperationExprssion":
                    OneOperationExprssion unaryExpr = (OneOperationExprssion) expr;
                    sb.append("unary operation: ").append(unaryExpr.op).append("\n");
                    sb.append(indent).append("  └─ Operand: ");
                    printExpression(unaryExpr.expr, sb, depth + 2);
                    break;

                case "PowerExprssion":
                    PowerExprssion powExpr = (PowerExprssion) expr;
                    sb.append("power operation\n");
                    sb.append(indent).append("  ├─ Base: ");
                    printExpression(powExpr.base, sb, depth + 2);
                    sb.append(indent).append("  └─ Exponent: ");
                    printExpression(powExpr.exponent, sb, depth + 2);
                    break;

                case "CompareExprssion":
                    CompareExprssion cmpExpr = (CompareExprssion) expr;
                    sb.append("comparison\n");
                    sb.append(indent).append("  ├─ Left: ");
                    printExpression(cmpExpr.left, sb, depth + 2);
                    if (cmpExpr.ops != null && cmpExpr.rights != null) {
                        for (int i = 0; i < Math.min(cmpExpr.ops.size(), cmpExpr.rights.size()); i++) {
                            sb.append(indent).append("  ├─ Operator: ").append(cmpExpr.ops.get(i)).append("\n");
                            sb.append(indent).append("  └─ Right: ");
                            printExpression(cmpExpr.rights.get(i), sb, depth + 2);
                        }
                    }
                    break;

                case "ThreeConditionExprssion":
                    ThreeConditionExprssion ternaryExpr = (ThreeConditionExprssion) expr;
                    sb.append("ternary if\n");
                    sb.append(indent).append("  ├─ Condition: ");
                    printExpression(ternaryExpr.condExpr, sb, depth + 2);
                    sb.append(indent).append("  ├─ Then: ");
                    printExpression(ternaryExpr.thenExpr, sb, depth + 2);
                    sb.append(indent).append("  └─ Else: ");
                    printExpression(ternaryExpr.elseExpr, sb, depth + 2);
                    break;

                case "NameArgumentExpr":
                    NameArgumentExpr namedArg = (NameArgumentExpr) expr;
                    sb.append("named argument\n");
                    sb.append(indent).append("  ├─ Name: ").append(namedArg.name).append("\n");
                    sb.append(indent).append("  └─ Value: ");
                    printExpression(namedArg.value, sb, depth + 2);
                    break;

                case "ComplexListOfFor":
                    if (expr instanceof ComplexListOfFor) {
                        ComplexListOfFor compExpr = (ComplexListOfFor) expr;
                        sb.append("comprehension: ").append(compExpr.type).append("\n");
                        if (compExpr.key != null) {
                            sb.append(indent).append("  ├─ Key: ");
                            printExpression(compExpr.key, sb, depth + 2);
                        }
                        sb.append(indent).append("  ├─ Body: ");
                        printExpression(compExpr.body, sb, depth + 2);
                        if (compExpr.forClauses != null && !compExpr.forClauses.isEmpty()) {
                            sb.append(indent).append("  └─ For clauses (").append(compExpr.forClauses.size()).append("):\n");
                            for (CoplexForExpression forClause : compExpr.forClauses) {
                                sb.append(indent).append("      ├─ Target: ");
                                printExpression(forClause.target, sb, depth + 3);
                                sb.append(indent).append("      ├─ Iterable: ");
                                printExpression(forClause.iterable, sb, depth + 3);
                                if (forClause.conditions != null && !forClause.conditions.isEmpty()) {
                                    sb.append(indent).append("      └─ Conditions (").append(forClause.conditions.size()).append("):\n");
                                    for (ExpressionAtom cond : forClause.conditions) {
                                        printExpression(cond, sb, depth + 4);
                                    }
                                }
                            }
                        }
                    } else {
                        sb.append("[Comprehension - not an ExpressionAtom type]\n");
                    }
                    break;

                default:
                    sb.append(expr.toString()).append("\n");
            }
        } catch (ClassCastException e) {
            sb.append("[Error: ").append(e.getMessage()).append("]\n");
        }
    }
}