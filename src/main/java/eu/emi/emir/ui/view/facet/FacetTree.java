/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import org.codehaus.jettison.json.JSONArray;
import com.vaadin.ui.Tree;
import eu.emi.emir.ui.vaadin.container.JSONArrayHierarchichalContainer;

/**
 * @author a.memon
 *
 */
public class FacetTree extends Tree{

	private static final long serialVersionUID = 1L;
	
	JSONArrayHierarchichalContainer container;

	public FacetTree(JSONArray ja) {
		container = new JSONArrayHierarchichalContainer(ja);
		setContainerDataSource(container);
		setItemCaptionPropertyId(container.PROPERTY_NAME);
        setItemCaptionMode(ItemCaptionMode.PROPERTY);
        for (Object id : rootItemIds()) {
            expandItemsRecursively(id);
        }

	}

	/**
	 * @param facets
	 */
	public void showFacets(JSONArray facets) {
		setContainerDataSource(new JSONArrayHierarchichalContainer(facets));
		
	}
	
	

}
