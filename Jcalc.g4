grammar JCalc;

stmt: expr EOF;

expr:   '(' expr ')'            # Parent 
    |   expr '^' expr           # Square
    |   expr op=('*'|'/') expr  # MulDiv
    |   expr op=('+'|'-') expr  # AddSub
    |   INT                     # int
    ;

INT: [0-9]+;
MUL : '*' ; 
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LP  : '(' ;
RP  : ')' ;
SQR : '^' ;
WS  : [ \t\r\n]+ -> skip ;




