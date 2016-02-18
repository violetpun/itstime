package tml.lang;

import java.util.List;

import resources.tm.model.Exp;
import resources.tm.model.ExpVariable;

public class TmlExpVar extends TmlExpBase {

	String id;
	
	public TmlExpVar(String id) {
		this.id = id;
	}

	@Override
	public String getExpressionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean getIsSizeExpression() {
		return true;
	}
	
	@Override
	public Exp toBehavioralExp() {
		return new ExpVariable(id);
	}

	@Override
	public TmlExpBase getOpposite() {
		return null;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}
}
