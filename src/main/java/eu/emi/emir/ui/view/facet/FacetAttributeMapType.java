package eu.emi.emir.ui.view.facet;

import eu.emi.emir.ui.data.AttributeMapType;

/**
 * @author a.memon
 *
 */
public class FacetAttributeMapType implements AttributeMapType{

	public static final Class<FacetAttributeMap> FACET = FacetAttributeMap.class;
	
	/* (non-Javadoc)
	 * @see eu.emi.emir.ui.data.AttributeMapType#getTypeName()
	 */
	@Override
	public String getTypeName() {
		return FACET.getName();
	}

}
