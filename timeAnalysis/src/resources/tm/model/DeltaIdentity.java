/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.List;

/**
 * @author Abel
 * Represents the identity substitution
 */
public class DeltaIdentity extends DeltaSubstitution {

	private DeltaIdentity(){}
	
	@Override
	public List<String> applyAndReduce(List<String> elements) {
		return elements;
	}
	
	@Override
	public String getRepresentative(String id) {
		return id;
	}
	
	
	private static DeltaIdentity _delta;
	public static DeltaIdentity identity(){return _delta == null? (_delta = new DeltaIdentity()): _delta;}

}
