package ASTFlask.AtomExpression;
public class ThreeConditionExprssion extends ExpressionAtom {
    public ExpressionAtom thenExpr;
    public ExpressionAtom condExpr;
    public ExpressionAtom elseExpr;

    public ThreeConditionExprssion(ExpressionAtom thenExpr, ExpressionAtom condExpr, ExpressionAtom elseExpr, int line) {
        super("TernaryExpr", line);
        this.thenExpr = thenExpr;
        this.condExpr = condExpr;
        this.elseExpr = elseExpr;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", then=" + thenExpr + ", cond=" + condExpr + ", else=" + elseExpr + ")";
    }
}
