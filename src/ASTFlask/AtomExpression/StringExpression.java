package ASTFlask.AtomExpression;

public class StringExpression extends ExpressionAtom{
    public String value;

    public StringExpression(String value, int line) {
        super("StringExpr", line);
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
