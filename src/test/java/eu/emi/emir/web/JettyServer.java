/**
 * 
 */
package eu.emi.emir.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import com.sun.jersey.core.util.MultivaluedMapImpl;

import eu.emi.emir.EMIRServer;
import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.client.ServiceBasicAttributeNames;
import eu.emi.emir.client.TestValueConstants;

/**
 * @author a.memon
 * 
 */
public class JettyServer {
	public static void main(String[] args) throws Exception {
		runJetty();

	}

	private static void removeAllDummyData() throws JSONException {
		EMIRClient c = new EMIRClient("http://localhost:9127");
		JSONArray ja = c.queryByQueryParams(new MultivaluedMapImpl());
		int l = ja.length();
		System.out.println("Removing "+l+" records...");
		for (int i = 0; i < l; i++) {
			if(!ja.getJSONObject(i).has("ref"))
			c.deleteByID(ja.getJSONObject(i).getString(ServiceBasicAttributeNames.SERVICE_ENDPOINT_ID.toString()));
		}
		
	}

	private static void addPublicDummyData() throws JSONException {
		EMIRClient c = new EMIRClient("http://localhost:9127");
		
		//register 500 entries
		for (int i = 0; i < 2; i++) {
			c.register(TestValueConstants
					.getDummyJSONArrayWithMandatoryAttributes(100));	
		}
		
		
	}

	public static void runJetty() throws Exception {
		Server server = new Server();
		Connector con = new SelectChannelConnector();
		con.setPort(8080);
		server.addConnector(con);

		server.setHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();
		System.out.println("Test Jetty Server STARTED");
	}

	public static void runEmir() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(new File("src/test/resources/emir.config")));
		EMIRServer server = new EMIRServer();
		server.run(p);
		System.out.println("Test EMIR Server STARTED");
	}

}
