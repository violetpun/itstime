package tml.lang;

import java.util.List;

import resources.tm.model.Exp;
import resources.util.Strings;

public class TmlExpThisCapacity extends TmlExpBase {

	public TmlExpThisCapacity() {
		// TODO Auto-generated constructor stub
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
	public Exp toBehavioralExp() {
		// TODO should never be called
		return null;
	}

	@Override
	public TmlExpBase getOpposite() {
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Strings.thisCap;
	}

}
