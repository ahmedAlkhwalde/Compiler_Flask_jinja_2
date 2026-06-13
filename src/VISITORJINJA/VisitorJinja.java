package VISITORJINJA;
import AST_HTMLCSSJINJA.*;
import antlrJinja.HTMLCSSJINJA_parser;
import antlrJinja.HTMLCSSJINJA_parserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class VisitorJinja extends HTMLCSSJINJA_parserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitDocumentLabel(HTMLCSSJINJA_parser.DocumentLabelContext ctx) {
        DocumentNode document = new DocumentNode(ctx.getStart().getLine());
        for (HTMLCSSJINJA_parser.HtmlContext htmlCtx : ctx.html()) {
            ASTNode childNode = visit(htmlCtx);
            if (childNode != null) {
                document.addChild(childNode);
            }
        }

        return document;
    }

    @Override
    public ASTNode visitHtmlelementlabel(HTMLCSSJINJA_parser.HtmlelementlabelContext ctx) {
        return visit(ctx.htmlelement());
    }

    @Override
    public ASTNode visitDoctipelabel(HTMLCSSJINJA_parser.DoctipelabelContext ctx) {
        return new DoctypeNode(ctx.getStart().getLine());
    }

    @Override
    public ASTNode visitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx) {
        return new DoctypeNode(ctx.getStart().getLine());
    }

    @Override
    public ASTNode visitHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx) {
        HtmlElementNode htmlElement = new HtmlElementNode(
                ctx.getStart().getLine(),
                "html",
                HtmlElementNode.ElementType.HTML
        );
        for (HTMLCSSJINJA_parser.AttruputehtmlContext attrCtx : ctx.attruputehtml()) {
            ASTNode attrNode = visit(attrCtx);
            if (attrNode != null) {
                htmlElement.addChild(attrNode);
            }
        }
        for (HTMLCSSJINJA_parser.ContenthtmlContext contentCtx : ctx.contenthtml()) {
            ASTNode contentNode = visit(contentCtx);
            if (contentNode != null) {
                htmlElement.addChild(contentNode);
            }
        }

        return htmlElement;
    }

    @Override
    public ASTNode visitLangAttributeLabel(HTMLCSSJINJA_parser.LangAttributeLabelContext ctx) {
        String value = "";
        if (ctx.VALUE_LANG_EN() != null) {
            value = ctx.VALUE_LANG_EN().getText();
        } else if (ctx.VALUE_LANG_AR() != null) {
            value = ctx.VALUE_LANG_AR().getText();
        }
        if (value.length() >= 2) {
            value = value.substring(1, value.length() - 1);
        }

        return new AttributeNode(
                ctx.getStart().getLine(),
                "lang",
                value,
                AttributeNode.AttributeType.LANG
        );
    }

    @Override
    public ASTNode visitHeadlabel(HTMLCSSJINJA_parser.HeadlabelContext ctx) {
        return visit(ctx.head());
    }

    @Override
    public ASTNode visitBodylabel(HTMLCSSJINJA_parser.BodylabelContext ctx) {
        return visit(ctx.body());
    }

    @Override
    public ASTNode visitHead(HTMLCSSJINJA_parser.HeadContext ctx) {
        HtmlElementNode headElement = new HtmlElementNode(
                ctx.getStart().getLine(),
                "head",
                HtmlElementNode.ElementType.HEAD
        );

        for (HTMLCSSJINJA_parser.ContentheadContext contentCtx : ctx.contenthead()) {
            ASTNode childNode = visit(contentCtx);
            if (childNode != null) {
                headElement.addChild(childNode);
            }
        }

        return headElement;
    }

    @Override
    public ASTNode visitBody(HTMLCSSJINJA_parser.BodyContext ctx) {
        HtmlElementNode bodyElement = new HtmlElementNode(
                ctx.getStart().getLine(),
                "body",
                HtmlElementNode.ElementType.BODY
        );

        if (ctx.attributebody() != null) {
            for (HTMLCSSJINJA_parser.AttributebodyContext attrCtx : ctx.attributebody()) {
                ASTNode attrNode = visit(attrCtx);
                if (attrNode != null) {
                    bodyElement.addChild(attrNode);
                }
            }
        }
        if (ctx.contentbody() != null) {
            for (HTMLCSSJINJA_parser.ContentbodyContext contentCtx : ctx.contentbody()) {
                ASTNode childNode = visit(contentCtx);
                if (childNode != null) {
                    bodyElement.addChild(childNode);
                }
            }
        }

        return bodyElement;
    }

    @Override
    public ASTNode visitNormalTagElementheadlabel(HTMLCSSJINJA_parser.NormalTagElementheadlabelContext ctx) {
        return visit(ctx.normalTagElementhead());
    }

    @Override
    public ASTNode visitSelfClosingTagElementheadlabel(HTMLCSSJINJA_parser.SelfClosingTagElementheadlabelContext ctx) {
        return visit(ctx.selfClosingTagElementhead());
    }

    @Override
    public ASTNode visitNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx) {
        String tagName = ctx.tagsheadnormal(0).getText();

        HtmlElementNode element = new HtmlElementNode(
                ctx.getStart().getLine(),
                tagName,
                HtmlElementNode.ElementType.NORMAL
        );

        if (ctx.attributehead() != null) {
            for (HTMLCSSJINJA_parser.AttributeheadContext attrCtx : ctx.attributehead()) {
                ASTNode attrNode = visit(attrCtx);
                if (attrNode != null) {
                    element.addChild(attrNode);
                }
            }
        }
        if (ctx.text() != null) {
            for (HTMLCSSJINJA_parser.TextContext textCtx : ctx.text()) {
                ASTNode textNode = visit(textCtx);
                if (textNode != null) {
                    element.addChild(textNode);
                }
            }
        }

        return element;
    }

    @Override
    public ASTNode visitSelfclostaglabel(HTMLCSSJINJA_parser.SelfclostaglabelContext ctx) {
        String tagName = ctx.tagsheadself().getText();
        HtmlElementNode element = new HtmlElementNode(
                ctx.getStart().getLine(),
                tagName,
                HtmlElementNode.ElementType.SELF_CLOSING
        );

        if (ctx.attributehead() != null) {
            for (HTMLCSSJINJA_parser.AttributeheadContext attrCtx : ctx.attributehead()) {
                ASTNode attrNode = visit(attrCtx);
                if (attrNode != null) {
                    element.addChild(attrNode);
                }
            }
        }

        return element;
    }

    @Override
    public ASTNode visitNormalTagElementbodylabel(HTMLCSSJINJA_parser.NormalTagElementbodylabelContext ctx) {
        return visit(ctx.normalTagElementbody());
    }

    @Override
    public ASTNode visitSelfClosingTagElementbodylabel(HTMLCSSJINJA_parser.SelfClosingTagElementbodylabelContext ctx) {
        return visit(ctx.selfClosingTagElementbody());
    }

    @Override
    public ASTNode visitTextlabel(HTMLCSSJINJA_parser.TextlabelContext ctx) {
        return new TextNode(
                ctx.getStart().getLine(),
                ctx.TEXT().getText(),
                TextNode.TextContext.HTML
        );
    }

    @Override
    public ASTNode visitNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx) {
        String tagName = ctx.tagsbodynamenormal(0).getText();

        HtmlElementNode element = new HtmlElementNode(
                ctx.getStart().getLine(),
                tagName,
                HtmlElementNode.ElementType.NORMAL
        );

        if (ctx.attributebody() != null) {
            for (HTMLCSSJINJA_parser.AttributebodyContext attrCtx : ctx.attributebody()) {
                ASTNode attrNode = visit(attrCtx);
                if (attrNode != null) {
                    element.addChild(attrNode);
                }
            }
        }

        if (ctx.contentbody() != null) {
            for (HTMLCSSJINJA_parser.ContentbodyContext contentCtx : ctx.contentbody()) {
                ASTNode childNode = visit(contentCtx);
                if (childNode != null) {
                    element.addChild(childNode);
                }
            }
        }

        return element;
    }

    @Override
    public ASTNode visitSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx) {
        String tagName = ctx.tagsbodynameself().getText();
        HtmlElementNode element = new HtmlElementNode(
                ctx.getStart().getLine(),
                tagName,
                HtmlElementNode.ElementType.SELF_CLOSING
        );


        if (ctx.attributebody() != null) {
            for (HTMLCSSJINJA_parser.AttributebodyContext attrCtx : ctx.attributebody()) {
                ASTNode attrNode = visit(attrCtx);
                if (attrNode != null) {
                    element.addChild(attrNode);
                }
            }
        }

        return element;
    }

    @Override
    public ASTNode visitAttribute_stylelabel(HTMLCSSJINJA_parser.Attribute_stylelabelContext ctx) {
        return visit(ctx.attribute_style());
    }

    @Override
    public ASTNode visitStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx) {
        StyleAttributeNode styleAttr = new StyleAttributeNode(ctx.getStart().getLine());

        if (ctx.stylename() != null) {
            for (HTMLCSSJINJA_parser.StylenameContext styleCtx : ctx.stylename()) {
                ASTNode ruleNode = visit(styleCtx);
                if (ruleNode instanceof CssRuleNode) {
                    styleAttr.addCssRule((CssRuleNode) ruleNode);
                }
            }
        }

        return styleAttr;
    }

    @Override
    public ASTNode visitColorLabel(HTMLCSSJINJA_parser.ColorLabelContext ctx) {
        return visit(ctx.color());
    }

    @Override
    public ASTNode visitLengthLabel(HTMLCSSJINJA_parser.LengthLabelContext ctx) {
        return visit(ctx.length());
    }

    @Override
    public ASTNode visitUrlLabel(HTMLCSSJINJA_parser.UrlLabelContext ctx) {
        return visit(ctx.url());
    }

    @Override
    public ASTNode visitRepeatLabel(HTMLCSSJINJA_parser.RepeatLabelContext ctx) {
        return visit(ctx.repeat());
    }

    @Override
    public ASTNode visitPositionLabel(HTMLCSSJINJA_parser.PositionLabelContext ctx) {
        return visit(ctx.position());
    }

    @Override
    public ASTNode visitBorderStyleLabel(HTMLCSSJINJA_parser.BorderStyleLabelContext ctx) {
        return visit(ctx.border_style());
    }

    @Override
    public ASTNode visitBorderWidthLabel(HTMLCSSJINJA_parser.BorderWidthLabelContext ctx) {
        return visit(ctx.border_width());
    }

    @Override
    public ASTNode visitBorderLabel(HTMLCSSJINJA_parser.BorderLabelContext ctx) {
        return visit(ctx.border());
    }

    @Override
    public ASTNode visitFontLabel(HTMLCSSJINJA_parser.FontLabelContext ctx) {
        return visit(ctx.font());
    }

    @Override
    public ASTNode visitTextCssLabel(HTMLCSSJINJA_parser.TextCssLabelContext ctx) {
        return visit(ctx.textcss());
    }

    @Override
    public ASTNode visitEffectLabel(HTMLCSSJINJA_parser.EffectLabelContext ctx) {
        return visit(ctx.effect());
    }

    @Override
    public ASTNode visitLayoutLabel(HTMLCSSJINJA_parser.LayoutLabelContext ctx) {
        return visit(ctx.layout());
    }

    @Override
    public ASTNode visitOffsetLabel(HTMLCSSJINJA_parser.OffsetLabelContext ctx) {
        return visit(ctx.offset());
    }

    @Override
    public ASTNode visitColor(HTMLCSSJINJA_parser.ColorContext ctx) {
        if (ctx.CSS_ATTR_COLOR() != null && ctx.CSS_COLOR_VALUE() != null) {
            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_ATTR_COLOR().getText(),
                    ctx.CSS_COLOR_VALUE().getText(),
                    CssRuleNode.RuleType.COLOR
            );
        }
        return null;
    }

    @Override
    public ASTNode visitLength(HTMLCSSJINJA_parser.LengthContext ctx) {
        if (ctx.CSS_LENGTH_PROPERTY() != null && ctx.css_value() != null) {
            StringBuilder valueBuilder = new StringBuilder();
            for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                if (valueBuilder.length() > 0) valueBuilder.append(" ");
                valueBuilder.append(valueCtx.getText());
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_LENGTH_PROPERTY().getText(),
                    valueBuilder.toString(),
                    CssRuleNode.RuleType.LENGTH
            );
        }
        return null;
    }

    @Override
    public ASTNode visitUrl(HTMLCSSJINJA_parser.UrlContext ctx) {
        if (ctx.CSS_URL_PROPERTY() != null && ctx.CSS_URL_VALUE() != null) {
            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_URL_PROPERTY().getText(),
                    ctx.CSS_URL_VALUE().getText(),
                    CssRuleNode.RuleType.URL
            );
        }
        return null;
    }

    @Override
    public ASTNode visitRepeat(HTMLCSSJINJA_parser.RepeatContext ctx) {
        if (ctx.CSS_REPEAT_PROPERTY() != null && ctx.CSS_REPEAT_VALUE() != null) {
            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_REPEAT_PROPERTY().getText(),
                    ctx.CSS_REPEAT_VALUE().getText(),
                    CssRuleNode.RuleType.REPEAT
            );
        }
        return null;
    }

    @Override
    public ASTNode visitPosition(HTMLCSSJINJA_parser.PositionContext ctx) {
        if (ctx.CSS_POSITION_PROPERTY() != null && ctx.css_value() != null) {
            StringBuilder valueBuilder = new StringBuilder();
            for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                if (valueBuilder.length() > 0) valueBuilder.append(" ");
                valueBuilder.append(valueCtx.getText());
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_POSITION_PROPERTY().getText(),
                    valueBuilder.toString(),
                    CssRuleNode.RuleType.POSITION
            );
        }
        return null;
    }

    @Override
    public ASTNode visitOffset(HTMLCSSJINJA_parser.OffsetContext ctx) {
        if (ctx.CSS_OFFSET_PROPERTY() != null && ctx.css_value() != null) {
            String value = ctx.css_value().getText();

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_OFFSET_PROPERTY().getText(),
                    value,
                    CssRuleNode.RuleType.OFFSET
            );
        }
        return null;
    }

    @Override
    public ASTNode visitBorder_style(HTMLCSSJINJA_parser.Border_styleContext ctx) {
        if (ctx.CSS_BORDER_STYLE_PROPERTY() != null && ctx.CSS_BORDER_STYLE_VALUE() != null) {
            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_BORDER_STYLE_PROPERTY().getText(),
                    ctx.CSS_BORDER_STYLE_VALUE().getText(),
                    CssRuleNode.RuleType.BORDER_STYLE
            );
        }
        return null;
    }

    @Override
    public ASTNode visitBorder_width(HTMLCSSJINJA_parser.Border_widthContext ctx) {
        if (ctx.CSS_BORDER_WIDTH_PROPERTY() != null) {
            String value = "";
            if (ctx.CSS_BORDER_WIDTH_VALUE() != null) {
                value = ctx.CSS_BORDER_WIDTH_VALUE().getText();
            } else if (ctx.css_value() != null) {
                value = ctx.css_value().getText();
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_BORDER_WIDTH_PROPERTY().getText(),
                    value,
                    CssRuleNode.RuleType.BORDER_WIDTH
            );
        }
        return null;
    }

    @Override
    public ASTNode visitBorder(HTMLCSSJINJA_parser.BorderContext ctx) {
        if (ctx.CSS_BORDER_PROPERTY() != null) {
            StringBuilder valueBuilder = new StringBuilder();

            if (ctx.css_value() != null) {
                for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                    if (valueBuilder.length() > 0) valueBuilder.append(" ");
                    valueBuilder.append(valueCtx.getText());
                }
            }

            if (ctx.CSS_COLOR_VALUE() != null) {
                for (TerminalNode colorNode : ctx.CSS_COLOR_VALUE()) {
                    if (valueBuilder.length() > 0) valueBuilder.append(" ");
                    valueBuilder.append(colorNode.getText());
                }
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_BORDER_PROPERTY().getText(),
                    valueBuilder.toString(),
                    CssRuleNode.RuleType.BORDER
            );
        }
        return null;
    }

    @Override
    public ASTNode visitFont(HTMLCSSJINJA_parser.FontContext ctx) {
        if (ctx.CSS_FONT_PROPERTY() != null) {
            String value = "";
            if (ctx.CSS_FONT_VALUE() != null) {
                value = ctx.CSS_FONT_VALUE().getText();
            } else if (ctx.css_value() != null) {
                value = ctx.css_value().getText();
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_FONT_PROPERTY().getText(),
                    value,
                    CssRuleNode.RuleType.FONT
            );
        }
        return null;
    }

    @Override
    public ASTNode visitTextcss(HTMLCSSJINJA_parser.TextcssContext ctx) {
        if (ctx.CSS_TEXT_PROPERTY() != null && ctx.css_value() != null) {
            String value = ctx.css_value().getText();

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_TEXT_PROPERTY().getText(),
                    value,
                    CssRuleNode.RuleType.TEXT
            );
        }
        return null;
    }

    @Override
    public ASTNode visitEffect(HTMLCSSJINJA_parser.EffectContext ctx) {
        if (ctx.CSS_EFFECT_PROPERTY() != null && ctx.css_value() != null) {
            StringBuilder valueBuilder = new StringBuilder();
            for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                if (valueBuilder.length() > 0) valueBuilder.append(" ");
                valueBuilder.append(valueCtx.getText());
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_EFFECT_PROPERTY().getText(),
                    valueBuilder.toString(),
                    CssRuleNode.RuleType.EFFECT
            );
        }
        return null;
    }

    @Override
    public ASTNode visitLayout(HTMLCSSJINJA_parser.LayoutContext ctx) {
        if (ctx.CSS_LAYOUT_PROPERTY() != null && ctx.css_value() != null) {
            StringBuilder valueBuilder = new StringBuilder();
            for (HTMLCSSJINJA_parser.Css_valueContext valueCtx : ctx.css_value()) {
                if (valueBuilder.length() > 0) valueBuilder.append(" ");
                valueBuilder.append(valueCtx.getText());
            }

            return new CssRuleNode(
                    ctx.getStart().getLine(),
                    ctx.CSS_LAYOUT_PROPERTY().getText(),
                    valueBuilder.toString(),
                    CssRuleNode.RuleType.LAYOUT
            );
        }
        return null;
    }

    @Override
    public ASTNode visitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx) {
        String name = ctx.attributenamebody().getText();
        String value = ctx.ATTRIBUTE_VALUE().getText();

        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }

        return new AttributeNode(
                ctx.getStart().getLine(),
                name,
                value,
                AttributeNode.AttributeType.NORMAL
        );
    }

    @Override
    public ASTNode visitAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx) {
        String name = ctx.attributenamebodywithoutvalue().getText();

        return new AttributeNode(
                ctx.getStart().getLine(),
                name,
                null,
                AttributeNode.AttributeType.WITHOUT_VALUE
        );
    }

    @Override
    public ASTNode visitAttributehead(HTMLCSSJINJA_parser.AttributeheadContext ctx) {
        String name = ctx.attributenamehead().getText();
        String value = ctx.ATTRIBUTE_VALUE().getText();

        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }

        return new AttributeNode(
                ctx.getStart().getLine(),
                name,
                value,
                AttributeNode.AttributeType.NORMAL
        );
    }

    @Override
    public ASTNode visitJinjaElementlabel(HTMLCSSJINJA_parser.JinjaElementlabelContext ctx) {
        return visit(ctx.jinjaElement());
    }

    @Override
    public ASTNode visitJinjasecondElementlabel(HTMLCSSJINJA_parser.JinjasecondElementlabelContext ctx) {
        return visit(ctx.jinjaElement());
    }

    @Override
    public ASTNode visitJinjathirdElementlabel(HTMLCSSJINJA_parser.JinjathirdElementlabelContext ctx) {
        return visit(ctx.jinjaElement());
    }

    @Override
    public ASTNode visitJinjaExprlabel(HTMLCSSJINJA_parser.JinjaExprlabelContext ctx) {
        return visit(ctx.jinjaExpr());
    }

    @Override
    public ASTNode visitJinjaStmtlabel(HTMLCSSJINJA_parser.JinjaStmtlabelContext ctx) {
        return visit(ctx.jinjaStmt());
    }


    @Override
    public ASTNode visitJinjaIfBlocklabel(HTMLCSSJINJA_parser.JinjaIfBlocklabelContext ctx) {
        return visit(ctx.jinjaIfBlock());
    }

    @Override
    public ASTNode visitJinjaForBlocklabel(HTMLCSSJINJA_parser.JinjaForBlocklabelContext ctx) {
        return visit(ctx.jinjaForBlock());
    }

    @Override
    public ASTNode visitJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx) {
        StringBuilder content = new StringBuilder();

        if (ctx.jinjaExprContent() != null) {
            for (HTMLCSSJINJA_parser.JinjaExprContentContext exprCtx : ctx.jinjaExprContent()) {
                if (exprCtx.getText() != null) {
                    if (content.length() > 0) content.append(" ");
                    content.append(exprCtx.getText());
                }
            }
        }

        return new JinjaNode(
                ctx.getStart().getLine(),
                JinjaNode.JinjaType.EXPRESSION,
                content.toString().trim()
        );
    }

    @Override
    public ASTNode visitJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx) {
        StringBuilder content = new StringBuilder();

        if (ctx.jinjaStmtArgument() != null) {
            for (HTMLCSSJINJA_parser.JinjaStmtArgumentContext argCtx : ctx.jinjaStmtArgument()) {
                if (argCtx.getText() != null) {
                    if (content.length() > 0) content.append(" ");
                    content.append(argCtx.getText());
                }
            }
        }

        return new JinjaNode(
                ctx.getStart().getLine(),
                JinjaNode.JinjaType.STATEMENT,
                content.toString().trim()
        );
    }



    @Override
    public ASTNode visitJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx) {
        JinjaBlockNode ifBlock = new JinjaBlockNode(
                ctx.getStart().getLine(),
                JinjaBlockNode.BlockType.IF
        );

        String condition = extractJinjaArguments(ctx.jinjaStmtArgument());
        ifBlock.addConditionBlock(condition);

        if (ctx.jinjaBlockContent() != null) {
            for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                ASTNode contentNode = visit(contentCtx);
                if (contentNode != null) {
                    ifBlock.addContentToLastCondition(contentNode);
                }
            }
        }

        ifBlock.finalizeBlock();

        return ifBlock;
    }

    @Override
    public ASTNode visitJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx) {
        JinjaBlockNode forBlock = new JinjaBlockNode(
                ctx.getStart().getLine(),
                JinjaBlockNode.BlockType.FOR
        );

        String condition = extractJinjaArguments(ctx.jinjaStmtArgument());
        forBlock.addConditionBlock(condition);

        if (ctx.jinjaBlockContent() != null) {
            for (HTMLCSSJINJA_parser.JinjaBlockContentContext contentCtx : ctx.jinjaBlockContent()) {
                ASTNode contentNode = visit(contentCtx);
                if (contentNode != null) {
                    forBlock.addContentToLastCondition(contentNode);
                }
            }
        }

        forBlock.finalizeBlock();

        return forBlock;
    }

    @Override
    public ASTNode visitJinjaNormalTagLabel(HTMLCSSJINJA_parser.JinjaNormalTagLabelContext ctx) {
        return visit(ctx.normalTagElementbody());
    }

    @Override
    public ASTNode visitJinjaSelfClosingTagLabel(HTMLCSSJINJA_parser.JinjaSelfClosingTagLabelContext ctx) {
        return visit(ctx.selfClosingTagElementbody());
    }

    @Override
    public ASTNode visitJinjaNestedElementLabel(HTMLCSSJINJA_parser.JinjaNestedElementLabelContext ctx) {
        return visit(ctx.jinjaElement());
    }

    @Override
    public ASTNode visitJinjaTextLabel(HTMLCSSJINJA_parser.JinjaTextLabelContext ctx) {
        return new TextNode(
                ctx.getStart().getLine(),
                ctx.TEXT().getText(),
                TextNode.TextContext.JINJA
        );
    }


    @Override
    public ASTNode visitText(HTMLCSSJINJA_parser.TextContext ctx) {
        return new TextNode(
                ctx.getStart().getLine(),
                ctx.TEXT().getText(),
                TextNode.TextContext.HTML
        );
    }

    private String extractJinjaArguments(List<HTMLCSSJINJA_parser.JinjaStmtArgumentContext> arguments) {
        if (arguments == null || arguments.isEmpty()) {
            return "";
        }

        StringBuilder condition = new StringBuilder();
        for (HTMLCSSJINJA_parser.JinjaStmtArgumentContext arg : arguments) {
            if (condition.length() > 0) condition.append(" ");
            condition.append(arg.getText());
        }

        return condition.toString().trim();
    }

    @Override
    public ASTNode visitChildren(org.antlr.v4.runtime.tree.RuleNode node) {
        return null;
    }
}