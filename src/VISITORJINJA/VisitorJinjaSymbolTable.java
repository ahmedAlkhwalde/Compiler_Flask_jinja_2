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
            HtmlElementSymbol.ElementCategory category =
                    HtmlElementSymbol.getCategoryFromTag(tagName);

            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName,
                    category,
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
            HtmlElementSymbol.ElementCategory category =
                    HtmlElementSymbol.getCategoryFromTag(tagName);
            boolean isSelfClosing = HtmlElementSymbol.isSelfClosingTag(tagName);

            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName,
                    category,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    !isSelfClosing
            );

            if (inJinjaContext) {
                element.setInJinjaContext(true);
            }

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
            HtmlElementSymbol.ElementCategory category =
                    HtmlElementSymbol.getCategoryFromTag(tagName);

            HtmlElementSymbol element = new HtmlElementSymbol(
                    tagName,
                    category,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    false
            );


            if (inJinjaContext) {
                element.setInJinjaContext(true);
            }

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



    @Override
    public ASTNode visitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx) {
        try {
            String attrName = ctx.attributenamebody().getText();
            String attrValue = ctx.ATTRIBUTE_VALUE().getText();

            HtmlAttributeSymbol.AttributeType attrType =
                    HtmlAttributeSymbol.inferAttributeType(attrName);

            HtmlAttributeSymbol attribute = new HtmlAttributeSymbol(
                    attrName,
                    attrType,
                    attrValue,
                    true,
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
            logInfo("Added attribute: " + attrName + "=\"" +
                    attribute.getValueWithoutQuotes() + "\"");

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
            HtmlAttributeSymbol.AttributeType attrType =
                    HtmlAttributeSymbol.inferAttributeType(attrName);

            HtmlAttributeSymbol attribute = new HtmlAttributeSymbol(
                    attrName,
                    attrType,
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
                        property,
                        CssRuleSymbol.RuleCategory.COLOR,
                        Collections.singletonList(value),
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );


                if (!styleAttrStack.isEmpty()) {
                    StyleAttributeSymbol currentStyle = styleAttrStack.peek();
                    currentStyle.addCssRule(rule);


                    if (!elementStack.isEmpty()) {
                        rule.setTargetElement(elementStack.peek());
                    }
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
                        property,
                        CssRuleSymbol.RuleCategory.BOX_MODEL,
                        values,
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine()
                );


                if (!styleAttrStack.isEmpty()) {
                    StyleAttributeSymbol currentStyle = styleAttrStack.peek();
                    currentStyle.addCssRule(rule);


                    if (!elementStack.isEmpty()) {
                        rule.setTargetElement(elementStack.peek());
                    }
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

            JinjaSymbol jinja = new JinjaSymbol(
                    JinjaSymbol.JinjaType.EXPRESSION,
                    content.toString().trim(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            if (!elementStack.isEmpty()) {
                jinja.setParentElement(elementStack.peek());
            }

            symbolTable.addJinjaSymbol(jinja);
            logInfo("Added Jinja expression: {{ " + jinja.getContent() + " }}");

            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;

            ASTNode result = super.visitJinjaExpr(ctx);

            inJinjaContext = previousJinjaContext;

            return result;
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

            JinjaSymbol jinja = new JinjaSymbol(
                    JinjaSymbol.JinjaType.STATEMENT,
                    content.toString().trim(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            if (jinja.isControlStructure()) {
                logInfo("Found Jinja control structure: {% " + jinja.getContent() + " %}");
            }

            if (!elementStack.isEmpty()) {
                jinja.setParentElement(elementStack.peek());
            }

            symbolTable.addJinjaSymbol(jinja);

            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;

            ASTNode result = super.visitJinjaStmt(ctx);

            inJinjaContext = previousJinjaContext;

            return result;
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

            JinjaBlockSymbol ifBlock = JinjaBlockSymbol.createIfBlock(
                    condition,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            if (!elementStack.isEmpty()) {
                ifBlock.setParentElement(elementStack.peek());
            }

            symbolTable.enterScope("jinja_if_" + condition.hashCode(),
                    SymbolScope.ScopeType.JINJA_IF);
            jinjaBlockStack.push(ifBlock);
            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;

            super.visitJinjaIfBlock(ctx);

            symbolTable.closeJinjaBlock();
            jinjaBlockStack.pop();
            inJinjaContext = previousJinjaContext;

            symbolTable.addJinjaSymbol(ifBlock);
            logInfo("Added Jinja IF block with condition: " + condition);

            return null;
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

            JinjaBlockSymbol forBlock = JinjaBlockSymbol.createForBlock(
                    loopInfo.iterator,
                    loopInfo.iterable,
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine()
            );

            if (!elementStack.isEmpty()) {
                forBlock.setParentElement(elementStack.peek());
            }

            symbolTable.enterScope("jinja_for_" + loopInfo.iterator,
                    SymbolScope.ScopeType.JINJA_FOR);
            jinjaBlockStack.push(forBlock);
            boolean previousJinjaContext = inJinjaContext;
            inJinjaContext = true;

            super.visitJinjaForBlock(ctx);

            symbolTable.closeJinjaBlock();
            jinjaBlockStack.pop();
            inJinjaContext = previousJinjaContext;

            symbolTable.addJinjaSymbol(forBlock);
            logInfo("Added Jinja FOR block: " + loopInfo.iterator + " in " + loopInfo.iterable);

            return null;
        } catch (Exception e) {
            addError("Error processing Jinja FOR block: " + e.getMessage(),
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine());
            return super.visitJinjaForBlock(ctx);
        }
    }


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
                    if (info.iterator == null) {
                        info.iterator = text;
                    } else {
                        info.iterator += " " + text;
                    }
                } else {
                    if (info.iterable == null) {
                        info.iterable = text;
                    } else {
                        info.iterable += " " + text;
                    }
                }
            }
        }

        return info;
    }


    private static class ForLoopInfo {
        String iterator;
        String iterable;
    }

    @Override
    public ASTNode visitText(HTMLCSSJINJA_parser.TextContext ctx) {

        return super.visitText(ctx);
    }

    @Override
    public ASTNode visitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx) {
        logInfo("Found DOCTYPE declaration");
        return super.visitDoctipe(ctx);
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
        while (!elementStack.isEmpty()) {
            elementStack.pop();
        }
        while (!styleAttrStack.isEmpty()) {
            styleAttrStack.pop();
        }
        while (!jinjaBlockStack.isEmpty()) {
            jinjaBlockStack.pop();
        }


        symbolTable.closeAllScopes();

        logInfo("Cleanup completed. Open scopes: " + symbolTable.getScopeDepth());
    }
}