/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import java.util.Map;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.Event;

/**
 * @author a.memon
 *
 */
public class ListingViewEvent implements Event{
	
	public static final String QUERY = "query";
	
	private Map<String, String> map;
	
	private final URIQuery q;
	
	/**
	 * 
	 */
	public ListingViewEvent(URIQuery q) {
		this.q = q;
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
	
	public URIQuery getQuery(){
		return this.q;
	}
	
	@Subscribe
	public void handleListingViewEvent(ListingViewEvent e){
		
	}
	
	
	
}
