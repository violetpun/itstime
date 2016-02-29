/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.LinkedList;
import java.util.List;

import resources.tm.model.BTMethod;
import resources.tm.model.BType;
import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlMethod extends TmlElementBase {

	private String name;
	TmlExpBase capacity;
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

	public TmlMethod(String methodName, List<TmlArgument> arguments,
			List<TmlStatement> stmts, String returnType) {
		setName(methodName);
		this.arguments = arguments;
		body = new TmlStmtSeq(stmts);
		this.returnType = returnType;
	}
	
	/*
	 * With capacity
	 */
	public TmlMethod(String methodName, TmlExpBase methodCapacity, List<TmlArgument> arguments,
			List<TmlStatement> stmts, String returnType) {
		setName(methodName);
		setCapacity(methodCapacity);
		this.arguments = arguments;
		body = new TmlStmtSeq(stmts);
		this.returnType = returnType;
	}
	
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
		plainArguments.add(Strings.CurrentCog);
		if(!isMain){
			for(TmlArgument e : arguments)
				plainArguments.add(e.id);
			
			return new BTMethod(name, plainArguments, body.inferBehavior(), returnType, releases );
		}else{
			assert capacity != null;
			return new BTMethod(capacity.toBehavioralExp(), body.inferBehavior());
		}
	}

}
