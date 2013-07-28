package de.kacperbak.chapter10RadioListView;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class AddressRadioListFormPanel extends GenericPanel<List<? extends Address>> {

    private SelectedMainAddressContext context;

    public AddressRadioListFormPanel(String id, IModel<List<? extends Address>> model, SelectedMainAddressContext context) {
        super(id, model);
        this.context = context;
        add(addressRadioListForm());
    }

    private Component addressRadioListForm(){
        return new RadioAddressListForm("form", getModel(), context);
    }
}
