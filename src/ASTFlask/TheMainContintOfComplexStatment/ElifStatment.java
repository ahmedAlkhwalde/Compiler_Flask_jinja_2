package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class ElifStatment extends Statment {

    public ExpressionAtom condition;
    public List<Statment> body;

    public ElifStatment(ExpressionAtom condition, List<Statment> body, int line) {
        super("ElifPart", line);
        this.condition = condition;
        this.body = body;
    }


    @Override
    public String toString() {
        return "ElifPart(line=" + line +
                ", condition=" + condition +
                ", body=" + body + ")";
    }
}
