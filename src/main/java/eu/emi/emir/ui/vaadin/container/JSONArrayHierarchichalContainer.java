/**
 * 
 */
package eu.emi.emir.ui.vaadin.container;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;

import eu.emi.emir.client.ServiceBasicAttributeNames;

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
		addContainerProperty(PROPERTY_VAL, String.class, null);
		try {
			//add ALL node
			parentItemId = addItem();
			parentItem = getItem(parentItemId);
			parentItem.getItemProperty(PROPERTY_NAME).setValue("All");
			parentItem.getItemProperty(PROPERTY_VAL).setValue("All");
			//all should not contain any children
			setChildrenAllowed(parentItemId, false);
			
			for (int i = 0; i < ja.length(); i++) {
				// Add new item
				parentItemId = addItem();
				parentItem = getItem(parentItemId);
				// item = getItem(itemId);
				// Add name property for item
				JSONObject facet = ja.getJSONObject(i);
				String keyName = facet.names().getString(0);
				
				parentItem.getItemProperty(PROPERTY_NAME).setValue(keyName);	
				if (keyName.equals(ServiceBasicAttributeNames.SERVICE_ENDPOINT_CAPABILITY.getAttributeName())) {
					parentItem.getItemProperty(PROPERTY_VAL).setValue("Service Capabilities");	
				} else if (keyName.equals(ServiceBasicAttributeNames.SERVICE_TYPE.getAttributeName())){
					parentItem.getItemProperty(PROPERTY_VAL).setValue("Service Types");
				}
				
				// Allow children
				setChildrenAllowed(parentItemId, true);
				JSONArray childItems = facet.getJSONArray(keyName);
				for (int j = 0; j < childItems.length(); j++) {
					// Add child items
					childItemId = addItem();
					childItem = getItem(childItemId);
					JSONObject childJson = childItems.getJSONObject(j);
					childItem.getItemProperty(PROPERTY_VAL).setValue(
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
