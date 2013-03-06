/**
 * 
 */
package eu.emi.emir.ui;

/**
 * @author a.memon
 *
 */
public class ApplicationState {
	
	private static volatile String url = null;
	
	public static void setServerAddress(String emirUrl){
		if (url == null) {
			url = emirUrl;
		}
	}

	public static String getServerAddress(){
		return url;
	}
	
}
