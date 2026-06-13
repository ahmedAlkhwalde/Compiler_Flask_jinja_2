package AST_HTMLCSSJINJA;

public class TextNode extends ASTNode {
    private String text;
    private TextContext context;

    public enum TextContext {
        HTML,
        JINJA,
        CSS
    }

    public TextNode(int lineNumber, String text, TextContext context) {
        super(lineNumber);
        this.text = text;
        this.context = context;
    }

    public String getText() {
        return text;
    }

    public TextContext getContext() {
        return context;
    }

    @Override
    public String getNodeName() {
        return "TextNode[" + context + "]";
    }

    @Override
    public String getAdditionalInfo() {
        if (text.length() > 50) {
            return "\"" + text.substring(0, 47) + "...\"";
        }
        return "\"" + text + "\"";
    }
}