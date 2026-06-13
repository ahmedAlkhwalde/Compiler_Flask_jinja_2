package ASTFlask.AtomExpression;

public class FStringExpression extends ExpressionAtom {
    public String value;

    public FStringExpression(String value, int line) {
        super("FStringExpr", line);
        this.value = value;
    }

    @Override
    public String toString() {
        if (value.length() > 50) {
            return nodeName + "(line=" + line + ", value='" + value.substring(0, 47) + "...')";
        }
        return nodeName + "(line=" + line + ", value='" + value + "')";
    }
}