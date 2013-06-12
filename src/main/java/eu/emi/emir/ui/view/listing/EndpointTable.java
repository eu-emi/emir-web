/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.vaadin.addons.lazyquerycontainer.LazyQueryContainer;
import org.vaadin.addons.lazyquerycontainer.LazyQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryView;
import org.vaadin.addons.lazyquerycontainer.QueryItemStatus;
import org.vaadin.addons.lazyquerycontainer.QueryItemStatusColumnGenerator;

import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.client.TestValueConstants;
import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.ui.data.AttributeMap;
import eu.emi.emir.ui.vaadin.container.JSONArrayLazyIndexedContainer;
import eu.emi.emir.ui.vaadin.container.EmirWebQuery;
import eu.emi.emir.ui.vaadin.container.EmirWebQueryFactory;

/**
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class EndpointTable extends Table implements ItemClickListener {
	static final Action ACTION_MARK = new Action("Mark");
	static final Action ACTION_UNMARK = new Action("Unmark");
	static final Action ACTION_LOG = new Action("Save");
	static final Action[] ACTIONS_UNMARKED = new Action[] { ACTION_MARK,
			ACTION_LOG };
	static final Action[] ACTIONS_MARKED = new Action[] { ACTION_UNMARK,
			ACTION_LOG };
	
	private AttributeMap attrMap = AttributeMap.Factory
			.newInstance(ListingMapType.LISTING);;
	
    private ArrayList<Object> visibleColumnIds = new ArrayList<Object>();
	private ArrayList<String> visibleColumnLabels = new ArrayList<String>();
	
	private ListingPresenter presenter;
	
	public EndpointTable(ListingPresenter presenter) {
		this.presenter = presenter;
		init();
	}


		/**
	 * 
	 */
	private void init() {
		setColumnCollapsingAllowed(true);
		setSortEnabled(true);

		// turn on column reordering and collapsing
		setColumnReorderingAllowed(true);
		setColumnCollapsingAllowed(true);

		// set the size
		setSizeFull();

		/////////////
		// allow only single select
//		setSelectable(true);
//		setMultiSelect(false);
//
//		List<String> lst = new ArrayList<String>();
//
//		lst.add(ServiceBasicAttributeNames.SERVICE_ENDPOINT_ID.toString());
//		lst.add(ServiceBasicAttributeNames.SERVICE_ENDPOINT_URL.toString());
//
//		Map<String, String> map = attrMap.getAttributeMap();

		/////////////
		
		LazyQueryDefinition d = new LazyQueryDefinition(true, 100, "ID");
		
		EmirWebQueryFactory mockQueryFactory = new EmirWebQueryFactory(d, presenter.getEmirClient(), URIQuery.builder().build());
        LazyQueryContainer container = new LazyQueryContainer(d, mockQueryFactory);
        
        container.addContainerProperty("ID", String.class, "", true, true);
        container.addContainerProperty("Name", String.class, "", true, true);
        container.addContainerProperty("PublishedBy", String.class, "", true, true);
        container.addContainerProperty("ExpireOn", String.class, "", true, true);
        container.addContainerProperty("URL", String.class, "", true, true);
        
        setContainerDataSource(container);

        visibleColumnIds.add("Name");
        visibleColumnIds.add("PublishedBy");
        visibleColumnIds.add("ExpireOn");
        visibleColumnIds.add("URL");

        visibleColumnLabels.add("Name");
        visibleColumnLabels.add("Published By");
        visibleColumnLabels.add("Expire On");
        visibleColumnLabels.add("URL");
        
        setVisibleColumns(visibleColumnIds.toArray());
        setColumnHeaders(visibleColumnLabels.toArray(new String[0]));

        setEditable(false);
        setMultiSelect(false);
        setSelectable(true);
		
		addItemClickListener(this);

	}

	/**
	 * 
	 */
	private void setColumnHeaders(Map<String, String> map) {
		Set<String> keys = map.keySet();

		for (String key : keys) {
			setColumnHeader(key, map.get(key));
		}

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vaadin.ui.Table#valueChange(com.vaadin.data.Property.ValueChangeEvent
	 * )
	 */
	@Override
	public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {

		Notification.show(event.getProperty().getValue().toString());

		super.valueChange(event);
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

	}

	/**
	 * 
	 */
	public void updateTable(URIQuery query) {
		LazyQueryDefinition d = new LazyQueryDefinition(true, 100, "ID");
		if (query == null) {
			query = URIQuery.builder().build();
		}
		EmirWebQueryFactory mockQueryFactory = new EmirWebQueryFactory(d, presenter.getEmirClient(), query);
        LazyQueryContainer container = new LazyQueryContainer(d, mockQueryFactory);
        container.addContainerProperty("ID", String.class, "", true, true);
        container.addContainerProperty("Name", String.class, "", true, true);
        container.addContainerProperty("PublishedBy", String.class, "", true, true);
        container.addContainerProperty("ExpireOn", String.class, "", true, true);
        container.addContainerProperty("URL", String.class, "", true, true);
		setContainerDataSource(container);
	}
	
}
