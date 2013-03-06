/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import eu.emi.emir.client.EMIRClient;

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
		//TODO: read from the properties files
		return new EMIRClient("http://zam052v04.zam.kfa-juelich.de:9127");
	}
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		
	}
}	
