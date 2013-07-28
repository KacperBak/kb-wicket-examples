package de.kacperbak.chapter10RadioListView;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class RadioAddressListForm extends Form<List<? extends Address>> {

    private RadioGroup<Address> radioGroup;

    private SelectedMainAddressContext context;

    public RadioAddressListForm(String id, IModel<List<? extends Address>> model, SelectedMainAddressContext context) {
        super(id, model);
        this.context = context;
        add(radioGroup());
    }

    private Component radioGroup(){
        radioGroup = new RadioGroup<Address>("radioGroup", new Model<Address>());
        radioGroup.add(radioAddressList());
        return radioGroup;
    }

    private Component radioAddressList(){
        ListView<Address> listView = new ListView<Address>("radioAddressList", getModel()) {
            @Override
            protected void populateItem(ListItem<Address> item) {
                item.add(new RadioAddressListItem("item", item.getModel()));
            }
        };
        return listView;
    }

    @Override
    protected void onSubmit() {
        super.onSubmit();
        context.getSelectedMainAddress(radioGroup.getModelObject());
    }
}
