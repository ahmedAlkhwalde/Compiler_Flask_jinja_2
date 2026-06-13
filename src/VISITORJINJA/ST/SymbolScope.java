package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolScope {
    public enum ScopeType {
        GLOBAL,
        HTML_DOCUMENT,
        HTML_ELEMENT,
        JINJA_BLOCK,
        JINJA_FOR,
        JINJA_IF,
        STYLE_ATTRIBUTE,
        CSS_RULE
    }

    public String name;
    private ScopeType type;
    public SymbolScope parent;
    private Map<String, Symbol> symbols;
    private Map<String, List<Symbol>> symbolHistory;

    public SymbolScope(String name, ScopeType type, SymbolScope parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.symbols = new HashMap<>();
        this.symbolHistory = new HashMap<>();
    }

    public boolean addSymbol(Symbol symbol) {
        if (symbol == null || symbol.name == null) {
            return false;
        }

        if (!symbolHistory.containsKey(symbol.name)) {
            symbolHistory.put(symbol.name, new ArrayList<>());
        }
        symbolHistory.get(symbol.name).add(symbol);

        symbols.put(symbol.name, symbol);
        return true;
    }

    public Symbol lookup(String name) {
        return symbols.get(name);
    }


    public Symbol lookupRecursive(String name) {
        Symbol symbol = lookup(name);
        if (symbol != null) {
            return symbol;
        }
        if (parent != null) {
            return parent.lookupRecursive(name);
        }
        return null;
    }
    public void printScope(int indent) {
        String indentStr = "  ".repeat(indent);
        System.out.println(indentStr + "[" + type + "] " + name + ":");

        for (Symbol symbol : symbols.values()) {
            System.out.println(indentStr + "  • " + symbol.name + " (" + symbol.type + ")");
        }

        if (symbols.isEmpty()) {
            System.out.println(indentStr + "  (empty)");
        }
    }

}
