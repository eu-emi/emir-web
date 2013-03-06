/**
 * 
 */
package eu.emi.emir.ui.view.common;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author a.memon
 *
 */
public class HeaderPanel extends HorizontalLayout{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public HeaderPanel() {
		setHeight(null);
		setWidth("100%");
		
		Label l = new Label("EMIR Query Browser");
		addComponent(l);		
		
	}
}
