/**
 * 
 */
package eu.emi.emir.ui.data;

/**
 * @author a.memon
 *
 */
public class AttributeItem extends Item{

	private Long count;
	private String name;
	private Group group;
	
	public AttributeItem(Group item, String name, Long count) {
		super(name);
		this.name = name;
		this.count = count;
		this.group = item;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the underlying group
	 */
	public Group getGroup() {
		return group;
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.web.data.Item#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;		
	}
	
	public String getQueryLink(){
		//TODO: emir url
		return "http://emir/services?"+group.getEndpointAttributeName()+"="+name;
	}	
	
}
