package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.StatmentRoot;

import java.util.List;

public class DecoratorOfFunction extends StatmentRoot {

    public ExpressionAtom name;
    public List<ExpressionAtom> args;

    public DecoratorOfFunction(ExpressionAtom name, List<ExpressionAtom> args, int line) {
        super("Decorator", line);
        this.name = name;
        this.args = args;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", name=" + name + ", args=" + args + ")";
    }
}
