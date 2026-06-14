lexer grammar HTMLCSSJINJA_lexer;

WS : [ \t\r\n]+ -> skip;

JINJA_EXPR_START    : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA_STMT_START    : '{%' -> pushMode(JINJA_STMT_MODE);

END_TAG_START  : '</' -> pushMode(TAG_MODE);
OPEN_TAG_START : '<'  -> pushMode(TAG_MODE);

HTML_COMMENT
    : '<!--' .*? '-->' -> skip
    ;

JANJI_COMMENT
    : '{#' .*? '#}' -> skip
    ;

TEXT : ~[<{]+ ;

mode TAG_MODE;

EQUALS : '=';

STYLE_ATTRIBUTE_START : 'style' EQUALS '"' -> pushMode(STYLE_MODE);

TAG_DOCTYPE: '!DOCTYPE html';
TAG_HTML   : 'html';
TAG_HEAD   : 'head';
TAG_META   : 'meta';
TAG_TITLE  : 'title';
TAG_BODY   : 'body';
TAG_DIV    : 'div';
TAG_H1     : 'h1';
TAG_H2     : 'h2';
TAG_H3     : 'h3';
TAG_H4     : 'h4';
TAG_H5     : 'h5';
TAG_H6     : 'h6';
TAG_P      : 'p';
TAG_A      : 'a';
TAG_IMG    : 'img';
TAG_BR     : 'br';
TAG_HR     : 'hr';
TAG_INPUT  : 'input';
TAG_FORM   : 'form';
TAG_LABEL  : 'label';
TAG_BUTTON : 'button';
TAG_STRONG      : 'strong';
TAG_B           : 'b';
TAG_I           : 'i';
TAG_EM          : 'em';
TAG_U           : 'u';
TAG_SMALL       : 'small';
TAG_MARK        : 'mark';
TAG_SUB         : 'sub';
TAG_SUP         : 'sup';
TAG_BLOCKQUOTE  : 'blockquote';
TAG_CODE        : 'code';
TAG_PRE         : 'pre';
TAG_SELECT      : 'select';
TAG_OPTION      : 'option';
TAG_TEXTAREA    : 'textarea';
TAG_DATALIST    : 'datalist';
TAG_FIELDSET    : 'fieldset';
TAG_LEGEND      : 'legend';
TAG_OPTGROUP    : 'optgroup';
TAG_AUDIO       : 'audio';
TAG_VIDEO       : 'video';
TAG_CANVAS      : 'canvas';
TAG_SVG         : 'svg';
TAG_PICTURE     : 'picture';
TAG_UL          : 'ul';
TAG_OL          : 'ol';
TAG_LI          : 'li';
TAG_DL          : 'dl';
TAG_DT          : 'dt';
TAG_DD          : 'dd';
TAG_TABLE       : 'table';
TAG_THEAD       : 'thead';
TAG_TBODY       : 'tbody';
TAG_TFOOT       : 'tfoot';
TAG_TR          : 'tr';
TAG_TD          : 'td';
TAG_TH          : 'th';
TAG_CAPTION     : 'caption';
TAG_COLGROUP    : 'colgroup';
TAG_FIGURE      : 'figure';
TAG_FIGCAPTION  : 'figcaption';
TAG_DETAILS     : 'details';
TAG_SUMMARY     : 'summary';
TAG_DIALOG      : 'dialog';
TAG_LINK    : 'link';
TAG_SOURCE  : 'source';
TAG_TRACK   : 'track';
TAG_WBR     : 'wbr';
TAG_AREA    : 'area';
TAG_BASE    : 'base';
TAG_COL     : 'col';
TAG_EMBED   : 'embed';
TAG_PARAM   : 'param';
TAG_SECTION     : 'section';
TAG_ARTICLE     : 'article';
TAG_NAV         : 'nav';
TAG_ASIDE       : 'aside';
TAG_HEADER      : 'header';
TAG_FOOTER      : 'footer';
TAG_MAIN        : 'main';
TAG_SPAN        : 'span';


// HTML ATTRIBUTES
ATTR_HIDDEN             : 'hidden';
ATTR_DRAGGABLE          : 'draggable';
ATTR_CONTENTEDITABLE    : 'contenteditable';
ATTR_TRANSLATE          : 'translate';

ATTR_REQUIRED           : 'required';
ATTR_READONLY           : 'readonly';
ATTR_DISABLED           : 'disabled';
ATTR_CHECKED            : 'checked';
ATTR_MULTIPLE           : 'multiple';

ATTR_NOVALIDATE         : 'novalidate';

ATTR_CONTROLS           : 'controls';
ATTR_AUTOPLAY           : 'autoplay';
ATTR_LOOP               : 'loop';
ATTR_MUTED              : 'muted';

ATTR_ID                 : 'id';
ATTR_CLASS              : 'class';

ATTR_TITLE              : 'title';
ATTR_LANG               : 'lang';
ATTR_DIR                : 'dir';
ATTR_TABINDEX           : 'tabindex';
ATTR_ACCESSKEY          : 'accesskey';
ATTR_HREF               : 'href';
ATTR_TARGET             : 'target';
ATTR_REL                : 'rel';
ATTR_DOWNLOAD           : 'download';
ATTR_REFERRERPOLICY     : 'referrerpolicy';

ATTR_SRC                : 'src';
ATTR_ALT                : 'alt';
ATTR_WIDTH              : 'width';
ATTR_HEIGHT             : 'height';
ATTR_LOADING            : 'loading';
ATTR_DECODING           : 'decoding';
ATTR_TYPE               : 'type';
ATTR_NAME               : 'name';
ATTR_VALUE              : 'value';
ATTR_PLACEHOLDER        : 'placeholder';
ATTR_MAX                : 'max';
ATTR_MIN                : 'min';
ATTR_STEP               : 'step';
ATTR_PATTERN            : 'pattern';
ATTR_MAXLENGTH          : 'maxlength';
ATTR_MINLENGTH          : 'minlength';
ATTR_ACCEPT             : 'accept';
ATTR_AUTOCOMPLETE       : 'autocomplete';
ATTR_SIZE               : 'size';

ATTR_METHOD             : 'method';
ATTR_ACTION             : 'action';
ATTR_ENCTYPE            : 'enctype';
ATTR_AUTOFILL           : 'autofill';

ATTR_ONCLICK            : 'onclick';
ATTR_ONCHANGE           : 'onchange';
ATTR_ONSUBMIT           : 'onsubmit';
ATTR_ONINPUT            : 'oninput';
ATTR_ONLOAD             : 'onload';

ATTR_PRELOAD            : 'preload';
ATTR_POSTER             : 'poster';

ATTR_COLSPAN            : 'colspan';
ATTR_ROWSPAN            : 'rowspan';
ATTR_SCOPE              : 'scope';

ATTR_CHARSET            : 'charset';
ATTR_CONTENT            : 'content';
ATTR_HTTP_EQUIV         : 'http-equiv';
ATTR_PROPERTY           : 'property';

VALUE_LANG_EN: '"en"';
VALUE_LANG_AR: '"ar"';

ATTRIBUTE_NAME  : [a-zA-Z_:][a-zA-Z0-9._:-]*;

ATTRIBUTE_VALUE
    : '"' (~["])* '"'
    ;

SLASH_CLOSE : '/>' -> popMode;
CLOSE       : '>'  -> popMode;

TAG_WS : [ \t\r\n]+ -> skip;

mode STYLE_MODE;

STYLE_END               : '"' -> popMode;

// Punctuation
CSS_TWOPOINT            : ':';
CSS_SEMI                : ';';

// CSS Properties
CSS_TEXT_PROPERTY
    : 'text-align'
    | 'text-decoration'
    | 'text-transform'
    | 'vertical-align'
    | 'white-space'
    | 'line-height'
    ;

CSS_ATTR_COLOR
    : 'color' | 'background-color' | 'border-color'
    | 'text-decoration-color' | 'outline-color'
    ;

CSS_LENGTH_PROPERTY
    : 'margin' | 'margin-top' | 'margin-bottom' | 'margin-left' | 'margin-right'
    | 'padding' | 'padding-top' | 'padding-bottom' | 'padding-left' | 'padding-right'
    | 'width' | 'height'
    | 'border-radius'
    | 'min-width' | 'min-height' | 'max-width' | 'max-height'
    | 'background-size' | 'background-position'
    ;

CSS_OFFSET_PROPERTY
    : 'top' | 'bottom' | 'left' | 'right'
    ;

CSS_LAYOUT_PROPERTY
    : 'display' | 'position' | 'overflow' | 'visibility'
    | 'float' | 'clear'
    | 'z-index'
    | 'object-fit'
    | 'flex' | 'flex-grow' | 'flex-shrink' | 'flex-basis'
    | 'direction'
    ;

CSS_URL_PROPERTY
    : 'background-image'
    | 'list-style-image'
    ;

CSS_REPEAT_PROPERTY
    : 'background-repeat'
    | 'mask-repeat'
    ;

CSS_POSITION_PROPERTY
    : 'background-position'
    | 'transform-origin'
    | 'object-position'
    ;

CSS_BORDER_PROPERTY
    : 'border' | 'border-top' | 'border-bottom'
    | 'border-left' | 'border-right'
    | 'background'
    | 'box-shadow'
    ;

CSS_BORDER_STYLE_PROPERTY
    : 'border-style' | 'border-top-style' | 'border-bottom-style'
    | 'border-left-style' | 'border-right-style' | 'outline-style'
    ;

CSS_BORDER_WIDTH_PROPERTY
    : 'border-width' | 'border-top-width' | 'border-bottom-width'
    | 'border-left-width' | 'border-right-width' | 'outline-width'
    ;

CSS_FONT_PROPERTY
    : 'font-size' | 'font-weight' | 'font-style'
    | 'font-family'
    ;

CSS_EFFECT_PROPERTY
    : 'opacity' | 'cursor' | 'filter' | 'mix-blend-mode'
    ;

// CSS Values - Reordered to handle conflicts
CSS_TEXT_VALUE
    : 'left' | 'right' | 'center' | 'justify' | 'start' | 'end'
    | 'underline' | 'overline' | 'line-through' | 'none'
    | 'uppercase' | 'lowercase' | 'capitalize'
    | 'baseline' | 'sub' | 'super'
    | 'text-top' | 'text-bottom' | 'middle'
    | 'top' | 'bottom' | 'normal'
    | 'nowrap' | 'pre' | 'pre-line' | 'pre-wrap' | 'break-spaces'
    ;

CSS_SHORTHAND_VALUE
    : LENGTH
    | PERCENT
    | INT
    | FLOAT
    | 'none'
    | 'auto'
    | 'left' | 'right' | 'center' | 'justify'  // Added text-align values
    | 'top' | 'bottom'  // Added position values
    | 'solid' | 'dashed' | 'dotted' | 'double' | 'groove' | 'ridge' | 'inset' | 'outset' | 'hidden'
    | 'thin' | 'medium' | 'thick'
    | 'normal' | 'italic' | 'oblique'
    | 'bold' | 'bolder' | 'lighter'
    | 'small' | 'medium' | 'large' | 'x-small' | 'xx-small' | 'x-large' | 'xx-large'
    | 'pointer' | 'default' | 'move' | 'text' | 'wait' | 'help' | 'not-allowed' | 'crosshair'
    | 'inherit' | 'initial' | 'unset'
    | 'rtl' | 'ltr'
    | 'block' | 'inline' | 'inline-block' | 'flex' | 'grid' | 'table'
    | 'static' | 'relative' | 'absolute' | 'fixed' | 'sticky'
    | 'visible' | 'hidden' | 'scroll' | 'auto'
    | 'cover' | 'contain' | 'fill' | 'scale-down'
    ;

CSS_EFFECT_VALUE
    : OPACITY_VALUE
    | CURSOR_VALUE
    | FILTER_VALUE
    | BLEND_MODE_VALUE
    ;

CSS_LAYOUT_VALUE
    : 'block' | 'inline' | 'inline-block' | 'flex' | 'grid' | 'table'
    | 'static' | 'relative' | 'absolute' | 'fixed' | 'sticky'
    | 'visible' | 'hidden' | 'scroll' | 'collapse' | 'auto'
    | 'both' | 'none'
    | 'cover' | 'contain' | 'fill' | 'scale-down'
    | 'rtl' | 'ltr'
    ;

CSS_COLOR_VALUE
    : HASH_COLOR
    | RGB_FUNC | RGBA_FUNC
    | HSL_FUNC | HSLA_FUNC
    | NAMED_COLOR
    ;

CSS_URL_VALUE
    : URL_FUNC
    ;

CSS_REPEAT_VALUE
    : 'repeat' | 'repeat-x' | 'repeat-y'
    | 'no-repeat' | 'round' | 'space'
    ;

CSS_POSITION_VALUE
    : LENGTH_POSITION
    | PERCENT
    ;

CSS_BORDER_STYLE_VALUE
    : 'hidden' | 'dotted' | 'dashed'
    | 'solid' | 'double' | 'groove' | 'ridge'
    | 'inset' | 'outset'
    ;

CSS_BORDER_WIDTH_VALUE
    : 'thin' | 'medium' | 'thick'
    ;

CSS_FONT_VALUE
    : FONT_SIZE_VALUE
    | FONT_WEIGHT_VALUE
    | FONT_STYLE_VALUE
    | FONT_FAMILY_VALUE
    ;

CSS_GENERIC_VALUE
    : NAME
    ;

fragment INT : [0-9]+ ;
fragment FLOAT : [0-9]+ '.' [0-9]+ ;
fragment LENGTH_UNIT : ('px'|'em'|'rem'|'vh'|'vw'|'pt'|'%') ;

fragment LENGTH : INT LENGTH_UNIT | FLOAT LENGTH_UNIT ;
fragment LENGTH_POSITION : LENGTH ;
fragment PERCENT : (INT|FLOAT) '%' ;

fragment HASH_COLOR : '#'[0-9a-fA-F]+ ;
fragment RGB_FUNC   : 'rgb(' ~[)]* ')' ;
fragment RGBA_FUNC  : 'rgba(' ~[)]* ')' ;
fragment HSL_FUNC   : 'hsl(' ~[)]* ')' ;
fragment HSLA_FUNC  : 'hsla(' ~[)]* ')' ;

fragment URL_FUNC : 'url(' ~[)]* ')' ;

fragment NAMED_COLOR
    : 'red' | 'green' | 'blue' | 'black' | 'white'
    | 'yellow' | 'cyan' | 'magenta' | 'gray' | 'grey'
    | 'silver' | 'transparent' | 'currentColor' | 'orange' | 'purple' | 'pink'
    | 'aliceblue' | 'antiquewhite' | 'aqua' | 'aquamarine' | 'azure'
    | 'beige' | 'bisque' | 'blanchedalmond' | 'blueviolet' | 'brown'
    | 'burlywood' | 'cadetblue' | 'chartreuse' | 'chocolate' | 'coral'
    | 'cornflowerblue' | 'cornsilk' | 'crimson' | 'darkblue' | 'darkcyan'
    | 'darkgoldenrod' | 'darkgray' | 'darkgreen' | 'darkgrey' | 'darkkhaki'
    | 'darkmagenta' | 'darkolivegreen' | 'darkorange' | 'darkorchid'
    | 'darkred' | 'darksalmon' | 'darkseagreen' | 'darkslateblue'
    | 'darkslategray' | 'darkslategrey' | 'darkturquoise' | 'darkviolet'
    | 'deeppink' | 'deepskyblue' | 'dimgray' | 'dimgrey' | 'dodgerblue'
    | 'firebrick' | 'floralwhite' | 'forestgreen' | 'fuchsia' | 'gainsboro'
    | 'ghostwhite' | 'gold' | 'goldenrod' | 'greenyellow' | 'honeydew'
    | 'hotpink' | 'indianred' | 'indigo' | 'ivory' | 'khaki' | 'lavender'
    | 'lavenderblush' | 'lawngreen' | 'lemonchiffon' | 'lightblue'
    | 'lightcoral' | 'lightcyan' | 'lightgoldenrodyellow' | 'lightgray'
    | 'lightgreen' | 'lightgrey' | 'lightpink' | 'lightsalmon'
    | 'lightseagreen' | 'lightskyblue' | 'lightslategray' | 'lightslategrey'
    | 'lightsteelblue' | 'lightyellow' | 'lime' | 'limegreen' | 'linen'
    | 'maroon' | 'mediumaquamarine' | 'mediumblue' | 'mediumorchid'
    | 'mediumpurple' | 'mediumseagreen' | 'mediumslateblue'
    | 'mediumspringgreen' | 'mediumturquoise' | 'mediumvioletred'
    | 'midnightblue' | 'mintcream' | 'mistyrose' | 'moccasin' | 'navajowhite'
    | 'navy' | 'oldlace' | 'olive' | 'olivedrab' | 'orangered' | 'orchid'
    | 'palegoldenrod' | 'palegreen' | 'paleturquoise' | 'palevioletred'
    | 'papayawhip' | 'peachpuff' | 'peru' | 'plum' | 'powderblue'
    | 'rosybrown' | 'royalblue' | 'saddlebrown' | 'salmon' | 'sandybrown'
    | 'seagreen' | 'seashell' | 'sienna' | 'skyblue' | 'slateblue'
    | 'slategray' | 'slategrey' | 'snow' | 'springgreen' | 'steelblue'
    | 'tan' | 'teal' | 'thistle' | 'tomato' | 'turquoise' | 'violet'
    | 'wheat' | 'whitesmoke' | 'yellowgreen'
    ;

// Text Keywords
fragment FONT_SIZE_VALUE
    : 'small' | 'medium' | 'large'
    | 'x-small' | 'xx-small' | 'x-large' | 'xx-large'
    ;

fragment FONT_WEIGHT_VALUE
    : 'bold' | 'lighter' | 'bolder'
    | '100' | '200' | '300' | '400' | '500' | '600' | '700' | '800' | '900'
    ;

fragment FONT_STYLE_VALUE
    : 'italic' | 'oblique' | 'normal'
    ;

fragment FONT_FAMILY_VALUE
    : ('"' ~["\r\n]* '"')
    | '\'' ~['\r\n]* '\''
    | 'serif' | 'sans-serif' | 'monospace'
    | 'cursive' | 'fantasy' | 'Arial' | 'Helvetica' | 'Times New Roman'
    ;

fragment OPACITY_VALUE : '0' | '1' | '0.' [0-9]+ ;

fragment CURSOR_VALUE
    : 'default' | 'pointer' | 'move'
    | 'text' | 'wait' | 'help' | 'not-allowed'
    | 'crosshair' | 'grab' | 'grabbing'
    ;

fragment FILTER_VALUE : FILTER_FUNC ;
fragment FILTER_FUNC
    : NAME '(' ~[)]* ')'
    ;

fragment BLEND_MODE_VALUE
    : 'multiply' | 'screen' | 'overlay'
    | 'darken' | 'lighten'
    | 'color-dodge' | 'color-burn'
    | 'hard-light' | 'soft-light'
    | 'difference' | 'exclusion'
    | 'hue' | 'saturation' | 'luminosity'
    ;

fragment NAME : [a-zA-Z_][a-zA-Z0-9_-]* ;

STYLE_WS : [ \t\r\n]+ -> skip;

mode JINJA_EXPR_MODE;

JINJA_EXPR_END     : '}}' -> popMode;

JINJA_EXPR_WS : [ \t\r\n]+ -> skip;

JINJA_EXPR_STRING
    : '"' (~["]|'\\"')* '"'
    | '\'' (~[']|'\\\'')* '\''
    ;

JINJA_EXPR_ATOM : [a-zA-Z_][a-zA-Z0-9_.]* ;

JINJA_EXPR_SYMBOL : [+\-*/%=><!&|.,:;()[\]{}] ;

JINJA_EXPR_UNKNOWN : . ;

mode JINJA_STMT_MODE;

JINJA_STMT_END     : '%}' -> popMode;

JINJA_STMT_IF        : 'if';
JINJA_STMT_ENDIF     : 'endif';
JINJA_STMT_FOR       : 'for';
JINJA_STMT_ENDFOR    : 'endfor';
JINJA_STMT_ELSE      : 'else';
JINJA_STMT_ELIF      : 'elif';
JINJA_STMT_IN        : 'in';
JINJA_STMT_SET       : 'set';
JINJA_STMT_BLOCK     : 'block';
JINJA_STMT_ENDBLOCK  : 'endblock';
JINJA_STMT_WITH      : 'with';
JINJA_STMT_ENDWITH   : 'endwith';
JINJA_STMT_MACRO     : 'macro';
JINJA_STMT_ENDMACRO  : 'endmacro';
JINJA_STMT_INCLUDE   : 'include';
JINJA_STMT_EXTENDS   : 'extends';
JINJA_STMT_FROM      : 'from';

JINJA_STMT_WS : [ \t\r\n]+ -> skip;

JINJA_STMT_STRING
    : '"' (~["]|'\\"')* '"'
    | '\'' (~[']|'\\\'')* '\''
    ;

JINJA_STMT_ATOM : [a-zA-Z_][a-zA-Z0-9_.]* ;

JINJA_STMT_SYMBOL : [+\-*/%=><!&|.,:;()[\]{}] ;

JINJA_STMT_UNKNOWN : . ;