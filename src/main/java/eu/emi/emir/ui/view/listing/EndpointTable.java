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

import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.client.TestValueConstants;
import eu.emi.emir.ui.data.AttributeMap;
import eu.emi.emir.ui.vaadin.container.JSONArrayLazyIndexedContainer;

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

	public EndpointTable() {
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

		// allow only single select
		setSelectable(true);
		setMultiSelect(false);

		List<String> lst = new ArrayList<String>();

		lst.add(ServiceBasicAttributeNames.SERVICE_ENDPOINT_ID.toString());
		lst.add(ServiceBasicAttributeNames.SERVICE_ENDPOINT_URL.toString());

		Map<String, String> map = attrMap.getAttributeMap();

		setColumnHeaders(map);

		// populate data
		try {
			setContainerDataSource(new JSONArrayLazyIndexedContainer(
					generateDummyData()), map.keySet());
		} catch (JSONException e) {
			e.printStackTrace();
		}

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

	/**
	 * @REMOVEME
	 * @return
	 * @throws JSONException
	 */
	private JSONArray generateDummyData() throws JSONException {
		return TestValueConstants
				.getDummyJSONArrayWithMandatoryAttributes(1000);
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
		com.vaadin.ui.Window w = new com.vaadin.ui.Window("Detailed View");

	}

	/**
	 * 
	 */
	public void updateTable() {
		// populate data
		try {
			// data changed
			setContainerDataSource(new JSONArrayLazyIndexedContainer(
					generateDummyData()), attrMap.getAttributeMap().keySet());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
