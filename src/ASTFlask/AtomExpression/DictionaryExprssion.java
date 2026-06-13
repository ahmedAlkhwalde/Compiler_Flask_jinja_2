package ASTFlask.AtomExpression;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExprssion extends ExpressionAtom{

    public List<ExpressionAtom> keys;
    public List<ExpressionAtom> values;

    public DictionaryExprssion(List<ExpressionAtom> keys, List<ExpressionAtom> values, int line) {
        super("DictExpr", line);
        this.keys = keys;
        this.values = values;
    }


    public void setValues(List<ExpressionAtom> values) { this.values = values; }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", keys=" + keys + ", values=" + values + ")";
    }
}
