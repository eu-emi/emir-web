/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import org.codehaus.jettison.json.JSONArray;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.EmirUI;

/**
 * 
 * The presenter class knows about the data and the view too
 * @author a.memon
 *
 */
public class ListingPresenter {
	
	EmirUI ui;
	ListingView view;
	
	@Inject
	EMIRClient client;
	
	
		
	/**
	 * @param listingView
	 */
	public ListingPresenter() {
		ui = EmirUI.getCurrent();		
		
	}

	public void setView(ListingView listingView){
		this.view = listingView;
	}

	public JSONArray getListing(URIQuery q){
		return client.queryByQueryParams(q);
	}
}
