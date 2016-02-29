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
public class BTJob extends BTAtom {

	Exp jobExp;
	Exp capacity;
	
	/**
	 * @param jobExp: Number of processing cycles needed
	 * @param capacity: the capacity of the local cog
	 */
	public BTJob(Exp jobExp, Exp capcity) {
		this.jobExp = jobExp;		
		this.capacity = capcity;
	}

	
	/* (non-Javadoc)
	 * VP: Copy from the other file
	 */
//	VP: comment out for the translation at the moment
	@Override
	public List<CostSequence> translate(DeltaSubstitution delta, EnvTranslation env, String carrierValue, CostSequence cost) {
		
		LinkedList<CostSequence> result = new LinkedList<CostSequence>();

		return result;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.jobExp + "/" + this.capacity + ";\n";
	}

}
