//package Merge_Symbol_tables;
//
//import ASTFlask.ASTPrinter;
//import ASTFlask.Proge;
//import ASTFlask.SymbolTable.*;
//import AST_HTMLCSSJINJA.*;
//import Generation_Flask_Jinja.FlaskCodeGenerator;
//import Generation_Flask_Jinja.JinjaCodeGenerator;
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
//import java.awt.Desktop;
//import java.io.*;
//import java.net.URI;
//import java.nio.file.*;
//import java.util.*;
//
//import static java.nio.file.StandardWatchEventKinds.*;
//import static org.antlr.v4.runtime.CharStreams.fromFileName;
//
//public class Compiler {
//
//    private static Process flaskProcess = null;
//
//    public static void main(String[] args) throws Exception {
//        boolean watch = false;
//        boolean serve = false;
//        for (String arg : args) {
//            if (arg.equals("--watch")) watch = true;
//            if (arg.equals("--serve")) serve = true;
//        }
//
//        // التوليد الأول
//        compileAll();
//
//        // تشغيل الخادم وفتح المتصفح إذا طلب ذلك
//        if (serve) {
//            startFlaskServer();
//        }
//
//        // مراقبة الملفات وإعادة التوليد تلقائياً
//        if (watch) {
//            watchAndRegenerate(serve);
//        }
//    }
//
//    // ==================== دالة الترجمة الأساسية ====================
//    private static void compileAll() throws IOException {
//        System.out.println("╔══════════════════════════════════════════════════════════════╗");
//        System.out.println("║     مترجم Flask + Jinja2 المتكامل - تحليل ورموز ودمج        ║");
//        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");
//
//        // ==================== 1. تحليل Python/Flask ====================
//        System.out.println("📁 [1/5] تحليل ملف Flask (Python)...");
//        String flaskFile = "Files/Flask.py";
//
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
//        Visitor flaskVisitor = new Visitor();
//        Proge flaskProgram = (Proge) flaskVisitor.visit(flaskTree);
//
//        System.out.println("=== ABSTRACT SYNTAX TREE (Flask) ===");
//        System.out.println(ASTPrinter.printTree(flaskProgram));
//        System.out.println("====================================\n");
//
//        System.out.println("=== SYMBOL TABLE CONSTRUCTION (Flask) ===");
//        SymbolTableBuilder flaskSymbolBuilder = new SymbolTableBuilder();
//        flaskSymbolBuilder.visit(flaskTree);
//        System.out.println("=========================================\n");
//
//        Operationflask.displaySymbolTable(flaskSymbolBuilder);
//
//        // ==================== 2. تحليل HTML/Jinja2 ====================
//        System.out.println("\n📁 [2/5] تحليل ملف HTML/Jinja2...");
//        String jinjaFile = "Files/templates/products.html";
//
//        System.out.println("\n=== FILE CONTENT (HTML/Jinja2) ===");
//        String jinjaContent = Files.readString(Paths.get(jinjaFile));
//        System.out.println(jinjaContent);
//        System.out.println("================================\n");
//
//        CharStream jinjaStream = fromFileName(jinjaFile);
//        HTMLCSSJINJA_lexer jinjaLexer = new HTMLCSSJINJA_lexer(jinjaStream);
//        CommonTokenStream jinjaTokens = new CommonTokenStream(jinjaLexer);
//        jinjaTokens.fill();
//
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
//        System.out.println("=== ABSTRACT SYNTAX TREE (HTML/Jinja2) ===");
//        VisitorJinja jinjaVisitor = new VisitorJinja();
//        ASTNode jinjaRoot = jinjaVisitor.visit(jinjaTree);
//
//        if (jinjaRoot instanceof DocumentNode) {
//            ((DocumentNode) jinjaRoot).print();
//        }
//        System.out.println("==========================================\n");
//
//        System.out.println("=== SYMBOL TABLE CONSTRUCTION (HTML/Jinja2) ===");
//        VisitorJinjaSymbolTable jinjaSymbolBuilder = new VisitorJinjaSymbolTable(jinjaVisitor);
//        jinjaSymbolBuilder.visit(jinjaTree);
//        HtmlCssJinjaSymbolTable jinjaSymbolTable = jinjaSymbolBuilder.getSymbolTable();
//        System.out.println("تم بناء جدول الرموز بنجاح!");
//        System.out.println("================================================\n");
//
//        Operation.displaySymbolTable(jinjaSymbolTable);
//
//        // ==================== 3. بناء جدول الرموز الموحّد ====================
//        System.out.println("\n🔗 [3/5] بناء جدول الرموز الموحّد وربط Python ↔ Jinja2...");
//
//        SymbolTable unifiedTable = new SymbolTable();
//        transferFlaskSymbolsToUnified(flaskSymbolBuilder, unifiedTable);
//        transferJinjaSymbolsToUnified(jinjaSymbolTable, unifiedTable);
//        System.out.println("   ✅ تم نقل الرموز إلى الجدول الموحّد\n");
//
//        // ==================== 4. التحليل الدلالي ====================
//        System.out.println("⚙️  [4/4] التحليل الدلالي وطباعة جدول الرموز الموحّد...");
//
//        String flaskRawCode = Files.readString(Paths.get(flaskFile));
//        String jinjaRawCode = Files.readString(Paths.get(jinjaFile));
//        SemanticAnalyzer analyzer = new SemanticAnalyzer(unifiedTable, flaskSymbolBuilder, jinjaSymbolTable, flaskRawCode, jinjaRawCode);
//        analyzer.resolveAndValidate();
//
//        unifiedTable.printTable();
//
//        boolean hasErrors = unifiedTable.hasErrors();
//
//        if (hasErrors) {
//            System.out.println("\n⚠️  الأخطاء الدلالية المكتشفة (" + unifiedTable.getErrors().size() + "):");
//            for (String error : unifiedTable.getErrors()) {
//                System.out.println("   ❌ " + error);
//            }
//            System.out.println("\n🛑 **تم اكتشاف أخطاء دلالية، لن يتم توليد الكود!** 🛑");
//            System.out.println("   يرجى تصحيح الأخطاء المذكورة أعلاه وإعادة تشغيل المترجم.");
//        } else {
//            System.out.println("\n✅ لا توجد أخطاء دلالية! جميع الروابط صحيحة.");
//
//            // ==================== 5. توليد الكود ====================
//            System.out.println("\n📁 [5/5] توليد الكود من AST...");
//
//            try {
//                FlaskCodeGenerator flaskGenerator = new FlaskCodeGenerator();
//                flaskGenerator.generate(flaskProgram);
//                flaskGenerator.saveToFile("Files/generated_app.py");
//
//                JinjaCodeGenerator jinjaGenerator = new JinjaCodeGenerator();
//                jinjaGenerator.generate(jinjaRoot);
//                jinjaGenerator.saveToFile("Files/generated_template.html");
//
//                System.out.println("\n✅ تم توليد الكود بنجاح!");
//                System.out.println("   📄 ملف Flask: Files/generated_app.py");
//                System.out.println("   📄 ملف القالب: Files/generated_template.html");
//                System.out.println("\n💡 لتشغيل التطبيق:");
//                System.out.println("   1. افتح الملفين المولَدين");
//                System.out.println("   2. قم بتثبيت Flask: pip install flask");
//                System.out.println("   3. قم بتشغيل: python Files/generated_app.py");
//
//            } catch (Exception e) {
//                System.err.println("❌ خطأ أثناء توليد الكود: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//
//        printFinalStatistics(flaskSymbolBuilder, jinjaSymbolTable, unifiedTable);
//        System.out.println("\n✅ المشروع يعمل بنجاح! تم دمج Flask و Jinja2 في مترجم واحد.");
//    }
//
//    // ==================== المراقبة وإعادة التوليد ====================
//    private static void watchAndRegenerate(boolean serve) throws Exception {
//        System.out.println("\n👁️  بدء مراقبة التغييرات في مجلد Files/ ...");
//        WatchService watchService = FileSystems.getDefault().newWatchService();
//        Path folder = Paths.get("Files");
//        folder.register(watchService, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
//
//        while (true) {
//            WatchKey key = watchService.take();
//            for (WatchEvent<?> event : key.pollEvents()) {
//                WatchEvent.Kind<?> kind = event.kind();
//                if (kind == OVERFLOW) continue;
//                String changedFile = event.context().toString();
//                System.out.println("\n🔄 تم اكتشاف تغيير في: " + changedFile + " - جاري إعادة التوليد...");
//                try {
//                    compileAll();
//                    if (serve) {
//                        restartFlaskServer();
//                    }
//                } catch (Exception e) {
//                    System.err.println("❌ فشلت إعادة التوليد: " + e.getMessage());
//                }
//            }
//            key.reset();
//        }
//    }
//
//    // ==================== تشغيل Flask وفتح المتصفح ====================
//    // ==================== تشغيل Flask وفتح المتصفح (نسخة محسنة) ====================
//    private static void startFlaskServer() {
//        if (!Files.exists(Paths.get("Files/generated_app.py"))) {
//            System.err.println("❌ ملف generated_app.py غير موجود، لا يمكن تشغيل الخادم.");
//            return;
//        }
//
//        System.out.println("\n🚀 تشغيل خادم Flask...");
//
//        // استخدم المسار الكامل لـ Python الذي يعمل عندك
//        String pythonCmd = "C:\\Users\\dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe";
//
//        ProcessBuilder pb = new ProcessBuilder(
//                pythonCmd, "Files/generated_app.py"
//        );
//        pb.directory(new File("."));
//        pb.redirectErrorStream(true);
//
//        try {
//            flaskProcess = pb.start();
//            System.out.println("   ⏳ في انتظار إقلاع الخادم (3 ثوانٍ)...");
//
//            // انتظر 3 ثوانٍ لضمان إقلاع Flask بالكامل
//            Thread.sleep(3000);
//
//            System.out.println("🌐 فتح المتصفح على http://localhost:5000");
//            try {
//                Desktop.getDesktop().browse(new URI("http://localhost:5000"));
//                System.out.println("   ✅ تم فتح المتصفح بنجاح.");
//            } catch (Exception e) {
//                // محاولة بديلة لنظام Windows
//                try {
//                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:5000");
//                    System.out.println("   ✅ تم فتح المتصفح (طريقة بديلة).");
//                } catch (Exception e2) {
//                    System.err.println("❌ فشل فتح المتصفح تلقائياً. افتح يدوياً: http://localhost:5000");
//                }
//            }
//
//        } catch (Exception e) {
//            System.err.println("❌ فشل تشغيل الخادم: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private static void waitForServer(String url, int maxRetries) {
//        for (int i = 0; i < maxRetries; i++) {
//            try {
//                java.net.HttpURLConnection conn = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
//                conn.setConnectTimeout(500);
//                conn.connect();
//                System.out.println("   ✅ الخادم جاهز.");
//                return;
//            } catch (Exception e) {
//                try {
//                    Thread.sleep(800);
//                } catch (InterruptedException ie) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//        System.err.println("   ⚠️ لم يتم تأكيد جاهزية الخادم، لكن سيُفتح المتصفح على أي حال.");
//    }
//
//    private static void openBrowser(String url) {
//        try {
//            System.out.println("🌐 فتح المتصفح على " + url);
//            Desktop.getDesktop().browse(new URI(url));
//        } catch (Exception e) {
//            // محاولة ثانية باستخدام أمر النظام مباشرة
//            try {
//                String os = System.getProperty("os.name").toLowerCase();
//                Runtime rt = Runtime.getRuntime();
//                if (os.contains("win")) {
//                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
//                } else if (os.contains("mac")) {
//                    rt.exec("open " + url);
//                } else {
//                    rt.exec("xdg-open " + url);
//                }
//                System.out.println("   ✅ تم فتح المتصفح باستخدام أمر النظام.");
//            } catch (Exception e2) {
//                System.err.println("❌ فشل فتح المتصفح. افتح يدوياً: " + url);
//            }
//        }
//    }
//
//    private static void restartFlaskServer() throws IOException {
//        if (flaskProcess != null && flaskProcess.isAlive()) {
//            flaskProcess.destroyForcibly();
//            System.out.println("⏹️  تم إيقاف الخادم السابق.");
//            try {
//                Thread.sleep(500); // انتظر حتى يتحرر المنفذ
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//        startFlaskServer();
//    }
//
//    // ==================== نقل رموز Flask ====================
//    private static void transferFlaskSymbolsToUnified(SymbolTableBuilder source, SymbolTable target) {
//        System.out.println("   📦 نقل رموز Flask إلى الجدول الموحّد...");
//
//        Scope globalScope = source.getCurrentScope();
//        int count = 0;
//        int routeCount = 0;
//
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
//    private static void transferJinjaSymbolsToUnified(HtmlCssJinjaSymbolTable source, SymbolTable target) {
//        System.out.println("   📦 نقل رموز Jinja إلى الجدول الموحّد...");
//        int count = 0;
//        int loopCount = 0;
//
//        SymbolTable.Symbol templateSym = new SymbolTable.Symbol(
//                "products.html", "template",
//                SymbolTable.SymbolKind.TEMPLATE,
//                SymbolTable.SymbolSource.JINJA, 1
//        );
//        target.addJinjaSymbol(templateSym);
//        count++;
//
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
//    // ==================== الإحصائيات النهائية ====================
//    private static void printFinalStatistics(SymbolTableBuilder flaskBuilder,
//                                             HtmlCssJinjaSymbolTable jinjaTable,
//                                             SymbolTable unifiedTable) {
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


package Merge_Symbol_tables;

import ASTFlask.ASTPrinter;
import ASTFlask.Proge;
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

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.StandardWatchEventKinds.*;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Compiler {

    private static Process flaskProcess = null;

    public static void main(String[] args) throws Exception {
        // 🔍 تشخيص: تأكد أن هذا هو نفس مسار مجلد Files الذي تحفظ فيه فعليًا من IntelliJ
        System.out.println("📂 المسار الذي يراقبه المترجم: " + Paths.get("Files").toAbsolutePath().normalize());

        boolean watch = false;
        boolean serve = false;
        for (String arg : args) {
            if (arg.equals("--watch")) watch = true;
            if (arg.equals("--serve")) serve = true;
        }

        // التوليد الأول
        compileAll();

        // تشغيل الخادم وفتح المتصفح إذا طلب ذلك (فقط في هذا التشغيل الأول)
        if (serve) {
            startFlaskServer(true);
        }

        // مراقبة الملفات وإعادة التوليد تلقائياً
        if (watch) {
            watchAndRegenerate(serve);
        }
    }

    // ==================== دالة الترجمة الأساسية ====================
    private static void compileAll() throws IOException {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║     مترجم Flask + Jinja2 المتكامل - تحليل ورموز ودمج        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // ==================== 1. تحليل Python/Flask ====================
        System.out.println("📁 [1/4] تحليل ملف Flask (Python)...");
        String flaskFile = "Files/Flask.py";

        System.out.println("\n=== FILE CONTENT (Flask) ===");
        String flaskContent = Files.readString(Paths.get(flaskFile));
        System.out.println(flaskContent);
        System.out.println("============================\n");

        CharStream flaskStream = fromFileName(flaskFile);
        ProjectLexer flaskLexer = new ProjectLexer(flaskStream);
        CommonTokenStream flaskTokens = new CommonTokenStream(flaskLexer);
        flaskTokens.fill();

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

        Visitor flaskVisitor = new Visitor();
        Proge flaskProgram = (Proge) flaskVisitor.visit(flaskTree);

        System.out.println("=== ABSTRACT SYNTAX TREE (Flask) ===");
        System.out.println(ASTPrinter.printTree(flaskProgram));
        System.out.println("====================================\n");

        System.out.println("=== SYMBOL TABLE CONSTRUCTION (Flask) ===");
        SymbolTableBuilder flaskSymbolBuilder = new SymbolTableBuilder();
        flaskSymbolBuilder.visit(flaskTree);
        System.out.println("=========================================\n");

        Operationflask.displaySymbolTable(flaskSymbolBuilder);

        // ==================== 2. تحليل HTML/Jinja2 ====================
        System.out.println("\n📁 [2/4] تحليل ملف HTML/Jinja2...");
        String jinjaFile = "Files/templates/products.html";

        System.out.println("\n=== FILE CONTENT (HTML/Jinja2) ===");
        String jinjaContent = Files.readString(Paths.get(jinjaFile));
        System.out.println(jinjaContent);
        System.out.println("================================\n");

        CharStream jinjaStream = fromFileName(jinjaFile);
        HTMLCSSJINJA_lexer jinjaLexer = new HTMLCSSJINJA_lexer(jinjaStream);
        CommonTokenStream jinjaTokens = new CommonTokenStream(jinjaLexer);
        jinjaTokens.fill();

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

        System.out.println("=== ABSTRACT SYNTAX TREE (HTML/Jinja2) ===");
        VisitorJinja jinjaVisitor = new VisitorJinja();
        ASTNode jinjaRoot = jinjaVisitor.visit(jinjaTree);

        if (jinjaRoot instanceof DocumentNode) {
            ((DocumentNode) jinjaRoot).print();
        }
        System.out.println("==========================================\n");

        System.out.println("=== SYMBOL TABLE CONSTRUCTION (HTML/Jinja2) ===");
        VisitorJinjaSymbolTable jinjaSymbolBuilder = new VisitorJinjaSymbolTable(jinjaVisitor);
        jinjaSymbolBuilder.visit(jinjaTree);
        HtmlCssJinjaSymbolTable jinjaSymbolTable = jinjaSymbolBuilder.getSymbolTable();
        System.out.println("تم بناء جدول الرموز بنجاح!");
        System.out.println("================================================\n");

        Operation.displaySymbolTable(jinjaSymbolTable);

        // ==================== 3. بناء جدول الرموز الموحّد ====================
        System.out.println("\n🔗 [3/4] بناء جدول الرموز الموحّد وربط Python ↔ Jinja2...");

        SymbolTable unifiedTable = new SymbolTable();
        transferFlaskSymbolsToUnified(flaskSymbolBuilder, unifiedTable);
        transferJinjaSymbolsToUnified(jinjaSymbolTable, unifiedTable);
        System.out.println("   ✅ تم نقل الرموز إلى الجدول الموحّد\n");

        // ==================== 4. التحليل الدلالي ====================
        System.out.println("⚙️  [4/4] التحليل الدلالي وطباعة جدول الرموز الموحّد...");

        String flaskRawCode = Files.readString(Paths.get(flaskFile));
        String jinjaRawCode = Files.readString(Paths.get(jinjaFile));
        SemanticAnalyzer analyzer = new SemanticAnalyzer(unifiedTable, flaskSymbolBuilder, jinjaSymbolTable, flaskRawCode, jinjaRawCode);
        analyzer.resolveAndValidate();

        unifiedTable.printTable();

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

            // ==================== 5. توليد الكود ====================
            System.out.println("\n📁 [5/5] توليد الكود من AST...");

            try {
                FlaskCodeGenerator flaskGenerator = new FlaskCodeGenerator();
                flaskGenerator.generate(flaskProgram);
                // 🔄 دمج آخر بيانات products القادمة فعليًا من المتصفح — في الملف المُولَّد فقط.
                // Files/Flask.py (المصدر) لا يُعدَّل أبدًا.
                flaskGenerator.applyLiveProductsState("Files/.products_state.txt");
                flaskGenerator.saveToFile("Files/generated_app.py");

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

        printFinalStatistics(flaskSymbolBuilder, jinjaSymbolTable, unifiedTable);
        System.out.println("\n✅ المشروع يعمل بنجاح! تم دمج Flask و Jinja2 في مترجم واحد.");
    }

    // ==================== المراقبة وإعادة التوليد (نسخة مع تجميع الأحداث/debounce) ====================
    private static void watchAndRegenerate(boolean serve) throws Exception {
        System.out.println("\n👁️  بدء مراقبة التغييرات في مجلد Files/ ...");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path folder = Paths.get("Files");
        folder.register(watchService, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);

        while (true) {
            WatchKey key = watchService.take();

            // تجميع كل الأحداث المتلاحقة خلال 300ms كإعادة توليد واحدة فقط
            // (بعض أنظمة الملفات تُطلق أكثر من ENTRY_MODIFY لعملية حفظ واحدة،
            //  وهنا نفس Flask.py هو من يُعدَّل نفسه عبر save_products)
            List<WatchEvent<?>> events = new ArrayList<>(key.pollEvents());
            Thread.sleep(300);

            WatchKey extraKey = watchService.poll();
            if (extraKey != null) {
                events.addAll(extraKey.pollEvents());
                extraKey.reset();
            }

            boolean relevant = false;
            for (WatchEvent<?> event : events) {
                if (event.kind() == OVERFLOW) continue;
                String changedFile = event.context().toString();

                // ⛔ تجاهل الملفات التي يكتبها المترجم نفسه، وإلا دخل في حلقة
                // توليد لا تنتهي (كل توليد يُنتج ملفات، والملفات تُشغّل توليدًا جديدًا...)
                if (changedFile.equals("generated_app.py") || changedFile.equals("generated_template.html")) {
                    continue;
                }

                System.out.println("🔄 تم اكتشاف تغيير في: " + changedFile);
                relevant = true;
            }

            if (relevant) {
                try {
                    compileAll();
                    if (serve) {
                        restartFlaskServer();
                    }
                } catch (Exception ex) {
                    System.err.println("❌ فشلت إعادة التوليد: " + ex.getMessage());
                }
            }
            key.reset();
        }
    }

    // ==================== تشغيل Flask وفتح المتصفح ====================
    // ==================== تشغيل Flask وفتح المتصفح (نسخة محسنة) ====================
    // openBrowser = true فقط عند أول تشغيل للخادم؛ إعادة التشغيل بعد كل توليد لاحق
    // لا تفتح تبويبًا جديدًا في المتصفح (نفس التبويب المفتوح يعمل تلقائيًا مع الكود الجديد).
    private static void startFlaskServer(boolean openBrowser) {
        if (!Files.exists(Paths.get("Files/generated_app.py"))) {
            System.err.println("❌ ملف generated_app.py غير موجود، لا يمكن تشغيل الخادم.");
            return;
        }

        System.out.println("\n🚀 تشغيل خادم Flask...");

        // استخدم المسار الكامل لـ Python الذي يعمل عندك
        String pythonCmd = "C:\\Users\\dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe";

        ProcessBuilder pb = new ProcessBuilder(
                pythonCmd, "Files/generated_app.py"
        );
        pb.directory(new File("."));
        pb.redirectErrorStream(true);

        try {
            flaskProcess = pb.start();

            // 🔍 تشخيص: اعرض مخرجات Python (بما فيها أي Traceback) مباشرة في نافذة IntelliJ
            Process finalFlaskProcess = flaskProcess;
            Thread outputThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(finalFlaskProcess.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("[Flask] " + line);
                    }
                } catch (IOException ignored) {
                }
            });
            outputThread.setDaemon(true);
            outputThread.start();

            System.out.println("   ⏳ في انتظار إقلاع الخادم (3 ثوانٍ)...");

            // انتظر 3 ثوانٍ لضمان إقلاع Flask بالكامل
            Thread.sleep(3000);

            if (!openBrowser) {
                System.out.println("   ↩️  إعادة تشغيل صامتة (بدون فتح تبويب متصفح جديد).");
                return;
            }

            System.out.println("🌐 فتح المتصفح على http://localhost:5000");
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:5000"));
                System.out.println("   ✅ تم فتح المتصفح بنجاح.");
            } catch (Exception e) {
                // محاولة بديلة لنظام Windows
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:5000");
                    System.out.println("   ✅ تم فتح المتصفح (طريقة بديلة).");
                } catch (Exception e2) {
                    System.err.println("❌ فشل فتح المتصفح تلقائياً. افتح يدوياً: http://localhost:5000");
                }
            }

        } catch (Exception e) {
            System.err.println("❌ فشل تشغيل الخادم: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void waitForServer(String url, int maxRetries) {
        for (int i = 0; i < maxRetries; i++) {
            try {
                java.net.HttpURLConnection conn = (java.net.HttpURLConnection) new java.net.URL(url).openConnection();
                conn.setConnectTimeout(500);
                conn.connect();
                System.out.println("   ✅ الخادم جاهز.");
                return;
            } catch (Exception e) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.err.println("   ⚠️ لم يتم تأكيد جاهزية الخادم، لكن سيُفتح المتصفح على أي حال.");
    }

    private static void openBrowser(String url) {
        try {
            System.out.println("🌐 فتح المتصفح على " + url);
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            // محاولة ثانية باستخدام أمر النظام مباشرة
            try {
                String os = System.getProperty("os.name").toLowerCase();
                Runtime rt = Runtime.getRuntime();
                if (os.contains("win")) {
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    rt.exec("open " + url);
                } else {
                    rt.exec("xdg-open " + url);
                }
                System.out.println("   ✅ تم فتح المتصفح باستخدام أمر النظام.");
            } catch (Exception e2) {
                System.err.println("❌ فشل فتح المتصفح. افتح يدوياً: " + url);
            }
        }
    }

    private static void restartFlaskServer() throws IOException {
        if (flaskProcess != null && flaskProcess.isAlive()) {
            flaskProcess.destroyForcibly();
            System.out.println("⏹️  تم إيقاف الخادم السابق.");
            try {
                Thread.sleep(500); // انتظر حتى يتحرر المنفذ
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        startFlaskServer(false); // لا تفتح تبويب متصفح جديد عند إعادة التشغيل
    }

    // ==================== نقل رموز Flask ====================
    private static void transferFlaskSymbolsToUnified(SymbolTableBuilder source, SymbolTable target) {
        System.out.println("   📦 نقل رموز Flask إلى الجدول الموحّد...");

        Scope globalScope = source.getCurrentScope();
        int count = 0;
        int routeCount = 0;

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

        SymbolTable.Symbol templateSym = new SymbolTable.Symbol(
                "products.html", "template",
                SymbolTable.SymbolKind.TEMPLATE,
                SymbolTable.SymbolSource.JINJA, 1
        );
        target.addJinjaSymbol(templateSym);
        count++;

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

    // ==================== الإحصائيات النهائية ====================
    private static void printFinalStatistics(SymbolTableBuilder flaskBuilder,
                                             HtmlCssJinjaSymbolTable jinjaTable,
                                             SymbolTable unifiedTable) {
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