/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import eu.emi.emir.ui.data.AttributeMapType;

/**
 * @author a.memon
 *
 */
public class ListingMapType implements AttributeMapType{
	
	public static final String LISTING = ListingAttributeMap.class.getName();
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AttributeMapType#getTypeName()
	 */
	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return LISTING;
	}

}
