package ASTFlask.SymbolTable;

import java.util.ArrayList;
import java.util.List;

    public class FunctionSymbol extends Symbol {
    public List<VariableSymbol> parameters;
    public String returnType;
    public Scope functionScope;

    public FunctionSymbol(String name, String returnType, int line, Scope scope) {
        super(name, "function", line, scope);
        this.returnType = returnType;
        this.parameters = new ArrayList<>();
    }

    public void addParameter(VariableSymbol param) {
        parameters.add(param);
    }

    @Override
    public String toString() {
        return "Function(" + name + ":" + returnType + " with " + parameters.size() + " params)";
    }

}