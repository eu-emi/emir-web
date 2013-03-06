/**
 * 
 */
package eu.emi.emir.ui.guice;

import java.util.Properties;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;


/**
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
@Singleton
public class BaseServlet extends VaadinServlet implements SessionInitListener {
	@Inject
	private EmirUIProvider basicProvider;

	@Override
	protected DeploymentConfiguration createDeploymentConfiguration(
			Properties initParameters) {
		initParameters.setProperty(SERVLET_PARAMETER_PRODUCTION_MODE, "true");
		return super.createDeploymentConfiguration(initParameters);
	}

	@Override
	protected void servletInitialized() {
		getService().addSessionInitListener(this);
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		event.getSession().addUIProvider(basicProvider);
	}

}
