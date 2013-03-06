/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

/**
 * @author a.memon
 *
 */
@SuppressWarnings("serial")
public class ListingView extends VerticalLayout implements View{

	public static final String VIEW_NAME = "view.listing";
	
	ListingPresenter presenter;
	
	EndpointTable t;
	
	/**
	 * 
	 */
	public ListingView() {
		System.out.println("listing view called");
		presenter = new ListingPresenter(this);
		generateUI();
	}
	
	/**
	 * 
	 */
	private void generateUI() {
		setSizeFull();
		t = new EndpointTable();		
		addComponent(t);
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	public void updateTable(){
		t.updateTable();
	}

	

}
