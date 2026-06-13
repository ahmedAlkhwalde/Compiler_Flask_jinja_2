package ASTFlask.TheMainExpressionStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.TheMainContintOfSimpleStatment.ExpressionStatment;

public class Testlist_star_expr extends ExpressionStatment {
    public ExpressionAtom expr;

    public Testlist_star_expr(ExpressionAtom expr, int line) {
        super("ExprOnlyStmt", line);
        this.expr = expr;
        this.value = expr;
    }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", expr=" + expr + ")";
    }
}
