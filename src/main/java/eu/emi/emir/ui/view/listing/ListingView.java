/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import org.codehaus.jettison.json.JSONArray;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.ui.EmirUI;

/**
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class ListingView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "view.listing";

	private ListingPresenter presenter;

	private EndpointTable t;

	private EventBus bus;

	/**
	 * 
	 */
	public ListingView() {
		presenter = EmirUI.getCurrent().getInjector()
				.getInstance(ListingPresenter.class);
		bus = EmirUI.getCurrent().getEventBus();
		bus.register(this);
		generateUI();
	}

	/**
	 * 
	 */
	private void generateUI() {
		setSizeFull();
		t = new EndpointTable(presenter);
		addComponent(t);

		JSONArray ja = presenter.getListing(null);

		if (ja.length() > 0) {
			t.updateTable(null);
		} else {
			Notification.show("Found 0 Endpoints",
					Notification.Type.HUMANIZED_MESSAGE);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener
	 * .ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

	@Subscribe
	public void handleListingViewEvent(ListingViewEvent e) {
//		JSONArray ja = presenter.getListing(e.getQuery());
//		if (ja.length() > 0) {
//			t.updateTable(ja);
			t.updateTable(e.getQuery());
//		} else {
//			Notification.show("Found 0 Endpoints",
//					Notification.Type.HUMANIZED_MESSAGE);
//		}
	}

}
