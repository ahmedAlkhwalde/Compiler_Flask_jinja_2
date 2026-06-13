// Generated from C:/D/CompilerFlaskAndJinja/src/antlrJinja/HTMLCSSJINJA_parser.g4 by ANTLR 4.13.2
package antlrJinja;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLCSSJINJA_parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLCSSJINJA_parserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code documentLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentLabel(HTMLCSSJINJA_parser.DocumentLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlelementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlelementlabel(HTMLCSSJINJA_parser.HtmlelementlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlcommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlcommentlabel(HTMLCSSJINJA_parser.HtmlcommentlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doctipelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctipelabel(HTMLCSSJINJA_parser.DoctipelabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElementlabel(HTMLCSSJINJA_parser.JinjaElementlabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#doctipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#htmlelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#attruputehtml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttruputehtml(HTMLCSSJINJA_parser.AttruputehtmlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code langAttributeLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributehtml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLangAttributeLabel(HTMLCSSJINJA_parser.LangAttributeLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code headlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeadlabel(HTMLCSSJINJA_parser.HeadlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodylabel(HTMLCSSJINJA_parser.BodylabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(HTMLCSSJINJA_parser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(HTMLCSSJINJA_parser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(HTMLCSSJINJA_parser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalTagElementheadlabel(HTMLCSSJINJA_parser.NormalTagElementheadlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfClosingTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTagElementheadlabel(HTMLCSSJINJA_parser.SelfClosingTagElementheadlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjasecondElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjasecondElementlabel(HTMLCSSJINJA_parser.JinjasecondElementlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normaltaghead}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementhead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadnormal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagsheadnormal(HTMLCSSJINJA_parser.TagsheadnormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfclostaglabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#selfClosingTagElementhead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfclostaglabel(HTMLCSSJINJA_parser.SelfclostaglabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadself}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagsheadself(HTMLCSSJINJA_parser.TagsheadselfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalTagElementbodylabel(HTMLCSSJINJA_parser.NormalTagElementbodylabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfClosingTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTagElementbodylabel(HTMLCSSJINJA_parser.SelfClosingTagElementbodylabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjathirdElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjathirdElementlabel(HTMLCSSJINJA_parser.JinjathirdElementlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextlabel(HTMLCSSJINJA_parser.TextlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normal_Tag_Element_body}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attribute_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code colorLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorLabel(HTMLCSSJINJA_parser.ColorLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lengthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthLabel(HTMLCSSJINJA_parser.LengthLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code urlLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrlLabel(HTMLCSSJINJA_parser.UrlLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repeatLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatLabel(HTMLCSSJINJA_parser.RepeatLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positionLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionLabel(HTMLCSSJINJA_parser.PositionLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code borderStyleLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorderStyleLabel(HTMLCSSJINJA_parser.BorderStyleLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code borderWidthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorderWidthLabel(HTMLCSSJINJA_parser.BorderWidthLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code borderLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorderLabel(HTMLCSSJINJA_parser.BorderLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fontLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFontLabel(HTMLCSSJINJA_parser.FontLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textCssLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextCssLabel(HTMLCSSJINJA_parser.TextCssLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code effectLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffectLabel(HTMLCSSJINJA_parser.EffectLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code layoutLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutLabel(HTMLCSSJINJA_parser.LayoutLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code offsetLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffsetLabel(HTMLCSSJINJA_parser.OffsetLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(HTMLCSSJINJA_parser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(HTMLCSSJINJA_parser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(HTMLCSSJINJA_parser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(HTMLCSSJINJA_parser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#position}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition(HTMLCSSJINJA_parser.PositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#offset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffset(HTMLCSSJINJA_parser.OffsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#border_style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorder_style(HTMLCSSJINJA_parser.Border_styleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#border_width}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorder_width(HTMLCSSJINJA_parser.Border_widthContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#border}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBorder(HTMLCSSJINJA_parser.BorderContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#font}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFont(HTMLCSSJINJA_parser.FontContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#textcss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextcss(HTMLCSSJINJA_parser.TextcssContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect(HTMLCSSJINJA_parser.EffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#layout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayout(HTMLCSSJINJA_parser.LayoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#css_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCss_value(HTMLCSSJINJA_parser.Css_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynamenormal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagsbodynamenormal(HTMLCSSJINJA_parser.TagsbodynamenormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#selfClosingTagElementbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynameself}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagsbodynameself(HTMLCSSJINJA_parser.TagsbodynameselfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attribute_stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_stylelabel(HTMLCSSJINJA_parser.Attribute_stylelabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributenamebodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributenamebodywithoutvaluelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebodywithoutvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributenamebodywithoutvalue(HTMLCSSJINJA_parser.AttributenamebodywithoutvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributenamebody(HTMLCSSJINJA_parser.AttributenamebodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#attributehead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributehead(HTMLCSSJINJA_parser.AttributeheadContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamehead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributenamehead(HTMLCSSJINJA_parser.AttributenameheadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaExprlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprlabel(HTMLCSSJINJA_parser.JinjaExprlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaStmtlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStmtlabel(HTMLCSSJINJA_parser.JinjaStmtlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaCommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaCommentlabel(HTMLCSSJINJA_parser.JinjaCommentlabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaIfBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfBlocklabel(HTMLCSSJINJA_parser.JinjaIfBlocklabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaForBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForBlocklabel(HTMLCSSJINJA_parser.JinjaForBlocklabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaCompactElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaCompactElementlabel(HTMLCSSJINJA_parser.JinjaCompactElementlabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaCompactElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaCompactElement(HTMLCSSJINJA_parser.JinjaCompactElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExprContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprContent(HTMLCSSJINJA_parser.JinjaExprContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaNormalTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaNormalTagLabel(HTMLCSSJINJA_parser.JinjaNormalTagLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaSelfClosingTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaSelfClosingTagLabel(HTMLCSSJINJA_parser.JinjaSelfClosingTagLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaNestedElementLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaNestedElementLabel(HTMLCSSJINJA_parser.JinjaNestedElementLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaTextLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaTextLabel(HTMLCSSJINJA_parser.JinjaTextLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaForBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmtArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStmtArgument(HTMLCSSJINJA_parser.JinjaStmtArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaComment(HTMLCSSJINJA_parser.JinjaCommentContext ctx);
}