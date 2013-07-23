package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class AddressListItemPanel extends GenericPanel<Address> {

    public AddressListItemPanel(String id, IModel<Address> model) {
        super(id, new CompoundPropertyModel<Address>(model));
        add(new Label("zip"));
        add(new Label("city"));
        add(new Label("nr"));
        add(new Label("checkNumber"));
    }

}
