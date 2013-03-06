/**
 * 
 */
package eu.emi.emir.ui.data;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

/**
 * Model for endpoint information
 * 
 * @author a.memon
 *
 */
public class Endpoint {
	private String url;
	private String expireOn;
	private String type;
	private String serviceName;
	private List<String> capabilities;
	private JSONObject detailedRawInfo;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the expireOn
	 */
	public String getExpireOn() {
		return expireOn;
	}
	/**
	 * @param expireOn the expireOn to set
	 */
	public void setExpireOn(String expireOn) {
		this.expireOn = expireOn;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the capabilities
	 */
	public List<String> getCapabilities() {
		return capabilities;
	}
	/**
	 * @param capabilities the capabilities to set
	 */
	public void setCapabilities(List<String> capabilities) {
		this.capabilities = capabilities;
	}
	/**
	 * @return the detailedRawInfo
	 */
	public JSONObject getDetailedRawInfo() {
		return detailedRawInfo;
	}
	/**
	 * @param detailedRawInfo the detailedRawInfo to set
	 */
	public void setDetailedRawInfo(JSONObject detailedRawInfo) {
		this.detailedRawInfo = detailedRawInfo;
	}
	
	
}
