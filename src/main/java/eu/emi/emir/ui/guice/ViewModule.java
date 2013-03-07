/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.inject.AbstractModule;

import eu.emi.emir.ui.service.EmirEndpointListingService;
import eu.emi.emir.ui.service.EmirFacetService;
import eu.emi.emir.ui.service.EndpointListingService;
import eu.emi.emir.ui.service.FacetService;
import eu.emi.emir.ui.view.facet.FacetPresenter;
import eu.emi.emir.ui.view.listing.ListingPresenter;

/**
 * @author a.memon
 *
 */
public class ViewModule extends AbstractModule{

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(FacetPresenter.class);
		bind(ListingPresenter.class);
		bind(FacetService.class).to(EmirFacetService.class);
		bind(EndpointListingService.class).to(EmirEndpointListingService.class);
	}
	
}
