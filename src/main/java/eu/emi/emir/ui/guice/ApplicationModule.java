/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.service.EmirEndpointListingService;
import eu.emi.emir.ui.service.EmirFacetService;
import eu.emi.emir.ui.service.EndpointListingService;
import eu.emi.emir.ui.service.FacetService;
import eu.emi.emir.ui.view.facet.FacetPresenter;

/**
 * @author a.memon
 *
 */
public class ApplicationModule extends AbstractModule{

	
	
	@Provides
	EventBus createEventBus(){
		return new EventBus("emir-event-bus");
	}
	
	@Provides
	EMIRClient createEmirClient(){
		//TODO: should read from the properties files
		return new EMIRClient("http://localhost:9127");
	}
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		
	}
}	
