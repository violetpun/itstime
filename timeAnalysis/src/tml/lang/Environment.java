package tml.lang;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Environment {

	HashMap<String, String> localVars = new HashMap<String, String>();
	HashMap<String, List<String>> methods = new HashMap<String, List<String>>();
	
	Stack<String> scopes = new Stack<String>();
	
	public Environment() {
		// TODO Auto-generated constructor stub
	}

	public void putLocal(String id, String type) {
		localVars.put(id, type);
		scopes.push(id);
	}

	public boolean containsLocal(String id) {
		return localVars.containsKey(id);
	}

	public void putMethod(String name, List<String> argumentTypes) {
		
		methods.put(name, argumentTypes);
				
	}
	
	public void openScope(){
		scopes.push("$");
	}
	
	public void closeScope(){
		String s;
		while(!(s=scopes.pop()).equals("$")){
			localVars.remove(s);
		}
	}

}
