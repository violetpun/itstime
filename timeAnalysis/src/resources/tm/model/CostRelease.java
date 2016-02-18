/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import resources.util.Strings;

/**
 * @author Abel
 * Cost Element corresponding VM Acquisition
 */
public class CostRelease extends CostElement {

	ValVmExt vmState;
	
	/**
	 * @param valVmExt 
	 * 
	 */
	public CostRelease(ValVmExt valVmExt) {
		vmState = valVmExt;
	}
	
	
	@Override
	public String toString() {
		return Strings.ReleaseHelper + "(" + vmState.getVmValue() + ")";
	}

}
