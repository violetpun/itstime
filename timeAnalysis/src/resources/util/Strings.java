/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.util;

import java.util.List;

/**
 * @author Abel
 * This class contains literal resources used along the project
 */
public class Strings {
	
	public final static String OpAnd = "&&";
	public final static String OpOr = "||";
	public static final String OpDistinct = "<>";	
	public static final String OpEqual = "==";
	public static final String OpLt = "<";
	public static final String OpMult = "*";
	public static final String OpPlus = "+";
	public static final String OpLeq = "<=";
	public static final String OpGt = ">";
	public static final String OpGeq = ">=";
	
	public final static String ReleaseHelper = "crel";
	public final static String AcquireHelper = "cnew";
	
	public static final String VMTop = "TOP";
	public static final String VMBot = "BOT";
	public static final String VMPart = "PART";
	public static final String VMMain = "MAINVM";
	public static final String MainCog = "MAINCOG";
	
	public static final String DownArrow = "!";
	public static final String PeakModifier = "peak";
	public static final String NetModifier = "net";
	
	public static final String TypeInt = "Int";
	public static final String TypeVM = "VM";
	public static final String TypeCog = "NewVM";			//for object in a new cog
	public static final String TypeObj = "LocalVM";			//for object in local cog
	public static final String TypeFuture = "Fut";
	public static final String MainMethodName = "$MAIN";
	public static final String CurrentVM = "THISVM";
	public static final String CurrentCog = "THISCOG";
	
	
	
	
	public static class ErrorMessage{
		
		public static final String ArgumentTypeInvalid = "Argument type not recognized: {0}";
		public static final String VariableAlreadyExists = "A variable with the same name already exists: {0}";
		public static final String VariableNotFound = "Variable not found: {0}";
		public static final String ReleaseNonVM = "Attempt to release a non-VM object:{0}";
		public static final String UnexpectedBehavior = "Unexpected behavior";
		
	}
	
	
	
//	/* HELPER METHODS */
//	/**
//	 * @param elements: A list of elements with repetitions
//	 * @return: a same size array that for each element contains the position of the first occurrence of the element in the list
//	 */
//	public static int[] getEquivalenceFromList(List<String> elements){
//		
//		int[] result = new int[elements.size()];
//		boolean[] flags = new boolean[result.length];
//		
//		for(int i = 0; i < result.length; i++){
//			if(!flags[i]){//if the element has not been substituted then it is the first of its kind
//				result[i] = i;
//				String current = elements.get(i);//grab the first occurrence
//				for(int j = i+1; j < result.length; j++){
//					if(elements.get(j).equals(current)){//if the elements are equal, then 
//						result[j] = i;//point to the position of the first occurrence
//						flags[j] = true;//update flags
//					}
//				}
//			}
//		}
//		
//		return result;
//	}
	
	
	/**
	 * Classic String.join method
	 * @param elements
	 * @param joinOn
	 * @return
	 */
	public static String join(List<?> elements, String joinOn) {
		String join = "";
		int size = elements.size();
		for(int i = 0; i < size; i++)
		{
			join += elements.get(i).toString();
			if(i < size - 1)
				join += joinOn;
		}
		return join;
	}

	//this can be done using generics, but java generics is a mess
	/**
	 * Classic String.join method for int array
	 * @param elements
	 * @param joinOn
	 * @return
	 */
	public static String join(int[] elements, String joinOn) {
		String join = "";
		int size = elements.length;
		for(int i = 0; i < size; i++)
		{
			join += elements[i];
			if(i < size - 1)
				join += joinOn;
		}
		return join;
	}
}
