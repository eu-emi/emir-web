package eu.emi.emir.ui.view.address;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.Styles;
import eu.emi.emir.ui.view.main.MainView;

public class AddressView extends FormLayout implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "view.address";

	public AddressView() {
		Label lbl = new Label("EMIR Server Address:");
		
		addComponent(lbl);
		
		
		
		final TextField txtAddress = new TextField();
		txtAddress.setStyleName(Styles.ADDRESS_TEXTBOX);
		
		addComponent(txtAddress);
		Button btn = new Button("Go >", new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8110860927970444345L;

			@Override
			public void buttonClick(ClickEvent event) {
				String address = txtAddress.getValue();
				if (!(address.isEmpty() && address == null)) {
					Address.set(txtAddress.getValue());
				}

				if (new EMIRClient(address).isReachable()) {
					EmirUI.getCurrent().getNavigator()
							.addView(MainView.VIEW_NAME, new MainView());
					EmirUI.getCurrent().getNavigator()
							.navigateTo(MainView.VIEW_NAME);
				} else {
					Address.unset();
					Notification.show("EMIR Server is not reachable on: "
							+ address, Type.ERROR_MESSAGE);
				}
			}
		});
		addComponent(btn);		
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}
}
