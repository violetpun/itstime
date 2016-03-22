/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.LinkedList;
import java.util.List;

import resources.tm.model.BTAtom;
import resources.tm.model.BTCog;
import resources.tm.model.BTMethod;
import resources.tm.model.BType;
import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlMethod extends TmlElementBase {

	String localCapacity = "C";
	private String name;
	TmlExpBase capacity = new TmlExpVar(localCapacity);
	List<TmlArgument> arguments; 
	TmlStmtSeq body;
	String returnType; 

	
	boolean isMain = false;
	
	/**
	 * 
	 */
	public TmlMethod() {
		// TODO Auto-generated constructor stub
	}

	// for methods which are not Main (no capacity)
	public TmlMethod(String methodName, List<TmlArgument> arguments,
			List<TmlStatement> stmts, String returnType) {
		setName(methodName);
		this.arguments = arguments;
		body = new TmlStmtSeq(stmts);
		this.returnType = returnType;
	}
	
	/*
	 * Main With capacity
	 */
	public TmlMethod(String methodName, TmlExpBase methodCapacity, List<TmlArgument> arguments,
			List<TmlStatement> stmts, String returnType) {
		setName(methodName);
		setCapacity(methodCapacity);
		this.arguments = arguments;
		body = new TmlStmtSeq(stmts);
		this.returnType = returnType;
	}
	
	//If the method is Main
	public TmlMethod(String methodName, TmlExpBase methodCapacity, List<TmlArgument> arguments,
			List<TmlStatement> stmts, String returnType, boolean isMain) {
		this(methodName, methodCapacity, arguments, stmts, returnType);
		this.isMain = isMain;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public TmlExpBase getCapacity() {
		return capacity;
	}

	public void setCapacity(TmlExpBase capacity) {
		this.capacity = capacity;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics()
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		e.openScope();
		
		for(TmlArgument a: arguments)
			a.checkSemantics(e, errors);
		
		body.checkSemantics(e, errors);
		
		
		e.closeScope();
		
	}

	@Override
	public BType inferBehavior() throws Exception {
		List<String> releases = new LinkedList<String>();
		List<String> plainArguments = new LinkedList<String>();
		List<BTAtom> argCogs = new LinkedList<BTAtom>();
		argCogs.add(new BTCog(Strings.CurrentCog, capacity.toBehavioralExp())) ;
		plainArguments.add(Strings.CurrentCog + "[" + capacity + "]");
		if(!isMain){
			for(TmlArgument e : arguments){
				if(e.type.equals(Strings.TypeClass)){
					argCogs.add(new BTCog(e.id, new TmlExpVar(e.id.toLowerCase()+"C").toBehavioralExp())) ;
					plainArguments.add(e.id + "[" + e.id.toLowerCase() + "C]");
				}
				else
					plainArguments.add(e.id);
			}
			return new BTMethod(name, plainArguments, body.inferBehavior(capacity, argCogs), returnType, releases );
		}else{
			assert capacity != null;
			return new BTMethod(capacity.toBehavioralExp(), body.inferBehavior(capacity, argCogs));
		}
	}

}
