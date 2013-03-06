/**
 * 
 */
package eu.emi.emir.ui.guice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import com.vaadin.shared.Version;
import com.vaadin.ui.UI;

import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.UIProperties;

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
	
	@Provides
	private UIProperties provideUIProperties(){
		String path = getServletContext().getRealPath("config/emir.properties");
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UIProperties emirProps = new UIProperties(p);
		return emirProps;
	}
}
