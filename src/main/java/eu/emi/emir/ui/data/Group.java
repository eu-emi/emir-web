/**
 * 
 */
package eu.emi.emir.ui.data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author a.memon
 *
 */
public class Group extends Item{

	private List<AttributeItem> setAttrItem = null;
	
	private final String emirEndPtAttrName;
	
	public Group(String groupName, String emirEndptAttrName) {
		super(groupName);
		setAttrItem = new CopyOnWriteArrayList<AttributeItem>();
		this.emirEndPtAttrName = emirEndptAttrName; 
	}
	
	public void addItem(AttributeItem item){
		setAttrItem.add(item);		
	}
	
	public void removeItem(AttributeItem item){
		setAttrItem.remove(item);		
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.web.data.Item#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
		
	}
	
	public String getEndpointAttributeName(){
		return emirEndPtAttrName;
	}
	
	public List<AttributeItem> getAttributeItems(){
		return setAttrItem;				
	} 
	
}
