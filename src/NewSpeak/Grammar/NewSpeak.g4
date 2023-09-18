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
| 'samegreater'
| 'sameungreater'
;

addexpression
: unaryexpression 'dubleplus' expr
;

unaryexpression
: ID
| INT
;
print: 'versificator' expr;

expr
: addexpression
| unaryexpression
;

ID: ('a'..'z'|'A'..'Z')+ ;
INT: ('0'..'9')+ ;
WS: [ \n\t\r]+ -> skip;
Comment: ('//' .*? '\n' | '//' .*? EOF) -> skip;