/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

/**
 * @author a.memon
 * 
 */
public class FacetPresenter {
	@Inject
	EventBus bus;
	
	/**
	 * 
	 */
	public FacetPresenter() {
		bus.register(this);
	}	
	
}
