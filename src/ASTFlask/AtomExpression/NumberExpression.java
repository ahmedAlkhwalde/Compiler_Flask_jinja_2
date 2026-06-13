package ASTFlask.AtomExpression;

public class NumberExpression extends ExpressionAtom{
    public String value;

    public NumberExpression(String value, int line) {
        super("NumberExpr", line);
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", value=" + value + ")";
    }
}
