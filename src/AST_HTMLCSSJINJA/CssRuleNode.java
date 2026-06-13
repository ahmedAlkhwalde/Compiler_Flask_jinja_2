package AST_HTMLCSSJINJA;

public class CssRuleNode extends ASTNode {
    private String property;
    private String value;
    private RuleType ruleType;

    public enum RuleType {
        COLOR,
        LENGTH,
        URL,
        SHORTHAND,
        TEXT,
        EFFECT,
        LAYOUT,
        FONT,
        BORDER_STYLE,
        BORDER_WIDTH,
        BORDER,
        REPEAT,
        POSITION,
        OFFSET
    }

    public CssRuleNode(int lineNumber, String property, String value, RuleType ruleType) {
        super(lineNumber);
        this.property = property;
        this.value = value;
        this.ruleType = ruleType;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    @Override
    public String getNodeName() {
        return "CssRuleNode[" + ruleType + "]";
    }

    @Override
    public String getAdditionalInfo() {
        return property + ": " + value + ";";
    }
}