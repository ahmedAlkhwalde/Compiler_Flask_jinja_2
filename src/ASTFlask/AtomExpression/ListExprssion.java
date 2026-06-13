package ASTFlask.AtomExpression;

import java.util.ArrayList;
import java.util.List;

public class ListExprssion extends ExpressionAtom{

    public List<ExpressionAtom> items;

    public ListExprssion(List<ExpressionAtom> items, int line) {
        super("ListExpr", line);
        this.items = items;
    }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", items=" + items + ")";
    }
}
