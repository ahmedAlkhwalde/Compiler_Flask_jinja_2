package ASTFlask.SymbolTable;


public abstract class Symbol {
    public String name;
    public String type;
    public int line;
    public Scope scope;

    public Symbol(String name, String type, int line, Scope scope) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.scope = scope;
    }

    public abstract String toString();
}