package ASTFlask.AtomExpression;
import java.util.ArrayList;
import java.util.List;

public class ComplexListOfFor extends ExpressionAtom {
    public TypeOfFor_Complex type;
    public List<CoplexForExpression> forClauses;
    public ExpressionAtom body;
    public ExpressionAtom key;

    public ComplexListOfFor(TypeOfFor_Complex type, ExpressionAtom body,
                            List<CoplexForExpression> forClauses, int line) {
        super("Comprehension", line);
        this.type = type;
        this.body = body;
        this.forClauses = forClauses;
    }


    public void setKey(ExpressionAtom key) {
        this.key = key;
    }

    public void addForClause(CoplexForExpression clause) {
        if (this.forClauses == null) {
            this.forClauses = new ArrayList<>();
        }
        this.forClauses.add(clause);
    }


    @Override
    public String toString() {
        return "Comprehension(type=" + type +
                ", line=" + line +
                ", key=" + key +
                ", body=" + body +
                ", forClauses=" + forClauses + ")";
    }
}
