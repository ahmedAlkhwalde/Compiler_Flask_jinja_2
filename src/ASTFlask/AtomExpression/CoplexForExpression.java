package ASTFlask.AtomExpression;

import ASTFlask.StatmentRoot;

import java.util.ArrayList;
import java.util.List;

public class CoplexForExpression extends StatmentRoot {

    public ExpressionAtom target;
    public ExpressionAtom iterable;
    public List<ExpressionAtom> conditions;

    public CoplexForExpression(ExpressionAtom target, ExpressionAtom iterable, List<ExpressionAtom> conditions, int line) {
        super("ComprehensionFor", line);
        this.target = target;
        this.iterable = iterable;
        this.conditions = conditions;
    }

    public void addCondition(ExpressionAtom condition) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<>();
        }
        this.conditions.add(condition);
    }


    @Override
    public String toString() {
        return "ComprehensionFor(line=" + line +
                ", target=" + target +
                ", iterable=" + iterable +
                ", conditions=" + conditions + ")";
    }
}
