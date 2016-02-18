/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.LinkedList;
import java.util.List;



/**
 * @author Abel
 * Represents the empty behavior
 */
public class BTSkip extends BTAtom {

	/* (non-Javadoc)
	 * @see resources.vm.model.BType#translate(resources.vm.model.DeltaSubstitution, resources.vm.model.EnvTranslation, java.lang.String, resources.vm.model.CostSequence)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
		//CostSequence newCost = cost.clone();
		
		//newCost.addCost(new CostZero());
		
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
		result.add(cost);
		return result;
		
	}
	
	@Override
	public String toString() {
		
		return "";
	}

}
