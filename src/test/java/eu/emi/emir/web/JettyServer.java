/**
 * 
 */
package eu.emi.emir.web;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author a.memon
 *
 */
public class JettyServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		Connector con = new SelectChannelConnector();
        con.setPort(8080);
        server.addConnector(con);
        
        server.setHandler(new WebAppContext("src/main/webapp", "/"));
        server.start();
		
	}

	
}
