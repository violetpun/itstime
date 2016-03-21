/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package resources.tm.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import resources.util.Strings;
//import tml.lang.TmlExpBase;

/**
 * @author Violet
 * Represents the acquire operation
 */
public class BTNewCog extends BTAtom {

	public String cogId;
	public Exp capacity;
	
	/**
	 * @param cogId: The id of the cog which is newly created
	 * @param statesEnv: The states of the related Vms
	 */
	public BTNewCog(String cogId, Exp capcity) {
		this.cogId = cogId;		
		this.capacity = capcity;
	}

	
	/* (non-Javadoc)
	 * @see resources.vm.model.BType#translate(resources.vm.model.DeltaSubstitution, resources.vm.model.EnvTranslation, java.lang.String, resources.vm.model.CostSequence)
	 */
//	VP: comment out for the translation at the moment
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
//		//TODO: check this carefully
//		if(!carrierValue.equals(Strings.VMBot))
//			env.vmValues.put(vmId, new ValVmExt(new LinkedList<String>(), Strings.VMTop));
//		
//		//create a copy of the costs to avoid modifying the argument
//		CostSequence newCost = cost.clone();
//		
//		//Apply delta transformation to current states
//		HashMap<String, ValVmExt> actualStates = env.mergeVmValues(delta);
//		
//		//build cost element expression by substituting the id of the vm being released
//		CostElement costExp = new CostNew(new ValVmExt(carrierValue));
//		
//		//add the cost expression to the cost list
//		newCost.addCost(costExp);
//		
//		//Build the result
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
//		result.add(newCost);
		return result;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new cog " + this.cogId + "[" + this.capacity + "]" + ";\n";
	}

}
