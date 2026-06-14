lexer grammar ProjectLexer;

@members {
    private java.util.Stack<Integer> indents = new java.util.Stack<>();
    private java.util.LinkedList<Token> pendingTokens = new java.util.LinkedList<>();
    private int opened = 0;
    private int tokenIndex = 0;

    private CommonToken createToken(int type, String text) {
        int start = getCharIndex() - text.length();
        int stop = getCharIndex() - 1;
        CommonToken token = new CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
        token.setText(text);
        token.setTokenIndex(tokenIndex++);
        return token;
    }

    @Override
    public Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.poll();
        }

        Token next = super.nextToken();

        if (next.getType() == EOF) {
            while (!indents.isEmpty()) {
                indents.pop();
                pendingTokens.add(createToken(DEDENT, ""));
            }
            pendingTokens.add(next);
            return pendingTokens.poll();
        }

        return next;
    }
}

tokens { INDENT, DEDENT }

NEWLINE
    :   ('\r'? '\n') {
            String nl = getText();
            int nextChar = _input.LA(1);

            if (opened > 0 || nextChar == '\r' || nextChar == '\n' || nextChar == '#') {
                emit(createToken(NEWLINE, nl));
            } else {
                int indentCount = 0;
                int pos = 1;

                while (true) {
                    int c = _input.LA(pos);
                    if (c == ' ') {
                        indentCount++;
                    } else if (c == '\t') {
                        indentCount += 4;
                    } else if (c == '\r' || c == '\n' || c == '#') {
                        break;
                    } else if (c == CharStream.EOF) {
                        break;
                    } else {
                        break;
                    }
                    pos++;
                }

                int currentIndent = indents.isEmpty() ? 0 : indents.peek();

                if (indentCount > currentIndent) {
                    indents.push(indentCount);
                    pendingTokens.add(createToken(INDENT, ""));

                } else if (indentCount < currentIndent) {
                    while (!indents.isEmpty() && indents.peek() > indentCount) {
                        indents.pop();
                        pendingTokens.add(createToken(DEDENT, ""));
                    }
                }

                emit(createToken(NEWLINE, nl));

                if (indentCount > 0) {
                    if (_input.index() + indentCount <= _input.size()) {
                        _input.seek(_input.index() + indentCount);
                    }
                }
            }
        }
    ;
COMMENT
    : '#' ~[\r\n]* -> skip
    ;
WS : [ \t]+ -> skip ;

LPAREN  : '(' {opened++;} ;
RPAREN  : ')' {opened = Math.max(0, opened-1);} ;
LBRACK  : '[' {opened++;} ;
RBRACK  : ']' {opened = Math.max(0, opened-1);} ;
LBRACE  : '{' {opened++;} ;
RBRACE  : '}' {opened = Math.max(0, opened-1);} ;

DEF     : 'def';
CLASS   : 'class';
RETURN  : 'return';
IF      : 'if';
ELSE    : 'else';
ELIF    : 'elif';
FOR     : 'for';
WHILE   : 'while';
IN      : 'in';
IMPORT  : 'import';
FROM    : 'from';
AS      : 'as';
PASS    : 'pass';
BREAK   : 'break';
CONTINUE: 'continue';
GLOBAL  : 'global';
NONLOCAL: 'nonlocal';

TRUE    : 'True';
FALSE   : 'False';
NONE    : 'None';

NOT     : 'not';
AND     : 'and';
OR      : 'or';

TRY     : 'try';
EXCEPT  : 'except';
FINALLY : 'finally';
WITH    : 'with';

LAMBDA  : 'lambda';
ASYNC   : 'async';
AWAIT   : 'await';

PLUS   : '+' ;
MINUS  : '-' ;
STAR   : '*' ;
POW    : '**' ;
SLASH  : '/' ;
FSLASH : '//' ;
PERCENT: '%' ;

EQ     : '=' ;
EQEQ   : '==' ;
NOTEQ  : '!=' ;
LT     : '<' ;
LE     : '<=' ;
GT     : '>' ;
GE     : '>=' ;

ARROW  : '->' ;
TILDE  : '~' ;
BITAND : '&' ;
BITOR  : '|' ;
XOR    : '^' ;
LSHIFT : '<<' ;
RSHIFT : '>>' ;
COLON  : ':' ;
COMMA  : ',' ;
DOT    : '.' ;
SEMI   : ';' ;
AT     : '@' ;

STRING
    : '"' (~["\\\r\n] | '\\' .)* '"'
    | '\'' (~['\\\r\n] | '\\' .)* '\''
    ;

FSTRING
    : ('f' | 'F') '"' FSTRING_CHAR* '"'
    | ('f' | 'F') '\'' FSTRING_CHAR* '\''
    ;

fragment FSTRING_CHAR
    : ~["'\\\r\n{]
    | '\\' .
    | '{' FSTRING_EXPR '}'
    ;

fragment FSTRING_EXPR
    : (~[}\\] | '\\' .)*
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)? ([eE][+-]?[0-9]+)?
    | '.' [0-9]+ ([eE][+-]?[0-9]+)?
    ;

NAME
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;
