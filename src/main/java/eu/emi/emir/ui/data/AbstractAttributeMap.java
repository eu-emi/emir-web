/**
 * 
 */
package eu.emi.emir.ui.data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Abstract class to map service endpoint attribute names to data
 * 
 * @author a.memon
 *
 */
public abstract class AbstractAttributeMap implements AttributeMap{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, String> map;
	protected String type;
	protected List<String> list;
	
	public Map<String, String> getAttributeMap(){
		if (map.isEmpty()) {
			return null;
		}
		return Collections.unmodifiableMap(map);
	}
	
	public String getType(){
		return type;
	}
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AttributeMap#getValues()
	 */
	@Override
	public Collection<String> getValues() {
		return Collections.unmodifiableCollection(map.values());
	}
	
	public abstract void setAttributeMap(Map<String, String> m);

	public abstract void setAttributeMapType(String type);
	
	
}
