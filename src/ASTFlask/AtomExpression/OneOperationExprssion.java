package ASTFlask.AtomExpression;
public class OneOperationExprssion extends ExpressionAtom{
    public String op;
    public ExpressionAtom expr;

    public OneOperationExprssion(String op, ExpressionAtom expr, int line) {
        super("UnaryExpr", line);
        this.op = op;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", op=" + op + ", expr=" + expr + ")";
    }
}
