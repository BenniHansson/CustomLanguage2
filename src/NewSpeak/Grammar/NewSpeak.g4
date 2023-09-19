grammar NewSpeak;
file
: code
| EOF
;

code
: statement code
| statement        // Implicitly defined terminal
;

statement
: decl
| assign
| print
| while
;

decl: 'artsem' ID;

expr
: addexpression
| subexpression
| unaryexpression
;

unaryexpression
: ID
| INT
;

addexpression
: unaryexpression 'dubleplus' expr
;

subexpression
: unaryexpression 'dubleunplus' expr
;

assign
: ID 'blackwhite' expr;

while
: 'again' whilecondition
code
'unagain'
;


whilecondition
: expr* condition expr*
;

condition
: 'greater'
| 'ungreater'
;

print
: 'versificator' ID
| 'versificator' INT;

ID: ('a'..'z'|'A'..'Z')+ ;
INT: ('0'..'9')+ ;
WS: [ \n\t\r]+ -> skip;
Comment: ('//' .*? '\n' | '//' .*? EOF) -> skip;
MULTILINE: ('/*' .*? '*/') -> skip;