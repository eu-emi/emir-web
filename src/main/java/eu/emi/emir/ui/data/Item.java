/**
 * 
 */
package eu.emi.emir.ui.data;

/**
 * @author a.memon
 *
 */
public abstract class Item {
	private final String name;
	protected String type;
	/**
	 * 
	 */
	public Item(String name) {
		this.name = name;		
	}
	
	public abstract void setType(String type);
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
}
