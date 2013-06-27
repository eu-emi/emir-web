/**
 * Copyright 2010 Tommi S.E. Laukkanen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.emi.emir.ui.vaadin.container;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.client.query.EndpointQuery;
import eu.emi.emir.client.query.URIQuery;
import eu.emi.emir.client.util.DateUtil;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.vaadin.addons.lazyquerycontainer.Query;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;
import org.vaadin.addons.lazyquerycontainer.QueryFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

/**
 * Mock implementation of QueryFactory interface for JUnit tests and example
 * application.
 * 
 * @author Tommi S.E. Laukkanen
 */
public class EmirWebQueryFactory implements QueryFactory {

	private List<Item> items;
	private QueryDefinition definition;
	// private int resultSize;
	private int batchQueryMinTime;
	private int batchQueryMaxTime;
	private EMIRClient c;
	private URIQuery uriQuery;

	public EmirWebQueryFactory(QueryDefinition d, EMIRClient client,
			URIQuery uriQuery) {
		// this.resultSize = resultSize;
		this.batchQueryMinTime = batchQueryMinTime;
		this.batchQueryMaxTime = batchQueryMaxTime;
		this.definition = d;
		this.c = client;
		this.uriQuery = uriQuery;
	}

	public void setQueryDefinition(QueryDefinition definition) {
		this.definition = definition;
	}

	public EMIRClient getEmirClient() {
		return c;
	}

	public Query constructQuery(QueryDefinition definition) {
		JSONArray ja = null;
		// Creating items on demand when constructQuery is first time called.
		if (items == null) {
			items = new ArrayList<Item>();
			ja = c.queryByQueryParams(EndpointQuery.builder()
					.addParam("limit", "100").build());
		} else {
			ja = c.queryByQueryParams(EndpointQuery.builder()
					.addParam("limit", "100").addParam("skip", ("100")).build());
		}

		try {
			for (int i = 0; i < ja.length(); i++) {

				JSONObject eptObj;
				eptObj = ja.getJSONObject(i);
				if (!eptObj.has("ref")) {
					this.items.add(constructItem(eptObj));
				}

			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new EmirWebQuery(this, this.items, this.uriQuery);
	}

	public Item _constructItem(int indexColumnValue, int reverseIndexColumnValue) {
		// since construct item needs to know what the current size is
		// (including added items)
		// to populate Index and ReverseIndex we should provide it somehow here!
		// At the moment adding multiple items leads to strange behaviour.
		PropertysetItem item = new PropertysetItem();

		for (Object propertyId : this.definition.getPropertyIds()) {

			Object value = null;

			if ("Index".equals(propertyId)) {
				value = indexColumnValue;
			} else if ("ReverseIndex".equals(propertyId)) {
				value = reverseIndexColumnValue;
			} else {
				value = this.definition.getPropertyDefaultValue(propertyId);
			}

			item.addItemProperty(propertyId, new ObjectProperty(value,
					this.definition.getPropertyType(propertyId),
					this.definition.isPropertyReadOnly(propertyId)));

		}
		return item;
	}

	public Item constructItem(JSONObject jo) {
		// since construct item needs to know what the current size is
		// (including added items)
		// to populate Index and ReverseIndex we should provide it somehow here!
		// At the moment adding multiple items leads to strange behaviour.
		PropertysetItem item = new PropertysetItem();
		try {
			for (Object propertyId : this.definition.getPropertyIds()) {

				Object value = null;

				if ("Name".equals(propertyId)) {
					if (jo.has(ServiceBasicAttributeNames.SERVICE_NAME
							.getAttributeName())) {
						value = jo
								.getString(ServiceBasicAttributeNames.SERVICE_NAME
										.getAttributeName());
					} else {
						value = "";
					}
				} else
				if ("PublishedBy".equals(propertyId)) {
					value = jo
							.getString(ServiceBasicAttributeNames.SERVICE_OWNER_DN
									.getAttributeName());
				} else if ("ExpireOn".equals(propertyId)) {
					Calendar fromDate = Calendar.getInstance();
					DateUtil.getDate(jo
							.getJSONObject(ServiceBasicAttributeNames.SERVICE_EXPIRE_ON
									.getAttributeName()));
					fromDate.setTime(DateUtil.getDate(jo
							.getJSONObject(ServiceBasicAttributeNames.SERVICE_EXPIRE_ON
									.getAttributeName())));
					value = DateUtil.duration(Calendar.getInstance(), fromDate)
							.toString();
				} else if ("URL".equals(propertyId)) {
					if (jo.has(ServiceBasicAttributeNames.SERVICE_ENDPOINT_URL
							.getAttributeName()))
						value = jo
							.getString(ServiceBasicAttributeNames.SERVICE_ENDPOINT_URL
									.getAttributeName());
					else
						value = "";
				} 
				
				else if ("ID".equals(propertyId)) {
					if(jo.has(ServiceBasicAttributeNames.SERVICE_ENDPOINT_ID
							.getAttributeName()))
						value = jo
							.getString(ServiceBasicAttributeNames.SERVICE_ENDPOINT_ID
									.getAttributeName());
					else
						value = "";
				}

				item.addItemProperty(propertyId, new ObjectProperty(value,
						this.definition.getPropertyType(propertyId),
						this.definition.isPropertyReadOnly(propertyId)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public void addProperty(Object propertyId, Class<?> type,
			Object defaultValue, boolean readOnly, boolean sortable) {
		for (Item item : this.items) {
			((PropertysetItem) item).addItemProperty(propertyId,
					new ObjectProperty(defaultValue, type, readOnly));

		}
	}

	public class ItemComparator implements Comparator<Item> {
		private Object[] sortPropertyIds;
		private boolean[] ascendingStates;

		public ItemComparator(Object[] sortPropertyIds,
				boolean[] ascendingStates) {
			this.sortPropertyIds = sortPropertyIds;
			this.ascendingStates = ascendingStates;
		}

		public int compare(Item o1, Item o2) {

			for (int i = 0; i < sortPropertyIds.length; i++) {
				Property p1 = o1.getItemProperty(sortPropertyIds[i]);
				Property p2 = o2.getItemProperty(sortPropertyIds[i]);

				int v1 = (Integer) p1.getValue();
				int v2 = (Integer) p2.getValue();

				if (v1 != v2) {
					int comparison = v1 - v2;
					if (!ascendingStates[i]) {
						comparison = -comparison;
					}
					return comparison;
				}
			}

			return 0;
		}

	}

}
