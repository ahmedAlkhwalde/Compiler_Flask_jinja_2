package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JinjaSymbol extends Symbol {


    public enum JinjaType {
        EXPRESSION,
        STATEMENT,
        COMMENT,
        BLOCK,
        MACRO,
        INCLUDE,
        EXTENDS,
        IMPORT,
        IF,
        FOR,
        SET,
        WITH
    }

    public JinjaType jinjaType;
    public String content;
    public Map<String, Object> context;
    public List<JinjaSymbol> nestedSymbols;
    public HtmlElementSymbol parentElement;
    public boolean isControlStructure;
    public boolean hasFilters;


    public JinjaSymbol(JinjaType type, String content, int line, int column) {
        super(generateName(type), "JINJA", line, column);
        this.jinjaType = type;
        this.content = content != null ? content : "";
        this.context = new HashMap<>();
        this.nestedSymbols = new ArrayList<>();
        this.parentElement = null;
        this.isControlStructure = determineIfControlStructure(type, content);
        this.hasFilters = determineIfHasFilters(type, content);
    }


    public static String generateName(JinjaType type) {
        return "jinja_" + type.toString().toLowerCase();
    }


    public boolean determineIfControlStructure(JinjaType type, String content) {
        if (type != JinjaType.STATEMENT) {
            return false;
        }

        if (content == null) {
            return false;
        }

        String lowerContent = content.toLowerCase().trim();
        return lowerContent.startsWith("if ") ||
                lowerContent.startsWith("for ") ||
                lowerContent.startsWith("set ") ||
                lowerContent.startsWith("with ") ||
                lowerContent.startsWith("block ") ||
                lowerContent.startsWith("macro ");
    }


    public boolean determineIfHasFilters(JinjaType type, String content) {
        if (type != JinjaType.EXPRESSION || content == null) {
            return false;
        }
        return content.contains("|");
    }


    public JinjaType getJinjaType() {
        return jinjaType;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content != null ? content : "";
        this.isControlStructure = determineIfControlStructure(jinjaType, this.content);
        this.hasFilters = determineIfHasFilters(jinjaType, this.content);
    }

    public HtmlElementSymbol getParentElement() {
        return parentElement;
    }

    public void setParentElement(HtmlElementSymbol parentElement) {
        this.parentElement = parentElement;
    }

    public boolean isControlStructure() {
        return isControlStructure;
    }

    public boolean isComment() {
        return jinjaType == JinjaType.COMMENT;
    }


    public boolean isStatement() {
        return jinjaType == JinjaType.STATEMENT;
    }

    public boolean isSetStatement() {
        return jinjaType == JinjaType.STATEMENT &&
                content.toLowerCase().trim().startsWith("set ");
    }

    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jinja2 ").append(jinjaType).append("\n");
        sb.append("  Content: ").append(content).append("\n");
        sb.append("  Line: ").append(getLine()).append(", Column: ").append(getColumn()).append("\n");
        sb.append("  Control Structure: ").append(isControlStructure).append("\n");
        sb.append("  Has Filters: ").append(hasFilters).append("\n");
        sb.append("  Context variables: ").append(context.size()).append("\n");
        sb.append("  Nested symbols: ").append(nestedSymbols.size()).append("\n");

        if (!context.isEmpty()) {
            sb.append("  Context:\n");
            for (Map.Entry<String, Object> entry : context.entrySet()) {
                sb.append("    • ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }

        if (parentElement != null) {
            sb.append("  Parent element: <").append(parentElement.getName()).append(">\n");
        }

        if (!nestedSymbols.isEmpty()) {
            sb.append("  Nested symbols preview:\n");
            for (int i = 0; i < Math.min(nestedSymbols.size(), 3); i++) {
                sb.append("    • ").append(nestedSymbols.get(i).getContent())
                        .append(" [").append(nestedSymbols.get(i).getJinjaType()).append("]\n");
            }
            if (nestedSymbols.size() > 3) {
                sb.append("    ... and ").append(nestedSymbols.size() - 3).append(" more\n");
            }
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        String typeStr = jinjaType.name().substring(0, Math.min(4, jinjaType.name().length()));
        String contentPreview = content.length() > 30 ?
                content.substring(0, 27) + "..." : content;

        return String.format("{%s: %s} [%s] line:%d",
                typeStr, contentPreview, getName(), getLine());
    }


    public Map<String, Object> toJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("type", jinjaType.name());
        json.put("name", getName());
        json.put("content", content);
        json.put("line", getLine());
        json.put("column", getColumn());
        json.put("isControlStructure", isControlStructure);
        json.put("hasFilters", hasFilters);
        json.put("contextSize", context.size());
        json.put("nestedSymbolsCount", nestedSymbols.size());

        if (parentElement != null) {
            json.put("parentElement", parentElement.getName());
        }

        List<String> nestedNames = new ArrayList<>();
        for (JinjaSymbol symbol : nestedSymbols) {
            nestedNames.add(symbol.getName() + " [" + symbol.getJinjaType() + "]");
        }
        json.put("nestedSymbols", nestedNames);

        return json;
    }



}