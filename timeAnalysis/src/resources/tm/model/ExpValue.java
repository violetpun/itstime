/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

/**
 * @author Abel
 * Represents a value like 1 or TOP
 */
public class ExpValue extends Exp {

	String value;
	
	/**
	 * 
	 */
	public ExpValue(String value) {
		this.value = value;
	}
	
	public String getValue(){return value;}
	
	
	@Override
	public String toString() {
		return value;
	}

}
