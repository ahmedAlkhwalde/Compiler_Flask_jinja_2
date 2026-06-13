package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class FounctionStatment extends Statment {

    public String name;
    public List<ParametarToFunction> params;
    public ExpressionAtom returnType;
    public List<Statment> body;

    public FounctionStatment(String name, List<ParametarToFunction> params, ExpressionAtom returnType, List<Statment> body, int line) {
        super("FuncDef", line);
        this.name = name;
        this.params = params;
        this.returnType = returnType;
        this.body = body;
    }



    @Override
    public String toString() {
        return "FuncDef(line=" + line +
                ", name=" + name +
                ", params=" + params +
                ", returnType=" + returnType +
                ", body=" + body + ")";
    }
}
