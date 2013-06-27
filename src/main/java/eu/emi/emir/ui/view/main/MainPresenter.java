/**
 * 
 */
package eu.emi.emir.ui.view.main;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.view.address.Address;

/**
 * @author a.memon
 *
 */
public class MainPresenter{
	EMIRClient client;
	
	public boolean isReachable(){
		return getClient().isReachable();
	}
	
	public String getEmirUrl(){
		return getClient().getEmirUrl();
	}
	
	private EMIRClient getClient(){
		if (client == null) {
			client = new EMIRClient(Address.get());
		}
		return client;
	}
	
}
