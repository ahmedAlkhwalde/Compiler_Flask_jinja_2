package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.AtomExpression.ExpressionAtom;
import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class ClassStatment extends Statment {

    public String name;
    public List<ExpressionAtom> bases;
    public List<Statment> body;

    public ClassStatment(String name, List<ExpressionAtom> bases, List<Statment> body, int line) {
        super("ClassDef", line);
        this.name = name;
        this.bases = bases;
        this.body = body;
    }


    @Override
    public String toString() {
        return "ClassDef(line=" + line +
                ", name=" + name +
                ", bases=" + bases +
                ", body=" + body + ")";
    }
}
