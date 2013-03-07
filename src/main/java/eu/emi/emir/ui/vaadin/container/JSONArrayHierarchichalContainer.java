/**
 * 
 */
package eu.emi.emir.ui.vaadin.container;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;

/**
 * The hierarchical container used to build the facet tree from 2D json Array
 * 
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class JSONArrayHierarchichalContainer extends HierarchicalContainer {
	public static final Object PROPERTY_NAME = "name";
	public static final Object PROPERTY_VAL = "value";

	public JSONArrayHierarchichalContainer(JSONArray ja) {
		Item parentItem = null;

		Item childItem = null;

		Object parentItemId = null;

		Object childItemId = null;

		addContainerProperty(PROPERTY_NAME, String.class, null);
		try {

			for (int i = 0; i < ja.length(); i++) {
				// Add new item
				parentItemId = addItem();
				parentItem = getItem(parentItemId);
				// item = getItem(itemId);
				// Add name property for item
				JSONObject facet = ja.getJSONObject(i);
				String keyName = facet.names().getString(0);

				parentItem.getItemProperty(PROPERTY_NAME).setValue(keyName);
				// Allow children
				setChildrenAllowed(parentItemId, true);
				JSONArray childItems = facet.getJSONArray(keyName);
				for (int j = 0; j < childItems.length(); j++) {
					// Add child items
					childItemId = addItem();
					childItem = getItem(childItemId);
					JSONObject childJson = childItems.getJSONObject(j);
					childItem.getItemProperty(PROPERTY_NAME).setValue(
							childJson.getString("_id") + " ("
									+ childJson.getLong("count") + ")");
					setParent(childItemId, parentItemId);
					setChildrenAllowed(childItemId, false);

				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
