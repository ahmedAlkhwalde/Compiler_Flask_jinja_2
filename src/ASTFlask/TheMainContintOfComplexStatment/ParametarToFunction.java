package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.StatmentRoot;

public class ParametarToFunction extends StatmentRoot {
    public String name;
    public ExpressionAtom type;
    public ExpressionAtom defaultValue;

    public ParametarToFunction(String name, ExpressionAtom type, ExpressionAtom defaultValue, int line) {
        super("Parameter", line);
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "Parameter(line=" + line +
                ", name=" + name +
                ", type=" + type +
                ", default=" + defaultValue + ")";
    }
}
