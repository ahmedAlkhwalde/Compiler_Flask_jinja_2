//package Generation_Flask_Jinja;
//
//
//import AST_HTMLCSSJINJA.*;
//import java.io.*;
//import java.util.List;
//
///**
// * مولد كود HTML/Jinja2 من AST
// * يقوم بتحويل الشجرة المجردة إلى قالب HTML صالح مع صيغة Jinja2
// */
//public class JinjaCodeGenerator {
//
//    private final StringBuilder code = new StringBuilder();
//    private int indentLevel = 0;
//
//    public JinjaCodeGenerator() {}
//
//    private void append(String text) {
//        code.append(text);
//    }
//
//    private void appendLine(String line) {
//        code.append(line).append("\n");
//    }
//
//    private void appendIndent() {
//        code.append("    ".repeat(indentLevel));
//    }
//
//    private void indent() { indentLevel++; }
//    private void dedent() { indentLevel--; }
//
//    public void generate(ASTNode root) {
//        if (root instanceof DocumentNode) {
//            generateDocument((DocumentNode) root);
//        } else {
//            generateNode(root);
//        }
//    }
//
//    private void generateDocument(DocumentNode document) {
//        for (ASTNode child : document.getChildren()) {
//            generateNode(child);
//        }
//    }
//
//    private void generateNode(ASTNode node) {
//        if (node == null) return;
//
//        if (node instanceof HtmlElementNode) {
//            generateHtmlElement((HtmlElementNode) node);
//        } else if (node instanceof JinjaBlockNode) {
//            generateJinjaBlock((JinjaBlockNode) node);
//        } else if (node instanceof JinjaNode) {
//            generateJinjaNode((JinjaNode) node);
//        } else if (node instanceof TextNode) {
//            generateText((TextNode) node);
//        } else if (node instanceof DoctypeNode) {
//            appendLine("<!DOCTYPE html>");
//        } else if (node instanceof StyleAttributeNode) {
//            // يتم التعامل معها داخل generateHtmlElement
//        } else if (node instanceof AttributeNode) {
//            // يتم التعامل معها داخل generateHtmlElement
//        } else if (node instanceof CssRuleNode) {
//            // يتم التعامل معها داخل generateHtmlElement
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد عناصر HTML
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateHtmlElement(HtmlElementNode element) {
//        // فتح الوسم
//        appendIndent();
//        append("<" + element.getTagName());
//
//        // إضافة السمات
//        for (ASTNode child : element.getChildren()) {
//            if (child instanceof AttributeNode) {
//                generateAttribute((AttributeNode) child);
//            } else if (child instanceof StyleAttributeNode) {
//                generateStyleAttribute((StyleAttributeNode) child);
//            }
//        }
//
//        if (element.getElementType() == HtmlElementNode.ElementType.SELF_CLOSING) {
//            append(" />\n");
//            return;
//        }
//
//        append(">\n");
//        indent();
//
//        // محتوى العنصر
//        for (ASTNode child : element.getChildren()) {
//            if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode)) {
//                generateNode(child);
//            }
//        }
//
//        dedent();
//        appendIndent();
//        append("</" + element.getTagName() + ">\n");
//    }
//
//    private void generateAttribute(AttributeNode attr) {
//        if (attr.getValue() != null && !attr.getValue().isEmpty()) {
//            append(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
//        } else if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE) {
//            append(" " + attr.getName());
//        }
//    }
//
//    private void generateStyleAttribute(StyleAttributeNode styleAttr) {
//        if (styleAttr.getCssRules().isEmpty()) return;
//
//        append(" style=\"");
//        for (int i = 0; i < styleAttr.getCssRules().size(); i++) {
//            CssRuleNode rule = styleAttr.getCssRules().get(i);
//            if (i > 0) append(" ");
//            append(rule.getProperty() + ": " + rule.getValue());
//            if (i < styleAttr.getCssRules().size() - 1) append("; ");
//        }
//        append("\"");
//    }
//
//    private void generateText(TextNode text) {
//        appendIndent();
//        append(text.getText());
//        append("\n");
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  توليد عناصر Jinja2
//    // ═══════════════════════════════════════════════════════════════════
//
//    private void generateJinjaBlock(JinjaBlockNode block) {
//        appendIndent();
//
//        if (block.getBlockType() == JinjaBlockNode.BlockType.IF) {
//            generateJinjaIfBlock(block);
//        } else if (block.getBlockType() == JinjaBlockNode.BlockType.FOR) {
//            generateJinjaForBlock(block);
//        }
//    }
//
//    private void generateJinjaIfBlock(JinjaBlockNode block) {
//        // الحصول على الشرط والمحتوى من ConditionBlock
//        // نظراً لأن ConditionBlock هي كلاس داخلي، نستخدم انعكاس أو نحصل من الأطفال
//
//        // طريقة مبسطة: نفحص الأطفال للعثور على الشروط
//        List<ASTNode> children = block.getChildren();
//        if (children.isEmpty()) return;
//
//        // أول شرط
//        append("{% if ... %}\n");
//        indent();
//        for (ASTNode child : children) {
//            generateNode(child);
//        }
//        dedent();
//        appendIndent();
//        append("{% endif %}\n");
//    }
//
//    private void generateJinjaForBlock(JinjaBlockNode block) {
//        List<ASTNode> children = block.getChildren();
//        if (children.isEmpty()) return;
//
//        append("{% for ... %}\n");
//        indent();
//        for (ASTNode child : children) {
//            generateNode(child);
//        }
//        dedent();
//        appendIndent();
//        append("{% endfor %}\n");
//    }
//
//    private void generateJinjaNode(JinjaNode jinjaNode) {
//        appendIndent();
//        if (jinjaNode.getNodeName().contains("EXPRESSION")) {
//            append("{{ " + jinjaNode.getContent() + " }}\n");
//        } else {
//            append("{% " + jinjaNode.getContent() + " %}\n");
//        }
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  دوال حفظ الملف
//    // ═══════════════════════════════════════════════════════════════════
//
//    public String getCode() {
//        return code.toString();
//    }
//
//    public void saveToFile(String path) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
//            writer.write(code.toString());
//        }
//        System.out.println("✅ تم إنشاء قالب Jinja2: " + path);
//    }
//
//    public void clear() {
//        code.setLength(0);
//        indentLevel = 0;
//    }
//}














package Generation_Flask_Jinja;

import AST_HTMLCSSJINJA.*;
import java.io.*;
import java.util.*;

/**
 * مولد كود HTML/Jinja2 المطور والمصلح لمشاكل الـ CSS والـ Style Attributes
 */
public class JinjaCodeGenerator {
    private final StringBuilder code = new StringBuilder();
    private int indentLevel = 0;

    public JinjaCodeGenerator() {}

    private void append(String text) {
        code.append(text);
    }

    private void appendIndent() {
        code.append("    ".repeat(indentLevel));
    }

    private void appendLine(String line) {
        appendIndent();
        code.append(line).append("\n");
    }

    private void indent() {
        indentLevel++;
    }

    private void dedent() {
        indentLevel--;
    }

    public void generate(ASTNode root) {
        if (root instanceof DocumentNode) {
            generateDocument((DocumentNode) root);
        } else {
            generateNode(root);
        }
    }

    private void generateDocument(DocumentNode document) {
        for (ASTNode child : document.getChildren()) {
            generateNode(child);
        }
    }

    private void generateNode(ASTNode node) {
        if (node == null) return;
        if (node instanceof DoctypeNode) {
            appendLine("<!DOCTYPE html>");
        } else if (node instanceof HtmlElementNode) {
            generateHtmlElement((HtmlElementNode) node);
        } else if (node instanceof JinjaBlockNode) {
            generateJinjaBlock((JinjaBlockNode) node);
        } else if (node instanceof JinjaNode) {
            generateJinjaNode((JinjaNode) node);
        } else if (node instanceof TextNode) {
            generateText((TextNode) node);
        }
    }

    // ═══════════════════════════════════════════════════════════════════════
    // توليد عناصر HTML والتحكم الذكي في الـ Style و الـ CSS
    // ═══════════════════════════════════════════════════════════════════════




//
//
//    private void generateHtmlElement(HtmlElementNode element) {
//        String tagName = element.getTagName();
//        boolean isSelfClosing = (element.getElementType() == HtmlElementNode.ElementType.SELF_CLOSING);
//
//        // 1. فتح الوسم الأساسي
//        appendIndent();
//        append("<" + tagName);
//
//        // 2. حلقة استخراج السمات العادية وتجنب تكرار الـ style
//        for (ASTNode child : element.getChildren()) {
//            if (child instanceof AttributeNode) {
//                AttributeNode attr = (AttributeNode) child;
//                String name = attr.getName();
//                String value = attr.getValue();
//
//                if (name != null && name.equalsIgnoreCase("style")) {
//                    continue;
//                }
//
//                if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE || value == null) {
//                    append(" " + name);
//                } else {
//                    String cleanedValue = cleanQuotes(value);
//                    append(" " + name + "=\"" + cleanedValue + "\"");
//                }
//            }
//        }
//
//        // 3. حلقة بناء الـ CSS المصلحة وإضافة النقطتين الرئيستين ":" والفاصلة ";"
//        for (ASTNode child : element.getChildren()) {
//            if (child instanceof StyleAttributeNode) {
//                StyleAttributeNode styleAttr = (StyleAttributeNode) child;
//                if (styleAttr.getCssRules() != null && !styleAttr.getCssRules().isEmpty()) {
//                    StringBuilder styleValue = new StringBuilder();
//                    for (CssRuleNode rule : styleAttr.getCssRules()) {
//                        if (styleValue.length() > 0) {
//                            styleValue.append(" "); // إضافة مسافة تفصل بين كل قاعدة والأخرى
//                        }
//
//                        // تنظيف أي علامات منقوطة مكررة قد تأتي من شجرة الـ AST
//                        String cleanValue = rule.getValue().trim();
//                        if (cleanValue.endsWith(";")) {
//                            cleanValue = cleanValue.substring(0, cleanValue.length() - 1).trim();
//                        }
//
//                        // 🔥 الإصلاح: دمج الخاصية والقيمة باستخدام النقطتين الرئيستين ":" والفاصلة المنقوطة ";"
//                        styleValue.append(rule.getProperty().trim())
//                                .append(": ")
//                                .append(cleanValue)
//                                .append(";");
//                    }
//                    if (styleValue.length() > 0) {
//                        append(" style=\"" + styleValue.toString() + "\"");
//                    }
//                }
//            }
//        }
//
//        // 4. إغلاق وسم الفتح
//        if (isSelfClosing) {
//            append(" />\n");
//            return;
//        }
//        append(">\n");
//        indent();
//
//        // 5. توليد المحتوى الداخلي للوسم
//        for (ASTNode child : element.getChildren()) {
//            if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode) && !(child instanceof CssRuleNode)) {
//                generateNode(child);
//            }
//        }
//
//        // 6. وسم الإغلاق
//        dedent();
//        appendIndent();
//        append("</" + tagName + ">\n");
//    }
//


    private void generateHtmlElement(HtmlElementNode element) {
        String tagName = element.getTagName();
        boolean isSelfClosing = (element.getElementType() == HtmlElementNode.ElementType.SELF_CLOSING);

        // 1. فتح الوسم الأساسي
        appendIndent();
        append("<" + tagName);

        // 2. حلقة استخراج السمات العادية (بما فيها lang وغيرها)
        for (ASTNode child : element.getChildren()) {
            if (child instanceof AttributeNode) {
                AttributeNode attr = (AttributeNode) child;
                String name = attr.getName();
                String value = attr.getValue();

                if (name != null && name.equalsIgnoreCase("style")) {
                    continue;
                }

                if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE || value == null) {
                    append(" " + name);
                } else {
                    String cleanedValue = cleanQuotes(value);
                    append(" " + name + "=\"" + cleanedValue + "\"");
                }
            }
        }

        // 3. حلقة بناء الـ CSS
        for (ASTNode child : element.getChildren()) {
            if (child instanceof StyleAttributeNode) {
                StyleAttributeNode styleAttr = (StyleAttributeNode) child;
                if (styleAttr.getCssRules() != null && !styleAttr.getCssRules().isEmpty()) {
                    StringBuilder styleValue = new StringBuilder();
                    for (CssRuleNode rule : styleAttr.getCssRules()) {
                        if (styleValue.length() > 0) {
                            styleValue.append(" ");
                        }
                        String cleanValue = rule.getValue().trim();
                        if (cleanValue.endsWith(";")) {
                            cleanValue = cleanValue.substring(0, cleanValue.length() - 1).trim();
                        }
                        styleValue.append(rule.getProperty().trim())
                                .append(": ")
                                .append(cleanValue)
                                .append(";");
                    }
                    if (styleValue.length() > 0) {
                        append(" style=\"" + styleValue.toString() + "\"");
                    }
                }
            }
        }

        // 4. معالجة إغلاق الوسم الفرعي (إزالة المسافة الزائدة لتطابق الأصلي)
        if (isSelfClosing) {
            append("/>\n");
            return;
        }

        // التحقق ما إذا كان العنصر يحتوي فقط على نص قصير أو تعبير Jinja واحد لطباعته في سطر واحد
        boolean inlineContent = false;
        if (element.getChildren().size() == 1 || (element.getChildren().size() <= 3 && (tagName.equalsIgnoreCase("h2") || tagName.equalsIgnoreCase("h3") || tagName.equalsIgnoreCase("p") || tagName.equalsIgnoreCase("label") || tagName.equalsIgnoreCase("title")))) {
            inlineContent = true;
            for (ASTNode child : element.getChildren()) {
                if (child instanceof HtmlElementNode || child instanceof JinjaBlockNode) {
                    inlineContent = false; // إذا كان يحتوي على عناصر HTML أخرى نلغي الـ inline
                    break;
                }
            }
        }

        if (inlineContent) {
            append(">");
            for (ASTNode child : element.getChildren()) {
                if (child instanceof TextNode) {
                    append(((TextNode) child).getText());
                } else if (child instanceof JinjaNode) {
                    String content = ((JinjaNode) child).getContent().trim();
                    if (((JinjaNode) child).getNodeName().contains("EXPRESSION")) {
                        append("{{ " + content + " }}");
                    } else {
                        append("{% " + content + " %}");
                    }
                }
            }
            append("</" + tagName + ">\n");
        } else {
            append(">\n");
            indent();

            // 5. توليد المحتوى الداخلي للعناصر العادية متعددة الأسطر
            for (ASTNode child : element.getChildren()) {
                if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode) && !(child instanceof CssRuleNode)) {
                    generateNode(child);
                }
            }

            // 6. وسم الإغلاق
            dedent();
            appendIndent();
            append("</" + tagName + ">\n");
        }
    }





    // ═══════════════════════════════════════════════════════════════════════
    // توليد النصوص
    // ═══════════════════════════════════════════════════════════════════════
    private void generateText(TextNode text) {
        String content = text.getText();
        if (content == null || content.isEmpty()) {
            return;
        }
        String trimmed = content.trim();
        if (trimmed.isEmpty()) {
            return;
        }
        // النص العادي
        appendIndent();
        append(content);
        append("\n");
    }

    // ═══════════════════════════════════════════════════════════════════════
    // توليد كتل Jinja2
    // ═══════════════════════════════════════════════════════════════════════
    private void generateJinjaBlock(JinjaBlockNode block) {
        if (block.getBlockType() == JinjaBlockNode.BlockType.IF) {
            generateJinjaIfBlock(block);
        } else if (block.getBlockType() == JinjaBlockNode.BlockType.FOR) {
            generateJinjaForBlock(block);
        }
    }

    private void generateJinjaIfBlock(JinjaBlockNode block) {
        String condition = "add_form";
        try {
            java.lang.reflect.Field field = JinjaBlockNode.class.getDeclaredField("conditionBlocks");
            field.setAccessible(true);
            Object blocks = field.get(block);
            if (blocks instanceof List && !((List<?>) blocks).isEmpty()) {
                Object firstBlock = ((List<?>) blocks).get(0);
                java.lang.reflect.Method getCondition = firstBlock.getClass().getMethod("getCondition");
                String cond = (String) getCondition.invoke(firstBlock);
                if (cond != null && !cond.isEmpty()) {
                    condition = cond;
                }
            }
        } catch (Exception e) {
            // استخدام القيمة الافتراضية عند فشل الانعكاس
        }
        appendIndent();
        appendLine("{% if " + condition + " %}");
        indent();

        for (ASTNode child : block.getChildren()) {
            if (child instanceof JinjaNode) {
                String content = ((JinjaNode) child).getContent();
                if (content.startsWith("if")) {
                    continue;
                } else if (content.startsWith("elif")) {
                    dedent();
                    appendIndent();
                    appendLine("{% " + content + " %}");
                    indent();
                    continue;
                } else if (content.equals("else")) {
                    dedent();
                    appendIndent();
                    appendLine("{% else %}");
                    indent();
                    continue;
                }
            }
            generateNode(child);
        }
        dedent();
        appendIndent();
        appendLine("{% endif %}");
    }

    private void generateJinjaForBlock(JinjaBlockNode block) {
        String loopExpr = "p in products";
        try {
            java.lang.reflect.Field field = JinjaBlockNode.class.getDeclaredField("conditionBlocks");
            field.setAccessible(true);
            Object blocks = field.get(block);
            if (blocks instanceof List && !((List<?>) blocks).isEmpty()) {
                Object firstBlock = ((List<?>) blocks).get(0);
                java.lang.reflect.Method getCondition = firstBlock.getClass().getMethod("getCondition");
                String cond = (String) getCondition.invoke(firstBlock);
                if (cond != null && !cond.isEmpty()) {
                    loopExpr = cond;
                }
            }
        } catch (Exception e) {
            // استخدام القيمة الافتراضية
        }
        appendIndent();
        appendLine("{% for " + loopExpr + " %}");
        indent();

        for (ASTNode child : block.getChildren()) {
            if (child instanceof JinjaNode) {
                String content = ((JinjaNode) child).getContent();
                if (content.startsWith("for")) {
                    continue;
                } else if (content.equals("else")) {
                    dedent();
                    appendIndent();
                    appendLine("{% else %}");
                    indent();
                    continue;
                }
            }
            generateNode(child);
        }
        dedent();
        appendIndent();
        appendLine("{% endfor %}");
    }

    private void generateJinjaNode(JinjaNode jinjaNode) {
        String content = jinjaNode.getContent().trim();
        String nodeName = jinjaNode.getNodeName();
        if (content.startsWith("if") || content.startsWith("for") || content.equals("else") || content.startsWith("elif") || content.equals("endif") || content.equals("endfor")) {
            return;
        }
        appendIndent();
        if (nodeName.contains("EXPRESSION")) {
            appendLine("{{ " + content + " }}");
        } else {
            appendLine("{% " + content + " %}");
        }
    }

    // ═══════════════════════════════════════════════════════════════════════
    // دوال مساعدة وتنظيف النصوص
    // ═══════════════════════════════════════════════════════════════════════
    private String cleanQuotes(String value) {
        if (value == null) return "";
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        if (value.startsWith("'") && value.endsWith("'")) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }

    public String getCode() {
        return code.toString();
    }

    public void saveToFile(String path) throws IOException {
        File file = new File(path);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(code.toString());
        }
        System.out.println("✅ تم إنشاء قالب Jinja2: " + path);
    }

    public void debugAST(ASTNode node, int depth) {
        if (node == null) return;
        String indent = " ".repeat(depth);
        System.out.println(indent + node.getNodeName());
        if (node instanceof StyleAttributeNode) {
            System.out.println(indent + " 🔥 STYLE ATTRIBUTE FOUND with " + ((StyleAttributeNode) node).getCssRules().size() + " rules");
        }
        for (ASTNode child : node.getChildren()) {
            debugAST(child, depth + 1);
        }
    }

    public void clear() {
        code.setLength(0);
        indentLevel = 0;
    }
}