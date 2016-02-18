/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.Exp;
import resources.tm.model.ExpBinary;
import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlExpBinary extends TmlExpBase {

	TmlExpBase exp1;
	TmlExpBase exp2;
	String operator;
	/**
	 * 
	 */
	public TmlExpBinary(TmlExpBase exp1, String operator, TmlExpBase exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operator = operator;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlExpBase#getExpressionType()
	 */
	@Override
	public String getExpressionType() {
		// assume that for the moment all combined expressions return int
		return Strings.TypeInt;
	}
	
	@Override
	public boolean getIsSizeExpression() {
		//check whether the two inner expressions are size expressions and then check the composition
		//TODO: there could be problematic cases like a<=b<=c
		if(exp1.getIsSizeExpression() && exp2.getIsSizeExpression()){
			switch(operator){
				case Strings.OpAnd:
				case Strings.OpOr:
				case Strings.OpEqual:
				case Strings.OpLeq:
				case Strings.OpMult:
				case Strings.OpPlus:
				case Strings.OpGeq:
				case Strings.OpGt:
				case Strings.OpLt:
					return true;
				default:
					return false;
			}				
		}
		return false;
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
		return new ExpBinary(exp1.toBehavioralExp(), exp2.toBehavioralExp(), operator);
	}

	@Override
	public TmlExpBase getOpposite() {
		//TODO just a first idea
		if(getIsSizeExpression()){
			switch(operator){
				case Strings.OpAnd:{
					return new TmlExpBinary(exp1.getOpposite(), Strings.OpOr, exp2.getOpposite());
				}
					
				case Strings.OpOr:{
					return new TmlExpBinary(exp1.getOpposite(), Strings.OpAnd, exp2.getOpposite());
				}
				
				case Strings.OpEqual:{
					//TmlExpBinary lesExp = new TmlExpBinary(exp1, Strings.OpLt, exp2);
					TmlExpBinary gtExp = new TmlExpBinary(exp1, Strings.OpGt, exp2);
					
					//return new TmlExpBinary(lesExp, Strings.OpOr, gtExp);
					return gtExp;
				}
				
				case Strings.OpLeq:{
					return new TmlExpBinary(exp1, Strings.OpGt, exp2);
				}
				
				case Strings.OpGeq:{
					return new TmlExpBinary(exp1, Strings.OpLt, exp2);
				}
				
				case Strings.OpLt:{
					return new TmlExpBinary(exp1, Strings.OpGeq, exp2);
				}
				
				case Strings.OpGt:{
					return new TmlExpBinary(exp1, Strings.OpLeq, exp2);
				}
				
				default:
					return null;
			}				
		}else{
			//not size expressions does not have an opposite expression 
			return null;
		}
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", exp1, operator, exp2);
	}
	
}
