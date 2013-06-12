package eu.emi.emir.ui.vaadin.container;

import java.util.Collection;

import com.vaadin.data.Item;
import com.vaadin.data.Property;

public class JSONObjectItem implements Item{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6546137849576107086L;

	@Override
	public Property getItemProperty(Object id) {
		return null;
	}

	@Override
	public Collection<?> getItemPropertyIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItemProperty(Object id, Property property)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeItemProperty(Object id)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
