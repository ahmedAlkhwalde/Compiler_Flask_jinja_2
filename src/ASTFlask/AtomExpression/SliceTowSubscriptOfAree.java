package ASTFlask.AtomExpression;

import ASTFlask.StatmentRoot;

public class SliceTowSubscriptOfAree extends StatmentRoot {
    public ExpressionAtom start;
    public ExpressionAtom end;
    public ExpressionAtom step;

    public SliceTowSubscriptOfAree(ExpressionAtom start, ExpressionAtom end, ExpressionAtom step, int line) {
        super("Slice", line);
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Slice[");
        if (start != null) sb.append(start);
        sb.append(":");
        if (end != null) sb.append(end);
        if (step != null) sb.append(":").append(step);
        sb.append("]");
        return sb.toString();
    }
}
