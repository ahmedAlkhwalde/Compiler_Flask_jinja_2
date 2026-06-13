package ASTFlask.SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Scope {
    public String name;
    public Scope parent;
    public Map<String, Symbol> symbols = new HashMap<>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean addSymbol(Symbol symbol) {
        if (symbol == null || symbol.name == null || symbol.name.isEmpty()) {
            return false;
        }

        if (symbols.containsKey(symbol.name)) {
            return false;
        }

        symbols.put(symbol.name, symbol);
        return true;
    }

    public Symbol lookupCurrent(String name) {
        return symbols.get(name);
    }

    public Symbol lookup(String name) {
        Symbol symbol = symbols.get(name);
        if (symbol != null) {
            return symbol;
        }
        if (parent != null) {
            return parent.lookup(name);
        }
        return null;
    }

    public boolean removeSymbol(String name) {
        if (symbols.containsKey(name)) {
            symbols.remove(name);
            return true;
        }
        return false;
    }

}