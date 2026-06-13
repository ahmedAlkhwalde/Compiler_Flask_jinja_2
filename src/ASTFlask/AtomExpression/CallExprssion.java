package ASTFlask.AtomExpression;

import java.util.List;

public class CallExprssion extends ExpressionAtom{

    public ExpressionAtom function;
    public List<ExpressionAtom> args;

    public CallExprssion(ExpressionAtom function, List<ExpressionAtom> args, int line) {
        super("CallExpr", line);
        this.function = function;
        this.args = args;
    }



    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", function=" + function + ", args=" + args + ")";
    }
}
