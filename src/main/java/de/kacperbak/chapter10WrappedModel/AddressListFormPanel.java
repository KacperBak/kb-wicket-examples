package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.wrappedbeans.WrappedAddress;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class AddressListFormPanel extends GenericPanel<List<WrappedAddress>> {

    private AddressListFormContext context;

    public AddressListFormPanel(String id, IModel<List<WrappedAddress>> addressListModel, AddressListFormContext context) {
        super(id, addressListModel);
        this.context = context;
        add(addressListForm());
    }

    private Component addressListForm(){
        return new AddressListForm("form", getModel()){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                context.removeSelectedAddresses(getModelObject());
            }
        };
    }
}
