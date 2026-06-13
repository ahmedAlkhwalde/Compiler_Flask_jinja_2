package ASTFlask.AtomExpression;


import java.util.List;

public class CompareExprssion extends ExpressionAtom{
    public ExpressionAtom left;
    public List<String> ops;
    public List<ExpressionAtom> rights;

    public CompareExprssion(ExpressionAtom left, List<String> ops, List<ExpressionAtom> rights, int line) {
        super("CompareExpr", line);
        this.left = left;
        this.ops = ops;
        this.rights = rights;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line +
                ", left=" + left +
                ", ops=" + ops +
                ", rights=" + rights +
                ")";
    }
}
