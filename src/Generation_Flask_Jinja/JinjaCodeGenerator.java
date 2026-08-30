
package Generation_Flask_Jinja;

import AST_HTMLCSSJINJA.*;
import java.io.*;
import java.util.*;


public class JinjaCodeGenerator {


    private final StringBuilder htmlCode   = new StringBuilder(); // ناتج HTML/Jinja2
    private final StringBuilder flaskCode  = new StringBuilder(); // ناتج Python/Flask
    private int indentLevel = 0;

    // خريطة كلاس CSS الساكن → خصائص style المباشرة (مكون 12 – Padding)
    private static final Map<String, String> CSS_CLASS_MAP = new LinkedHashMap<>();
    static {
        // Container (مكون 1)
        CSS_CLASS_MAP.put("container-box",
                "width: 100%; max-width: 500px; padding: 15px; background: #ffffff;");
        // Row (مكون 2)
        CSS_CLASS_MAP.put("row-layout",
                "display: flex; flex-direction: row; align-items: center; gap: 10px;");
        // Column (مكون 3)
        CSS_CLASS_MAP.put("column-layout",
                "display: flex; flex-direction: column; gap: 12px;");
        // Scaffold (مكون 10)
        CSS_CLASS_MAP.put("scaffold-app", "");          // يُفكَّك إلى DOCTYPE
        // AppBar (مكون 11)
        CSS_CLASS_MAP.put("app-bar",
                "background: #2196F3; color: #fff; padding: 16px; font-size: 1.4rem;");
        // Padding (مكون 12) – يُعالج ديناميكياً عبر extractPadding()
        // SizedBox (مكون 13) – يُعالج ديناميكياً عبر extractSizedBox()
        // Card (مكون 15)
        CSS_CLASS_MAP.put("ui-card",
                "box-shadow: 0 4px 8px rgba(0,0,0,0.1); border-radius: 8px; padding: 16px;");
        // ListTile (مكون 16)
        CSS_CLASS_MAP.put("list-tile", "display: flex; align-items: center; gap: 12px;");
        // Clickable/Gesture (مكون 14) – يُعالج عبر detectGesture()
        CSS_CLASS_MAP.put("clickable", "cursor: pointer;");
        // btn-submit (مكون 7)
        CSS_CLASS_MAP.put("btn-submit",
                "background: #2196F3; color: #fff; padding: 10px 24px; border: none; border-radius: 4px; cursor: pointer;");
    }

    public JinjaCodeGenerator() {}


    public void generate(ASTNode root) {
        if (root instanceof DocumentNode) {
            generateDocument((DocumentNode) root);
        } else {
            generateHtmlNode(root);
        }
    }

    private void generateDocument(DocumentNode document) {
        for (ASTNode child : document.getChildren()) {
            generateHtmlNode(child);
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  توليد عقد HTML
    // ═══════════════════════════════════════════════════════════════════

    private void generateHtmlNode(ASTNode node) {
        if (node == null) return;

        if (node instanceof DoctypeNode) {
            // مكون 10 – Scaffold: طباعة DOCTYPE
            htmlAppendLine("<!DOCTYPE html>");

        } else if (node instanceof HtmlElementNode) {
            generateHtmlElement((HtmlElementNode) node);

        } else if (node instanceof JinjaBlockNode) {
            generateJinjaBlock((JinjaBlockNode) node);

        } else if (node instanceof JinjaNode) {
            generateJinjaNode((JinjaNode) node);

        } else if (node instanceof TextNode) {
            generateText((TextNode) node);
        }
        // AttributeNode / StyleAttributeNode / CssRuleNode تُعالج داخل generateHtmlElement
    }


    private void generateHtmlElement(HtmlElementNode element) {
        String tagName  = element.getTagName().toLowerCase();
        boolean isSelf  = element.getElementType() == HtmlElementNode.ElementType.SELF_CLOSING;

        // ── استخرج معلومات السمات أولاً ──
        String classVal  = extractAttrValue(element, "class");
        String styleVal  = extractInlineStyle(element);   // من StyleAttributeNode
        String nameVal   = extractAttrValue(element, "name");
        String srcVal    = extractAttrValue(element, "src");
        String typeVal   = extractAttrValue(element, "type");
        String actionVal = extractAttrValue(element, "action");
        String methodVal = extractAttrValue(element, "method");
        String onclickVal= extractAttrValue(element, "onclick");
        String dataTarget= extractAttrValue(element, "data-target");
        String altVal    = extractAttrValue(element, "alt");
        String langVal   = extractAttrValue(element, "lang");

        // ── ترجمة CSS-class الساكنة إلى style مباشر (مكونات 1-3, 10-16) ──
        String resolvedStyle = resolveClassToStyle(classVal, styleVal, nameVal, dataTarget, onclickVal);

        // ── تحديد نوع المكون ──

        // مكون 10 – Scaffold: <div class="scaffold-app">
        if ("scaffold-app".equals(classVal)) {
            // يُفكَّك إلى هيكل HTML كامل
            htmlAppendLine("<!DOCTYPE html>");
            htmlAppendLine("<html" + (langVal != null ? " lang=\"" + langVal + "\"" : "") + ">");
            htmlIndent();
            for (ASTNode child : element.getChildren()) {
                if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode))
                    generateHtmlNode(child);
            }
            htmlDedent();
            htmlAppendLine("</html>");
            return;
        }

        // مكون 13 – SizedBox: <div class="spacerh{N}">
        if (classVal != null && classVal.startsWith("spacer")) {
            String heightPx = extractSizedBoxHeight(classVal);
            htmlAppendLine("<div style=\"height: " + heightPx + ";\"></div>");
            return;
        }

        // مكون 12 – Padding: <div class="pad-{N}">
        if (classVal != null && classVal.startsWith("pad-")) {
            String padVal = extractPaddingValue(classVal);
            htmlAppend("<div style=\"padding: " + padVal + "; margin: " + padVal + ";\">");
            htmlIndentBlock(element);
            return;
        }

        // مكون 14 – Gesture: <div class="clickable" data-target="...">
        if ("clickable".equals(classVal) && dataTarget != null) {
            String href = "/" + dataTarget.replace(".php", "").replace(".html", "");
            htmlAppend("<div onclick=\"window.location.href='" + href + ";'\">");
            htmlIndentBlock(element);
            return;
        }

        // مكون 7 – Button داخل form
        if ("button".equals(tagName) && "submit".equals(typeVal)) {
            // الزر نفسه – سيُغلَّف بـ <form> إذا كان الوالد form
            String btnStyle = resolvedStyle.isEmpty()
                    ? "background: #2196F3; color: #fff; padding: 10px 24px; border: none; border-radius: 4px; cursor: pointer;"
                    : resolvedStyle;
            htmlAppend("<button type=\"submit\" style=\"" + btnStyle + "\">");
            generateInlineChildren(element);
            htmlAppendRaw("</" + tagName + ">\n");
            return;
        }


        if ("form".equals(tagName)) {
            String method = methodVal != null ? methodVal : "POST";
            String action = actionVal != null ? translateRoute(actionVal) : "";

            htmlAppend("<form method=\"" + method + "\" action=\"" + action + "\"");

            if (hasFileInput(element)) {
                htmlAppendRaw(" enctype=\"multipart/form-data\"");
            }

            htmlAppendRaw(">");
            htmlNewLine();
            htmlIndent();
            for (ASTNode child : element.getChildren()) {
                if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode))
                    generateHtmlNode(child);
            }
            htmlDedent();
            htmlAppendLine("</form>");
            return;
        }

        // مكون 5 – TextField: أي <input> يحمل name يحتاج request.form.get لإعادة تعبئة قيمته
        // يشمل: type="text", "number", "email", "password", "search", "tel", وبدون type
        if ("input".equals(tagName) && nameVal != null) {
            String inputType = (typeVal != null) ? typeVal : "text";

            // حقول من النوع checkbox/radio/submit/button/file لا تحتاج request.form.get
            boolean needsFormGet = !inputType.equals("submit")
                    && !inputType.equals("button")
                    && !inputType.equals("file")
                    && !inputType.equals("checkbox")
                    && !inputType.equals("radio")
                    && !inputType.equals("image");

            // استخرج باقي السمات الأصلية (required, placeholder, id, ...) من الـ AST
            StringBuilder extraAttrs = new StringBuilder();
            for (ASTNode child : element.getChildren()) {
                if (child instanceof AttributeNode) {
                    AttributeNode attr = (AttributeNode) child;
                    String attrName = attr.getName();
                    if (attrName == null) continue;
                    // تجاهل السمات التي سنكتبها يدوياً
                    if (attrName.equalsIgnoreCase("type")
                            || attrName.equalsIgnoreCase("name")
                            || attrName.equalsIgnoreCase("value")
                            || attrName.equalsIgnoreCase("class")
                            || attrName.equalsIgnoreCase("style")) continue;

                    String val = attr.getValue();
                    if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE || val == null) {
                        extraAttrs.append(" ").append(attrName);
                    } else {
                        extraAttrs.append(" ").append(attrName).append("=\"").append(cleanQuotes(val)).append("\"");
                    }
                }
            }

            StringBuilder inputTag = new StringBuilder();
            inputTag.append("<input type=\"").append(inputType).append("\"");
            inputTag.append(" name=\"").append(nameVal).append("\"");

            // مكون 5: حقن {{ request.form.get('name', '') }} لإعادة تعبئة الحقل بعد الإرسال
            if (needsFormGet) {
                inputTag.append(" value=\"{{ request.form.get('").append(nameVal).append("', '') }}\"");
            }

            if (!resolvedStyle.isEmpty()) {
                inputTag.append(" style=\"").append(resolvedStyle).append("\"");
            }
            inputTag.append(extraAttrs);
            inputTag.append(">");
            htmlAppendLine(inputTag.toString());
            return;
        }

        // مكون 6 – Image: <img src="...">
        // ===== التعديل المطلوب رقم 2: إصلاح الأقواس المزدوجة في src =====
        if ("img".equals(tagName)) {
            String resolvedSrc = resolveImageSrc(srcVal);
            String alt         = altVal != null ? altVal : "image";
            htmlAppendLine("<img src=\"" + resolvedSrc + "\" alt=\"" + alt + "\""
                    + (resolvedStyle.isEmpty() ? "" : " style=\"" + resolvedStyle + "\"")
                    + ">");
            return;
        }

        // مكون 11 – AppBar: <header class="app-bar">
        if ("header".equals(tagName) || "app-bar".equals(classVal)) {
            String barStyle = resolvedStyle.isEmpty()
                    ? "background: #2196F3; color: #fff; padding: 16px; font-size: 1.4rem;"
                    : resolvedStyle;
            htmlAppend("<header style=\"" + barStyle + "\">");
            htmlNewLine();
            htmlIndent();
            for (ASTNode child : element.getChildren()) {
                if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode))
                    generateHtmlNode(child);
            }
            htmlDedent();
            htmlAppendLine("</header>");
            return;
        }

        // ── معالجة خاصة لوسم <a>: ترجمة href باستخدام resolveHref / url_for ──
        if ("a".equals(tagName)) {
            String hrefVal = extractAttrValue(element, "href");
            String resolvedHref = resolveHref(hrefVal);
            htmlAppend("<a href=\"" + resolvedHref + "\"");
            // باقي السمات
            for (ASTNode child : element.getChildren()) {
                if (child instanceof AttributeNode) {
                    AttributeNode attr = (AttributeNode) child;
                    String attrName = attr.getName();
                    if (attrName == null || attrName.equalsIgnoreCase("href")
                            || attrName.equalsIgnoreCase("class")
                            || attrName.equalsIgnoreCase("style")) continue;
                    String val = attr.getValue();
                    if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE || val == null)
                        htmlAppendRaw(" " + attrName);
                    else
                        htmlAppendRaw(" " + attrName + "=\"" + cleanQuotes(val) + "\"");
                }
            }
            if (!resolvedStyle.isEmpty()) htmlAppendRaw(" style=\"" + resolvedStyle + "\"");
            if (hasOnlyInlineChildren(element)) {
                htmlAppendRaw(">");
                generateInlineChildren(element);
                htmlAppendRaw("</a>\n");
            } else {
                htmlAppendRaw(">\n");
                htmlIndent();
                for (ASTNode child : element.getChildren()) {
                    if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode))
                        generateHtmlNode(child);
                }
                htmlDedent();
                htmlAppendLine("</a>");
            }
            return;
        }

        // ── المسار الافتراضي: عنصر HTML عادي بترجمة الكلاس الساكن ──
        htmlAppend("<" + tagName);

        // أضف lang إن وجد
        if (langVal != null) htmlAppendRaw(" lang=\"" + langVal + "\"");

        // أضف باقي السمات (غير المُعالَجة أعلاه)
        for (ASTNode child : element.getChildren()) {
            if (child instanceof AttributeNode) {
                AttributeNode attr = (AttributeNode) child;
                String attrName = attr.getName();
                if (attrName == null) continue;
                // السمات التي عُولجت بالفعل
                if (isHandledAttr(attrName)) continue;
                String val = attr.getValue();
                if (attr.getType() == AttributeNode.AttributeType.WITHOUT_VALUE || val == null) {
                    htmlAppendRaw(" " + attrName);
                } else {
                    htmlAppendRaw(" " + attrName + "=\"" + cleanQuotes(val) + "\"");
                }
            }
        }

        // أضف style المُجمَّع
        if (!resolvedStyle.isEmpty()) {
            htmlAppendRaw(" style=\"" + resolvedStyle + "\"");
        }

        if (isSelf) {
            htmlAppendRaw("/>\n");
            return;
        }

        // هل المحتوى داخلي مختصر (نص + Jinja فقط، بدون عناصر HTML داخلية)؟
        if (isInlineTag(tagName) && hasOnlyInlineChildren(element)) {
            htmlAppendRaw(">");
            generateInlineChildren(element);
            htmlAppendRaw("</" + tagName + ">\n");
        } else {
            htmlAppendRaw(">\n");
            htmlIndent();
            for (ASTNode child : element.getChildren()) {
                if (!(child instanceof AttributeNode)
                        && !(child instanceof StyleAttributeNode)
                        && !(child instanceof CssRuleNode)) {
                    generateHtmlNode(child);
                }
            }
            htmlDedent();
            htmlAppendIndent();
            htmlAppendRaw("</" + tagName + ">\n");
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  توليد كتل Jinja2
    // ═══════════════════════════════════════════════════════════════════

    private void generateJinjaBlock(JinjaBlockNode block) {
        if (block.getBlockType() == JinjaBlockNode.BlockType.IF) {
            generateJinjaIfBlock(block);
        } else if (block.getBlockType() == JinjaBlockNode.BlockType.FOR) {
            generateJinjaForBlock(block);
        }
    }

    // مكون 24 – الشرط الدلالي للأمان  {% if predictions %}
    private void generateJinjaIfBlock(JinjaBlockNode block) {
        String condition = extractBlockCondition(block, "predictions");
        htmlAppendLine("{% if " + condition + " %}");
        htmlIndent();
        for (ASTNode child : block.getChildren()) {
            if (child instanceof JinjaNode) {
                String content = ((JinjaNode) child).getContent();
                if (content.startsWith("if")) continue;
                if (content.startsWith("elif")) {
                    htmlDedent();
                    htmlAppendLine("{% " + content + " %}");
                    htmlIndent();
                    continue;
                }
                if (content.equals("else")) {
                    htmlDedent();
                    htmlAppendLine("{% else %}");
                    htmlIndent();
                    continue;
                }
            }
            generateHtmlNode(child);
        }
        htmlDedent();
        htmlAppendLine("{% endif %}");
    }

    // مكونا 8+9 – For Loop / EndFor
    private void generateJinjaForBlock(JinjaBlockNode block) {
        String loopExpr = extractBlockCondition(block, "score in predictions");
        htmlAppendLine("{% for " + loopExpr + " %}");
        htmlIndent();
        for (ASTNode child : block.getChildren()) {
            if (child instanceof JinjaNode) {
                String content = ((JinjaNode) child).getContent();
                if (content.startsWith("for")) continue;
                if (content.equals("else")) {
                    htmlDedent();
                    htmlAppendLine("{% else %}");
                    htmlIndent();
                    continue;
                }
            }
            generateHtmlNode(child);
        }
        htmlDedent();
        htmlAppendLine("{% endfor %}");
    }

    // مكون 4 – Text / JinjaExpression  {{ variable }}
    private void generateJinjaNode(JinjaNode jinjaNode) {
        String content  = jinjaNode.getContent().trim();
        String nodeName = jinjaNode.getNodeName();
        // تجاهل الكلمات المفتاحية التي تُعالجها كتل IF/FOR
        if (content.matches("(if|for|else|elif|endif|endfor).*")) return;
        htmlAppendIndent();
        if (nodeName.contains("EXPRESSION")) {
            htmlAppendRaw("{{ " + content + " }}\n");
        } else {
            htmlAppendRaw("{% " + content + " %}\n");
        }
    }

    private void generateText(TextNode text) {
        String content = text.getText();
        if (content == null || content.trim().isEmpty()) return;
        htmlAppendIndent();
        htmlAppendRaw(content + "\n");
    }

    // ═══════════════════════════════════════════════════════════════════
    //  توليد كود Flask/Python  (مكونات 17-25)
    // ═══════════════════════════════════════════════════════════════════

    /**
     * يولد ملف app.py كامل يشمل:
     *   مكون 17 – Server/App
     *   مكون 18 – Route
     *   مكون 19 – Data Receiving
     *   مكون 20 – ML Model Load
     *   مكون 21 – Feature Array
     *   مكون 22 – Prediction
     *   مكون 23 – Probabilities
     *   مكون 24 – Conditional Safety
     *   مكون 25 – render_template
     *
     * @param routePath   مسار الـ route مثل /predict
     * @param modelFile   اسم ملف الموديل مثل ai_model.pkl
     * @param featureNames قائمة أسماء الحقول المُدخَلة مثل ["age","salary"]
     * @param templateName اسم قالب HTML مثل index.html
     */
    public void generateFlaskApp(String routePath,
                                 String modelFile,
                                 List<String> featureNames,
                                 String templateName) {
        flaskCode.setLength(0);

        // مكون 17 – Server/App
        fl("from flask import Flask, request, render_template");
        fl("import joblib");
        fl("");
        fl("app = Flask(__name__)");
        fl("");

        // مكون 20 – ML Model Load
        fl("# تحميل خوارزمية الذكاء الاصطناعي في ذاكرة السيرفر");
        fl("ai_model = joblib.load('" + modelFile + "')");
        fl("");

        // مكون 18 – Route
        fl("@app.route('" + routePath + "', methods=['GET', 'POST'])");
        fl("def predict_route():");

        // مكون 24 – Conditional Safety (الجانب البايثوني)
        fl("    prediction_probabilities = None");
        fl("    final_prediction = None");
        fl("");
        fl("    if request.method == 'POST':");

        // مكون 19 – Data Receiving
        for (String feat : featureNames) {
            fl("        " + feat + " = float(request.form.get('" + feat + "', 0))");
        }
        fl("");

        // مكون 21 – Feature Array
        String featArray = buildFeatureArray(featureNames);
        fl("        # تجميع الميزات في مصفوفة ثنائية الأبعاد");
        fl("        input_features = [" + featArray + "]");
        fl("");

        // مكون 22 – Prediction
        fl("        # استدعاء الموديل للحصول على التصنيف");
        fl("        final_prediction = int(ai_model.predict(input_features)[0])");

        // مكون 23 – Probabilities
        fl("        # احتمالات التوقع لكل الفئات");
        fl("        prediction_probabilities = ai_model.predict_proba(input_features)[0].tolist()");
        fl("");

        // مكون 25 – render_template
        fl("    return render_template('" + templateName + "',");
        fl("                           predictions=prediction_probabilities,");
        fl("                           result=final_prediction)");
        fl("");
        fl("");
        fl("if __name__ == '__main__':");
        fl("    app.run(debug=True)");
    }

    // ═══════════════════════════════════════════════════════════════════
    //  دوال مساعدة – استخراج المعلومات من الـ AST
    // ═══════════════════════════════════════════════════════════════════

    private String extractAttrValue(HtmlElementNode element, String attrName) {
        for (ASTNode child : element.getChildren()) {
            if (child instanceof AttributeNode) {
                AttributeNode attr = (AttributeNode) child;
                if (attrName.equalsIgnoreCase(attr.getName())) {
                    return cleanQuotes(attr.getValue());
                }
            }
        }
        return null;
    }

    private String extractInlineStyle(HtmlElementNode element) {
        for (ASTNode child : element.getChildren()) {
            if (child instanceof StyleAttributeNode) {
                StyleAttributeNode sa = (StyleAttributeNode) child;
                if (sa.getCssRules() == null || sa.getCssRules().isEmpty()) continue;
                StringBuilder sb = new StringBuilder();
                for (CssRuleNode rule : sa.getCssRules()) {
                    if (sb.length() > 0) sb.append(" ");
                    String val = rule.getValue().trim();
                    if (val.endsWith(";")) val = val.substring(0, val.length() - 1).trim();
                    sb.append(rule.getProperty().trim()).append(": ").append(val).append(";");
                }
                return sb.toString();
            }
        }
        return "";
    }


    private String resolveClassToStyle(String classVal, String existingStyle,
                                       String nameVal, String dataTarget, String onclick) {
        // الأولوية لـ style المُدرج مباشرة في الـ AST
        if (existingStyle != null && !existingStyle.isEmpty()) return existingStyle;
        if (classVal == null || classVal.isEmpty()) return "";

        // بحث في الخريطة الثابتة
        if (CSS_CLASS_MAP.containsKey(classVal)) return CSS_CLASS_MAP.get(classVal);

        // Padding ديناميكي: pad-{N}
        if (classVal.startsWith("pad-")) return "padding: " + extractPaddingValue(classVal)
                + "; margin: " + extractPaddingValue(classVal) + ";";

        // SizedBox ديناميكي: spacerh{N} أو spacerw{N}
        if (classVal.startsWith("spacer")) return "height: " + extractSizedBoxHeight(classVal) + ";";

        return "";
    }

    private String extractPaddingValue(String classVal) {
        String num = classVal.replaceAll("[^0-9]", "");
        return num.isEmpty() ? "10px" : num + "px";
    }

    private String extractSizedBoxHeight(String classVal) {
        String num = classVal.replaceAll("[^0-9]", "");
        return num.isEmpty() ? "20px" : num + "px";
    }


    private String resolveImageSrc(String src) {
        if (src == null || src.isEmpty()) return "";

        // ✅ إضافة هذا الشرط لمنع الأقواس المزدوجة
        if (src.contains("{{") && src.contains("}}")) {
            return src;
        }

        // حالة أ: يحتوي بالفعل على url_for – نُعيده كتعبير Jinja محاط بـ {{ }}
        if (src.contains("url_for")) {
            // إذا لم يكن محاطاً بـ {{ }} أضفناها
            String trimmed = src.trim();
            if (trimmed.startsWith("{{") && trimmed.endsWith("}}")) return trimmed;
            return "{{ " + trimmed + " }}";
        }

        // حالة ب: مسار نسبي يبدأ بـ assets/ أو images/ → url_for('static', filename='...')
        if (src.startsWith("assets/") || src.startsWith("images/")) {
            String filename = src
                    .replaceFirst("^assets/images/", "")
                    .replaceFirst("^assets/", "")
                    .replaceFirst("^images/", "");
            return "{{ url_for('static', filename='" + filename + "') }}";
        }

        // حالة ج: متغير Jinja (لا يبدأ بـ / أو http ولا ينتهي بامتداد صورة مباشرة)
        boolean isAbsolute = src.startsWith("/") || src.startsWith("http://") || src.startsWith("https://");
        boolean hasImageExt = src.matches(".*\\.(png|jpg|jpeg|gif|svg|webp|ico)$");
        if (!isAbsolute && !hasImageExt) {
            // متغير Jinja مثل product.image_url أو item.photo
            return "{{ " + src + " }}";
        }

        // حالة د: مسار مطلق أو مباشر → يُعاد كما هو
        return src;
    }


    private String translateRoute(String action) {
        if (action == null) return "";
        if (action.contains("{{") && action.contains("}}")) return action;
        // إذا كان يحتوي url_for → يُعاد كـ Jinja {{ url_for(...) }}
        if (action.contains("url_for")) {
            String trimmed = action.trim();
            if (trimmed.startsWith("{{") && trimmed.endsWith("}}")) return trimmed;
            return "{{ " + trimmed + " }}";
        }
        return "/" + action.replaceAll("\\.php$", "").replaceAll("\\.html$", "").replaceAll("^/", "");
    }


    private String resolveHref(String href) {
        if (href == null || href.isEmpty()) return "#";
        if (href.contains("url_for")) {
            String trimmed = href.trim();
            if (trimmed.startsWith("{{") && trimmed.endsWith("}}")) return trimmed;
            return "{{ " + trimmed + " }}";
        }
        // رابط PHP → Flask route
        if (href.endsWith(".php") || href.contains(".php?")) {
            return "/" + href.replaceAll("\\.php(\\?.*)?$", "").replaceAll("^/", "");
        }
        return href;
    }

    private String extractBlockCondition(JinjaBlockNode block, String fallback) {
        try {
            java.lang.reflect.Field field = JinjaBlockNode.class.getDeclaredField("conditionBlocks");
            field.setAccessible(true);
            Object blocks = field.get(block);
            if (blocks instanceof List && !((List<?>) blocks).isEmpty()) {
                Object first = ((List<?>) blocks).get(0);
                java.lang.reflect.Method getCondition = first.getClass().getMethod("getCondition");
                String cond = (String) getCondition.invoke(first);
                if (cond != null && !cond.isEmpty()) return cond;
            }
        } catch (Exception ignored) {}
        return fallback;
    }

    // ===== التعديل المطلوب رقم 1 (مكمل): دالة للكشف عن input type="file" =====
    private boolean hasFileInput(HtmlElementNode element) {
        for (ASTNode child : element.getChildren()) {
            if (child instanceof HtmlElementNode) {
                HtmlElementNode el = (HtmlElementNode) child;
                if ("input".equalsIgnoreCase(el.getTagName())) {
                    String type = extractAttrValue(el, "type");
                    if ("file".equalsIgnoreCase(type)) return true;
                }
            }
        }
        return false;
    }

    // ═══════════════════════════════════════════════════════════════════
    //  دوال مساعدة – التصيير
    // ═══════════════════════════════════════════════════════════════════

    private static final Set<String> INLINE_TAGS = new HashSet<>(Arrays.asList(
            "h1","h2","h3","h4","h5","h6","p","label","title","span","a","li","td","th","caption","dt","dd"));

    private boolean isInlineTag(String tagName) { return INLINE_TAGS.contains(tagName); }

    private boolean hasOnlyInlineChildren(HtmlElementNode element) {
        for (ASTNode child : element.getChildren()) {
            if (child instanceof HtmlElementNode || child instanceof JinjaBlockNode) return false;
        }
        return true;
    }

    private void generateInlineChildren(HtmlElementNode element) {
        for (ASTNode child : element.getChildren()) {
            if (child instanceof TextNode) {
                htmlAppendRaw(((TextNode) child).getText());
            } else if (child instanceof JinjaNode) {
                JinjaNode j = (JinjaNode) child;
                String content = j.getContent().trim();
                if (j.getNodeName().contains("EXPRESSION"))
                    htmlAppendRaw("{{ " + content + " }}");
                else
                    htmlAppendRaw("{% " + content + " %}");
            }
        }
    }

    private void htmlIndentBlock(HtmlElementNode element) {
        htmlNewLine();
        htmlIndent();
        for (ASTNode child : element.getChildren()) {
            if (!(child instanceof AttributeNode) && !(child instanceof StyleAttributeNode)
                    && !(child instanceof CssRuleNode))
                generateHtmlNode(child);
        }
        htmlDedent();
        htmlAppendLine("</" + element.getTagName() + ">");
    }

    private static final Set<String> HANDLED_ATTRS = new HashSet<>(Arrays.asList(
            "class","style","name","src","type","action","method","onclick",
            "data-target","alt","lang","value"));

    private boolean isHandledAttr(String name) {
        return name != null && HANDLED_ATTRS.contains(name.toLowerCase());
    }

    private String cleanQuotes(String value) {
        if (value == null) return "";
        value = value.trim();
        if (value.startsWith("\"") && value.endsWith("\"")) value = value.substring(1, value.length() - 1);
        if (value.startsWith("'")  && value.endsWith("'"))  value = value.substring(1, value.length() - 1);
        return value;
    }

    private String buildFeatureArray(List<String> featureNames) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < featureNames.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append("user_").append(featureNames.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    // ═══════════════════════════════════════════════════════════════════
    //  دوال إخراج HTML
    // ═══════════════════════════════════════════════════════════════════

    private void htmlAppend(String text)      { htmlAppendIndent(); htmlCode.append(text); }
    private void htmlAppendRaw(String text)   { htmlCode.append(text); }
    private void htmlAppendLine(String line)  { htmlAppendIndent(); htmlCode.append(line).append("\n"); }
    private void htmlAppendIndent()           { htmlCode.append("    ".repeat(indentLevel)); }
    private void htmlNewLine()                { htmlCode.append("\n"); }
    private void htmlIndent()                 { indentLevel++; }
    private void htmlDedent()                 { if (indentLevel > 0) indentLevel--; }

    // ═══════════════════════════════════════════════════════════════════
    //  دوال إخراج Flask
    // ═══════════════════════════════════════════════════════════════════

    private void fl(String line) { flaskCode.append(line).append("\n"); }

    // ═══════════════════════════════════════════════════════════════════
    //  واجهة الحفظ والاسترجاع
    // ═══════════════════════════════════════════════════════════════════

    public String getHtmlCode()   { return htmlCode.toString(); }
    public String getFlaskCode()  { return flaskCode.toString(); }

    /** يحفظ ملف HTML/Jinja2 */
    public void saveToFile(String path) throws IOException {
        saveToFile(path, htmlCode.toString());
        System.out.println("✅ تم إنشاء قالب Jinja2: " + path);
    }

    /** يحفظ ملف app.py */
    public void saveFlaskToFile(String path) throws IOException {
        saveToFile(path, flaskCode.toString());
        System.out.println("✅ تم إنشاء سيرفر Flask: " + path);
    }

    private void saveToFile(String path, String content) throws IOException {
        File file = new File(path);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    public void debugAST(ASTNode node, int depth) {
        if (node == null) return;
        String pad = "  ".repeat(depth);
        System.out.println(pad + node.getNodeName());
        if (node instanceof StyleAttributeNode)
            System.out.println(pad + "   STYLE ATTRIBUTE FOUND with "
                    + ((StyleAttributeNode) node).getCssRules().size() + " rules");
        for (ASTNode child : node.getChildren()) debugAST(child, depth + 1);
    }

    public void clear() {
        htmlCode.setLength(0);
        flaskCode.setLength(0);
        indentLevel = 0;

    }
}




