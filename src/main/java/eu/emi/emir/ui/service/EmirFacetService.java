/**
 * 
 */
package eu.emi.emir.ui.service;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.view.address.Address;

/**
 * @author a.memon
 *
 */
public class EmirFacetService implements FacetService{
	
	@Inject
	private EMIRClient client = new EMIRClient("http://localhost:9127");
	
	/**
	 * 
	 */
	public EmirFacetService() {
//		client = new EMIRClient(Address.get());
	}
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.service.FacetService#getFacets()
	 */
	@Override
	public JSONArray getFacets(Map<String, String> facets) {
		return client.facetSearch(facets);
	}	

}
