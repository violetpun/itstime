/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.LinkedList;

/**
 * @author Abel
 * Represents the cost of a sync operation
 */
public class CostSync extends CostElement {

	String futureId;
	ValMethodCall actualCall;
	LinkedList<CostElement> adjustments;
	
	public CostSync(String futureId, ValMethodCall actualCall, LinkedList<CostElement> adjustments) {
		this.futureId = futureId;
		this.actualCall = actualCall;
		this.adjustments = adjustments;
	}
	
	@Override
	public String toString() {
		return String.format("%s=%s + %s", futureId, actualCall, adjustments);
	}

}
