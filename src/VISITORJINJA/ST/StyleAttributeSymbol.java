package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyleAttributeSymbol extends HtmlAttributeSymbol {

    private List<CssRuleSymbol> cssRules;
    private Map<String, CssRuleSymbol> rulesByProperty;
    private boolean hasErrors;
    private List<String> cssErrors;


    public StyleAttributeSymbol(int line, int column) {
        super("style", AttributeType.GLOBAL, null, true, line, column);
        this.cssRules = new ArrayList<>();
        this.rulesByProperty = new HashMap<>();
        this.hasErrors = false;
        this.cssErrors = new ArrayList<>();

        setMetadata("isStyleAttribute", true);
        setMetadata("containsCss", true);
    }


    public List<CssRuleSymbol> getCssRules() {
        return new ArrayList<>(cssRules);
    }

    public void addCssRule(CssRuleSymbol rule) {
        if (rule != null && rule.isValid()) {
            cssRules.add(rule);
            rulesByProperty.put(rule.getProperty().toLowerCase(), rule);

            rule.setTargetElement(getParentElement());
            rule.setInline(true);

            updateStyleValue();
        }
    }


    private void updateStyleValue() {
        StringBuilder styleBuilder = new StringBuilder();

        for (int i = 0; i < cssRules.size(); i++) {
            CssRuleSymbol rule = cssRules.get(i);
            styleBuilder.append(rule.toCssString());

            if (i < cssRules.size() - 1) {
                styleBuilder.append(" ");
            }
        }

        setValue(styleBuilder.toString());
    }


    public int getRuleCount() {
        return cssRules.size();
    }

    public boolean isEffective() {
        return !cssRules.isEmpty() && !hasErrors;
    }


    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Style Attribute\n");
        sb.append("  Line: ").append(getLine()).append(", Column: ").append(getColumn()).append("\n");
        sb.append("  CSS Rules: ").append(cssRules.size()).append("\n");
        sb.append("  Has Errors: ").append(hasErrors).append("\n");
        sb.append("  Effective: ").append(isEffective()).append("\n");

        if (getParentElement() != null) {
            sb.append("  On element: <").append(getParentElement().getName()).append(">\n");
        }

        if (!cssRules.isEmpty()) {
            sb.append("  CSS Rules Details:\n");
            for (CssRuleSymbol rule : cssRules) {
                sb.append("    • ").append(rule.toString()).append("\n");
            }
        }

        if (hasErrors && !cssErrors.isEmpty()) {
            sb.append("  CSS Errors:\n");
            for (String error : cssErrors) {
                sb.append("    • ").append(error).append("\n");
            }
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        String rulesInfo = cssRules.size() + " rule" + (cssRules.size() != 1 ? "s" : "");
        String errorInfo = hasErrors ? " (has errors)" : "";
        return String.format("style=\"%s\" [%s%s]",
                getValueWithoutQuotes(), rulesInfo, errorInfo);
    }

}