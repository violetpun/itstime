/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.List;

/**
 * @author Abel
 * Represents a sequence formed by an Atom and the Behavioral Type of the continuation
 */
public class BTSequence extends BType {

	BTAtom atom;
	BType continuation;
	
	
	/**
	 * @param atom: It represents a behavioral unit
	 * @param continuation: The behavior of the continuation
	 */
	public BTSequence(BTAtom atom, BType continuation) {
		super();
		this.atom = atom;
		this.continuation = continuation;
	}

	/* ACCESSORS */
	
	public BTAtom getAtom() {
		return atom;
	}

	public BType getContinuation() {
		return continuation;
	}
	
	/* PUBLIC METHODS */
	
	/* (non-Javadoc)
	 * @see resources.vm.model.BType#Translate(resources.vm.model.DeltaSubstitution, resources.vm.model.TranslationEnvironment, java.util.List)
	 */
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost){
		
		//get cost for the atom. A List with with 1 cost sequence is expected  
		List<CostSequence> atomResult = atom.translate(delta, env, carrierValue, cost);
		
		//translate the continuation
		return continuation.translate(delta, env, carrierValue, atomResult.get(0));
	}
	
	@Override
	public String toString(){
		return atom.toString() + continuation.toString();  
	}

	
}
