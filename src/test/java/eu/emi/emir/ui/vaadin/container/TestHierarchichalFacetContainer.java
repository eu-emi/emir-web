/**
 * 
 */
package eu.emi.emir.ui.vaadin.container;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.codehaus.jettison.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author a.memon
 * 
 */
public class TestHierarchichalFacetContainer {
	@Test
	public void test() throws Exception {
		String facets = FileUtils.readFileToString(new File(
				"src/test/resources/facet.json"));
		JSONArray ja = new JSONArray(facets);
		System.out.println(ja.getJSONObject(0).names().getString(0));

		JSONArrayHierarchichalContainer c = new JSONArrayHierarchichalContainer(
				ja);

		// assert that the first item in the tree is the first item in array
		assertEquals(ja.getJSONObject(0).names().getString(0), c.getItem(1)
				.getItemProperty(c.PROPERTY_NAME).getValue());
	}
}
