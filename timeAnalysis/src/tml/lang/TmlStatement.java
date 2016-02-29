/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import resources.tm.model.BTSkip;
import resources.tm.model.BType;

/**
 * @author Violet
 *
 */
public abstract class TmlStatement extends TmlElementBase {

	/**
	 * 
	 */
	public TmlStatement() {
		// TODO Auto-generated constructor stub
	}

	public BType inferBehavior(TmlExpBase capacity) throws Exception {
		// TODO Auto-generated method stub
		return new BTSkip();
	}


}
