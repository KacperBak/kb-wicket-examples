package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class AddressListPanel extends Panel {

    private IModel<List<Address>> addressListModel;

    public AddressListPanel(String id, IModel<List<Address>> addressListModel) {
        super(id);
        this.addressListModel = addressListModel;
        add(addressList());
    }

    private Component addressList(){
        ListView<Address> addressListView = new ListView<Address>("addressList", addressListModel) {
            @Override
            protected void populateItem(ListItem<Address> item) {
                item.add(new AddressListItemPanel("item", item.getModel()));
            }
        };
        return addressListView;
    }
}
