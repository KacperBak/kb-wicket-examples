package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 04.07.13
 */
public class NestedFormPage extends BasePage {

    private NestedAddressFormPanel addressFormPanel;

    public NestedFormPage() {
        add(nestedForm());
    }

    private Component nestedForm(){
        Form form = new Form("nestedForm"){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                service.addAddress(addressFormPanel.getModelObject());
                printAddresses(service.getAddresses());
            }
        };
//        Address address = new Address("MM", "999", 88888, 609);
        Address address = null;
        form.add(addressFormPanel = new NestedAddressFormPanel("addressFormPanel", new Model<Address>(address)));
        return form;
    }

    private void printAddresses(List<Address> addressList){
        for (Address address : addressList){
            System.out.println(address);
        }
    }
}
