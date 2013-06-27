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

import eu.emi.emir.client.query.EndpointQuery;
import eu.emi.emir.client.query.URIQuery;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.vaadin.addons.lazyquerycontainer.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock implementation of Query interface for JUnit tests and example application.
 *
 * @author tommilaukkanen
 */
public class EmirWebQuery implements Query {

    private EmirWebQueryFactory queryFactory;
    private List<Item> items;
    private int batchQueryMinTime;
    private int batchQueryMaxTime;
    private Map<Item, Item> cloneMap = new HashMap<Item, Item>();
	private URIQuery uriQuery;

    public EmirWebQuery(EmirWebQueryFactory queryFactory, List<Item> items, int batchQueryMinTime, int batchQueryMaxTime) {
        this.queryFactory = queryFactory;
        this.items = items;
        this.batchQueryMinTime = batchQueryMinTime;
        this.batchQueryMaxTime = batchQueryMaxTime;
    }

    public EmirWebQuery(EmirWebQueryFactory mockQueryFactory, List<Item> items2, URIQuery uriQuery) {
    	this.queryFactory = mockQueryFactory;
        this.items = items2;
        this.uriQuery = uriQuery; 
	}

	public List<Item> loadItems(int startIndex, int count) {
        List<Item> resultItems = new ArrayList<Item>();
        
        JSONArray ja = null;
        URIQuery query = null;
        try {
        	
        if (!(startIndex <= 0)) {
        	query = URIQuery.builder().setSkip(startIndex).setResultLimit(count).mergeURIQuery(uriQuery).build();
        	ja = this.queryFactory.getEmirClient().queryByQueryParams(query);
		} else {
			query = URIQuery.builder().setResultLimit(count).mergeURIQuery(uriQuery).build();
			ja = this.queryFactory.getEmirClient().queryByQueryParams(query);
		}
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        for (int i = 0; i < ja.length(); i++) {
			try {
				JSONObject jo = ja.getJSONObject(i);
				if (!jo.has("ref")) {
					resultItems.add(queryFactory.constructItem(jo));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
        
        return resultItems;
    }
	
	public List<Item> _loadItems(int startIndex, int count) {
        List<Item> resultItems = new ArrayList<Item>();
        for (int i = 0; i < count; i++) {
            // Returning clones to be able to control commit/discard of modifications.
            Item original = items.get(startIndex + i);
            Item clone = cloneItem(original);
            resultItems.add(clone);
            cloneMap.put(clone, original);
        }

        try {
            Thread.sleep(batchQueryMinTime + (int) (Math.random() * batchQueryMaxTime));
        } catch (InterruptedException e) {
        }

        return resultItems;
    }

    public int size() {
    	URIQuery query = URIQuery.builder().setSkip(1).mergeURIQuery(uriQuery).build();
    	//this is very one time but computational expensive
    	Integer size = this.queryFactory.getEmirClient().queryByQueryParams(query).length()+1;
        return size;
    }

    public Item constructItem() {
        return queryFactory.constructItem(null);
    }

    public boolean deleteAllItems() {
        items.clear();
        return true;
    }

    public void saveItems(List<Item> addedItems, List<Item> modifiedItems,
                          List<Item> removedItems) {
        items.addAll(0, addedItems);
        for (Item clone : removedItems) {
            Item original = cloneMap.get(clone);
            if (addedItems.contains(clone)) {
                // If item is new then it is not mapped through clone map.
                items.remove(clone);
            } else {
                items.remove(original);
            }
        }
        for (Item clone : modifiedItems) {
            Item original = cloneMap.get(clone);
            copyItemValues(original, clone);
        }
    }

    private Item cloneItem(Item originalItem) {
        PropertysetItem newItem = new PropertysetItem();
        for (Object propertyId : originalItem.getItemPropertyIds()) {
            Property originalProperty = originalItem.getItemProperty(propertyId);
            newItem.addItemProperty(propertyId,
                    new ObjectProperty(
                            originalProperty.getValue(),
                            originalProperty.getType(),
                            originalProperty.isReadOnly()
                    ));
        }
        return newItem;
    }

    private void copyItemValues(Item target, Item source) {
        for (Object propertyId : source.getItemPropertyIds()) {
            Property sourceProperty = source.getItemProperty(propertyId);
            Property targetProperty = target.getItemProperty(propertyId);
            boolean readonlyState = targetProperty.isReadOnly();
            targetProperty.setReadOnly(false);
            target.getItemProperty(propertyId).setValue(sourceProperty.getValue());
            targetProperty.setReadOnly(readonlyState);
        }
    }

}
