/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.util.Strings;

/**
 * @author Violet
 *
 */
public class TmlArgument extends TmlElementBase {

	String type;
	String id;
	
	/**
	 * 
	 */
	public TmlArgument(String type, String id) {
		this.type = type;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics()
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {

		if(!type.equals(Strings.TypeInt) && !type.equals(Strings.TypeVM))
			errors.add(String.format(Strings.ErrorMessage.ArgumentTypeInvalid, type));
		
		if(e.containsLocal(id))
			errors.add(String.format(Strings.ErrorMessage.VariableAlreadyExists, id));
		
		e.putLocal(id, type);

	}

}
