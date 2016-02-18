/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.Exp;
import resources.tm.model.ExpValue;

/**
 * @author Violet
 *
 */
public class TmlExpInt extends TmlExpBase {

	int value;
	
	/**
	 * 
	 */
	public TmlExpInt(int value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlExpBase#getExpressionType()
	 */
	@Override
	public String getExpressionType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean getIsSizeExpression() {
		return true;
	}

	@Override
	public Exp toBehavioralExp() {
		return new ExpValue(value + "");
	}

	@Override
	public TmlExpBase getOpposite() {
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value + "";
	}

}
