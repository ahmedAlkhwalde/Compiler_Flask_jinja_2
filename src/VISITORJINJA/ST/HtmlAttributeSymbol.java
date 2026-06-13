package VISITORJINJA.ST;

import java.util.HashMap;
import java.util.Map;


public class HtmlAttributeSymbol extends Symbol {


    public enum AttributeType {
        GLOBAL,
        EVENT,
        FORM,
        MEDIA,
        LINK,
        META,
        BOOLEAN,
        CUSTOM,
        DATA,
        ARIA
    }


    private AttributeType attributeType;
    private String value;
    private boolean hasValue;
    private HtmlElementSymbol parentElement;
    private Map<String, Object> metadata;


    public HtmlAttributeSymbol(String name, AttributeType type,
                               String value, boolean hasValue,
                               int line, int column) {
        super(name, "HTML_ATTRIBUTE", line, column);
        this.attributeType = type;
        this.value = value;
        this.hasValue = hasValue;
        this.parentElement = null;
        this.metadata = new HashMap<>();
        initializeMetadata();
    }


    public HtmlAttributeSymbol(String name, AttributeType type,
                               int line, int column) {
        this(name, type, null, false, line, column);
    }





    public AttributeType getAttributeType() {
        return attributeType;
    }



    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
        this.hasValue = true;
        initializeMetadata();
    }



    public HtmlElementSymbol getParentElement() {
        return parentElement;
    }


    public void setParentElement(HtmlElementSymbol parentElement) {
        this.parentElement = parentElement;
    }




    public void setMetadata(String key, Object value) {
        metadata.put(key, value);
    }

    private void initializeMetadata() {
        metadata.put("isBooleanAttribute", !hasValue);
        metadata.put("isCustomAttribute", attributeType == AttributeType.CUSTOM);
        metadata.put("isDataAttribute", name != null && name.startsWith("data-"));
        metadata.put("isAriaAttribute", name != null && name.startsWith("aria-"));
        metadata.put("isEventAttribute", name != null && name.startsWith("on"));

        if (hasValue && value != null) {
            metadata.put("valueLength", value.length());
            metadata.put("hasQuotes",
                    (value.startsWith("\"") && value.endsWith("\"")) ||
                            (value.startsWith("'") && value.endsWith("'")));
        }
    }


    public String getValueWithoutQuotes() {
        if (value == null || value.isEmpty()) {
            return "";
        }


        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        if (value.startsWith("'") && value.endsWith("'")) {
            return value.substring(1, value.length() - 1);
        }

        return value;
    }


    public String[] getValueAsArray() {
        String cleanValue = getValueWithoutQuotes();
        if (cleanValue.isEmpty()) {
            return new String[0];
        }


        return cleanValue.split("\\s+");
    }


    public boolean isBooleanAttribute() {
        return Boolean.TRUE.equals(metadata.get("isBooleanAttribute"));
    }

    public boolean isCustomAttribute() {
        return Boolean.TRUE.equals(metadata.get("isCustomAttribute"));
    }

    public boolean isDataAttribute() {
        return Boolean.TRUE.equals(metadata.get("isDataAttribute"));
    }


    public boolean isAriaAttribute() {
        return Boolean.TRUE.equals(metadata.get("isAriaAttribute"));
    }


    public boolean isEventAttribute() {
        return Boolean.TRUE.equals(metadata.get("isEventAttribute"));
    }


    public boolean hasQuotes() {
        return Boolean.TRUE.equals(metadata.get("hasQuotes"));
    }


    public int getValueLength() {
        Integer length = (Integer) metadata.get("valueLength");
        return length != null ? length : 0;
    }


    public boolean containsJinjaExpression() {
        if (value == null) return false;
        return value.contains("{{") || value.contains("{%");
    }


    public boolean containsCss() {
        if (!name.equals("style")) return false;
        if (value == null) return false;
        return value.contains(":") || value.contains(";");
    }


    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);

        if (hasValue && value != null) {
            String valueDisplay = value;
            if (value.length() > 50) {
                valueDisplay = value.substring(0, 47) + "...";
            }
            sb.append("=\"").append(valueDisplay).append("\"");
        } else {
            sb.append(" (boolean)");
        }

        sb.append(" [").append(attributeType).append("]");
        sb.append(" line:").append(line).append(", col:").append(column);


        if (isDataAttribute()) {
            sb.append(" [data-*]");
        } else if (isAriaAttribute()) {
            sb.append(" [aria-*]");
        } else if (isEventAttribute()) {
            sb.append(" [event]");
        }

        if (parentElement != null) {
            sb.append(" on <").append(parentElement.name).append(">");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        if (hasValue && value != null) {
            String shortValue = value.length() > 20 ?
                    value.substring(0, 17) + "..." : value;
            return String.format("%s=\"%s\"", name, shortValue);
        } else {
            return name;
        }
    }


    public Map<String, Object> toJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("name", name);
        json.put("type", attributeType.name());
        json.put("line", line);
        json.put("column", column);
        json.put("hasValue", hasValue);

        if (hasValue && value != null) {
            json.put("value", value);
            json.put("valueWithoutQuotes", getValueWithoutQuotes());
            json.put("valueLength", getValueLength());
        }

        json.put("isBoolean", isBooleanAttribute());
        json.put("isCustom", isCustomAttribute());
        json.put("isDataAttribute", isDataAttribute());
        json.put("isAriaAttribute", isAriaAttribute());
        json.put("isEventAttribute", isEventAttribute());
        json.put("containsJinja", containsJinjaExpression());
        json.put("containsCss", containsCss());

        if (parentElement != null) {
            json.put("parentElement", parentElement.name);
        }

        return json;
    }




    public static AttributeType inferAttributeType(String attributeName) {
        if (attributeName == null) return AttributeType.CUSTOM;

        String attrLower = attributeName.toLowerCase();


        if (attrLower.equals("id") || attrLower.equals("class") ||
                attrLower.equals("style") || attrLower.equals("title") ||
                attrLower.equals("lang") || attrLower.equals("dir") ||
                attrLower.equals("tabindex") || attrLower.equals("accesskey") ||
                attrLower.equals("translate") || attrLower.equals("contenteditable") ||
                attrLower.equals("draggable")) {
            return AttributeType.GLOBAL;
        }


        if (attrLower.startsWith("on")) {
            return AttributeType.EVENT;
        }


        if (attrLower.equals("name") || attrLower.equals("value") ||
                attrLower.equals("placeholder") || attrLower.equals("required") ||
                attrLower.equals("readonly") || attrLower.equals("disabled") ||
                attrLower.equals("checked") || attrLower.equals("max") ||
                attrLower.equals("min") || attrLower.equals("step") ||
                attrLower.equals("pattern") || attrLower.equals("maxlength") ||
                attrLower.equals("minlength") || attrLower.equals("accept") ||
                attrLower.equals("autocomplete") || attrLower.equals("size") ||
                attrLower.equals("multiple") || attrLower.equals("selected") ||
                attrLower.equals("rows") || attrLower.equals("cols") ||
                attrLower.equals("autofocus") || attrLower.equals("form")) {
            return AttributeType.FORM;
        }

        // سمات الوسائط
        if (attrLower.equals("src") || attrLower.equals("alt") ||
                attrLower.equals("width") || attrLower.equals("height") ||
                attrLower.equals("controls") || attrLower.equals("autoplay") ||
                attrLower.equals("loop") || attrLower.equals("muted") ||
                attrLower.equals("poster") || attrLower.equals("preload") ||
                attrLower.equals("playsinline") || attrLower.equals("crossorigin")) {
            return AttributeType.MEDIA;
        }


        if (attrLower.equals("href") || attrLower.equals("target") ||
                attrLower.equals("rel") || attrLower.equals("download") ||
                attrLower.equals("hreflang") || attrLower.equals("type") ||
                attrLower.equals("referrerpolicy")) {
            return AttributeType.LINK;
        }

        if (attrLower.equals("charset") || attrLower.equals("content") ||
                attrLower.equals("http-equiv") || attrLower.equals("property") ||
                attrLower.equals("name") || attrLower.equals("scheme")) {
            return AttributeType.META;
        }

        if (attrLower.equals("hidden") || attrLower.equals("disabled") ||
                attrLower.equals("checked") || attrLower.equals("readonly") ||
                attrLower.equals("required") || attrLower.equals("multiple") ||
                attrLower.equals("selected") || attrLower.equals("autofocus") ||
                attrLower.equals("novalidate") || attrLower.equals("formnovalidate") ||
                attrLower.equals("open") || attrLower.equals("reversed") ||
                attrLower.equals("allowfullscreen") || attrLower.equals("async") ||
                attrLower.equals("defer") || attrLower.equals("ismap") ||
                attrLower.equals("nomodule") || attrLower.equals("playsinline")) {
            return AttributeType.BOOLEAN;
        }

        if (attrLower.startsWith("data-")) {
            return AttributeType.DATA;
        }

        if (attrLower.startsWith("aria-")) {
            return AttributeType.ARIA;
        }

        return AttributeType.CUSTOM;
    }





    }
