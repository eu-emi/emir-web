/**
 * 
 */
package eu.emi.emir.ui.view.main;

import java.util.Timer;
import java.util.TimerTask;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.view.common.HeaderPanel;
import eu.emi.emir.ui.view.facet.FacetView;
import eu.emi.emir.ui.view.listing.ListingView;

/**
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "view.main";

	private Injector injector;
	
	MainPresenter presenter;
	
	DisconnectWindow window;
	
	EventBus bus;
	
	EmirUI ui;
	
	/**
	 * 
	 */
	public MainView() {
		generateUI();
	}

	/**
	 * 
	 */
	private void generateUI() {
		setSizeFull();
		
		ui = EmirUI.getCurrent();
		
		injector = EmirUI.getCurrent().getInjector();
		
		presenter = injector.getInstance(MainPresenter.class);
		
		 window = new DisconnectWindow(presenter);
		 
		 bus = injector.getInstance(EventBus.class);
		 
		 bus.register(this);
		
		HeaderPanel panel = new HeaderPanel();

		addComponent(panel);

		setExpandRatio(panel, 0.25f);

		if (!presenter.isReachable()) {
			showDisconnectWindow();
		} else {
			FacetView facetView = new FacetView();

			ListingView listView = new ListingView();

			HorizontalSplitPanel hPanel = new HorizontalSplitPanel(facetView,
					listView);

			hPanel.setSplitPosition(25);

			hPanel.setMaxSplitPosition(50, Unit.PERCENTAGE);

			hPanel.setMinSplitPosition(15, Unit.PERCENTAGE);

			addComponent(hPanel);

			setExpandRatio(hPanel, 2.75f);
			
			Navigator navigator = EmirUI.getCurrent().getNavigator();

			// register the views
//			navigator.addView(FacetView.VIEW_NAME, facetView);
			
//			navigator.addView(ListingView.VIEW_NAME, listView);
		}		

	}
	
	private void showDisconnectWindow(){
		window.showWindow();
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
	public void disconnectEvent(ConnectionStatusEvent event){
		if (!event.isConnected()) {
//			if(window.getWindow().isVisible()){
//				window.removeWindow();				
//			}
			
//			window.showWindow();
			if(ui.getWindows().isEmpty()){
				window.showWindow();
			}
		} else {
			
			if (ui.getWindows().size() > 0) {
				System.out.println("removing window");
				window.removeWindow();
			}
			
			
//			window.showWindow();
		}
	}

}
