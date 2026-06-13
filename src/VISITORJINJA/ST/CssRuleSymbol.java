package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CssRuleSymbol extends Symbol {


    public enum RuleCategory {
        LAYOUT,
        BOX_MODEL,
        TYPOGRAPHY,
        COLOR,
        BORDER,
        EFFECT,
        ANIMATION,
        FLEX_GRID,
        BACKGROUND,
        LIST,
        TABLE,
        OTHER
    }

    private RuleCategory category;
    private String property;
    private List<String> values;
    private HtmlElementSymbol targetElement;
    private boolean isInline;
    private String specificity;
    private boolean isImportant;
    private Map<String, Object> metadata;


    public CssRuleSymbol(String property, RuleCategory category,
                         List<String> values, int line, int column) {
        super(property, "CSS_RULE", line, column);
        this.property = property;
        this.category = category;
        this.values = values != null ? new ArrayList<>(values) : new ArrayList<>();
        this.isInline = true; // افتراضيًا inline في سياق HTML+CSS+Jinja
        this.isImportant = false;
        this.metadata = new HashMap<>();
        this.specificity = "0,0,0,0";

        initializeMetadata();
        checkForImportant();
    }




    public String getProperty() {
        return property;
    }


    public void setProperty(String property) {
        this.property = property;
        initializeMetadata();
    }


    public RuleCategory getCategory() {
        return category;
    }


    public List<String> getValues() {
        return new ArrayList<>(values);
    }


    public void setValues(List<String> values) {
        this.values = values != null ? new ArrayList<>(values) : new ArrayList<>();
        checkForImportant();
        initializeMetadata();
    }




    public void setTargetElement(HtmlElementSymbol targetElement) {
        this.targetElement = targetElement;
    }





    public void setInline(boolean inline) {
        isInline = inline;
    }


    private void initializeMetadata() {
        metadata.put("isShorthand", isShorthandProperty(property));
        metadata.put("isVendorPrefixed", isVendorPrefixed(property));
        metadata.put("isCustomProperty", property.startsWith("--"));
        metadata.put("hasMultipleValues", values.size() > 1);


        if (!values.isEmpty()) {
            metadata.put("hasColorValue", hasColorValue());
            metadata.put("hasLengthValue", hasLengthValue());
            metadata.put("hasUrlValue", hasUrlValue());
            metadata.put("hasKeywordValue", hasKeywordValue());
            metadata.put("hasFunctionValue", hasFunctionValue());
        }
    }


    private void checkForImportant() {
        if (!values.isEmpty()) {
            String lastValue = values.get(values.size() - 1);
            if (lastValue != null && lastValue.trim().equalsIgnoreCase("!important")) {
                this.isImportant = true;
                // إزالة !important من القيم
                values.set(values.size() - 1,
                        lastValue.replace("!important", "").trim());
            }
        }
    }


    public String getValuesAsString() {
        return String.join(" ", values);
    }


    public boolean isShorthand() {
        return Boolean.TRUE.equals(metadata.get("isShorthand"));
    }


    public boolean isVendorPrefixed() {
        return Boolean.TRUE.equals(metadata.get("isVendorPrefixed"));
    }


    public boolean isCustomProperty() {
        return Boolean.TRUE.equals(metadata.get("isCustomProperty"));
    }



    public boolean hasColorValue() {
        if (Boolean.TRUE.equals(metadata.get("hasColorValue"))) {
            return true;
        }

        for (String value : values) {
            if (isColorValue(value)) {
                return true;
            }
        }
        return false;
    }


    public boolean hasLengthValue() {
        if (Boolean.TRUE.equals(metadata.get("hasLengthValue"))) {
            return true;
        }

        for (String value : values) {
            if (isLengthValue(value)) {
                return true;
            }
        }
        return false;
    }


    public boolean hasUrlValue() {
        if (Boolean.TRUE.equals(metadata.get("hasUrlValue"))) {
            return true;
        }

        for (String value : values) {
            if (isUrlValue(value)) {
                return true;
            }
        }
        return false;
    }


    public boolean hasKeywordValue() {
        return Boolean.TRUE.equals(metadata.get("hasKeywordValue"));
    }


    public boolean hasFunctionValue() {
        return Boolean.TRUE.equals(metadata.get("hasFunctionValue"));
    }


    public boolean isEmpty() {
        return values.isEmpty() ||
                (values.size() == 1 && values.get(0).trim().isEmpty());
    }


    public boolean isValid() {
        return !property.isEmpty() && !values.isEmpty() && !isEmpty();
    }


    public String toCssString() {
        StringBuilder sb = new StringBuilder();
        sb.append(property).append(": ").append(getValuesAsString());

        if (isImportant) {
            sb.append(" !important");
        }

        sb.append(";");
        return sb.toString();
    }


    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("CSS Rule: ").append(property).append("\n");
        sb.append("  Category: ").append(category).append("\n");
        sb.append("  Values: ").append(getValuesAsString()).append("\n");
        sb.append("  Line: ").append(line).append(", Column: ").append(column).append("\n");
        sb.append("  Type: ").append(isInline ? "inline" : "external").append("\n");
        sb.append("  Important: ").append(isImportant).append("\n");
        sb.append("  Specificity: ").append(specificity).append("\n");
        sb.append("  Valid: ").append(isValid()).append("\n");

        if (targetElement != null) {
            sb.append("  Target element: <").append(targetElement.name).append(">\n");
        }


        if (isShorthand()) {
            sb.append("  Note: Shorthand property\n");
        }
        if (isVendorPrefixed()) {
            sb.append("  Note: Vendor-prefixed property\n");
        }
        if (isCustomProperty()) {
            sb.append("  Note: CSS Custom Property\n");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        String importantStr = isImportant ? " !important" : "";
        String targetStr = targetElement != null ?
                " on <" + targetElement.name + ">" : "";
        return String.format("%s: %s%s%s [%s]",
                property, getValuesAsString(), importantStr, targetStr, category);
    }



    public static boolean isShorthandProperty(String property) {
        if (property == null) return false;

        String[] shorthandProperties = {
                "margin", "padding", "border", "background",
                "font", "list-style", "animation", "transition",
                "flex", "grid", "place", "inset"
        };

        String propLower = property.toLowerCase();
        for (String shorthand : shorthandProperties) {
            if (propLower.equals(shorthand) || propLower.startsWith(shorthand + "-")) {
                return true;
            }
        }
        return false;
    }


    public static boolean isVendorPrefixed(String property) {
        if (property == null) return false;
        return property.startsWith("-webkit-") ||
                property.startsWith("-moz-") ||
                property.startsWith("-ms-") ||
                property.startsWith("-o-");
    }


    public static boolean isColorValue(String value) {
        if (value == null) return false;

        if (value.equalsIgnoreCase("red") || value.equalsIgnoreCase("blue") ||
                value.equalsIgnoreCase("green") || value.equalsIgnoreCase("black") ||
                value.equalsIgnoreCase("white") || value.equalsIgnoreCase("transparent")) {
            return true;
        }

        if (value.matches("^#[0-9a-fA-F]{3,8}$")) {
            return true;
        }


        if (value.startsWith("rgb(") || value.startsWith("rgba(") ||
                value.startsWith("hsl(") || value.startsWith("hsla(")) {
            return true;
        }

        return false;
    }


    public static boolean isLengthValue(String value) {
        if (value == null) return false;


        return value.matches("^-?\\d+(\\.\\d+)?(px|em|rem|vh|vw|vmin|vmax|%|pt|cm|mm|in|pc)$") ||
                value.equals("0") || value.equals("auto");
    }


    public static boolean isUrlValue(String value) {
        if (value == null) return false;
        return value.startsWith("url(") ||
                (value.startsWith("\"") && value.contains("://")) ||
                (value.startsWith("'") && value.contains("://"));
    }
}