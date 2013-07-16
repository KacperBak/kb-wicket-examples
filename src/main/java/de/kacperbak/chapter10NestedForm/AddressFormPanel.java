package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class AddressFormPanel extends GenericPanel<Address> {

    public AddressFormPanel(String id, IModel<Address> model) {
        super(id, model);
        add(form());
    }

    private Component form(){
        return new AddressForm("form", getModel());
    }
}
