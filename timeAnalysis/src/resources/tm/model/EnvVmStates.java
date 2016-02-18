/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import resources.util.Strings;

/**
 * @author Abel
 * Represents the states of the VM involved in a particular behavior
 */
public class EnvVmStates {
	
	HashMap<String,ValVmExt> vmValues;
	
	public EnvVmStates(){
		vmValues = new HashMap<String, ValVmExt>();
	}
	
	/* PUBLIC METHODS */
	
	
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
	public EnvVmStates merge(DeltaSubstitution substitution){
		
		EnvVmStates result = new EnvVmStates();
		
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
			
			result.addVmState(key, new ValVmExt(newF, newValue, newHasDa));
		}
		
		return result;
	}

}
