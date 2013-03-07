/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import java.util.LinkedHashMap;
import java.util.Map;

import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.ui.data.AbstractAttributeMap;

/**
 * @author a.memon
 *
 */
public class ListingAttributeMap extends AbstractAttributeMap{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ListingAttributeMap() {
		Map<String, String> m = new LinkedHashMap<String, String>(); //only to preserve the insertion ordering
		m.put(ServiceBasicAttributeNames.SERVICE_NAME.toString(), "Name");
		m.put(ServiceBasicAttributeNames.SERVICE_TYPE.toString(), "Type");
		m.put(ServiceBasicAttributeNames.SERVICE_ENDPOINT_URL.toString(), "URL");
		m.put(ServiceBasicAttributeNames.SERVICE_EXPIRE_ON.toString(), "Expire On");
		setAttributeMap(m);
		setAttributeMapType(ListingMapType.LISTING.getName());
	}
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AbstractAttributeMap#setAttributeMap(java.util.Map)
	 */
	@Override
	public void setAttributeMap(Map<String, String> m) {
		this.map = m;		
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AbstractAttributeMap#setAttributeMapType(eu.emi.emir.ui.data.AttributeMapType)
	 */
	@Override
	public void setAttributeMapType(String type) {
		this.type = type;		
	}

	

}
