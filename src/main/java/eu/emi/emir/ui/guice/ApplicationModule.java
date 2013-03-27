/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.UIProperties;

/**
 * @author a.memon
 *
 */
public class ApplicationModule extends AbstractModule{

	private EMIRClient client;
	
	@Provides @Singleton
	EventBus createEventBus(){
		return new EventBus("emir-event-bus");
	}
	
	@Provides
	@Inject
	EMIRClient createEmirClient(UIProperties props){
		client = new EMIRClient(props.getAddress());
		return client;
	}
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
	}

}	
