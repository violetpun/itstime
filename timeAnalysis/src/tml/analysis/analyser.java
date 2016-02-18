package tml.analysis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import resources.tm.model.BTProgram;
//import resources.tm.translation.EquationTransformer;
import tml.lang.TmlProgram;
import tml.lang.TmlVisitorImpl;
import tml.parser.tmlLexer;
import tml.parser.tmlParser;

public class analyser {

	public analyser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		//String inputFile = null;
		PrintStream bt_out, ec_out;
		InputStream is = args.length>0?new FileInputStream(args[0]):System.in;
		ec_out = bt_out = args.length>1?new PrintStream(args[1]):System.out;
		ec_out = args.length>2?new PrintStream(args[2]):ec_out;
		
		
		ANTLRInputStream input = new ANTLRInputStream(is);
		tmlLexer lexer = new tmlLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tmlParser parser = new tmlParser(tokens);
		parser.setBuildParseTree(true);
		
		TmlVisitorImpl visitor = new TmlVisitorImpl();
		
		TmlProgram p = (TmlProgram) visitor.visitProgram(parser.program());
		
/*		
 * 		check semantics is supposed to be here
 */
		
		try {
			BTProgram bt = (BTProgram)p.inferBehavior();
			
			bt_out.println("/**********************Behavioral types**********************/");
			bt_out.println();
			
			bt_out.println(bt.toString());
			
			bt_out.println();
			bt_out.println("/*****************End of Behavioral types********************/");
			
			
			
//			List<String> result = bt.translate();
//			
//			result = EquationTransformer.toCoFloCoFormat(result);
//			
//			ec_out.println("%**********************Cost Equations**********************%");
//			ec_out.println();
//			for(String line:result)
//				ec_out.println(line); // print result
//			
//			ec_out.println();
//			ec_out.println("%**********************Cost Equations**********************%");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		BTProgram p = parser.program().p; // parse; start at methodContract
//		
//		List<String> result = p.translate();
//		
//		result = EquationTransformer.toCoFloCoFormat(result);
//		
//		for(String line:result)
//			System.out.println(line); // print result

	}

}
