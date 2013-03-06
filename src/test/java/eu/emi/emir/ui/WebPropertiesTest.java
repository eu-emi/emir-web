/**
 * 
 */
package eu.emi.emir.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * @author a.memon
 *
 */
public class WebPropertiesTest {
	@Test
	public void testReadFacets() throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileInputStream(new File("src/main/webapp/WEB-INF/emir.properties")));
		UIProperties web = new UIProperties(p);
		System.out.println(web.getFacets());
	}
}
