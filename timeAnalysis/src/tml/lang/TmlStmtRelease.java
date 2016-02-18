package tml.lang;

import java.util.List;

import resources.tm.model.BTRelease;
import resources.tm.model.BType;
import resources.util.Strings;

public class TmlStmtRelease extends TmlStatement{

	String id;
	
	public TmlStmtRelease(String id) {
		this.id = id;
	}

	

	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		if(!e.containsLocal(id))
			errors.add(String.format(Strings.ErrorMessage.VariableNotFound, id));
		
		else{
		
			String type = e.localVars.get(id);
			if(!type.equals(Strings.TypeVM))
				errors.add(String.format(Strings.ErrorMessage.ReleaseNonVM, id));
		}
		
	}



	@Override
	public BType inferBehavior() throws Exception {
		return new BTRelease(id);
	}

}
