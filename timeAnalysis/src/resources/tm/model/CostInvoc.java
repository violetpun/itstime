package resources.tm.model;

import java.util.LinkedList;

import resources.util.Strings;

/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */

/**
 * @author Abel
 * Represents the cost of an invocation
 */
public class CostInvoc extends CostElement {
	
	ValMethodCall actualCall;
	LinkedList<CostElement> adjustments;
	
	public CostInvoc(ValMethodCall actualCall, LinkedList<CostElement> adjustments) {
		this.actualCall = actualCall;
		this.adjustments = adjustments;
	}
	
	@Override
	public String toString() {
		
		String result = actualCall.toString();
		if(adjustments!=null && adjustments.size() > 0)
			result = result + "," + Strings.join(adjustments, ",");
		
		return result;
	}
}
