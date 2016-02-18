/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.List;

public abstract class BType {

	
	/**
	 * It performs the translation from behavioral types to cost equations.
	 * @param delta: The equivalence relationship substitution for argument names
	 * @param env: The translation environment
	 * @param env: The id of the VM executing the behavior
	 * @param cost: The current accumulated cost
	 * @return: The list of cost sequences for each cost branch
	 */
	public abstract List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost);
	
}
