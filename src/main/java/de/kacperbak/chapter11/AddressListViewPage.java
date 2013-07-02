package de.kacperbak.chapter11;

import de.kacperbak.beans.Address;
import de.kacperbak.chapter9forms.AddressForm;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * User: bakka
 * Date: 19.06.13
 */
public class AddressListViewPage extends BasePage{

    private List<Address> addresses;
    private IModel<Address> currentSelectedAddress;

    private AddressForm addressForm;

    public AddressListViewPage() {
        this.addresses = service.getAddresses();
        this.currentSelectedAddress = new Model<Address>(new Address("","",0,0));
        add(addresses());
        add(addressForm());
    }

    private Component addresses(){
        ListView<Address> listView = new ListView<Address>("addresses", addresses) {
            @Override
            protected void populateItem(ListItem<Address> item) {
                item.add(new AddressItemPanel("addressItemPanel", item.getModel()){

                    @Override
                    public void selectCurrentAddress(IModel<Address> currentAddress) {
                        addressForm.setModel(currentAddress);
                    }

                    @Override
                    public void addAjaxRequestTarget(AjaxRequestTarget target) {
                        if(target != null){
                            target.add(addressForm);
                        }
                    }
                });
            }
        };
        return listView;
    }

    private Component addressForm(){
        addressForm = new AddressForm("addressForm", currentSelectedAddress);
        addressForm.setOutputMarkupPlaceholderTag(true);
        return addressForm;
    }
}
