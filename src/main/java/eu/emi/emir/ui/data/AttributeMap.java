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
		public static <T extends AttributeMap> T newInstance(
				Class<T> type) {
//			AttributeMap m = null;
			T a = null;
			try {
				a = type.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			return a;
		}

	}

	public Map<String, String> getAttributeMap();

	public String getType();

	public Collection<String> getValues();

}
