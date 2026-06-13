package ASTFlask.TheMainContintOfSimpleStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

public class ExpressionStatment extends Statment {
    public ExpressionAtom value;

    public ExpressionStatment(String nodeName, int line) {
        super(nodeName, line);
    }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", value=" + value + ")";
    }
}
