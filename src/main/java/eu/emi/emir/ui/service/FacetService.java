/**
 * 
 */
package eu.emi.emir.ui.service;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;


/**
 * The place holder for summarization data from emir
 * 
 * @author a.memon
 *
 */
public interface FacetService {
	public JSONArray getFacets(Map<String, String> facets);	
}
