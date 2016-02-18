/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

/**
 * @author Violet
 *
 */
public class TmlStmtReturn extends TmlStatement {

	TmlExpBase exp;
	
	/**
	 * 
	 */
	public TmlStmtReturn(TmlExpBase exp) {
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

}
