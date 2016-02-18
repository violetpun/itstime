/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

/**
 * @author Abel
 * Represents a variable
 */
public class ExpVariable extends Exp {

	String variableId;
	
	/**
	 * 
	 */
	public ExpVariable(String variableId) {
		this.variableId = variableId;
	}
	
	public String getValue(){return variableId;}
	
	@Override
	public String toString() {
		return variableId;
	}
}
