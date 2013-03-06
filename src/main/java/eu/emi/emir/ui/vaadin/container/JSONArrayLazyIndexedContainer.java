/**
 * 
 */
package eu.emi.emir.ui.vaadin.container;

import java.util.Iterator;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ReadOnlyException;
import com.vaadin.data.util.IndexedContainer;

/**
 * 
 * 
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class JSONArrayLazyIndexedContainer extends IndexedContainer {

	JSONArray ja;

	/**
	 * 
	 */
	public JSONArrayLazyIndexedContainer(JSONArray jsonArray) {
		this.ja = jsonArray;
		populateContainer(this.ja);
	}

	private void populateContainer(JSONArray parsedJsonArray) {

		int length = parsedJsonArray.length();
		try {
			for (int i = 0; i < length; i++) {
				JSONObject jo;

				jo = parsedJsonArray.getJSONObject(i);

				if (!jo.has("ref")) {
					addJsonObject(jo);
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addJsonObject(JSONObject jsonObject) throws ReadOnlyException,
			JSONException {
		// use itemId generated by IndexedContainer
		Object itemId = addItem();
		Item i = getItem(itemId);
		
		
		
		Iterator<String> it = jsonObject.keys();

		while (it.hasNext()) {
			String key = it.next();
			addContainerProperty(key, String.class, null);
			i.getItemProperty(key).setValue(jsonObject.get(key).toString());
		}

	}

	public void appendContainer(JSONArray ja) throws JSONException {
		populateContainer(ja);
	}

}
