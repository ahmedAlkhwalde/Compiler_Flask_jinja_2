package Merge_Symbol_tables;

import java.util.*;

/**
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║              جدول الرموز الموحّد - Python ↔ Jinja2              ║
 * ║                                                                  ║
 * ║  الجدولان مرتبطان ببعض عبر:                                    ║
 * ║  1. linkedTo   : كل رمز يعرف من يقابله في الجانب الآخر         ║
 * ║  2. crossLinks : خريطة ربط مباشرة Python_name ↔ Jinja_name     ║
 * ║  3. validate() : دالة تتحقق من سلامة كل الروابط                ║
 * ╚══════════════════════════════════════════════════════════════════╝
 */
public class SymbolTable {

    // ══════════════════════════════════════════════════════════════
    //  أنواع الرموز
    // ══════════════════════════════════════════════════════════════
    public enum SymbolKind {
        VARIABLE,   // متغير بسيط في Python
        LIST,       // قائمة في Python → ستصبح for loop في Jinja
        ROUTE,      // دالة Flask في Python → مرتبطة بقالب Jinja
        TEMPLATE,   // قالب HTML في Jinja → مرتبط بـ route Python
        LOOP_VAR,   // متغير حلقة for في Jinja (مصدره LIST في Python)
        FORM_VAR    // متغير نموذج HTML في Jinja
    }

    public enum SymbolSource { PYTHON, JINJA }

    // ══════════════════════════════════════════════════════════════
    //  كلاس الرمز الموحّد
    // ══════════════════════════════════════════════════════════════
    public static class Symbol {
        public final String       name;
        public String       type;        // "list","string","number","route","template"...
        public final SymbolKind   kind;
        public final SymbolSource source;      // من أين جاء: PYTHON أو JINJA
        public final int          lineNumber;

        // ── حقول الربط بين الشجرتين ──────────────────────────────
        public String  linkedTo;       // اسم الرمز المقابل في الجانب الآخر
        public String  linkedFile;     // اسم الملف/القالب المرتبط
        public boolean isResolved;     // هل تم التحقق من الرابط وهو صحيح؟
        public List<String> usedKeys;  // مفاتيح القاموس المستخدمة في Jinja

        public Symbol(String name, String type, SymbolKind kind,
                      SymbolSource source, int lineNumber) {
            this.name       = name;
            this.type       = type;
            this.kind       = kind;
            this.source     = source;
            this.lineNumber = lineNumber;
            this.isResolved = false;
            this.usedKeys   = new ArrayList<>();
        }

        public String statusIcon() {
            if (!isResolved) return "⚪"; // لم يُربط بعد
            return "✅";                   // مرتبط وصحيح
        }

        @Override
        public String toString() {
            String linked = (linkedTo != null) ? linkedTo : "—";
            String file   = (linkedFile != null) ? " [" + linkedFile + "]" : "";
            return String.format("  %s %-22s | %-10s | %-10s | %-6s | line:%-4d | → %s%s",
                    statusIcon(), name, type, kind, source, lineNumber, linked, file);
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  التخزين الداخلي
    // ══════════════════════════════════════════════════════════════

    // الجداول المنفصلة (للبحث السريع)
    private final Map<String, Symbol> pythonSymbols = new LinkedHashMap<>();
    private final Map<String, Symbol> jinjaSymbols  = new LinkedHashMap<>();

    // ── جدول الروابط المتقاطعة (القلب) ──────────────────────────
    // crossLinks.get("products") = "products.html"  (Python LIST → Jinja TEMPLATE)
    // crossLinks.get("show_products") = "products.html" (Python ROUTE → Jinja TEMPLATE)
    // crossLinks.get("product_loop") = "products"   (Jinja LOOP_VAR → Python LIST)
    private final Map<String, String>       crossLinks     = new LinkedHashMap<>();

    // خريطة route → template (من Python)
    private final Map<String, String>       routeToTemplate = new LinkedHashMap<>();

    // خريطة template → dataVariable (من Jinja)
    private final Map<String, String>       templateToData  = new LinkedHashMap<>();

    // خريطة listName → List of keys (مفاتيح القاموس في Python)
    private final Map<String, List<String>> listKeys        = new LinkedHashMap<>();

    private final List<String> semanticErrors   = new ArrayList<>();
    private final List<String> semanticWarnings = new ArrayList<>();

    // ══════════════════════════════════════════════════════════════
    //  إضافة رموز Python
    // ══════════════════════════════════════════════════════════════

    public void addPythonSymbol(Symbol s) {
        if (pythonSymbols.containsKey(s.name)) {
            addError("[Python] سطر " + s.lineNumber +
                    ": '" + s.name + "' مُعرَّف مسبقاً في سطر " +
                    pythonSymbols.get(s.name).lineNumber);
            return;
        }
        pythonSymbols.put(s.name, s);

        // إذا كان route → سجّل في خريطة routeToTemplate
        if (s.kind == SymbolKind.ROUTE && s.linkedFile != null) {
            routeToTemplate.put(s.name, s.linkedFile);
            crossLinks.put(s.name, s.linkedFile);
        }

        // إذا كان LIST → سجّل مفاتيحه
        if (s.kind == SymbolKind.LIST && s.usedKeys != null && !s.usedKeys.isEmpty()) {
            listKeys.put(s.name, new ArrayList<>(s.usedKeys));
        }
    }

    // سجّل مفاتيح قائمة Python (تُستخدم لاحقاً للتحقق من Jinja)
    public void registerListKeys(String listName, List<String> keys) {
        listKeys.put(listName, new ArrayList<>(keys));
        Symbol sym = pythonSymbols.get(listName);
        if (sym != null) sym.usedKeys = new ArrayList<>(keys);
    }

    // ══════════════════════════════════════════════════════════════
    //  إضافة رموز Jinja
    // ══════════════════════════════════════════════════════════════

    public void addJinjaSymbol(Symbol s) {
        jinjaSymbols.put(s.name, s);

        // إذا كان TEMPLATE → سجّل في خريطة templateToData
        if (s.kind == SymbolKind.TEMPLATE && s.linkedTo != null) {
            templateToData.put(s.name, s.linkedTo);
        }

        // إذا كان LOOP_VAR → اربطه بالـ LIST في Python
        if (s.kind == SymbolKind.LOOP_VAR && s.linkedTo != null) {
            crossLinks.put(s.name + "_loop", s.linkedTo);
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  دالة الربط الرئيسية - تُشغَّل بعد تسجيل كل الرموز
    //  تربط كل رمز Python بمقابله في Jinja وبالعكس
    // ══════════════════════════════════════════════════════════════

    public void resolveLinks() {
        System.out.println("  ▶ جاري ربط الرموز بين Python و Jinja2...\n");

        // ── ربط ROUTE (Python) ↔ TEMPLATE (Jinja) ────────────────
        for (Symbol route : getPythonByKind(SymbolKind.ROUTE)) {
            String templateName = routeToTemplate.get(route.name);
            if (templateName == null) continue;

            Symbol template = jinjaSymbols.get(templateName);
            if (template != null) {
                // الربط ثنائي الاتجاه
                route.linkedTo    = templateName;
                route.isResolved  = true;
                template.linkedTo = route.name;
                template.isResolved = true;
                System.out.println("  ✅ ROUTE  [Python] '" + route.name +
                        "' ←→ TEMPLATE [Jinja] '" + templateName + "'");
            } else {
                addError("[ربط] route '" + route.name +
                        "' يشير إلى قالب '" + templateName +
                        "' غير موجود في Jinja");
                System.out.println("  ❌ ROUTE  [Python] '" + route.name +
                        "' → '" + templateName + "' (لم يُوجد!)");
            }
        }

        // ── ربط LIST (Python) ↔ LOOP_VAR (Jinja) ─────────────────
        for (Symbol loopVar : getJinjaByKind(SymbolKind.LOOP_VAR)) {
            String sourceList = loopVar.linkedTo; // اسم القائمة في Python
            if (sourceList == null) continue;

            Symbol list = pythonSymbols.get(sourceList);
            if (list != null) {
                list.linkedTo    = loopVar.name;
                list.isResolved  = true;
                loopVar.isResolved = true;
                System.out.println("  ✅ LIST   [Python] '" + sourceList +
                        "' ←→ FOR_LOOP [Jinja] '" + loopVar.name + "'");

                // تحقق إضافي: هل مفاتيح Jinja موجودة في Python؟
                validateJinjaKeysAgainstPython(loopVar, sourceList);
            } else {
                addError("[ربط] حلقة for في Jinja تكرر على '" + sourceList +
                        "' غير معرّف في Python");
                System.out.println("  ❌ FOR_LOOP [Jinja] '" + loopVar.name +
                        "' → '" + sourceList + "' (لم يُوجد!)");
            }
        }

        // ── ربط TEMPLATE (Jinja) ↔ dataVariable (Python) ─────────
        for (Symbol template : getJinjaByKind(SymbolKind.TEMPLATE)) {
            String dataVar = templateToData.get(template.name);
            if (dataVar == null) continue;

            if (!pythonSymbols.containsKey(dataVar)) {
                addError("[ربط] قالب '" + template.name +
                        "' يستخدم متغير '" + dataVar +
                        "' غير معرّف في Python");
                System.out.println("  ❌ TEMPLATE [Jinja] '" + template.name +
                        "' → data='" + dataVar + "' (غير موجود في Python!)");
            } else {
                System.out.println("  ✅ TEMPLATE [Jinja] '" + template.name +
                        "' ← data='" + dataVar + "' [Python]");
            }
        }

        System.out.println();
    }

    // ══════════════════════════════════════════════════════════════
    //  التحقق من المفاتيح: هل {{ product.price }} موجود فعلاً؟
    // ══════════════════════════════════════════════════════════════

    private void validateJinjaKeysAgainstPython(Symbol loopVar, String listName) {
        List<String> knownKeys = listKeys.get(listName);
        if (knownKeys == null || loopVar.usedKeys == null) return;

        for (String usedKey : loopVar.usedKeys) {
            if (!knownKeys.contains(usedKey)) {
                addError("[مفتاح] Jinja تستخدم '" + loopVar.name + "." + usedKey +
                        "' لكن المفتاح '" + usedKey +
                        "' غير موجود في قاموس Python '" + listName +
                        "'. المفاتيح المتاحة: " + knownKeys);
            }
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  التحقق الشامل من كل الروابط (يُشغَّل بعد resolveLinks)
    // ══════════════════════════════════════════════════════════════

    public void validate() {
        // تحقق 1: كل LIST في Python لها for loop مقابل في Jinja؟
        for (Symbol sym : getPythonByKind(SymbolKind.LIST)) {
            if (!sym.isResolved) {
                addWarning("[تحذير] القائمة Python '" + sym.name +
                        "' لم تُستخدم في أي حلقة for في Jinja");
            }
        }

        // تحقق 2: كل ROUTE في Python له template مقابل؟
        for (Symbol sym : getPythonByKind(SymbolKind.ROUTE)) {
            if (!sym.isResolved) {
                addError("[دلالي] route '" + sym.name +
                        "' لا يملك قالب Jinja مقابل");
            }
        }

        // تحقق 3: كل TEMPLATE في Jinja له route مقابل في Python؟
        for (Symbol sym : getJinjaByKind(SymbolKind.TEMPLATE)) {
            if (!sym.isResolved) {
                addError("[دلالي] قالب '" + sym.name +
                        "' لا يملك route Python مقابل");
            }
        }

        // تحقق 4: route path يبدأ بـ / ؟
        for (Map.Entry<String, String> e : routeToTemplate.entrySet()) {
            // (هذا المثال لو خزّنا routePath نفسه وليس اسم الدالة)
        }
    }

    // ══════════════════════════════════════════════════════════════
    //  Getters
    // ══════════════════════════════════════════════════════════════

    public Symbol getPythonSymbol(String name)  { return pythonSymbols.get(name); }
    public Symbol getJinjaSymbol(String name)   { return jinjaSymbols.get(name); }
    public boolean pythonSymbolExists(String n) { return pythonSymbols.containsKey(n); }
    public boolean jinjaSymbolExists(String n)  { return jinjaSymbols.containsKey(n); }
    public Map<String, Symbol> getAllPythonSymbols() { return Collections.unmodifiableMap(pythonSymbols); }
    public Map<String, Symbol> getAllJinjaSymbols()  { return Collections.unmodifiableMap(jinjaSymbols); }
    public List<String> getListKeys(String name) { return listKeys.getOrDefault(name, new ArrayList<>()); }

    public List<Symbol> getPythonByKind(SymbolKind kind) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol s : pythonSymbols.values()) if (s.kind == kind) result.add(s);
        return result;
    }

    public List<Symbol> getJinjaByKind(SymbolKind kind) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol s : jinjaSymbols.values()) if (s.kind == kind) result.add(s);
        return result;
    }

    // ══════════════════════════════════════════════════════════════
    //  Errors & Warnings
    // ══════════════════════════════════════════════════════════════

    public void addError(String e)   { semanticErrors.add(e); }
    public void addWarning(String w) { semanticWarnings.add(w); }
    public List<String> getErrors()    { return semanticErrors; }
    public List<String> getWarnings()  { return semanticWarnings; }
    public boolean hasErrors()         { return !semanticErrors.isEmpty(); }

    // ══════════════════════════════════════════════════════════════
    //  طباعة الجداول الموحّدة مع الروابط
    // ══════════════════════════════════════════════════════════════

    public void printTable() {
        String line = "═".repeat(90);
        String thin = "─".repeat(90);

        System.out.println("\n╔" + line + "╗");
        System.out.println("║" + center("جدول الرموز الموحّد - Python ↔ Jinja2", 90) + "║");
        System.out.println("╠" + line + "╣");

        // ── Python ────────────────────────────────────────────────
        System.out.println("║" + center("◀  Python  ▶", 90) + "║");
        System.out.println("╠" + line + "╣");
        printHeader();
        System.out.println("  " + thin);
        pythonSymbols.values().forEach(s -> System.out.println(s));

        // ── الروابط المتقاطعة ─────────────────────────────────────
        System.out.println("╠" + line + "╣");
        System.out.println("║" + center("🔗  روابط Python ↔ Jinja2  🔗", 90) + "║");
        System.out.println("╠" + line + "╣");
        if (crossLinks.isEmpty()) {
            System.out.println("  (لا توجد روابط مسجّلة)");
        } else {
            crossLinks.forEach((k, v) ->
                    System.out.printf("  %-30s  ←→  %s%n", k, v));
        }

        // ── Jinja ─────────────────────────────────────────────────
        System.out.println("╠" + line + "╣");
        System.out.println("║" + center("◀  Jinja2  ▶", 90) + "║");
        System.out.println("╠" + line + "╣");
        printHeader();
        System.out.println("  " + thin);
        jinjaSymbols.values().forEach(s -> System.out.println(s));

        // ── الأخطاء ───────────────────────────────────────────────
        if (!semanticErrors.isEmpty() || !semanticWarnings.isEmpty()) {
            System.out.println("╠" + line + "╣");
            System.out.println("║" + center("⚠  الأخطاء والتحذيرات الدلالية", 90) + "║");
            System.out.println("╠" + line + "╣");
            semanticErrors.forEach(e   -> System.out.println("  ❌ " + e));
            semanticWarnings.forEach(w -> System.out.println("  ⚠  " + w));
        }

        System.out.println("╚" + line + "╝\n");
    }

    private void printHeader() {
        System.out.printf("  %2s %-22s | %-10s | %-10s | %-6s | %-6s | %s%n",
                "", "الاسم", "النوع", "الصنف", "المصدر", "السطر", "مرتبط بـ");
    }

    private String center(String text, int width) {
        int pad = Math.max(0, (width - text.length()) / 2);
        return " ".repeat(pad) + text + " ".repeat(width - pad - text.length());
    }
}