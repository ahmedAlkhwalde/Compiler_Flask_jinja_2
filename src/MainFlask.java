import ASTFlask.ASTPrinter;
import ASTFlask.Proge;
import ASTFlask.Statment;
import ASTFlask.SymbolTable.*;
import ASTFlask.TheMainContintOfComplexStatment.IfStatment;
import VISITORJINJA.ST.Operation;
import VisitorFlask.Visitor;
import VisitorFlask.SymbolTableBuilder;
import antlrFlask.ProjectLexer;
import antlrFlask.ProjectParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class MainFlask {
    public static void main(String[] args) throws IOException {
        String fileName = "Files/Flask.txt";

        System.out.println("=== FILE CONTENT ===");
        String fileContent = java.nio.file.Files.readString(java.nio.file.Path.of(fileName));
        System.out.println(fileContent);
        System.out.println("====================\n");

        CharStream charStream = fromFileName(fileName);
        ProjectLexer lexer = new ProjectLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        System.out.println("=== TOKEN ANALYSIS ===");
        for (Token t : tokens.getTokens()) {
            String tokenName = lexer.VOCABULARY.getSymbolicName(t.getType());
            if (tokenName != null && !tokenName.equals("EOF")) {
                System.out.printf("TOKEN: %-20s -> '%s' (Line: %d, Column: %d)\n",
                        tokenName, t.getText(), t.getLine(), t.getCharPositionInLine());
            }
        }
        System.out.println("======================\n");

        ProjectParser parser = new ProjectParser(tokens);
        ParseTree parseTree = parser.proge();

        Visitor visitor = new Visitor();
        Proge program = (Proge) visitor.visit(parseTree);

        System.out.println("=== ABSTRACT SYNTAX TREE ===");
        System.out.println(ASTPrinter.printTree(program));

        System.out.println("===========================\n");

        System.out.println("=== SYMBOL TABLE CONSTRUCTION ===");
        SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
        symbolTableBuilder.visit(parseTree);
        System.out.println("==============================\n");

        interactiveMenu(symbolTableBuilder);
    }

    private static void interactiveMenu(SymbolTableBuilder builder) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== SYMBOL TABLE MANAGEMENT SYSTEM ===");

        while (!exit) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. عرض جدول الرموز");
            System.out.println("2. البحث عن رمز");
            System.out.println("3. إضافة رمز جديد");
            System.out.println("4. تحديث رمز");
            System.out.println("5. حذف رمز");
            System.out.println("6. إعادة تسمية رمز");
            System.out.println("7. إحصائيات الرموز");
            System.out.println("8. البحث المتقدم");
            System.out.println("9. عرض الرموز غير المستخدمة");
            System.out.println("10. تصدير جدول الرموز");
            System.out.println("11. عرض الهياكل المتداخلة");
            System.out.println("12. اختبار جميع الوظائف");
            System.out.println("0. الخروج");
            System.out.print("اختر خيارًا: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Operationflask.displaySymbolTable(builder);
                    break;
                case 2:
                   Operationflask. searchSymbol(builder, scanner);
                    break;
                case 3:
                    Operationflask.addSymbol(builder, scanner);
                    break;
                case 4:
                    Operationflask. updateSymbol(builder, scanner);
                    break;
                case 5:
                    Operationflask.deleteSymbol(builder, scanner);
                    break;
                case 6:
                    Operationflask.renameSymbol(builder, scanner);
                    break;
                case 7:
                    Operationflask.displayStatistics(builder);
                    break;
                case 8:
                    Operationflask. advancedSearch(builder, scanner);
                    break;
                case 9:
                    Operationflask. displayUnusedSymbols(builder);
                    break;
                case 10:
                    Operationflask. exportSymbolTable(builder);
                    break;
                case 11:
                    Operationflask. displayNestedStructures(builder, scanner);
                    break;
                case 12:
                    Operationflask. testAllFunctions(builder);
                    break;
                case 0:
                    exit = true;
                    System.out.println("شكرًا لاستخدامك النظام!");
                    break;
                default:
                    System.out.println("خيار غير صحيح!");
            }
        }

        scanner.close();
    }


}
