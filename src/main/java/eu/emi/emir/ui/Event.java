/**
 * 
 */
package eu.emi.emir.ui;

import java.util.Map;

/**
 * @author a.memon
 *
 */
public interface Event {
	public void setParameters(Map<String, String> params);
	
	/**
	 * @return the map containing event specific parameters
	 * */
	public Map<String, String> getParameters();
}
