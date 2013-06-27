/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.view.address.Address;

/**
 * 
 * The presenter class knows about the data and the view too
 * @author a.memon
 *
 */
public class ListingPresenter {
	
	private EmirUI ui;
	private ListingView view;
	
//	@Inject
	private EMIRClient client;
	
	
		
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
		return getEmirClient().queryByQueryParams(q);
	}
	
	public EMIRClient getEmirClient(){
		if (client == null) {
			client = new EMIRClient(Address.get());
		}
		return client;
	}
}
