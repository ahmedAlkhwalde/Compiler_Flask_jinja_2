package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HtmlElementSymbol extends Symbol {

    public enum ElementCategory {
        STRUCTURAL,
        HEADING,
        TEXT,
        LIST,
        TABLE,
        FORM,
        MEDIA,
        SEMANTIC,
        SELF_CLOSING
    }


    private ElementCategory category;
    private Map<String, HtmlAttributeSymbol> attributes;
    private List<HtmlElementSymbol> children;
    private HtmlElementSymbol parent;
    private boolean hasClosingTag;
    private String innerText;
    private boolean isInJinjaContext;


    public HtmlElementSymbol(String tagName, ElementCategory category,
                             int line, int column, boolean hasClosingTag) {
        super(tagName, "HTML_ELEMENT", line, column);
        this.category = category;
        this.hasClosingTag = hasClosingTag;
        this.attributes = new HashMap<>();
        this.children = new ArrayList<>();
        this.parent = null;
        this.innerText = "";
        this.isInJinjaContext = false;
    }


    public void addAttribute(HtmlAttributeSymbol attribute) {
        if (attribute != null) {
            attributes.put(attribute.name, attribute);
            attribute.setParentElement(this);
        }
    }


    public HtmlAttributeSymbol getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }


    public boolean hasAttribute(String attributeName) {
        return attributes.containsKey(attributeName);
    }



    public void setParent(HtmlElementSymbol parent) {
        this.parent = parent;
    }


    public HtmlElementSymbol getParent() {
        return parent;
    }


    public void setInJinjaContext(boolean inJinja) {
        this.isInJinjaContext = inJinja;
    }


    public List<HtmlElementSymbol> getAncestors() {
        List<HtmlElementSymbol> ancestors = new ArrayList<>();
        HtmlElementSymbol current = this.parent;
        while (current != null) {
            ancestors.add(current);
            current = current.getParent();
        }
        return ancestors;
    }


    public List<HtmlElementSymbol> getChildren() {
        return new ArrayList<>(children);
    }


    public Map<String, HtmlAttributeSymbol> getAttributes() {
        return new HashMap<>(attributes);
    }


    public String getId() {
        HtmlAttributeSymbol idAttr = getAttribute("id");
        return idAttr != null ? idAttr.getValueWithoutQuotes() : null;
    }


    public List<String> getClasses() {
        HtmlAttributeSymbol classAttr = getAttribute("class");
        if (classAttr != null) {
            String classValue = classAttr.getValueWithoutQuotes();
            if (classValue != null && !classValue.isEmpty()) {
                String[] classes = classValue.split("\\s+");
                List<String> result = new ArrayList<>();
                for (String cls : classes) {
                    if (!cls.trim().isEmpty()) {
                        result.add(cls.trim());
                    }
                }
                return result;
            }
        }
        return new ArrayList<>();
    }


    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTML Element: <").append(name).append(">\n");
        sb.append("  Category: ").append(category).append("\n");
        sb.append("  Line: ").append(line).append(", Column: ").append(column).append("\n");
        sb.append("  Has closing tag: ").append(hasClosingTag).append("\n");
        sb.append("  In Jinja context: ").append(isInJinjaContext).append("\n");
        sb.append("  Attributes: ").append(attributes.size()).append("\n");
        sb.append("  Children: ").append(children.size()).append("\n");

        if (!innerText.isEmpty()) {
            String textPreview = innerText.length() > 50 ?
                    innerText.substring(0, 47) + "..." : innerText;
            sb.append("  Inner text: \"").append(textPreview).append("\"\n");
        }

        if (!attributes.isEmpty()) {
            sb.append("  Attribute list:\n");
            for (HtmlAttributeSymbol attr : attributes.values()) {
                sb.append("    • ").append(attr.getDetailedInfo()).append("\n");
            }
        }

        if (!children.isEmpty()) {
            sb.append("  Children tags: ");
            for (int i = 0; i < Math.min(children.size(), 5); i++) {
                sb.append("<").append(children.get(i).name).append(">");
                if (i < Math.min(children.size(), 5) - 1) {
                    sb.append(", ");
                }
            }
            if (children.size() > 5) {
                sb.append(" ... and ").append(children.size() - 5).append(" more");
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        String closing = hasClosingTag ? ">" : "/>";
        String categoryStr = category.name().substring(0, Math.min(3, category.name().length()));
        return String.format("<%s%s [%s] line:%d", name, closing, categoryStr, line);
    }


    public static ElementCategory getCategoryFromTag(String tagName) {
        if (tagName == null) return ElementCategory.STRUCTURAL;

        switch (tagName.toLowerCase()) {
            case "h1": case "h2": case "h3": case "h4": case "h5": case "h6":
                return ElementCategory.HEADING;
            case "p": case "span": case "strong": case "b": case "i": case "em":
            case "u": case "small": case "mark": case "sub": case "sup":
            case "blockquote": case "code": case "pre":
                return ElementCategory.TEXT;
            case "ul": case "ol": case "li": case "dl": case "dt": case "dd":
                return ElementCategory.LIST;
            case "table": case "tr": case "td": case "th": case "thead":
            case "tbody": case "tfoot": case "caption": case "colgroup":
                return ElementCategory.TABLE;
            case "form": case "input": case "button": case "select":
            case "option": case "textarea": case "label": case "datalist":
            case "fieldset": case "legend": case "optgroup":
                return ElementCategory.FORM;
            case "img": case "audio": case "video": case "canvas":
            case "svg": case "picture":
                return ElementCategory.MEDIA;
            case "header": case "footer": case "nav": case "article":
            case "aside": case "section": case "main": case "figure":
            case "figcaption": case "details": case "summary": case "dialog":
                return ElementCategory.SEMANTIC;
            case "br": case "hr": case "meta": case "link":
            case "wbr": case "area": case "base": case "col": case "embed":
            case "param": case "source": case "track":
                return ElementCategory.SELF_CLOSING;
            case "html": case "head": case "body": case "div":
                return ElementCategory.STRUCTURAL;
            default:
                return ElementCategory.STRUCTURAL;
        }
    }


    public static boolean isSelfClosingTag(String tagName) {
        if (tagName == null) return false;

        switch (tagName.toLowerCase()) {
            case "br": case "hr": case "img": case "meta": case "link":
            case "input": case "area": case "base": case "col": case "embed":
            case "param": case "source": case "track": case "wbr":
                return true;
            default:
                return false;
        }
    }


  
    public ElementCategory getCategory() {
        return this.category;
    }
}