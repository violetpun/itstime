/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.HashMap;

/**
 * @author Abel
 *
 */
public class ValFuture {

	private EnvVmStates vmState;
	private ValMethodCall call;
	/**
	 * @param vmState
	 * @param call
	 */
	public ValFuture(EnvVmStates vmState, ValMethodCall call) {
		this.vmState = vmState;
		this.call = call;
	}

	

	/**
	 * 
	 */
	public ValFuture() {
		// TODO Auto-generated constructor stub
	}

	public EnvVmStates getVmState() {
		return vmState;
	}

	public void setVmState(EnvVmStates vmState) {
		this.vmState = vmState;
	}

	public ValMethodCall getCall() {
		return call;
	}

	public void setCall(ValMethodCall call) {
		this.call = call;
	}
}
