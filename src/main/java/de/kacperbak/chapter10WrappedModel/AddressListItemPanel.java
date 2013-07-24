package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.wrappedbeans.WrappedAddress;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;


/**
 * User: bakka
 * Date: 22.07.13
 */
public class AddressListItemPanel extends GenericPanel<WrappedAddress> {

    public AddressListItemPanel(String id, IModel<WrappedAddress> model) {
        super(id, model);
        add(new CheckBox("checkBox", new PropertyModel<Boolean>(getModel(), "checked")));
        add(new Label("zip", new PropertyModel<WrappedAddress>(model, "address.zip")));
        add(new Label("city", new PropertyModel<WrappedAddress>(model, "address.city")));
        add(new Label("nr", new PropertyModel<WrappedAddress>(model, "address.nr")));
        add(new Label("checkNumber", new PropertyModel<WrappedAddress>(model, "address.checkNumber")));
    }
}
