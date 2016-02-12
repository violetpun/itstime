/*
 * @Author Abel
 * Grammar definition for VML Language
 */

grammar tml;

program						: method* LCBRACK statement* RCBRACK;

method 						: type ID LPAREN (parameter (COMMA parameter)*)? RPAREN LCBRACK statementList RCBRACK;

parameter					: type ID ;

type						: (INT | VM);

extendedType				: type | FUT LT type GT;

statementList				: statement*;

statement					: varDecl 
							| assignment 
							| ifStmt		 					
							| returnStmt 					
							| release ;
							
assignment					: (extendedType? ID) ASSIGN sideEffectExp SEMI;							
							
varDecl 					: extendedType ID SEMI;

returnStmt 					: RETURN exp SEMI;

release						: RELEASE ID SEMI;
							
sideEffectExp				: exp							
							| asyncInvoc
							| sync		
							| acquire;
							
asyncInvoc					: receiver=exp BANG ID LPAREN (exp (COMMA exp)*)? RPAREN;

sync						: exp DOT SYNC;

acquire						: NEW VM LPAREN RPAREN;							
							
ifStmt						: IF LPAREN exp RPAREN LCBRACK thenBranch=statementList RCBRACK ELSE LCBRACK elseBranch=statementList RCBRACK  #ifMultiple
							| IF LPAREN exp RPAREN s1=statement ELSE s2=statement														   #ifSingle	
							;
							
							

exp							: exp1=exp (op=(EQUALS | DISTINCT | LEG | GEG | LT | GT) exp2=exp) 		#comparissonExp
							| exp1=exp op=(AND | OR) exp2=exp	 									#booleanExp					
							| exp1=exp op=(PLUS | MINUS) exp2=exp 									#sumExp						
							| exp1=exp op=(MULT | DIV) exp2=exp 									#multExp
							| NUMBER 																#valueExp
							| ID 																	#varExp
							| LPAREN exp RPAREN 													#enclosingExp
							| THIS																	#thisExp	
							;
        //TOKENS
LPAREN  : '(';
RPAREN  : ')';
RSBRACK : ']';
LSBRACK : '[';
RCBRACK : '}';
LCBRACK : '{';
PLUS    : '+' ;
MINUS   : '-' ;
MULT    : '*' ;
DIV     : '/' ;
AND     : '&&' ;
OR      : '||' ;
GT      : '>' ;
LT      : '<' ;
GEG     : '>=';
LEG     : '<=' ;
EQUALS  : '==';
DISTINCT: '!=';
BANG     : '!' ;
ASSIGN  : '=';
COMMA   : ',';
SEMI    : ';';

NEW     : 'new';

VM      : 'VM';
DOT     : '.';
//NULL    : 'null';
//TRUE    : 'true';
//FALSE   : 'false';
RELEASE : 'release';
SYNC    : 'get';
INT     : 'Int';
FUT		: 'Fut';
THIS	: 'this';
IF		: 'if';
ELSE	: 'else';
RETURN	: 'return';

//BOOL    : 'Bool';

fragment CHAR 	: 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

fragment DIGIT	: '0'..'9';	
NUMBER          : DIGIT+;

//SCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

