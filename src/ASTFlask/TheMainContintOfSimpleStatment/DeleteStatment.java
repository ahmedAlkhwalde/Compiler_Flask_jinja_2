package ASTFlask.TheMainContintOfSimpleStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class DeleteStatment extends Statment {
    public List<ExpressionAtom> elementsTdelete;

    public DeleteStatment(List<ExpressionAtom> elementsTdelete, int line) {
        super("DelStmt", line);
        this.elementsTdelete = elementsTdelete;
    }

    @Override
    public String toString() {
        return "DelStmt(line=" + line + ", targets=" + elementsTdelete + ")";
    }
}
