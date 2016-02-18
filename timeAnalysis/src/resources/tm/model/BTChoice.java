/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.List;



/**
 * @author Abel
 * Represents the non-deterministic choice 
 */
public class BTChoice extends BType {

	BType choice1;
	BType choice2;
	
	/**
	 * @param choice1: First choice
	 * @param choice2: Second choice
	 */
	public BTChoice(BType choice1, BType choice2) {
		super();
		this.choice1 = choice1;
		this.choice2 = choice2;
	}

	/* ACCESSORS */
	
	public BType getChoice1() {
		return choice1;
	}

	public BType getChoice2() {
		return choice2;
	}

	/* PUBLIC METHODS */

	/* (non-Javadoc)
	 * @see resources.vm.model.BType#Translate(resources.vm.model.DeltaSubstitution, resources.vm.model.TranslationEnvironment, java.util.List)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost){
		
		//clone the current environment to avoid reference issues
		EnvTranslation secondEnv = env.clone();
				
		//translate choice1
		List<CostSequence> result = choice1.translate(delta, env, carrierValue, cost);
		
		//translate choice2 and add result to resulting list
		result.addAll(choice2.translate(delta, secondEnv, carrierValue, cost));
		
		return result;
	}

	@Override
	public String toString() {
		
		String choice1Rep = choice1 instanceof BTConditional?choice1.toString():"{\n" + choice1.toString() + "}";
		String choice2Rep = choice2 instanceof BTConditional?choice2.toString():"{\n" + choice2.toString() + "}";
		
		return choice1Rep + " + " + choice2Rep;

	}
	
}
