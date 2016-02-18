package resources.tm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import resources.util.Strings;

public class EnvTranslation {
	
	HashMap<String, ValFuture> futureValues;
	HashMap<String, ValMethodCall> solvedFutures;
	HashMap<String, ValVmExt> vmValues;
	HashMap<String, BTMethod> methodBehaviors;
	
	public HashMap<String, BTMethod> getMethodBehaviors() {
		return methodBehaviors;
	}


	public EnvTranslation(HashMap<String, BTMethod> methods){
		futureValues = new HashMap<String, ValFuture>();
		solvedFutures = new HashMap<String, ValMethodCall>();
		vmValues = new HashMap<String, ValVmExt>();
		
		this.methodBehaviors = methods;
	}
	
	
	/*PUBLIC METHODS*/
	
	public ValFuture getFutureValue(String futureId){
		return futureValues.get(futureId);
	}
	
	public void setFutureValue(String futureId, ValFuture value){
		futureValues.put(futureId, value);
	}
	
	public ValVmExt getVmValue(String vmId){
		return vmValues.get(vmId);
	}
	
	public void setFutureValue(String vmId, ValVmExt value){
		vmValues.put(vmId, value);
	}
	
	
	/**
	 * It binds a futureId with the invocation with actual parameter values
	 * it also removes this futureId from the dictionary of active futures
	 * @param futureId: The id of the future
	 * @param cost: The actual cost
	 */
	public void markFutureAsSolved(String futureId, ValMethodCall cost){
		
		futureValues.remove(futureId);
		solvedFutures.put(futureId, cost);
	}
	
	public Collection<ValMethodCall> getCompletedCalls(){
		return solvedFutures.values();
	}
	
	public Set<String> getCompletedFutures(){
		return solvedFutures.keySet();
	}
	
	public ValMethodCall getCompletedCall(String futureId){
		return solvedFutures.get(futureId);
	}
	
	
	@SuppressWarnings("unchecked")
	public EnvTranslation clone(){
		
		EnvTranslation clone = new EnvTranslation(methodBehaviors);
		clone.futureValues = (HashMap<String, ValFuture>)this.futureValues.clone();
		clone.solvedFutures = (HashMap<String, ValMethodCall>)this.solvedFutures.clone();
		clone.vmValues = (HashMap<String, ValVmExt>)this.vmValues.clone();
		return clone;
	}
	
	
	
	/**
	 * @param vmId: The id of the vm
	 * @param value: The state of the vm
	 */
	public void addVmState(String vmId, ValVmExt value){
		vmValues.put(vmId, value);
	}
	
	
	/**
	 * @param vmId: The id of the vm
	 * @return: The state of the vm
	 */
	public ValVmExt getVmState(String vmId){
		return vmValues.get(vmId);
	}
	
	
	/**
	 * @param substitution: The classes of equivalence in which the items in the environment can be grouped
	 * @return: Returns a newly created environment in which elements in the same class are merged to a unique representation
	 */
	public HashMap<String, ValVmExt> mergeVmValues(DeltaSubstitution substitution){
		
		HashMap<String, ValVmExt> result = new HashMap<String, ValVmExt>();
		
		for(Entry<String, ValVmExt> entry:vmValues.entrySet()){
			ValVmExt v1 = entry.getValue();
			String newValue = v1.getVmValue();
			List<String> newF = null; 
			boolean newHasDa = v1.getHasDownArrow();
			if(v1.getF() != null) newF = new ArrayList<String>(v1.getF());
			
			String key = entry.getKey();
			String rep = substitution.getRepresentative(key);
			
			//if it is not the same name, we need to merge them
			//TODO review this carefully
			if(!rep.equals(key)){				
				ValVmExt v2 = vmValues.get(rep);
				
				
				//merge v1 and v2 
				if(v1.getVmValue().equals(Strings.VMBot) || v2.getVmValue().equals(Strings.VMBot))
					newValue = Strings.VMBot;
								
				else if(v2.getIsVariable() && v1.getIsVariable()){
					newValue = v2.getVmValue();
					newHasDa = newHasDa || v2.getHasDownArrow();
				}
				
				else{
					//shouldnt happen this
					int a = 2/0;
				}
				
//				else if(v1.getVmValue().contains(Strings.DownArrow)){
//					newValue = v2.getVmValue();
//				}
//				
//				else if(v2.getVmValue().contains(Strings.DownArrow)){
//					newValue = v2.getVmValue();
//				}
				
				
				
				List<String> newF2 = null;
				if(v2.getF() != null) newF2 = new ArrayList<String>(v2.getF());
				if(newF == null)
					newF = newF2;
				
				if(newF != null && newF2 != null){
					HashSet<String> tem = new HashSet<String>(newF);
				    tem.addAll(newF2);
				    newF = new ArrayList<String>(tem);
				}
			}
			
			result.put(key, new ValVmExt(newF, newValue, newHasDa));
		}
		
		return result;
	}
}
