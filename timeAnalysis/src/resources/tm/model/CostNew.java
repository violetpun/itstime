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
public class CostNew extends CostElement {

	ValVmExt carrierVmState;
	
	/**
	 * @param valVmExt 
	 * 
	 */
	public CostNew(ValVmExt valVmExt) {
		carrierVmState = valVmExt;
	}
	
	
	@Override
	public String toString() {
		return Strings.AcquireHelper + "(" + carrierVmState.getVmValue() + ")";
	}

}
