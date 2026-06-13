package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class WhileStatment extends Statment {

    public ExpressionAtom condition;
    public List<Statment> body;
    public List<Statment> elseBody;

    public WhileStatment(ExpressionAtom condition, List<Statment> body, List<Statment> elseBody, int line) {
        super("WhileStmt", line);
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }


    @Override
    public String toString() {
        return "WhileStmt(line=" + line +
                ", condition=" + condition +
                ", body=" + body +
                ", elseBody=" + elseBody + ")";
    }
}
