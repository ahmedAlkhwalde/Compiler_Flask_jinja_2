package Merge_Symbol_tables;


//
//import ASTFlask.ASTPrinter;
//import ASTFlask.Proge;
//import ASTFlask.Statment;
//import ASTFlask.SymbolTable.*;
//import AST_HTMLCSSJINJA.*;
//import VISITORJINJA.VisitorJinja;
//import VISITORJINJA.VisitorJinjaSymbolTable;
//import VISITORJINJA.ST.*;
//import VisitorFlask.Visitor;
//import VisitorFlask.SymbolTableBuilder;
//import antlrFlask.ProjectLexer;
//import antlrFlask.ProjectParser;
//import antlrJinja.HTMLCSSJINJA_lexer;
//import antlrJinja.HTMLCSSJINJA_parser;
//import org.antlr.v4.runtime.CharStream;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.Token;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//
//import static org.antlr.v4.runtime.CharStreams.fromFileName;
//
//public class Compiler {
//
//    public static void main(String[] args) throws IOException {
//        System.out.println("╔══════════════════════════════════════════════════════════════╗");
//        System.out.println("║     مترجم Flask + Jinja2 المتكامل - تحليل ورموز ودمج        ║");
//        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");
//
//        // ==================== 1. تحليل Python/Flask (مثل MainFlask) ====================
//        System.out.println("📁 [1/4] تحليل ملف Flask (Python)...");
//        String flaskFile = "Files/Flask.txt";
//
//        // عرض محتوى الملف
//        System.out.println("\n=== FILE CONTENT (Flask) ===");
//        String flaskContent = Files.readString(Paths.get(flaskFile));
//        System.out.println(flaskContent);
//        System.out.println("============================\n");
//
//        CharStream flaskStream = fromFileName(flaskFile);
//        ProjectLexer flaskLexer = new ProjectLexer(flaskStream);
//        CommonTokenStream flaskTokens = new CommonTokenStream(flaskLexer);
//        flaskTokens.fill();
//
//        // عرض تحليل التوكنز
//        System.out.println("=== TOKEN ANALYSIS (Flask) ===");
//        for (Token t : flaskTokens.getTokens()) {
//            String tokenName = flaskLexer.VOCABULARY.getSymbolicName(t.getType());
//            if (tokenName != null && !tokenName.equals("EOF")) {
//                System.out.printf("TOKEN: %-20s -> '%s' (Line: %d, Column: %d)\n",
//                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
//            }
//        }
//        System.out.println("==============================\n");
//
//        ProjectParser flaskParser = new ProjectParser(flaskTokens);
//        ParseTree flaskTree = flaskParser.proge();
//
//        // بناء AST لـ Flask
//        Visitor flaskVisitor = new Visitor();
//        Proge flaskProgram = (Proge) flaskVisitor.visit(flaskTree);
//
//        // طباعة AST لـ Flask (مثل MainFlask)
//        System.out.println("=== ABSTRACT SYNTAX TREE (Flask) ===");
//        System.out.println(ASTPrinter.printTree(flaskProgram));
//        System.out.println("====================================\n");
//
//        // بناء جدول رموز Flask
//        System.out.println("=== SYMBOL TABLE CONSTRUCTION (Flask) ===");
//        SymbolTableBuilder flaskSymbolBuilder = new SymbolTableBuilder();
//        flaskSymbolBuilder.visit(flaskTree);
//        System.out.println("=========================================\n");
//
//        // طباعة جدول رموز Flask
//        Operationflask.displaySymbolTable(flaskSymbolBuilder);
//
//        // ==================== 2. تحليل HTML/Jinja2 (مثل MainJinja) ====================
//        System.out.println("\n📁 [2/4] تحليل ملف HTML/Jinja2...");
//        String jinjaFile = "Files/html.txt";
//
//        // عرض محتوى الملف
//        System.out.println("\n=== FILE CONTENT (HTML/Jinja2) ===");
//        String jinjaContent = Files.readString(Paths.get(jinjaFile));
//        System.out.println(jinjaContent);
//        System.out.println("================================\n");
//
//        CharStream jinjaStream = CharStreams.fromFileName(jinjaFile);
//        HTMLCSSJINJA_lexer jinjaLexer = new HTMLCSSJINJA_lexer(jinjaStream);
//        CommonTokenStream jinjaTokens = new CommonTokenStream(jinjaLexer);
//        jinjaTokens.fill();
//
//        // عرض تحليل التوكنز (مثل MainJinja)
//        System.out.println("=== TOKEN ANALYSIS (HTML/Jinja2) ===");
//        for (Token t : jinjaTokens.getTokens()) {
//            String tokenName = jinjaLexer.VOCABULARY.getSymbolicName(t.getType());
//            if (tokenName != null && !tokenName.equals("EOF")) {
//                System.out.printf("TOKEN: %-25s -> '%s' (السطر: %d, العمود: %d)\n",
//                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
//            }
//        }
//        System.out.println("===================================\n");
//
//        HTMLCSSJINJA_parser jinjaParser = new HTMLCSSJINJA_parser(jinjaTokens);
//        ParseTree jinjaTree = jinjaParser.document();
//
//        // بناء AST لـ Jinja2 (مثل MainJinja)
//        System.out.println("=== ABSTRACT SYNTAX TREE (HTML/Jinja2) ===");
//        VisitorJinja jinjaVisitor = new VisitorJinja();
//        ASTNode jinjaRoot = jinjaVisitor.visit(jinjaTree);
//
//        if (jinjaRoot instanceof DocumentNode) {
//            ((DocumentNode) jinjaRoot).print();
//        }
//        System.out.println("==========================================\n");
//
//        // بناء جدول رموز Jinja (مثل MainJinja)
//        System.out.println("=== SYMBOL TABLE CONSTRUCTION (HTML/Jinja2) ===");
//        VisitorJinjaSymbolTable jinjaSymbolBuilder = new VisitorJinjaSymbolTable(jinjaVisitor);
//        jinjaSymbolBuilder.visit(jinjaTree);
//        HtmlCssJinjaSymbolTable jinjaSymbolTable = jinjaSymbolBuilder.getSymbolTable();
//        System.out.println("تم بناء جدول الرموز بنجاح!");
//        System.out.println("================================================\n");
//
//        // طباعة جدول رموز Jinja
//        Operation.displaySymbolTable(jinjaSymbolTable);
//
//        // ==================== 3. بناء جدول الرموز الموحّد ====================
//        System.out.println("\n🔗 [3/4] بناء جدول الرموز الموحّد وربط Python ↔ Jinja2...");
//
//        SymbolTable unifiedTable = new SymbolTable();
//
//        // نقل رموز Flask
//        transferFlaskSymbolsToUnified(flaskSymbolBuilder, unifiedTable);
//
//        // نقل رموز Jinja
//        transferJinjaSymbolsToUnified(jinjaSymbolTable, unifiedTable);
//
//        System.out.println("   ✅ تم نقل الرموز إلى الجدول الموحّد\n");
//
//        // ==================== 4. التحليل الدلالي وطباعة الجدول الموحّد ====================
////        System.out.println("⚙️  [4/4] التحليل الدلالي وطباعة جدول الرموز الموحّد...");
////
////        SemanticAnalyzer analyzer = new SemanticAnalyzer(unifiedTable);
////        analyzer.resolveAndValidate();
//
//
//        // ==================== 4. التحليل الدلالي وطباعة الجدول الموحّد ====================
//        System.out.println("⚙️  [4/4] التحليل الدلالي وطباعة جدول الرموز الموحّد...");
//
//        String flaskRawCode = Files.readString(Paths.get(flaskFile));  // اقرأ النص الخام
//
//        SemanticAnalyzer analyzer = new SemanticAnalyzer(unifiedTable, flaskSymbolBuilder, jinjaSymbolTable, flaskRawCode
//        );  // ✅ التصحيح
//        analyzer.resolveAndValidate();
//
//        // طباعة جدول الرموز الموحّد بشكل مفصل
//        unifiedTable.printTable();
//
//        // عرض الأخطاء
//        if (unifiedTable.hasErrors()) {
//            System.out.println("\n⚠️  الأخطاء الدلالية المكتشفة:");
//            for (String error : unifiedTable.getErrors()) {
//                System.out.println("   ❌ " + error);
//            }
//        } else {
//            System.out.println("\n✅ لا توجد أخطاء دلالية! جميع الروابط صحيحة.");
//        }
//
//        // طباعة الإحصائيات النهائية
//        printFinalStatistics(flaskSymbolBuilder, jinjaSymbolTable, unifiedTable);
//
//        System.out.println("\n✅ المشروع يعمل بنجاح! تم دمج Flask و Jinja2 في مترجم واحد.");
//    }
//
//    // ==================== نقل رموز Flask ====================
//
//    private static void transferFlaskSymbolsToUnified(SymbolTableBuilder source, SymbolTable target) {
//        System.out.println("   📦 نقل رموز Flask إلى الجدول الموحّد...");
//
//        Scope globalScope = source.getCurrentScope();
//        int count = 0;
//        int routeCount = 0;
//
//        // 1. نقل المتغيرات
//        for (ASTFlask.SymbolTable.Symbol symbol : globalScope.symbols.values()) {
//            if (symbol instanceof VariableSymbol) {
//                VariableSymbol var = (VariableSymbol) symbol;
//
//                if (var.name.equals("True") || var.name.equals("False") ||
//                        var.name.equals("None") || var.name.equals("__name__")) {
//                    continue;
//                }
//
//                if (var.type.equals("module") || var.type.equals("imported")) {
//                    continue;
//                }
//
//                SymbolTable.SymbolKind kind = SymbolTable.SymbolKind.VARIABLE;
//
//                if (var.type.equals("list") || (var.value instanceof List)) {
//                    kind = SymbolTable.SymbolKind.LIST;
//
//                    if (var.value instanceof List) {
//                        List<?> list = (List<?>) var.value;
//                        if (!list.isEmpty() && list.get(0) instanceof Map) {
//                            List<String> keys = new ArrayList<>();
//                            Map<?, ?> firstItem = (Map<?, ?>) list.get(0);
//                            for (Object key : firstItem.keySet()) {
//                                if (key instanceof String) {
//                                    keys.add((String) key);
//                                }
//                            }
//                            target.registerListKeys(var.name, keys);
//                        }
//                    }
//                }
//
//                SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
//                        var.name, var.type, kind,
//                        SymbolTable.SymbolSource.PYTHON, var.line
//                );
//                target.addPythonSymbol(unifiedSym);
//                count++;
//            }
//        }
//
//        // 2. نقل الدوال (Routes)
//        for (ASTFlask.SymbolTable.Symbol symbol : globalScope.symbols.values()) {
//            if (symbol instanceof FunctionSymbol) {
//                FunctionSymbol func = (FunctionSymbol) symbol;
//
//                boolean isRoute = func.name.startsWith("show_") ||
//                        func.name.startsWith("product_") ||
//                        func.name.startsWith("add_") ||
//                        func.name.startsWith("delete_");
//
//                SymbolTable.SymbolKind kind = isRoute ? SymbolTable.SymbolKind.ROUTE : SymbolTable.SymbolKind.VARIABLE;
//
//                SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
//                        func.name, "function", kind,
//                        SymbolTable.SymbolSource.PYTHON, func.line
//                );
//
//                if (isRoute) {
//                    routeCount++;
//                    unifiedSym.linkedFile = "products.html";
//
//                    if (func.name.contains("products")) {
//                        unifiedSym.linkedTo = "products";
//                    } else if (func.name.contains("product")) {
//                        unifiedSym.linkedTo = "product";
//                    } else if (func.name.contains("add")) {
//                        unifiedSym.linkedTo = "add_form";
//                    } else if (func.name.contains("delete")) {
//                        unifiedSym.linkedTo = "product";
//                    }
//                }
//
//                target.addPythonSymbol(unifiedSym);
//                count++;
//            }
//        }
//
//        System.out.println("      ✅ تم نقل " + count + " رمز من Flask (" + routeCount + " routes)");
//    }
//
//    // ==================== نقل رموز Jinja ====================
//
//    private static void transferJinjaSymbolsToUnified(HtmlCssJinjaSymbolTable source, SymbolTable target) {
//        System.out.println("   📦 نقل رموز Jinja إلى الجدول الموحّد...");
//        int count = 0;
//        int loopCount = 0;
//
//        // 1. إضافة القالب الرئيسي
//        SymbolTable.Symbol templateSym = new SymbolTable.Symbol(
//                "products.html", "template",
//                SymbolTable.SymbolKind.TEMPLATE,
//                SymbolTable.SymbolSource.JINJA, 1
//        );
//        target.addJinjaSymbol(templateSym);
//        count++;
//
//        // 2. نقل حلقات FOR
//        for (VISITORJINJA.ST.Symbol symbol : source.findSymbolsByType("JINJA")) {
//            if (symbol instanceof JinjaSymbol) {
//                JinjaSymbol jinja = (JinjaSymbol) symbol;
//
//                String content = jinja.getContent();
//                if (content != null && (content.contains(" for ") || content.contains(" in "))) {
//                    String loopVar = null;
//                    String iterable = null;
//
//                    if (content.contains(" in ")) {
//                        String[] parts = content.split(" in ");
//                        if (parts.length >= 2) {
//                            String varPart = parts[0].trim();
//                            if (varPart.startsWith("for ")) {
//                                varPart = varPart.substring(4).trim();
//                            }
//                            loopVar = varPart;
//                            iterable = parts[1].trim();
//                        }
//                    }
//
//                    if (loopVar != null && iterable != null) {
//                        SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
//                                loopVar, "loop_var",
//                                SymbolTable.SymbolKind.LOOP_VAR,
//                                SymbolTable.SymbolSource.JINJA, jinja.getLine()
//                        );
//                        unifiedSym.linkedTo = iterable;
//                        target.addJinjaSymbol(unifiedSym);
//                        loopCount++;
//                        count++;
//                    }
//                }
//            }
//        }
//
//        System.out.println("      ✅ تم نقل " + count + " رمز من Jinja (" + loopCount + " loops)");
//    }
//
//    // ==================== دوال مساعدة ====================
//
//    private static void printFinalStatistics(SymbolTableBuilder flaskBuilder,
//                                             HtmlCssJinjaSymbolTable jinjaTable,
//                                             SymbolTable unifiedTable) {
//        // إحصائيات Flask
//        int functions = 0, variables = 0, imports = 0, classes = 0;
//        Scope scope = flaskBuilder.getCurrentScope();
//        for (ASTFlask.SymbolTable.Symbol symbol : scope.symbols.values()) {
//            if (symbol instanceof FunctionSymbol) {
//                functions++;
//            } else if (symbol instanceof VariableSymbol) {
//                VariableSymbol var = (VariableSymbol) symbol;
//                if (var.type.equals("module") || var.type.equals("imported")) {
//                    imports++;
//                } else if (!var.name.equals("True") && !var.name.equals("False") &&
//                        !var.name.equals("None") && !var.name.equals("__name__")) {
//                    variables++;
//                }
//            } else if (symbol instanceof ClassSymbol) {
//                classes++;
//            }
//        }
//
//        System.out.println("\n═══════════════════════════════════════════════════════════════");
//        System.out.println("                    📊 الإحصائيات النهائية");
//        System.out.println("═══════════════════════════════════════════════════════════════");
//
//        System.out.println("\n🔹 Python/Flask:");
//        System.out.println("   • الدوال: " + functions);
//        System.out.println("   • المتغيرات: " + variables);
//        System.out.println("   • الأصناف: " + classes);
//        System.out.println("   • الإستيرادات: " + imports);
//
//        System.out.println("\n🔹 HTML/CSS/Jinja2:");
//        System.out.println("   • عناصر HTML: " + jinjaTable.htmlElementCount);
//        System.out.println("   • قواعد CSS: " + jinjaTable.cssRuleCount);
//        System.out.println("   • تعبيرات Jinja: " + jinjaTable.jinjaSymbolCount);
//
//        System.out.println("\n🔹 الجدول الموحّد (بعد الربط):");
//        System.out.println("   • رموز Python: " + unifiedTable.getAllPythonSymbols().size());
//        System.out.println("   • رموز Jinja2: " + unifiedTable.getAllJinjaSymbols().size());
//
//        int resolvedCount = 0;
//        for (SymbolTable.Symbol sym : unifiedTable.getAllPythonSymbols().values()) {
//            if (sym.isResolved) resolvedCount++;
//        }
//        for (SymbolTable.Symbol sym : unifiedTable.getAllJinjaSymbols().values()) {
//            if (sym.isResolved) resolvedCount++;
//        }
//        System.out.println("   • الروابط الناجحة: " + resolvedCount);
//        System.out.println("   • الأخطاء الدلالية: " + unifiedTable.getErrors().size());
//    }
//}















import ASTFlask.ASTPrinter;
import ASTFlask.Proge;
import ASTFlask.Statment;
import ASTFlask.SymbolTable.*;
import AST_HTMLCSSJINJA.*;
import Generation_Flask_Jinja.FlaskCodeGenerator;
import Generation_Flask_Jinja.JinjaCodeGenerator;
import VISITORJINJA.VisitorJinja;
import VISITORJINJA.VisitorJinjaSymbolTable;
import VISITORJINJA.ST.*;
import VisitorFlask.Visitor;
import VisitorFlask.SymbolTableBuilder;
import antlrFlask.ProjectLexer;
import antlrFlask.ProjectParser;
import antlrJinja.HTMLCSSJINJA_lexer;
import antlrJinja.HTMLCSSJINJA_parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Compiler {

    public static void main(String[] args) throws IOException {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     مترجم Flask + Jinja2 المتكامل - تحليل ورموز ودمج        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // ==================== 1. تحليل Python/Flask ====================
        System.out.println("📁 [1/5] تحليل ملف Flask (Python)...");
        String flaskFile = "Files/Flask.txt";

        // عرض محتوى الملف
        System.out.println("\n=== FILE CONTENT (Flask) ===");
        String flaskContent = Files.readString(Paths.get(flaskFile));
        System.out.println(flaskContent);
        System.out.println("============================\n");

        CharStream flaskStream = fromFileName(flaskFile);
        ProjectLexer flaskLexer = new ProjectLexer(flaskStream);
        CommonTokenStream flaskTokens = new CommonTokenStream(flaskLexer);
        flaskTokens.fill();

        // عرض تحليل التوكنز
        System.out.println("=== TOKEN ANALYSIS (Flask) ===");
        for (Token t : flaskTokens.getTokens()) {
            String tokenName = flaskLexer.VOCABULARY.getSymbolicName(t.getType());
            if (tokenName != null && !tokenName.equals("EOF")) {
                System.out.printf("TOKEN: %-20s -> '%s' (Line: %d, Column: %d)\n",
                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
            }
        }
        System.out.println("==============================\n");

        ProjectParser flaskParser = new ProjectParser(flaskTokens);
        ParseTree flaskTree = flaskParser.proge();

        // بناء AST لـ Flask
        Visitor flaskVisitor = new Visitor();
        Proge flaskProgram = (Proge) flaskVisitor.visit(flaskTree);

        // طباعة AST لـ Flask
        System.out.println("=== ABSTRACT SYNTAX TREE (Flask) ===");
        System.out.println(ASTPrinter.printTree(flaskProgram));
        System.out.println("====================================\n");

        // بناء جدول رموز Flask
        System.out.println("=== SYMBOL TABLE CONSTRUCTION (Flask) ===");
        SymbolTableBuilder flaskSymbolBuilder = new SymbolTableBuilder();
        flaskSymbolBuilder.visit(flaskTree);
        System.out.println("=========================================\n");

        // طباعة جدول رموز Flask
        Operationflask.displaySymbolTable(flaskSymbolBuilder);

        // ==================== 2. تحليل HTML/Jinja2 ====================
        System.out.println("\n📁 [2/5] تحليل ملف HTML/Jinja2...");
        String jinjaFile = "Files/html.txt";

        // عرض محتوى الملف
        System.out.println("\n=== FILE CONTENT (HTML/Jinja2) ===");
        String jinjaContent = Files.readString(Paths.get(jinjaFile));
        System.out.println(jinjaContent);
        System.out.println("================================\n");

        CharStream jinjaStream = CharStreams.fromFileName(jinjaFile);
        HTMLCSSJINJA_lexer jinjaLexer = new HTMLCSSJINJA_lexer(jinjaStream);
        CommonTokenStream jinjaTokens = new CommonTokenStream(jinjaLexer);
        jinjaTokens.fill();

        // عرض تحليل التوكنز
        System.out.println("=== TOKEN ANALYSIS (HTML/Jinja2) ===");
        for (Token t : jinjaTokens.getTokens()) {
            String tokenName = jinjaLexer.VOCABULARY.getSymbolicName(t.getType());
            if (tokenName != null && !tokenName.equals("EOF")) {
                System.out.printf("TOKEN: %-25s -> '%s' (السطر: %d, العمود: %d)\n",
                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
            }
        }
        System.out.println("===================================\n");

        HTMLCSSJINJA_parser jinjaParser = new HTMLCSSJINJA_parser(jinjaTokens);
        ParseTree jinjaTree = jinjaParser.document();

        // بناء AST لـ Jinja2
        System.out.println("=== ABSTRACT SYNTAX TREE (HTML/Jinja2) ===");
        VisitorJinja jinjaVisitor = new VisitorJinja();
        ASTNode jinjaRoot = jinjaVisitor.visit(jinjaTree);

        if (jinjaRoot instanceof DocumentNode) {
            ((DocumentNode) jinjaRoot).print();
        }
        System.out.println("==========================================\n");

        // بناء جدول رموز Jinja
        System.out.println("=== SYMBOL TABLE CONSTRUCTION (HTML/Jinja2) ===");
        VisitorJinjaSymbolTable jinjaSymbolBuilder = new VisitorJinjaSymbolTable(jinjaVisitor);
        jinjaSymbolBuilder.visit(jinjaTree);
        HtmlCssJinjaSymbolTable jinjaSymbolTable = jinjaSymbolBuilder.getSymbolTable();
        System.out.println("تم بناء جدول الرموز بنجاح!");
        System.out.println("================================================\n");

        // طباعة جدول رموز Jinja
        Operation.displaySymbolTable(jinjaSymbolTable);

        // ==================== 3. بناء جدول الرموز الموحّد ====================
        System.out.println("\n🔗 [3/5] بناء جدول الرموز الموحّد وربط Python ↔ Jinja2...");

        SymbolTable unifiedTable = new SymbolTable();

        // نقل رموز Flask
        transferFlaskSymbolsToUnified(flaskSymbolBuilder, unifiedTable);

        // نقل رموز Jinja
        transferJinjaSymbolsToUnified(jinjaSymbolTable, unifiedTable);

        System.out.println("   ✅ تم نقل الرموز إلى الجدول الموحّد\n");

        // ==================== 4. التحليل الدلالي ====================
        System.out.println("⚙️  [4/5] التحليل الدلالي...");

        String flaskRawCode = Files.readString(Paths.get(flaskFile));

        SemanticAnalyzer analyzer = new SemanticAnalyzer(unifiedTable, flaskSymbolBuilder, jinjaSymbolTable, flaskRawCode);
        analyzer.resolveAndValidate();

        // طباعة جدول الرموز الموحّد بشكل مفصل
        unifiedTable.printTable();

        // عرض الأخطاء
        boolean hasErrors = unifiedTable.hasErrors();

        if (hasErrors) {
            System.out.println("\n⚠️  الأخطاء الدلالية المكتشفة (" + unifiedTable.getErrors().size() + "):");
            for (String error : unifiedTable.getErrors()) {
                System.out.println("   ❌ " + error);
            }
            System.out.println("\n🛑 **تم اكتشاف أخطاء دلالية، لن يتم توليد الكود!** 🛑");
            System.out.println("   يرجى تصحيح الأخطاء المذكورة أعلاه وإعادة تشغيل المترجم.");
        } else {
            System.out.println("\n✅ لا توجد أخطاء دلالية! جميع الروابط صحيحة.");

            // ==================== 5. توليد الكود (فقط إذا لم توجد أخطاء) ====================
            System.out.println("\n📁 [5/5] توليد الكود من AST...");

            try {
                // توليد كود Flask
                FlaskCodeGenerator flaskGenerator = new FlaskCodeGenerator();
                flaskGenerator.generate(flaskProgram);
                flaskGenerator.saveToFile("Files/generated_app.py");

                // توليد قالب Jinja2
                JinjaCodeGenerator jinjaGenerator = new JinjaCodeGenerator();
                jinjaGenerator.generate(jinjaRoot);
                jinjaGenerator.saveToFile("Files/generated_template.html");

                System.out.println("\n✅ تم توليد الكود بنجاح!");
                System.out.println("   📄 ملف Flask: Files/generated_app.py");
                System.out.println("   📄 ملف القالب: Files/generated_template.html");
                System.out.println("\n💡 لتشغيل التطبيق:");
                System.out.println("   1. افتح الملفين المولَدين");
                System.out.println("   2. قم بتثبيت Flask: pip install flask");
                System.out.println("   3. قم بتشغيل: python Files/generated_app.py");

            } catch (Exception e) {
                System.err.println("❌ خطأ أثناء توليد الكود: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // طباعة الإحصائيات النهائية
        printFinalStatistics(flaskSymbolBuilder, jinjaSymbolTable, unifiedTable);

        System.out.println("\n✅ المشروع يعمل بنجاح! تم دمج Flask و Jinja2 في مترجم واحد.");
    }

    // ==================== نقل رموز Flask ====================

    private static void transferFlaskSymbolsToUnified(SymbolTableBuilder source, SymbolTable target) {
        System.out.println("   📦 نقل رموز Flask إلى الجدول الموحّد...");

        Scope globalScope = source.getCurrentScope();
        int count = 0;
        int routeCount = 0;

        // 1. نقل المتغيرات
        for (ASTFlask.SymbolTable.Symbol symbol : globalScope.symbols.values()) {
            if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;

                if (var.name.equals("True") || var.name.equals("False") ||
                        var.name.equals("None") || var.name.equals("__name__")) {
                    continue;
                }

                if (var.type.equals("module") || var.type.equals("imported")) {
                    continue;
                }

                SymbolTable.SymbolKind kind = SymbolTable.SymbolKind.VARIABLE;

                if (var.type.equals("list") || (var.value instanceof List)) {
                    kind = SymbolTable.SymbolKind.LIST;

                    if (var.value instanceof List) {
                        List<?> list = (List<?>) var.value;
                        if (!list.isEmpty() && list.get(0) instanceof Map) {
                            List<String> keys = new ArrayList<>();
                            Map<?, ?> firstItem = (Map<?, ?>) list.get(0);
                            for (Object key : firstItem.keySet()) {
                                if (key instanceof String) {
                                    keys.add((String) key);
                                }
                            }
                            target.registerListKeys(var.name, keys);
                        }
                    }
                }

                SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
                        var.name, var.type, kind,
                        SymbolTable.SymbolSource.PYTHON, var.line
                );
                target.addPythonSymbol(unifiedSym);
                count++;
            }
        }

        // 2. نقل الدوال (Routes)
        for (ASTFlask.SymbolTable.Symbol symbol : globalScope.symbols.values()) {
            if (symbol instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) symbol;

                boolean isRoute = func.name.startsWith("show_") ||
                        func.name.startsWith("product_") ||
                        func.name.startsWith("add_") ||
                        func.name.startsWith("delete_");

                SymbolTable.SymbolKind kind = isRoute ? SymbolTable.SymbolKind.ROUTE : SymbolTable.SymbolKind.VARIABLE;

                SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
                        func.name, "function", kind,
                        SymbolTable.SymbolSource.PYTHON, func.line
                );

                if (isRoute) {
                    routeCount++;
                    unifiedSym.linkedFile = "products.html";

                    if (func.name.contains("products")) {
                        unifiedSym.linkedTo = "products";
                    } else if (func.name.contains("product")) {
                        unifiedSym.linkedTo = "product";
                    } else if (func.name.contains("add")) {
                        unifiedSym.linkedTo = "add_form";
                    } else if (func.name.contains("delete")) {
                        unifiedSym.linkedTo = "product";
                    }
                }

                target.addPythonSymbol(unifiedSym);
                count++;
            }
        }

        System.out.println("      ✅ تم نقل " + count + " رمز من Flask (" + routeCount + " routes)");
    }

    // ==================== نقل رموز Jinja ====================

    private static void transferJinjaSymbolsToUnified(HtmlCssJinjaSymbolTable source, SymbolTable target) {
        System.out.println("   📦 نقل رموز Jinja إلى الجدول الموحّد...");
        int count = 0;
        int loopCount = 0;

        // 1. إضافة القالب الرئيسي
        SymbolTable.Symbol templateSym = new SymbolTable.Symbol(
                "products.html", "template",
                SymbolTable.SymbolKind.TEMPLATE,
                SymbolTable.SymbolSource.JINJA, 1
        );
        target.addJinjaSymbol(templateSym);
        count++;

        // 2. نقل حلقات FOR
        for (VISITORJINJA.ST.Symbol symbol : source.findSymbolsByType("JINJA")) {
            if (symbol instanceof JinjaSymbol) {
                JinjaSymbol jinja = (JinjaSymbol) symbol;

                String content = jinja.getContent();
                if (content != null && (content.contains(" for ") || content.contains(" in "))) {
                    String loopVar = null;
                    String iterable = null;

                    if (content.contains(" in ")) {
                        String[] parts = content.split(" in ");
                        if (parts.length >= 2) {
                            String varPart = parts[0].trim();
                            if (varPart.startsWith("for ")) {
                                varPart = varPart.substring(4).trim();
                            }
                            loopVar = varPart;
                            iterable = parts[1].trim();
                        }
                    }

                    if (loopVar != null && iterable != null) {
                        SymbolTable.Symbol unifiedSym = new SymbolTable.Symbol(
                                loopVar, "loop_var",
                                SymbolTable.SymbolKind.LOOP_VAR,
                                SymbolTable.SymbolSource.JINJA, jinja.getLine()
                        );
                        unifiedSym.linkedTo = iterable;
                        target.addJinjaSymbol(unifiedSym);
                        loopCount++;
                        count++;
                    }
                }
            }
        }

        System.out.println("      ✅ تم نقل " + count + " رمز من Jinja (" + loopCount + " loops)");
    }

    // ==================== دوال مساعدة ====================

    private static void printFinalStatistics(SymbolTableBuilder flaskBuilder,
                                             HtmlCssJinjaSymbolTable jinjaTable,
                                             SymbolTable unifiedTable) {
        // إحصائيات Flask
        int functions = 0, variables = 0, imports = 0, classes = 0;
        Scope scope = flaskBuilder.getCurrentScope();
        for (ASTFlask.SymbolTable.Symbol symbol : scope.symbols.values()) {
            if (symbol instanceof FunctionSymbol) {
                functions++;
            } else if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;
                if (var.type.equals("module") || var.type.equals("imported")) {
                    imports++;
                } else if (!var.name.equals("True") && !var.name.equals("False") &&
                        !var.name.equals("None") && !var.name.equals("__name__")) {
                    variables++;
                }
            } else if (symbol instanceof ClassSymbol) {
                classes++;
            }
        }

        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("                    📊 الإحصائيات النهائية");
        System.out.println("═══════════════════════════════════════════════════════════════");

        System.out.println("\n🔹 Python/Flask:");
        System.out.println("   • الدوال: " + functions);
        System.out.println("   • المتغيرات: " + variables);
        System.out.println("   • الأصناف: " + classes);
        System.out.println("   • الإستيرادات: " + imports);

        System.out.println("\n🔹 HTML/CSS/Jinja2:");
        System.out.println("   • عناصر HTML: " + jinjaTable.htmlElementCount);
        System.out.println("   • قواعد CSS: " + jinjaTable.cssRuleCount);
        System.out.println("   • تعبيرات Jinja: " + jinjaTable.jinjaSymbolCount);

        System.out.println("\n🔹 الجدول الموحّد (بعد الربط):");
        System.out.println("   • رموز Python: " + unifiedTable.getAllPythonSymbols().size());
        System.out.println("   • رموز Jinja2: " + unifiedTable.getAllJinjaSymbols().size());

        int resolvedCount = 0;
        for (SymbolTable.Symbol sym : unifiedTable.getAllPythonSymbols().values()) {
            if (sym.isResolved) resolvedCount++;
        }
        for (SymbolTable.Symbol sym : unifiedTable.getAllJinjaSymbols().values()) {
            if (sym.isResolved) resolvedCount++;
        }
        System.out.println("   • الروابط الناجحة: " + resolvedCount);
        System.out.println("   • الأخطاء الدلالية: " + unifiedTable.getErrors().size());
    }
}

