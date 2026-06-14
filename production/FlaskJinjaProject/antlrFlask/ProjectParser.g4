parser grammar ProjectParser;

options { tokenVocab=ProjectLexer; }

proge
    : (statement | empty_line)* EOF #progeRoot
    ;

empty_line
    : (NEWLINE | INDENT | DEDENT)+
    ;

statement
    : simple_stmt                 #simpleStatement
    | compound_stmt               #compoundStatement
    ;

simple_stmt
    : small_stmt (SEMI small_stmt)* (SEMI)? NEWLINE?
    ;

small_stmt
    : expr_stmt       #exprStatement
    | del_stmt        #delStatement
    | pass_stmt       #passStatement
    | flow_stmt       #flowStatement
    | import_stmt     #importStatement
    | global_stmt     #globalStatement
    ;

expr_stmt
    : testlist_star_expr ((annAssign) | (augassign testlist_star_expr) | (EQ testlist_star_expr))? #exprStmt
    ;

annAssign
    : COLON test (EQ test)? #annotatedAssign
    ;

augassign
    : PLUS  EQ
    | MINUS EQ
    | STAR  EQ
    | SLASH EQ
    ;

testlist_star_expr
    : test (COMMA test)* (COMMA)?
    | test comp_for
    ;

test
    : or_test (IF or_test ELSE test)?
    ;

or_test
    : and_test (OR and_test)*
    ;

and_test
    : not_test (AND not_test)*
    ;

not_test
    : NOT not_test
    | comparison
    ;

comparison
    : arith_expr (comp_op arith_expr)*
    ;

comp_op
    : LT | GT | EQEQ | GE | LE | NOTEQ | IN | NOT IN
    ;

arith_expr
    : term ((PLUS|MINUS) term)*
    ;

term
    : factor ((STAR|SLASH|FSLASH|PERCENT) factor)*
    ;

factor
    : (PLUS|MINUS|TILDE) factor
    | power
    ;

power
    : atom_expr (POW factor)?
    ;

atom_expr
    : atom trailer*
    | LPAREN (test | testlist_comp)? RPAREN
    ;

atom
    : LPAREN (testlist_comp)? RPAREN             #atomParen
    | LBRACK (listmaker)? RBRACK                 #atomList
    | LBRACE (dictmaker)? RBRACE                 #atomDict
    | NAME                                      #atomName
    | NUMBER                                    #atomNumber
    | STRING                                    #atomString
    | FSTRING                                   #atomFString
    | TRUE                                      #atomTrue
    | FALSE                                     #atomFalse
    | NONE                                      #atomNone
    ;

trailer
    : LPAREN (arglist)? RPAREN      #callTrailer
    | LBRACK subscriptlist RBRACK  #subscriptTrailer
    | DOT NAME                     #dotTrailer
    ;

subscriptlist
    : subscript (COMMA subscript)* (COMMA)?
    ;

subscript
    : test
    | ((test)? COLON (test)? (COLON (test)?)?)
    ;

listmaker
    : test (COMMA test)* (COMMA)?
    | test comp_for
    | NEWLINE* test (COMMA NEWLINE* test)* (COMMA)? NEWLINE*
    ;

dictmaker
    : test COLON test (COMMA test COLON test)* (COMMA)?
    | (test COLON test) comp_for
    | NEWLINE* test COLON test (COMMA NEWLINE* test COLON test)* (COMMA)? NEWLINE*
    ;

comp_for
    : FOR exprlist IN testlist (IF test)* #compFor
    ;

testlist_comp
    : test (COMMA test)* (COMMA)?
    | test comp_for
    ;

arglist
    : argument (COMMA argument)* (COMMA)?
    ;

argument
    : (test (comp_for)?)
    | (test EQ test)
    ;

del_stmt : DEL exprlist ;
pass_stmt : PASS ;
flow_stmt
    : BREAK
    | CONTINUE
    | RETURN (testlist)?
    ;

import_stmt
    : IMPORT dotted_as_names
    | FROM dotted_name IMPORT (STAR | import_as_names)
    ;

dotted_name : NAME (DOT NAME)* ;
dotted_as_names : dotted_as_name (COMMA dotted_as_name)* ;
dotted_as_name : dotted_name (AS NAME)? ;
import_as_names : import_as_name (COMMA import_as_name)* ;
import_as_name : NAME (AS NAME)? ;
global_stmt : GLOBAL NAME (COMMA NAME)* ;

compound_stmt
    : if_stmt    #ifStmt
    | while_stmt #whileStmt
    | for_stmt   #forStmt
    | funcdef    #funcDefStmt
    | classdef   #classDefinition
    | try_stmt   #tryStmt
    | with_stmt  #withStmt
    | decorated  #decoratedStmt
    ;

decorated : decorator+ (funcdef | classdef) ;
decorator : AT dotted_name (LPAREN (arglist)? RPAREN)? NEWLINE ;

if_stmt : IF test COLON suite (ELIF test COLON suite)* (ELSE COLON suite)? ;
while_stmt : WHILE test COLON suite (ELSE COLON suite)? ;
for_stmt : FOR exprlist IN testlist COLON suite (ELSE COLON suite)? ;

funcdef : DEF NAME LPAREN (parameters)? RPAREN (ARROW test)? COLON suite ;
parameters : typedargslist ;
typedargslist
    : ((tfpdef (EQ test)? (COMMA tfpdef (EQ test)?)*)?)
    | ((STAR NAME (COMMA NAME)*)?)
    ;
tfpdef : NAME (COLON test)? ;
classdef : CLASS NAME (LPAREN (arglist)? RPAREN)? COLON suite ;
try_stmt : TRY COLON suite (EXCEPT (test (AS NAME)?) COLON suite)+ ((FINALLY COLON suite) | (ELSE COLON suite))? ;
with_stmt : WITH with_item (COMMA with_item)* COLON suite ;
with_item : test (AS test)? ;

suite
    : simple_stmt
    | NEWLINE+ INDENT (statement | empty_line)+ DEDENT
    ;

exprlist : test (COMMA test)* (COMMA)? ;
testlist : test (COMMA test)* (COMMA)? ;