// Generated from C:/D/CompilerFlaskAndJinja/src/antlrJinja/HTMLCSSJINJA_parser.g4 by ANTLR 4.13.2
package antlrJinja;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HTMLCSSJINJA_parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, JINJA_EXPR_START=2, JINJA_STMT_START=3, END_TAG_START=4, OPEN_TAG_START=5, 
		HTML_COMMENT=6, JANJI_COMMENT=7, TEXT=8, EQUALS=9, STYLE_ATTRIBUTE_START=10, 
		TAG_DOCTYPE=11, TAG_HTML=12, TAG_HEAD=13, TAG_META=14, TAG_TITLE=15, TAG_BODY=16, 
		TAG_DIV=17, TAG_H1=18, TAG_H2=19, TAG_H3=20, TAG_H4=21, TAG_H5=22, TAG_H6=23, 
		TAG_P=24, TAG_A=25, TAG_IMG=26, TAG_BR=27, TAG_HR=28, TAG_INPUT=29, TAG_FORM=30, 
		TAG_LABEL=31, TAG_BUTTON=32, TAG_STRONG=33, TAG_B=34, TAG_I=35, TAG_EM=36, 
		TAG_U=37, TAG_SMALL=38, TAG_MARK=39, TAG_SUB=40, TAG_SUP=41, TAG_BLOCKQUOTE=42, 
		TAG_CODE=43, TAG_PRE=44, TAG_SELECT=45, TAG_OPTION=46, TAG_TEXTAREA=47, 
		TAG_DATALIST=48, TAG_FIELDSET=49, TAG_LEGEND=50, TAG_OPTGROUP=51, TAG_AUDIO=52, 
		TAG_VIDEO=53, TAG_CANVAS=54, TAG_SVG=55, TAG_PICTURE=56, TAG_UL=57, TAG_OL=58, 
		TAG_LI=59, TAG_DL=60, TAG_DT=61, TAG_DD=62, TAG_TABLE=63, TAG_THEAD=64, 
		TAG_TBODY=65, TAG_TFOOT=66, TAG_TR=67, TAG_TD=68, TAG_TH=69, TAG_CAPTION=70, 
		TAG_COLGROUP=71, TAG_FIGURE=72, TAG_FIGCAPTION=73, TAG_DETAILS=74, TAG_SUMMARY=75, 
		TAG_DIALOG=76, TAG_LINK=77, TAG_SOURCE=78, TAG_TRACK=79, TAG_WBR=80, TAG_AREA=81, 
		TAG_BASE=82, TAG_COL=83, TAG_EMBED=84, TAG_PARAM=85, TAG_SECTION=86, TAG_ARTICLE=87, 
		TAG_NAV=88, TAG_ASIDE=89, TAG_HEADER=90, TAG_FOOTER=91, TAG_MAIN=92, TAG_SPAN=93, 
		ATTR_HIDDEN=94, ATTR_DRAGGABLE=95, ATTR_CONTENTEDITABLE=96, ATTR_TRANSLATE=97, 
		ATTR_REQUIRED=98, ATTR_READONLY=99, ATTR_DISABLED=100, ATTR_CHECKED=101, 
		ATTR_MULTIPLE=102, ATTR_NOVALIDATE=103, ATTR_CONTROLS=104, ATTR_AUTOPLAY=105, 
		ATTR_LOOP=106, ATTR_MUTED=107, ATTR_ID=108, ATTR_CLASS=109, ATTR_TITLE=110, 
		ATTR_LANG=111, ATTR_DIR=112, ATTR_TABINDEX=113, ATTR_ACCESSKEY=114, ATTR_HREF=115, 
		ATTR_TARGET=116, ATTR_REL=117, ATTR_DOWNLOAD=118, ATTR_REFERRERPOLICY=119, 
		ATTR_SRC=120, ATTR_ALT=121, ATTR_WIDTH=122, ATTR_HEIGHT=123, ATTR_LOADING=124, 
		ATTR_DECODING=125, ATTR_TYPE=126, ATTR_NAME=127, ATTR_VALUE=128, ATTR_PLACEHOLDER=129, 
		ATTR_MAX=130, ATTR_MIN=131, ATTR_STEP=132, ATTR_PATTERN=133, ATTR_MAXLENGTH=134, 
		ATTR_MINLENGTH=135, ATTR_ACCEPT=136, ATTR_AUTOCOMPLETE=137, ATTR_SIZE=138, 
		ATTR_METHOD=139, ATTR_ACTION=140, ATTR_ENCTYPE=141, ATTR_AUTOFILL=142, 
		ATTR_ONCLICK=143, ATTR_ONCHANGE=144, ATTR_ONSUBMIT=145, ATTR_ONINPUT=146, 
		ATTR_ONLOAD=147, ATTR_PRELOAD=148, ATTR_POSTER=149, ATTR_COLSPAN=150, 
		ATTR_ROWSPAN=151, ATTR_SCOPE=152, ATTR_CHARSET=153, ATTR_CONTENT=154, 
		ATTR_HTTP_EQUIV=155, ATTR_PROPERTY=156, VALUE_LANG_EN=157, VALUE_LANG_AR=158, 
		ATTRIBUTE_NAME=159, ATTRIBUTE_VALUE=160, SLASH_CLOSE=161, CLOSE=162, TAG_WS=163, 
		STYLE_END=164, CSS_TWOPOINT=165, CSS_SEMI=166, CSS_TEXT_PROPERTY=167, 
		CSS_ATTR_COLOR=168, CSS_LENGTH_PROPERTY=169, CSS_OFFSET_PROPERTY=170, 
		CSS_LAYOUT_PROPERTY=171, CSS_URL_PROPERTY=172, CSS_REPEAT_PROPERTY=173, 
		CSS_POSITION_PROPERTY=174, CSS_BORDER_PROPERTY=175, CSS_BORDER_STYLE_PROPERTY=176, 
		CSS_BORDER_WIDTH_PROPERTY=177, CSS_FONT_PROPERTY=178, CSS_EFFECT_PROPERTY=179, 
		CSS_SHORTHAND_VALUE=180, CSS_TEXT_VALUE=181, CSS_EFFECT_VALUE=182, CSS_LAYOUT_VALUE=183, 
		CSS_COLOR_VALUE=184, CSS_URL_VALUE=185, CSS_REPEAT_VALUE=186, CSS_POSITION_VALUE=187, 
		CSS_BORDER_STYLE_VALUE=188, CSS_BORDER_WIDTH_VALUE=189, CSS_FONT_VALUE=190, 
		CSS_GENERIC_VALUE=191, STYLE_WS=192, JINJA_EXPR_END=193, JINJA_EXPR_WS=194, 
		JINJA_EXPR_STRING=195, JINJA_EXPR_ATOM=196, JINJA_EXPR_SYMBOL=197, JINJA_EXPR_UNKNOWN=198, 
		JINJA_STMT_END=199, JINJA_STMT_IF=200, JINJA_STMT_ENDIF=201, JINJA_STMT_FOR=202, 
		JINJA_STMT_ENDFOR=203, JINJA_STMT_ELSE=204, JINJA_STMT_ELIF=205, JINJA_STMT_IN=206, 
		JINJA_STMT_SET=207, JINJA_STMT_BLOCK=208, JINJA_STMT_ENDBLOCK=209, JINJA_STMT_WITH=210, 
		JINJA_STMT_ENDWITH=211, JINJA_STMT_MACRO=212, JINJA_STMT_ENDMACRO=213, 
		JINJA_STMT_INCLUDE=214, JINJA_STMT_EXTENDS=215, JINJA_STMT_FROM=216, JINJA_STMT_WS=217, 
		JINJA_STMT_STRING=218, JINJA_STMT_ATOM=219, JINJA_STMT_SYMBOL=220, JINJA_STMT_UNKNOWN=221;
	public static final int
		RULE_document = 0, RULE_html = 1, RULE_doctipe = 2, RULE_htmlelement = 3, 
		RULE_attruputehtml = 4, RULE_attributehtml = 5, RULE_contenthtml = 6, 
		RULE_text = 7, RULE_head = 8, RULE_body = 9, RULE_contenthead = 10, RULE_normalTagElementhead = 11, 
		RULE_tagsheadnormal = 12, RULE_selfClosingTagElementhead = 13, RULE_tagsheadself = 14, 
		RULE_contentbody = 15, RULE_normalTagElementbody = 16, RULE_attribute_style = 17, 
		RULE_stylename = 18, RULE_color = 19, RULE_length = 20, RULE_url = 21, 
		RULE_repeat = 22, RULE_position = 23, RULE_offset = 24, RULE_border_style = 25, 
		RULE_border_width = 26, RULE_border = 27, RULE_font = 28, RULE_textcss = 29, 
		RULE_effect = 30, RULE_layout = 31, RULE_css_value = 32, RULE_tagsbodynamenormal = 33, 
		RULE_selfClosingTagElementbody = 34, RULE_tagsbodynameself = 35, RULE_attributebody = 36, 
		RULE_attributenamebodywithoutvalue = 37, RULE_attributenamebody = 38, 
		RULE_attributehead = 39, RULE_attributenamehead = 40, RULE_jinjaElement = 41, 
		RULE_jinjaCompactElement = 42, RULE_jinjaExpr = 43, RULE_jinjaExprContent = 44, 
		RULE_jinjaBlockContent = 45, RULE_jinjaIfBlock = 46, RULE_jinjaForBlock = 47, 
		RULE_jinjaStmtArgument = 48, RULE_jinjaStmt = 49, RULE_jinjaComment = 50;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "html", "doctipe", "htmlelement", "attruputehtml", "attributehtml", 
			"contenthtml", "text", "head", "body", "contenthead", "normalTagElementhead", 
			"tagsheadnormal", "selfClosingTagElementhead", "tagsheadself", "contentbody", 
			"normalTagElementbody", "attribute_style", "stylename", "color", "length", 
			"url", "repeat", "position", "offset", "border_style", "border_width", 
			"border", "font", "textcss", "effect", "layout", "css_value", "tagsbodynamenormal", 
			"selfClosingTagElementbody", "tagsbodynameself", "attributebody", "attributenamebodywithoutvalue", 
			"attributenamebody", "attributehead", "attributenamehead", "jinjaElement", 
			"jinjaCompactElement", "jinjaExpr", "jinjaExprContent", "jinjaBlockContent", 
			"jinjaIfBlock", "jinjaForBlock", "jinjaStmtArgument", "jinjaStmt", "jinjaComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'{{'", "'{%'", "'</'", "'<'", null, null, null, "'='", null, 
			"'!DOCTYPE html'", "'html'", "'head'", "'meta'", null, "'body'", "'div'", 
			"'h1'", "'h2'", "'h3'", "'h4'", "'h5'", "'h6'", "'p'", "'a'", "'img'", 
			"'br'", "'hr'", "'input'", "'form'", "'label'", "'button'", "'strong'", 
			"'b'", "'i'", "'em'", "'u'", "'small'", "'mark'", "'sub'", "'sup'", "'blockquote'", 
			"'code'", "'pre'", "'select'", "'option'", "'textarea'", "'datalist'", 
			"'fieldset'", "'legend'", "'optgroup'", "'audio'", "'video'", "'canvas'", 
			"'svg'", "'picture'", "'ul'", "'ol'", "'li'", "'dl'", "'dt'", "'dd'", 
			"'table'", "'thead'", "'tbody'", "'tfoot'", "'tr'", "'td'", "'th'", "'caption'", 
			"'colgroup'", "'figure'", "'figcaption'", "'details'", "'summary'", "'dialog'", 
			"'link'", "'source'", "'track'", "'wbr'", "'area'", "'base'", "'col'", 
			"'embed'", "'param'", "'section'", "'article'", "'nav'", "'aside'", "'header'", 
			"'footer'", "'main'", "'span'", "'hidden'", "'draggable'", "'contenteditable'", 
			"'translate'", "'required'", "'readonly'", "'disabled'", "'checked'", 
			"'multiple'", "'novalidate'", "'controls'", "'autoplay'", "'loop'", "'muted'", 
			"'id'", "'class'", null, "'lang'", "'dir'", "'tabindex'", "'accesskey'", 
			"'href'", "'target'", "'rel'", "'download'", "'referrerpolicy'", "'src'", 
			"'alt'", "'width'", "'height'", "'loading'", "'decoding'", "'type'", 
			"'name'", "'value'", "'placeholder'", "'max'", "'min'", "'step'", "'pattern'", 
			"'maxlength'", "'minlength'", "'accept'", "'autocomplete'", "'size'", 
			"'method'", "'action'", "'enctype'", "'autofill'", "'onclick'", "'onchange'", 
			"'onsubmit'", "'oninput'", "'onload'", "'preload'", "'poster'", "'colspan'", 
			"'rowspan'", "'scope'", "'charset'", "'content'", "'http-equiv'", "'property'", 
			"'\"en\"'", "'\"ar\"'", null, null, "'/>'", "'>'", null, "'\"'", "':'", 
			"';'", null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'}}'", null, null, null, null, null, "'%}'", "'if'", 
			"'endif'", "'for'", "'endfor'", "'else'", "'elif'", "'in'", "'set'", 
			"'block'", "'endblock'", "'with'", "'endwith'", "'macro'", "'endmacro'", 
			"'include'", "'extends'", "'from'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "JINJA_EXPR_START", "JINJA_STMT_START", "END_TAG_START", 
			"OPEN_TAG_START", "HTML_COMMENT", "JANJI_COMMENT", "TEXT", "EQUALS", 
			"STYLE_ATTRIBUTE_START", "TAG_DOCTYPE", "TAG_HTML", "TAG_HEAD", "TAG_META", 
			"TAG_TITLE", "TAG_BODY", "TAG_DIV", "TAG_H1", "TAG_H2", "TAG_H3", "TAG_H4", 
			"TAG_H5", "TAG_H6", "TAG_P", "TAG_A", "TAG_IMG", "TAG_BR", "TAG_HR", 
			"TAG_INPUT", "TAG_FORM", "TAG_LABEL", "TAG_BUTTON", "TAG_STRONG", "TAG_B", 
			"TAG_I", "TAG_EM", "TAG_U", "TAG_SMALL", "TAG_MARK", "TAG_SUB", "TAG_SUP", 
			"TAG_BLOCKQUOTE", "TAG_CODE", "TAG_PRE", "TAG_SELECT", "TAG_OPTION", 
			"TAG_TEXTAREA", "TAG_DATALIST", "TAG_FIELDSET", "TAG_LEGEND", "TAG_OPTGROUP", 
			"TAG_AUDIO", "TAG_VIDEO", "TAG_CANVAS", "TAG_SVG", "TAG_PICTURE", "TAG_UL", 
			"TAG_OL", "TAG_LI", "TAG_DL", "TAG_DT", "TAG_DD", "TAG_TABLE", "TAG_THEAD", 
			"TAG_TBODY", "TAG_TFOOT", "TAG_TR", "TAG_TD", "TAG_TH", "TAG_CAPTION", 
			"TAG_COLGROUP", "TAG_FIGURE", "TAG_FIGCAPTION", "TAG_DETAILS", "TAG_SUMMARY", 
			"TAG_DIALOG", "TAG_LINK", "TAG_SOURCE", "TAG_TRACK", "TAG_WBR", "TAG_AREA", 
			"TAG_BASE", "TAG_COL", "TAG_EMBED", "TAG_PARAM", "TAG_SECTION", "TAG_ARTICLE", 
			"TAG_NAV", "TAG_ASIDE", "TAG_HEADER", "TAG_FOOTER", "TAG_MAIN", "TAG_SPAN", 
			"ATTR_HIDDEN", "ATTR_DRAGGABLE", "ATTR_CONTENTEDITABLE", "ATTR_TRANSLATE", 
			"ATTR_REQUIRED", "ATTR_READONLY", "ATTR_DISABLED", "ATTR_CHECKED", "ATTR_MULTIPLE", 
			"ATTR_NOVALIDATE", "ATTR_CONTROLS", "ATTR_AUTOPLAY", "ATTR_LOOP", "ATTR_MUTED", 
			"ATTR_ID", "ATTR_CLASS", "ATTR_TITLE", "ATTR_LANG", "ATTR_DIR", "ATTR_TABINDEX", 
			"ATTR_ACCESSKEY", "ATTR_HREF", "ATTR_TARGET", "ATTR_REL", "ATTR_DOWNLOAD", 
			"ATTR_REFERRERPOLICY", "ATTR_SRC", "ATTR_ALT", "ATTR_WIDTH", "ATTR_HEIGHT", 
			"ATTR_LOADING", "ATTR_DECODING", "ATTR_TYPE", "ATTR_NAME", "ATTR_VALUE", 
			"ATTR_PLACEHOLDER", "ATTR_MAX", "ATTR_MIN", "ATTR_STEP", "ATTR_PATTERN", 
			"ATTR_MAXLENGTH", "ATTR_MINLENGTH", "ATTR_ACCEPT", "ATTR_AUTOCOMPLETE", 
			"ATTR_SIZE", "ATTR_METHOD", "ATTR_ACTION", "ATTR_ENCTYPE", "ATTR_AUTOFILL", 
			"ATTR_ONCLICK", "ATTR_ONCHANGE", "ATTR_ONSUBMIT", "ATTR_ONINPUT", "ATTR_ONLOAD", 
			"ATTR_PRELOAD", "ATTR_POSTER", "ATTR_COLSPAN", "ATTR_ROWSPAN", "ATTR_SCOPE", 
			"ATTR_CHARSET", "ATTR_CONTENT", "ATTR_HTTP_EQUIV", "ATTR_PROPERTY", "VALUE_LANG_EN", 
			"VALUE_LANG_AR", "ATTRIBUTE_NAME", "ATTRIBUTE_VALUE", "SLASH_CLOSE", 
			"CLOSE", "TAG_WS", "STYLE_END", "CSS_TWOPOINT", "CSS_SEMI", "CSS_TEXT_PROPERTY", 
			"CSS_ATTR_COLOR", "CSS_LENGTH_PROPERTY", "CSS_OFFSET_PROPERTY", "CSS_LAYOUT_PROPERTY", 
			"CSS_URL_PROPERTY", "CSS_REPEAT_PROPERTY", "CSS_POSITION_PROPERTY", "CSS_BORDER_PROPERTY", 
			"CSS_BORDER_STYLE_PROPERTY", "CSS_BORDER_WIDTH_PROPERTY", "CSS_FONT_PROPERTY", 
			"CSS_EFFECT_PROPERTY", "CSS_SHORTHAND_VALUE", "CSS_TEXT_VALUE", "CSS_EFFECT_VALUE", 
			"CSS_LAYOUT_VALUE", "CSS_COLOR_VALUE", "CSS_URL_VALUE", "CSS_REPEAT_VALUE", 
			"CSS_POSITION_VALUE", "CSS_BORDER_STYLE_VALUE", "CSS_BORDER_WIDTH_VALUE", 
			"CSS_FONT_VALUE", "CSS_GENERIC_VALUE", "STYLE_WS", "JINJA_EXPR_END", 
			"JINJA_EXPR_WS", "JINJA_EXPR_STRING", "JINJA_EXPR_ATOM", "JINJA_EXPR_SYMBOL", 
			"JINJA_EXPR_UNKNOWN", "JINJA_STMT_END", "JINJA_STMT_IF", "JINJA_STMT_ENDIF", 
			"JINJA_STMT_FOR", "JINJA_STMT_ENDFOR", "JINJA_STMT_ELSE", "JINJA_STMT_ELIF", 
			"JINJA_STMT_IN", "JINJA_STMT_SET", "JINJA_STMT_BLOCK", "JINJA_STMT_ENDBLOCK", 
			"JINJA_STMT_WITH", "JINJA_STMT_ENDWITH", "JINJA_STMT_MACRO", "JINJA_STMT_ENDMACRO", 
			"JINJA_STMT_INCLUDE", "JINJA_STMT_EXTENDS", "JINJA_STMT_FROM", "JINJA_STMT_WS", 
			"JINJA_STMT_STRING", "JINJA_STMT_ATOM", "JINJA_STMT_SYMBOL", "JINJA_STMT_UNKNOWN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HTMLCSSJINJA_parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HTMLCSSJINJA_parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
	 
		public DocumentContext() { }
		public void copyFrom(DocumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DocumentLabelContext extends DocumentContext {
		public TerminalNode EOF() { return getToken(HTMLCSSJINJA_parser.EOF, 0); }
		public List<HtmlContext> html() {
			return getRuleContexts(HtmlContext.class);
		}
		public HtmlContext html(int i) {
			return getRuleContext(HtmlContext.class,i);
		}
		public DocumentLabelContext(DocumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterDocumentLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitDocumentLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitDocumentLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			_localctx = new DocumentLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 236L) != 0)) {
				{
				{
				setState(102);
				html();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContext extends ParserRuleContext {
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
	 
		public HtmlContext() { }
		public void copyFrom(HtmlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElementlabelContext extends HtmlContext {
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public JinjaElementlabelContext(HtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaElementlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaElementlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaElementlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoctipelabelContext extends HtmlContext {
		public DoctipeContext doctipe() {
			return getRuleContext(DoctipeContext.class,0);
		}
		public DoctipelabelContext(HtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterDoctipelabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitDoctipelabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitDoctipelabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlelementlabelContext extends HtmlContext {
		public HtmlelementContext htmlelement() {
			return getRuleContext(HtmlelementContext.class,0);
		}
		public HtmlelementlabelContext(HtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterHtmlelementlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitHtmlelementlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitHtmlelementlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlcommentlabelContext extends HtmlContext {
		public TerminalNode HTML_COMMENT() { return getToken(HTMLCSSJINJA_parser.HTML_COMMENT, 0); }
		public HtmlcommentlabelContext(HtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterHtmlcommentlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitHtmlcommentlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitHtmlcommentlabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_html);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new HtmlelementlabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				htmlelement();
				}
				break;
			case 2:
				_localctx = new HtmlcommentlabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(HTML_COMMENT);
				}
				break;
			case 3:
				_localctx = new DoctipelabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				doctipe();
				}
				break;
			case 4:
				_localctx = new JinjaElementlabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				jinjaElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoctipeContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public TerminalNode TAG_DOCTYPE() { return getToken(HTMLCSSJINJA_parser.TAG_DOCTYPE, 0); }
		public TerminalNode CLOSE() { return getToken(HTMLCSSJINJA_parser.CLOSE, 0); }
		public DoctipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterDoctipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitDoctipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitDoctipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctipeContext doctipe() throws RecognitionException {
		DoctipeContext _localctx = new DoctipeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_doctipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(OPEN_TAG_START);
			setState(117);
			match(TAG_DOCTYPE);
			setState(118);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlelementContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public List<TerminalNode> TAG_HTML() { return getTokens(HTMLCSSJINJA_parser.TAG_HTML); }
		public TerminalNode TAG_HTML(int i) {
			return getToken(HTMLCSSJINJA_parser.TAG_HTML, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(HTMLCSSJINJA_parser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(HTMLCSSJINJA_parser.CLOSE, i);
		}
		public TerminalNode END_TAG_START() { return getToken(HTMLCSSJINJA_parser.END_TAG_START, 0); }
		public List<AttruputehtmlContext> attruputehtml() {
			return getRuleContexts(AttruputehtmlContext.class);
		}
		public AttruputehtmlContext attruputehtml(int i) {
			return getRuleContext(AttruputehtmlContext.class,i);
		}
		public List<ContenthtmlContext> contenthtml() {
			return getRuleContexts(ContenthtmlContext.class);
		}
		public ContenthtmlContext contenthtml(int i) {
			return getRuleContext(ContenthtmlContext.class,i);
		}
		public HtmlelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterHtmlelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitHtmlelement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitHtmlelement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlelementContext htmlelement() throws RecognitionException {
		HtmlelementContext _localctx = new HtmlelementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlelement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(OPEN_TAG_START);
			setState(121);
			match(TAG_HTML);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ATTR_LANG) {
				{
				{
				setState(122);
				attruputehtml();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(CLOSE);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_TAG_START) {
				{
				{
				setState(129);
				contenthtml();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(END_TAG_START);
			setState(136);
			match(TAG_HTML);
			setState(137);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttruputehtmlContext extends ParserRuleContext {
		public AttributehtmlContext attributehtml() {
			return getRuleContext(AttributehtmlContext.class,0);
		}
		public AttruputehtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attruputehtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttruputehtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttruputehtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttruputehtml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttruputehtmlContext attruputehtml() throws RecognitionException {
		AttruputehtmlContext _localctx = new AttruputehtmlContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attruputehtml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			attributehtml();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributehtmlContext extends ParserRuleContext {
		public AttributehtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributehtml; }
	 
		public AttributehtmlContext() { }
		public void copyFrom(AttributehtmlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LangAttributeLabelContext extends AttributehtmlContext {
		public TerminalNode ATTR_LANG() { return getToken(HTMLCSSJINJA_parser.ATTR_LANG, 0); }
		public TerminalNode EQUALS() { return getToken(HTMLCSSJINJA_parser.EQUALS, 0); }
		public TerminalNode VALUE_LANG_EN() { return getToken(HTMLCSSJINJA_parser.VALUE_LANG_EN, 0); }
		public TerminalNode VALUE_LANG_AR() { return getToken(HTMLCSSJINJA_parser.VALUE_LANG_AR, 0); }
		public LangAttributeLabelContext(AttributehtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterLangAttributeLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitLangAttributeLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitLangAttributeLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributehtmlContext attributehtml() throws RecognitionException {
		AttributehtmlContext _localctx = new AttributehtmlContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attributehtml);
		int _la;
		try {
			_localctx = new LangAttributeLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ATTR_LANG);
			setState(142);
			match(EQUALS);
			setState(143);
			_la = _input.LA(1);
			if ( !(_la==VALUE_LANG_EN || _la==VALUE_LANG_AR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContenthtmlContext extends ParserRuleContext {
		public ContenthtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contenthtml; }
	 
		public ContenthtmlContext() { }
		public void copyFrom(ContenthtmlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HeadlabelContext extends ContenthtmlContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public HeadlabelContext(ContenthtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterHeadlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitHeadlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitHeadlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BodylabelContext extends ContenthtmlContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BodylabelContext(ContenthtmlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBodylabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBodylabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBodylabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContenthtmlContext contenthtml() throws RecognitionException {
		ContenthtmlContext _localctx = new ContenthtmlContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contenthtml);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new HeadlabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				head();
				}
				break;
			case 2:
				_localctx = new BodylabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				body();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(HTMLCSSJINJA_parser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeadContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public List<TerminalNode> TAG_HEAD() { return getTokens(HTMLCSSJINJA_parser.TAG_HEAD); }
		public TerminalNode TAG_HEAD(int i) {
			return getToken(HTMLCSSJINJA_parser.TAG_HEAD, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(HTMLCSSJINJA_parser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(HTMLCSSJINJA_parser.CLOSE, i);
		}
		public TerminalNode END_TAG_START() { return getToken(HTMLCSSJINJA_parser.END_TAG_START, 0); }
		public List<ContentheadContext> contenthead() {
			return getRuleContexts(ContentheadContext.class);
		}
		public ContentheadContext contenthead(int i) {
			return getRuleContext(ContentheadContext.class,i);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(OPEN_TAG_START);
			setState(152);
			match(TAG_HEAD);
			setState(153);
			match(CLOSE);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 172L) != 0)) {
				{
				{
				setState(154);
				contenthead();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			match(END_TAG_START);
			setState(161);
			match(TAG_HEAD);
			setState(162);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public List<TerminalNode> TAG_BODY() { return getTokens(HTMLCSSJINJA_parser.TAG_BODY); }
		public TerminalNode TAG_BODY(int i) {
			return getToken(HTMLCSSJINJA_parser.TAG_BODY, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(HTMLCSSJINJA_parser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(HTMLCSSJINJA_parser.CLOSE, i);
		}
		public TerminalNode END_TAG_START() { return getToken(HTMLCSSJINJA_parser.END_TAG_START, 0); }
		public List<AttributebodyContext> attributebody() {
			return getRuleContexts(AttributebodyContext.class);
		}
		public AttributebodyContext attributebody(int i) {
			return getRuleContext(AttributebodyContext.class,i);
		}
		public List<ContentbodyContext> contentbody() {
			return getRuleContexts(ContentbodyContext.class);
		}
		public ContentbodyContext contentbody(int i) {
			return getRuleContext(ContentbodyContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(OPEN_TAG_START);
			setState(165);
			match(TAG_BODY);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STYLE_ATTRIBUTE_START || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 9223372036854775807L) != 0)) {
				{
				{
				setState(166);
				attributebody();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(CLOSE);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 428L) != 0)) {
				{
				{
				setState(173);
				contentbody();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(END_TAG_START);
			setState(180);
			match(TAG_BODY);
			setState(181);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentheadContext extends ParserRuleContext {
		public ContentheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contenthead; }
	 
		public ContentheadContext() { }
		public void copyFrom(ContentheadContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjasecondElementlabelContext extends ContentheadContext {
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public JinjasecondElementlabelContext(ContentheadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjasecondElementlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjasecondElementlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjasecondElementlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalTagElementheadlabelContext extends ContentheadContext {
		public NormalTagElementheadContext normalTagElementhead() {
			return getRuleContext(NormalTagElementheadContext.class,0);
		}
		public NormalTagElementheadlabelContext(ContentheadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterNormalTagElementheadlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitNormalTagElementheadlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitNormalTagElementheadlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagElementheadlabelContext extends ContentheadContext {
		public SelfClosingTagElementheadContext selfClosingTagElementhead() {
			return getRuleContext(SelfClosingTagElementheadContext.class,0);
		}
		public SelfClosingTagElementheadlabelContext(ContentheadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterSelfClosingTagElementheadlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitSelfClosingTagElementheadlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitSelfClosingTagElementheadlabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentheadContext contenthead() throws RecognitionException {
		ContentheadContext _localctx = new ContentheadContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_contenthead);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new NormalTagElementheadlabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				normalTagElementhead();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagElementheadlabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				selfClosingTagElementhead();
				}
				break;
			case 3:
				_localctx = new JinjasecondElementlabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				jinjaElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NormalTagElementheadContext extends ParserRuleContext {
		public NormalTagElementheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalTagElementhead; }
	 
		public NormalTagElementheadContext() { }
		public void copyFrom(NormalTagElementheadContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormaltagheadContext extends NormalTagElementheadContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public List<TagsheadnormalContext> tagsheadnormal() {
			return getRuleContexts(TagsheadnormalContext.class);
		}
		public TagsheadnormalContext tagsheadnormal(int i) {
			return getRuleContext(TagsheadnormalContext.class,i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(HTMLCSSJINJA_parser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(HTMLCSSJINJA_parser.CLOSE, i);
		}
		public TerminalNode END_TAG_START() { return getToken(HTMLCSSJINJA_parser.END_TAG_START, 0); }
		public List<AttributeheadContext> attributehead() {
			return getRuleContexts(AttributeheadContext.class);
		}
		public AttributeheadContext attributehead(int i) {
			return getRuleContext(AttributeheadContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public NormaltagheadContext(NormalTagElementheadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterNormaltaghead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitNormaltaghead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitNormaltaghead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalTagElementheadContext normalTagElementhead() throws RecognitionException {
		NormalTagElementheadContext _localctx = new NormalTagElementheadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_normalTagElementhead);
		int _la;
		try {
			_localctx = new NormaltagheadContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(OPEN_TAG_START);
			setState(189);
			tagsheadnormal();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & 1006632961L) != 0)) {
				{
				{
				setState(190);
				attributehead();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(CLOSE);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TEXT) {
				{
				{
				setState(197);
				text();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(END_TAG_START);
			setState(204);
			tagsheadnormal();
			setState(205);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagsheadnormalContext extends ParserRuleContext {
		public TerminalNode TAG_TITLE() { return getToken(HTMLCSSJINJA_parser.TAG_TITLE, 0); }
		public TagsheadnormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagsheadnormal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTagsheadnormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTagsheadnormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTagsheadnormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsheadnormalContext tagsheadnormal() throws RecognitionException {
		TagsheadnormalContext _localctx = new TagsheadnormalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tagsheadnormal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(TAG_TITLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagElementheadContext extends ParserRuleContext {
		public SelfClosingTagElementheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingTagElementhead; }
	 
		public SelfClosingTagElementheadContext() { }
		public void copyFrom(SelfClosingTagElementheadContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfclostaglabelContext extends SelfClosingTagElementheadContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public TagsheadselfContext tagsheadself() {
			return getRuleContext(TagsheadselfContext.class,0);
		}
		public TerminalNode SLASH_CLOSE() { return getToken(HTMLCSSJINJA_parser.SLASH_CLOSE, 0); }
		public List<AttributeheadContext> attributehead() {
			return getRuleContexts(AttributeheadContext.class);
		}
		public AttributeheadContext attributehead(int i) {
			return getRuleContext(AttributeheadContext.class,i);
		}
		public SelfclostaglabelContext(SelfClosingTagElementheadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterSelfclostaglabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitSelfclostaglabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitSelfclostaglabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingTagElementheadContext selfClosingTagElementhead() throws RecognitionException {
		SelfClosingTagElementheadContext _localctx = new SelfClosingTagElementheadContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_selfClosingTagElementhead);
		int _la;
		try {
			_localctx = new SelfclostaglabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(OPEN_TAG_START);
			setState(210);
			tagsheadself();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & 1006632961L) != 0)) {
				{
				{
				setState(211);
				attributehead();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			match(SLASH_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagsheadselfContext extends ParserRuleContext {
		public TerminalNode TAG_META() { return getToken(HTMLCSSJINJA_parser.TAG_META, 0); }
		public TagsheadselfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagsheadself; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTagsheadself(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTagsheadself(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTagsheadself(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsheadselfContext tagsheadself() throws RecognitionException {
		TagsheadselfContext _localctx = new TagsheadselfContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tagsheadself);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TAG_META);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentbodyContext extends ParserRuleContext {
		public ContentbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentbody; }
	 
		public ContentbodyContext() { }
		public void copyFrom(ContentbodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextlabelContext extends ContentbodyContext {
		public TerminalNode TEXT() { return getToken(HTMLCSSJINJA_parser.TEXT, 0); }
		public TextlabelContext(ContentbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTextlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTextlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTextlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalTagElementbodylabelContext extends ContentbodyContext {
		public NormalTagElementbodyContext normalTagElementbody() {
			return getRuleContext(NormalTagElementbodyContext.class,0);
		}
		public NormalTagElementbodylabelContext(ContentbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterNormalTagElementbodylabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitNormalTagElementbodylabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitNormalTagElementbodylabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagElementbodylabelContext extends ContentbodyContext {
		public SelfClosingTagElementbodyContext selfClosingTagElementbody() {
			return getRuleContext(SelfClosingTagElementbodyContext.class,0);
		}
		public SelfClosingTagElementbodylabelContext(ContentbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterSelfClosingTagElementbodylabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitSelfClosingTagElementbodylabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitSelfClosingTagElementbodylabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjathirdElementlabelContext extends ContentbodyContext {
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public JinjathirdElementlabelContext(ContentbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjathirdElementlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjathirdElementlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjathirdElementlabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentbodyContext contentbody() throws RecognitionException {
		ContentbodyContext _localctx = new ContentbodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_contentbody);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new NormalTagElementbodylabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				normalTagElementbody();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagElementbodylabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				selfClosingTagElementbody();
				}
				break;
			case 3:
				_localctx = new JinjathirdElementlabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				jinjaElement();
				}
				break;
			case 4:
				_localctx = new TextlabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NormalTagElementbodyContext extends ParserRuleContext {
		public NormalTagElementbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalTagElementbody; }
	 
		public NormalTagElementbodyContext() { }
		public void copyFrom(NormalTagElementbodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Normal_Tag_Element_bodyContext extends NormalTagElementbodyContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public List<TagsbodynamenormalContext> tagsbodynamenormal() {
			return getRuleContexts(TagsbodynamenormalContext.class);
		}
		public TagsbodynamenormalContext tagsbodynamenormal(int i) {
			return getRuleContext(TagsbodynamenormalContext.class,i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(HTMLCSSJINJA_parser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(HTMLCSSJINJA_parser.CLOSE, i);
		}
		public TerminalNode END_TAG_START() { return getToken(HTMLCSSJINJA_parser.END_TAG_START, 0); }
		public List<AttributebodyContext> attributebody() {
			return getRuleContexts(AttributebodyContext.class);
		}
		public AttributebodyContext attributebody(int i) {
			return getRuleContext(AttributebodyContext.class,i);
		}
		public List<ContentbodyContext> contentbody() {
			return getRuleContexts(ContentbodyContext.class);
		}
		public ContentbodyContext contentbody(int i) {
			return getRuleContext(ContentbodyContext.class,i);
		}
		public Normal_Tag_Element_bodyContext(NormalTagElementbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterNormal_Tag_Element_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitNormal_Tag_Element_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitNormal_Tag_Element_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalTagElementbodyContext normalTagElementbody() throws RecognitionException {
		NormalTagElementbodyContext _localctx = new NormalTagElementbodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_normalTagElementbody);
		int _la;
		try {
			_localctx = new Normal_Tag_Element_bodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(OPEN_TAG_START);
			setState(228);
			tagsbodynamenormal();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STYLE_ATTRIBUTE_START || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 9223372036854775807L) != 0)) {
				{
				{
				setState(229);
				attributebody();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(CLOSE);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 428L) != 0)) {
				{
				{
				setState(236);
				contentbody();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			match(END_TAG_START);
			setState(243);
			tagsbodynamenormal();
			setState(244);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attribute_styleContext extends ParserRuleContext {
		public Attribute_styleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_style; }
	 
		public Attribute_styleContext() { }
		public void copyFrom(Attribute_styleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StylelabelContext extends Attribute_styleContext {
		public TerminalNode STYLE_ATTRIBUTE_START() { return getToken(HTMLCSSJINJA_parser.STYLE_ATTRIBUTE_START, 0); }
		public TerminalNode STYLE_END() { return getToken(HTMLCSSJINJA_parser.STYLE_END, 0); }
		public List<StylenameContext> stylename() {
			return getRuleContexts(StylenameContext.class);
		}
		public StylenameContext stylename(int i) {
			return getRuleContext(StylenameContext.class,i);
		}
		public StylelabelContext(Attribute_styleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterStylelabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitStylelabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitStylelabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_styleContext attribute_style() throws RecognitionException {
		Attribute_styleContext _localctx = new Attribute_styleContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_attribute_style);
		int _la;
		try {
			_localctx = new StylelabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(STYLE_ATTRIBUTE_START);
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(247);
				stylename();
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & 8191L) != 0) );
			setState(252);
			match(STYLE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylenameContext extends ParserRuleContext {
		public StylenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylename; }
	 
		public StylenameContext() { }
		public void copyFrom(StylenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextCssLabelContext extends StylenameContext {
		public TextcssContext textcss() {
			return getRuleContext(TextcssContext.class,0);
		}
		public TextCssLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTextCssLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTextCssLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTextCssLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BorderWidthLabelContext extends StylenameContext {
		public Border_widthContext border_width() {
			return getRuleContext(Border_widthContext.class,0);
		}
		public BorderWidthLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorderWidthLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorderWidthLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorderWidthLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BorderLabelContext extends StylenameContext {
		public BorderContext border() {
			return getRuleContext(BorderContext.class,0);
		}
		public BorderLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorderLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorderLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorderLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FontLabelContext extends StylenameContext {
		public FontContext font() {
			return getRuleContext(FontContext.class,0);
		}
		public FontLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterFontLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitFontLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitFontLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UrlLabelContext extends StylenameContext {
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public UrlLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterUrlLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitUrlLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitUrlLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LengthLabelContext extends StylenameContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public LengthLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterLengthLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitLengthLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitLengthLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PositionLabelContext extends StylenameContext {
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public PositionLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterPositionLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitPositionLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitPositionLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EffectLabelContext extends StylenameContext {
		public EffectContext effect() {
			return getRuleContext(EffectContext.class,0);
		}
		public EffectLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterEffectLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitEffectLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitEffectLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatLabelContext extends StylenameContext {
		public RepeatContext repeat() {
			return getRuleContext(RepeatContext.class,0);
		}
		public RepeatLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterRepeatLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitRepeatLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitRepeatLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColorLabelContext extends StylenameContext {
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public ColorLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterColorLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitColorLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitColorLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LayoutLabelContext extends StylenameContext {
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public LayoutLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterLayoutLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitLayoutLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitLayoutLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OffsetLabelContext extends StylenameContext {
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public OffsetLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterOffsetLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitOffsetLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitOffsetLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BorderStyleLabelContext extends StylenameContext {
		public Border_styleContext border_style() {
			return getRuleContext(Border_styleContext.class,0);
		}
		public BorderStyleLabelContext(StylenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorderStyleLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorderStyleLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorderStyleLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylenameContext stylename() throws RecognitionException {
		StylenameContext _localctx = new StylenameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stylename);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_ATTR_COLOR:
				_localctx = new ColorLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				color();
				}
				break;
			case CSS_LENGTH_PROPERTY:
				_localctx = new LengthLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				length();
				}
				break;
			case CSS_URL_PROPERTY:
				_localctx = new UrlLabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				url();
				}
				break;
			case CSS_REPEAT_PROPERTY:
				_localctx = new RepeatLabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				repeat();
				}
				break;
			case CSS_POSITION_PROPERTY:
				_localctx = new PositionLabelContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				position();
				}
				break;
			case CSS_BORDER_STYLE_PROPERTY:
				_localctx = new BorderStyleLabelContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				border_style();
				}
				break;
			case CSS_BORDER_WIDTH_PROPERTY:
				_localctx = new BorderWidthLabelContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				border_width();
				}
				break;
			case CSS_BORDER_PROPERTY:
				_localctx = new BorderLabelContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(261);
				border();
				}
				break;
			case CSS_FONT_PROPERTY:
				_localctx = new FontLabelContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				font();
				}
				break;
			case CSS_TEXT_PROPERTY:
				_localctx = new TextCssLabelContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(263);
				textcss();
				}
				break;
			case CSS_EFFECT_PROPERTY:
				_localctx = new EffectLabelContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(264);
				effect();
				}
				break;
			case CSS_LAYOUT_PROPERTY:
				_localctx = new LayoutLabelContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(265);
				layout();
				}
				break;
			case CSS_OFFSET_PROPERTY:
				_localctx = new OffsetLabelContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(266);
				offset();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorContext extends ParserRuleContext {
		public TerminalNode CSS_ATTR_COLOR() { return getToken(HTMLCSSJINJA_parser.CSS_ATTR_COLOR, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_COLOR_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_COLOR_VALUE, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(CSS_ATTR_COLOR);
			setState(270);
			match(CSS_TWOPOINT);
			setState(271);
			match(CSS_COLOR_VALUE);
			setState(272);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LengthContext extends ParserRuleContext {
		public TerminalNode CSS_LENGTH_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_LENGTH_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public List<Css_valueContext> css_value() {
			return getRuleContexts(Css_valueContext.class);
		}
		public Css_valueContext css_value(int i) {
			return getRuleContext(Css_valueContext.class,i);
		}
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_length);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(CSS_LENGTH_PROPERTY);
			setState(275);
			match(CSS_TWOPOINT);
			setState(277); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				css_value();
				}
				}
				setState(279); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0) );
			setState(281);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UrlContext extends ParserRuleContext {
		public TerminalNode CSS_URL_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_URL_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_URL_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_URL_VALUE, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(CSS_URL_PROPERTY);
			setState(284);
			match(CSS_TWOPOINT);
			setState(285);
			match(CSS_URL_VALUE);
			setState(286);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatContext extends ParserRuleContext {
		public TerminalNode CSS_REPEAT_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_REPEAT_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_REPEAT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_REPEAT_VALUE, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public RepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitRepeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatContext repeat() throws RecognitionException {
		RepeatContext _localctx = new RepeatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_repeat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(CSS_REPEAT_PROPERTY);
			setState(289);
			match(CSS_TWOPOINT);
			setState(290);
			match(CSS_REPEAT_VALUE);
			setState(291);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public TerminalNode CSS_POSITION_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_POSITION_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public List<Css_valueContext> css_value() {
			return getRuleContexts(Css_valueContext.class);
		}
		public Css_valueContext css_value(int i) {
			return getRuleContext(Css_valueContext.class,i);
		}
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_position);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(CSS_POSITION_PROPERTY);
			setState(294);
			match(CSS_TWOPOINT);
			setState(296); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(295);
				css_value();
				}
				}
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0) );
			setState(300);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OffsetContext extends ParserRuleContext {
		public TerminalNode CSS_OFFSET_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_OFFSET_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public Css_valueContext css_value() {
			return getRuleContext(Css_valueContext.class,0);
		}
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(CSS_OFFSET_PROPERTY);
			setState(303);
			match(CSS_TWOPOINT);
			setState(304);
			css_value();
			setState(305);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Border_styleContext extends ParserRuleContext {
		public TerminalNode CSS_BORDER_STYLE_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_STYLE_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_BORDER_STYLE_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_STYLE_VALUE, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public Border_styleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_border_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorder_style(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorder_style(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorder_style(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Border_styleContext border_style() throws RecognitionException {
		Border_styleContext _localctx = new Border_styleContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_border_style);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(CSS_BORDER_STYLE_PROPERTY);
			setState(308);
			match(CSS_TWOPOINT);
			setState(309);
			match(CSS_BORDER_STYLE_VALUE);
			setState(310);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Border_widthContext extends ParserRuleContext {
		public TerminalNode CSS_BORDER_WIDTH_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_WIDTH_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public TerminalNode CSS_BORDER_WIDTH_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_WIDTH_VALUE, 0); }
		public Css_valueContext css_value() {
			return getRuleContext(Css_valueContext.class,0);
		}
		public Border_widthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_border_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorder_width(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorder_width(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorder_width(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Border_widthContext border_width() throws RecognitionException {
		Border_widthContext _localctx = new Border_widthContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_border_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(CSS_BORDER_WIDTH_PROPERTY);
			setState(313);
			match(CSS_TWOPOINT);
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(314);
				match(CSS_BORDER_WIDTH_VALUE);
				}
				break;
			case 2:
				{
				setState(315);
				css_value();
				}
				break;
			}
			setState(318);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BorderContext extends ParserRuleContext {
		public TerminalNode CSS_BORDER_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public List<Css_valueContext> css_value() {
			return getRuleContexts(Css_valueContext.class);
		}
		public Css_valueContext css_value(int i) {
			return getRuleContext(Css_valueContext.class,i);
		}
		public List<TerminalNode> CSS_COLOR_VALUE() { return getTokens(HTMLCSSJINJA_parser.CSS_COLOR_VALUE); }
		public TerminalNode CSS_COLOR_VALUE(int i) {
			return getToken(HTMLCSSJINJA_parser.CSS_COLOR_VALUE, i);
		}
		public BorderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_border; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterBorder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitBorder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitBorder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BorderContext border() throws RecognitionException {
		BorderContext _localctx = new BorderContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_border);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(CSS_BORDER_PROPERTY);
			setState(321);
			match(CSS_TWOPOINT);
			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(324);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(322);
					css_value();
					}
					break;
				case 2:
					{
					setState(323);
					match(CSS_COLOR_VALUE);
					}
					break;
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0) );
			setState(328);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FontContext extends ParserRuleContext {
		public TerminalNode CSS_FONT_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_FONT_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public TerminalNode CSS_FONT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_FONT_VALUE, 0); }
		public Css_valueContext css_value() {
			return getRuleContext(Css_valueContext.class,0);
		}
		public FontContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_font; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterFont(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitFont(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitFont(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FontContext font() throws RecognitionException {
		FontContext _localctx = new FontContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_font);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(CSS_FONT_PROPERTY);
			setState(331);
			match(CSS_TWOPOINT);
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(332);
				match(CSS_FONT_VALUE);
				}
				break;
			case 2:
				{
				setState(333);
				css_value();
				}
				break;
			}
			setState(336);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextcssContext extends ParserRuleContext {
		public TerminalNode CSS_TEXT_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_TEXT_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public Css_valueContext css_value() {
			return getRuleContext(Css_valueContext.class,0);
		}
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public TextcssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textcss; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTextcss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTextcss(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTextcss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextcssContext textcss() throws RecognitionException {
		TextcssContext _localctx = new TextcssContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_textcss);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(CSS_TEXT_PROPERTY);
			setState(339);
			match(CSS_TWOPOINT);
			setState(340);
			css_value();
			setState(341);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EffectContext extends ParserRuleContext {
		public TerminalNode CSS_EFFECT_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_EFFECT_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public List<Css_valueContext> css_value() {
			return getRuleContexts(Css_valueContext.class);
		}
		public Css_valueContext css_value(int i) {
			return getRuleContext(Css_valueContext.class,i);
		}
		public EffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterEffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitEffect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitEffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectContext effect() throws RecognitionException {
		EffectContext _localctx = new EffectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_effect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(CSS_EFFECT_PROPERTY);
			setState(344);
			match(CSS_TWOPOINT);
			setState(346); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(345);
				css_value();
				}
				}
				setState(348); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0) );
			setState(350);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LayoutContext extends ParserRuleContext {
		public TerminalNode CSS_LAYOUT_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_LAYOUT_PROPERTY, 0); }
		public TerminalNode CSS_TWOPOINT() { return getToken(HTMLCSSJINJA_parser.CSS_TWOPOINT, 0); }
		public TerminalNode CSS_SEMI() { return getToken(HTMLCSSJINJA_parser.CSS_SEMI, 0); }
		public List<Css_valueContext> css_value() {
			return getRuleContexts(Css_valueContext.class);
		}
		public Css_valueContext css_value(int i) {
			return getRuleContext(Css_valueContext.class,i);
		}
		public LayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterLayout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitLayout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitLayout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutContext layout() throws RecognitionException {
		LayoutContext _localctx = new LayoutContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_layout);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(CSS_LAYOUT_PROPERTY);
			setState(353);
			match(CSS_TWOPOINT);
			setState(355); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(354);
				css_value();
				}
				}
				setState(357); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0) );
			setState(359);
			match(CSS_SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Css_valueContext extends ParserRuleContext {
		public TerminalNode CSS_SHORTHAND_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_SHORTHAND_VALUE, 0); }
		public TerminalNode CSS_TEXT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_TEXT_VALUE, 0); }
		public TerminalNode CSS_LAYOUT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_LAYOUT_VALUE, 0); }
		public TerminalNode CSS_EFFECT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_EFFECT_VALUE, 0); }
		public TerminalNode CSS_OFFSET_PROPERTY() { return getToken(HTMLCSSJINJA_parser.CSS_OFFSET_PROPERTY, 0); }
		public TerminalNode CSS_BORDER_STYLE_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_STYLE_VALUE, 0); }
		public TerminalNode CSS_BORDER_WIDTH_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_BORDER_WIDTH_VALUE, 0); }
		public TerminalNode CSS_FONT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_FONT_VALUE, 0); }
		public TerminalNode CSS_COLOR_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_COLOR_VALUE, 0); }
		public TerminalNode CSS_URL_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_URL_VALUE, 0); }
		public TerminalNode CSS_REPEAT_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_REPEAT_VALUE, 0); }
		public TerminalNode CSS_POSITION_VALUE() { return getToken(HTMLCSSJINJA_parser.CSS_POSITION_VALUE, 0); }
		public Css_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_css_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterCss_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitCss_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitCss_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Css_valueContext css_value() throws RecognitionException {
		Css_valueContext _localctx = new Css_valueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_css_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(((((_la - 170)) & ~0x3f) == 0 && ((1L << (_la - 170)) & 2096129L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagsbodynamenormalContext extends ParserRuleContext {
		public TerminalNode TAG_DIV() { return getToken(HTMLCSSJINJA_parser.TAG_DIV, 0); }
		public TerminalNode TAG_H1() { return getToken(HTMLCSSJINJA_parser.TAG_H1, 0); }
		public TerminalNode TAG_H2() { return getToken(HTMLCSSJINJA_parser.TAG_H2, 0); }
		public TerminalNode TAG_H3() { return getToken(HTMLCSSJINJA_parser.TAG_H3, 0); }
		public TerminalNode TAG_FORM() { return getToken(HTMLCSSJINJA_parser.TAG_FORM, 0); }
		public TerminalNode TAG_LABEL() { return getToken(HTMLCSSJINJA_parser.TAG_LABEL, 0); }
		public TerminalNode TAG_BUTTON() { return getToken(HTMLCSSJINJA_parser.TAG_BUTTON, 0); }
		public TerminalNode TAG_A() { return getToken(HTMLCSSJINJA_parser.TAG_A, 0); }
		public TerminalNode TAG_P() { return getToken(HTMLCSSJINJA_parser.TAG_P, 0); }
		public TerminalNode TAG_SECTION() { return getToken(HTMLCSSJINJA_parser.TAG_SECTION, 0); }
		public TerminalNode TAG_ARTICLE() { return getToken(HTMLCSSJINJA_parser.TAG_ARTICLE, 0); }
		public TerminalNode TAG_NAV() { return getToken(HTMLCSSJINJA_parser.TAG_NAV, 0); }
		public TerminalNode TAG_ASIDE() { return getToken(HTMLCSSJINJA_parser.TAG_ASIDE, 0); }
		public TerminalNode TAG_HEADER() { return getToken(HTMLCSSJINJA_parser.TAG_HEADER, 0); }
		public TerminalNode TAG_FOOTER() { return getToken(HTMLCSSJINJA_parser.TAG_FOOTER, 0); }
		public TerminalNode TAG_MAIN() { return getToken(HTMLCSSJINJA_parser.TAG_MAIN, 0); }
		public TerminalNode TAG_SPAN() { return getToken(HTMLCSSJINJA_parser.TAG_SPAN, 0); }
		public TerminalNode TAG_H4() { return getToken(HTMLCSSJINJA_parser.TAG_H4, 0); }
		public TerminalNode TAG_H5() { return getToken(HTMLCSSJINJA_parser.TAG_H5, 0); }
		public TerminalNode TAG_H6() { return getToken(HTMLCSSJINJA_parser.TAG_H6, 0); }
		public TerminalNode TAG_STRONG() { return getToken(HTMLCSSJINJA_parser.TAG_STRONG, 0); }
		public TerminalNode TAG_B() { return getToken(HTMLCSSJINJA_parser.TAG_B, 0); }
		public TerminalNode TAG_I() { return getToken(HTMLCSSJINJA_parser.TAG_I, 0); }
		public TerminalNode TAG_EM() { return getToken(HTMLCSSJINJA_parser.TAG_EM, 0); }
		public TerminalNode TAG_U() { return getToken(HTMLCSSJINJA_parser.TAG_U, 0); }
		public TerminalNode TAG_SMALL() { return getToken(HTMLCSSJINJA_parser.TAG_SMALL, 0); }
		public TerminalNode TAG_MARK() { return getToken(HTMLCSSJINJA_parser.TAG_MARK, 0); }
		public TerminalNode TAG_SUB() { return getToken(HTMLCSSJINJA_parser.TAG_SUB, 0); }
		public TerminalNode TAG_SUP() { return getToken(HTMLCSSJINJA_parser.TAG_SUP, 0); }
		public TerminalNode TAG_BLOCKQUOTE() { return getToken(HTMLCSSJINJA_parser.TAG_BLOCKQUOTE, 0); }
		public TerminalNode TAG_CODE() { return getToken(HTMLCSSJINJA_parser.TAG_CODE, 0); }
		public TerminalNode TAG_PRE() { return getToken(HTMLCSSJINJA_parser.TAG_PRE, 0); }
		public TerminalNode TAG_SELECT() { return getToken(HTMLCSSJINJA_parser.TAG_SELECT, 0); }
		public TerminalNode TAG_OPTION() { return getToken(HTMLCSSJINJA_parser.TAG_OPTION, 0); }
		public TerminalNode TAG_TEXTAREA() { return getToken(HTMLCSSJINJA_parser.TAG_TEXTAREA, 0); }
		public TerminalNode TAG_DATALIST() { return getToken(HTMLCSSJINJA_parser.TAG_DATALIST, 0); }
		public TerminalNode TAG_FIELDSET() { return getToken(HTMLCSSJINJA_parser.TAG_FIELDSET, 0); }
		public TerminalNode TAG_LEGEND() { return getToken(HTMLCSSJINJA_parser.TAG_LEGEND, 0); }
		public TerminalNode TAG_OPTGROUP() { return getToken(HTMLCSSJINJA_parser.TAG_OPTGROUP, 0); }
		public TerminalNode TAG_AUDIO() { return getToken(HTMLCSSJINJA_parser.TAG_AUDIO, 0); }
		public TerminalNode TAG_VIDEO() { return getToken(HTMLCSSJINJA_parser.TAG_VIDEO, 0); }
		public TerminalNode TAG_CANVAS() { return getToken(HTMLCSSJINJA_parser.TAG_CANVAS, 0); }
		public TerminalNode TAG_SVG() { return getToken(HTMLCSSJINJA_parser.TAG_SVG, 0); }
		public TerminalNode TAG_PICTURE() { return getToken(HTMLCSSJINJA_parser.TAG_PICTURE, 0); }
		public TerminalNode TAG_UL() { return getToken(HTMLCSSJINJA_parser.TAG_UL, 0); }
		public TerminalNode TAG_OL() { return getToken(HTMLCSSJINJA_parser.TAG_OL, 0); }
		public TerminalNode TAG_LI() { return getToken(HTMLCSSJINJA_parser.TAG_LI, 0); }
		public TerminalNode TAG_DL() { return getToken(HTMLCSSJINJA_parser.TAG_DL, 0); }
		public TerminalNode TAG_DT() { return getToken(HTMLCSSJINJA_parser.TAG_DT, 0); }
		public TerminalNode TAG_DD() { return getToken(HTMLCSSJINJA_parser.TAG_DD, 0); }
		public TerminalNode TAG_TABLE() { return getToken(HTMLCSSJINJA_parser.TAG_TABLE, 0); }
		public TerminalNode TAG_THEAD() { return getToken(HTMLCSSJINJA_parser.TAG_THEAD, 0); }
		public TerminalNode TAG_TBODY() { return getToken(HTMLCSSJINJA_parser.TAG_TBODY, 0); }
		public TerminalNode TAG_TFOOT() { return getToken(HTMLCSSJINJA_parser.TAG_TFOOT, 0); }
		public TerminalNode TAG_TR() { return getToken(HTMLCSSJINJA_parser.TAG_TR, 0); }
		public TerminalNode TAG_TD() { return getToken(HTMLCSSJINJA_parser.TAG_TD, 0); }
		public TerminalNode TAG_TH() { return getToken(HTMLCSSJINJA_parser.TAG_TH, 0); }
		public TerminalNode TAG_CAPTION() { return getToken(HTMLCSSJINJA_parser.TAG_CAPTION, 0); }
		public TerminalNode TAG_COLGROUP() { return getToken(HTMLCSSJINJA_parser.TAG_COLGROUP, 0); }
		public TerminalNode TAG_FIGURE() { return getToken(HTMLCSSJINJA_parser.TAG_FIGURE, 0); }
		public TerminalNode TAG_FIGCAPTION() { return getToken(HTMLCSSJINJA_parser.TAG_FIGCAPTION, 0); }
		public TerminalNode TAG_DETAILS() { return getToken(HTMLCSSJINJA_parser.TAG_DETAILS, 0); }
		public TerminalNode TAG_SUMMARY() { return getToken(HTMLCSSJINJA_parser.TAG_SUMMARY, 0); }
		public TerminalNode TAG_DIALOG() { return getToken(HTMLCSSJINJA_parser.TAG_DIALOG, 0); }
		public TagsbodynamenormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagsbodynamenormal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTagsbodynamenormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTagsbodynamenormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTagsbodynamenormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsbodynamenormalContext tagsbodynamenormal() throws RecognitionException {
		TagsbodynamenormalContext _localctx = new TagsbodynamenormalContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tagsbodynamenormal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -1006764032L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1069555711L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagElementbodyContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_START() { return getToken(HTMLCSSJINJA_parser.OPEN_TAG_START, 0); }
		public TagsbodynameselfContext tagsbodynameself() {
			return getRuleContext(TagsbodynameselfContext.class,0);
		}
		public TerminalNode SLASH_CLOSE() { return getToken(HTMLCSSJINJA_parser.SLASH_CLOSE, 0); }
		public List<AttributebodyContext> attributebody() {
			return getRuleContexts(AttributebodyContext.class);
		}
		public AttributebodyContext attributebody(int i) {
			return getRuleContext(AttributebodyContext.class,i);
		}
		public SelfClosingTagElementbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfClosingTagElementbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterSelfClosingTagElementbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitSelfClosingTagElementbody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitSelfClosingTagElementbody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfClosingTagElementbodyContext selfClosingTagElementbody() throws RecognitionException {
		SelfClosingTagElementbodyContext _localctx = new SelfClosingTagElementbodyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selfClosingTagElementbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(OPEN_TAG_START);
			setState(366);
			tagsbodynameself();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STYLE_ATTRIBUTE_START || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 9223372036854775807L) != 0)) {
				{
				{
				setState(367);
				attributebody();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
			match(SLASH_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagsbodynameselfContext extends ParserRuleContext {
		public TerminalNode TAG_BR() { return getToken(HTMLCSSJINJA_parser.TAG_BR, 0); }
		public TerminalNode TAG_HR() { return getToken(HTMLCSSJINJA_parser.TAG_HR, 0); }
		public TerminalNode TAG_IMG() { return getToken(HTMLCSSJINJA_parser.TAG_IMG, 0); }
		public TerminalNode TAG_INPUT() { return getToken(HTMLCSSJINJA_parser.TAG_INPUT, 0); }
		public TerminalNode TAG_META() { return getToken(HTMLCSSJINJA_parser.TAG_META, 0); }
		public TerminalNode TAG_LINK() { return getToken(HTMLCSSJINJA_parser.TAG_LINK, 0); }
		public TerminalNode TAG_SOURCE() { return getToken(HTMLCSSJINJA_parser.TAG_SOURCE, 0); }
		public TerminalNode TAG_TRACK() { return getToken(HTMLCSSJINJA_parser.TAG_TRACK, 0); }
		public TerminalNode TAG_WBR() { return getToken(HTMLCSSJINJA_parser.TAG_WBR, 0); }
		public TerminalNode TAG_AREA() { return getToken(HTMLCSSJINJA_parser.TAG_AREA, 0); }
		public TerminalNode TAG_BASE() { return getToken(HTMLCSSJINJA_parser.TAG_BASE, 0); }
		public TerminalNode TAG_COL() { return getToken(HTMLCSSJINJA_parser.TAG_COL, 0); }
		public TerminalNode TAG_EMBED() { return getToken(HTMLCSSJINJA_parser.TAG_EMBED, 0); }
		public TerminalNode TAG_PARAM() { return getToken(HTMLCSSJINJA_parser.TAG_PARAM, 0); }
		public TagsbodynameselfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagsbodynameself; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterTagsbodynameself(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitTagsbodynameself(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitTagsbodynameself(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsbodynameselfContext tagsbodynameself() throws RecognitionException {
		TagsbodynameselfContext _localctx = new TagsbodynameselfContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tagsbodynameself);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1006649344L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 511L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributebodyContext extends ParserRuleContext {
		public AttributebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributebody; }
	 
		public AttributebodyContext() { }
		public void copyFrom(AttributebodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Attribute_stylelabelContext extends AttributebodyContext {
		public Attribute_styleContext attribute_style() {
			return getRuleContext(Attribute_styleContext.class,0);
		}
		public Attribute_stylelabelContext(AttributebodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttribute_stylelabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttribute_stylelabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttribute_stylelabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributenamebodywithoutvaluelabelContext extends AttributebodyContext {
		public AttributenamebodywithoutvalueContext attributenamebodywithoutvalue() {
			return getRuleContext(AttributenamebodywithoutvalueContext.class,0);
		}
		public AttributenamebodywithoutvaluelabelContext(AttributebodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributenamebodywithoutvaluelabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributenamebodywithoutvaluelabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributenamebodywithoutvaluelabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributenamebodylabelContext extends AttributebodyContext {
		public AttributenamebodyContext attributenamebody() {
			return getRuleContext(AttributenamebodyContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(HTMLCSSJINJA_parser.EQUALS, 0); }
		public TerminalNode ATTRIBUTE_VALUE() { return getToken(HTMLCSSJINJA_parser.ATTRIBUTE_VALUE, 0); }
		public AttributenamebodylabelContext(AttributebodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributenamebodylabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributenamebodylabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributenamebodylabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributebodyContext attributebody() throws RecognitionException {
		AttributebodyContext _localctx = new AttributebodyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_attributebody);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new Attribute_stylelabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				attribute_style();
				}
				break;
			case 2:
				_localctx = new AttributenamebodylabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				attributenamebody();
				setState(379);
				match(EQUALS);
				setState(380);
				match(ATTRIBUTE_VALUE);
				}
				break;
			case 3:
				_localctx = new AttributenamebodywithoutvaluelabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(382);
				attributenamebodywithoutvalue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributenamebodywithoutvalueContext extends ParserRuleContext {
		public TerminalNode ATTR_HIDDEN() { return getToken(HTMLCSSJINJA_parser.ATTR_HIDDEN, 0); }
		public TerminalNode ATTR_DRAGGABLE() { return getToken(HTMLCSSJINJA_parser.ATTR_DRAGGABLE, 0); }
		public TerminalNode ATTR_CONTENTEDITABLE() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTENTEDITABLE, 0); }
		public TerminalNode ATTR_TRANSLATE() { return getToken(HTMLCSSJINJA_parser.ATTR_TRANSLATE, 0); }
		public TerminalNode ATTR_REQUIRED() { return getToken(HTMLCSSJINJA_parser.ATTR_REQUIRED, 0); }
		public TerminalNode ATTR_READONLY() { return getToken(HTMLCSSJINJA_parser.ATTR_READONLY, 0); }
		public TerminalNode ATTR_DISABLED() { return getToken(HTMLCSSJINJA_parser.ATTR_DISABLED, 0); }
		public TerminalNode ATTR_CHECKED() { return getToken(HTMLCSSJINJA_parser.ATTR_CHECKED, 0); }
		public TerminalNode ATTR_MULTIPLE() { return getToken(HTMLCSSJINJA_parser.ATTR_MULTIPLE, 0); }
		public TerminalNode ATTR_NOVALIDATE() { return getToken(HTMLCSSJINJA_parser.ATTR_NOVALIDATE, 0); }
		public TerminalNode ATTR_CONTROLS() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTROLS, 0); }
		public TerminalNode ATTR_AUTOPLAY() { return getToken(HTMLCSSJINJA_parser.ATTR_AUTOPLAY, 0); }
		public TerminalNode ATTR_LOOP() { return getToken(HTMLCSSJINJA_parser.ATTR_LOOP, 0); }
		public TerminalNode ATTR_MUTED() { return getToken(HTMLCSSJINJA_parser.ATTR_MUTED, 0); }
		public AttributenamebodywithoutvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributenamebodywithoutvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributenamebodywithoutvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributenamebodywithoutvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributenamebodywithoutvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenamebodywithoutvalueContext attributenamebodywithoutvalue() throws RecognitionException {
		AttributenamebodywithoutvalueContext _localctx = new AttributenamebodywithoutvalueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_attributenamebodywithoutvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_la = _input.LA(1);
			if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 16383L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributenamebodyContext extends ParserRuleContext {
		public TerminalNode ATTR_ID() { return getToken(HTMLCSSJINJA_parser.ATTR_ID, 0); }
		public TerminalNode ATTR_CLASS() { return getToken(HTMLCSSJINJA_parser.ATTR_CLASS, 0); }
		public TerminalNode ATTR_TITLE() { return getToken(HTMLCSSJINJA_parser.ATTR_TITLE, 0); }
		public TerminalNode ATTR_LANG() { return getToken(HTMLCSSJINJA_parser.ATTR_LANG, 0); }
		public TerminalNode ATTR_DIR() { return getToken(HTMLCSSJINJA_parser.ATTR_DIR, 0); }
		public TerminalNode ATTR_HIDDEN() { return getToken(HTMLCSSJINJA_parser.ATTR_HIDDEN, 0); }
		public TerminalNode ATTR_DRAGGABLE() { return getToken(HTMLCSSJINJA_parser.ATTR_DRAGGABLE, 0); }
		public TerminalNode ATTR_CONTENTEDITABLE() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTENTEDITABLE, 0); }
		public TerminalNode ATTR_TABINDEX() { return getToken(HTMLCSSJINJA_parser.ATTR_TABINDEX, 0); }
		public TerminalNode ATTR_ACCESSKEY() { return getToken(HTMLCSSJINJA_parser.ATTR_ACCESSKEY, 0); }
		public TerminalNode ATTR_TRANSLATE() { return getToken(HTMLCSSJINJA_parser.ATTR_TRANSLATE, 0); }
		public TerminalNode ATTR_HREF() { return getToken(HTMLCSSJINJA_parser.ATTR_HREF, 0); }
		public TerminalNode ATTR_TARGET() { return getToken(HTMLCSSJINJA_parser.ATTR_TARGET, 0); }
		public TerminalNode ATTR_REL() { return getToken(HTMLCSSJINJA_parser.ATTR_REL, 0); }
		public TerminalNode ATTR_DOWNLOAD() { return getToken(HTMLCSSJINJA_parser.ATTR_DOWNLOAD, 0); }
		public TerminalNode ATTR_REFERRERPOLICY() { return getToken(HTMLCSSJINJA_parser.ATTR_REFERRERPOLICY, 0); }
		public TerminalNode ATTR_SRC() { return getToken(HTMLCSSJINJA_parser.ATTR_SRC, 0); }
		public TerminalNode ATTR_ALT() { return getToken(HTMLCSSJINJA_parser.ATTR_ALT, 0); }
		public TerminalNode ATTR_WIDTH() { return getToken(HTMLCSSJINJA_parser.ATTR_WIDTH, 0); }
		public TerminalNode ATTR_HEIGHT() { return getToken(HTMLCSSJINJA_parser.ATTR_HEIGHT, 0); }
		public TerminalNode ATTR_LOADING() { return getToken(HTMLCSSJINJA_parser.ATTR_LOADING, 0); }
		public TerminalNode ATTR_DECODING() { return getToken(HTMLCSSJINJA_parser.ATTR_DECODING, 0); }
		public TerminalNode ATTR_TYPE() { return getToken(HTMLCSSJINJA_parser.ATTR_TYPE, 0); }
		public TerminalNode ATTR_NAME() { return getToken(HTMLCSSJINJA_parser.ATTR_NAME, 0); }
		public TerminalNode ATTR_VALUE() { return getToken(HTMLCSSJINJA_parser.ATTR_VALUE, 0); }
		public TerminalNode ATTR_PLACEHOLDER() { return getToken(HTMLCSSJINJA_parser.ATTR_PLACEHOLDER, 0); }
		public TerminalNode ATTR_REQUIRED() { return getToken(HTMLCSSJINJA_parser.ATTR_REQUIRED, 0); }
		public TerminalNode ATTR_READONLY() { return getToken(HTMLCSSJINJA_parser.ATTR_READONLY, 0); }
		public TerminalNode ATTR_DISABLED() { return getToken(HTMLCSSJINJA_parser.ATTR_DISABLED, 0); }
		public TerminalNode ATTR_CHECKED() { return getToken(HTMLCSSJINJA_parser.ATTR_CHECKED, 0); }
		public TerminalNode ATTR_MAX() { return getToken(HTMLCSSJINJA_parser.ATTR_MAX, 0); }
		public TerminalNode ATTR_MIN() { return getToken(HTMLCSSJINJA_parser.ATTR_MIN, 0); }
		public TerminalNode ATTR_STEP() { return getToken(HTMLCSSJINJA_parser.ATTR_STEP, 0); }
		public TerminalNode ATTR_PATTERN() { return getToken(HTMLCSSJINJA_parser.ATTR_PATTERN, 0); }
		public TerminalNode ATTR_MAXLENGTH() { return getToken(HTMLCSSJINJA_parser.ATTR_MAXLENGTH, 0); }
		public TerminalNode ATTR_MINLENGTH() { return getToken(HTMLCSSJINJA_parser.ATTR_MINLENGTH, 0); }
		public TerminalNode ATTR_MULTIPLE() { return getToken(HTMLCSSJINJA_parser.ATTR_MULTIPLE, 0); }
		public TerminalNode ATTR_ACCEPT() { return getToken(HTMLCSSJINJA_parser.ATTR_ACCEPT, 0); }
		public TerminalNode ATTR_AUTOCOMPLETE() { return getToken(HTMLCSSJINJA_parser.ATTR_AUTOCOMPLETE, 0); }
		public TerminalNode ATTR_SIZE() { return getToken(HTMLCSSJINJA_parser.ATTR_SIZE, 0); }
		public TerminalNode ATTR_METHOD() { return getToken(HTMLCSSJINJA_parser.ATTR_METHOD, 0); }
		public TerminalNode ATTR_ACTION() { return getToken(HTMLCSSJINJA_parser.ATTR_ACTION, 0); }
		public TerminalNode ATTR_ENCTYPE() { return getToken(HTMLCSSJINJA_parser.ATTR_ENCTYPE, 0); }
		public TerminalNode ATTR_AUTOFILL() { return getToken(HTMLCSSJINJA_parser.ATTR_AUTOFILL, 0); }
		public TerminalNode ATTR_NOVALIDATE() { return getToken(HTMLCSSJINJA_parser.ATTR_NOVALIDATE, 0); }
		public TerminalNode ATTR_ONCLICK() { return getToken(HTMLCSSJINJA_parser.ATTR_ONCLICK, 0); }
		public TerminalNode ATTR_ONCHANGE() { return getToken(HTMLCSSJINJA_parser.ATTR_ONCHANGE, 0); }
		public TerminalNode ATTR_ONSUBMIT() { return getToken(HTMLCSSJINJA_parser.ATTR_ONSUBMIT, 0); }
		public TerminalNode ATTR_ONINPUT() { return getToken(HTMLCSSJINJA_parser.ATTR_ONINPUT, 0); }
		public TerminalNode ATTR_ONLOAD() { return getToken(HTMLCSSJINJA_parser.ATTR_ONLOAD, 0); }
		public TerminalNode ATTR_CONTROLS() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTROLS, 0); }
		public TerminalNode ATTR_AUTOPLAY() { return getToken(HTMLCSSJINJA_parser.ATTR_AUTOPLAY, 0); }
		public TerminalNode ATTR_LOOP() { return getToken(HTMLCSSJINJA_parser.ATTR_LOOP, 0); }
		public TerminalNode ATTR_MUTED() { return getToken(HTMLCSSJINJA_parser.ATTR_MUTED, 0); }
		public TerminalNode ATTR_PRELOAD() { return getToken(HTMLCSSJINJA_parser.ATTR_PRELOAD, 0); }
		public TerminalNode ATTR_POSTER() { return getToken(HTMLCSSJINJA_parser.ATTR_POSTER, 0); }
		public TerminalNode ATTR_COLSPAN() { return getToken(HTMLCSSJINJA_parser.ATTR_COLSPAN, 0); }
		public TerminalNode ATTR_ROWSPAN() { return getToken(HTMLCSSJINJA_parser.ATTR_ROWSPAN, 0); }
		public TerminalNode ATTR_SCOPE() { return getToken(HTMLCSSJINJA_parser.ATTR_SCOPE, 0); }
		public TerminalNode ATTR_CHARSET() { return getToken(HTMLCSSJINJA_parser.ATTR_CHARSET, 0); }
		public TerminalNode ATTR_CONTENT() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTENT, 0); }
		public TerminalNode ATTR_HTTP_EQUIV() { return getToken(HTMLCSSJINJA_parser.ATTR_HTTP_EQUIV, 0); }
		public TerminalNode ATTR_PROPERTY() { return getToken(HTMLCSSJINJA_parser.ATTR_PROPERTY, 0); }
		public AttributenamebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributenamebody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributenamebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributenamebody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributenamebody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenamebodyContext attributenamebody() throws RecognitionException {
		AttributenamebodyContext _localctx = new AttributenamebodyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_attributenamebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_la = _input.LA(1);
			if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 9223372036854775807L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeheadContext extends ParserRuleContext {
		public AttributenameheadContext attributenamehead() {
			return getRuleContext(AttributenameheadContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(HTMLCSSJINJA_parser.EQUALS, 0); }
		public TerminalNode ATTRIBUTE_VALUE() { return getToken(HTMLCSSJINJA_parser.ATTRIBUTE_VALUE, 0); }
		public AttributeheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributehead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributehead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributehead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributehead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeheadContext attributehead() throws RecognitionException {
		AttributeheadContext _localctx = new AttributeheadContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_attributehead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			attributenamehead();
			setState(390);
			match(EQUALS);
			setState(391);
			match(ATTRIBUTE_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributenameheadContext extends ParserRuleContext {
		public TerminalNode ATTR_CHARSET() { return getToken(HTMLCSSJINJA_parser.ATTR_CHARSET, 0); }
		public TerminalNode ATTR_NAME() { return getToken(HTMLCSSJINJA_parser.ATTR_NAME, 0); }
		public TerminalNode ATTR_CONTENT() { return getToken(HTMLCSSJINJA_parser.ATTR_CONTENT, 0); }
		public TerminalNode ATTR_HTTP_EQUIV() { return getToken(HTMLCSSJINJA_parser.ATTR_HTTP_EQUIV, 0); }
		public TerminalNode ATTR_PROPERTY() { return getToken(HTMLCSSJINJA_parser.ATTR_PROPERTY, 0); }
		public AttributenameheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributenamehead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterAttributenamehead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitAttributenamehead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitAttributenamehead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenameheadContext attributenamehead() throws RecognitionException {
		AttributenameheadContext _localctx = new AttributenameheadContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_attributenamehead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_la = _input.LA(1);
			if ( !(((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & 1006632961L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElementContext extends ParserRuleContext {
		public JinjaElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElement; }
	 
		public JinjaElementContext() { }
		public void copyFrom(JinjaElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprlabelContext extends JinjaElementContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public JinjaExprlabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaExprlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaExprlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaExprlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStmtlabelContext extends JinjaElementContext {
		public JinjaStmtContext jinjaStmt() {
			return getRuleContext(JinjaStmtContext.class,0);
		}
		public JinjaStmtlabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaStmtlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaStmtlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaStmtlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentlabelContext extends JinjaElementContext {
		public JinjaCommentContext jinjaComment() {
			return getRuleContext(JinjaCommentContext.class,0);
		}
		public JinjaCommentlabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaCommentlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaCommentlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaCommentlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfBlocklabelContext extends JinjaElementContext {
		public JinjaIfBlockContext jinjaIfBlock() {
			return getRuleContext(JinjaIfBlockContext.class,0);
		}
		public JinjaIfBlocklabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaIfBlocklabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaIfBlocklabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaIfBlocklabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCompactElementlabelContext extends JinjaElementContext {
		public JinjaCompactElementContext jinjaCompactElement() {
			return getRuleContext(JinjaCompactElementContext.class,0);
		}
		public JinjaCompactElementlabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaCompactElementlabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaCompactElementlabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaCompactElementlabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForBlocklabelContext extends JinjaElementContext {
		public JinjaForBlockContext jinjaForBlock() {
			return getRuleContext(JinjaForBlockContext.class,0);
		}
		public JinjaForBlocklabelContext(JinjaElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaForBlocklabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaForBlocklabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaForBlocklabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElementContext jinjaElement() throws RecognitionException {
		JinjaElementContext _localctx = new JinjaElementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_jinjaElement);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new JinjaExprlabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				jinjaExpr();
				}
				break;
			case 2:
				_localctx = new JinjaStmtlabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(396);
				jinjaStmt();
				}
				break;
			case 3:
				_localctx = new JinjaCommentlabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				jinjaComment();
				}
				break;
			case 4:
				_localctx = new JinjaIfBlocklabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(398);
				jinjaIfBlock();
				}
				break;
			case 5:
				_localctx = new JinjaForBlocklabelContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(399);
				jinjaForBlock();
				}
				break;
			case 6:
				_localctx = new JinjaCompactElementlabelContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(400);
				jinjaCompactElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCompactElementContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_START() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_START, 0); }
		public TerminalNode JINJA_STMT_END() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_END, 0); }
		public List<JinjaStmtArgumentContext> jinjaStmtArgument() {
			return getRuleContexts(JinjaStmtArgumentContext.class);
		}
		public JinjaStmtArgumentContext jinjaStmtArgument(int i) {
			return getRuleContext(JinjaStmtArgumentContext.class,i);
		}
		public JinjaCompactElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaCompactElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaCompactElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaCompactElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaCompactElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaCompactElementContext jinjaCompactElement() throws RecognitionException {
		JinjaCompactElementContext _localctx = new JinjaCompactElementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_jinjaCompactElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(JINJA_STMT_START);
			setState(405); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(404);
				jinjaStmtArgument();
				}
				}
				setState(407); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0) );
			setState(409);
			match(JINJA_STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR_START() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_START, 0); }
		public TerminalNode JINJA_EXPR_END() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_END, 0); }
		public List<JinjaExprContentContext> jinjaExprContent() {
			return getRuleContexts(JinjaExprContentContext.class);
		}
		public JinjaExprContentContext jinjaExprContent(int i) {
			return getRuleContext(JinjaExprContentContext.class,i);
		}
		public JinjaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContext jinjaExpr() throws RecognitionException {
		JinjaExprContext _localctx = new JinjaExprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_jinjaExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(JINJA_EXPR_START);
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & 15L) != 0)) {
				{
				{
				setState(412);
				jinjaExprContent();
				}
				}
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(418);
			match(JINJA_EXPR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContentContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR_STRING() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_STRING, 0); }
		public TerminalNode JINJA_EXPR_ATOM() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_ATOM, 0); }
		public TerminalNode JINJA_EXPR_SYMBOL() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_SYMBOL, 0); }
		public TerminalNode JINJA_EXPR_UNKNOWN() { return getToken(HTMLCSSJINJA_parser.JINJA_EXPR_UNKNOWN, 0); }
		public JinjaExprContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExprContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaExprContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaExprContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaExprContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContentContext jinjaExprContent() throws RecognitionException {
		JinjaExprContentContext _localctx = new JinjaExprContentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_jinjaExprContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_la = _input.LA(1);
			if ( !(((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContentContext extends ParserRuleContext {
		public JinjaBlockContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlockContent; }
	 
		public JinjaBlockContentContext() { }
		public void copyFrom(JinjaBlockContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaSelfClosingTagLabelContext extends JinjaBlockContentContext {
		public SelfClosingTagElementbodyContext selfClosingTagElementbody() {
			return getRuleContext(SelfClosingTagElementbodyContext.class,0);
		}
		public JinjaSelfClosingTagLabelContext(JinjaBlockContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaSelfClosingTagLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaSelfClosingTagLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaSelfClosingTagLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaNestedElementLabelContext extends JinjaBlockContentContext {
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public JinjaNestedElementLabelContext(JinjaBlockContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaNestedElementLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaNestedElementLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaNestedElementLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaTextLabelContext extends JinjaBlockContentContext {
		public TerminalNode TEXT() { return getToken(HTMLCSSJINJA_parser.TEXT, 0); }
		public JinjaTextLabelContext(JinjaBlockContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaTextLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaTextLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaTextLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaNormalTagLabelContext extends JinjaBlockContentContext {
		public NormalTagElementbodyContext normalTagElementbody() {
			return getRuleContext(NormalTagElementbodyContext.class,0);
		}
		public JinjaNormalTagLabelContext(JinjaBlockContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaNormalTagLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaNormalTagLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaNormalTagLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContentContext jinjaBlockContent() throws RecognitionException {
		JinjaBlockContentContext _localctx = new JinjaBlockContentContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_jinjaBlockContent);
		try {
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new JinjaNormalTagLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				normalTagElementbody();
				}
				break;
			case 2:
				_localctx = new JinjaSelfClosingTagLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				selfClosingTagElementbody();
				}
				break;
			case 3:
				_localctx = new JinjaNestedElementLabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				jinjaElement();
				}
				break;
			case 4:
				_localctx = new JinjaTextLabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(425);
				match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfBlockContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_START() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_START); }
		public TerminalNode JINJA_STMT_START(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_START, i);
		}
		public TerminalNode JINJA_STMT_IF() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_IF, 0); }
		public List<TerminalNode> JINJA_STMT_END() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_END); }
		public TerminalNode JINJA_STMT_END(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_END, i);
		}
		public TerminalNode JINJA_STMT_ENDIF() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ENDIF, 0); }
		public List<JinjaStmtArgumentContext> jinjaStmtArgument() {
			return getRuleContexts(JinjaStmtArgumentContext.class);
		}
		public JinjaStmtArgumentContext jinjaStmtArgument(int i) {
			return getRuleContext(JinjaStmtArgumentContext.class,i);
		}
		public List<JinjaBlockContentContext> jinjaBlockContent() {
			return getRuleContexts(JinjaBlockContentContext.class);
		}
		public JinjaBlockContentContext jinjaBlockContent(int i) {
			return getRuleContext(JinjaBlockContentContext.class,i);
		}
		public List<TerminalNode> JINJA_STMT_ELIF() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_ELIF); }
		public TerminalNode JINJA_STMT_ELIF(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ELIF, i);
		}
		public List<TerminalNode> JINJA_STMT_ELSE() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_ELSE); }
		public TerminalNode JINJA_STMT_ELSE(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ELSE, i);
		}
		public JinjaIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIfBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfBlockContext jinjaIfBlock() throws RecognitionException {
		JinjaIfBlockContext _localctx = new JinjaIfBlockContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_jinjaIfBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(JINJA_STMT_START);
			setState(429);
			match(JINJA_STMT_IF);
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0)) {
				{
				{
				setState(430);
				jinjaStmtArgument();
				}
				}
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(436);
			match(JINJA_STMT_END);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(437);
					jinjaBlockContent();
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(443);
					match(JINJA_STMT_START);
					setState(444);
					match(JINJA_STMT_ELIF);
					setState(448);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0)) {
						{
						{
						setState(445);
						jinjaStmtArgument();
						}
						}
						setState(450);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(451);
					match(JINJA_STMT_END);
					setState(455);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(452);
							jinjaBlockContent();
							}
							} 
						}
						setState(457);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
					}
					}
					} 
				}
				setState(462);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(463);
					match(JINJA_STMT_START);
					setState(464);
					match(JINJA_STMT_ELSE);
					setState(465);
					match(JINJA_STMT_END);
					setState(469);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(466);
							jinjaBlockContent();
							}
							} 
						}
						setState(471);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(477);
			match(JINJA_STMT_START);
			setState(478);
			match(JINJA_STMT_ENDIF);
			setState(479);
			match(JINJA_STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForBlockContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_STMT_START() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_START); }
		public TerminalNode JINJA_STMT_START(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_START, i);
		}
		public TerminalNode JINJA_STMT_FOR() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_FOR, 0); }
		public List<TerminalNode> JINJA_STMT_END() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_END); }
		public TerminalNode JINJA_STMT_END(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_END, i);
		}
		public TerminalNode JINJA_STMT_ENDFOR() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ENDFOR, 0); }
		public List<JinjaStmtArgumentContext> jinjaStmtArgument() {
			return getRuleContexts(JinjaStmtArgumentContext.class);
		}
		public JinjaStmtArgumentContext jinjaStmtArgument(int i) {
			return getRuleContext(JinjaStmtArgumentContext.class,i);
		}
		public List<JinjaBlockContentContext> jinjaBlockContent() {
			return getRuleContexts(JinjaBlockContentContext.class);
		}
		public JinjaBlockContentContext jinjaBlockContent(int i) {
			return getRuleContext(JinjaBlockContentContext.class,i);
		}
		public List<TerminalNode> JINJA_STMT_ELSE() { return getTokens(HTMLCSSJINJA_parser.JINJA_STMT_ELSE); }
		public TerminalNode JINJA_STMT_ELSE(int i) {
			return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ELSE, i);
		}
		public JinjaForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaForBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForBlockContext jinjaForBlock() throws RecognitionException {
		JinjaForBlockContext _localctx = new JinjaForBlockContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_jinjaForBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(JINJA_STMT_START);
			setState(482);
			match(JINJA_STMT_FOR);
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0)) {
				{
				{
				setState(483);
				jinjaStmtArgument();
				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489);
			match(JINJA_STMT_END);
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(490);
					jinjaBlockContent();
					}
					} 
				}
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(496);
					match(JINJA_STMT_START);
					setState(497);
					match(JINJA_STMT_ELSE);
					setState(498);
					match(JINJA_STMT_END);
					setState(502);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(499);
							jinjaBlockContent();
							}
							} 
						}
						setState(504);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					}
					}
					} 
				}
				setState(509);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(510);
			match(JINJA_STMT_START);
			setState(511);
			match(JINJA_STMT_ENDFOR);
			setState(512);
			match(JINJA_STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStmtArgumentContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_ATOM() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ATOM, 0); }
		public TerminalNode JINJA_STMT_SYMBOL() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_SYMBOL, 0); }
		public TerminalNode JINJA_STMT_STRING() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_STRING, 0); }
		public TerminalNode JINJA_STMT_UNKNOWN() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_UNKNOWN, 0); }
		public TerminalNode JINJA_STMT_ELSE() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ELSE, 0); }
		public TerminalNode JINJA_STMT_ELIF() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ELIF, 0); }
		public TerminalNode JINJA_STMT_IN() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_IN, 0); }
		public TerminalNode JINJA_STMT_SET() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_SET, 0); }
		public TerminalNode JINJA_STMT_BLOCK() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_BLOCK, 0); }
		public TerminalNode JINJA_STMT_ENDBLOCK() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ENDBLOCK, 0); }
		public TerminalNode JINJA_STMT_WITH() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_WITH, 0); }
		public TerminalNode JINJA_STMT_ENDWITH() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ENDWITH, 0); }
		public TerminalNode JINJA_STMT_MACRO() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_MACRO, 0); }
		public TerminalNode JINJA_STMT_ENDMACRO() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_ENDMACRO, 0); }
		public TerminalNode JINJA_STMT_INCLUDE() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_INCLUDE, 0); }
		public TerminalNode JINJA_STMT_EXTENDS() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_EXTENDS, 0); }
		public TerminalNode JINJA_STMT_FROM() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_FROM, 0); }
		public JinjaStmtArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStmtArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaStmtArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaStmtArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaStmtArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStmtArgumentContext jinjaStmtArgument() throws RecognitionException {
		JinjaStmtArgumentContext _localctx = new JinjaStmtArgumentContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_jinjaStmtArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_la = _input.LA(1);
			if ( !(((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStmtContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_START() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_START, 0); }
		public TerminalNode JINJA_STMT_END() { return getToken(HTMLCSSJINJA_parser.JINJA_STMT_END, 0); }
		public List<JinjaStmtArgumentContext> jinjaStmtArgument() {
			return getRuleContexts(JinjaStmtArgumentContext.class);
		}
		public JinjaStmtArgumentContext jinjaStmtArgument(int i) {
			return getRuleContext(JinjaStmtArgumentContext.class,i);
		}
		public JinjaStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStmtContext jinjaStmt() throws RecognitionException {
		JinjaStmtContext _localctx = new JinjaStmtContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_jinjaStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(JINJA_STMT_START);
			setState(518); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(517);
				jinjaStmtArgument();
				}
				}
				setState(520); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 253951L) != 0) );
			setState(522);
			match(JINJA_STMT_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentContext extends ParserRuleContext {
		public TerminalNode JANJI_COMMENT() { return getToken(HTMLCSSJINJA_parser.JANJI_COMMENT, 0); }
		public JinjaCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).enterJinjaComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLCSSJINJA_parserListener ) ((HTMLCSSJINJA_parserListener)listener).exitJinjaComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLCSSJINJA_parserVisitor ) return ((HTMLCSSJINJA_parserVisitor<? extends T>)visitor).visitJinjaComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaCommentContext jinjaComment() throws RecognitionException {
		JinjaCommentContext _localctx = new JinjaCommentContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_jinjaComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(JANJI_COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00dd\u020f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u0001\u0000\u0005\u0000h\b\u0000\n\u0000\f\u0000k\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001s\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003|\b\u0003\n\u0003\f\u0003"+
		"\u007f\t\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0083\b\u0003\n\u0003"+
		"\f\u0003\u0086\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u0094\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u009c\b\b\n\b\f\b\u009f\t\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t\u00a8\b\t\n"+
		"\t\f\t\u00ab\t\t\u0001\t\u0001\t\u0005\t\u00af\b\t\n\t\f\t\u00b2\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c0\b\u000b\n\u000b\f\u000b"+
		"\u00c3\t\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c7\b\u000b\n\u000b"+
		"\f\u000b\u00ca\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u00d5\b\r\n\r\f\r\u00d8"+
		"\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00e2\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00e7\b\u0010\n\u0010\f\u0010\u00ea\t\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00ee\b\u0010\n\u0010\f\u0010\u00f1\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0004"+
		"\u0011\u00f9\b\u0011\u000b\u0011\f\u0011\u00fa\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u010c\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014"+
		"\u0116\b\u0014\u000b\u0014\f\u0014\u0117\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0004\u0017\u0129\b\u0017\u000b\u0017\f\u0017\u012a\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u013d\b\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0004\u001b"+
		"\u0145\b\u001b\u000b\u001b\f\u001b\u0146\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u014f\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u015b\b\u001e\u000b"+
		"\u001e\f\u001e\u015c\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0004\u001f\u0164\b\u001f\u000b\u001f\f\u001f\u0165\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0005"+
		"\"\u0171\b\"\n\"\f\"\u0174\t\"\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u0180\b$\u0001%\u0001%\u0001&\u0001"+
		"&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0003)\u0192\b)\u0001*\u0001*\u0004*\u0196\b*\u000b*\f"+
		"*\u0197\u0001*\u0001*\u0001+\u0001+\u0005+\u019e\b+\n+\f+\u01a1\t+\u0001"+
		"+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0003-\u01ab\b-\u0001"+
		".\u0001.\u0001.\u0005.\u01b0\b.\n.\f.\u01b3\t.\u0001.\u0001.\u0005.\u01b7"+
		"\b.\n.\f.\u01ba\t.\u0001.\u0001.\u0001.\u0005.\u01bf\b.\n.\f.\u01c2\t"+
		".\u0001.\u0001.\u0005.\u01c6\b.\n.\f.\u01c9\t.\u0005.\u01cb\b.\n.\f.\u01ce"+
		"\t.\u0001.\u0001.\u0001.\u0001.\u0005.\u01d4\b.\n.\f.\u01d7\t.\u0005."+
		"\u01d9\b.\n.\f.\u01dc\t.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001"+
		"/\u0005/\u01e5\b/\n/\f/\u01e8\t/\u0001/\u0001/\u0005/\u01ec\b/\n/\f/\u01ef"+
		"\t/\u0001/\u0001/\u0001/\u0001/\u0005/\u01f5\b/\n/\f/\u01f8\t/\u0005/"+
		"\u01fa\b/\n/\f/\u01fd\t/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u0001"+
		"1\u00011\u00041\u0207\b1\u000b1\f1\u0208\u00011\u00011\u00012\u00012\u0001"+
		"2\u0000\u00003\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bd\u0000\t"+
		"\u0001\u0000\u009d\u009e\u0002\u0000\u00aa\u00aa\u00b4\u00be\u0003\u0000"+
		"\u0011\u0019\u001eLV]\u0003\u0000\u000e\u000e\u001a\u001dMU\u0001\u0000"+
		"^k\u0001\u0000^\u009c\u0002\u0000\u007f\u007f\u0099\u009c\u0001\u0000"+
		"\u00c3\u00c6\u0002\u0000\u00cc\u00d8\u00da\u00dd\u021d\u0000i\u0001\u0000"+
		"\u0000\u0000\u0002r\u0001\u0000\u0000\u0000\u0004t\u0001\u0000\u0000\u0000"+
		"\u0006x\u0001\u0000\u0000\u0000\b\u008b\u0001\u0000\u0000\u0000\n\u008d"+
		"\u0001\u0000\u0000\u0000\f\u0093\u0001\u0000\u0000\u0000\u000e\u0095\u0001"+
		"\u0000\u0000\u0000\u0010\u0097\u0001\u0000\u0000\u0000\u0012\u00a4\u0001"+
		"\u0000\u0000\u0000\u0014\u00ba\u0001\u0000\u0000\u0000\u0016\u00bc\u0001"+
		"\u0000\u0000\u0000\u0018\u00cf\u0001\u0000\u0000\u0000\u001a\u00d1\u0001"+
		"\u0000\u0000\u0000\u001c\u00db\u0001\u0000\u0000\u0000\u001e\u00e1\u0001"+
		"\u0000\u0000\u0000 \u00e3\u0001\u0000\u0000\u0000\"\u00f6\u0001\u0000"+
		"\u0000\u0000$\u010b\u0001\u0000\u0000\u0000&\u010d\u0001\u0000\u0000\u0000"+
		"(\u0112\u0001\u0000\u0000\u0000*\u011b\u0001\u0000\u0000\u0000,\u0120"+
		"\u0001\u0000\u0000\u0000.\u0125\u0001\u0000\u0000\u00000\u012e\u0001\u0000"+
		"\u0000\u00002\u0133\u0001\u0000\u0000\u00004\u0138\u0001\u0000\u0000\u0000"+
		"6\u0140\u0001\u0000\u0000\u00008\u014a\u0001\u0000\u0000\u0000:\u0152"+
		"\u0001\u0000\u0000\u0000<\u0157\u0001\u0000\u0000\u0000>\u0160\u0001\u0000"+
		"\u0000\u0000@\u0169\u0001\u0000\u0000\u0000B\u016b\u0001\u0000\u0000\u0000"+
		"D\u016d\u0001\u0000\u0000\u0000F\u0177\u0001\u0000\u0000\u0000H\u017f"+
		"\u0001\u0000\u0000\u0000J\u0181\u0001\u0000\u0000\u0000L\u0183\u0001\u0000"+
		"\u0000\u0000N\u0185\u0001\u0000\u0000\u0000P\u0189\u0001\u0000\u0000\u0000"+
		"R\u0191\u0001\u0000\u0000\u0000T\u0193\u0001\u0000\u0000\u0000V\u019b"+
		"\u0001\u0000\u0000\u0000X\u01a4\u0001\u0000\u0000\u0000Z\u01aa\u0001\u0000"+
		"\u0000\u0000\\\u01ac\u0001\u0000\u0000\u0000^\u01e1\u0001\u0000\u0000"+
		"\u0000`\u0202\u0001\u0000\u0000\u0000b\u0204\u0001\u0000\u0000\u0000d"+
		"\u020c\u0001\u0000\u0000\u0000fh\u0003\u0002\u0001\u0000gf\u0001\u0000"+
		"\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000"+
		"lm\u0005\u0000\u0000\u0001m\u0001\u0001\u0000\u0000\u0000ns\u0003\u0006"+
		"\u0003\u0000os\u0005\u0006\u0000\u0000ps\u0003\u0004\u0002\u0000qs\u0003"+
		"R)\u0000rn\u0001\u0000\u0000\u0000ro\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rq\u0001\u0000\u0000\u0000s\u0003\u0001\u0000\u0000\u0000"+
		"tu\u0005\u0005\u0000\u0000uv\u0005\u000b\u0000\u0000vw\u0005\u00a2\u0000"+
		"\u0000w\u0005\u0001\u0000\u0000\u0000xy\u0005\u0005\u0000\u0000y}\u0005"+
		"\f\u0000\u0000z|\u0003\b\u0004\u0000{z\u0001\u0000\u0000\u0000|\u007f"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"\u0084\u0005\u00a2\u0000\u0000\u0081\u0083\u0003\f\u0006\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\u0004\u0000\u0000\u0088\u0089\u0005\f\u0000\u0000\u0089\u008a\u0005"+
		"\u00a2\u0000\u0000\u008a\u0007\u0001\u0000\u0000\u0000\u008b\u008c\u0003"+
		"\n\u0005\u0000\u008c\t\u0001\u0000\u0000\u0000\u008d\u008e\u0005o\u0000"+
		"\u0000\u008e\u008f\u0005\t\u0000\u0000\u008f\u0090\u0007\u0000\u0000\u0000"+
		"\u0090\u000b\u0001\u0000\u0000\u0000\u0091\u0094\u0003\u0010\b\u0000\u0092"+
		"\u0094\u0003\u0012\t\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\r\u0001\u0000\u0000\u0000\u0095\u0096\u0005"+
		"\b\u0000\u0000\u0096\u000f\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0005"+
		"\u0000\u0000\u0098\u0099\u0005\r\u0000\u0000\u0099\u009d\u0005\u00a2\u0000"+
		"\u0000\u009a\u009c\u0003\u0014\n\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000"+
		"\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0004\u0000\u0000"+
		"\u00a1\u00a2\u0005\r\u0000\u0000\u00a2\u00a3\u0005\u00a2\u0000\u0000\u00a3"+
		"\u0011\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0005\u0000\u0000\u00a5"+
		"\u00a9\u0005\u0010\u0000\u0000\u00a6\u00a8\u0003H$\u0000\u00a7\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00b0\u0005"+
		"\u00a2\u0000\u0000\u00ad\u00af\u0003\u001e\u000f\u0000\u00ae\u00ad\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005"+
		"\u0004\u0000\u0000\u00b4\u00b5\u0005\u0010\u0000\u0000\u00b5\u00b6\u0005"+
		"\u00a2\u0000\u0000\u00b6\u0013\u0001\u0000\u0000\u0000\u00b7\u00bb\u0003"+
		"\u0016\u000b\u0000\u00b8\u00bb\u0003\u001a\r\u0000\u00b9\u00bb\u0003R"+
		")\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u0015\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0005\u0000\u0000\u00bd\u00c1\u0003\u0018\f\u0000"+
		"\u00be\u00c0\u0003N\'\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c8\u0005\u00a2\u0000\u0000\u00c5"+
		"\u00c7\u0003\u000e\u0007\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0004\u0000\u0000\u00cc"+
		"\u00cd\u0003\u0018\f\u0000\u00cd\u00ce\u0005\u00a2\u0000\u0000\u00ce\u0017"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u000f\u0000\u0000\u00d0\u0019"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0005\u0000\u0000\u00d2\u00d6"+
		"\u0003\u001c\u000e\u0000\u00d3\u00d5\u0003N\'\u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"\u00a1\u0000\u0000\u00da\u001b\u0001\u0000\u0000\u0000\u00db\u00dc\u0005"+
		"\u000e\u0000\u0000\u00dc\u001d\u0001\u0000\u0000\u0000\u00dd\u00e2\u0003"+
		" \u0010\u0000\u00de\u00e2\u0003D\"\u0000\u00df\u00e2\u0003R)\u0000\u00e0"+
		"\u00e2\u0005\b\u0000\u0000\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u001f\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\u0005\u0000\u0000\u00e4\u00e8\u0003B!\u0000\u00e5\u00e7\u0003H"+
		"$\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ef\u0005\u00a2\u0000\u0000\u00ec\u00ee\u0003\u001e\u000f"+
		"\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000"+
		"\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005\u0004\u0000\u0000\u00f3\u00f4\u0003B!\u0000\u00f4"+
		"\u00f5\u0005\u00a2\u0000\u0000\u00f5!\u0001\u0000\u0000\u0000\u00f6\u00f8"+
		"\u0005\n\u0000\u0000\u00f7\u00f9\u0003$\u0012\u0000\u00f8\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005\u00a4\u0000\u0000\u00fd#\u0001\u0000"+
		"\u0000\u0000\u00fe\u010c\u0003&\u0013\u0000\u00ff\u010c\u0003(\u0014\u0000"+
		"\u0100\u010c\u0003*\u0015\u0000\u0101\u010c\u0003,\u0016\u0000\u0102\u010c"+
		"\u0003.\u0017\u0000\u0103\u010c\u00032\u0019\u0000\u0104\u010c\u00034"+
		"\u001a\u0000\u0105\u010c\u00036\u001b\u0000\u0106\u010c\u00038\u001c\u0000"+
		"\u0107\u010c\u0003:\u001d\u0000\u0108\u010c\u0003<\u001e\u0000\u0109\u010c"+
		"\u0003>\u001f\u0000\u010a\u010c\u00030\u0018\u0000\u010b\u00fe\u0001\u0000"+
		"\u0000\u0000\u010b\u00ff\u0001\u0000\u0000\u0000\u010b\u0100\u0001\u0000"+
		"\u0000\u0000\u010b\u0101\u0001\u0000\u0000\u0000\u010b\u0102\u0001\u0000"+
		"\u0000\u0000\u010b\u0103\u0001\u0000\u0000\u0000\u010b\u0104\u0001\u0000"+
		"\u0000\u0000\u010b\u0105\u0001\u0000\u0000\u0000\u010b\u0106\u0001\u0000"+
		"\u0000\u0000\u010b\u0107\u0001\u0000\u0000\u0000\u010b\u0108\u0001\u0000"+
		"\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010a\u0001\u0000"+
		"\u0000\u0000\u010c%\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u00a8\u0000"+
		"\u0000\u010e\u010f\u0005\u00a5\u0000\u0000\u010f\u0110\u0005\u00b8\u0000"+
		"\u0000\u0110\u0111\u0005\u00a6\u0000\u0000\u0111\'\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0005\u00a9\u0000\u0000\u0113\u0115\u0005\u00a5\u0000\u0000"+
		"\u0114\u0116\u0003@ \u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0005\u00a6\u0000\u0000\u011a)\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"\u00ac\u0000\u0000\u011c\u011d\u0005\u00a5\u0000\u0000\u011d\u011e\u0005"+
		"\u00b9\u0000\u0000\u011e\u011f\u0005\u00a6\u0000\u0000\u011f+\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0005\u00ad\u0000\u0000\u0121\u0122\u0005\u00a5"+
		"\u0000\u0000\u0122\u0123\u0005\u00ba\u0000\u0000\u0123\u0124\u0005\u00a6"+
		"\u0000\u0000\u0124-\u0001\u0000\u0000\u0000\u0125\u0126\u0005\u00ae\u0000"+
		"\u0000\u0126\u0128\u0005\u00a5\u0000\u0000\u0127\u0129\u0003@ \u0000\u0128"+
		"\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a"+
		"\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u00a6\u0000\u0000\u012d"+
		"/\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u00aa\u0000\u0000\u012f\u0130"+
		"\u0005\u00a5\u0000\u0000\u0130\u0131\u0003@ \u0000\u0131\u0132\u0005\u00a6"+
		"\u0000\u0000\u01321\u0001\u0000\u0000\u0000\u0133\u0134\u0005\u00b0\u0000"+
		"\u0000\u0134\u0135\u0005\u00a5\u0000\u0000\u0135\u0136\u0005\u00bc\u0000"+
		"\u0000\u0136\u0137\u0005\u00a6\u0000\u0000\u01373\u0001\u0000\u0000\u0000"+
		"\u0138\u0139\u0005\u00b1\u0000\u0000\u0139\u013c\u0005\u00a5\u0000\u0000"+
		"\u013a\u013d\u0005\u00bd\u0000\u0000\u013b\u013d\u0003@ \u0000\u013c\u013a"+
		"\u0001\u0000\u0000\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013d\u013e"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u00a6\u0000\u0000\u013f5\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0005\u00af\u0000\u0000\u0141\u0144\u0005"+
		"\u00a5\u0000\u0000\u0142\u0145\u0003@ \u0000\u0143\u0145\u0005\u00b8\u0000"+
		"\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0143\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0005\u00a6\u0000\u0000\u01497\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0005\u00b2\u0000\u0000\u014b\u014e\u0005\u00a5\u0000\u0000"+
		"\u014c\u014f\u0005\u00be\u0000\u0000\u014d\u014f\u0003@ \u0000\u014e\u014c"+
		"\u0001\u0000\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0150"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0005\u00a6\u0000\u0000\u01519\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0005\u00a7\u0000\u0000\u0153\u0154\u0005"+
		"\u00a5\u0000\u0000\u0154\u0155\u0003@ \u0000\u0155\u0156\u0005\u00a6\u0000"+
		"\u0000\u0156;\u0001\u0000\u0000\u0000\u0157\u0158\u0005\u00b3\u0000\u0000"+
		"\u0158\u015a\u0005\u00a5\u0000\u0000\u0159\u015b\u0003@ \u0000\u015a\u0159"+
		"\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015a"+
		"\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e"+
		"\u0001\u0000\u0000\u0000\u015e\u015f\u0005\u00a6\u0000\u0000\u015f=\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0005\u00ab\u0000\u0000\u0161\u0163\u0005"+
		"\u00a5\u0000\u0000\u0162\u0164\u0003@ \u0000\u0163\u0162\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0005\u00a6\u0000\u0000\u0168?\u0001\u0000\u0000\u0000"+
		"\u0169\u016a\u0007\u0001\u0000\u0000\u016aA\u0001\u0000\u0000\u0000\u016b"+
		"\u016c\u0007\u0002\u0000\u0000\u016cC\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0005\u0005\u0000\u0000\u016e\u0172\u0003F#\u0000\u016f\u0171\u0003H"+
		"$\u0000\u0170\u016f\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000"+
		"\u0000\u0173\u0175\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0005\u00a1\u0000\u0000\u0176E\u0001\u0000\u0000\u0000"+
		"\u0177\u0178\u0007\u0003\u0000\u0000\u0178G\u0001\u0000\u0000\u0000\u0179"+
		"\u0180\u0003\"\u0011\u0000\u017a\u017b\u0003L&\u0000\u017b\u017c\u0005"+
		"\t\u0000\u0000\u017c\u017d\u0005\u00a0\u0000\u0000\u017d\u0180\u0001\u0000"+
		"\u0000\u0000\u017e\u0180\u0003J%\u0000\u017f\u0179\u0001\u0000\u0000\u0000"+
		"\u017f\u017a\u0001\u0000\u0000\u0000\u017f\u017e\u0001\u0000\u0000\u0000"+
		"\u0180I\u0001\u0000\u0000\u0000\u0181\u0182\u0007\u0004\u0000\u0000\u0182"+
		"K\u0001\u0000\u0000\u0000\u0183\u0184\u0007\u0005\u0000\u0000\u0184M\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0003P(\u0000\u0186\u0187\u0005\t\u0000"+
		"\u0000\u0187\u0188\u0005\u00a0\u0000\u0000\u0188O\u0001\u0000\u0000\u0000"+
		"\u0189\u018a\u0007\u0006\u0000\u0000\u018aQ\u0001\u0000\u0000\u0000\u018b"+
		"\u0192\u0003V+\u0000\u018c\u0192\u0003b1\u0000\u018d\u0192\u0003d2\u0000"+
		"\u018e\u0192\u0003\\.\u0000\u018f\u0192\u0003^/\u0000\u0190\u0192\u0003"+
		"T*\u0000\u0191\u018b\u0001\u0000\u0000\u0000\u0191\u018c\u0001\u0000\u0000"+
		"\u0000\u0191\u018d\u0001\u0000\u0000\u0000\u0191\u018e\u0001\u0000\u0000"+
		"\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0190\u0001\u0000\u0000"+
		"\u0000\u0192S\u0001\u0000\u0000\u0000\u0193\u0195\u0005\u0003\u0000\u0000"+
		"\u0194\u0196\u0003`0\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198"+
		"\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019a"+
		"\u0005\u00c7\u0000\u0000\u019aU\u0001\u0000\u0000\u0000\u019b\u019f\u0005"+
		"\u0002\u0000\u0000\u019c\u019e\u0003X,\u0000\u019d\u019c\u0001\u0000\u0000"+
		"\u0000\u019e\u01a1\u0001\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000"+
		"\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a2\u01a3\u0005\u00c1\u0000"+
		"\u0000\u01a3W\u0001\u0000\u0000\u0000\u01a4\u01a5\u0007\u0007\u0000\u0000"+
		"\u01a5Y\u0001\u0000\u0000\u0000\u01a6\u01ab\u0003 \u0010\u0000\u01a7\u01ab"+
		"\u0003D\"\u0000\u01a8\u01ab\u0003R)\u0000\u01a9\u01ab\u0005\b\u0000\u0000"+
		"\u01aa\u01a6\u0001\u0000\u0000\u0000\u01aa\u01a7\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01a9\u0001\u0000\u0000\u0000"+
		"\u01ab[\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005\u0003\u0000\u0000\u01ad"+
		"\u01b1\u0005\u00c8\u0000\u0000\u01ae\u01b0\u0003`0\u0000\u01af\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b8\u0005"+
		"\u00c7\u0000\u0000\u01b5\u01b7\u0003Z-\u0000\u01b6\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b7\u01ba\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01cc\u0001\u0000\u0000"+
		"\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005\u0003\u0000"+
		"\u0000\u01bc\u01c0\u0005\u00cd\u0000\u0000\u01bd\u01bf\u0003`0\u0000\u01be"+
		"\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000\u01c0"+
		"\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c7\u0005\u00c7\u0000\u0000\u01c4\u01c6\u0003Z-\u0000\u01c5\u01c4\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c9\u0001\u0000\u0000\u0000\u01c7\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01cb\u0001"+
		"\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01ca\u01bb\u0001"+
		"\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cd\u01da\u0001"+
		"\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005"+
		"\u0003\u0000\u0000\u01d0\u01d1\u0005\u00cc\u0000\u0000\u01d1\u01d5\u0005"+
		"\u00c7\u0000\u0000\u01d2\u01d4\u0003Z-\u0000\u01d3\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d7\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d9\u0001\u0000\u0000"+
		"\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d8\u01cf\u0001\u0000\u0000"+
		"\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000\u0000"+
		"\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dd\u0001\u0000\u0000"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01de\u0005\u0003\u0000"+
		"\u0000\u01de\u01df\u0005\u00c9\u0000\u0000\u01df\u01e0\u0005\u00c7\u0000"+
		"\u0000\u01e0]\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005\u0003\u0000\u0000"+
		"\u01e2\u01e6\u0005\u00ca\u0000\u0000\u01e3\u01e5\u0003`0\u0000\u01e4\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6\u01e4"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e9"+
		"\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ed"+
		"\u0005\u00c7\u0000\u0000\u01ea\u01ec\u0003Z-\u0000\u01eb\u01ea\u0001\u0000"+
		"\u0000\u0000\u01ec\u01ef\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000"+
		"\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01fb\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005\u0003"+
		"\u0000\u0000\u01f1\u01f2\u0005\u00cc\u0000\u0000\u01f2\u01f6\u0005\u00c7"+
		"\u0000\u0000\u01f3\u01f5\u0003Z-\u0000\u01f4\u01f3\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f8\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000"+
		"\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7\u01fa\u0001\u0000\u0000\u0000"+
		"\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f9\u01f0\u0001\u0000\u0000\u0000"+
		"\u01fa\u01fd\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000"+
		"\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fe\u0001\u0000\u0000\u0000"+
		"\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fe\u01ff\u0005\u0003\u0000\u0000"+
		"\u01ff\u0200\u0005\u00cb\u0000\u0000\u0200\u0201\u0005\u00c7\u0000\u0000"+
		"\u0201_\u0001\u0000\u0000\u0000\u0202\u0203\u0007\b\u0000\u0000\u0203"+
		"a\u0001\u0000\u0000\u0000\u0204\u0206\u0005\u0003\u0000\u0000\u0205\u0207"+
		"\u0003`0\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000"+
		"\u0000\u0000\u0208\u0206\u0001\u0000\u0000\u0000\u0208\u0209\u0001\u0000"+
		"\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000\u020a\u020b\u0005\u00c7"+
		"\u0000\u0000\u020bc\u0001\u0000\u0000\u0000\u020c\u020d\u0005\u0007\u0000"+
		"\u0000\u020de\u0001\u0000\u0000\u0000+ir}\u0084\u0093\u009d\u00a9\u00b0"+
		"\u00ba\u00c1\u00c8\u00d6\u00e1\u00e8\u00ef\u00fa\u010b\u0117\u012a\u013c"+
		"\u0144\u0146\u014e\u015c\u0165\u0172\u017f\u0191\u0197\u019f\u01aa\u01b1"+
		"\u01b8\u01c0\u01c7\u01cc\u01d5\u01da\u01e6\u01ed\u01f6\u01fb\u0208";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}