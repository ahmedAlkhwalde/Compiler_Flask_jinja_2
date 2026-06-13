package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class IfStatment extends Statment {

    public ExpressionAtom condition;
    public List<Statment> body;
    public List<ElifStatment> elifs;
    public List<Statment> elseBody;

    public IfStatment(ExpressionAtom condition, List<Statment> body, List<ElifStatment> elifs, List<Statment> elseBody, int line) {
        super("IfStmt", line);
        this.condition = condition;
        this.body = body;
        this.elifs = elifs;
        this.elseBody = elseBody;
    }


    @Override
    public String toString() {
        return "IfStmt(line=" + line +
                ", condition=" + condition +
                ", body=" + body +
                ", elifs=" + elifs +
                ", elseBody=" + elseBody + ")";
    }
}
