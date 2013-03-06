/**
 * 
 */
package eu.emi.emir.ui.service;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;

import eu.emi.emir.ui.data.Endpoint;

/**
 * @author a.memon
 *
 */
public interface EndpointListingService {
	public JSONArray getEndpoints();
}
