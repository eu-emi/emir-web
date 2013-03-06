/**
 * 
 */
package eu.emi.emir.ui.service;

import java.util.Set;

import org.codehaus.jettison.json.JSONArray;


/**
 * The place holder for summarization data from emir
 * 
 * @author a.memon
 *
 */
public interface FacetService {
	public JSONArray getFacets(Set<String> facets);	
}
