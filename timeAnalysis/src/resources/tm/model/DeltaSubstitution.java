package resources.tm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Abel
 *
 */
public class DeltaSubstitution {

	//this field represents the equivalence relation associating to each element the first element of the class as representative
	HashMap<String, String> substitution = new HashMap<String, String>();
	int[] equivalence;
	
	protected DeltaSubstitution(){}
	
	public DeltaSubstitution(List<String> elements, int[] equivalence){
		this.equivalence = equivalence;
		for(int i = 0; i < equivalence.length; i++){
			substitution.put(elements.get(i), elements.get(equivalence[i]));
		}
	}
	
	
	/* PUBLIC METHODS */
	
	/**
	 * @param releases: The list of elements to reduce
	 * @return: A list without repetitions of the representatives of the equivalence classes to which the original element corresponded
	 */
	public List<String> applyAndReduce(List<String> elements) {
		
		HashSet<String> uniques = new HashSet<String>();
		LinkedList<String> orderPreserved = new LinkedList<String>();
		
		String temp;
		for(String s:elements)
			if(substitution.containsKey(s)){
				if(uniques.add(temp = substitution.get(s)))
					orderPreserved.add(temp);
			}
		
		return orderPreserved;
		
	} 
	
	
	
	
	public String getRepresentative(String id){
		return substitution.containsKey(id)? substitution.get(id):id;
	}
	
	
	
		
//	/**
//	 * It performs an in-place substitution of the element of the list replacing
//	 * each with the representative of its class of equivalence
//	 * @param actualParameters: The list to which the substitution is applied
//	 */
//	public void apply(List<String> actualParameters) {
//		
//		//mark already substituted elements
//		boolean [] flags = new boolean[equivalenceClass.length];
//		
//		for(int i = 0; i < equivalenceClass.length; i++){
//			if(!flags[i]){//if the element has not been substituted then it is the first of its kind
//				String current = actualParameters.get(i);//the first of the class is the representative of the class
//				for(int j = i+1; j < equivalenceClass.length; j++){
//					if(equivalenceClass[i] == equivalenceClass[j]){//if the elements are in the same class, then 
//						actualParameters.set(j, current);//substitute it by its class representative
//						flags[j] = true;//update flags
//					}
//				}
//			}
//		}
//		
//		//this method can be done in a bit more efficient way, but lets just assume that method parameters wont be more than a few
//		
//	}

}
