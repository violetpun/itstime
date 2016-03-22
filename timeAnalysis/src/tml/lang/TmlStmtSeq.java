/**
 * Time analysis for TML contracts 
 * Developed by Violet Pun, modifying codes from Abel Garcia
 * 2016
 */
package tml.lang;

import java.util.LinkedList;
import java.util.List;

import resources.tm.model.BTAtom;
import resources.tm.model.BTNewCog;
import resources.tm.model.BTNewLocal;
import resources.tm.model.BTSequence;
import resources.tm.model.BTSkip;
import resources.tm.model.BType;

/**
 * @author Violet
 *
 */
public class TmlStmtSeq extends TmlStatement {

	List<TmlStatement> stmts;
//	List<BTAtom> existingCogs = new LinkedList<BTAtom>() ;
	public List<TmlStatement> getStmts() {
		return stmts;
	}

	/**
	 * @param stmts 
	 * 
	 */
	public TmlStmtSeq(List<TmlStatement> stmts) {
		this.stmts = stmts;
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#checkSemantics(tml.lang.Environment, java.util.List)
	 */
	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		e.openScope();
		for(TmlStatement stmt : stmts)
			stmt.checkSemantics(e, errors);
		e.closeScope();
	}

	/* (non-Javadoc)
	 * @see tml.lang.TmlElementBase#inferBehavior()
	 */
	@Override
	public BType inferBehavior(TmlExpBase localCapacity, List<BTAtom> existingCogs) throws Exception {
		if(stmts.size() > 0) 
			return inferBehavior(stmts, localCapacity, existingCogs);
		return new BTSkip();
	}

	private BType inferBehavior(List<TmlStatement> stmts, TmlExpBase localCapacity, List<BTAtom> existingCogs) throws Exception{
		if(stmts.size() == 1){
			if (stmts.get(0).inferBehavior(localCapacity) instanceof BTNewCog)
				System.out.println(stmts.get(0).inferBehavior(localCapacity).toString());
			return stmts.get(0).inferBehavior(localCapacity, existingCogs);
		}
			
		
		//TODO add a try catch?
		BTAtom atom = (BTAtom)stmts.get(0).inferBehavior(localCapacity, existingCogs);
		if (atom instanceof BTNewCog || atom instanceof BTNewLocal)
			existingCogs.add(atom);			
		return new BTSequence(atom, inferBehavior(stmts.subList(1, stmts.size()), localCapacity, existingCogs));
	}
}
