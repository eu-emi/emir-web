/**
 * 
 */
package eu.emi.emir.ui.service;

import java.util.Set;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;

/**
 * @author a.memon
 *
 */
public class EmirFacetService implements FacetService{

	@Inject
	private EMIRClient client;
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.service.FacetService#getFacets()
	 */
	@Override
	public JSONArray getFacets(Set<String> facets) {
		return client.facetSearch(facets);
	}

}
