/**
 * 
 */
package eu.emi.emir.ui.vaadin.container;

import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import eu.emi.emir.client.TestValueConstants;

/**
 * @author a.memon
 *
 */
public class TestIndexedJSONContainer {
	@Test
	public void test() throws JSONException{
		JSONArrayLazyIndexedContainer j = new JSONArrayLazyIndexedContainer(TestValueConstants.getSingleJSONArrayWithMandatoryAttributes());
		System.out.println(j.getContainerPropertyIds());
		System.out.println(j.getItemIds());
	}
}
