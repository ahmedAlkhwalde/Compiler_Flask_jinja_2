package ASTFlask.AtomExpression;

import java.util.List;

public class TupleExprssion extends ExpressionAtom{

    public List<ExpressionAtom> items;

    public TupleExprssion(List<ExpressionAtom> items, int line) {
        super("TupleExpr", line);
        this.items = items;
    }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", items=" + items + ")";
    }
}