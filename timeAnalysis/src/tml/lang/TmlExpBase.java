/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import resources.tm.model.Exp;


/**
 * @author Violet
 *
 */
public abstract class TmlExpBase extends TmlElementBase {

	/**
	 * 
	 */
	public TmlExpBase() {
		// TODO Auto-generated constructor stub
	}

	
	public abstract String getExpressionType();
	
	
	
	/**
	 * To be override by child classes. 
	 * @return true if the current expression is a size expression, false otherwise
	 */
	public boolean getIsSizeExpression(){
		
		return false;
		
	}


	public abstract Exp toBehavioralExp();


	/**
	 * Calculates the opposite condition, applies logical negative to the original	
	 * @return the negative expression
	 */
	public abstract TmlExpBase getOpposite();
}
