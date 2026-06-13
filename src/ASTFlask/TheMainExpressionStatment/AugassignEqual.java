package ASTFlask.TheMainExpressionStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.TheMainContintOfSimpleStatment.ExpressionStatment;

public class AugassignEqual extends ExpressionStatment {
    public ExpressionAtom target;
    public String operator;
    public ExpressionAtom value;

    public AugassignEqual(ExpressionAtom target, String operator, ExpressionAtom value, int line) {
        super("AugAssignStmt", line);
        this.target = target;
        this.operator = operator;
        this.value = value;
    }


    public void setValue(ExpressionAtom value) {
        this.value = value;
        super.value = value;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", target=" + target + ", operator=" + operator + ", value=" + value + ")";
    }
}
