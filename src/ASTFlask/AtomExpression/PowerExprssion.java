package ASTFlask.AtomExpression;

public class PowerExprssion extends ExpressionAtom{
    public ExpressionAtom base;
    public ExpressionAtom exponent;

    public PowerExprssion(ExpressionAtom base, ExpressionAtom exponent, int line) {
        super("PowerExpr", line);
        this.base = base;
        this.exponent = exponent;
    }

    public void setBase(ExpressionAtom base) { this.base = base; }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", base=" + base + ", exponent=" + exponent + ")";
    }
}