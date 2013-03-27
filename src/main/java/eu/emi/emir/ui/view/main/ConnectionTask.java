/**
 * 
 */
package eu.emi.emir.ui.view.main;

import com.google.common.eventbus.EventBus;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.guice.BaseFilter;

/**
 * Global 
 * 
 * @author a.memon
 *
 */
public class ConnectionTask implements Runnable{
	EMIRClient client;
	EventBus bus;
	ConnectionStatusEvent cse;
	/**
	 * 
	 */
	public ConnectionTask() {
		cse = new ConnectionStatusEvent();
		client = BaseFilter.getInjector().getInstance(EMIRClient.class);
		bus = BaseFilter.getInjector().getInstance(EventBus.class);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("checking client connection");
		if (client.isReachable()) {
			cse.setConnectionStatus(true);
		} else {
			cse.setConnectionStatus(false);
		}
		bus.post(cse);
	}

}
