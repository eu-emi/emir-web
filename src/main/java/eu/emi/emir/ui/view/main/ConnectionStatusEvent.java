/**
 * 
 */
package eu.emi.emir.ui.view.main;

/**
 * @author a.memon
 *
 */
public class ConnectionStatusEvent {
	private Boolean connectionStatus = false;

	/**
	 * @return the connectionStatus
	 */
	public Boolean isConnected() {
		return connectionStatus;
	}

	/**
	 * @param connectionStatus the connectionStatus to set
	 */
	public void setConnectionStatus(Boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
}
