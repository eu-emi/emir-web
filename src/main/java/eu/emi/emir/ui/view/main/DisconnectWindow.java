/**
 * 
 */
package eu.emi.emir.ui.view.main;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import eu.emi.emir.ui.EmirUI;

/**
 * @author a.memon
 *
 */
public class DisconnectWindow {
	/**
	 * 
	 */
	private EmirUI ui;
	private final Window subwindow;
	public DisconnectWindow(final MainPresenter presenter) {
		ui = EmirUI.getCurrent();
		subwindow = new Window("EMIR Unreachable");
		subwindow.setModal(true);
		 // Configure the windows layout; by default a VerticalLayout
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        // Add some content; a label and a close-button
        Label message = new Label("EMIR cannot be reached at: "+presenter.getEmirUrl());
        

        Button close = new Button("Try to Reconnect...", new Button.ClickListener() {
           	@Override
			public void buttonClick(ClickEvent event) {
           		Notification.show("Trying to connect", Notification.Type.HUMANIZED_MESSAGE);
				if (presenter.isReachable()) {
					removeWindow();
				}
				
			}
        });
        layout.addComponent(message);
        layout.addComponent(close);
        layout.setComponentAlignment(close, Alignment.TOP_RIGHT);
        
        subwindow.setContent(layout);
        subwindow.setImmediate(true);
        subwindow.setVisible(true);
	}
	
	public Window getWindow(){
		return subwindow;
	}
	
	public void showWindow(){
		ui.addWindow(subwindow);		
	}
	
	public void removeWindow(){
		ui.removeWindow(subwindow);
//		ui.buildMainLayout();
	}
}
