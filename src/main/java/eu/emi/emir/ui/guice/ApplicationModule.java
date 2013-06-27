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

	EventBus createEventBus(){
		return new EventBus("emir-event-bus");
	}
	
	@Override
	protected void configure() {
	}

}	
