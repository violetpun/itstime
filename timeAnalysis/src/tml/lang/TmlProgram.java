/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import resources.tm.model.BTMethod;
import resources.tm.model.BTProgram;
import resources.tm.model.BType;
import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlProgram extends TmlElementBase {
	
	HashMap<String, TmlMethod> methods;

	/**
	 * 
	 */
	public TmlProgram() {
		methods = new HashMap<String, TmlMethod>();		
	}
	
	public void AddMethod(TmlMethod m){
		methods.put(m.getName(), m);
	}
	
	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics()
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		for(TmlMethod m : methods.values()){
			List<String> argumentTypes = new LinkedList<String>();
			for(TmlArgument a : m.arguments)
				argumentTypes.add(a.type);
			e.putMethod(m.getName(), argumentTypes);
		}
		
		for(TmlMethod m : methods.values()){
			m.checkSemantics(e, errors);
		}
	}

	public void addMain(List<TmlStatement> mainStmts, TmlExpBase mainCap) {
		// TODO Auto-generated method stub
		methods.put(Strings.MainMethodName, new TmlMethod(Strings.MainMethodName, mainCap, null, mainStmts, "_", true));
	}
	
	@Override
	public BType inferBehavior() throws Exception {
		
		BTMethod main = null;
		HashMap<String, BTMethod> methodBehaviors = new HashMap<String, BTMethod>();
		for(TmlMethod m : methods.values()){
			BTMethod bt = (BTMethod)m.inferBehavior();
			if(m.getName().equals(Strings.MainMethodName))
				main = bt;
			else
				methodBehaviors.put(bt.getMethodId(), bt);
		}
		
		//calculate R set for each method
		boolean noFixPointYet = true;
		while(noFixPointYet){
			noFixPointYet = false;
			for(BTMethod m:methodBehaviors.values())
				noFixPointYet |= m.updateBehavior(methodBehaviors);
		}
		
		
		return new BTProgram(main, methodBehaviors);
	}

}
