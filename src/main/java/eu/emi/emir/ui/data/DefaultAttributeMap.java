/**
 * 
 */
package eu.emi.emir.ui.data;

import java.util.HashMap;
import java.util.Map;

import eu.emi.emir.client.ServiceBasicAttributeNames;

/**
 * @author a.memon
 *
 */
public class DefaultAttributeMap extends AbstractAttributeMap {

	/**
	 * 
	 */
	public DefaultAttributeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(ServiceBasicAttributeNames.SERVICE_ENDPOINT_CAPABILITY.toString(), "Capability");
		setAttributeMap(map);
		setAttributeMapType(AttributeMapType.DEFAULT);
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
