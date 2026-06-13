package VISITORJINJA.ST;

import VISITORJINJA.VisitorJinjaSymbolTable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Operation {
      public static void displaySymbolTable(HtmlCssJinjaSymbolTable symbolTable) {
        System.out.println("\n=== عرض جدول الرموز ===");
        symbolTable.printStatistics();

        System.out.println("\n=== العناصر HTML ===");
        List<HtmlElementSymbol> htmlElements = getAllHtmlElements(symbolTable);
        for (HtmlElementSymbol element : htmlElements) {
            System.out.printf("• <%s> (السطر: %d, النوع: %s)\n",
                    element.getName(),
                    element.getLine(),
                    element.getCategory().toString()); // تم التعديل هنا
            if (element.getAttributes() != null && !element.getAttributes().isEmpty()) {
                System.out.println("  السمات:");
                for (HtmlAttributeSymbol attr : element.getAttributes().values()) {
                    System.out.printf("    - %s=\"%s\"\n",
                            attr.getName(),
                            attr.getValueWithoutQuotes());
                }
            }
        }

        System.out.println("\n=== قواعد CSS ===");
        List<CssRuleSymbol> cssRules = getAllCssRules(symbolTable);
        for (CssRuleSymbol rule : cssRules) {
            System.out.printf("• %s: %s (السطر: %d, النوع: %s)\n",
                    rule.getProperty(),
                    rule.getValuesAsString(),
                    rule.getLine(),
                    rule.getCategory());
        }

        System.out.println("\n=== تعبيرات Jinja ===");
        List<JinjaSymbol> jinjaSymbols = getAllJinjaSymbols(symbolTable);
        for (JinjaSymbol jinja : jinjaSymbols) {
            System.out.printf("• %s: %s (السطر: %d)\n",
                    jinja.getJinjaType(),
                    jinja.getContent(),
                    jinja.getLine());
        }
    }

      public static void searchHtmlElement(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل اسم عنصر HTML للبحث (مثال: div, p, a): ");
        String elementName = scanner.nextLine().toLowerCase();

        List<HtmlElementSymbol> results = getHtmlElementsByTag(symbolTable, elementName);

        System.out.println("\n=== نتائج البحث ===");
        if (results.isEmpty()) {
            System.out.println("لم يتم العثور على عناصر بهذا الاسم.");
        } else {
            System.out.println("عدد العناصر التي تم العثور عليها: " + results.size());
            for (HtmlElementSymbol element : results) {
                System.out.printf("• <%s> في السطر %d، النوع: %s\n",
                        element.getName(),
                        element.getLine(),
                        element.getCategory().toString());
            }
        }
    }

     public static void searchCssAttribute(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل اسم خاصية CSS للبحث (مثال: color, width, margin): ");
        String propertyName = scanner.nextLine().toLowerCase();

        List<CssRuleSymbol> results = getCssRulesByProperty(symbolTable, propertyName);

        System.out.println("\n=== نتائج البحث ===");
        if (results.isEmpty()) {
            System.out.println("لم يتم العثور على قواعد CSS بهذه الخاصية.");
        } else {
            System.out.println("عدد القواعد التي تم العثور عليها: " + results.size());
            for (CssRuleSymbol rule : results) {
                System.out.printf("• %s: %s في السطر %d\n",
                        rule.getProperty(),
                        rule.getValuesAsString(),
                        rule.getLine());
            }
        }
    }

     public static void searchJinja(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل كلمة للبحث في تعبيرات Jinja: ");
        String searchWord = scanner.nextLine();

        List<JinjaSymbol> results = getJinjaSymbolsByContent(symbolTable, searchWord);

        System.out.println("\n=== نتائج البحث ===");
        if (results.isEmpty()) {
            System.out.println("لم يتم العثور على تعبيرات Jinja تحتوي على: " + searchWord);
        } else {
            System.out.println("عدد تعبيرات Jinja التي تم العثور عليها: " + results.size());
            for (JinjaSymbol jinja : results) {
                System.out.printf("• %s: %s في السطر %d\n",
                        jinja.getJinjaType(),
                        jinja.getContent(),
                        jinja.getLine());
            }
        }
    }

     public static void displayStatistics(HtmlCssJinjaSymbolTable symbolTable) {
        System.out.println("\n=== إحصائيات جدول الرموز ===");

        List<HtmlElementSymbol> htmlElements = getAllHtmlElements(symbolTable);
        List<CssRuleSymbol> cssRules = getAllCssRules(symbolTable);
        List<JinjaSymbol> jinjaSymbols = getAllJinjaSymbols(symbolTable);

        System.out.println("إجمالي العناصر HTML: " + htmlElements.size());
        System.out.println("إجمالي قواعد CSS: " + cssRules.size());
        System.out.println("إجمالي تعبيرات Jinja: " + jinjaSymbols.size());

        Map<String, Integer> typeStatistics = new HashMap<>();
        Map<String, Integer> attributeStatistics = new HashMap<>();
        Map<JinjaSymbol.JinjaType, Integer> jinjaStatistics = new HashMap<>();

        for (HtmlElementSymbol element : htmlElements) {
            String elementType = element.getCategory().toString(); // تم التعديل هنا
            typeStatistics.put(elementType, typeStatistics.getOrDefault(elementType, 0) + 1);

            if (element.getAttributes() != null) {
                for (HtmlAttributeSymbol attr : element.getAttributes().values()) {
                    String attributeType = attr.getAttributeType().toString();
                    attributeStatistics.put(attributeType, attributeStatistics.getOrDefault(attributeType, 0) + 1);
                }
            }
        }

        for (JinjaSymbol jinja : jinjaSymbols) {
            JinjaSymbol.JinjaType type = jinja.getJinjaType();
            jinjaStatistics.put(type, jinjaStatistics.getOrDefault(type, 0) + 1);
        }

        System.out.println("\n=== توزيع العناصر HTML حسب النوع ===");
        for (Map.Entry<String, Integer> entry : typeStatistics.entrySet()) {
            System.out.printf("  • %s: %d عنصر\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n=== توزيع السمات حسب النوع ===");
        for (Map.Entry<String, Integer> entry : attributeStatistics.entrySet()) {
            System.out.printf("  • %s: %d سمة\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n=== توزيع تعبيرات Jinja حسب النوع ===");
        for (Map.Entry<JinjaSymbol.JinjaType, Integer> entry : jinjaStatistics.entrySet()) {
            System.out.printf("  • %s: %d تعبير\n", entry.getKey(), entry.getValue());
        }
    }

     public static void searchWithinScope(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.println("اختر نوع النطاق للبحث:");
        System.out.println("1. داخل عنصر HTML محدد");
        System.out.println("2. داخل سمة style");
        System.out.println("3. داخل كتلة Jinja");
        System.out.print("اختر خيارًا: ");

        int scopeType = scanner.nextInt();
        scanner.nextLine();

        switch (scopeType) {
            case 1:
                searchWithinHtmlElement(symbolTable, scanner);
                break;
            case 2:
                searchWithinStyleAttribute(symbolTable, scanner);
                break;
            case 3:
                searchWithinJinjaBlock(symbolTable, scanner);
                break;
            default:
                System.out.println("خيار غير صحيح!");
        }
    }

     public static void searchWithinHtmlElement(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل اسم عنصر HTML: ");
        String elementName = scanner.nextLine();

        List<HtmlElementSymbol> elements = getHtmlElementsByTag(symbolTable, elementName);

        if (elements.isEmpty()) {
            System.out.println("لم يتم العثور على عنصر بهذا الاسم.");
            return;
        }

        System.out.println("العناصر التي تم العثور عليها:");
        for (int i = 0; i < elements.size(); i++) {
            HtmlElementSymbol element = elements.get(i);
            System.out.printf("%d. <%s> في السطر %d\n", i + 1, element.getName(), element.getLine());
        }

        System.out.print("اختر رقم العنصر للبحث داخله: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > elements.size()) {
            System.out.println("اختيار غير صحيح!");
            return;
        }

        HtmlElementSymbol selectedElement = elements.get(choice - 1);

        System.out.println("\n=== محتوى العنصر " + selectedElement.getName() + " ===");
        System.out.println("السمات:");
        for (HtmlAttributeSymbol attr : selectedElement.getAttributes().values()) {
            System.out.printf("  • %s=\"%s\"\n", attr.getName(), attr.getValueWithoutQuotes());
        }
    }

     public static void searchWithinStyleAttribute(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل رقم السطر لسمة style: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine();

        List<StyleAttributeSymbol> styleAttributes = getAllStyleAttributes(symbolTable);
        StyleAttributeSymbol styleAttr = null;

        for (StyleAttributeSymbol attr : styleAttributes) {
            if (attr.getLine() == lineNumber) {
                styleAttr = attr;
                break;
            }
        }

        if (styleAttr == null) {
            System.out.println("لم يتم العثور على سمة style في السطر " + lineNumber);
            return;
        }

        System.out.println("\n=== قواعد CSS في سمة style ===");
        List<CssRuleSymbol> rules = styleAttr.getCssRules();
        System.out.println("عدد القواعد: " + rules.size());

        for (CssRuleSymbol rule : rules) {
            System.out.printf("• %s: %s\n", rule.getProperty(), rule.getValuesAsString());
        }
    }

     public static void searchWithinJinjaBlock(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.println("اختر نوع كتلة Jinja:");
        System.out.println("1. كتل IF");
        System.out.println("2. كتل FOR");
        System.out.print("اختر خيارًا: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        List<JinjaSymbol> blocks = new ArrayList<>();

        if (typeChoice == 1) {
            blocks = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.IF);
        } else if (typeChoice == 2) {
            blocks = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.FOR);
        } else {
            System.out.println("خيار غير صحيح!");
            return;
        }

        System.out.println("\n=== كتل Jinja التي تم العثور عليها ===");
        if (blocks.isEmpty()) {
            System.out.println("لم يتم العثور على كتل من النوع المحدد.");
            return;
        }

        for (int i = 0; i < blocks.size(); i++) {
            JinjaSymbol block = blocks.get(i);
            System.out.printf("%d. %s في السطر %d\n",
                    i + 1,
                    block.getJinjaType(),
                    block.getLine());
        }
    }

     public static void displayJinjaByType(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.println("اختر نوع تعبير Jinja:");
        System.out.println("1. تعبيرات (Expressions)");
        System.out.println("2. عبارات (Statements)");
        System.out.println("3. تعليقات (Comments)");
        System.out.println("4. كتل IF");
        System.out.println("5. كتل FOR");
        System.out.print("اختر خيارًا: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        List<JinjaSymbol> results = new ArrayList<>();

        switch (typeChoice) {
            case 1:
                results = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.EXPRESSION);
                break;
            case 2:
                results = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.STATEMENT);
                break;
            case 3:
                results = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.COMMENT);
                break;
            case 4:
                results = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.IF);
                break;
            case 5:
                results = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.FOR);
                break;
            default:
                System.out.println("خيار غير صحيح!");
                return;
        }

        System.out.println("\n=== نتائج البحث ===");
        if (results.isEmpty()) {
            System.out.println("لم يتم العثور على تعبيرات من النوع المحدد.");
        } else {
            System.out.println("عدد النتائج: " + results.size());
            for (JinjaSymbol jinja : results) {
                System.out.printf("• %s: %s (السطر: %d)\n",
                        jinja.getJinjaType(),
                        jinja.getContent(),
                        jinja.getLine());
            }
        }
    }

     public static void displayErrorsAndWarnings(VisitorJinjaSymbolTable visitor) {
        System.out.println("\n=== الأخطاء والتحذيرات ===");

        List<String> errors = visitor.getErrors();
        List<String> warnings = visitor.getWarnings();

        System.out.println("عدد الأخطاء: " + errors.size());
        System.out.println("عدد التحذيرات: " + warnings.size());

        if (!errors.isEmpty()) {
            System.out.println("\n=== الأخطاء ===");
            for (String error : errors) {
                System.out.println("• " + error);
            }
        }

        if (!warnings.isEmpty()) {
            System.out.println("\n=== التحذيرات ===");
            for (String warning : warnings) {
                System.out.println("• " + warning);
            }
        }
    }

     public static void testAllFunctions(HtmlCssJinjaSymbolTable symbolTable, VisitorJinjaSymbolTable visitor) {
        System.out.println("\n=== اختبار جميع الوظائف ===");

        System.out.println("1. اختبار الحصول على جميع العناصر HTML...");
        List<HtmlElementSymbol> htmlElements = getAllHtmlElements(symbolTable);
        System.out.println("   عدد العناصر: " + htmlElements.size());

        System.out.println("2. اختبار الحصول على جميع قواعد CSS...");
        List<CssRuleSymbol> cssRules = getAllCssRules(symbolTable);
        System.out.println("   عدد القواعد: " + cssRules.size());

        System.out.println("3. اختبار الحصول على جميع تعبيرات Jinja...");
        List<JinjaSymbol> jinjaSymbols = getAllJinjaSymbols(symbolTable);
        System.out.println("   عدد التعبيرات: " + jinjaSymbols.size());

        System.out.println("4. اختبار البحث عن عنصر div...");
        List<HtmlElementSymbol> divElements = getHtmlElementsByTag(symbolTable, "div");
        System.out.println("   عدد عناصر div: " + divElements.size());

        System.out.println("5. اختبار البحث عن سمة color في CSS...");
        List<CssRuleSymbol> colorRules = getCssRulesByProperty(symbolTable, "color");
        System.out.println("   عدد قواعد color: " + colorRules.size());

        System.out.println("6. اختبار الحصول على الأخطاء...");
        List<String> errors = visitor.getErrors();
        System.out.println("   عدد الأخطاء: " + errors.size());

        System.out.println("7. اختبار الحصول على التحذيرات...");
        List<String> warnings = visitor.getWarnings();
        System.out.println("   عدد التحذيرات: " + warnings.size());

        System.out.println("8. اختبار البحث في تعبيرات Jinja...");
        List<JinjaSymbol> searchResults = getJinjaSymbolsByContent(symbolTable, "");
        System.out.println("   نتائج البحث: " + searchResults.size());

        System.out.println("9. اختبار الحصول على سمات Style...");
        List<StyleAttributeSymbol> styleAttributes = getAllStyleAttributes(symbolTable);
        System.out.println("   عدد سمات Style: " + styleAttributes.size());

        System.out.println("10. اختبار الحصول على كتل Jinja IF...");
        List<JinjaSymbol> ifBlocks = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.IF);
        System.out.println("   عدد كتل IF: " + ifBlocks.size());

        System.out.println("11. اختبار الحصول على كتل Jinja FOR...");
        List<JinjaSymbol> forBlocks = getJinjaSymbolsByType(symbolTable, JinjaSymbol.JinjaType.FOR);
        System.out.println("   عدد كتل FOR: " + forBlocks.size());

        System.out.println("12. اختبار عرض الإحصائيات...");
        System.out.println("   إجمالي العناصر: " + getAllHtmlElements(symbolTable).size());
        System.out.println("   إجمالي القواعد: " + getAllCssRules(symbolTable).size());
        System.out.println("   إجمالي التعبيرات: " + getAllJinjaSymbols(symbolTable).size());

        System.out.println("\n تم اختبار جميع الوظائف بنجاح!");
    }



     public static void displayNestedStructures(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.println("\n=== تحليل الهياكل المتداخلة ===");

        System.out.println("1. تحليل العلاقات بين العناصر");
        System.out.println("2. عرض التسلسل الهرمي");
        System.out.println("3. البحث عن عناصر ضمن سياق معين");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                analyzeElementRelationships(symbolTable);
                break;
            case 2:
                displayHierarchy(symbolTable);
                break;
            case 3:
                searchWithinContext(symbolTable, scanner);
                break;
            default:
                System.out.println("خيار غير صحيح!");
        }
    }


     public static List<HtmlElementSymbol> getAllHtmlElements(HtmlCssJinjaSymbolTable symbolTable) {
        List<HtmlElementSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("HTML_ELEMENT")) {
            if (symbol instanceof HtmlElementSymbol) {
                result.add((HtmlElementSymbol) symbol);
            }
        }
        return result;
    }

     public static List<CssRuleSymbol> getAllCssRules(HtmlCssJinjaSymbolTable symbolTable) {
        List<CssRuleSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("CSS_RULE")) {
            if (symbol instanceof CssRuleSymbol) {
                result.add((CssRuleSymbol) symbol);
            }
        }
        return result;
    }

     public static List<JinjaSymbol> getAllJinjaSymbols(HtmlCssJinjaSymbolTable symbolTable) {
        List<JinjaSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("JINJA")) {
            if (symbol instanceof JinjaSymbol) {
                result.add((JinjaSymbol) symbol);
            }
        }
        return result;
    }

     public static List<HtmlElementSymbol> getHtmlElementsByTag(HtmlCssJinjaSymbolTable symbolTable, String tagName) {
        List<HtmlElementSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("HTML_ELEMENT")) {
            if (symbol instanceof HtmlElementSymbol && symbol.getName().equalsIgnoreCase(tagName)) {
                result.add((HtmlElementSymbol) symbol);
            }
        }
        return result;
    }

     public static List<CssRuleSymbol> getCssRulesByProperty(HtmlCssJinjaSymbolTable symbolTable, String property) {
        List<CssRuleSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("CSS_RULE")) {
            if (symbol instanceof CssRuleSymbol && ((CssRuleSymbol) symbol).getProperty().equalsIgnoreCase(property)) {
                result.add((CssRuleSymbol) symbol);
            }
        }
        return result;
    }

     public static List<JinjaSymbol> getJinjaSymbolsByContent(HtmlCssJinjaSymbolTable symbolTable, String content) {
        List<JinjaSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("JINJA")) {
            if (symbol instanceof JinjaSymbol && ((JinjaSymbol) symbol).getContent().contains(content)) {
                result.add((JinjaSymbol) symbol);
            }
        }
        return result;
    }

     public static List<JinjaSymbol> getJinjaSymbolsByType(HtmlCssJinjaSymbolTable symbolTable, JinjaSymbol.JinjaType type) {
        List<JinjaSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("JINJA")) {
            if (symbol instanceof JinjaSymbol && ((JinjaSymbol) symbol).getJinjaType() == type) {
                result.add((JinjaSymbol) symbol);
            }
        }
        return result;
    }

     public static List<StyleAttributeSymbol> getAllStyleAttributes(HtmlCssJinjaSymbolTable symbolTable) {
        List<StyleAttributeSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolTable.findSymbolsByType("HTML_ATTRIBUTE")) {
            if (symbol instanceof StyleAttributeSymbol) {
                result.add((StyleAttributeSymbol) symbol);
            }
        }
        return result;
    }

     public static void analyzeElementRelationships(HtmlCssJinjaSymbolTable symbolTable) {
        System.out.println("\n=== تحليل العلاقات بين العناصر ===");

        List<HtmlElementSymbol> elements = getAllHtmlElements(symbolTable);

        Map<String, List<String>> parentRelationships = new HashMap<>();
        Map<String, List<String>> childRelationships = new HashMap<>();

        for (HtmlElementSymbol element : elements) {
            String elementName = element.getName();
            String parentName = element.getParent() != null ? element.getParent().getName() : "root";

            parentRelationships.computeIfAbsent(parentName, k -> new ArrayList<>()).add(elementName);

            childRelationships.put(elementName, element.getAncestors().stream()
                    .map(HtmlElementSymbol::getName)
                    .collect(Collectors.toList()));
        }

        System.out.println("العلاقات الأب-ابن:");
        for (Map.Entry<String, List<String>> entry : parentRelationships.entrySet()) {
            System.out.printf("  • %s -> %s\n", entry.getKey(), entry.getValue());
        }
    }

     public static void displayHierarchy(HtmlCssJinjaSymbolTable symbolTable) {
        System.out.println("\n=== التسلسل الهرمي للعناصر ===");

        List<HtmlElementSymbol> elements = getAllHtmlElements(symbolTable);

        List<HtmlElementSymbol> rootElements = elements.stream()
                .filter(element -> element.getParent() == null)
                .collect(Collectors.toList());

        for (HtmlElementSymbol root : rootElements) {
            displayElementAndContent(root, 0);
        }
    }

     public static void displayElementAndContent(HtmlElementSymbol element, int level) {
        String indent = "  ".repeat(level);
        System.out.printf("%s• <%s> (السطر: %d)\n", indent, element.getName(), element.getLine());

        if (element.getAttributes() != null && !element.getAttributes().isEmpty()) {
            for (HtmlAttributeSymbol attr : element.getAttributes().values()) {
                System.out.printf("%s  - %s=\"%s\"\n", indent, attr.getName(), attr.getValueWithoutQuotes());
            }
        }

        for (HtmlElementSymbol child : element.getChildren()) {
            displayElementAndContent(child, level + 1);
        }
    }

     public static void searchWithinContext(HtmlCssJinjaSymbolTable symbolTable, Scanner scanner) {
        System.out.print("أدخل اسم سياق Jinja للبحث (مثال: if, for, with): ");
        String contextName = scanner.nextLine();

        List<JinjaSymbol> results = getAllJinjaSymbols(symbolTable).stream()
                .filter(symbol -> symbol.getContent().contains(contextName))
                .collect(Collectors.toList());

        System.out.println("\n=== العناصر ضمن سياق " + contextName + " ===");
        if (results.isEmpty()) {
            System.out.println("لم يتم العثور على عناصر ضمن هذا السياق.");
            return;
        }

        System.out.println("عدد العناصر: " + results.size());
        for (JinjaSymbol symbol : results) {
            System.out.printf("• %s: %s (السطر: %d)\n",
                    symbol.getJinjaType(),
                    symbol.getContent(),
                    symbol.getLine());
        }
    }
}
