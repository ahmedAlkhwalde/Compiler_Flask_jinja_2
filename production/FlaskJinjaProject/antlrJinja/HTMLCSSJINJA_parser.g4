parser grammar HTMLCSSJINJA_parser;

options { tokenVocab = HTMLCSSJINJA_lexer; }

document
    : html* EOF         #documentLabel
    ;

html:  htmlelement      #htmlelementlabel
      |doctipe          #doctipelabel
      |jinjaElement     #jinjaElementlabel
      ;

doctipe: OPEN_TAG_START TAG_DOCTYPE CLOSE;

htmlelement: OPEN_TAG_START TAG_HTML attruputehtml* CLOSE contenthtml* END_TAG_START TAG_HTML CLOSE;

attruputehtml: attributehtml;

attributehtml: ATTR_LANG EQUALS (VALUE_LANG_EN|VALUE_LANG_AR) #langAttributeLabel;

contenthtml: head     #headlabel
           | body     #bodylabel;
text: TEXT;

head: OPEN_TAG_START TAG_HEAD CLOSE contenthead* END_TAG_START TAG_HEAD CLOSE;
body: OPEN_TAG_START TAG_BODY attributebody* CLOSE contentbody* END_TAG_START TAG_BODY CLOSE;


contenthead: normalTagElementhead          #normalTagElementheadlabel
           | selfClosingTagElementhead     #selfClosingTagElementheadlabel
           | jinjaElement                  #jinjasecondElementlabel
           ;

normalTagElementhead: OPEN_TAG_START tagsheadnormal attributehead* CLOSE text* END_TAG_START tagsheadnormal CLOSE #normaltaghead;
tagsheadnormal: TAG_TITLE;

selfClosingTagElementhead: OPEN_TAG_START tagsheadself attributehead* SLASH_CLOSE #selfclostaglabel;
tagsheadself: TAG_META;

contentbody
    : normalTagElementbody          #normalTagElementbodylabel
    | selfClosingTagElementbody     #selfClosingTagElementbodylabel
    | jinjaElement                  #jinjathirdElementlabel
    | TEXT                          #textlabel
    ;

normalTagElementbody: OPEN_TAG_START  tagsbodynamenormal attributebody* CLOSE contentbody* END_TAG_START tagsbodynamenormal CLOSE #normal_Tag_Element_body;

attribute_style: STYLE_ATTRIBUTE_START stylename+ STYLE_END #stylelabel;

stylename
        : color         #colorLabel
        | length        #lengthLabel
        | url           #urlLabel
        | repeat        #repeatLabel
        | position      #positionLabel
        | border_style  #borderStyleLabel
        | border_width  #borderWidthLabel
        | border        #borderLabel
        | font          #fontLabel
        | textcss       #textCssLabel
        | effect        #effectLabel
        | layout        #layoutLabel
        | offset        #offsetLabel
        ;

color: CSS_ATTR_COLOR CSS_TWOPOINT CSS_COLOR_VALUE CSS_SEMI;

length: CSS_LENGTH_PROPERTY CSS_TWOPOINT css_value+ CSS_SEMI;

url: CSS_URL_PROPERTY CSS_TWOPOINT CSS_URL_VALUE CSS_SEMI;

repeat: CSS_REPEAT_PROPERTY CSS_TWOPOINT CSS_REPEAT_VALUE CSS_SEMI;

position: CSS_POSITION_PROPERTY CSS_TWOPOINT css_value+ CSS_SEMI;

offset: CSS_OFFSET_PROPERTY CSS_TWOPOINT css_value CSS_SEMI;

border_style: CSS_BORDER_STYLE_PROPERTY CSS_TWOPOINT CSS_BORDER_STYLE_VALUE CSS_SEMI;

border_width: CSS_BORDER_WIDTH_PROPERTY CSS_TWOPOINT (CSS_BORDER_WIDTH_VALUE | css_value) CSS_SEMI;

border: CSS_BORDER_PROPERTY CSS_TWOPOINT (css_value | CSS_COLOR_VALUE)+ CSS_SEMI;

font: CSS_FONT_PROPERTY CSS_TWOPOINT (CSS_FONT_VALUE | css_value) CSS_SEMI;

textcss: CSS_TEXT_PROPERTY CSS_TWOPOINT css_value CSS_SEMI;

effect: CSS_EFFECT_PROPERTY CSS_TWOPOINT css_value+ CSS_SEMI;

layout: CSS_LAYOUT_PROPERTY CSS_TWOPOINT css_value+ CSS_SEMI;

// CSS value helper rule
css_value:
    CSS_SHORTHAND_VALUE
    | CSS_TEXT_VALUE
    | CSS_LAYOUT_VALUE
    | CSS_EFFECT_VALUE
    | CSS_OFFSET_PROPERTY
    | CSS_BORDER_STYLE_VALUE
    | CSS_BORDER_WIDTH_VALUE
    | CSS_FONT_VALUE
    | CSS_COLOR_VALUE
    | CSS_URL_VALUE
    | CSS_REPEAT_VALUE
    | CSS_POSITION_VALUE
    ;

tagsbodynamenormal
    : TAG_DIV
    | TAG_H1
    | TAG_H2
    | TAG_H3
    | TAG_FORM
    | TAG_LABEL
    | TAG_BUTTON
    | TAG_A
    | TAG_P
    | TAG_SECTION
    | TAG_ARTICLE
    | TAG_NAV
    | TAG_ASIDE
    | TAG_HEADER
    | TAG_FOOTER
    | TAG_MAIN
    | TAG_SPAN
    | TAG_H4
    | TAG_H5
    | TAG_H6
    | TAG_STRONG
    | TAG_B
    | TAG_I
    | TAG_EM
    | TAG_U
    | TAG_SMALL
    | TAG_MARK
    | TAG_SUB
    | TAG_SUP
    | TAG_BLOCKQUOTE
    | TAG_CODE
    | TAG_PRE
    | TAG_SELECT
    | TAG_OPTION
    | TAG_TEXTAREA
    | TAG_DATALIST
    | TAG_FIELDSET
    | TAG_LEGEND
    | TAG_OPTGROUP
    | TAG_AUDIO
    | TAG_VIDEO
    | TAG_CANVAS
    | TAG_SVG
    | TAG_PICTURE
    | TAG_UL
    | TAG_OL
    | TAG_LI
    | TAG_DL
    | TAG_DT
    | TAG_DD
    | TAG_TABLE
    | TAG_THEAD
    | TAG_TBODY
    | TAG_TFOOT
    | TAG_TR
    | TAG_TD
    | TAG_TH
    | TAG_CAPTION
    | TAG_COLGROUP
    | TAG_FIGURE
    | TAG_FIGCAPTION
    | TAG_DETAILS
    | TAG_SUMMARY
    | TAG_DIALOG
    ;

selfClosingTagElementbody: OPEN_TAG_START  tagsbodynameself attributebody* SLASH_CLOSE;
tagsbodynameself
    : TAG_BR
    | TAG_HR
    | TAG_IMG
    | TAG_INPUT
    | TAG_META
    | TAG_LINK
    | TAG_SOURCE
    | TAG_TRACK
    | TAG_WBR
    | TAG_AREA
    | TAG_BASE
    | TAG_COL
    | TAG_EMBED
    | TAG_PARAM
    ;

attributebody: attribute_style                             #attribute_stylelabel
             | attributenamebody EQUALS ATTRIBUTE_VALUE    #attributenamebodylabel
             | attributenamebodywithoutvalue               #attributenamebodywithoutvaluelabel;

attributenamebodywithoutvalue
    : ATTR_HIDDEN
    | ATTR_DRAGGABLE
    | ATTR_CONTENTEDITABLE
    | ATTR_TRANSLATE
    | ATTR_REQUIRED
    | ATTR_READONLY
    | ATTR_DISABLED
    | ATTR_CHECKED
    | ATTR_MULTIPLE
    | ATTR_NOVALIDATE
    | ATTR_CONTROLS
    | ATTR_AUTOPLAY
    | ATTR_LOOP
    | ATTR_MUTED
    ;

attributenamebody
    : ATTR_ID
    | ATTR_CLASS
    | ATTR_TITLE
    | ATTR_LANG
    | ATTR_DIR
    | ATTR_HIDDEN
    | ATTR_DRAGGABLE
    | ATTR_CONTENTEDITABLE
    | ATTR_TABINDEX
    | ATTR_ACCESSKEY
    | ATTR_TRANSLATE
    | ATTR_HREF
    | ATTR_TARGET
    | ATTR_REL
    | ATTR_DOWNLOAD
    | ATTR_REFERRERPOLICY
    | ATTR_SRC
    | ATTR_ALT
    | ATTR_WIDTH
    | ATTR_HEIGHT
    | ATTR_LOADING
    | ATTR_DECODING
    | ATTR_TYPE
    | ATTR_NAME
    | ATTR_VALUE
    | ATTR_PLACEHOLDER
    | ATTR_REQUIRED
    | ATTR_READONLY
    | ATTR_DISABLED
    | ATTR_CHECKED
    | ATTR_MAX
    | ATTR_MIN
    | ATTR_STEP
    | ATTR_PATTERN
    | ATTR_MAXLENGTH
    | ATTR_MINLENGTH
    | ATTR_MULTIPLE
    | ATTR_ACCEPT
    | ATTR_AUTOCOMPLETE
    | ATTR_SIZE
    | ATTR_METHOD
    | ATTR_ACTION
    | ATTR_ENCTYPE
    | ATTR_AUTOFILL
    | ATTR_NOVALIDATE
    | ATTR_ONCLICK
    | ATTR_ONCHANGE
    | ATTR_ONSUBMIT
    | ATTR_ONINPUT
    | ATTR_ONLOAD
    | ATTR_CONTROLS
    | ATTR_AUTOPLAY
    | ATTR_LOOP
    | ATTR_MUTED
    | ATTR_PRELOAD
    | ATTR_POSTER
    | ATTR_COLSPAN
    | ATTR_ROWSPAN
    | ATTR_SCOPE
    | ATTR_CHARSET
    | ATTR_CONTENT
    | ATTR_HTTP_EQUIV
    | ATTR_PROPERTY
    ;

attributehead: attributenamehead EQUALS ATTRIBUTE_VALUE;

attributenamehead
    : ATTR_CHARSET
    | ATTR_NAME
    | ATTR_CONTENT
    | ATTR_HTTP_EQUIV
    | ATTR_PROPERTY
    ;

jinjaElement
    : jinjaExpr         #jinjaExprlabel
    | jinjaStmt         #jinjaStmtlabel
    | jinjaIfBlock      #jinjaIfBlocklabel
    | jinjaForBlock     #jinjaForBlocklabel
    ;


jinjaExpr
    : JINJA_EXPR_START jinjaExprContent* JINJA_EXPR_END
    ;

jinjaExprContent
    : JINJA_EXPR_STRING
    | JINJA_EXPR_ATOM
    | JINJA_EXPR_SYMBOL
    | JINJA_EXPR_UNKNOWN
    ;

jinjaBlockContent
    : normalTagElementbody          #jinjaNormalTagLabel
    | selfClosingTagElementbody     #jinjaSelfClosingTagLabel
    | jinjaElement                  #jinjaNestedElementLabel
    | TEXT                          #jinjaTextLabel
    ;

jinjaIfBlock
    : JINJA_STMT_START JINJA_STMT_IF jinjaStmtArgument* JINJA_STMT_END
      jinjaBlockContent*
      (JINJA_STMT_START JINJA_STMT_ELIF jinjaStmtArgument* JINJA_STMT_END jinjaBlockContent*)*
      (JINJA_STMT_START JINJA_STMT_ELSE JINJA_STMT_END jinjaBlockContent*)*
      JINJA_STMT_START JINJA_STMT_ENDIF JINJA_STMT_END
    ;

jinjaForBlock
    : JINJA_STMT_START JINJA_STMT_FOR jinjaStmtArgument* JINJA_STMT_END
      jinjaBlockContent*
      (JINJA_STMT_START JINJA_STMT_ELSE JINJA_STMT_END jinjaBlockContent*)*
      JINJA_STMT_START JINJA_STMT_ENDFOR JINJA_STMT_END
    ;

jinjaStmtArgument
    : JINJA_STMT_ATOM
    | JINJA_STMT_SYMBOL
    | JINJA_STMT_STRING
    | JINJA_STMT_UNKNOWN
    | JINJA_STMT_ELSE
    | JINJA_STMT_ELIF
    | JINJA_STMT_IN
    | JINJA_STMT_SET
    | JINJA_STMT_BLOCK
    | JINJA_STMT_ENDBLOCK
    | JINJA_STMT_WITH
    | JINJA_STMT_ENDWITH
    | JINJA_STMT_MACRO
    | JINJA_STMT_ENDMACRO
    | JINJA_STMT_INCLUDE
    | JINJA_STMT_EXTENDS
    | JINJA_STMT_FROM
    ;

jinjaStmt
    : JINJA_STMT_START jinjaStmtArgument+ JINJA_STMT_END
    ;