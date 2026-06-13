package ASTFlask.AtomExpression;

public class BooleanExpression extends ExpressionAtom{
    public boolean value;

    public BooleanExpression(boolean value, int line) {
        super("BooleanExpr", line);
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", value=" + value + ")";
    }
}
