package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.BasePage;
import de.kacperbak.wrappedbeans.WrappedAddress;
import de.kacperbak.wrappedbeans.Wrapper;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.List;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class WrappedModelPage extends BasePage implements PersonListContext, AddressListFormContext{

    private IModel<Person> selectedPerson;
    private IModel selectedAddresses;

    private AddressListFormPanel addressListFormPanel;

    public WrappedModelPage() {
        this.selectedAddresses = Model.ofList(Arrays.asList(new WrappedAddress(null)));
        add(personsList());
        add(addressList());
    }

    private Component personsList(){
        IModel persons = Model.ofList(service.getPersonsWithAddresses());
        return new PersonListPanel("personsList", persons, this);
    }

    private Component addressList(){
        addressListFormPanel = new AddressListFormPanel("addressList", selectedAddresses, this);
        addressListFormPanel.setOutputMarkupId(true);
        return addressListFormPanel;
    }

    @Override
    public Component getComponentForAjaxUpdate() {
        return addressListFormPanel;
    }

    @Override
    public void removeSelectedAddresses(List<WrappedAddress> selectedAddresses) {
        for(WrappedAddress wrappedAddress : selectedAddresses){
            if(wrappedAddress.getChecked()){
                service.removeAddressFromPerson(selectedPerson.getObject(), wrappedAddress.getAddress());
            }
        }
        List<Address> updatedAddresses = service.getAddressesFromPerson(selectedPerson.getObject());
        List<WrappedAddress> wrappedAddresses = Wrapper.wrappedAddresses(updatedAddresses);
        this.selectedAddresses.setObject(wrappedAddresses);
    }

    @Override
    public void selectPerson(IModel<Person> personModel) {
        selectedPerson = personModel;
        List<Address> addresses = personModel.getObject().getAddresses();
        List<WrappedAddress> wrappedAddresses = Wrapper.wrappedAddresses(addresses);
        this.selectedAddresses.setObject(wrappedAddresses);
    }
}
