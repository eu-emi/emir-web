/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

/**
 * @author a.memon
 *
 */
public class FacetTree extends Tree{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public FacetTree() {
		HierarchicalContainer container = new HierarchicalContainer();
		container.addItem("Capabilities");
		container.addItem("Types");
		container.addItem("Domains");
		setContainerDataSource(container);
	}
	

}
