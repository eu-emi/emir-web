/**
 * 
 */
package eu.emi.emir.ui.view.listing;

import com.google.common.eventbus.Subscribe;

import eu.emi.emir.ui.EmirUI;

/**
 * 
 * The presenter class knows about the data and the view too
 * @author a.memon
 *
 */
public class ListingPresenter {
	
	EmirUI ui;
	ListingView view;
	/**
	 * 
	 */
	public ListingPresenter() {
		
	}
	
	
		
	/**
	 * @param listingView
	 */
	public ListingPresenter(ListingView listingView) {
		ui = EmirUI.getCurrent();
		ui.getEventBus().register(this);
		this.view = listingView;
	}



	@Subscribe
	public void handleListingViewEvent(ListingViewEvent e){
		view.updateTable();
	}
}
