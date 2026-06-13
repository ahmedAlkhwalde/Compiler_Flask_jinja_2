package ASTFlask.AtomExpression;

public class NameArgumentExpr extends ExpressionAtom{

    public String name;
    public ExpressionAtom value;

    public NameArgumentExpr(String name, ExpressionAtom value, int line) {
        super("NamedArgument", line);
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", name=" + name + ", value=" + value + ")";
    }
}
