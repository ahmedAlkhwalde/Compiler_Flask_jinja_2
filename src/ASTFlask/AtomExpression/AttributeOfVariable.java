package ASTFlask.AtomExpression;
//a.b
public class AttributeOfVariable extends ExpressionAtom{
    public ExpressionAtom object;
    public String property;

    public AttributeOfVariable(ExpressionAtom object, String property, int line) {
        super("AttributeExpr", line);
        this.object = object;
        this.property = property;
    }


    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", object=" + object + ", property=" + property + ")";
    }
}
