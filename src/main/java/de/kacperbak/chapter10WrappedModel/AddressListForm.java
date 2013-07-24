package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.wrappedbeans.WrappedAddress;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 23.07.13
 */
public class AddressListForm extends Form<List<WrappedAddress>> {

    public AddressListForm(String id, IModel<List<WrappedAddress>> model) {
        super(id, model);
        add(addressList());
    }

    private Component addressList(){
        ListView<WrappedAddress> addressListView = new ListView<WrappedAddress>("addressList", getModel()) {
            @Override
            protected void populateItem(ListItem<WrappedAddress> item) {
                item.add(new AddressListItemPanel("item", item.getModel()));
            }
        };
        return addressListView;
    }
}
