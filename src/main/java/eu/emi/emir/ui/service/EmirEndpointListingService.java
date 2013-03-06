/**
 * 
 */
package eu.emi.emir.ui.service;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;

/**
 * @author a.memon
 *
 */
public class EmirEndpointListingService implements EndpointListingService{
	@Inject
	private EMIRClient client;
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.service.EndpointListingService#getEndpoints()
	 */
	@Override
	public JSONArray getEndpoints() {
		
		return null;
	}

}
