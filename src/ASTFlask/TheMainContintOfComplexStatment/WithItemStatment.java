package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.StatmentRoot;

public class WithItemStatment extends StatmentRoot {
    public ExpressionAtom contextExpr;
    public ExpressionAtom optionalVar;

    public WithItemStatment(ExpressionAtom contextExpr, ExpressionAtom optionalVar, int line) {
        super("WithItem", line);
        this.contextExpr = contextExpr;
        this.optionalVar = optionalVar;
    }

    @Override
    public String toString() {
        return "WithItem(line=" + line +
                ", context=" + contextExpr +
                ", var=" + optionalVar + ")";
    }
}
