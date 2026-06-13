package AST_HTMLCSSJINJA;

import java.util.ArrayList;
import java.util.List;

public class StyleAttributeNode extends AttributeNode {
    private List<CssRuleNode> cssRules;

    public StyleAttributeNode(int lineNumber) {
        super(lineNumber, "style", null, AttributeType.STYLE);
        this.cssRules = new ArrayList<>();
    }

    public void addCssRule(CssRuleNode rule) {
        cssRules.add(rule);
        this.addChild(rule);
    }

    public List<CssRuleNode> getCssRules() {
        return cssRules;
    }

    @Override
    public String getNodeName() {
        return "StyleAttributeNode";
    }

    @Override
    public String getAdditionalInfo() {
        return "style=\"" + cssRules.size() + " rules\"";
    }
}