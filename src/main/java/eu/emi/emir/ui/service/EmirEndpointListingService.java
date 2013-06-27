/**
 * 
 */
package eu.emi.emir.ui.service;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.view.address.Address;

/**
 * @author a.memon
 *
 */
public class EmirEndpointListingService implements EndpointListingService{
//	@Inject
	private EMIRClient client;
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.service.EndpointListingService#getEndpoints()
	 */
	@Override
	public JSONArray getEndpoints(URIQuery query) {
		client = new EMIRClient(Address.get());		
		return client.queryByQueryParams(query);
	}

}
