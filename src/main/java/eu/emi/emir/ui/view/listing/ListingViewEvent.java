/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import java.util.Map;

import eu.emi.emir.ui.Event;

/**
 * @author a.memon
 *
 */
public class ListingViewEvent implements Event{
	
	public static final String QUERY = "query";
	
	private Map<String, String> map;
	
	/**
	 * 
	 */
	public ListingViewEvent() {
		
	}
	
	public ListingViewEvent(Map<String, String> params) {
		this.map = params;
	}
	
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.base.Event#setParameters(java.util.Map)
	 */
	@Override
	public void setParameters(Map<String, String> params) {
		this.map = params;
		
	}

	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.base.Event#getParameters()
	 */
	@Override
	public Map<String, String> getParameters() {
		return map;
	}
	
	
}
