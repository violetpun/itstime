/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.BTAtom;
import resources.tm.model.BTJob;
import resources.tm.model.BType;

/**
 * @author Violet
 *
 */
public class TmlStmtJob extends TmlStatement {

	TmlExpBase exp;
	
	/**
	 * 
	 */
	public TmlStmtJob(TmlExpBase exp) {
		this.exp = exp;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {

		exp.checkSemantics(e, errors);
		
		//TODO check return type
		//TODO check that all code paths return

	}
	
	@Override
	public BType inferBehavior(TmlExpBase capacity, List<BTAtom> existingCogs) throws Exception {
		
		return new BTJob(this.exp.toBehavioralExp(), capacity.toBehavioralExp());
		
	}

}
