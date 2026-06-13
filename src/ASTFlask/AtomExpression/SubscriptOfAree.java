package ASTFlask.AtomExpression;

public class SubscriptOfAree extends ExpressionAtom{
    public ExpressionAtom value;
    public SliceTowSubscriptOfAree slice;

    public SubscriptOfAree(ExpressionAtom value, SliceTowSubscriptOfAree slice, int line) {
        super("SubscriptExpr", line);
        this.value = value;
        this.slice = slice;
    }

    public void setValue(ExpressionAtom value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", value=" + value + ", slice=" + slice + ")";
    }
}
