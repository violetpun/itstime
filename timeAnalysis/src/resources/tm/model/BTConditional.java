/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.List;

import resources.util.Strings;

/**
 * @author Abel
 * Represents a conditioned sequence formed by a Condition and the Behavioral Type of the sequence
 */
public class BTConditional extends BType {

	Exp condition;
	BType sequence;
	
	/**
	 * @param condition: The conditional expression
	 * @param sequence: The behavioral type of the sequence
	 */
	public BTConditional(Exp exp, BType sequence) {
		super();
		this.condition = exp;
		this.sequence = sequence;
	}

	/* ACCESSORS */
	
	public Exp getCondition() {
		return condition;
	}

	public BType getSequence() {
		return sequence;
	}
	
	/* PUBLIC METHODS */

	/* (non-Javadoc)
	 * @see resources.vm.model.BType#Translate(resources.vm.model.DeltaSubstitution, resources.vm.model.TranslationEnvironment, java.util.List)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost){
		
		//calculate the new condition, if there is already a condition then take the aggregation
		//take this condition otherwise
		Exp currentCondition = cost.getCondition();
		Exp newCondition = currentCondition != null ? new ExpBinary(currentCondition, this.getCondition(), Strings.OpAnd)
														   : this.getCondition();
		
		//reformulate the accumulated cost
		CostSequence accumulated = new CostSequence(cost.getCostElements(), newCondition);
		
		//translate the conditioned sequence
		return sequence.translate(delta, env, carrierValue, accumulated);
		
	}

	@Override
	public String toString() {
		return "(" + condition.toString() + ")" + "{\n" + sequence + "}";
	}
}
