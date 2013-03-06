/**
 * 
 */
package eu.emi.emir.ui.data;

import org.junit.Test;

import eu.emi.emir.ui.view.facet.FacetAttributeMapType;
import eu.emi.emir.ui.view.listing.ListingMapType;

import static org.junit.Assert.*;

/**
 * @author a.memon
 *
 */
public class TestAttributeMap {
	@Test
	public void test(){
		AttributeMap fm = AttributeMap.Factory.newInstance(FacetAttributeMapType.FACET);
		AttributeMap am = AttributeMap.Factory.newInstance(ListingMapType.LISTING);
		System.out.println(am.getValues());
		assertFalse("Values: "+fm.getValues(),fm.getValues().isEmpty());
	}
	
	
}
