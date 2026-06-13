// Generated from C:/D/CompilerFlaskAndJinja/src/antlrJinja/HTMLCSSJINJA_parser.g4 by ANTLR 4.13.2
package antlrJinja;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLCSSJINJA_parser}.
 */
public interface HTMLCSSJINJA_parserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code documentLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocumentLabel(HTMLCSSJINJA_parser.DocumentLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code documentLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocumentLabel(HTMLCSSJINJA_parser.DocumentLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlelementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtmlelementlabel(HTMLCSSJINJA_parser.HtmlelementlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlelementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtmlelementlabel(HTMLCSSJINJA_parser.HtmlelementlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlcommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtmlcommentlabel(HTMLCSSJINJA_parser.HtmlcommentlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlcommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtmlcommentlabel(HTMLCSSJINJA_parser.HtmlcommentlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doctipelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void enterDoctipelabel(HTMLCSSJINJA_parser.DoctipelabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doctipelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void exitDoctipelabel(HTMLCSSJINJA_parser.DoctipelabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElementlabel(HTMLCSSJINJA_parser.JinjaElementlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#html}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElementlabel(HTMLCSSJINJA_parser.JinjaElementlabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#doctipe}.
	 * @param ctx the parse tree
	 */
	void enterDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#doctipe}.
	 * @param ctx the parse tree
	 */
	void exitDoctipe(HTMLCSSJINJA_parser.DoctipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#htmlelement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlelement(HTMLCSSJINJA_parser.HtmlelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#attruputehtml}.
	 * @param ctx the parse tree
	 */
	void enterAttruputehtml(HTMLCSSJINJA_parser.AttruputehtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#attruputehtml}.
	 * @param ctx the parse tree
	 */
	void exitAttruputehtml(HTMLCSSJINJA_parser.AttruputehtmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code langAttributeLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributehtml}.
	 * @param ctx the parse tree
	 */
	void enterLangAttributeLabel(HTMLCSSJINJA_parser.LangAttributeLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code langAttributeLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributehtml}.
	 * @param ctx the parse tree
	 */
	void exitLangAttributeLabel(HTMLCSSJINJA_parser.LangAttributeLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code headlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 */
	void enterHeadlabel(HTMLCSSJINJA_parser.HeadlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code headlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 */
	void exitHeadlabel(HTMLCSSJINJA_parser.HeadlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 */
	void enterBodylabel(HTMLCSSJINJA_parser.BodylabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthtml}.
	 * @param ctx the parse tree
	 */
	void exitBodylabel(HTMLCSSJINJA_parser.BodylabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(HTMLCSSJINJA_parser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(HTMLCSSJINJA_parser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(HTMLCSSJINJA_parser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(HTMLCSSJINJA_parser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(HTMLCSSJINJA_parser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(HTMLCSSJINJA_parser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void enterNormalTagElementheadlabel(HTMLCSSJINJA_parser.NormalTagElementheadlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void exitNormalTagElementheadlabel(HTMLCSSJINJA_parser.NormalTagElementheadlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfClosingTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTagElementheadlabel(HTMLCSSJINJA_parser.SelfClosingTagElementheadlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfClosingTagElementheadlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTagElementheadlabel(HTMLCSSJINJA_parser.SelfClosingTagElementheadlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjasecondElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void enterJinjasecondElementlabel(HTMLCSSJINJA_parser.JinjasecondElementlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjasecondElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contenthead}.
	 * @param ctx the parse tree
	 */
	void exitJinjasecondElementlabel(HTMLCSSJINJA_parser.JinjasecondElementlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normaltaghead}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementhead}.
	 * @param ctx the parse tree
	 */
	void enterNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normaltaghead}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementhead}.
	 * @param ctx the parse tree
	 */
	void exitNormaltaghead(HTMLCSSJINJA_parser.NormaltagheadContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadnormal}.
	 * @param ctx the parse tree
	 */
	void enterTagsheadnormal(HTMLCSSJINJA_parser.TagsheadnormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadnormal}.
	 * @param ctx the parse tree
	 */
	void exitTagsheadnormal(HTMLCSSJINJA_parser.TagsheadnormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfclostaglabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#selfClosingTagElementhead}.
	 * @param ctx the parse tree
	 */
	void enterSelfclostaglabel(HTMLCSSJINJA_parser.SelfclostaglabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfclostaglabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#selfClosingTagElementhead}.
	 * @param ctx the parse tree
	 */
	void exitSelfclostaglabel(HTMLCSSJINJA_parser.SelfclostaglabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadself}.
	 * @param ctx the parse tree
	 */
	void enterTagsheadself(HTMLCSSJINJA_parser.TagsheadselfContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsheadself}.
	 * @param ctx the parse tree
	 */
	void exitTagsheadself(HTMLCSSJINJA_parser.TagsheadselfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normalTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void enterNormalTagElementbodylabel(HTMLCSSJINJA_parser.NormalTagElementbodylabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normalTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void exitNormalTagElementbodylabel(HTMLCSSJINJA_parser.NormalTagElementbodylabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfClosingTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTagElementbodylabel(HTMLCSSJINJA_parser.SelfClosingTagElementbodylabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfClosingTagElementbodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTagElementbodylabel(HTMLCSSJINJA_parser.SelfClosingTagElementbodylabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjathirdElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void enterJinjathirdElementlabel(HTMLCSSJINJA_parser.JinjathirdElementlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjathirdElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void exitJinjathirdElementlabel(HTMLCSSJINJA_parser.JinjathirdElementlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void enterTextlabel(HTMLCSSJINJA_parser.TextlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#contentbody}.
	 * @param ctx the parse tree
	 */
	void exitTextlabel(HTMLCSSJINJA_parser.TextlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code normal_Tag_Element_body}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementbody}.
	 * @param ctx the parse tree
	 */
	void enterNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code normal_Tag_Element_body}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#normalTagElementbody}.
	 * @param ctx the parse tree
	 */
	void exitNormal_Tag_Element_body(HTMLCSSJINJA_parser.Normal_Tag_Element_bodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attribute_style}.
	 * @param ctx the parse tree
	 */
	void enterStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attribute_style}.
	 * @param ctx the parse tree
	 */
	void exitStylelabel(HTMLCSSJINJA_parser.StylelabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colorLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterColorLabel(HTMLCSSJINJA_parser.ColorLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colorLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitColorLabel(HTMLCSSJINJA_parser.ColorLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lengthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterLengthLabel(HTMLCSSJINJA_parser.LengthLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lengthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitLengthLabel(HTMLCSSJINJA_parser.LengthLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code urlLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterUrlLabel(HTMLCSSJINJA_parser.UrlLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code urlLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitUrlLabel(HTMLCSSJINJA_parser.UrlLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeatLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterRepeatLabel(HTMLCSSJINJA_parser.RepeatLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeatLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitRepeatLabel(HTMLCSSJINJA_parser.RepeatLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positionLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterPositionLabel(HTMLCSSJINJA_parser.PositionLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positionLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitPositionLabel(HTMLCSSJINJA_parser.PositionLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code borderStyleLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterBorderStyleLabel(HTMLCSSJINJA_parser.BorderStyleLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code borderStyleLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitBorderStyleLabel(HTMLCSSJINJA_parser.BorderStyleLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code borderWidthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterBorderWidthLabel(HTMLCSSJINJA_parser.BorderWidthLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code borderWidthLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitBorderWidthLabel(HTMLCSSJINJA_parser.BorderWidthLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code borderLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterBorderLabel(HTMLCSSJINJA_parser.BorderLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code borderLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitBorderLabel(HTMLCSSJINJA_parser.BorderLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fontLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterFontLabel(HTMLCSSJINJA_parser.FontLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fontLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitFontLabel(HTMLCSSJINJA_parser.FontLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textCssLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterTextCssLabel(HTMLCSSJINJA_parser.TextCssLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textCssLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitTextCssLabel(HTMLCSSJINJA_parser.TextCssLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code effectLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterEffectLabel(HTMLCSSJINJA_parser.EffectLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code effectLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitEffectLabel(HTMLCSSJINJA_parser.EffectLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code layoutLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterLayoutLabel(HTMLCSSJINJA_parser.LayoutLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code layoutLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitLayoutLabel(HTMLCSSJINJA_parser.LayoutLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code offsetLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void enterOffsetLabel(HTMLCSSJINJA_parser.OffsetLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code offsetLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#stylename}.
	 * @param ctx the parse tree
	 */
	void exitOffsetLabel(HTMLCSSJINJA_parser.OffsetLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(HTMLCSSJINJA_parser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(HTMLCSSJINJA_parser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#length}.
	 * @param ctx the parse tree
	 */
	void enterLength(HTMLCSSJINJA_parser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#length}.
	 * @param ctx the parse tree
	 */
	void exitLength(HTMLCSSJINJA_parser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(HTMLCSSJINJA_parser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(HTMLCSSJINJA_parser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#repeat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(HTMLCSSJINJA_parser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#repeat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(HTMLCSSJINJA_parser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(HTMLCSSJINJA_parser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(HTMLCSSJINJA_parser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#offset}.
	 * @param ctx the parse tree
	 */
	void enterOffset(HTMLCSSJINJA_parser.OffsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#offset}.
	 * @param ctx the parse tree
	 */
	void exitOffset(HTMLCSSJINJA_parser.OffsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#border_style}.
	 * @param ctx the parse tree
	 */
	void enterBorder_style(HTMLCSSJINJA_parser.Border_styleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#border_style}.
	 * @param ctx the parse tree
	 */
	void exitBorder_style(HTMLCSSJINJA_parser.Border_styleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#border_width}.
	 * @param ctx the parse tree
	 */
	void enterBorder_width(HTMLCSSJINJA_parser.Border_widthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#border_width}.
	 * @param ctx the parse tree
	 */
	void exitBorder_width(HTMLCSSJINJA_parser.Border_widthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#border}.
	 * @param ctx the parse tree
	 */
	void enterBorder(HTMLCSSJINJA_parser.BorderContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#border}.
	 * @param ctx the parse tree
	 */
	void exitBorder(HTMLCSSJINJA_parser.BorderContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#font}.
	 * @param ctx the parse tree
	 */
	void enterFont(HTMLCSSJINJA_parser.FontContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#font}.
	 * @param ctx the parse tree
	 */
	void exitFont(HTMLCSSJINJA_parser.FontContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#textcss}.
	 * @param ctx the parse tree
	 */
	void enterTextcss(HTMLCSSJINJA_parser.TextcssContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#textcss}.
	 * @param ctx the parse tree
	 */
	void exitTextcss(HTMLCSSJINJA_parser.TextcssContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#effect}.
	 * @param ctx the parse tree
	 */
	void enterEffect(HTMLCSSJINJA_parser.EffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#effect}.
	 * @param ctx the parse tree
	 */
	void exitEffect(HTMLCSSJINJA_parser.EffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#layout}.
	 * @param ctx the parse tree
	 */
	void enterLayout(HTMLCSSJINJA_parser.LayoutContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#layout}.
	 * @param ctx the parse tree
	 */
	void exitLayout(HTMLCSSJINJA_parser.LayoutContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#css_value}.
	 * @param ctx the parse tree
	 */
	void enterCss_value(HTMLCSSJINJA_parser.Css_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#css_value}.
	 * @param ctx the parse tree
	 */
	void exitCss_value(HTMLCSSJINJA_parser.Css_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynamenormal}.
	 * @param ctx the parse tree
	 */
	void enterTagsbodynamenormal(HTMLCSSJINJA_parser.TagsbodynamenormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynamenormal}.
	 * @param ctx the parse tree
	 */
	void exitTagsbodynamenormal(HTMLCSSJINJA_parser.TagsbodynamenormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#selfClosingTagElementbody}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#selfClosingTagElementbody}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTagElementbody(HTMLCSSJINJA_parser.SelfClosingTagElementbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynameself}.
	 * @param ctx the parse tree
	 */
	void enterTagsbodynameself(HTMLCSSJINJA_parser.TagsbodynameselfContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#tagsbodynameself}.
	 * @param ctx the parse tree
	 */
	void exitTagsbodynameself(HTMLCSSJINJA_parser.TagsbodynameselfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attribute_stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_stylelabel(HTMLCSSJINJA_parser.Attribute_stylelabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attribute_stylelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_stylelabel(HTMLCSSJINJA_parser.Attribute_stylelabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributenamebodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void enterAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributenamebodylabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void exitAttributenamebodylabel(HTMLCSSJINJA_parser.AttributenamebodylabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributenamebodywithoutvaluelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void enterAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributenamebodywithoutvaluelabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#attributebody}.
	 * @param ctx the parse tree
	 */
	void exitAttributenamebodywithoutvaluelabel(HTMLCSSJINJA_parser.AttributenamebodywithoutvaluelabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebodywithoutvalue}.
	 * @param ctx the parse tree
	 */
	void enterAttributenamebodywithoutvalue(HTMLCSSJINJA_parser.AttributenamebodywithoutvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebodywithoutvalue}.
	 * @param ctx the parse tree
	 */
	void exitAttributenamebodywithoutvalue(HTMLCSSJINJA_parser.AttributenamebodywithoutvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebody}.
	 * @param ctx the parse tree
	 */
	void enterAttributenamebody(HTMLCSSJINJA_parser.AttributenamebodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamebody}.
	 * @param ctx the parse tree
	 */
	void exitAttributenamebody(HTMLCSSJINJA_parser.AttributenamebodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#attributehead}.
	 * @param ctx the parse tree
	 */
	void enterAttributehead(HTMLCSSJINJA_parser.AttributeheadContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#attributehead}.
	 * @param ctx the parse tree
	 */
	void exitAttributehead(HTMLCSSJINJA_parser.AttributeheadContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamehead}.
	 * @param ctx the parse tree
	 */
	void enterAttributenamehead(HTMLCSSJINJA_parser.AttributenameheadContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#attributenamehead}.
	 * @param ctx the parse tree
	 */
	void exitAttributenamehead(HTMLCSSJINJA_parser.AttributenameheadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaExprlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExprlabel(HTMLCSSJINJA_parser.JinjaExprlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaExprlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExprlabel(HTMLCSSJINJA_parser.JinjaExprlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaStmtlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStmtlabel(HTMLCSSJINJA_parser.JinjaStmtlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaStmtlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStmtlabel(HTMLCSSJINJA_parser.JinjaStmtlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaCommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaCommentlabel(HTMLCSSJINJA_parser.JinjaCommentlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaCommentlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaCommentlabel(HTMLCSSJINJA_parser.JinjaCommentlabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaIfBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfBlocklabel(HTMLCSSJINJA_parser.JinjaIfBlocklabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaIfBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfBlocklabel(HTMLCSSJINJA_parser.JinjaIfBlocklabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaForBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForBlocklabel(HTMLCSSJINJA_parser.JinjaForBlocklabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaForBlocklabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForBlocklabel(HTMLCSSJINJA_parser.JinjaForBlocklabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaCompactElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaCompactElementlabel(HTMLCSSJINJA_parser.JinjaCompactElementlabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaCompactElementlabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaCompactElementlabel(HTMLCSSJINJA_parser.JinjaCompactElementlabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaCompactElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaCompactElement(HTMLCSSJINJA_parser.JinjaCompactElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaCompactElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaCompactElement(HTMLCSSJINJA_parser.JinjaCompactElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpr(HTMLCSSJINJA_parser.JinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExprContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExprContent(HTMLCSSJINJA_parser.JinjaExprContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaExprContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExprContent(HTMLCSSJINJA_parser.JinjaExprContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaNormalTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaNormalTagLabel(HTMLCSSJINJA_parser.JinjaNormalTagLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaNormalTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaNormalTagLabel(HTMLCSSJINJA_parser.JinjaNormalTagLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaSelfClosingTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaSelfClosingTagLabel(HTMLCSSJINJA_parser.JinjaSelfClosingTagLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaSelfClosingTagLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaSelfClosingTagLabel(HTMLCSSJINJA_parser.JinjaSelfClosingTagLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaNestedElementLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaNestedElementLabel(HTMLCSSJINJA_parser.JinjaNestedElementLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaNestedElementLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaNestedElementLabel(HTMLCSSJINJA_parser.JinjaNestedElementLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaTextLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaTextLabel(HTMLCSSJINJA_parser.JinjaTextLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaTextLabel}
	 * labeled alternative in {@link HTMLCSSJINJA_parser#jinjaBlockContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaTextLabel(HTMLCSSJINJA_parser.JinjaTextLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfBlock(HTMLCSSJINJA_parser.JinjaIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaForBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaForBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForBlock(HTMLCSSJINJA_parser.JinjaForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmtArgument}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStmtArgument(HTMLCSSJINJA_parser.JinjaStmtArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmtArgument}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStmtArgument(HTMLCSSJINJA_parser.JinjaStmtArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmt}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaStmt}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStmt(HTMLCSSJINJA_parser.JinjaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void enterJinjaComment(HTMLCSSJINJA_parser.JinjaCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLCSSJINJA_parser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void exitJinjaComment(HTMLCSSJINJA_parser.JinjaCommentContext ctx);
}