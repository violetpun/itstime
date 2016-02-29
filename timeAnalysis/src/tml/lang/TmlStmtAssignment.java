package tml.lang;

import java.util.LinkedList;
import java.util.List;

//import resources.tm.model.BTAcquire;
import resources.tm.model.BTNewCog;
import resources.tm.model.BTNewLocal;
import resources.tm.model.BTInvoc;
import resources.tm.model.BType;
import resources.tm.model.ValMethodCall;

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
	public BType inferBehavior() throws Exception {
		
//		if(exp instanceof TmlExpNew){
		if(exp instanceof TmlExpNewcog){
			//if it is an object in a _new_ cog, then generate an new-cog behavior (same as in the VM paper)
			return new BTNewCog(varId, ((TmlExpNewcog) exp).capcity.toBehavioralExp());
		}else if(exp instanceof TmlExpNewlocal){
			//if it is an object in a _old_ cog, then generate a cog behavior with the capacity of the current cog
			return new BTNewLocal(varId);
		} else if(exp instanceof TmlExpInvoke){
			//if it is a method invocation then generate the call
			//TODO notice that arguments are treated as String
			TmlExpInvoke tmlExpInvoke = (TmlExpInvoke)exp;
			
			List<String> arguments = new LinkedList<String>();
			arguments.add(tmlExpInvoke.receiver.toString());
			for(TmlExpBase e : tmlExpInvoke.arguments)
				arguments.add(e.toString());
						
			ValMethodCall call = new ValMethodCall(tmlExpInvoke.name, arguments);
			return new BTInvoc(varId, call);
		}else{
			return exp.inferBehavior();
		}
		
	}
}
