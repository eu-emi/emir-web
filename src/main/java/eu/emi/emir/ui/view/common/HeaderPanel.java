/**
 * 
 */
package eu.emi.emir.ui.view.common;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.ui.view.address.Address;

/**
 * @author a.memon
 *
 */
public class HeaderPanel extends VerticalLayout{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TODO: put logo  
	 */
	
	public HeaderPanel() {
		setHeight(null);
		setWidth("100%");
		
		Label l = new Label("EMIR Query Browser");
		
		//TODO: should be able to change the address
		Label conn = new Label("Connected with EMIR on address: "+Address.get());
		
		addComponent(l);
		addComponent(conn);
		
	}
}
