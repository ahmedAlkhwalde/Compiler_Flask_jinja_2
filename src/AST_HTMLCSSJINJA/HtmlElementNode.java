package AST_HTMLCSSJINJA;

public class HtmlElementNode extends ASTNode {
    private String tagName;
    private ElementType elementType;

    public enum ElementType {
        NORMAL, SELF_CLOSING, HEAD, BODY, HTML
    }

    public HtmlElementNode(int lineNumber, String tagName, ElementType elementType) {
        super(lineNumber);
        this.tagName = tagName;
        this.elementType = elementType;
    }

    public String getTagName() {
        return tagName;
    }

    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public String getNodeName() {
        return "HtmlElementNode[" + elementType + "]";
    }

    @Override
    public String getAdditionalInfo() {
        return "<" + tagName + ">";
    }
}