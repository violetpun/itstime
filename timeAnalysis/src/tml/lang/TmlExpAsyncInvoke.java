package tml.lang;

import java.util.List;

import resources.tm.model.BType;
import resources.tm.model.Exp;

public class TmlExpAsyncInvoke extends TmlExpBase {

	TmlExpBase receiver;
	String name;
	List<TmlExpBase> arguments;
	
	public TmlExpAsyncInvoke(String name, TmlExpBase receiver, List<TmlExpBase> arguments) {
		this.name = name;
		this.receiver = receiver;
		this.arguments = arguments;
	}

	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		//TODO implement checkSemantics
		
	}

	@Override
	public String getExpressionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BType inferBehavior() throws Exception {
		// behavior is inferred at the level of an ancestor
		return null;
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
}
