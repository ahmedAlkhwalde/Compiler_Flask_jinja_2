package ASTFlask.TheMainContintOfSimpleStatment;

import ASTFlask.AtomExpression.ExpressionAtom;

import java.util.ArrayList;
import java.util.List;

public class FlowReturn extends FlowStatment{
    public List<ExpressionAtom> values;

    public FlowReturn(List<ExpressionAtom> values, int line) {
        super("ReturnStmt", line);
        this.values = values;
    }

    @Override
    public String toString() {
        return "ReturnStmt(line=" + line + ", values=" + values + ")";
    }
}
