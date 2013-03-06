/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.eventbus.EventBus;
import com.google.inject.name.Named;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.view.listing.ListingView;
import eu.emi.emir.ui.view.listing.ListingViewEvent;

/**
 * @author a.memon
 *
 */
public class FacetView extends VerticalLayout implements View, ItemClickListener{
	
	public final static String VIEW_NAME ="view.facet"; 
	
	private EventBus bus;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FacetTree tree = new FacetTree();
	
	/**
	 * 
	 */
	public FacetView() {
		initLayout();
	}

	/**
	 * 
	 */
	private void initLayout() {
		System.out.println("facet view called");
		tree = new FacetTree();
		tree.addItemClickListener(this);
		addComponent(tree);
		bus = EmirUI.getCurrent().getEventBus();
		
		
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
				
	}

	/* (non-Javadoc)
	 * @see com.vaadin.event.ItemClickEvent.ItemClickListener#itemClick(com.vaadin.event.ItemClickEvent)
	 */
	@Override
	public void itemClick(ItemClickEvent event) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(ListingViewEvent.QUERY, "query");
		bus.post(new ListingViewEvent(map));
		}

}
