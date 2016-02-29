/*
 * @Author Violet, modifying Abel's VML code
 * Grammar definition for TML Language
 */

grammar tml;

program						: method* LCBRACK statement* RCBRACK WITH NUMBER;

//program						: method* LCBRACK statement* RCBRACK WITH NUMBER;

method 						: type ID LPAREN (parameter (COMMA parameter)*)? RPAREN LCBRACK statementList RCBRACK;

parameter					: type ID ;

type						: INT | CLASS;

extendedType				: type | FUT LT (type)? GT;

statementList				: statement*;

statement					: varDecl 
							| assignment 
							| ifStmt	
							| jobStmt	 					
							| returnStmt ;							 					
//							| release ;
							
assignment					: (extendedType? ID) ASSIGN sideEffectExp SEMI;							
							
varDecl 					: extendedType ID SEMI;

jobStmt						: JOB LPAREN exp RPAREN SEMI;

returnStmt 					: RETURN exp SEMI;

//release						: RELEASE ID SEMI;
							
sideEffectExp				: exp							
							| asyncInvoc
							| syncInvoc  //not so important at the moment
							| sync
							| newcog
							| newlocal;		
//							| acquire;
							
asyncInvoc					: receiver=exp BANG ID LPAREN (exp (COMMA exp)*)? RPAREN;

syncInvoc					: receiver=exp DOT ID LPAREN (exp (COMMA exp)*)? RPAREN;

sync						: exp DOT SYNC;

newcog						: NEW CLASS WITH exp;

newlocal					: NEW LOCAL CLASS;

//acquire						: NEW VM LPAREN RPAREN;							
							
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
							| THIS DOT CAPACITY														#thisCapacity
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

CLASS   : 'Class';
LOCAL	: 'local';
//VM      : 'VM';
DOT     : '.';
//NULL    : 'null';
//TRUE    : 'true';
//FALSE   : 'false';
//RELEASE : 'release';
WITH	: 'with';
SYNC    : 'get';
INT     : 'Int';
FUT		: 'Fut';
THIS	: 'this';
CAPACITY: 'capacity';
IF		: 'if';
ELSE	: 'else';
JOB		: 'job';
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

