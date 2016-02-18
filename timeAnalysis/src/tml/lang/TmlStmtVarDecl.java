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
public class TmlStmtVarDecl extends TmlStatement {

	String type;
	String id;
	
	/**
	 * 
	 */
	

	public TmlStmtVarDecl(String type, String id) {
		this.type = type; this.id = id;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		//if it is a future take the type of the future, take the type directly otherwise
		//TODO: use types object instead of Strings
		String innerType = type.startsWith(Strings.TypeFuture)?type.substring(type.indexOf('<') + 1, type.indexOf('>')).trim():type;
		
		if(!innerType.equals(Strings.TypeInt) && !type.equals(Strings.TypeVM))
			errors.add(String.format(Strings.ErrorMessage.ArgumentTypeInvalid, type));
		
		if(e.containsLocal(id))
			errors.add(String.format(Strings.ErrorMessage.VariableAlreadyExists, id));
		
		e.putLocal(id, type);
	}

}
