package de.kacperbak.chapter10RadioListView;

import de.kacperbak.beans.Address;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class RadioAddressListItem extends GenericPanel<Address> {

    public RadioAddressListItem(String id, IModel<Address> model) {
        super(id, model);
        add(new Radio<Address>("radio", model));
        add(new Label("zip", getModelObject().getZip()));
        add(new Label("city", getModelObject().getCity()));
        add(new Label("nr", getModelObject().getNr()));
        add(new Label("checkNumber", getModelObject().getCheckNumber()));
    }
}
