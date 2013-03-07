/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import java.util.HashMap;
import java.util.Map;

import eu.emi.emir.client.FacetKeyType;
import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.ui.data.AbstractAttributeMap;

/**
 * @author a.memon
 *
 */
public class FacetAttributeMap extends AbstractAttributeMap{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FacetAttributeMap() {
		//TODO: publish it from the properties file
		Map<String, String> m = new HashMap<String, String>();
		m.put(ServiceBasicAttributeNames.SERVICE_ENDPOINT_CAPABILITY.toString(), FacetKeyType.ARRAY);
		m.put(ServiceBasicAttributeNames.SERVICE_TYPE.toString(), FacetKeyType.SIMPLE);
		setAttributeMap(m);
		setAttributeMapType(FacetAttributeMapType.FACET.getName());
	}
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AbstractAttributeMap#setAttributeMap(java.util.Map)
	 */
	@Override
	public void setAttributeMap(Map<String, String> m) {
		this.map = m;
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AbstractAttributeMap#setAttributeMapType(java.lang.String)
	 */
	@Override
	public void setAttributeMapType(String type) {
		this.type = type; 		
	}

	

	

}
