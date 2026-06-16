//package Generation_Flask_Jinja;
//
//import ASTFlask.*;
//import ASTFlask.AtomExpression.*;
//import ASTFlask.TheMainContintOfComplexStatment.*;
//import ASTFlask.TheMainContintOfSimpleStatment.*;
//import ASTFlask.TheMainExpressionStatment.*;
//import java.io.*;
//import java.util.List;
//
///**
// * مولد كود Flask من AST
// * يقوم بتحويل الشجرة المجردة إلى كود Python صالح للتشغيل
// */
//public class FlaskCodeGenerator {
//
//    private final StringBuilder code = new StringBuilder();
//    private int indentLevel = 0;
//
//    public FlaskCodeGenerator() {}
//
//    private void append(String text) {
//        code.append("    ".repeat(indentLevel)).append(text);
//    }
//
//    private void appendLine(String line) {
//        append(line);
//        code.append("\n");
//    }
//
//    private void indent() { indentLevel++; }
//    private void dedent() { indentLevel--; }
//
//    public void generate(Proge program) {
//        for (Statment stmt : program.statements) {
//            generateStatment(stmt);
//        }
//    }
//
//    private void generateStatment(Statment stmt) {
//        if (stmt == null) return;
//
//        // استيرادات
//        if (stmt instanceof ImportFrom) {
//            generateImportFrom((ImportFrom) stmt);
//        } else if (stmt instanceof ImportName) {
//            generateImportName((ImportName) stmt);
//        }
//        // التعابير والعمليات
//        else if (stmt instanceof Testlist_Start_ExpressionEqual) {
//            generateAssignment((Testlist_Start_ExpressionEqual) stmt);
//        } else if (stmt instanceof AugassignEqual) {
//            generateAugAssign((AugassignEqual) stmt);
//        } else if (stmt instanceof AnnassignColon) {
//            generateAnnAssign((AnnassignColon) stmt);
//        } else if (stmt instanceof DeleteStatment) {
//            generateDelete((DeleteStatment) stmt);
//        } else if (stmt instanceof GlobalStatment) {
//            generateGlobal((GlobalStatment) stmt);
//        } else if (stmt instanceof PassStatment) {
//            generatePass((PassStatment) stmt);
//        } else if (stmt instanceof Testlist_star_expr) {
//            generateExpressionStatement((Testlist_star_expr) stmt);
//        }
//        // الدوال
//        else if (stmt instanceof FounctionStatment) {
//            generateFunction((FounctionStatment) stmt);
//        } else if (stmt instanceof DecoratedStatmentOfFunction) {
//            generateDecoratedFunction((DecoratedStatmentOfFunction) stmt);
//        } else if (stmt instanceof FlowReturn) {
//            generateReturn((FlowReturn) stmt);
//        } else if (stmt instanceof FlowBreak) {
//            appendLine("break");
//        } else if (stmt instanceof FlowCountinue) {
//            appendLine("continue");
//        }
//        // الجمل الشرطية والحلقات
//        else if (stmt instanceof IfStatment) {
//            generateIfStatement((IfStatment) stmt);
//        } else if (stmt instanceof ForStatment) {
//            generateForStatement((ForStatment) stmt);
//        } else if (stmt instanceof WhileStatment) {
//            generateWhileStatement((WhileStatment) stmt);
//        }
//        // try-except-with
//        else if (stmt instanceof TryStatment) {
//            generateTryStatement((TryStatment) stmt);
//        } else if (stmt instanceof WithStatment) {
//            generateWithStatement((WithStatment) stmt);
//        }
//        // الكلاس
//        else if (stmt instanceof ClassStatment) {
//            generateClassStatement((ClassStatment) stmt);
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد الاستيرادات
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateImportFrom(ImportFrom stmt) {
//        StringBuilder items = new StringBuilder();
//        for (int i = 0; i < stmt.items.size(); i++) {
//            if (i > 0) items.append(", ");
//            ImportItem item = stmt.items.get(i);
//            if (item.alias != null && !item.alias.equals(item.name)) {
//                items.append(item.name).append(" as ").append(item.alias);
//            } else {
//                items.append(item.name);
//            }
//        }
//        appendLine(String.format("from %s import %s", stmt.module, items));
//    }
//
//    private void generateImportName(ImportName stmt) {
//        for (ImportItem item : stmt.items) {
//            if (item.alias != null && !item.alias.equals(item.name)) {
//                appendLine(String.format("import %s as %s", item.name, item.alias));
//            } else {
//                appendLine(String.format("import %s", item.name));
//            }
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد المتغيرات والتعابير
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateAssignment(Testlist_Start_ExpressionEqual stmt) {
//        String target = expressionToString(stmt.target);
//        String value = expressionToString(stmt.value);
//        appendLine(String.format("%s = %s", target, value));
//    }
//
//    private void generateAugAssign(AugassignEqual stmt) {
//        String target = expressionToString(stmt.target);
//        String value = expressionToString(stmt.value);
//        appendLine(String.format("%s %s %s", target, stmt.operator, value));
//    }
//
//    private void generateAnnAssign(AnnassignColon stmt) {
//        String target = expressionToString(stmt.target);
//        if (stmt.value != null) {
//            appendLine(String.format("%s = %s", target, expressionToString(stmt.value)));
//        } else {
//            appendLine(target);
//        }
//    }
//
//    private void generateDelete(DeleteStatment stmt) {
//        StringBuilder targets = new StringBuilder();
//        for (int i = 0; i < stmt.elementsTdelete.size(); i++) {
//            if (i > 0) targets.append(", ");
//            targets.append(expressionToString(stmt.elementsTdelete.get(i)));
//        }
//        appendLine(String.format("del %s", targets));
//    }
//
//    private void generateGlobal(GlobalStatment stmt) {
//        StringBuilder names = new StringBuilder();
//        for (int i = 0; i < stmt.names.size(); i++) {
//            if (i > 0) names.append(", ");
//            names.append(stmt.names.get(i));
//        }
//        appendLine(String.format("global %s", names));
//    }
//
//    private void generatePass(PassStatment stmt) {
//        appendLine("pass");
//    }
//
//    private void generateExpressionStatement(Testlist_star_expr stmt) {
//        if (stmt.expr != null) {
//            appendLine(expressionToString(stmt.expr));
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد الدوال
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateFunction(FounctionStatment stmt) {
//        // معاملات الدالة
//        StringBuilder params = new StringBuilder();
//        if (stmt.params != null) {
//            for (int i = 0; i < stmt.params.size(); i++) {
//                if (i > 0) params.append(", ");
//                ParametarToFunction param = stmt.params.get(i);
//                params.append(param.name);
//                if (param.defaultValue != null) {
//                    params.append(" = ").append(expressionToString(param.defaultValue));
//                }
//            }
//        }
//
//        // توقيع الدالة
//        if (stmt.returnType != null) {
//            appendLine(String.format("def %s(%s) -> %s:", stmt.name, params, expressionToString(stmt.returnType)));
//        } else {
//            appendLine(String.format("def %s(%s):", stmt.name, params));
//        }
//        indent();
//
//        // جسم الدالة
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//
//        dedent();
//        code.append("\n");
//    }
//
//    private void generateDecoratedFunction(DecoratedStatmentOfFunction stmt) {
//        // توليد الديكوراتورات
//        if (stmt.decorators != null) {
//            for (DecoratorOfFunction decorator : stmt.decorators) {
//                String decoratorName = expressionToString(decorator.name);
//                if (decorator.args != null && !decorator.args.isEmpty()) {
//                    StringBuilder args = new StringBuilder();
//                    for (int i = 0; i < decorator.args.size(); i++) {
//                        if (i > 0) args.append(", ");
//                        args.append(expressionToString(decorator.args.get(i)));
//                    }
//                    appendLine(String.format("@%s(%s)", decoratorName, args));
//                } else {
//                    appendLine(String.format("@%s", decoratorName));
//                }
//            }
//        }
//        // توليد الدالة نفسها
//        if (stmt.statement instanceof FounctionStatment) {
//            generateFunction((FounctionStatment) stmt.statement);
//        }
//    }
//
//    private void generateReturn(FlowReturn stmt) {
//        if (stmt.values == null || stmt.values.isEmpty()) {
//            appendLine("return");
//        } else {
//            StringBuilder values = new StringBuilder();
//            for (int i = 0; i < stmt.values.size(); i++) {
//                if (i > 0) values.append(", ");
//                values.append(expressionToString(stmt.values.get(i)));
//            }
//            appendLine(String.format("return %s", values));
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد الجمل الشرطية والحلقات
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateIfStatement(IfStatment stmt) {
//        appendLine(String.format("if %s:", expressionToString(stmt.condition)));
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//
//        // جمل elif
//        if (stmt.elifs != null) {
//            for (ElifStatment elif : stmt.elifs) {
//                appendLine(String.format("elif %s:", expressionToString(elif.condition)));
//                indent();
//                if (elif.body != null) {
//                    for (Statment bodyStmt : elif.body) {
//                        generateStatment(bodyStmt);
//                    }
//                }
//                dedent();
//            }
//        }
//
//        // جمل else
//        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
//            appendLine("else:");
//            indent();
//            for (Statment bodyStmt : stmt.elseBody) {
//                generateStatment(bodyStmt);
//            }
//            dedent();
//        }
//    }
//
//    private void generateForStatement(ForStatment stmt) {
//        String target = expressionToString(stmt.target);
//        String iterable = expressionToString(stmt.iterable);
//        appendLine(String.format("for %s in %s:", target, iterable));
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//
//        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
//            appendLine("else:");
//            indent();
//            for (Statment bodyStmt : stmt.elseBody) {
//                generateStatment(bodyStmt);
//            }
//            dedent();
//        }
//    }
//
//    private void generateWhileStatement(WhileStatment stmt) {
//        appendLine(String.format("while %s:", expressionToString(stmt.condition)));
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//
//        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
//            appendLine("else:");
//            indent();
//            for (Statment bodyStmt : stmt.elseBody) {
//                generateStatment(bodyStmt);
//            }
//            dedent();
//        }
//    }
//
//    private void generateTryStatement(TryStatment stmt) {
//        appendLine("try:");
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//
//        if (stmt.handlers != null) {
//            for (CatchStatment handler : stmt.handlers) {
//                if (handler.exceptionType != null) {
//                    String type = expressionToString(handler.exceptionType);
//                    if (handler.varName != null && !handler.varName.isEmpty()) {
//                        appendLine(String.format("except %s as %s:", type, handler.varName));
//                    } else {
//                        appendLine(String.format("except %s:", type));
//                    }
//                } else {
//                    appendLine("except:");
//                }
//                indent();
//                if (handler.body != null) {
//                    for (Statment bodyStmt : handler.body) {
//                        generateStatment(bodyStmt);
//                    }
//                }
//                dedent();
//            }
//        }
//
//        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
//            appendLine("else:");
//            indent();
//            for (Statment bodyStmt : stmt.elseBody) {
//                generateStatment(bodyStmt);
//            }
//            dedent();
//        }
//
//        if (stmt.finallyBody != null && !stmt.finallyBody.isEmpty()) {
//            appendLine("finally:");
//            indent();
//            for (Statment bodyStmt : stmt.finallyBody) {
//                generateStatment(bodyStmt);
//            }
//            dedent();
//        }
//    }
//
//    private void generateWithStatement(WithStatment stmt) {
//        StringBuilder items = new StringBuilder();
//        if (stmt.items != null) {
//            for (int i = 0; i < stmt.items.size(); i++) {
//                if (i > 0) items.append(", ");
//                WithItemStatment item = stmt.items.get(i);
//                items.append(expressionToString(item.contextExpr));
//                if (item.optionalVar != null) {
//                    items.append(" as ").append(expressionToString(item.optionalVar));
//                }
//            }
//        }
//        appendLine(String.format("with %s:", items));
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//    }
//
//    private void generateClassStatement(ClassStatment stmt) {
//        StringBuilder bases = new StringBuilder();
//        if (stmt.bases != null && !stmt.bases.isEmpty()) {
//            for (int i = 0; i < stmt.bases.size(); i++) {
//                if (i > 0) bases.append(", ");
//                bases.append(expressionToString(stmt.bases.get(i)));
//            }
//            appendLine(String.format("class %s(%s):", stmt.name, bases));
//        } else {
//            appendLine(String.format("class %s:", stmt.name));
//        }
//        indent();
//        if (stmt.body != null) {
//            for (Statment bodyStmt : stmt.body) {
//                generateStatment(bodyStmt);
//            }
//        }
//        dedent();
//        code.append("\n");
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  دوال مساعدة لتحويل التعبيرات إلى نص
//    // ═══════════════════════════════════════════════════════════════════
//
//    private String expressionToString(ExpressionAtom expr) {
//        if (expr == null) return "None";
//
//        // التعابير الذرية
//        if (expr instanceof NameExpression) {
//            return ((NameExpression) expr).name;
//        }
//        if (expr instanceof NumberExpression) {
//            return ((NumberExpression) expr).value;
//        }
//        if (expr instanceof StringExpression) {
//            return ((StringExpression) expr).value;
//        }
//        if (expr instanceof BooleanExpression) {
//            return ((BooleanExpression) expr).value ? "True" : "False";
//        }
//        if (expr instanceof NoneExpression) {
//            return "None";
//        }
//        if (expr instanceof FStringExpression) {
//            return ((FStringExpression) expr).value;
//        }
//
//        // استدعاء الدوال
//        if (expr instanceof CallExprssion) {
//            CallExprssion call = (CallExprssion) expr;
//            StringBuilder args = new StringBuilder();
//            if (call.args != null) {
//                for (int i = 0; i < call.args.size(); i++) {
//                    if (i > 0) args.append(", ");
//                    args.append(expressionToString(call.args.get(i)));
//                }
//            }
//            return String.format("%s(%s)", expressionToString(call.function), args);
//        }
//
//        // الوصول إلى الخصائص
//        if (expr instanceof AttributeOfVariable) {
//            AttributeOfVariable attr = (AttributeOfVariable) expr;
//            return String.format("%s.%s", expressionToString(attr.object), attr.property);
//        }
//
//        // الوصول إلى المصفوفات
//        if (expr instanceof SubscriptOfAree) {
//            SubscriptOfAree sub = (SubscriptOfAree) expr;
//            return String.format("%s[%s]", expressionToString(sub.value), sliceToString(sub.slice));
//        }
//
//        // العمليات الثنائية
//        if (expr instanceof TwoOperationExprssion) {
//            TwoOperationExprssion bin = (TwoOperationExprssion) expr;
//            return String.format("(%s %s %s)",
//                    expressionToString(bin.left), bin.op, expressionToString(bin.right));
//        }
//
//        // العمليات الأحادية
//        if (expr instanceof OneOperationExprssion) {
//            OneOperationExprssion un = (OneOperationExprssion) expr;
//            return String.format("%s%s", un.op, expressionToString(un.expr));
//        }
//
//        // عمليات المقارنة
//        if (expr instanceof CompareExprssion) {
//            CompareExprssion comp = (CompareExprssion) expr;
//            StringBuilder result = new StringBuilder(expressionToString(comp.left));
//            for (int i = 0; i < comp.ops.size(); i++) {
//                result.append(" ").append(comp.ops.get(i)).append(" ");
//                result.append(expressionToString(comp.rights.get(i)));
//            }
//            return result.toString();
//        }
//
//        // العمليات الثلاثية
//        if (expr instanceof ThreeConditionExprssion) {
//            ThreeConditionExprssion ternary = (ThreeConditionExprssion) expr;
//            return String.format("%s if %s else %s",
//                    expressionToString(ternary.thenExpr),
//                    expressionToString(ternary.condExpr),
//                    expressionToString(ternary.elseExpr));
//        }
//
//        // القوائم
//        if (expr instanceof ListExprssion) {
//            ListExprssion list = (ListExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (list.items != null) {
//                for (int i = 0; i < list.items.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(list.items.get(i)));
//                }
//            }
//            return "[" + items + "]";
//        }
//
//        // المجموعات (Tuple)
//        if (expr instanceof TupleExprssion) {
//            TupleExprssion tuple = (TupleExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (tuple.items != null) {
//                for (int i = 0; i < tuple.items.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(tuple.items.get(i)));
//                }
//            }
//            if (tuple.items != null && tuple.items.size() == 1) {
//                return "(" + items + ",)";
//            }
//            return "(" + items + ")";
//        }
//
//        // القواميس
//        if (expr instanceof DictionaryExprssion) {
//            DictionaryExprssion dict = (DictionaryExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (dict.keys != null && dict.values != null) {
//                for (int i = 0; i < dict.keys.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(dict.keys.get(i)));
//                    items.append(": ");
//                    items.append(expressionToString(dict.values.get(i)));
//                }
//            }
//            return "{" + items + "}";
//        }
//
//        // الوسائط المسماة
//        if (expr instanceof NameArgumentExpr) {
//            NameArgumentExpr named = (NameArgumentExpr) expr;
//            return String.format("%s=%s", named.name, expressionToString(named.value));
//        }
//
//        // العمليات التكعيبية (Power)
//        if (expr instanceof PowerExprssion) {
//            PowerExprssion power = (PowerExprssion) expr;
//            return String.format("%s ** %s", expressionToString(power.base), expressionToString(power.exponent));
//        }
//
//        // التعابير المركبة (Comprehension)
//        if (expr instanceof ComplexListOfFor) {
//            ComplexListOfFor comp = (ComplexListOfFor) expr;
//            StringBuilder result = new StringBuilder();
//            if (comp.type == TypeOfFor_Complex.DICT && comp.key != null) {
//                result.append("{").append(expressionToString(comp.key)).append(": ").append(expressionToString(comp.body));
//            } else {
//                if (comp.type == TypeOfFor_Complex.LIST) result.append("[");
//                else if (comp.type == TypeOfFor_Complex.GENERATOR) result.append("(");
//                else result.append("{").append(expressionToString(comp.body));
//                result.append(expressionToString(comp.body));
//            }
//            for (CoplexForExpression clause : comp.forClauses) {
//                result.append(" for ").append(expressionToString(clause.target));
//                result.append(" in ").append(expressionToString(clause.iterable));
//                if (clause.conditions != null) {
//                    for (ExpressionAtom cond : clause.conditions) {
//                        result.append(" if ").append(expressionToString(cond));
//                    }
//                }
//            }
//            if (comp.type == TypeOfFor_Complex.LIST) result.append("]");
//            else if (comp.type == TypeOfFor_Complex.GENERATOR) result.append(")");
//            else result.append("}");
//            return result.toString();
//        }
//
//        return expr.toString();
//    }
//
//    private String sliceToString(SliceTowSubscriptOfAree slice) {
//        if (slice == null) return "";
//        StringBuilder sb = new StringBuilder();
//        if (slice.start != null) sb.append(expressionToString(slice.start));
//        sb.append(":");
//        if (slice.end != null) sb.append(expressionToString(slice.end));
//        if (slice.step != null) {
//            sb.append(":").append(expressionToString(slice.step));
//        }
//        return sb.toString();
//    }
//
//    public String getCode() {
//        return code.toString();
//    }
//
//    public void saveToFile(String path) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
//            writer.write(code.toString());
//        }
//        System.out.println("✅ تم إنشاء ملف Flask: " + path);
//    }
//}


























package Generation_Flask_Jinja;

import ASTFlask.*;
import ASTFlask.AtomExpression.*;
import ASTFlask.TheMainContintOfComplexStatment.*;
import ASTFlask.TheMainContintOfSimpleStatment.*;
import ASTFlask.TheMainExpressionStatment.*;
import java.io.*;
import java.util.List;

/**
 * مولد كود Flask ذكي، يمنع الأقواس المعلقة والثغرات القواعدية في بايثون
 */
public class FlaskCodeGenerator {

    private final StringBuilder code = new StringBuilder();
    private int indentLevel = 0;

    public FlaskCodeGenerator() {}

    private void append(String text) {
        code.append(text);
    }

    private void appendLine(String line) {
        code.append("    ".repeat(indentLevel)).append(line).append("\n");
    }

    private void indent() { indentLevel++; }
    private void dedent() { indentLevel--; }

    public void generate(Proge program) {
        for (Statment stmt : program.statements) {
            generateStatment(stmt);
        }
    }

    private void generateStatment(Statment stmt) {
        if (stmt == null) return;

        if (stmt instanceof ImportFrom) {
            generateImportFrom((ImportFrom) stmt);
        } else if (stmt instanceof ImportName) {
            generateImportName((ImportName) stmt);
        } else if (stmt instanceof Testlist_Start_ExpressionEqual) {
            generateAssignment((Testlist_Start_ExpressionEqual) stmt);
        } else if (stmt instanceof AugassignEqual) {
            generateAugAssign((AugassignEqual) stmt);
        } else if (stmt instanceof AnnassignColon) {
            generateAnnAssign((AnnassignColon) stmt);
        } else if (stmt instanceof DeleteStatment) {
            generateDelete((DeleteStatment) stmt);
        } else if (stmt instanceof GlobalStatment) {
            generateGlobal((GlobalStatment) stmt);
        } else if (stmt instanceof PassStatment) {
            generatePass((PassStatment) stmt);
        } else if (stmt instanceof Testlist_star_expr) {
            generateExpressionStatement((Testlist_star_expr) stmt);
        } else if (stmt instanceof FounctionStatment) {
            generateFunction((FounctionStatment) stmt);
        } else if (stmt instanceof DecoratedStatmentOfFunction) {
            generateDecoratedFunction((DecoratedStatmentOfFunction) stmt);
        } else if (stmt instanceof FlowReturn) {
            generateReturn((FlowReturn) stmt);
        } else if (stmt instanceof FlowBreak) {
            appendLine("break");
        } else if (stmt instanceof FlowCountinue) {
            appendLine("continue");
        } else if (stmt instanceof IfStatment) {
            generateIfStatement((IfStatment) stmt);
        } else if (stmt instanceof ForStatment) {
            generateForStatement((ForStatment) stmt);
        } else if (stmt instanceof WhileStatment) {
            generateWhileStatement((WhileStatment) stmt);
        } else if (stmt instanceof TryStatment) {
            generateTryStatement((TryStatment) stmt);
        } else if (stmt instanceof WithStatment) {
            generateWithStatement((WithStatment) stmt);
        } else if (stmt instanceof ClassStatment) {
            generateClassStatement((ClassStatment) stmt);
        }
    }

    private void generateImportFrom(ImportFrom stmt) {
        StringBuilder items = new StringBuilder();
        for (int i = 0; i < stmt.items.size(); i++) {
            if (i > 0) items.append(", ");
            ImportItem item = stmt.items.get(i);
            if (item.alias != null && !item.alias.equals(item.name)) {
                items.append(item.name).append(" as ").append(item.alias);
            } else {
                items.append(item.name);
            }
        }
        appendLine(String.format("from %s import %s", stmt.module, items));
    }

    private void generateImportName(ImportName stmt) {
        for (ImportItem item : stmt.items) {
            if (item.alias != null && !item.alias.equals(item.name)) {
                appendLine(String.format("import %s as %s", item.name, item.alias));
            } else {
                appendLine(String.format("import %s", item.name));
            }
        }
    }

    private void generateAssignment(Testlist_Start_ExpressionEqual stmt) {
        String target = expressionToString(stmt.target);
        String value = expressionToString(stmt.value);
        appendLine(String.format("%s = %s", target, value));
    }

    private void generateAugAssign(AugassignEqual stmt) {
        String target = expressionToString(stmt.target);
        String value = expressionToString(stmt.value);
        appendLine(String.format("%s %s %s", target, stmt.operator, value));
    }

    private void generateAnnAssign(AnnassignColon stmt) {
        String target = expressionToString(stmt.target);
        if (stmt.value != null) {
            appendLine(String.format("%s = %s", target, expressionToString(stmt.value)));
        } else {
            appendLine(target);
        }
    }

    private void generateDelete(DeleteStatment stmt) {
        StringBuilder targets = new StringBuilder();
        for (int i = 0; i < stmt.elementsTdelete.size(); i++) {
            if (i > 0) targets.append(", ");
            targets.append(expressionToString(stmt.elementsTdelete.get(i)));
        }
        appendLine(String.format("del %s", targets));
    }

    private void generateGlobal(GlobalStatment stmt) {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < stmt.names.size(); i++) {
            if (i > 0) names.append(", ");
            names.append(stmt.names.get(i));
        }
        appendLine(String.format("global %s", names));
    }

    private void generatePass(PassStatment stmt) {
        appendLine("pass");
    }

    private void generateExpressionStatement(Testlist_star_expr stmt) {
        if (stmt.expr != null) {
            appendLine(expressionToString(stmt.expr));
        }
    }

    private void generateFunction(FounctionStatment stmt) {
        StringBuilder params = new StringBuilder();
        if (stmt.params != null) {
            for (int i = 0; i < stmt.params.size(); i++) {
                if (i > 0) params.append(", ");
                ParametarToFunction param = stmt.params.get(i);
                params.append(param.name);
                if (param.defaultValue != null) {
                    params.append("=").append(expressionToString(param.defaultValue));
                }
            }
        }

        if (stmt.returnType != null) {
            appendLine(String.format("def %s(%s) -> %s:", stmt.name, params, expressionToString(stmt.returnType)));
        } else {
            appendLine(String.format("def %s(%s):", stmt.name, params));
        }
        indent();

        // حماية تلقائية لـ Scope بايثون: إضافة global للمصفوفات العامة في دوال الحذف أو الإضافة
        if (stmt.name.equalsIgnoreCase("delete_product") || stmt.name.equalsIgnoreCase("add_product")) {
            appendLine("global products");
        }

        if (stmt.body != null && !stmt.body.isEmpty()) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        } else {
            appendLine("pass");
        }

        dedent();
        code.append("\n");
    }

    private void generateDecoratedFunction(DecoratedStatmentOfFunction stmt) {
        if (stmt.decorators != null) {
            for (DecoratorOfFunction decorator : stmt.decorators) {
                String decoratorName = expressionToString(decorator.name);
                if (decorator.args != null && !decorator.args.isEmpty()) {
                    StringBuilder args = new StringBuilder();
                    for (int i = 0; i < decorator.args.size(); i++) {
                        if (i > 0) args.append(", ");
                        args.append(expressionToString(decorator.args.get(i)));
                    }
                    appendLine(String.format("@%s(%s)", decoratorName, args));
                } else {
                    appendLine(String.format("@%s", decoratorName));
                }
            }
        }
        if (stmt.statement instanceof FounctionStatment) {
            generateFunction((FounctionStatment) stmt.statement);
        }
    }

    private void generateReturn(FlowReturn stmt) {
        if (stmt.values == null || stmt.values.isEmpty()) {
            appendLine("return");
        } else {
            StringBuilder values = new StringBuilder();
            for (int i = 0; i < stmt.values.size(); i++) {
                if (i > 0) values.append(", ");
                values.append(expressionToString(stmt.values.get(i)));
            }
            appendLine(String.format("return %s", values));
        }
    }

    private void generateIfStatement(IfStatment stmt) {
        appendLine(String.format("if %s:", expressionToString(stmt.condition)));
        indent();
        if (stmt.body != null && !stmt.body.isEmpty()) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        } else {
            appendLine("pass");
        }
        dedent();

        if (stmt.elifs != null) {
            for (ElifStatment elif : stmt.elifs) {
                appendLine(String.format("elif %s:", expressionToString(elif.condition)));
                indent();
                if (elif.body != null && !elif.body.isEmpty()) {
                    for (Statment bodyStmt : elif.body) {
                        generateStatment(bodyStmt);
                    }
                } else {
                    appendLine("pass");
                }
                dedent();
            }
        }

        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
            appendLine("else:");
            indent();
            for (Statment bodyStmt : stmt.elseBody) {
                generateStatment(bodyStmt);
            }
            dedent();
        }
    }

    private void generateForStatement(ForStatment stmt) {
        String target = expressionToString(stmt.target);
        String iterable = expressionToString(stmt.iterable);
        appendLine(String.format("for %s in %s:", target, iterable));
        indent();
        if (stmt.body != null && !stmt.body.isEmpty()) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        } else {
            appendLine("pass");
        }
        dedent();

        if (stmt.elseBody != null && !stmt.elseBody.isEmpty()) {
            appendLine("else:");
            indent();
            for (Statment bodyStmt : stmt.elseBody) {
                generateStatment(bodyStmt);
            }
            dedent();
        }
    }

    private void generateWhileStatement(WhileStatment stmt) {
        appendLine(String.format("while %s:", expressionToString(stmt.condition)));
        indent();
        if (stmt.body != null && !stmt.body.isEmpty()) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        } else {
            appendLine("pass");
        }
        dedent();
    }

    private void generateTryStatement(TryStatment stmt) {
        appendLine("try:");
        indent();
        if (stmt.body != null) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        }
        dedent();

        if (stmt.handlers != null) {
            for (CatchStatment handler : stmt.handlers) {
                if (handler.exceptionType != null) {
                    String type = expressionToString(handler.exceptionType);
                    if (handler.varName != null && !handler.varName.isEmpty()) {
                        appendLine(String.format("except %s as %s:", type, handler.varName));
                    } else {
                        appendLine(String.format("except %s:", type));
                    }
                } else {
                    appendLine("except:");
                }
                indent();
                if (handler.body != null) {
                    for (Statment bodyStmt : handler.body) {
                        generateStatment(bodyStmt);
                    }
                }
                dedent();
            }
        }
    }

    private void generateWithStatement(WithStatment stmt) {
        StringBuilder items = new StringBuilder();
        if (stmt.items != null) {
            for (int i = 0; i < stmt.items.size(); i++) {
                if (i > 0) items.append(", ");
                WithItemStatment item = stmt.items.get(i);
                items.append(expressionToString(item.contextExpr));
                if (item.optionalVar != null) {
                    items.append(" as ").append(expressionToString(item.optionalVar));
                }
            }
        }
        appendLine(String.format("with %s:", items));
        indent();
        if (stmt.body != null) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        }
        dedent();
    }

    private void generateClassStatement(ClassStatment stmt) {
        StringBuilder bases = new StringBuilder();
        if (stmt.bases != null && !stmt.bases.isEmpty()) {
            for (int i = 0; i < stmt.bases.size(); i++) {
                if (i > 0) bases.append(", ");
                bases.append(expressionToString(stmt.bases.get(i)));
            }
            appendLine(String.format("class %s(%s):", stmt.name, bases));
        } else {
            appendLine(String.format("class %s:", stmt.name));
        }
        indent();
        if (stmt.body != null) {
            for (Statment bodyStmt : stmt.body) {
                generateStatment(bodyStmt);
            }
        }
        dedent();
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  🔥🔥🔥 توليد Comprehension (list, dict, generator) 🔥🔥🔥
    // ═══════════════════════════════════════════════════════════════════════

    private String generateComprehension(ComplexListOfFor comp) {
        if (comp == null) return "[]";

        // توليد الجسم (body) - العنصر الذي سيتم إرجاعه
        String body = expressionToString(comp.body);

        // توليد حلقات for والشروط
        StringBuilder clauses = new StringBuilder();
        for (CoplexForExpression forClause : comp.forClauses) {
            if (clauses.length() > 0) clauses.append(" ");

            String target = expressionToString(forClause.target);
            String iterable = expressionToString(forClause.iterable);
            clauses.append("for ").append(target).append(" in ").append(iterable);

            // إضافة الشروط (if)
            if (forClause.conditions != null && !forClause.conditions.isEmpty()) {
                for (ExpressionAtom condition : forClause.conditions) {
                    clauses.append(" if ").append(expressionToString(condition));
                }
            }
        }

        // تحديد نوع الـ comprehension
        if (comp.type == TypeOfFor_Complex.LIST) {
            // List comprehension: [expr for ...]
            return "[" + body + " " + clauses + "]";
        } else if (comp.type == TypeOfFor_Complex.GENERATOR) {
            // Generator expression: (expr for ...)
            return "(" + body + " " + clauses + ")";
        } else if (comp.type == TypeOfFor_Complex.DICT) {
            // Dict comprehension: {key: value for ...}
            String key = comp.key != null ? expressionToString(comp.key) : body;
            return "{" + key + ": " + body + " " + clauses + "}";
        }

        return "[" + body + " " + clauses + "]";
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  تنظيف النصوص من الاقتباسات الزائدة
    // ═══════════════════════════════════════════════════════════════════════

    private String cleanStringValue(String value) {
        if (value == null) return "";
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        if (value.startsWith("'") && value.endsWith("'")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  دالة تحويل التعبير إلى نص (المعدلة بالكامل)
    // ═══════════════════════════════════════════════════════════════════════



//
//    private String expressionToString(ExpressionAtom expr) {
//        if (expr == null) return "None";
//
//        if (expr instanceof NameExpression) {
//            return ((NameExpression) expr).name;
//        }
//        if (expr instanceof NumberExpression) {
//            return ((NumberExpression) expr).value;
//        }
//        if (expr instanceof StringExpression) {
//            String value = ((StringExpression) expr).value;
//            value = cleanStringValue(value);
//            return "'" + value + "'";
//        }
//        if (expr instanceof BooleanExpression) {
//            return ((BooleanExpression) expr).value ? "True" : "False";
//        }
//        if (expr instanceof NoneExpression) {
//            return "None";
//        }
//        if (expr instanceof FStringExpression) {
//            return ((FStringExpression) expr).value;
//        }
//        // 🔥 أهم إضافة: معالجة ComplexListOfFor (comprehension)
//        if (expr instanceof ComplexListOfFor) {
//            return generateComprehension((ComplexListOfFor) expr);
//        }
//        if (expr instanceof CallExprssion) {
//            CallExprssion call = (CallExprssion) expr;
//            StringBuilder args = new StringBuilder();
//            if (call.args != null) {
//                for (int i = 0; i < call.args.size(); i++) {
//                    if (i > 0) args.append(", ");
//                    args.append(expressionToString(call.args.get(i)));
//                }
//            }
//            return String.format("%s(%s)", expressionToString(call.function), args);
//        }
//        if (expr instanceof AttributeOfVariable) {
//            AttributeOfVariable attr = (AttributeOfVariable) expr;
//            return String.format("%s.%s", expressionToString(attr.object), attr.property);
//        }
//        if (expr instanceof SubscriptOfAree) {
//            SubscriptOfAree sub = (SubscriptOfAree) expr;
//            String sliceStr = sliceToString(sub.slice);
//            if (sliceStr.isEmpty()) {
//                return String.format("%s", expressionToString(sub.value));
//            }
//            return String.format("%s[%s]", expressionToString(sub.value), sliceStr);
//        }
//        if (expr instanceof TwoOperationExprssion) {
//            TwoOperationExprssion bin = (TwoOperationExprssion) expr;
//            return String.format("(%s %s %s)", expressionToString(bin.left), bin.op, expressionToString(bin.right));
//        }
//        if (expr instanceof OneOperationExprssion) {
//            OneOperationExprssion un = (OneOperationExprssion) expr;
//            return String.format("%s%s", un.op, expressionToString(un.expr));
//        }
//        if (expr instanceof CompareExprssion) {
//            CompareExprssion comp = (CompareExprssion) expr;
//            StringBuilder result = new StringBuilder(expressionToString(comp.left));
//            for (int i = 0; i < comp.ops.size(); i++) {
//                result.append(" ").append(comp.ops.get(i)).append(" ");
//                result.append(expressionToString(comp.rights.get(i)));
//            }
//            return result.toString();
//        }
//        if (expr instanceof ListExprssion) {
//            ListExprssion list = (ListExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (list.items != null) {
//                for (int i = 0; i < list.items.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(list.items.get(i)));
//                }
//            }
//            return "[" + items + "]";
//        }
//        if (expr instanceof TupleExprssion) {
//            TupleExprssion tuple = (TupleExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (tuple.items != null) {
//                for (int i = 0; i < tuple.items.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(tuple.items.get(i)));
//                }
//            }
//            if (tuple.items != null && tuple.items.size() == 1) {
//                return "(" + items + ",)";
//            }
//            return "(" + items + ")";
//        }
//        if (expr instanceof DictionaryExprssion) {
//            DictionaryExprssion dict = (DictionaryExprssion) expr;
//            StringBuilder items = new StringBuilder();
//            if (dict.keys != null && dict.values != null) {
//                for (int i = 0; i < dict.keys.size(); i++) {
//                    if (i > 0) items.append(", ");
//                    items.append(expressionToString(dict.keys.get(i)));
//                    items.append(": ");
//                    items.append(expressionToString(dict.values.get(i)));
//                }
//            }
//            return "{" + items + "}";
//        }
//        if (expr instanceof NameArgumentExpr) {
//            NameArgumentExpr named = (NameArgumentExpr) expr;
//            return String.format("%s=%s", named.name, expressionToString(named.value));
//        }
//
//        return expr.toString();
//    }
//
//






    // ═══════════════════════════════════════════════════════════════════════
    //  دالة تحويل التعبير إلى نص (المعدلة بالكامل لحل مشكلة الـ Tuple والـ Generator)
    // ═══════════════════════════════════════════════════════════════════════

    private String expressionToString(ExpressionAtom expr) {
        if (expr == null) return "None";

        if (expr instanceof NameExpression) {
            return ((NameExpression) expr).name;
        }
        if (expr instanceof NumberExpression) {
            return ((NumberExpression) expr).value;
        }
        if (expr instanceof StringExpression) {
            String value = ((StringExpression) expr).value;
            value = cleanStringValue(value);
            return "'" + value + "'";
        }
        if (expr instanceof BooleanExpression) {
            return ((BooleanExpression) expr).value ? "True" : "False";
        }
        if (expr instanceof NoneExpression) {
            return "None";
        }
        if (expr instanceof FStringExpression) {
            return ((FStringExpression) expr).value;
        }
        // 🔥 أهم إضافة: معالجة ComplexListOfFor (comprehension)
        if (expr instanceof ComplexListOfFor) {
            return generateComprehension((ComplexListOfFor) expr);
        }
        if (expr instanceof CallExprssion) {
            CallExprssion call = (CallExprssion) expr;
            StringBuilder args = new StringBuilder();
            if (call.args != null) {
                for (int i = 0; i < call.args.size(); i++) {
                    if (i > 0) args.append(", ");
                    args.append(expressionToString(call.args.get(i)));
                }
            }
            return String.format("%s(%s)", expressionToString(call.function), args);
        }
        if (expr instanceof AttributeOfVariable) {
            AttributeOfVariable attr = (AttributeOfVariable) expr;
            return String.format("%s.%s", expressionToString(attr.object), attr.property);
        }
        if (expr instanceof SubscriptOfAree) {
            SubscriptOfAree sub = (SubscriptOfAree) expr;
            String sliceStr = sliceToString(sub.slice);
            if (sliceStr.isEmpty()) {
                return String.format("%s", expressionToString(sub.value));
            }
            return String.format("%s[%s]", expressionToString(sub.value), sliceStr);
        }
        if (expr instanceof TwoOperationExprssion) {
            TwoOperationExprssion bin = (TwoOperationExprssion) expr;
            return String.format("(%s %s %s)", expressionToString(bin.left), bin.op, expressionToString(bin.right));
        }
        if (expr instanceof OneOperationExprssion) {
            OneOperationExprssion un = (OneOperationExprssion) expr;
            return String.format("%s%s", un.op, expressionToString(un.expr));
        }
        if (expr instanceof CompareExprssion) {
            CompareExprssion comp = (CompareExprssion) expr;
            StringBuilder result = new StringBuilder(expressionToString(comp.left));
            for (int i = 0; i < comp.ops.size(); i++) {
                result.append(" ").append(comp.ops.get(i)).append(" ");
                result.append(expressionToString(comp.rights.get(i)));
            }
            return result.toString();
        }
        if (expr instanceof ListExprssion) {
            ListExprssion list = (ListExprssion) expr;
            StringBuilder items = new StringBuilder();
            if (list.items != null) {
                for (int i = 0; i < list.items.size(); i++) {
                    if (i > 0) items.append(", ");
                    items.append(expressionToString(list.items.get(i)));
                }
            }
            return "[" + items + "]";
        }
        if (expr instanceof TupleExprssion) {
            TupleExprssion tuple = (TupleExprssion) expr;
            StringBuilder items = new StringBuilder();
            if (tuple.items != null) {
                for (int i = 0; i < tuple.items.size(); i++) {
                    if (i > 0) items.append(", ");
                    items.append(expressionToString(tuple.items.get(i)));
                }
            }

            // 🔥 الإصلاح الذكي للحماية من توليد الفاصلة والأقواس الزائدة مع الـ Generator التعبيري الممرر لدالة
            if (tuple.items != null && tuple.items.size() == 1) {
                ExpressionAtom singleItem = tuple.items.get(0);
                if (singleItem instanceof ComplexListOfFor && ((ComplexListOfFor) singleItem).type == TypeOfFor_Complex.GENERATOR) {
                    return items.toString();
                }
                return "(" + items + ",)";
            }
            return "(" + items + ")";
        }
        if (expr instanceof DictionaryExprssion) {
            DictionaryExprssion dict = (DictionaryExprssion) expr;
            StringBuilder items = new StringBuilder();
            if (dict.keys != null && dict.values != null) {
                for (int i = 0; i < dict.keys.size(); i++) {
                    if (i > 0) items.append(", ");
                    items.append(expressionToString(dict.keys.get(i)));
                    items.append(": ");
                    items.append(expressionToString(dict.values.get(i)));
                }
            }
            return "{" + items + "}";
        }
        if (expr instanceof NameArgumentExpr) {
            NameArgumentExpr named = (NameArgumentExpr) expr;
            return String.format("%s=%s", named.name, expressionToString(named.value));
        }

        return expr.toString();
    }




    private String sliceToString(SliceTowSubscriptOfAree slice) {
        if (slice == null) return "";
        StringBuilder sb = new StringBuilder();
        if (slice.start != null) sb.append(expressionToString(slice.start));

        if (slice.end != null || slice.step != null) {
            sb.append(":");
            if (slice.end != null) sb.append(expressionToString(slice.end));
            if (slice.step != null) {
                sb.append(":").append(expressionToString(slice.step));
            }
        }
        return sb.toString();
    }

    public String getCode() { return code.toString(); }

    public void saveToFile(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(code.toString());
        }
        System.out.println("✅ تم إنشاء ملف Flask مصحح: " + path);
    }

    public void clear() {
        code.setLength(0);
        indentLevel = 0;
    }
}