/**
 * 
 */
package eu.emi.emir.ui.guice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.Provider;

import eu.emi.emir.client.EMIRClient;

/**
 * @author a.memon
 * 
 */
public class ClientProvider implements Provider<EMIRClient> {
	EMIRClient client;
	
	/**
	 * 
	 */
	public ClientProvider() {
		Properties p =new Properties();
		try {
			p.load(new FileInputStream(new File("emir.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client = new EMIRClient(p.getProperty("emir.serverAddress"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.Provider#get()
	 */
	@Override
	public EMIRClient get() {
		return client;
	}

}
