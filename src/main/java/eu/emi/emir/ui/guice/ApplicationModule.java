/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;

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
