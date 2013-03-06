/**
 * 
 */
package eu.emi.emir.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import eu.unicore.util.Log;
import eu.unicore.util.configuration.DocumentationReferenceMeta;
import eu.unicore.util.configuration.DocumentationReferencePrefix;
import eu.unicore.util.configuration.PropertiesHelper;
import eu.unicore.util.configuration.PropertyMD;

/**
 * @author a.memon
 *
 */
public class UIProperties extends PropertiesHelper{
	
	private static final Logger logger = Log.getLogger("emir.web", UIProperties.class);
	
	@DocumentationReferencePrefix
	public static final String PREFIX = "emir.";

	/**
	 * 
	 * This is the EMIR server URL, where clients can contact. The URL should
	 * not end with slash "/"
	 * 
	 */
	public static final String PROP_ADDRESS = "serverAddress";
	
	/***
	 * Facet Properties
	 */
	public static final String PROP_FACET = "facet";
	
	public final static List<String> DEFAULT_FACET_LIST = new ArrayList<String>();
	
	static{
		DEFAULT_FACET_LIST.add("");
	}
	
	@DocumentationReferenceMeta
	public final static Map<String, PropertyMD> META = new HashMap<String, PropertyMD>();
	static
	{
		META.put(PROP_ADDRESS, new PropertyMD("http://localhost:0").setDescription("").setCanHaveSubkeys());
		META.put(PROP_FACET, new PropertyMD().setList(false).setDescription("").setCanHaveSubkeys());
	}
	
	
	public List<String> getFacets(){
		List<String> facets = new ArrayList<String>();
		List<String> lst = getListOfValues(PROP_FACET);
		for (String s : lst) {
			facets.add(s.split(":")[1].trim());
		}
		return facets;
	}
	
	
//	/**
//	 * @param prefix
//	 * @param properties
//	 * @param propertiesMD
//	 * @param log
//	 * @throws ConfigurationException
//	 */
//	public WebProperties(String prefix, Properties properties,
//			Map<String, PropertyMD> propertiesMD, Logger log)
//			throws ConfigurationException {
//		super(prefix, properties, propertiesMD, log);
//		// TODO Auto-generated constructor stub
//	}
	
	public UIProperties(Properties props){
		super(PREFIX, props, META, logger);
	}
	

}
