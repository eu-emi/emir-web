package eu.emi.emir.ui;

import java.util.Properties;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;

import eu.emi.emir.ui.service.FacetService;
import eu.emi.emir.ui.view.address.AddressView;
import eu.emi.emir.ui.view.facet.FacetView;
import eu.emi.emir.ui.view.listing.ListingView;
import eu.emi.emir.ui.view.main.DisconnectWindow;
import eu.emi.emir.ui.view.main.MainPresenter;
import eu.emi.emir.ui.view.main.MainView;

/* 
 * UI class is the starting point for your app. You may deploy it with VaadinServlet
 * or VaadinPortlet by giving your UI class name a parameter. When you browse to your
 * app a web page showing your UI is automatically generated. Or you may choose to 
 * embed your UI to an existing web page. 
 */
@Title("EMIR Browser")
@PreserveOnRefresh
public class EmirUI extends UI {

	private static final long serialVersionUID = 1L;

	private Navigator navigator = null;

	@Inject
	@Named("title")
	private String title = "Basic UI (default title)";

	@Inject(optional = true)
	@Named("version")
	private String version = "Vaadin <i>version unknown</i>";

	@Inject
	private UIProperties webProps = new UIProperties(new Properties());

	private EventBus bus;

	private Injector injector;

	/**
	 * @return the injector
	 */
	public Injector getInjector() {
		return injector;
	}

	/**
	 * @param injector
	 *            the injector to set
	 */
	@Inject
	public void setInjector(Injector injector) {
		this.injector = injector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		buildMainLayout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.UI#getCurrent()
	 */
	public static EmirUI getCurrent() {
		return (EmirUI) CurrentInstance.get(UI.class);
	}

	@Inject
	public void setEventBus(EventBus b) {
		this.bus = b;
	}

	public EventBus getEventBus() {
		return bus;
	}

	/**
	 * 
	 */
	public void _buildMainLayout() {

		navigator = new Navigator(UI.getCurrent(), this);

		MainView content = new MainView();
//		AddressView addressView = new AddressView();
		
//		setContent(addressView);
		setContent(content);

		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(
			content);
		
//		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(
//				addressView);
		
		navigator.addView(MainView.VIEW_NAME, content);
		
//		navigator.addView(AddressView.VIEW_NAME, addressView);
		
		setNavigator(navigator);

		navigator.navigateTo(MainView.VIEW_NAME);
		
//		navigator.navigateTo(AddressView.VIEW_NAME);

	}
	
	/**
	 * 
	 */
	public void buildMainLayout() {

		navigator = new Navigator(this, this);

		AddressView addressView = new AddressView();
		
		

//		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(
//				addressView);
		
		setNavigator(navigator);
		
		navigator.addView(AddressView.VIEW_NAME, addressView);
		
		setContent(addressView);
		
		navigator.navigateTo(AddressView.VIEW_NAME);

	}

	public static String getEmirServerAddress() {
		return ApplicationState.getServerAddress();
	}

}
