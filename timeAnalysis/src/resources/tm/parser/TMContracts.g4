/*
 * @Author Violet
 * Grammar definition for TM Contracts
 */

grammar TMContracts;

@header{
        import resources.tm.model.*;
        import java.util.LinkedList;
}

basicValue 			: UNIT | ID;

tmValue				returns [String val, boolean isVariable, Exp e]
					: ID {$val = $ID.text; $isVariable = true; $e = new ExpVariable($val); }
					| v=(PART | BOT | TOP) {$val = $v.text; $isVariable = false; $e = new ExpValue($val);};
					
sizeExp				returns [Exp exp]
					: NUMBER {$exp = new ExpValue($NUMBER.text);}
					| ID {$exp = new ExpVariable($ID.text);}
					| LPAREN tmValue LEG v=(TOP | BOT) RPAREN {$exp = new ExpBinary($tmValue.e, new ExpValue($v.text), $LEG.text);}
					| e1=sizeExp op=(PLUS | MULT | MINUS | EQUALS | DISTINCT | LEG | GEG | LT | GT | AND | OR) e2=sizeExp {$exp = new ExpBinary($e1.exp, $e2.exp, $op.text);};
					
typingValue			: basicValue 
					| sizeExp;

idSet 				returns [LinkedList<String> ids]
            		@init{$ids = new LinkedList<String>();}
            		: LCBRACK (ID{$ids.add($ID.text);} ( COMMA ID{$ids.add($ID.text);})*)? RCBRACK;
					
tmEnvironment		returns [EnvTmStates env]
					@init{$env=new EnvTmStates(); List<String> ids = null;}
					: LSBRACK (
								ID UPD (idSet{ids = $idSet.ids;})? tmValue {$env.addTmState($ID.text, new ValTmExt(ids, $tmValue.val)); ids = null;} 
								(COMMA ID UPD (idSet{ids = $idSet.ids;})? tmValue {$env.addTmState($ID.text, new ValTmExt(ids, $tmValue.val)); ids = null;} )*
							  )? RSBRACK;			

//futureValue			: basicValue
//					| LPAREN basicValue COMMA ID COMMA tmEnvironment COMMA idSet RPAREN;
					
methodCall			returns [ValMethodCall call]
					@init{LinkedList<String> args = new LinkedList<String>();}
					: method=ID carrier=ID {args.add($carrier.text);} LPAREN (typingValue {args.add($typingValue.text);} (COMMA typingValue {args.add($typingValue.text);})*)? RPAREN
					{$call = new ValMethodCall($method.text, args);};					
					
atom				returns [BTAtom a]
					: SKIP {$a = new BTSkip();}
					
					| NEW ID (tmEnvironment {$a = new BTAcquire($ID.text/* , $tmEnvironment.env*/);}
							 | COLON methodCall {$a = new BTInvoc($ID.text, $methodCall.call);})
					
					| ID DOT (RELEASE tmEnvironment {$a = new BTRelease($ID.text/*, $tmEnvironment.env*/);}
						     | {List<String> ids = null;} SYNC tmEnvironment (idSet{ids = $idSet.ids;})? 
						     {$a = new BTSync($ID.text);});
					
behavioralType		returns [BType bt]
					@init{BType cont = null;}
					: atom (SEMI c=behavioralType {cont = $c.bt;})? {$bt = (cont == null)? $atom.a : new BTSequence($atom.a, cont);} SEMI?
					| b1=behavioralType PLUS b2=behavioralType {$bt = new BTChoice($b1.bt, $b2.bt);}
					| LPAREN sizeExp RPAREN LCBRACK b2=behavioralType RCBRACK {$bt = new BTConditional($sizeExp.exp, $b2.bt);};			
					
behavioralInterface	returns [BTMethod bt]
					@init{LinkedList<String> args = new LinkedList<String>();}
					: id=ID p=ID{args.add($p.text);} LPAREN (p=ID {args.add($p.text);} (COMMA p=ID {args.add($p.text);})* )? RPAREN LCBRACK b1=behavioralType RCBRACK basicValue COMMA idSet
					{$bt = new BTMethod($id.text, args, $b1.bt, $basicValue.text, $idSet.ids);};

program				returns [BTProgram p]
					@init{LinkedList<BTMethod> methods = new LinkedList<BTMethod>();}
					: (bi=behavioralInterface{methods.add($bi.bt);})* LCBRACK main=behavioralType RCBRACK
					{$p = new BTProgram(new BTMethod($main.bt), methods);} ;				
  	

/*@header{
        import resources.tm.models.*;
        import java.util.HashMap;
        import java.util.LinkedList;
}

            //TYPES
pattern returns [TypeBase t] 
            : ID {$t= new TypeVariable($ID.text);}
            | record {$t=$record.r;};

record returns [TypeBase r]            
			: objectRecord {$r = $objectRecord.r; }	//[tm:alpha; ...]
            | UNIT {$r = new TypeUnit();}
            | ID {$r= new TypeVariable($ID.text);}
            ;
              
objectRecord returns [TypeRecord r]
			 @init{List<TypeBase> map = null;}
            : LSBRACK VM COLON ID (SEMI params{map = $params.map;})? RSBRACK
              {$r= new TypeRecord($ID.text, map);};
              
            //VALUES
actualParam returns [IActualValue av] 
            : exp {$av = $exp.e;}
            | objectRecord{$av = $objectRecord.r;}
            | UNIT {$av = new TypeUnit();}
            ;

            //INVOCATION WITH ACTUAL PARAMETERS
methodCall returns [MethodCall call] 
            @init{LinkedList<IActualValue> l = new LinkedList();}
            : cl=ID DOT mt=ID objectRecord LPAREN (o=actualParam {l.add($o.av);} (COMMA o=actualParam {l.add($o.av);})*)? RPAREN
            {
                $call = new MethodCall($cl.text+ $DOT.text+ $mt.text,
                                        $objectRecord.r,
                                        l);
            }; 

            //PARAMETER DECLARATION
params returns [List<TypeBase> map]      
			@init{LinkedList<TypeBase> map = new LinkedList();}
            : (pattern {map.add($pattern.t);} (COMMA pattern {map.add($pattern.t);})* )?; 

            //CONTRACTS
atom returns [ContractAtom cntc]   
            : SKIP {$cntc = new ContractSkip();}
            | NEW ID (DOT r=RELEASE)? 
              {$cntc = new ContractVM($ID.text, $r!=null);}
            | NEW ID EQUALS (f=methodCall {$cntc = new ContractFuture($ID.text, $f.call);}
                            | NULL {$cntc = new ContractFuture($ID.text, null);})
            | ID DOT (RELEASE {$cntc = new ContractRelease($ID.text);}
                     | SYNC {$cntc = new ContractFutureSync($ID.text);})
            ;

contract returns [Contract cntc] locals [Expression se]
            : a=atom {$cntc = $a.cntc;} (SEMI cont=contract {$cntc = new ContractSeq($a.cntc, $cont.cntc);})?
            | (LPAREN exp RPAREN {$se=$exp.e;})? LCBRACK c=contract {$cntc = $se==null?$c.cntc: new ContractGuarded($se, $c.cntc);}RCBRACK
            | c1=contract PLUS c2=contract {$cntc=new ContractSum($c1.cntc, $c2.cntc);}
            ;

methodContract returns [ContractMethod cntc] 
            @init{List<TypeBase> map = null;}
            : cl=ID DOT mt=ID objectRecord LPAREN params{map = $params.map;} RPAREN 
                LCBRACK 
                    contract 
                RCBRACK UPD (record) COMMA releaseList
            {
                $cntc = new ContractMethod($cl.text+ $DOT.text+ $mt.text,
                                        $objectRecord.r,
                                        map,
                                        $contract.cntc,
                                        $record.r,
                                        $releaseList.ids);
            }; 

releaseList returns [LinkedList<String> ids]
            @init{$ids = new LinkedList();}
            : LCBRACK (ID{$ids.add($ID.text);} (COMMA ID{$ids.add($ID.text);} )* )? RCBRACK;

            //VALUES AND NORMAL EXPRESSIONS
tmValue     : BOT | TOP | PART ; 
val returns [ExpressionValue e]        
            : (NUMBER {$e=new ExpressionIntValue($NUMBER.int);}
              | NULL {$e=new ExpressionNullValue();}
              | v=(TRUE | FALSE){$e=new ExpressionBoolValue(Boolean.parseBoolean($v.text));})
            | tmValue {
            	try{
            		$e = ExpressionVMValue.getValueFromText($tmValue.text);
				}catch(Exception e){ //TODO make a better error processing here
					throw new RuntimeException("Invalid VM Value");	
				}				
            }
            ;
            
      

exp returns [Expression e]        
            : val {$e = $val.e;}
            | ID {$e =new ExpressionVariable($ID.text);}
            | LPAREN exp RPAREN {$e = $exp.e;} 
            | e1=exp op=(PLUS|MINUS) e2=exp 
              {$e = new ExpressionBinaryOperation($e1.e, $op.text, $e2.e);}
            | e1=exp op=(GEG|LEG|EQUALS|DISTINCT|AND|OR) e2=exp
              {$e = new ExpressionBinaryOperation($e1.e, $op.text, $e2.e);}
            ;
            
*/

/*************************************************************************
 * The following are rules for EXTENDED CONTRACTS i.e. environment updates
 *************************************************************************/
/*futureType  : LPAREN ERROR? valueType 
              COMMA (methodCall | NUMBER{$NUMBER.int == 0}?)
              COMMA envList?
              COMMA nameList?
              RPAREN TICK?; //NOT USED SO FAR*/

/*envList     : LSBRACK (envUpdate (COMMA envUpdate)* )? RSBRACK;*/

/*envUpdate   : ID COLON (BOT | TOP | PART) | fut COLON futureType;*/

/*atom        : NUMBER {$NUMBER.int == 0}?
            | NEW ID TICK? 
            | ID TICK 
            | NEW fut EQUALS (methodCall | NUMBER {$NUMBER.int == 0}? )
            | fut TICK LPAREN envList RPAREN;*/

/*contract    : atom (UPD envList)? (SEMI contract)?
            | gContract
            | gContract PLUS gContract
            ;*/
    
    
/*
 *   END OF EXTENDED CONTRACTS 
 *************************************************************************/

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
//DIV     : '/' ;
AND     : '&&' ;
OR      : '||' ;
GT      : '>' ;
LT      : '<' ;
GEG     : '>=';
LEG     : '<=' ;
EQUALS  : '=';
DISTINCT: '!=';
NOT     : '!' ;
SKIP    : 'skip';
COMMA   : ',';
COLON   : ':';
SEMI    : ';';
//TICK    : '\'';
UNIT    : '_';
UPD     : '->';
NEW     : 'new';
BOT     : 'BOT';
TOP     : 'TOP';
PART    : 'PART';
CLASS   : 'Class';
LOCAL	: 'local';
//VM      : 'vm';
DOT     : '.';
NULL    : 'null';
TRUE    : 'true';
FALSE   : 'false';
//RELEASE : 'release';
SYNC    : 'get';
//INT     : 'Int';
//BOOL    : 'Bool';

fragment CHAR 	: 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

fragment DIGIT	: '0'..'9';	
NUMBER          : DIGIT+;

//SCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;






