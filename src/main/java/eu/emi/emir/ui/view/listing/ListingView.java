/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import org.codehaus.jettison.json.JSONArray;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.vaadin.container.JSONArrayLazyIndexedContainer;

/**
 * @author a.memon
 *
 */
@SuppressWarnings("serial")
public class ListingView extends VerticalLayout implements View{

	public static final String VIEW_NAME = "view.listing";
	
	private ListingPresenter presenter;
	
	private EndpointTable t;
	
	private EventBus bus;
	
	/**
	 * 
	 */
	public ListingView() {
		presenter = EmirUI.getCurrent().getInjector().getInstance(ListingPresenter.class);
		bus = EmirUI.getCurrent().getEventBus();
		bus.register(this);
		generateUI();
	}
	
	/**
	 * 
	 */
	private void generateUI() {
		setSizeFull();
		t = new EndpointTable();
		addComponent(t);
		t.updateTable(presenter.getListing(null));
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	
	@Subscribe
	public void handleListingViewEvent(ListingViewEvent e){
		t.updateTable(presenter.getListing(e.getQuery()));
	}

	

}
