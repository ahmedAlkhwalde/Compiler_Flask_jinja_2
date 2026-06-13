package AST_HTMLCSSJINJA;

public class AttributeNode extends ASTNode {
    private String name;
    private String value;
    private AttributeType type;

    public enum AttributeType {
        NORMAL,
        STYLE,
        WITHOUT_VALUE,
        LANG
    }

    public AttributeNode(int lineNumber, String name, String value, AttributeType type) {
        super(lineNumber);
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public AttributeType getType() {
        return type;
    }

    @Override
    public String getNodeName() {
        return "AttributeNode[" + type + "]";
    }

    @Override
    public String getAdditionalInfo() {
        if (type == AttributeType.WITHOUT_VALUE) {
            return name;
        }
        return name + "=\"" + value + "\"";
    }
}