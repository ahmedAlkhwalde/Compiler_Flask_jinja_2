package ASTFlask.TheMainExpressionStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.TheMainContintOfSimpleStatment.ExpressionStatment;

public class AnnassignColon extends ExpressionStatment {
    public ExpressionAtom target;
    public ExpressionAtom value;

    public AnnassignColon(ExpressionAtom target, ExpressionAtom value, int line) {
        super("AnnAssignStmt", line);
        this.target = target;
        this.value = value;
        super.value = value;
    }

    public void setTarget(ExpressionAtom target) { this.target = target; }
    public void setValue(ExpressionAtom value) {
        this.value = value;
        super.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", target=" + target + ", value=" + value + ")";
    }
}
