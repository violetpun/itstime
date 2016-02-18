/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.List;

import resources.tm.model.BTSync;
import resources.tm.model.BType;
import resources.tm.model.Exp;

/**
 * @author Violet
 *
 */
public class TmlExpSync extends TmlExpBase {

	TmlExpBase exp;
	
	/**
	 * 
	 */
	public TmlExpSync(TmlExpBase exp) {
       this.exp = exp;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlExpBase#getExpressionType()
	 */
	@Override
	public String getExpressionType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		exp.checkSemantics(e, errors);
		
		// TODO check type

	}
	
	@Override
	public BType inferBehavior() throws Exception {
		
		//TODO assume sync is always performed over variables, so no f!a().get for the moment
		TmlExpVar var = (TmlExpVar)exp;
		
		return new BTSync(var.id);
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
