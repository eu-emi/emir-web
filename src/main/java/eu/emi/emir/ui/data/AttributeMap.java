/**
 * 
 */
package eu.emi.emir.ui.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * @author a.memon
 * 
 */
public interface AttributeMap extends Serializable{

	public static class Factory {
		public static <T extends AttributeMap> AttributeMap newInstance(
				String type) {
			AttributeMap m = null;
			try {
				m = (AttributeMap) Class.forName(type).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return m;
		}

	}

	public Map<String, String> getAttributeMap();

	public String getType();

	public Collection<String> getValues();

}
