/**
 * 
 */
package eu.emi.emir.ui.view.facet;

import com.google.common.eventbus.EventBus;
import com.sun.jersey.json.impl.JSONHelper;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.vaadin.container.JSONArrayHierarchichalContainer;
import eu.emi.emir.ui.view.listing.ListingViewEvent;

/**
 * @author a.memon
 * 
 */
public class FacetView extends VerticalLayout implements View,
		ItemClickListener {

	public final static String VIEW_NAME = "view.facet";

	private EventBus bus;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FacetTree tree;

	private FacetPresenter presenter;

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
		bus = EmirUI.getCurrent().getEventBus();
		presenter = EmirUI.getCurrent().getInjector()
				.getInstance(FacetPresenter.class);
		tree = new FacetTree(presenter.getFacets());
		tree.addItemClickListener(this);

		addComponent(tree);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.event.ItemClickEvent.ItemClickListener#itemClick(com.vaadin
	 * .event.ItemClickEvent)
	 */
	@Override
	public void itemClick(ItemClickEvent event) {

		if (!tree.isRoot(event.getItemId())) {
			String itemVal = tree.getItem(event.getItemId())
			.getItemProperty(JSONArrayHierarchichalContainer.PROPERTY_VAL).getValue().toString();
			String attrValue = itemVal.substring(0, itemVal.indexOf('('));

			String key = tree.getItem(tree.getParent(event.getItemId())).getItemProperty(JSONArrayHierarchichalContainer.PROPERTY_NAME).getValue().toString();
			
			bus.post(new ListingViewEvent(URIQuery.builder().addParam(key, attrValue.trim()).build()));
		}
	}

}
