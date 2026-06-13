package ASTFlask.AtomExpression;

public class NameExpression extends ExpressionAtom {
    public String name;

    public NameExpression(String name, int line) {
        super("NameExpr", line);
        this.name = name;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", name=" + name + ")";
    }
}
