/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.Exp;
import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlExpNew extends TmlExpBase {

	/**
	 * 
	 */
	public TmlExpNew() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlExpBase#getExpressionType()
	 */
	@Override
	public String getExpressionType() {
		// TODO Auto-generated method stub
		return Strings.TypeVM;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		// TODO Auto-generated method stub

	}

	@Override
	public Exp toBehavioralExp() {
		// TODO should never be called
		return null;
	}

	@Override
	public TmlExpBase getOpposite() {
		return null;
	}
}
