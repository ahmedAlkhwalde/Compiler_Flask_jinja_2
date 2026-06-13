package ASTFlask.AtomExpression;

public class NoneExpression extends ExpressionAtom{
    public NoneExpression(int line) {
        super("NoneExpr", line);
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ")";
    }
}
