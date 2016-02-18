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
 * Represents the creation of a future by a method invocation
 */
public class BTInvoc extends BTAtom {

	String futureId;
	ValMethodCall methodCall;
	
	/**
	 * @param futureId
	 * @param methodCall
	 */
	public BTInvoc(String futureId, ValMethodCall methodCall) {
		this.futureId = futureId;
		this.methodCall = methodCall;
	}

	/* ACCESSORS */
	
	public String getFutureId() {
		return futureId;
	}


	public ValMethodCall getMethodCall() {
		return methodCall;
	}
	
	

	/* PUBLIC METHODS */

	/* (non-Javadoc)
	 * @see resources.vm.model.BType#translate(resources.vm.model.DeltaSubstitution, resources.vm.model.EnvTranslation, java.lang.String, resources.vm.model.CostSequence)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
//		//create a copy of the costs to avoid modifying the argument
//		List<String> newCost = new LinkedList<String>(cost.getCostElements());
//				
//		//add the future id as place holder in the cost sequence
//		//future id will be replaced by corresponding method cost at the moment of the sync
//		newCost.add(futureId);
//		
//		//add the future to the translation environment
//		env.setFutureValue(futureId, methodCall);
//		
//		//Build the result
//		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
//		result.add(new CostSequence(newCost, cost.getCondition()));
//		return result;
		
		
		
		//create a copy of the costs to avoid modifying the argument
		CostSequence newCost = cost.clone();
		
		if(!env.getVmState(methodCall.getCarrierId()).equals(Strings.VMBot)){
			//Add the cost of an invocation
			CostElement costExp = new CostFuture(futureId, methodCall);
			
			//add the cost expression to the cost list
			newCost.addCost(costExp);
			
			//add the future to the translation environment
			EnvVmStates vmStates =new EnvVmStates();
			for(String arg : methodCall.actualParameters){
				if(env.vmValues.containsKey(arg))
					vmStates.addVmState(arg, env.getVmValue(arg));
			}
			
			//add future id to released vm values
			List<String> releases = new LinkedList<String>(env.getMethodBehaviors().get(methodCall.getMethodId()).getReleasesForCall(methodCall));
			if(releases != null && releases.size() > 0){
				//List<String> newR = delta.applyAndReduce(releases); //apply delta to R set
				for(String pendingRelease:releases){
					ValVmExt val = env.getVmState(pendingRelease);
					val.getF().add(futureId);					
				}
			}
			
			env.setFutureValue(futureId, new ValFuture(vmStates, methodCall));
		}
		//Build the result
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
		result.add(newCost);
		return result;
		
	}

	@Override
	public String toString() {
		return String.format("new %s : %s;\n", futureId, methodCall);
	}
}
