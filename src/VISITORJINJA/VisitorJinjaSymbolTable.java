
package VISITORJINJA;

import AST_HTMLCSSJINJA.*;
import VISITORJINJA.ST.*;
import antlrJinja.HTMLCSSJINJA_parser;
import antlrJinja.HTMLCSSJINJA_parserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public class VisitorJinjaSymbolTable extends HTMLCSSJINJA_parserBaseVisitor<ASTNode> {

    private HtmlCssJinjaSymbolTable symbolTable;
    private Stack<HtmlElementSymbol> elementStack;
    private Stack<StyleAttributeSymbol> styleAttrStack;
    private Stack<JinjaBlockSymbol> jinjaBlockStack;
    private boolean inJinjaContext;
    private boolean inStyleContext;
    private List<String> errors;
    private List<String> warnings;
    private VisitorJinja originalVisitor;

    public VisitorJinjaSymbolTable() {
        this.symbolTable = new HtmlCssJinjaSymbolTable();
        this.elementStack = new Stack<>();
        this.styleAttrStack = new Stack<>();
        this.jinjaBlockStack = new Stack<>();
        this.inJinjaContext = false;
        this.inStyleContext = false;
        this.errors = new ArrayList<>();
        this.warnings = new ArrayList<>();
        this.originalVisitor = null;
    }

    public VisitorJinjaSymbolTable(VisitorJinja originalVisitor) {
        this();
        this.originalVisitor = originalVisitor;
    }

    public HtmlCssJinjaSymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public List<String> getWarnings() {
        return new ArrayList<>(warnings);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void printStatistics() {
        symbolTable.printStatistics();
        System.out.println("\n=== Visitor Errors/Warnings ===");
        System.out.println("Errors: " + errors.size());
        System.out.println("Warnings: " + warnings.size());
    }

    private void addError(String error, int line, int column) {
        String errorMsg = String.format("SymbolTable Error at line %d, col %d: %s",
                line, column, error);
        errors.add(errorMsg);
        System.err.println("[SymbolTable ERROR] " + errorMsg);
    }

    private void addWarning(String warning, int line, int column) {
        String warningMsg = String.format("SymbolTable Warning at line %d, col %d: %s",
                line, column, warning);
        warnings.add(warningMsg);
        System.out.println("[SymbolTable WARNING] " + warningMsg);
    }

    private void logInfo(String info) {
        System.out.println("[SymbolTable INFO] " + info);
    }

    private boolean isValidId(String id) {
        if (id == null || id.isEmpty()) return false;
        return id.matches("^[a-zA-Z_][a-zA-Z0-9_\\-]*$");
    }

    private boolean isValidClass(String className) {
        if (className == null || className.isEmpty()) return false;
        return !className.contains(" ") && className.matches("^[a-zA-Z_][a-zA-Z0-9_\\-]*$");
    }

    // ═══════════════════════════════════════════════════════════════════
    //  عناصر HTML
    // ═══════════════════════════════════════════════════════════════════

    @Override
    public ASTNode visitHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx) {
        try {
            HtmlElementSymbol htmlElement = new HtmlElementSymbol(
                    "html",
                    HtmlElementSymbol.ElementCategory.STRUCTURAL,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    true
            );
            symbolTable.enterScope("html_element", SymbolScope.ScopeType.HTML_ELEMENT);
            elementStack.push(htmlElement);
            ASTNode result = super.visitHtmlelement(ctx);
            symbolTable.closeHtmlElement();
            elementStack.pop();
            symbolTable.addHtmlElement(htmlElement);
            logInfo("Added HTML element: <html>");
            return result;
        } catch (Exception e) {
            addError("Error processing HTML element: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitHtmlelement(ctx);
        }
    }

    @Override
    public ASTNode visitNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx) {
        try {
            String tagName = ctx.tagsheadnormal(0).getText();
            HtmlElementSymbol.ElementCategory category = HtmlElementSymbol.getCategoryFromTag(tagName);
            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName, category,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    true
            );
            symbolTable.enterScope("element_" + tagName, SymbolScope.ScopeType.HTML_ELEMENT);
            elementStack.push(element);
            ASTNode result = super.visitNormaltaghead(ctx);
            symbolTable.closeHtmlElement();
            elementStack.pop();
            symbolTable.addHtmlElement(element);
            logInfo("Added head element: <" + tagName + ">");
            return result;
        } catch (Exception e) {
            addError("Error processing head tag: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitNormaltaghead(ctx);
        }
    }

    @Override
    public ASTNode visitNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx) {
        try {
            String tagName = ctx.tagsbodynamenormal(0).getText();
            HtmlElementSymbol.ElementCategory category = HtmlElementSymbol.getCategoryFromTag(tagName);
            boolean isSelfClosing = HtmlElementSymbol.isSelfClosingTag(tagName);
            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName, category,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    !isSelfClosing
            );
            if (inJinjaContext) element.setInJinjaContext(true);
            if (!isSelfClosing) {
                symbolTable.enterScope("element_" + tagName, SymbolScope.ScopeType.HTML_ELEMENT);
                elementStack.push(element);
            }
            ASTNode result = super.visitNormal_Tag_Element_body(ctx);
            if (!isSelfClosing) {
                symbolTable.closeHtmlElement();
                elementStack.pop();
            }
            symbolTable.addHtmlElement(element);
            logInfo("Added body element: <" + tagName + ">");
            return result;
        } catch (Exception e) {
            addError("Error processing body tag: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitNormal_Tag_Element_body(ctx);
        }
    }

    @Override
    public ASTNode visitSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx) {
        try {
            String tagName = ctx.tagsbodynameself().getText();
            HtmlElementSymbol.ElementCategory category = HtmlElementSymbol.getCategoryFromTag(tagName);
            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName, category,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    false
            );
            if (inJinjaContext) element.setInJinjaContext(true);
            super.visitSelfClosingTagElementbody(ctx);
            symbolTable.addHtmlElement(element);
            logInfo("Added self-closing element: <" + tagName + "/>");
            return null;
        } catch (Exception e) {
            addError("Error processing self-closing tag: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitSelfClosingTagElementbody(ctx);
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  السمات
    // ═══════════════════════════════════════════════════════════════════

    @Override
    public ASTNode visitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx) {
        try {
            String attrName = ctx.attributenamebody().getText();
            String attrValue = ctx.ATTRIBUTE_VALUE().getText();
            HtmlAttributeSymbol.AttributeType attrType = HtmlAttributeSymbol.inferAttributeType(attrName);
            HtmlAttributeSymbol attribute = new HtmlAttributeSymbol(
                    attrName, attrType, attrValue, true,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) {
                HtmlElementSymbol currentElement = elementStack.peek();
                attribute.setParentElement(currentElement);
                currentElement.addAttribute(attribute);
                if ("id".equals(attrName)) {
                    String idValue = attribute.getValueWithoutQuotes();
                    if (!isValidId(idValue)) {
                        addWarning("Invalid ID format: " + idValue,
                                ctx.getStart().getLine(),
                                ctx.getStart().getCharPositionInLine());
                    }
                } else if ("class".equals(attrName)) {
                    String[] classes = attribute.getValueAsArray();
                    for (String cls : classes) {
                        if (!isValidClass(cls)) {
                            addWarning("Invalid class name: " + cls,
                                    ctx.getStart().getLine(),
                                    ctx.getStart().getCharPositionInLine());
                        }
                    }
                }
            } else {
                addWarning("Attribute " + attrName + " without parent element",
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine());
            }
            symbolTable.addHtmlAttribute(attribute);
            logInfo("Added attribute: " + attrName + "=\"" + attribute.getValueWithoutQuotes() + "\"");
            return super.visitAttributenamebodylabel(ctx);
        } catch (Exception e) {
            addError("Error processing attribute: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitAttributenamebodylabel(ctx);
        }
    }

    @Override
    public ASTNode visitAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx) {
        try {
            String attrName = ctx.attributenamebodywithoutvalue().getText();
            HtmlAttributeSymbol.AttributeType attrType = HtmlAttributeSymbol.inferAttributeType(attrName);
            HtmlAttributeSymbol attribute = new HtmlAttributeSymbol(
                    attrName, attrType,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) {
                HtmlElementSymbol currentElement = elementStack.peek();
                attribute.setParentElement(currentElement);
                currentElement.addAttribute(attribute);
            }
            symbolTable.addHtmlAttribute(attribute);
            logInfo("Added boolean attribute: " + attrName);
            return super.visitAttributenamebodywithoutvaluelabel(ctx);
        } catch (Exception e) {
            addError("Error processing boolean attribute: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitAttributenamebodywithoutvaluelabel(ctx);
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  CSS Styles
    // ═══════════════════════════════════════════════════════════════════

    @Override
    public ASTNode visitStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx) {
        try {
            StyleAttributeSymbol styleAttr = new StyleAttributeSymbol(
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) {
                HtmlElementSymbol currentElement = elementStack.peek();
                styleAttr.setParentElement(currentElement);
                currentElement.addAttribute(styleAttr);
            }
            symbolTable.enterScope("style_attribute", SymbolScope.ScopeType.STYLE_ATTRIBUTE);
            styleAttrStack.push(styleAttr);
            inStyleContext = true;
            super.visitStylelabel(ctx);
            symbolTable.exitScope();
            styleAttrStack.pop();
            inStyleContext = false;
            symbolTable.addHtmlAttribute(styleAttr);
            logInfo("Added style attribute with " + styleAttr.getRuleCount() + " rules");
            return null;
        } catch (Exception e) {
            addError("Error processing style attribute: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitStylelabel(ctx);
        }
    }

    @Override
    public ASTNode visitColor(HTMLCSSJINJA_parser.ColorContext ctx) {
        try {
            if (ctx.CSS_ATTR_COLOR() != null && ctx.CSS_COLOR_VALUE() != null) {
                String property = ctx.CSS_ATTR_COLOR().getText();
                String value = ctx.CSS_COLOR_VALUE().getText();
                CssRuleSymbol rule = new CssRuleSymbol(
                        property, CssRuleSymbol.RuleCategory.COLOR,
                        Collections.singletonList(value),
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
                if (!styleAttrStack.isEmpty()) {
                    StyleAttributeSymbol currentStyle = styleAttrStack.peek();
                    currentStyle.addCssRule(rule);
                    if (!elementStack.isEmpty()) rule.setTargetElement(elementStack.peek());
                }
                symbolTable.addCssRule(rule);
                logInfo("Added CSS rule: " + property + ": " + value);
            }
            return super.visitColor(ctx);
        } catch (Exception e) {
            addError("Error processing CSS color rule: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitColor(ctx);
        }
    }

    @Override
    public ASTNode visitLength(HTMLCSSJINJA_parser.LengthContext ctx) {
        try {
            if (ctx.CSS_LENGTH_PROPERTY() != null && ctx.css_value() != null) {
                String property = ctx.CSS_LENGTH_PROPERTY().getText();
                List<String> values = new ArrayList<>();
                for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                    values.add(valueCtx.getText());
                }
                CssRuleSymbol rule = new CssRuleSymbol(
                        property, CssRuleSymbol.RuleCategory.BOX_MODEL,
                        values,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );
                if (!styleAttrStack.isEmpty()) {
                    StyleAttributeSymbol currentStyle = styleAttrStack.peek();
                    currentStyle.addCssRule(rule);
                    if (!elementStack.isEmpty()) rule.setTargetElement(elementStack.peek());
                }
                symbolTable.addCssRule(rule);
                logInfo("Added CSS length rule: " + property);
            }
            return super.visitLength(ctx);
        } catch (Exception e) {
            addError("Error processing CSS length rule: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitLength(ctx);
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  🔥🔥🔥 JINJA2 - المعدل بشكل صحيح حسب الـ grammar 🔥🔥🔥
    // ═══════════════════════════════════════════════════════════════════

    @Override
    public ASTNode visitJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx) {
        try {
            StringBuilder content = new StringBuilder();
            if (ctx.jinjaExprContent() != null) {
                for (HTMLCSSJINJA_parser.JinjaExprContentContext exprCtx : ctx.jinjaExprContent()) {
                    if (content.length() > 0) content.append(" ");
                    content.append(exprCtx.getText());
                }
            }
            String fullContent = content.toString().trim();

            JinjaNode jinjaNode = new JinjaNode(
                    ctx.getStart().getLine(),
                    JinjaNode.JinjaType.EXPRESSION,
                    fullContent
            );

            JinjaSymbol jinja = new JinjaSymbol(
                    JinjaSymbol.JinjaType.EXPRESSION,
                    fullContent,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) jinja.setParentElement(elementStack.peek());
            symbolTable.addJinjaSymbol(jinja);
            logInfo("Added Jinja expression: {{ " + jinja.getContent() + " }}");

            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;
            ASTNode result = super.visitJinjaExpr(ctx);
            inJinjaContext = previousJinjaContext;
            return jinjaNode;
        } catch (Exception e) {
            addError("Error processing Jinja expression: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitJinjaExpr(ctx);
        }
    }

    @Override
    public ASTNode visitJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx) {
        try {
            StringBuilder content = new StringBuilder();
            if (ctx.jinjaStmtArgument() != null) {
                for (HTMLCSSJINJA_parser.JinjaStmtArgumentContext argCtx : ctx.jinjaStmtArgument()) {
                    if (content.length() > 0) content.append(" ");
                    content.append(argCtx.getText());
                }
            }
            String stmtContent = content.toString().trim();
            String lowerContent = stmtContent.toLowerCase();

            System.out.println("  🔍 visitJinjaStmt: '" + stmtContent + "' at line " + ctx.getStart().getLine());

            // نتعامل مع if و for فقط (وليس endfor/endif)
            if (lowerContent.startsWith("if") && !lowerContent.equals("endif")) {
                symbolTable.incrementIfBlockCount();
                System.out.println("  ✅ Found {% if " + stmtContent + " %} at line " + ctx.getStart().getLine());
            } else if (lowerContent.startsWith("for") && !lowerContent.equals("endfor")) {
                symbolTable.incrementForBlockCount();
                System.out.println("  ✅ Found {% for " + stmtContent + " %} at line " + ctx.getStart().getLine());
            } else if (lowerContent.equals("else")) {
                symbolTable.incrementElseCount();
                System.out.println("  ✅ Found {% else %} at line " + ctx.getStart().getLine());
            } else if (lowerContent.equals("endfor")) {
                symbolTable.incrementEndforCount();
                System.out.println("  ✅ Found {% endfor %} at line " + ctx.getStart().getLine());
            } else if (lowerContent.equals("endif")) {
                symbolTable.incrementEndifCount();
                System.out.println("  ✅ Found {% endif %} at line " + ctx.getStart().getLine());
            }

            JinjaNode.JinjaType type = JinjaNode.JinjaType.STATEMENT;
            if (lowerContent.startsWith("if") && !lowerContent.equals("endif")) {
                type = JinjaNode.JinjaType.IF;
            } else if (lowerContent.startsWith("for") && !lowerContent.equals("endfor")) {
                type = JinjaNode.JinjaType.FOR;
            }

            JinjaNode jinjaNode = new JinjaNode(
                    ctx.getStart().getLine(),
                    type,
                    stmtContent
            );

            JinjaSymbol jinja = new JinjaSymbol(
                    JinjaSymbol.JinjaType.STATEMENT,
                    stmtContent,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) jinja.setParentElement(elementStack.peek());
            symbolTable.addJinjaSymbol(jinja);
            logInfo("Added Jinja statement: {% " + jinja.getContent() + " %}");

            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;
            ASTNode result = super.visitJinjaStmt(ctx);
            inJinjaContext = previousJinjaContext;
            return jinjaNode;
        } catch (Exception e) {
            addError("Error processing Jinja statement: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitJinjaStmt(ctx);
        }
    }

    @Override
    public ASTNode visitJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx) {
        try {
            String condition = extractJinjaCondition(ctx);
            System.out.println("  🔍 visitJinjaIfBlock: 'if " + condition + "' at line " + ctx.getStart().getLine());

            // لا نزيد ifBlockCount هنا لأنها ستزيد في visitJinjaStmt
            // فقط نتأكد من أن endif سيتم اكتشافه في المحتوى

            JinjaBlockNode ifBlock = new JinjaBlockNode(
                    ctx.getStart().getLine(),
                    JinjaBlockNode.BlockType.IF
            );
            ifBlock.addConditionBlock(condition);

            if (ctx.jinjaBlockContent() != null) {
                for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                    ASTNode child = visit(contentCtx);
                    if (child != null) {
                        ifBlock.addContentToLastCondition(child);
                    }
                }
            }

            // البحث عن endif داخل المحتوى - هذه الطريقة مضمونة
            if (ctx.jinjaBlockContent() != null) {
                for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                    String text = contentCtx.getText();
                    if (text.contains("endif")) {
                        symbolTable.incrementEndifCount();
                        System.out.println("  ✅ Found endif inside if block at line " + contentCtx.getStart().getLine());
                    } else if (text.contains("else")) {
                        symbolTable.incrementElseCount();
                        System.out.println("  ✅ Found else inside if block at line " + contentCtx.getStart().getLine());
                    } else if (text.contains("elif")) {
                        System.out.println("  ✅ Found elif inside if block at line " + contentCtx.getStart().getLine());
                    }
                }
            }

            ifBlock.finalizeBlock();

            JinjaBlockSymbol jinjaBlock = JinjaBlockSymbol.createIfBlock(
                    condition,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) jinjaBlock.setParentElement(elementStack.peek());
            symbolTable.addJinjaSymbol(jinjaBlock);

            return ifBlock;
        } catch (Exception e) {
            addError("Error processing Jinja IF block: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitJinjaIfBlock(ctx);
        }
    }

    @Override
    public ASTNode visitJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx) {
        try {
            ForLoopInfo loopInfo = extractForLoopInfo(ctx);
            System.out.println("  🔍 visitJinjaForBlock: 'for " + loopInfo.iterator + " in " + loopInfo.iterable + "' at line " + ctx.getStart().getLine());

            // لا نزيد forBlockCount هنا لأنها ستزيد في visitJinjaStmt
            // فقط نتأكد من أن endfor سيتم اكتشافه في المحتوى

            JinjaBlockNode forBlock = new JinjaBlockNode(
                    ctx.getStart().getLine(),
                    JinjaBlockNode.BlockType.FOR
            );
            String condition = loopInfo.iterator + " in " + loopInfo.iterable;
            forBlock.addConditionBlock(condition);

            if (ctx.jinjaBlockContent() != null) {
                for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                    ASTNode child = visit(contentCtx);
                    if (child != null) {
                        forBlock.addContentToLastCondition(child);
                    }
                }
            }

            // البحث عن endfor داخل المحتوى - هذه الطريقة مضمونة
            if (ctx.jinjaBlockContent() != null) {
                for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                    String text = contentCtx.getText();
                    if (text.contains("endfor")) {
                        symbolTable.incrementEndforCount();
                        System.out.println("  ✅ Found endfor inside for block at line " + contentCtx.getStart().getLine());
                    } else if (text.contains("else")) {
                        symbolTable.incrementElseCount();
                        System.out.println("  ✅ Found else inside for block at line " + contentCtx.getStart().getLine());
                    }
                }
            }

            forBlock.finalizeBlock();

            JinjaBlockSymbol jinjaBlock = JinjaBlockSymbol.createForBlock(
                    loopInfo.iterator,
                    loopInfo.iterable,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );
            if (!elementStack.isEmpty()) jinjaBlock.setParentElement(elementStack.peek());
            symbolTable.addJinjaSymbol(jinjaBlock);

            return forBlock;
        } catch (Exception e) {
            addError("Error processing Jinja FOR block: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitJinjaForBlock(ctx);
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  دوال مساعدة
    // ═══════════════════════════════════════════════════════════════════

    private String extractJinjaCondition(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx) {
        StringBuilder condition = new StringBuilder();
        List<HTMLCSSJINJA_parser.JinjaStmtArgumentContext> arguments = ctx.jinjaStmtArgument();
        if (arguments != null) {
            for (HTMLCSSJINJA_parser.JinjaStmtArgumentContext arg : arguments) {
                if (condition.length() > 0) condition.append(" ");
                condition.append(arg.getText());
            }
        }
        return condition.toString().trim();
    }

    private ForLoopInfo extractForLoopInfo(HTMLCSSJINJA_parser.JinjaForBlockContext ctx) {
        ForLoopInfo info = new ForLoopInfo();
        List<HTMLCSSJINJA_parser.JinjaStmtArgumentContext> arguments = ctx.jinjaStmtArgument();
        if (arguments != null) {
            boolean foundIn = false;
            for (HTMLCSSJINJA_parser.JinjaStmtArgumentContext arg : arguments) {
                String text = arg.getText();
                if ("in".equals(text)) {
                    foundIn = true;
                } else if (!foundIn) {
                    if (info.iterator == null) info.iterator = text;
                    else info.iterator += " " + text;
                } else {
                    if (info.iterable == null) info.iterable = text;
                    else info.iterable += " " + text;
                }
            }
        }
        if (info.iterator != null) info.iterator = info.iterator.trim();
        if (info.iterable != null) info.iterable = info.iterable.trim();
        return info;
    }

    private static class ForLoopInfo {
        String iterator;
        String iterable;
    }

    @Override
    public ASTNode visitText(HTMLCSSJINJA_parser.TextContext ctx) {
        try {
            String text = ctx.TEXT().getText();
            TextNode.TextContext textContext = inJinjaContext ? TextNode.TextContext.JINJA : TextNode.TextContext.HTML;
            if (inStyleContext) textContext = TextNode.TextContext.CSS;

            TextNode textNode = new TextNode(
                    ctx.getStart().getLine(),
                    text,
                    textContext
            );
            return textNode;
        } catch (Exception e) {
            addError("Error processing text: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitText(ctx);
        }
    }

    @Override
    public ASTNode visitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx) {
        logInfo("Found DOCTYPE declaration");
        DoctypeNode doctype = new DoctypeNode(ctx.getStart().getLine());
        return doctype;
    }

    @Override
    public ASTNode visitChildren(org.antlr.v4.runtime.tree.RuleNode node) {
        try {
            return super.visitChildren(node);
        } catch (Exception e) {
            if (node instanceof ParserRuleContext) {
                ParserRuleContext ctx = (ParserRuleContext) node;
                addError("Error visiting children: " + e.getMessage(),
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine());
            }
            return null;
        }
    }

    public void cleanup() {
        while (!elementStack.isEmpty()) elementStack.pop();
        while (!styleAttrStack.isEmpty()) styleAttrStack.pop();
        while (!jinjaBlockStack.isEmpty()) jinjaBlockStack.pop();
        symbolTable.closeAllScopes();
        logInfo("Cleanup completed. Open scopes: " + symbolTable.getScopeDepth());
    }
}




























//
//
//package VISITORJINJA;
//
//import AST_HTMLCSSJINJA.*;
//import VISITORJINJA.ST.*;
//import antlrJinja.HTMLCSSJINJA_parser;
//import antlrJinja.HTMLCSSJINJA_parserBaseVisitor;
//import org.antlr.v4.runtime.ParserRuleContext;
//
//import java.util.*;
//
//public class VisitorJinjaSymbolTable extends HTMLCSSJINJA_parserBaseVisitor<ASTNode> {
//
//    private HtmlCssJinjaSymbolTable symbolTable;
//    private Stack<HtmlElementSymbol> elementStack;
//    private Stack<StyleAttributeSymbol> styleAttrStack;
//    private Stack<JinjaBlockSymbol> jinjaBlockStack;
//    private boolean inJinjaContext;
//    private boolean inStyleContext;
//    private List<String> errors;
//    private List<String> warnings;
//
//    public VisitorJinjaSymbolTable() {
//        this.symbolTable = new HtmlCssJinjaSymbolTable();
//        this.elementStack = new Stack<>();
//        this.styleAttrStack = new Stack<>();
//        this.jinjaBlockStack = new Stack<>();
//        this.inJinjaContext = false;
//        this.inStyleContext = false;
//        this.errors = new ArrayList<>();
//        this.warnings = new ArrayList<>();
//    }
//
//    public VisitorJinjaSymbolTable(VisitorJinja originalVisitor) {
//        this();
//    }
//
//    public HtmlCssJinjaSymbolTable getSymbolTable() {
//        return symbolTable;
//    }
//
//    public List<String> getErrors() {
//        return new ArrayList<>(errors);
//    }
//
//    public List<String> getWarnings() {
//        return new ArrayList<>(warnings);
//    }
//
//    public boolean hasErrors() {
//        return !errors.isEmpty();
//    }
//
//    public void printStatistics() {
//        symbolTable.printStatistics();
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  المستند والعناصر الأساسية
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitDocumentLabel(HTMLCSSJINJA_parser.DocumentLabelContext ctx) {
//        DocumentNode doc = new DocumentNode(ctx.getStart().getLine());
//        for (var htmlCtx : ctx.html()) {
//            ASTNode child = visit(htmlCtx);
//            if (child != null) doc.addChild(child);
//        }
//        return doc;
//    }
//
//    @Override
//    public ASTNode visitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx) {
//        return new DoctypeNode(ctx.getStart().getLine());
//    }
//
//    @Override
//    public ASTNode visitHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx) {
//        HtmlElementNode html = new HtmlElementNode(ctx.getStart().getLine(), "html", HtmlElementNode.ElementType.HTML);
//        for (var attrCtx : ctx.attruputehtml()) {
//            ASTNode child = visit(attrCtx);
//            if (child != null) html.addChild(child);
//        }
//        for (var contentCtx : ctx.contenthtml()) {
//            ASTNode child = visit(contentCtx);
//            if (child != null) html.addChild(child);
//        }
//        return html;
//    }
//
//    @Override
//    public ASTNode visitHead(HTMLCSSJINJA_parser.HeadContext ctx) {
//        HtmlElementNode head = new HtmlElementNode(ctx.getStart().getLine(), "head", HtmlElementNode.ElementType.HEAD);
//        for (var contentCtx : ctx.contenthead()) {
//            ASTNode child = visit(contentCtx);
//            if (child != null) head.addChild(child);
//        }
//        return head;
//    }
//
//    @Override
//    public ASTNode visitBody(HTMLCSSJINJA_parser.BodyContext ctx) {
//        HtmlElementNode body = new HtmlElementNode(ctx.getStart().getLine(), "body", HtmlElementNode.ElementType.BODY);
//        if (ctx.attributebody() != null) {
//            for (var attrCtx : ctx.attributebody()) {
//                ASTNode attr = visit(attrCtx);
//                if (attr != null) body.addChild(attr);
//            }
//        }
//        if (ctx.contentbody() != null) {
//            for (var contentCtx : ctx.contentbody()) {
//                ASTNode child = visit(contentCtx);
//                if (child != null) body.addChild(child);
//            }
//        }
//        return body;
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  السمات العادية
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitAttributehead(HTMLCSSJINJA_parser.AttributeheadContext ctx) {
//        String name = ctx.attributenamehead().getText();
//        String value = ctx.ATTRIBUTE_VALUE().getText();
//        if (value.startsWith("\"") && value.endsWith("\"")) {
//            value = value.substring(1, value.length() - 1);
//        }
//        return new AttributeNode(ctx.getStart().getLine(), name, value, AttributeNode.AttributeType.NORMAL);
//    }
//
//    // 🔥🔥🔥 هاتين الدالتين مهمتين جداً لسمة style 🔥🔥🔥
//    @Override
//    public ASTNode visitAttribute_stylelabel(HTMLCSSJINJA_parser.Attribute_stylelabelContext ctx) {
//        return visit(ctx.attribute_style());
//    }
//
//    @Override
//    public ASTNode visitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx) {
//        String name = ctx.attributenamebody().getText();
//        String value = ctx.ATTRIBUTE_VALUE().getText();
//        if (value.startsWith("\"") && value.endsWith("\"")) {
//            value = value.substring(1, value.length() - 1);
//        }
//        return new AttributeNode(ctx.getStart().getLine(), name, value, AttributeNode.AttributeType.NORMAL);
//    }
//
//    @Override
//    public ASTNode visitAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx) {
//        String name = ctx.attributenamebodywithoutvalue().getText();
//        return new AttributeNode(ctx.getStart().getLine(), name, null, AttributeNode.AttributeType.WITHOUT_VALUE);
//    }
//
//    @Override
//    public ASTNode visitLangAttributeLabel(HTMLCSSJINJA_parser.LangAttributeLabelContext ctx) {
//        String value = ctx.VALUE_LANG_AR() != null ? ctx.VALUE_LANG_AR().getText() : ctx.VALUE_LANG_EN().getText();
//        if (value.startsWith("\"") && value.endsWith("\"")) {
//            value = value.substring(1, value.length() - 1);
//        }
//        return new AttributeNode(ctx.getStart().getLine(), "lang", value, AttributeNode.AttributeType.LANG);
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  عناصر HTML العادية
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx) {
//        String tagName = ctx.tagsheadnormal(0).getText();
//        HtmlElementNode element = new HtmlElementNode(ctx.getStart().getLine(), tagName, HtmlElementNode.ElementType.NORMAL);
//        if (ctx.attributehead() != null) {
//            for (var attrCtx : ctx.attributehead()) {
//                ASTNode attr = visit(attrCtx);
//                if (attr != null) element.addChild(attr);
//            }
//        }
//        if (ctx.text() != null) {
//            for (var textCtx : ctx.text()) {
//                ASTNode text = visit(textCtx);
//                if (text != null) element.addChild(text);
//            }
//        }
//        return element;
//    }
//
//    @Override
//    public ASTNode visitSelfclostaglabel(HTMLCSSJINJA_parser.SelfclostaglabelContext ctx) {
//        String tagName = ctx.tagsheadself().getText();
//        HtmlElementNode element = new HtmlElementNode(ctx.getStart().getLine(), tagName, HtmlElementNode.ElementType.SELF_CLOSING);
//        if (ctx.attributehead() != null) {
//            for (var attrCtx : ctx.attributehead()) {
//                ASTNode attr = visit(attrCtx);
//                if (attr != null) element.addChild(attr);
//            }
//        }
//        return element;
//    }
//
//    @Override
//    public ASTNode visitNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx) {
//        String tagName = ctx.tagsbodynamenormal(0).getText();
//        HtmlElementNode element = new HtmlElementNode(ctx.getStart().getLine(), tagName, HtmlElementNode.ElementType.NORMAL);
//        if (ctx.attributebody() != null) {
//            for (var attrCtx : ctx.attributebody()) {
//                ASTNode attr = visit(attrCtx);
//                if (attr != null) element.addChild(attr);
//            }
//        }
//        if (ctx.contentbody() != null) {
//            for (var contentCtx : ctx.contentbody()) {
//                ASTNode child = visit(contentCtx);
//                if (child != null) element.addChild(child);
//            }
//        }
//        return element;
//    }
//
//    @Override
//    public ASTNode visitSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx) {
//        String tagName = ctx.tagsbodynameself().getText();
//        HtmlElementNode element = new HtmlElementNode(ctx.getStart().getLine(), tagName, HtmlElementNode.ElementType.SELF_CLOSING);
//        if (ctx.attributebody() != null) {
//            for (var attrCtx : ctx.attributebody()) {
//                ASTNode attr = visit(attrCtx);
//                if (attr != null) element.addChild(attr);
//            }
//        }
//        return element;
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  🔥🔥🔥 CSS Styles 🔥🔥🔥
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx) {
//        StyleAttributeNode styleAttrNode = new StyleAttributeNode(ctx.getStart().getLine());
//
//        if (ctx.stylename() != null) {
//            for (var styleCtx : ctx.stylename()) {
//                ASTNode ruleNode = visit(styleCtx);
//                if (ruleNode instanceof CssRuleNode) {
//                    styleAttrNode.addCssRule((CssRuleNode) ruleNode);
//                }
//            }
//        }
//
//        return styleAttrNode;
//    }
//
//    @Override
//    public ASTNode visitColor(HTMLCSSJINJA_parser.ColorContext ctx) {
//        String property = ctx.CSS_ATTR_COLOR().getText();
//        String value = ctx.CSS_COLOR_VALUE().getText();
//        return new CssRuleNode(ctx.getStart().getLine(), property, value, CssRuleNode.RuleType.COLOR);
//    }
//
//    @Override
//    public ASTNode visitLength(HTMLCSSJINJA_parser.LengthContext ctx) {
//        String property = ctx.CSS_LENGTH_PROPERTY().getText();
//        StringBuilder value = new StringBuilder();
//        for (var valCtx : ctx.css_value()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(valCtx.getText());
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value.toString(), CssRuleNode.RuleType.LENGTH);
//    }
//
//    @Override
//    public ASTNode visitBorder(HTMLCSSJINJA_parser.BorderContext ctx) {
//        String property = ctx.CSS_BORDER_PROPERTY().getText();
//        StringBuilder value = new StringBuilder();
//        for (var valCtx : ctx.css_value()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(valCtx.getText());
//        }
//        for (var colorNode : ctx.CSS_COLOR_VALUE()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(colorNode.getText());
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value.toString(), CssRuleNode.RuleType.BORDER);
//    }
//
//    @Override
//    public ASTNode visitFont(HTMLCSSJINJA_parser.FontContext ctx) {
//        String property = ctx.CSS_FONT_PROPERTY().getText();
//        String value;
//        if (ctx.CSS_FONT_VALUE() != null) {
//            value = ctx.CSS_FONT_VALUE().getText();
//        } else {
//            value = ctx.css_value().getText();
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value, CssRuleNode.RuleType.FONT);
//    }
//
//    @Override
//    public ASTNode visitTextcss(HTMLCSSJINJA_parser.TextcssContext ctx) {
//        String property = ctx.CSS_TEXT_PROPERTY().getText();
//        String value = ctx.css_value().getText();
//        return new CssRuleNode(ctx.getStart().getLine(), property, value, CssRuleNode.RuleType.TEXT);
//    }
//
//    @Override
//    public ASTNode visitEffect(HTMLCSSJINJA_parser.EffectContext ctx) {
//        String property = ctx.CSS_EFFECT_PROPERTY().getText();
//        StringBuilder value = new StringBuilder();
//        for (var valCtx : ctx.css_value()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(valCtx.getText());
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value.toString(), CssRuleNode.RuleType.EFFECT);
//    }
//
//    @Override
//    public ASTNode visitLayout(HTMLCSSJINJA_parser.LayoutContext ctx) {
//        String property = ctx.CSS_LAYOUT_PROPERTY().getText();
//        StringBuilder value = new StringBuilder();
//        for (var valCtx : ctx.css_value()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(valCtx.getText());
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value.toString(), CssRuleNode.RuleType.LAYOUT);
//    }
//
//    @Override
//    public ASTNode visitPosition(HTMLCSSJINJA_parser.PositionContext ctx) {
//        String property = ctx.CSS_POSITION_PROPERTY().getText();
//        StringBuilder value = new StringBuilder();
//        for (var valCtx : ctx.css_value()) {
//            if (value.length() > 0) value.append(" ");
//            value.append(valCtx.getText());
//        }
//        return new CssRuleNode(ctx.getStart().getLine(), property, value.toString(), CssRuleNode.RuleType.POSITION);
//    }
//
//    @Override
//    public ASTNode visitOffset(HTMLCSSJINJA_parser.OffsetContext ctx) {
//        String property = ctx.CSS_OFFSET_PROPERTY().getText();
//        String value = ctx.css_value().getText();
//        return new CssRuleNode(ctx.getStart().getLine(), property, value, CssRuleNode.RuleType.OFFSET);
//    }
//
//    @Override
//    public ASTNode visitBorder_style(HTMLCSSJINJA_parser.Border_styleContext ctx) {
//        return new CssRuleNode(ctx.getStart().getLine(),
//                ctx.CSS_BORDER_STYLE_PROPERTY().getText(),
//                ctx.CSS_BORDER_STYLE_VALUE().getText(),
//                CssRuleNode.RuleType.BORDER_STYLE);
//    }
//
//    @Override
//    public ASTNode visitBorder_width(HTMLCSSJINJA_parser.Border_widthContext ctx) {
//        String value;
//        if (ctx.CSS_BORDER_WIDTH_VALUE() != null) {
//            value = ctx.CSS_BORDER_WIDTH_VALUE().getText();
//        } else {
//            value = ctx.css_value().getText();
//        }
//        return new CssRuleNode(ctx.getStart().getLine(),
//                ctx.CSS_BORDER_WIDTH_PROPERTY().getText(),
//                value,
//                CssRuleNode.RuleType.BORDER_WIDTH);
//    }
//
//    @Override
//    public ASTNode visitRepeat(HTMLCSSJINJA_parser.RepeatContext ctx) {
//        return new CssRuleNode(ctx.getStart().getLine(),
//                ctx.CSS_REPEAT_PROPERTY().getText(),
//                ctx.CSS_REPEAT_VALUE().getText(),
//                CssRuleNode.RuleType.REPEAT);
//    }
//
//    @Override
//    public ASTNode visitUrl(HTMLCSSJINJA_parser.UrlContext ctx) {
//        return new CssRuleNode(ctx.getStart().getLine(),
//                ctx.CSS_URL_PROPERTY().getText(),
//                ctx.CSS_URL_VALUE().getText(),
//                CssRuleNode.RuleType.URL);
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  النصوص
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitTextlabel(HTMLCSSJINJA_parser.TextlabelContext ctx) {
//        return new TextNode(ctx.getStart().getLine(), ctx.TEXT().getText(), TextNode.TextContext.HTML);
//    }
//
//    @Override
//    public ASTNode visitText(HTMLCSSJINJA_parser.TextContext ctx) {
//        return new TextNode(ctx.getStart().getLine(), ctx.TEXT().getText(), TextNode.TextContext.HTML);
//    }
//
//    // ═══════════════════════════════════════════════════════════════════
//    //  🔥🔥🔥 JINJA2 🔥🔥🔥
//    // ═══════════════════════════════════════════════════════════════════
//
//    @Override
//    public ASTNode visitJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx) {
//        StringBuilder content = new StringBuilder();
//        if (ctx.jinjaExprContent() != null) {
//            for (var exprCtx : ctx.jinjaExprContent()) {
//                if (content.length() > 0) content.append(" ");
//                content.append(exprCtx.getText());
//            }
//        }
//        return new JinjaNode(ctx.getStart().getLine(), JinjaNode.JinjaType.EXPRESSION, content.toString().trim());
//    }
//
//    @Override
//    public ASTNode visitJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx) {
//        StringBuilder content = new StringBuilder();
//        if (ctx.jinjaStmtArgument() != null) {
//            for (var argCtx : ctx.jinjaStmtArgument()) {
//                if (content.length() > 0) content.append(" ");
//                content.append(argCtx.getText());
//            }
//        }
//        String stmtContent = content.toString().trim();
//        String lower = stmtContent.toLowerCase();
//
//        if (lower.equals("endfor")) {
//            symbolTable.incrementEndforCount();
//            System.out.println("  ✅ Found endfor at line " + ctx.getStart().getLine());
//        } else if (lower.equals("endif")) {
//            symbolTable.incrementEndifCount();
//            System.out.println("  ✅ Found endif at line " + ctx.getStart().getLine());
//        } else if (lower.equals("else")) {
//            symbolTable.incrementElseCount();
//        } else if (lower.startsWith("if")) {
//            symbolTable.incrementIfBlockCount();
//        } else if (lower.startsWith("for")) {
//            symbolTable.incrementForBlockCount();
//        }
//
//        JinjaNode.JinjaType type = JinjaNode.JinjaType.STATEMENT;
//        if (lower.startsWith("if") && !lower.equals("endif")) {
//            type = JinjaNode.JinjaType.IF;
//        } else if (lower.startsWith("for") && !lower.equals("endfor")) {
//            type = JinjaNode.JinjaType.FOR;
//        }
//
//        return new JinjaNode(ctx.getStart().getLine(), type, stmtContent);
//    }
//
//    @Override
//    public ASTNode visitJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx) {
//        StringBuilder condition = new StringBuilder();
//        if (ctx.jinjaStmtArgument() != null) {
//            for (var argCtx : ctx.jinjaStmtArgument()) {
//                if (condition.length() > 0) condition.append(" ");
//                condition.append(argCtx.getText());
//            }
//        }
//
//        JinjaBlockNode ifBlock = new JinjaBlockNode(ctx.getStart().getLine(), JinjaBlockNode.BlockType.IF);
//        ifBlock.addConditionBlock(condition.toString().trim());
//
//        if (ctx.jinjaBlockContent() != null) {
//            for (var contentCtx : ctx.jinjaBlockContent()) {
//                ASTNode child = visit(contentCtx);
//                if (child != null) {
//                    ifBlock.addContentToLastCondition(child);
//                }
//            }
//        }
//
//        ifBlock.finalizeBlock();
//        return ifBlock;
//    }
//
//    @Override
//    public ASTNode visitJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx) {
//        StringBuilder loopExpr = new StringBuilder();
//        if (ctx.jinjaStmtArgument() != null) {
//            for (var argCtx : ctx.jinjaStmtArgument()) {
//                if (loopExpr.length() > 0) loopExpr.append(" ");
//                loopExpr.append(argCtx.getText());
//            }
//        }
//
//        JinjaBlockNode forBlock = new JinjaBlockNode(ctx.getStart().getLine(), JinjaBlockNode.BlockType.FOR);
//        forBlock.addConditionBlock(loopExpr.toString().trim());
//
//        if (ctx.jinjaBlockContent() != null) {
//            for (var contentCtx : ctx.jinjaBlockContent()) {
//                ASTNode child = visit(contentCtx);
//                if (child != null) {
//                    forBlock.addContentToLastCondition(child);
//                }
//            }
//        }
//
//        forBlock.finalizeBlock();
//        return forBlock;
//    }
//
//    @Override
//    public ASTNode visitJinjaTextLabel(HTMLCSSJINJA_parser.JinjaTextLabelContext ctx) {
//        return new TextNode(ctx.getStart().getLine(), ctx.TEXT().getText(), TextNode.TextContext.JINJA);
//    }
//
//    @Override
//    public ASTNode visitChildren(org.antlr.v4.runtime.tree.RuleNode node) {
//        try {
//            return super.visitChildren(node);
//        } catch (Exception e) {
//            if (node instanceof ParserRuleContext) {
//                ParserRuleContext ctx = (ParserRuleContext) node;
//                errors.add("Error: " + e.getMessage() + " at line " + ctx.getStart().getLine());
//            }
//            return null;
//        }
//    }
//
//    public void cleanup() {
//        // تنظيف
//    }
//}