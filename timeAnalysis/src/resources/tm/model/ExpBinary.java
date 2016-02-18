/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import resources.util.Strings;


/**
 * @author Abel
 * Represents a binary operation 
 */
public class ExpBinary extends Exp {
	
	Exp left;
	Exp right;
	String operator;
	
	/**
	 * @param left: Left expression
	 * @param right: Right expression
	 * @param operator: ("&&" , "||", "=", "<>", "<", ">", "<=", ">=")
	 */
	public ExpBinary(Exp left, Exp right, String operator) {
		super();
		this.left = left;
		this.right = right;
		this.operator = operator.equals(Strings.OpEqual)?"=":operator;
	}

	/* ACCESSORS */
	
	public Exp getLeft() {
		return left;
	}

	public Exp getRight() {
		return right;
	}

	public String getOperator() {
		return operator;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", left, operator, right);
	}
}
