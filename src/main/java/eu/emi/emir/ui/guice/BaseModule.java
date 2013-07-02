/**
 * 
 */
package eu.emi.emir.ui.guice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import com.vaadin.shared.Version;
import com.vaadin.ui.UI;

import eu.emi.emir.ui.EmirUI;

/**
 * @author a.memon
 * 
 */
public class BaseModule extends ServletModule {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.servlet.ServletModule#configureServlets()
	 */
	@Override
	protected void configureServlets() {
		serve("/*").with(BaseServlet.class);
		bind(String.class).annotatedWith(Names.named("title")).toInstance(
				"Basic Guice Vaadin Application");
		bind(String.class).annotatedWith(Names.named("version")).toInstance(
				"<b>Vaadin " + Version.getFullVersion() + "</b>");
		
	}

	@Provides
	private Class<? extends UI> provideUIClass() {
		return EmirUI.class;		
	}
	
	//TODO: probably a bad idea to have bus singleton 
	@Provides @Singleton
	ScheduledExecutorService createExecutorService(){
		return Executors.newScheduledThreadPool(3);
	}
	
}
