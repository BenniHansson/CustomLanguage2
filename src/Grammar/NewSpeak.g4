grammar NewSpeak;
file
: code
 EOF
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
: 'again' unaryexpression condition unaryexpression code 'unagain'
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
: ID
| INT
| addexpression
;

ID: ('a'..'z'|'A'..'Z')+ ;
INT: ('0'..'9')+ ;
WS: [ \n\t\r]+ -> skip;