package ASTFlask.TheMainExpressionStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.TheMainContintOfSimpleStatment.ExpressionStatment;

public class Testlist_Start_ExpressionEqual extends ExpressionStatment {
    public ExpressionAtom target;
    public ExpressionAtom value;

    public Testlist_Start_ExpressionEqual(ExpressionAtom target, ExpressionAtom value, int line) {
        super("AssignStmt", line);
        this.target = target;
        this.value = value;
    }

    public void setTarget(ExpressionAtom target) {
        this.target = target;
    }

    public void setValue(ExpressionAtom value) {
        this.value = value;
        super.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", target=" + target + ", value=" + value + ")";
    }
}
