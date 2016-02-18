package tml.lang;

import java.util.List;

import resources.tm.model.BTChoice;
import resources.tm.model.BTConditional;
import resources.tm.model.BType;

public class TmlStmtIf extends TmlStatement {

	TmlExpBase condition;
	TmlStmtSeq thenBranch;
	TmlStmtSeq elseBranch;
	
	public TmlStmtIf() {
		// TODO Auto-generated constructor stub
	}

	public TmlStmtIf(TmlExpBase cond, List<TmlStatement> stmtsThen,
			List<TmlStatement> stmtsElse) {

		this.condition = cond;
		this.thenBranch = new TmlStmtSeq(stmtsThen);
		this.elseBranch = new TmlStmtSeq(stmtsElse);
	}

	@Override
	public void checkSemantics(Environment e, List<String> errors) {
		
		condition.checkSemantics(e, errors);
		//TODO check condition type
		
		thenBranch.checkSemantics(e, errors);
		elseBranch.checkSemantics(e, errors);
		
//		e.openScope();
//		for(TmlStatement stmt : thenBranch)
//			stmt.checkSemantics(e, errors);
//		e.closeScope();
//		e.openScope();
//		for(TmlStatement stmt : elseBranch)
//			stmt.checkSemantics(e, errors);
//		e.closeScope();
		
	}

	@Override
	public BType inferBehavior() throws Exception {
		
		BType thenType;
		BType elseType;
		
		if(condition.getIsSizeExpression()){
			thenType = new BTConditional(condition.toBehavioralExp(), thenBranch.inferBehavior());
			elseType = new BTConditional(condition.getOpposite().toBehavioralExp(), elseBranch.inferBehavior());
		}else{
			thenType = thenBranch.inferBehavior();
			elseType = elseBranch.inferBehavior();
		}
		
		return new BTChoice(thenType, elseType);
		
	}

}
