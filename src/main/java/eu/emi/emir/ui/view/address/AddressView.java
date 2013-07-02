package eu.emi.emir.ui.view.address;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

import eu.emi.emir.client.EMIRClient;
import eu.emi.emir.ui.EmirUI;
import eu.emi.emir.ui.Styles;
import eu.emi.emir.ui.data.Status;
import eu.emi.emir.ui.view.main.MainView;

public class AddressView extends HorizontalLayout implements View {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "view.address";
	private EMIRClient client = null;

	public AddressView() {

		final TextField txtAddress = new TextField();
		txtAddress.setHeight(33, Unit.PIXELS);
		txtAddress.setStyleName(Styles.ADDRESS_TEXTBOX);
		txtAddress
				.setDescription("EMIR Address, e.g. http://emir.example.org:9127");
		txtAddress
				.setInputPrompt("EMIR Address, e.g. http://emir.example.org:9127");

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
					client = new EMIRClient(address);
					if (client.isReachable()) {
						// Add status method to the client class
						JSONObject status = client.getClientResource()
								.path("/status")
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.get(ClientResponse.class)
								.getEntity(JSONObject.class);

						try {
							if (status.getLong(Status.numberOfEntries) <= 0) {
								Notification
										.show("EMIR server on "
												+ address
												+ " address has ZERO endpoint records - Please try another address!!!",
												Type.ERROR_MESSAGE);

							return;
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						Address.set(address);
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
			}
		});

		addComponent(btn);

		setSpacing(true);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}
}
