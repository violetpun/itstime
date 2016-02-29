/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.BTSkip;
import resources.tm.model.BType;

/**
 * @author Violet
 *
 */
public abstract class TmlElementBase {

	/**
	 * 
	 */
	public TmlElementBase() {
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract void checkSemantics(Environment e, List<String> errors); 
	
	
	/**
	 * The default implementation simply return an empty Behavioral Type (BTSkip).
	 * This method is designed to be override by child classes.
	 * @return a Behavioral Type resembling the current operation
	 */
	public BType inferBehavior() throws Exception{
		return new BTSkip();
	}


	public BType inferBehavior(TmlExpBase capacity) throws Exception {
		// TODO Auto-generated method stub
		return new BTSkip();
	}

}
