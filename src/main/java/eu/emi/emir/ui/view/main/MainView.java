/**
 * 
 */
package eu.emi.emir.ui.view.main;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

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

		HeaderPanel panel = new HeaderPanel();

		addComponent(panel);

		setExpandRatio(panel, 0.25f);

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
		
		navigator.addView(FacetView.VIEW_NAME, facetView);
		navigator.addView(ListingView.VIEW_NAME, listView);

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

}
