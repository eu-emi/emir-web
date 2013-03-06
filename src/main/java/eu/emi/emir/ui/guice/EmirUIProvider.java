/**
 * 
 */
package eu.emi.emir.ui.guice;

import com.google.inject.Inject;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;


/**
 * @author a.memon
 * 
 */
@SuppressWarnings("serial")
public class EmirUIProvider extends UIProvider {

	@Inject
	private Class<? extends UI> uiClass;

	@Override
	public UI createInstance(UICreateEvent event) {
		return BaseFilter.getInjector().getProvider(uiClass).get();
	}

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		return uiClass;
	}
}
