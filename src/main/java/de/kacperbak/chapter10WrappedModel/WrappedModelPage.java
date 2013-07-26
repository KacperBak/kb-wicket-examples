package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.pages.BasePage;
import de.kacperbak.wrappedbeans.WrappedAddress;
import de.kacperbak.wrappedbeans.WrappedPerson;
import de.kacperbak.wrappedbeans.Wrapper;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class WrappedModelPage extends BasePage implements WrappedPersonContext, AddressListFormContext{

    private IModel<WrappedPerson> currentSelectedPerson;

    private AddressListFormPanel addressListFormPanel;

    public WrappedModelPage() {
        this.currentSelectedPerson = new Model<WrappedPerson>();
        add(personsList());
        add(addressList());
    }

    private Component personsList(){
        IModel persons = Model.ofList(service.getPersonsWithAddresses());
        return new WrappedPersonListPanel("personsList", persons, this);
    }

    private Component addressList(){
        addressListFormPanel = new AddressListFormPanel("addressList", new PropertyModel<List<WrappedAddress>>(currentSelectedPerson, "wrappedAddresses"), this);
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
            service.removeAddressFromPerson(currentSelectedPerson.getObject().getPerson(), wrappedAddress.getAddress());
        }
    }

    @Override
    public void selectPerson(IModel<WrappedPerson> personModel) {
        currentSelectedPerson.setObject(personModel.getObject());
    }
}
