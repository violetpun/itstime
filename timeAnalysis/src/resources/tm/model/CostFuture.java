/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

/**
 * @author Abel
 *
 */
public class CostFuture extends CostElement {

	String futureId;
	ValMethodCall methodCall;
	
	/**
	 * @param futureId 
	 * represents the id of the future corresponding to an invocation
	 * @param methodCall 
	 */
	public CostFuture(String futureId, ValMethodCall methodCall) {
		this.futureId = futureId;
		this.methodCall = methodCall;
	}
	
	@Override
	public String toString() {
		return String.format("%s=%s", futureId, methodCall);
	}

}
