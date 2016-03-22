package tml.lang;

import java.util.LinkedList;
import java.util.List;

//import resources.tm.model.BTAcquire;
//import resources.tm.model.BTCog;
import resources.tm.model.BTNewCog;
import resources.tm.model.BTNewLocal;
import resources.tm.model.BTAsyncInvoc;
import resources.tm.model.BType;
import resources.tm.model.BTAtom;
import resources.tm.model.BTCog;
import resources.tm.model.ValMethodCall;
import resources.util.Strings;

public class TmlStmtAssignment extends TmlStatement {

	String varId;
	TmlExpBase exp;
	TmlStmtVarDecl decl;
	boolean isSplittedDeclaration = false;
	
	public TmlStmtAssignment(TmlStmtVarDecl decl, TmlExpBase exp) {
		this(decl.id, exp);
		this.decl = decl;		
		isSplittedDeclaration = false;
	}

	public TmlStmtAssignment(String text, TmlExpBase exp) {
		this.varId = text;
		this.exp = exp;
		isSplittedDeclaration = true;
	}

	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		// TODO Auto-generated method stub

		exp.checkSemantics(e, errors);
		
		if(decl != null)
			decl.checkSemantics(e, errors);
		
		//TODO check type match
	}

	@Override
	public BType inferBehavior(TmlExpBase localCapacity, List<BTAtom> cogSets) throws Exception {
		
//		if(exp instanceof TmlExpNew){
		if(exp instanceof TmlExpNewcog){
			//if it is an object in a _new_ cog, then generate an new-cog behavior (same as in the VM paper)
			if (Strings.thisCap.equals(((TmlExpNewcog) exp).capacity.toString())) {			
//				System.out.println(((TmlExpNewcog) exp).capacity.toString());
				return new BTNewCog(varId, localCapacity.toBehavioralExp());
			}
				else {
//					System.out.println("else " + localCapacity);	
//					System.out.println(((TmlExpNewcog) exp).capacity.toString());
				return new BTNewCog(varId, ((TmlExpNewcog) exp).capacity.toBehavioralExp());
			}
		}else if(exp instanceof TmlExpNewlocal){
			//if it is an object in a _old_ cog, then generate a cog behavior with the capacity of the current cog
			return new BTNewLocal(varId, localCapacity.toBehavioralExp());
		} else if(exp instanceof TmlExpAsyncInvoke){
			//if it is a method invocation then generate the call
			//TODO notice that arguments are treated as String
			TmlExpAsyncInvoke tmlExpAsyncInvoke = (TmlExpAsyncInvoke)exp;
			
			//Add receiver
			String callee = tmlExpAsyncInvoke.receiver.toString() ;
			List<String> arguments = new LinkedList<String>();
			addCogToArg(arguments, callee, cogSets);
			
			//Add parameters
			for(TmlExpBase e : tmlExpAsyncInvoke.arguments){
				if (!addCogToArg(arguments, e.toString(), cogSets))
					arguments.add(e.toString());	
			}
							
			ValMethodCall call = new ValMethodCall(tmlExpAsyncInvoke.name, arguments);
			return new BTAsyncInvoc(varId, call);
		}else{
			return exp.inferBehavior();
		}
		
	}
	
	private boolean addCogToArg(List<String> arguments, String e, List<BTAtom> cogSets){
		for(BTAtom cog : cogSets) {
			if(cog instanceof BTNewCog){
				if(((BTNewCog) cog).cogId.equals(e)){
					arguments.add(e+"["+ ((BTNewCog) cog).capacity + "]");
					return true;	
				}
			} else if(cog instanceof BTNewLocal){  
				/*
				 * for the case where the asynchronous method call is made on the local cog
				 */
				if(((BTNewLocal) cog).objId.equals(e)){
					arguments.add(((BTNewLocal) cog).cogId+"["+ ((BTNewLocal) cog).capacity + "]");
					return true;	
				}
			} else if(cog instanceof BTCog){  
				/*
				 * for the case where the asynchronous method call is made on the parameter-cog
				 */
				if(((BTCog) cog).cogId.equals(e)){
					arguments.add(e+"["+ ((BTCog) cog).capacity + "]");
					return true;	
				}
			}
		}
		return false;	
	}
}
