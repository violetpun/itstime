/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package resources.tm.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import resources.util.Strings;


/**
 * @author Violet
 * Represents the acquire operation
 */
public class BTMethod extends BType {

	String methodId;
	Exp capacity;
	List<String> arguments;
	BType bodyBehavior;
	String returnValue;
	HashSet<String> releases;
	
	boolean isMain=false;
	
	
	
	/**
	 * @param methodId: The id of the method
	 * @param arguments: List of formal arguments, first argument is always the carrierID (this), in the context of the method
	 * @param bodyBehavior: Behavioral Type of the body
	 * @param returnValue: The return value is either a VM name or a '_' representing a value type
	 * @param releases: The list of tm names in the arguments that are released by this method
	 */
	public BTMethod(String methodId, List<String> arguments,
			BType bodyBehavior, String returnValue, List<String> releases) {
		this.methodId = methodId;
		this.arguments = arguments;
		this.bodyBehavior = bodyBehavior;
		this.returnValue = returnValue;
		this.releases = releases!=null? new HashSet<String>(releases):new HashSet<String>();
	}
	
	/*
	 * For main with capacity, and no release
	 */	
	public BTMethod(String methodId, Exp capacity, List<String> arguments, BType bodyBehavior, String returnValue) {
		this.methodId = methodId;
		this.capacity = capacity;
		this.arguments = arguments;
		this.bodyBehavior = bodyBehavior;
		this.returnValue = returnValue;
	}
	
	
	/**
	 * Intended for the Main Method
	 * @param bodyBehavior: The main behavior
	 */
	public BTMethod(Exp capacity, BType bodyBehavior) { 
		this("", capacity, null, bodyBehavior, "");
		isMain = true;
	}



	public String getMethodId() {
		return methodId;
	}


	public String getCarrierId() {
		return arguments.get(0);
	}


	public List<String> getArguments() {
		return arguments;
	}


	public BType getBodyBehavior() {
		return bodyBehavior;
	}


	public String getReturnValue() {
		return returnValue;
	}


	public HashSet<String> getReleases() {
		return releases;
	}


	/* (non-Javadoc)
	 * @see resources.tm.model.BType#translate(resources.tm.model.DeltaSubstitution, resources.tm.model.EnvTranslation, java.lang.String, resources.tm.model.CostSequence)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
		//return bodyBehavior.translate(new DeltaSubstitution(), new EnvTranslation(), Strings.VMTop, new CostSequence(new ArrayList<String>(), null));
		return bodyBehavior.translate(delta, env, carrierValue, cost);

	}
	
	@Override
	public String toString() {
		if(isMain){
			return "main( " + Strings.MainCog  + "[" + this.capacity + "] ){\n" + bodyBehavior + "}";
		}
		
		List<String> formalArgs = new LinkedList<String>(arguments) ;
		
		
		return methodId +  "(" + String.join(", ", formalArgs)+ "){\n" +
			bodyBehavior.toString() +
		"} " +returnValue + ",{" + String.join(", ", releases) + "}\n";
	}


	public boolean updateBehavior(HashMap<String, BTMethod> methodBehaviors) {
		int currentSize = releases.size();
		
		UpdateR(bodyBehavior, methodBehaviors);
		
		return currentSize < releases.size();
	}
	
	private void UpdateR(BType type, HashMap<String, BTMethod> methodBehaviors){
		if(type instanceof BTSequence){
			BTSequence seq = (BTSequence)type;
			UpdateR(seq.atom, methodBehaviors);
			UpdateR(seq.continuation, methodBehaviors);			
		}else if(type instanceof BTChoice){
			BTChoice choice = (BTChoice)type;
			UpdateR(choice.choice1, methodBehaviors);
			UpdateR(choice.choice2, methodBehaviors);
		}else if(type instanceof BTConditional){
			BTConditional cond = (BTConditional)type;
			UpdateR(cond.sequence, methodBehaviors);
		}else if(type instanceof BTInvoc){
			BTInvoc invoc = (BTInvoc)type;
			BTMethod called = methodBehaviors.get(invoc.getMethodCall().getMethodId());
			HashSet<String> currentCalledR = called.getReleases();
			//if the ith formal argument of the called method is released then add to the 
			//releases set the ith actual argument
			for(int i = 0; i<called.getArguments().size(); i++) {
				String actualRelease = invoc.getMethodCall().getActualParameters().get(i);
				if(currentCalledR.contains(called.getArguments().get(i)) && arguments.contains(actualRelease)){
					releases.add(actualRelease);
				}
			}
		}else{ 
			
		}
		
		return;
	}


	public HashSet<String> getReleasesForCall(ValMethodCall methodCall) {
		HashSet<String> result = new HashSet<String>();
		for(int i = 0; i< methodCall.actualParameters.size(); i++){
			if(releases.contains(arguments.get(i))){
				result.add(methodCall.actualParameters.get(i));
			}
		}
		
		return result;
	}

}
