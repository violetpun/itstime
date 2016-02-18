/**
 * Resource analisys for VML contracts V 1.0
 * Developed by Abel Garcia
 * 2015
 */
package resources.tm.model;

import java.util.LinkedList;
import java.util.List;

import resources.util.Strings;

/**
 * @author Abel
 * Represent the (extend) possible VM states
 */
public class ValVmExt {
	
	List<String> f;
	String vmValue;
	
	boolean hasDownArrow;

	
	/**
	 * @param f: The list of future names that represent invocations that currently release the VM with this state
	 * @param vmValue: The value of the VM, one of the special values ("TOP", "PART", "BOT") or a reference Id  
	 */
	public ValVmExt(List<String> f, String vmValue) {
		this(f, vmValue, false);
	}
	
	public ValVmExt(String vmValue) {
		this(new LinkedList<String>(), vmValue, false);
	}
	
	protected ValVmExt(List<String> f, String vmValue,  boolean hasDownArrow) {
		super();
		this.f = f;
		this.vmValue = vmValue;
		this.hasDownArrow = hasDownArrow;
	}

	/* ACCESSORS */
	public List<String> getF() {
		return f;
	}

	public String getVmValue() {
		return vmValue;
	}
	
	public Boolean getIsVariable() {
		String v = vmValue.trim();
		
		return !v.equals(Strings.VMBot) && !v.equals(Strings.VMPart) && !v.equals(Strings.VMTop);
	}
	
	public boolean getHasDownArrow(){
		return hasDownArrow;
	}
	
	/* PUBLIC METHODS */
	
	public ValVmExt applyDownArrow(){
		boolean newDownArrow = false;
		if(f == null || f.size() == 0 || hasDownArrow)
			return this;
		else{
			String newValue;
			switch(vmValue){
				case Strings.VMTop:
				case Strings.VMPart:
					newValue = Strings.VMPart;
					break;
				case Strings.VMBot:
					newValue = Strings.VMBot;
					break;
				default:
					newDownArrow = true;
					newValue = vmValue;
			}

			return new ValVmExt(null, newValue, newDownArrow);
		}
	}
	 
	
	@Override
	public String toString() {
		if(f == null || f.size() == 0)
			return vmValue;// + (hasDownArrow?"!":"");
		return String.format("{%s}%s", Strings.join(f, ", "), vmValue);
	}
}
