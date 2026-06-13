import VISITORJINJA.*;

import AST_HTMLCSSJINJA.*;
import VISITORJINJA.ST.*;
import antlrJinja.HTMLCSSJINJA_lexer;
import antlrJinja.HTMLCSSJINJA_parser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MainJinja {
    public static void main(String[] args) throws IOException {
        String fileName = "Files/html.txt";

        System.out.println("=== محتوى الملف ===");
        String fileContent = Files.readString(Paths.get(fileName));
        System.out.println(fileContent);
        System.out.println("====================\n");

        CharStream charStream = CharStreams.fromFileName(fileName);
        HTMLCSSJINJA_lexer lexer = new HTMLCSSJINJA_lexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        System.out.println("=== تحليل الرموز ===");
        for (Token t : tokens.getTokens()) {
            String tokenName = lexer.VOCABULARY.getSymbolicName(t.getType());
            if (tokenName != null && !tokenName.equals("EOF")) {
                System.out.printf("TOKEN: %-25s -> '%s' (السطر: %d, العمود: %d)\n",
                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
            }
        }
        System.out.println("======================\n");

        HTMLCSSJINJA_parser parser = new HTMLCSSJINJA_parser(tokens);
        ParseTree parseTree = parser.document();

        System.out.println("=== بناء شجرة الـAST ===");
        VisitorJinja visitor = new VisitorJinja();
        ASTNode astRoot = visitor.visit(parseTree);

        if (astRoot instanceof DocumentNode) {
            astRoot.print();
        }
        System.out.println("===========================\n");

        System.out.println("=== بناء جدول الرموز ===");
        VisitorJinjaSymbolTable symbolTableVisitor = new VisitorJinjaSymbolTable(visitor);
        symbolTableVisitor.visit(parseTree);
        HtmlCssJinjaSymbolTable symbolTable = symbolTableVisitor.getSymbolTable();
        System.out.println("تم بناء جدول الرموز بنجاح!");
        System.out.println("==============================\n");

        interactiveMenu(symbolTableVisitor, symbolTable);
    }

    private static void interactiveMenu(VisitorJinjaSymbolTable visitor, HtmlCssJinjaSymbolTable symbolTable) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== نظام إدارة جدول الرموز HTML/CSS/Jinja ===");

        while (!exit) {
            System.out.println("\n=== القائمة الرئيسية ===");
            System.out.println("1. عرض جدول الرموز");
            System.out.println("2. البحث عن عنصر HTML");
            System.out.println("3. البحث عن سمة CSS");
            System.out.println("4. البحث عن تعبير Jinja");
            System.out.println("5. عرض إحصائيات الرموز");
            System.out.println("6. البحث عن عناصر ضمن نطاق");
            System.out.println("7. عرض عناصر Jinja حسب النوع");
            System.out.println("8. عرض الأخطاء والتحذيرات");
            System.out.println("9. اختبار جميع الوظائف");
            System.out.println("10. تصدير جدول الرموز");
            System.out.println("11. عرض الهياكل المتداخلة");
            System.out.println("0. الخروج");
            System.out.print("اختر خيارًا: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("يرجى إدخال رقم صحيح!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    Operation.displaySymbolTable(symbolTable);
                    break;
                case 2:
                    Operation.searchHtmlElement(symbolTable, scanner);
                    break;
                case 3:
                    Operation.searchCssAttribute(symbolTable, scanner);
                    break;
                case 4:
                    Operation.searchJinja(symbolTable, scanner);
                    break;
                case 5:
                    Operation.displayStatistics(symbolTable);
                    break;
                case 6:
                    Operation.searchWithinScope(symbolTable, scanner);
                    break;
                case 7:
                    Operation.displayJinjaByType(symbolTable, scanner);
                    break;
                case 8:
                    Operation.displayErrorsAndWarnings(visitor);
                    break;
                case 9:
                    Operation.testAllFunctions(symbolTable, visitor);
                    break;
                case 10:
                    Operation.displayNestedStructures(symbolTable, scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.println("شكرًا لاستخدامك النظام!");
                    visitor.cleanup();
                    break;
                default:
                    System.out.println("خيار غير صحيح!");
            }
        }

        scanner.close();
    }


}