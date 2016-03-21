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

/**
 * @author Violet
 * Represents the acquire operation
 */
public class BTNewLocal extends BTAtom {

	public String objId;
	public Exp capacity;
	public String cogId = Strings.CurrentCog;
	
	/**
	 * @param capacity 
	 * @param tmId: The id of the tm being released
	 * @param statesEnv: The states of the related Tms
	 */
	public BTNewLocal(String tmId, Exp capacity) {
		this.objId = tmId;		
		this.capacity = capacity;
	}

	
	/* (non-Javadoc)
	 * @see resources.tm.model.BType#translate(resources.tm.model.DeltaSubstitution, resources.tm.model.EnvTranslation, java.lang.String, resources.tm.model.CostSequence)
	 */
//	comment out for the translation at the moment
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
//		//TODO: check this carefully
//		if(!carrierValue.equals(Strings.VMBot))
//			env.TmValues.put(vmId, new ValTmExt(new LinkedList<String>(), Strings.VMTop));
//		
//		//create a copy of the costs to avoid modifying the argument
//		CostSequence newCost = cost.clone();
//		
//		//Apply delta transformation to current states
//		HashMap<String, ValTmExt> actualStates = env.mergeTmValues(delta);
//		
//		//build cost element expression by substituting the id of the vm being released
//		CostElement costExp = new CostNew(new ValTmExt(carrierValue));
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
//		return "new local " + this.tmId + ";\n";
		return "new local object " + this.objId + " " + this.cogId + "[" + this.capacity + "];\n";
	}

}
