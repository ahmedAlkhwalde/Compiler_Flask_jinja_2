package ASTFlask.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class ClassSymbol extends Symbol {
    public List<VariableSymbol> attributes;
    public List<FunctionSymbol> methods;

    public ClassSymbol(String name, int line, Scope scope) {
        super(name, "class", line, scope);
        this.attributes = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Class(" + name + " with " + attributes.size() + " attrs, " + methods.size() + " methods)";
    }
}