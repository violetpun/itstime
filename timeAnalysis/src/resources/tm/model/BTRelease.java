/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import resources.util.Strings;

/**
 * @author Abel
 * Represents the release operation
 */
public class BTRelease extends BTAtom {

	String vmId;
	
	
	/**
	 * @param vmId: The id of the vm being released
	 * @param statesEnv: The states of the related Vms
	 */
	public BTRelease(String vmId) {
		this.vmId = vmId;		
	}

	
	
	/* (non-Javadoc)
	 * @see resources.vm.model.BType#translate(resources.vm.model.DeltaSubstitution, resources.vm.model.TranslationEnvironment, java.lang.String, resources.vm.model.CostSequence)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
		//create a copy of the costs to avoid modifying the argument
		CostSequence newCost = cost.clone();
		
		//Apply delta transformation to current states
		//HashMap<String, ValVmExt> actualStates = env.mergeVmValues(delta);
				
		
		//build cost element expression by substituting the id of the vm being released
		CostElement costExp = new CostRelease(env.vmValues.get(delta.getRepresentative(vmId)));
		
		//add the cost expression to the cost list
		newCost.addCost(costExp);
		
		//Build the result
		//TODO check this out, should return always bot?
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
		result.add(newCost);
		
		if(!carrierValue.equals(Strings.VMBot))
			env.vmValues.put(delta.getRepresentative(vmId), new ValVmExt(Strings.VMBot));
		
		return result;
		
	}

	@Override
	public String toString() {
		return vmId + ".release;\n";
	}
}
