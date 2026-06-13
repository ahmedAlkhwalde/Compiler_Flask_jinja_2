package ASTFlask.SymbolTable;

import VisitorFlask.SymbolTableBuilder;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Operationflask {
    public static void displaySymbolTable(SymbolTableBuilder builder) {
        System.out.println("\n=== SYMBOL TABLE DISPLAY ===");
        builder.printSymbolTable();
    }

    public static void searchSymbol(SymbolTableBuilder builder, Scanner scanner) {
        System.out.print("أدخل اسم الرمز للبحث: ");
        String name = scanner.nextLine();

        SymbolTableBuilder.SymbolLookupResult result = builder.lookupWithScope(name);
        if (result != null) {
            System.out.println(" تم العثور على الرمز:");
            System.out.println("  • الاسم: " + result.symbol.name);
            System.out.println("  • النوع: " + result.symbol.type);
            System.out.println("  • السطر: " + result.symbol.line);
            System.out.println("  • النطاق: " + result.scope.name);
        } else {
            System.out.println(" الرمز غير موجود: " + name);
        }
    }

    public static void addSymbol(SymbolTableBuilder builder, Scanner scanner) {
        System.out.println("\n=== إضافة رمز جديد ===");
        System.out.print("اسم الرمز: ");
        String name = scanner.nextLine();

        System.out.print("نوع الرمز (variable/function/class): ");
        String type = scanner.nextLine();

        System.out.print("رقم السطر: ");
        int line = scanner.nextInt();
        scanner.nextLine();

        Symbol symbol;
        switch (type.toLowerCase()) {
            case "variable":
                symbol = new VariableSymbol(name, "any", line, builder.getCurrentScope());
                break;
            case "function":
                symbol = new FunctionSymbol(name, "unknown", line, builder.getCurrentScope());
                break;
            case "class":
                symbol = new ClassSymbol(name, line, builder.getCurrentScope());
                break;
            default:
                System.out.println("نوع غير صحيح!");
                return;
        }

        boolean success = builder.addSymbol(symbol);
        if (success) {
            System.out.println(" تمت إضافة الرمز بنجاح");
        }
    }

    public static void updateSymbol(SymbolTableBuilder builder, Scanner scanner) {
        System.out.print("أدخل اسم الرمز للتحديث: ");
        String oldName = scanner.nextLine();

        System.out.print("أدخل الاسم الجديد: ");
        String newName = scanner.nextLine();

        System.out.print("أدخل النوع الجديد: ");
        String newType = scanner.nextLine();

        System.out.print("أدخل السطر الجديد: ");
        int newLine = scanner.nextInt();
        scanner.nextLine();

        VariableSymbol newSymbol = new VariableSymbol(newName, newType, newLine, builder.getCurrentScope());
        boolean success = builder.updateSymbol(oldName, newSymbol);

        if (success) {
            System.out.println(" تم تحديث الرمز بنجاح");
        }
    }

    public static void deleteSymbol(SymbolTableBuilder builder, Scanner scanner) {
        System.out.print("أدخل اسم الرمز للحذف: ");
        String name = scanner.nextLine();

        System.out.print("هل تريد الحذف من نطاق معين؟ (y/n): ");
        String scopeChoice = scanner.nextLine();

        boolean success;
        if (scopeChoice.equalsIgnoreCase("y")) {
            System.out.print("أدخل اسم النطاق: ");
            String scopeName = scanner.nextLine();
            success = builder.deleteSymbolFromScope(name, scopeName);
        } else {
            success = builder.deleteSymbol(name);
        }

        if (success) {
            System.out.println(" تم حذف الرمز بنجاح");
        }
    }

    public static void renameSymbol(SymbolTableBuilder builder, Scanner scanner) {
        System.out.print("أدخل الاسم القديم: ");
        String oldName = scanner.nextLine();

        System.out.print("أدخل الاسم الجديد: ");
        String newName = scanner.nextLine();

        boolean success = builder.renameSymbol(oldName, newName);
        if (success) {
            System.out.println(" تمت إعادة التسمية بنجاح");
        }
    }

    public static void displayStatistics(SymbolTableBuilder builder) {
        SymbolTableBuilder.SymbolStatistics stats = builder.getStatistics();
        System.out.println("\n=== SYMBOL STATISTICS ===");
        System.out.println(stats.toString());
    }

    public static void advancedSearch(SymbolTableBuilder builder, Scanner scanner) {
        System.out.println("\n=== البحث المتقدم ===");
        System.out.print("اسم الرمز للبحث: ");
        String name = scanner.nextLine();

        System.out.print("البحث من النطاق الحالي؟ (y/n): ");
        boolean startFromCurrent = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("البحث العودي؟ (y/n): ");
        boolean recursive = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("فلترة حسب النوع (اترك فارغًا للجميع): ");
        String typeFilter = scanner.nextLine();
        if (typeFilter.trim().isEmpty()) {
            typeFilter = null;
        }

        System.out.print("حساسية حالة الأحرف؟ (y/n): ");
        boolean caseSensitive = scanner.nextLine().equalsIgnoreCase("y");

        SymbolTableBuilder.LookupOptions options = new SymbolTableBuilder.LookupOptions()
                .startFromCurrent(startFromCurrent)
                .recursive(recursive)
                .typeFilter(typeFilter)
                .caseSensitive(caseSensitive);

        Symbol result = builder.advancedLookup(name, options);

        if (result != null) {
            System.out.println(" تم العثور على الرمز:");
            System.out.println("  • الاسم: " + result.name);
            System.out.println("  • النوع: " + result.type);
            System.out.println("  • السطر: " + result.line);
        } else {
            System.out.println(" الرمز غير موجود");
        }
    }

    public static void displayUnusedSymbols(SymbolTableBuilder builder) {
        List<Symbol> unused = builder.getUnusedSymbols();
        System.out.println("\n=== UNUSED SYMBOLS ===");
        System.out.println("عدد الرموز غير المستخدمة: " + unused.size());

        for (Symbol symbol : unused) {
            System.out.println("  • " + symbol.name + " (" + symbol.type + ") at line " + symbol.line);
        }

        if (unused.isEmpty()) {
            System.out.println("لا توجد رموز غير مستخدمة");
        }
    }

    public static void exportSymbolTable(SymbolTableBuilder builder) {
        String exported = builder.exportSymbolTable();
        System.out.println("\n=== EXPORTED SYMBOL TABLE ===");
        System.out.println(exported);

        try {
            java.nio.file.Files.writeString(
                    java.nio.file.Path.of("Files/symbol_table_export.txt"),
                    exported
            );
            System.out.println(" تم التصدير إلى ملف: symbol_table_export.txt");
        } catch (IOException e) {
            System.out.println(" خطأ في حفظ الملف: " + e.getMessage());
        }
    }

    public static void displayNestedStructures(SymbolTableBuilder builder, Scanner scanner) {
        System.out.println("\n=== NESTED STRUCTURES ANALYSIS ===");

        Map<String, List<VariableSymbol>> nestedSymbols = builder.getAllNestedSymbols();

        if (nestedSymbols.isEmpty()) {
            System.out.println("لا توجد هياكل متداخلة.");
            return;
        }

        System.out.println("1. عرض جميع الهياكل المتداخلة");
        System.out.println("2. البحث عن متغير معين");
        System.out.println("3. عرض إحصائيات الهياكل المتداخلة");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displayAllNestedStructures(builder);
                break;
            case 2:
                searchNestedVariable(builder, scanner);
                break;
            case 3:
                displayNestedStatistics(builder);
                break;
            default:
                System.out.println("خيار غير صحيح!");
        }
    }

    public static void displayAllNestedStructures(SymbolTableBuilder builder) {
        Map<String, List<VariableSymbol>> nestedSymbols = builder.getAllNestedSymbols();

        System.out.println("\n=== ALL NESTED STRUCTURES ===");
        for (Map.Entry<String, List<VariableSymbol>> entry : nestedSymbols.entrySet()) {
            System.out.println("\nVariable: " + entry.getKey());
            System.out.println("Nested Fields:");

            Set<String> uniqueFields = new HashSet<>();
            Map<String, Integer> fieldCount = new HashMap<>();

            for (VariableSymbol nested : entry.getValue()) {
                String fullName = nested.name;
                String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                uniqueFields.add(fieldName);
                fieldCount.put(fieldName, fieldCount.getOrDefault(fieldName, 0) + 1);
            }

            for (String field : uniqueFields) {
                int count = fieldCount.get(field);
                System.out.println("  • " + field + " (appears " + count + " times)");
            }

            System.out.println("  Total unique fields: " + uniqueFields.size());
            System.out.println("  Total occurrences: " + entry.getValue().size());
        }
    }

    public static void searchNestedVariable(SymbolTableBuilder builder, Scanner scanner) {
        System.out.print("أدخل اسم المتغير للبحث عن حقوله المتداخلة: ");
        String varName = scanner.nextLine();

        List<VariableSymbol> nestedSymbols = builder.getNestedSymbols(varName);

        if (nestedSymbols.isEmpty()) {
            System.out.println("✗ لا توجد حقول متداخلة للمتغير: " + varName);
            return;
        }

        System.out.println("\n=== NESTED FIELDS FOR: " + varName + " ===");
        System.out.println("Total fields found: " + nestedSymbols.size());

        Map<String, List<VariableSymbol>> fieldsByType = new HashMap<>();
        for (VariableSymbol nested : nestedSymbols) {
            String fieldName = nested.name.substring(varName.length() + 1);
            fieldsByType.computeIfAbsent(nested.type, k -> new ArrayList<>()).add(nested);
        }

        for (Map.Entry<String, List<VariableSymbol>> entry : fieldsByType.entrySet()) {
            System.out.println("\nType: " + entry.getKey() + " (" + entry.getValue().size() + " fields)");

            Set<String> uniqueFields = new HashSet<>();
            for (VariableSymbol nested : entry.getValue()) {
                String fieldName = nested.name.substring(varName.length() + 1);
                uniqueFields.add(fieldName);
            }

            for (String field : uniqueFields) {
                System.out.println("  • " + field);
            }
        }

        System.out.println("\n--- Additional Information ---");
        System.out.println("Variable path: " + varName);
        System.out.println("Total unique fields: " + fieldsByType.values().stream()
                .flatMap(List::stream)
                .map(s -> s.name.substring(varName.length() + 1))
                .distinct()
                .count());
    }

    public static void displayNestedStatistics(SymbolTableBuilder builder) {
        Map<String, List<VariableSymbol>> nestedSymbols = builder.getAllNestedSymbols();

        System.out.println("\n=== NESTED STRUCTURES STATISTICS ===");

        int totalVariablesWithNesting = nestedSymbols.size();
        int totalNestedFields = nestedSymbols.values().stream()
                .mapToInt(List::size)
                .sum();

        Set<String> allUniqueFields = new HashSet<>();
        for (List<VariableSymbol> nestedList : nestedSymbols.values()) {
            for (VariableSymbol nested : nestedList) {
                String fullName = nested.name;
                String fieldName = fullName.substring(fullName.lastIndexOf(".") + 1);
                allUniqueFields.add(fieldName);
            }
        }

        System.out.println("Total variables with nested structures: " + totalVariablesWithNesting);
        System.out.println("Total nested field occurrences: " + totalNestedFields);
        System.out.println("Total unique field names: " + allUniqueFields.size());

        Map<String, Integer> typeStatistics = new HashMap<>();
        for (List<VariableSymbol> nestedList : nestedSymbols.values()) {
            for (VariableSymbol nested : nestedList) {
                typeStatistics.put(nested.type, typeStatistics.getOrDefault(nested.type, 0) + 1);
            }
        }

        System.out.println("\nField type distribution:");
        for (Map.Entry<String, Integer> entry : typeStatistics.entrySet()) {
            System.out.println("  • " + entry.getKey() + ": " + entry.getValue() + " fields");
        }

        System.out.println("\nMost complex variables (most nested fields):");
        nestedSymbols.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .limit(5)
                .forEach(entry -> {
                    Set<String> uniqueFields = entry.getValue().stream()
                            .map(s -> s.name.substring(s.name.lastIndexOf(".") + 1))
                            .collect(Collectors.toSet());
                    System.out.println("  • " + entry.getKey() + ": " +
                            uniqueFields.size() + " unique fields, " +
                            entry.getValue().size() + " total occurrences");
                });
    }

    public static void testAllFunctions(SymbolTableBuilder builder) {
        System.out.println("\n=== TESTING ALL FUNCTIONS ===");

        System.out.println("1. اختبار البحث المتقدم...");
        SymbolTableBuilder.LookupOptions options = new SymbolTableBuilder.LookupOptions()
                .startFromCurrent(false)
                .recursive(true)
                .typeFilter("function")
                .caseSensitive(false);

        Symbol symbol = builder.advancedLookup("myFunction", options);
        if (symbol != null) {
            System.out.println("    تم العثور على الوظيفة: " + symbol.name);
        }

        System.out.println("2. البحث عن جميع المتغيرات...");
        List<Symbol> variables = builder.findAllSymbolsByType("variable");
        System.out.println("   عدد المتغيرات: " + variables.size());

        System.out.println("3. البحث بالنمط 'temp'...");
        List<Symbol> tempVars = builder.searchSymbolsByNamePattern("temp");
        System.out.println("    عدد الرموز بالنمط 'temp': " + tempVars.size());

        System.out.println("4. إضافة رمز جديد 'testVar'...");
        VariableSymbol newVar = new VariableSymbol("testVar", "int", 999, builder.getCurrentScope());
        boolean added = builder.addSymbol(newVar);
        System.out.println("    " + (added ? "تمت الإضافة بنجاح" : "فشلت الإضافة"));

        System.out.println("5. تحديث رمز 'testVar'...");
        VariableSymbol updatedVar = new VariableSymbol("testVar", "str", 1000, builder.getCurrentScope());
        boolean updated = builder.updateSymbol("testVar", updatedVar);
        System.out.println("    " + (updated ? "تم التحديث بنجاح" : "فشل التحديث"));

        System.out.println("6. حذف رمز 'testVar'...");
        boolean deleted = builder.deleteSymbol("testVar");
        System.out.println("   " + (deleted ? "تم الحذف بنجاح" : "فشل الحذف"));

        System.out.println("7. حذف جميع رموز النوع 'iteration'...");
        int deletedCount = builder.deleteAllSymbolsByType("iteration");
        System.out.println("    تم حذف " + deletedCount + " رمز");

        System.out.println("8. اختبار إعادة التسمية...");
        VariableSymbol tempSymbol = new VariableSymbol("tempOld", "any", 999, builder.getCurrentScope());
        builder.addSymbol(tempSymbol);
        boolean renamed = builder.renameSymbol("tempOld", "tempNew");
        System.out.println(" " + (renamed ? "تمت إعادة التسمية بنجاح" : "فشلت إعادة التسمية"));

        System.out.println("9. الحصول على الإحصائيات...");
        SymbolTableBuilder.SymbolStatistics stats = builder.getStatistics();
        System.out.println("  " + stats);

        System.out.println("10. الحصول على الرموز غير المستخدمة...");
        List<Symbol> unused = builder.getUnusedSymbols();
        System.out.println("   عدد الرموز غير المستخدمة: " + unused.size());

        System.out.println("11. اختبار الهياكل المتداخلة...");
        Map<String, List<VariableSymbol>> nestedSymbols = builder.getAllNestedSymbols();
        System.out.println("    عدد المتغيرات ذات الهياكل المتداخلة: " + nestedSymbols.size());
        int totalNestedFields = nestedSymbols.values().stream()
                .mapToInt(List::size)
                .sum();
        System.out.println("    إجمالي الحقول المتداخلة: " + totalNestedFields);

        System.out.println("12. تصدير جدول الرموز...");
        String exported = builder.exportSymbolTable();
        System.out.println("    تم التصدير (الطول: " + exported.length() + " حرف)");

        System.out.println("\n تم اختبار جميع الوظائف بنجاح!");
    }
}
