/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import resources.util.Strings;


/**
 * @author Abel
 * Represents a cost sequence obtained under certain conditions
 */
/**
 * @author Abel
 *
 */
public class CostSequence {
	
	List<CostElement> costElements;
	Exp condition;
	HashMap<String, CostSync> futuresMap;
	
	public CostSequence(List<CostElement> costElements, Exp condition) {
		super();
		this.costElements = new LinkedList<CostElement>();		
		this.condition = condition;
		futuresMap = new HashMap<String, CostSync>();
		
		for(CostElement el:costElements) this.addCost(el);
	}

	/* ACCESSORS */

	public List<CostElement> getCostElements() {
		return costElements;
	}


	public Exp getCondition() {
		return condition;
	}
	
	public void setCondition(Exp newCondition) {
		condition = newCondition;
	}

	
	
	/* PUBLIC METHODS */
	public static CostSequence empty() {
		
		return new CostSequence(new ArrayList<CostElement>(), null);
	}
	
	
	
	/* 
	 * returns a first level copy of the cost sequence.
	 * modifications in the new object list wont affect original object list.
	 * List elements are shared though.
	 */
	public CostSequence clone(){
		return new CostSequence(new ArrayList<CostElement>(this.costElements), this.condition);
	}
	
	
	/**
	 * Adds a cost element to the cost sequence
	 * @param cost: A descendant of @class CostElement representing the cost item to add to the sequence 
	 */
	public void addCost(CostElement cost){
		this.costElements.add(cost);
		
		if(cost instanceof CostFuture){ //know about the existence of this future
			futuresMap.put(((CostFuture)cost).futureId, null);
		}else if(cost instanceof CostSync){ //grab the sync of future
			futuresMap.put(((CostSync)cost).futureId, (CostSync)cost);			
		}
	}

	public CostElement getNetCost(String futureId) {
		if(futuresMap.containsKey(futureId)){
			CostSync c = futuresMap.get(futureId);
			if(c == null) //the future exists but it has not sync
				return new CostZero();
			else{ //we need to get the method call plus the adjustments
				ValMethodCall call = new ValMethodCall(c.actualCall.getMethodId() + "_" + Strings.NetModifier, c.actualCall.getActualParameters());
				return new CostInvoc(call, c.adjustments);
			}
		}
		
		//SHOULD NOT HAPPEN
		return null;
	}

	public CostElement getPeakCost(String futureId) {
		
		if(futuresMap.containsKey(futureId)){
			CostSync c = futuresMap.get(futureId);
			if(c == null) //the future exists but it has not sync
				return new CostZero();
			else{ //we need to get the method call plus the adjustments
				ValMethodCall call = new ValMethodCall(c.actualCall.getMethodId() + "_" + Strings.PeakModifier, c.actualCall.getActualParameters());
				return new CostInvoc(call, null);
			}
		}
		
		//SHOULD NOT HAPPEN
		return null;
	}
}
