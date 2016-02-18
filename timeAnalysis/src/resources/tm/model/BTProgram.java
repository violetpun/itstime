/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package resources.tm.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class BTProgram extends BType{

	BTMethod mainMethod;
	HashMap<String, BTMethod> methods;
	
	HashMap<String, Boolean> pendingCalls;
	
	/**
	 * @param mainMethod: The main method of the program
	 * @param methods: The rest of declared methods
	 */
	public BTProgram(BTMethod mainMethod, List<BTMethod> methods) {
		this.mainMethod = mainMethod;
		this.methods = new HashMap<String, BTMethod>(); 
				for(BTMethod m:methods){
					this.methods.put(m.methodId, m);
				}
	}
	
	/**
	 * @param mainMethod: The main method of the program
	 * @param methods: The rest of declared methods
	 */
	public BTProgram(BTMethod mainMethod, HashMap<String, BTMethod> methods) {
		this.mainMethod = mainMethod;
		this.methods = methods;
	}

	
	
	public List<String> translate(){
		
		
		List<String> result = new LinkedList<String>();
		pendingCalls = new HashMap<String, Boolean>();
		
		EnvTranslation env = new EnvTranslation(methods);
		
		
		result.addAll(translateMain(env));
		
		
		String pendingCall;
		while((pendingCall=getPendingCall())!=null){
			
			result.add(""); //add empty line to divide 
			result.add(""); //add empty line to divide
			
			//include the equations of the method
			result.addAll(translateMethod(env, pendingCall));
			
			//mark this call as translated
			pendingCalls.put(pendingCall, false);
		}
		
		
		//Add equations for CNEW
		result.add(String.format("cnew(VM)=%s\t[%s]", "1", "VM < 3"));
		result.add(String.format("cnew(VM)=%s\t[%s]", "0", "VM = 3"));
		
		result.add(""); //add empty line to divide
		
		//Add equations for CREL 
		result.add(String.format("crel(VM)=%s\t[%s]", "-1", "VM = 1"));
		result.add(String.format("crel(VM)=%s\t[%s]", "0", "VM > 1"));
		
		result.add(""); //add empty line to divide
		
		
		//Add equation for CNORM
//		result.add(String.format("cmax(VM, VPART, VM)=%s\t[%s]", "0", "VM = 3"));
//		result.add(String.format("cmax(VM, VPART, VPART)=%s\t[%s]", "0", "2 <= VM"));
		
		return result;
	}


	private List<String> translateMethod(EnvTranslation env, String pendingCall) {
		
		
		
		List<String> result = new LinkedList<String>();
		
		
		
		BTMethod btMethod = getBTMethod(pendingCall);
		DeltaSubstitution delta = getDelta(pendingCall);
		
		List<String> formalArgs = delta.applyAndReduce(btMethod.getArguments());
		String argumentList = Strings.join(formalArgs, ",");
		
		String peakFormat = "%s_peak(" + argumentList + ")=%s\t[%s]"; 
		String netFormat = "%s_net(" + argumentList + ")=%s\t[%s]";
		
		//get the list of cost sequences and produce the translations for the method
		
		for(String arg : formalArgs)
			env.vmValues.put(arg, new ValVmExt(new LinkedList<String>(), arg));
		List<CostSequence> costs = btMethod.translate(delta, env, btMethod.getCarrierId(), CostSequence.empty());
		
		//TODO: the next two can be merged		
		//add cost 0 for dead carrier
		result.add(String.format(peakFormat, pendingCall, "", new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMBot), Strings.OpEqual)));
		
		//add cost 0 for peak cost
		result.add(String.format(peakFormat, pendingCall, "", new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMBot), Strings.OpLt)));
		
		//Each cost sequence represents an execution branch
		for(CostSequence seq:costs){
			
			//this is just for generating the equations in an friendly order
			int pos = result.size();
			
			//Create the environment for the sequence
			//this environment allows us to record the dependencies of method
			HashSet<String> dependencies = new HashSet<String>();
			
			Exp currentCondition = seq.getCondition();
			Exp carrierCondition = new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMBot), Strings.OpLt);
			Exp newCondition = currentCondition != null ? new ExpBinary(currentCondition, carrierCondition, Strings.OpAnd)
															   : carrierCondition;
			
			
			
			String lastChain = "";
			//peak costs are all possible subsequences starting at position 0
			int size = seq.getCostElements().size();
			for(int i = 0; i<size; i++){
				
				//save call costs
				//HashMap<String, String> actValues = new HashMap<String, String>();
				HashSet<String> completedFutures = new HashSet<String>();
				
				//build cost chain from backward, because of gets
				String costChain = "";
				for(int j=size -i -1; j >= 0; j--){
					
					//take the current cost
					CostElement currentCost = seq.getCostElements().get(j);
					
					//if it is a get, update the call cost with the net cost (which is the one after the # in the cost element)
					if(currentCost instanceof CostSync){
						completedFutures.add(((CostSync)currentCost).futureId);
						dependencies.add(((CostSync)currentCost).actualCall.getMethodId());
						currentCost = null;
					}
					
					//if it is a future creation then set its cost to the correct cost
					else if(currentCost instanceof CostFuture){
						String futureId = ((CostFuture)currentCost).futureId;
						
						if(completedFutures.contains(futureId)){ //if I have already found the get then use netCost
							currentCost = seq.getNetCost(futureId);
						}else{ //use peakCost otherwise
							currentCost = seq.getPeakCost(futureId);
						}
						
					}
										
					//if the current value is not null (this is that it is not a get) then include it in the chain
					if(currentCost != null){
						costChain = currentCost + (costChain.length() == 0? "":"," + costChain);
						if(j == 0){//if we took all elements then write the equation							
							result.add(pos, String.format(peakFormat, pendingCall, costChain, newCondition));
						
							
						}
						if(i == 0){
								lastChain = costChain; //grab the lastChain
						}
					}
				}	
				
				
			}
			
			//add separation
			result.add("");		
			
			
		    //net cost equations are just the complete branch with the future placeholders substituted
			//add cost 0 for dead carrier
			result.add(String.format(netFormat, pendingCall, "", new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMBot), Strings.OpEqual)));
			
			//add reference to peak for partial carrier
			String peakCall = String.format("%s_peak(%s)", pendingCall, argumentList);
			//result.add(String.format(netFormat, pendingCall, peakCall, new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMPart), Strings.OpEqual)));
			
			Exp carrierTopCondition = new ExpBinary(new ExpVariable(btMethod.getCarrierId()), new ExpValue(Strings.VMTop), Strings.OpEqual);
			Exp netCondition = currentCondition != null ? new ExpBinary(currentCondition, carrierTopCondition, Strings.OpAnd)
			   : carrierTopCondition;
			result.add(String.format(netFormat, pendingCall, lastChain, netCondition));
			
			
			//If the method has dependencies that has not yet translated then put them in the pending translation list
			for(String call:dependencies){
				String methodName = call.replaceAll("_peak\\(.+?\\)", "");
				if(!pendingCalls.containsKey(methodName))
					pendingCalls.put(methodName, true);
			}
			
			//add separation
			result.add("");		
			
		}
		
		
		

		return result;
		
	}



	private DeltaSubstitution getDelta(String pendingCall) {
		String[] parts = pendingCall.split("_");
		BTMethod btMethod = methods.get(parts[0]);
		
		int[] eq = new int[btMethod.getArguments().size()];
		for(int i = 0; i<eq.length; i++){
			eq[i] = Integer.parseInt(parts[i+1]);
		}
		
		return new DeltaSubstitution(btMethod.getArguments(), eq);
	}



	private BTMethod getBTMethod(String pendingCall) {
		String[] parts = pendingCall.split("_");
		return methods.get(parts[0]);
	}



	//checks for a entry in pending calls with true value
	private String getPendingCall() {
		for(Entry<String, Boolean> entry:pendingCalls.entrySet()){
			if(entry.getValue()) return entry.getKey();
		}
		
		return null;
	}



	private List<String> translateMain(EnvTranslation env) {
		
		List<String> result = new LinkedList<String>();
		
		
		//get the list of cost sequences and produce the translations for the method
		
		env.vmValues.put(Strings.CurrentVM, new ValVmExt(new LinkedList<String>(), Strings.VMTop));
		List<CostSequence> costs = mainMethod.translate(DeltaIdentity.identity(), env, Strings.VMTop, CostSequence.empty());
		
		//Each cost sequence represents an execution branch
		for(CostSequence seq:costs){
			int pos = 0;
			//Create the environment for the sequence
			//this environment allows us to record the dependencies of main method
			HashSet<String> dependencies = new HashSet<String>();
			
			Exp currentCondition = seq.getCondition();
			//NO need to do this, carrier is always alive in Main
			//Exp carrierCondition = new ExpBinary(new ExpVariable(Strings.VMMain), new ExpValue(Strings.VMTop), Strings.OpEqual);
			//Exp newCondition = currentCondition != null ? new ExpBinary(currentCondition, carrierCondition, Strings.OpAnd)
			//												   : carrierCondition;
			
			//String lastChain = "";
			//peak costs are all possible subsequences starting at position 0
			int size = seq.getCostElements().size();
			for(int i = 0; i<size; i++){
				//save call costs
				//HashMap<String, String> actValues = new HashMap<String, String>();
				HashSet<String> completedFutures = new HashSet<String>();
				
				//build cost chain from backward, because of gets
				String costChain = "";
				for(int j=size -i -1; j >= 0; j--){
					
					//take the current cost
					CostElement currentCost = seq.getCostElements().get(j);
					
					//if it is a get, update the call cost with the net cost (which is the one after the # in the cost element)
					if(currentCost instanceof CostSync){
						completedFutures.add(((CostSync)currentCost).futureId);
						dependencies.add(((CostSync)currentCost).actualCall.getMethodId());
						currentCost = null;
					}
					
					//if it is a future creation then set its cost to the correct cost
					else if(currentCost instanceof CostFuture){
						String futureId = ((CostFuture)currentCost).futureId;
						
						if(completedFutures.contains(futureId)){ //if I have already found the get then use netCost
							currentCost = seq.getNetCost(futureId);
						}else{ //use peakCost otherwise
							currentCost = seq.getPeakCost(futureId);
						}
						
					}
										
					//if the current value is not null (this is that it is not a get) then include it in the chain
					if(currentCost != null){
						costChain = currentCost + (costChain.length() == 0? "":"," + costChain);
						if(j == 0){//if we took all elements then write the equation							
							//result.add(pos, String.format(peakFormat, pendingCall, costChain, newCondition));
							result.add(pos, String.format("main("+ Strings.VMMain +")=%s\t[%s]", costChain, currentCondition == null?"":currentCondition));
							
						}
					}
				}	
				
				
//				//save call costs
//				HashMap<String, String> actValues = new HashMap<String, String>();
//				
//				//build cost chain from backward, because of gets
//				String costChain = "";
//				for(int j=size -i -1; j >= 0; j--){
//					
//					//take the current cost
//					String currentCost = seq.getCostElements().get(j);
//					
//				
//					//if it is a get, update the call cost with the net cost (which is the one after the # in the cost element)
//					if(currentCost.contains("#")){//this is a get, then update the current environment
//						String[] parts = currentCost.split("#");
//						actValues.put(parts[0], parts[2]);
//						completedCalls.put(parts[0], parts[1]);
//						currentCost = null; //get doesn't have a cost
//					}
//					
//					//if it is a future creation then set its cost to the peak cost
//					else if(!actValues.containsKey(currentCost) && completedCalls.containsKey(currentCost)){
//						actValues.put(currentCost, completedCalls.get(currentCost));
//					}
//					
//					//if the element is a future substitute it by its cost
//					if(actValues.containsKey(currentCost))
//						currentCost = actValues.get(currentCost);
//					
//					//if the current value is not null (this is that it is not a get) then include it in the chain
//					if(currentCost != null){
//						costChain = currentCost + (costChain.length() == 0? "":"," + costChain);
//						if(j == 0){//if we took all elements then write the equation
//							
//							result.add(pos, String.format("main("+ Strings.VMMain +")=%s\t[%s]", costChain, newCondition));
//						}
//					}
//				}				
			
				//FOR MAIN METHOD WE DONT CARE ABOUT NET COST
			    //net cost equations are just the complete branch with the future placeholders substituted
				//result.add(String.format("main_net({0})={1}\t{2}", Strings.VMMain, lastChain, "[]"));
			}
			
			//If the method has dependencies that has not yet translated then put them in the pending translation list
			for(String calls:dependencies){
				String methodName = calls.replaceAll("_peak\\(.+?\\)", "");
				if(!pendingCalls.containsKey(methodName))
					pendingCalls.put(methodName, true);
			}
		}
		
		
		

		return result;
	}



	@Override
	public List<CostSequence> translate(DeltaSubstitution delta,
			EnvTranslation env, String carrierValue, CostSequence cost) {
		// shouldn't be called
		return null;
	}

	@Override
	public String toString() {
		String s = "";
		for(BTMethod m:methods.values())
			s+= m.toString() + "\n";
		
		s+= mainMethod.toString();
		
		return s;
		
			
	}

}
