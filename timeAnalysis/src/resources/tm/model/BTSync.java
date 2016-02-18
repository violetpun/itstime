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
//import resources.tm.parser.TMContractsParser.VmValueContext;


/**
 * @author Violet
 *
 */
public class BTSync extends BTAtom {

	String futureId;
	//EnvVmStates statesEnv;
	//List<String> releases;
	
	/**
	 * @param vmId: The id of the vm being released
	 * @param statesEnv: The states of the related Vms
	 */
	public BTSync(String futureId/*, EnvVmStates statesEnv, List<String> releases*/) {
		this.futureId = futureId;
		//this.statesEnv = statesEnv;
		//this.releases = releases;
	}
	
	/* (non-Javadoc)
	 * @see resources.vm.model.BType#translate(resources.vm.model.DeltaSubstitution, resources.vm.model.EnvTranslation, java.lang.String, resources.vm.model.CostSequence)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
		//result
		//List<String> newCost = new ArrayList<String>(cost.getCostElements());
		
		CostSequence newCost = cost.clone(); 
		
		//check if the current future is in the list of active futures,
		//if it is not then we don't care about it as it cost has been already calculated
		ValFuture valFuture;
		if((valFuture=env.getFutureValue(futureId)) != null){
			ValMethodCall methodCall = valFuture.getCall();
			//get the environment with he delta substitution applied
			EnvVmStates localEnv = valFuture.getVmState().merge(delta);
			
			//1) Calculate the adjustment corresponding to pending releases
			LinkedList<CostElement> adjustments = new LinkedList<CostElement>();
			List<String> releases = new LinkedList<String>(env.getMethodBehaviors().get(methodCall.getMethodId()).getReleasesForCall(methodCall));
			if(releases != null && releases.size() > 0){
				//List<String> newR = delta.applyAndReduce(releases); //apply delta to R set
				for(String pendingRelease:releases){
					
					//ValVmExt valInEnvironment;
					//if((valInEnvironment = env.getVmValue(pendingRelease)) != null){
					//	valInEnvironment.vmValue = new ValVmExt(Strings.VMBot);
					//}else{
						env.addVmState(pendingRelease, new ValVmExt(Strings.VMBot));
					//}
						
						
					ValVmExt currentValue;
					//check whether there are active futures using this resource, if there are then take care of the CREL as they won't do it
					if((currentValue = localEnv.getVmState(pendingRelease))!= null && /*currentValue.getIsVariable() &&*/
							currentValue.getF() != null && currentValue.getF().size() > 0)
						adjustments.add(new CostRelease(currentValue));
					}				
			}
			
			//calculate the equivalence relation that will be used for the call
			//at the same time substitute the actual arguments with their values in the local environment
			//and also applies down arrow operator to those which have a non empty set F
			int[] eqRel = applySubstitutionAndGetEquivalenceRelation(methodCall, localEnv);
			
			//construct an unique identifier for the method call according to the equivalence relation
			String newName = methodCall.getMethodId() + "_" + Strings.join(eqRel, "_");
			
			ValMethodCall actualCall = new ValMethodCall(newName, applyEquivalenceToArgumentsList(methodCall.actualParameters, eqRel));
			//methodCall.methodId = newName; //modify methodName according to the eqRel
			//methodCall.actualParameters = applyEquivalenceToArgumentsList(methodCall.actualParameters, eqRel); //modify the parameters according to the eqRel
			
			
			
			//2) Add the new cost element to the cost sequence
			newCost.addCost(new CostSync(futureId, actualCall, adjustments));
			
			//3) remove the future from the active futures and save its peak cost
			env.markFutureAsSolved(futureId, actualCall);
						
		}else{
			//add zero cost for get-done
			//newCost.addCost(new CostZero());
		}
				
		
		
		//Build the result
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();
		result.add(newCost);
		return result;
		
	}

	private static List<String> applyEquivalenceToArgumentsList(List<String> elements, int[]equivalence){
		LinkedList<String> res = new LinkedList<String>();
		
		int cont = 0;
		for(int i = 0; i < equivalence.length; i++){
			if(equivalence[i] == cont){
				res.add(elements.get(i));
				cont++;
			}
		}
		
		return res;
	}
	
private static int[] applySubstitutionAndGetEquivalenceRelation(ValMethodCall methodCall, EnvVmStates localEnv) {
		
		int[] result = new int[methodCall.actualParameters.size()]; //the equivalence relation description
		boolean[] flags = new boolean[result.length];
		
		for(int i = 0; i < result.length; i++){
			if(!flags[i]){//if the element has not been substituted then it is the first of its kind
				result[i] = i;
				String current = methodCall.actualParameters.get(i);//grab the first occurrence
				ValVmExt val;
				if((val = localEnv.getVmState(current)) != null){//check if the parameter is a vm variable
					ValVmExt valDown = val.applyDownArrow(); //apply down arrow operator
					methodCall.actualParameters.set(i, valDown.toString());//substitute the parameter with its current value
					
					for(int j = i+1; j < result.length; j++){
						if(current.equals(methodCall.actualParameters.get(j))){//if the elements are variables with the same identity, then 
							result[j] = i;//point to the position of the first occurrence
							methodCall.actualParameters.set(j, valDown.getVmValue());//also substitute the occurrences of other members in the equivalence relation 
							flags[j] = true;//update flags
						}
					}
					
					//TODO: Is this totally wrong???
					/*//if(val.getIsVariable())//check if the value of the parameter is unknown
						for(int j = i+1; j < result.length; j++){
							ValVmExt val2;//look in the rest of the arguments for an element in the same class
							if((val2 = localEnv.getVmState(methodCall.actualParameters.get(j))) != null && val2.getIsVariable()
									&& val.getVmValue().equals(val2.getVmValue())){//if the elements are variables with the same identity, then 
								result[j] = i;//point to the position of the first occurrence
								methodCall.actualParameters.set(j, val.getVmValue());//also substitute the occurrences of other members in the equivalence relation 
								flags[j] = true;//update flags
							}
						}*/
				}
			}
		}
		
		return result;
	}


	@Override
	public String toString() {
		return futureId + ".get;\n";
	}
}

//@Override
//public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
//	
//	//result
//	//List<String> newCost = new ArrayList<String>(cost.getCostElements());
//	
//	CostSequence newCost = cost.clone(); 
//	
//	//check if the current future is in the list of active futures,
//	//if it is not then we don't care about it as it cost has been already calculated
//	ValMethodCall methodCall;
//	if((methodCall=env.getFutureValue(futureId)) != null){
//		
//		//get the environment with the delta substitution applied
//		EnvVmStates localEnv = statesEnv.merge(delta);
//		
//		//calculate the equivalence relation that will be used for the call
//		//at the same time substitute the actual arguments with their values in the local environment
//		//and also applies down arrow operator to those which have a non empty set F
//		int[] eqRel = applySubstitutionAndGetEquivalenceRelation(methodCall, localEnv);
//		
//		//construct an unique identifier for the method call according to the equivalence relation
//		String newName = methodCall.getMethodId() + "_" + Strings.join(eqRel, "_");
//		
//		ValMethodCall actualCall = new ValMethodCall(newName, applyEquivalenceToArgumentsList(methodCall.actualParameters, eqRel));
//		//methodCall.methodId = newName; //modify methodName according to the eqRel
//		//methodCall.actualParameters = applyEquivalenceToArgumentsList(methodCall.actualParameters, eqRel); //modify the parameters according to the eqRel
//		
//		//1) Calculate the adjustment corresponding to pending releases
//		LinkedList<CostElement> adjustments = new LinkedList<CostElement>();
//		if(releases != null && releases.size() > 0){
//			List<String> newR = delta.applyAndReduce(releases); //apply delta to R set
//			for(String pendingRelease:newR){
//				ValVmExt currentValue;
//				//check whether there are active futures using this resource, if there are then take care of the CREL as they won't do it
//				if((currentValue = localEnv.getVmState(pendingRelease))!= null && currentValue.getIsVariable() &&
//						currentValue.getF() != null && currentValue.getF().size() > 0)
//					adjustments.add(new CostRelease(currentValue));
//				}				
//		}
//		
//		//2) Add the new cost element to the cost sequence
//		newCost.addCost(new CostSync(futureId, actualCall, adjustments));
//		
//		//3) remove the future from the active futures and save its peak cost
//		env.markFutureAsSolved(futureId, actualCall);
//					
//	}else{
//		//add zero cost for get-done
//		newCost.addCost(new CostZero());
//	}
//			
//	
//	
//	//Build the result
//	LinkedList<CostSequence> result = new LinkedList<CostSequence>();
//	result.add(newCost);
//	return result;
//	
//}
//
//private static List<String> applyEquivalenceToArgumentsList(List<String> elements, int[]equivalence){
//	LinkedList<String> res = new LinkedList<String>();
//	
//	int cont = 0;
//	for(int i = 0; i < equivalence.length; i++){
//		if(equivalence[i] == cont){
//			res.add(elements.get(i));
//			cont++;
//		}
//	}
//	
//	return res;
//}
//
//private static int[] applySubstitutionAndGetEquivalenceRelation(ValMethodCall methodCall, EnvVmStates localEnv) {
//	
//	int[] result = new int[methodCall.actualParameters.size()]; //the equivalence relation description
//	boolean[] flags = new boolean[result.length];
//	
//	for(int i = 0; i < result.length; i++){
//		if(!flags[i]){//if the element has not been substituted then it is the first of its kind
//			result[i] = i;
//			String current = methodCall.actualParameters.get(i);//grab the first occurrence
//			ValVmExt val;
//			if((val = localEnv.getVmState(current)) != null){//check if the parameter is a vm variable
//				ValVmExt valDown = val.applyDownArrow(); //apply down arrow operator
//				methodCall.actualParameters.set(i, valDown.toString());//substitute the parameter with its current value
//				
//				for(int j = i+1; j < result.length; j++){
//					if(current.equals(methodCall.actualParameters.get(j))){//if the elements are variables with the same identity, then 
//						result[j] = i;//point to the position of the first occurrence
//						methodCall.actualParameters.set(j, valDown.getVmValue());//also substitute the occurrences of other members in the equivalence relation 
//						flags[j] = true;//update flags
//					}
//				}
//				
//				//TODO: Is this totally wrong???
//				/*//if(val.getIsVariable())//check if the value of the parameter is unknown
//					for(int j = i+1; j < result.length; j++){
//						ValVmExt val2;//look in the rest of the arguments for an element in the same class
//						if((val2 = localEnv.getVmState(methodCall.actualParameters.get(j))) != null && val2.getIsVariable()
//								&& val.getVmValue().equals(val2.getVmValue())){//if the elements are variables with the same identity, then 
//							result[j] = i;//point to the position of the first occurrence
//							methodCall.actualParameters.set(j, val.getVmValue());//also substitute the occurrences of other members in the equivalence relation 
//							flags[j] = true;//update flags
//						}
//					}*/
//			}
//		}
//	}
//	
//	return result;
//}

