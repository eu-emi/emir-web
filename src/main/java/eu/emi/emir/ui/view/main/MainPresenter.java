/**
 * 
 */
package eu.emi.emir.ui.view.main;

import com.google.inject.Inject;

import eu.emi.emir.client.EMIRClient;

/**
 * @author a.memon
 *
 */
public class MainPresenter{
	@Inject
	EMIRClient client;
	
	public boolean isReachable(){
		return client.isReachable();
	}
	
	public String getEmirUrl(){
		return client.getEmirUrl();
	}
	
	
	
}
