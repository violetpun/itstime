/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;


import java.util.HashMap;
import java.util.List;

import resources.util.Strings;

/**
 * @author Abel
 * Represents a method call
 */
public class ValMethodCall {
	
	String methodId;
	List<String> actualParameters;
	
	
	/**
	 * @param methodId: The id of the method
	 * @param actualParameters: The actual parameters passed in the invocation, it cannot be empty, first parameter is always the carrier VM id
	 */
public ValMethodCall(String methodId, List<String> actualParameters) {
		this.methodId = methodId;
		this.actualParameters = actualParameters;					
	}
	
	/* ACCESSORS */
	public String getMethodId() {
		return methodId;
	}

	public String getCarrierId() {
		return actualParameters.get(0);
	}

	/* PUBLIC METHODS */
	
	/**
	 * @return The list of actual parameters of the method, the carrierId is the first argument
	 */
	public List<String> getActualParameters() {
		return actualParameters;
	}
	
	
	

	@Override
	public String toString() {
		
		String join = Strings.join(actualParameters, ", ");
		
		return methodId + "(" + join + ")";
	}

	public String toString(String modifier) {
		
		String join = Strings.join(actualParameters, ", ");
		
		return methodId + "_" + modifier + "(" + join + ")";
	}

	
}
