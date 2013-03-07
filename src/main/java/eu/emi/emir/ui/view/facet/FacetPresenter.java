/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;

import com.google.inject.Inject;

import eu.emi.emir.ui.data.AttributeMap;
import eu.emi.emir.ui.service.FacetService;

/**
 * @author a.memon
 * 
 */
public class FacetPresenter {
	
	
	private FacetService facetService;
	
	/**
	 * 
	 */
	public FacetPresenter() {
	}
	
	public JSONArray getFacets(){
		AttributeMap map = AttributeMap.Factory.newInstance(FacetAttributeMapType.FACET);
		Set<String> set = new HashSet<String>();
		set.addAll(map.getValues());
		return this.getFacets(set);
	}

	public JSONArray getFacets(Set<String> set){
		AttributeMap map = AttributeMap.Factory.newInstance(FacetAttributeMapType.FACET);
		return facetService.getFacets(map.getAttributeMap());
	}
	
	@Inject
	public void setFacetService(FacetService fs){
		this.facetService = fs;
	}
	
	public FacetService getFacetService(){
		return facetService;
	}
	
}
