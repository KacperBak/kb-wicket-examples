package de.kacperbak.chapter10RadioListView;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class RadioListViewPage extends BasePage implements PersonListContext, SelectedMainAddressContext {

    private Person currentPerson;

    private IModel<List<? extends Address>> currentAddresses;

    private AddressRadioListFormPanel addressRadioListFormPanel;

    public RadioListViewPage() {
        this.currentAddresses = Model.ofList(new ArrayList<Address>());
        add(personsList());
        add(addressRadioListFormPanel());
    }

    private Component personsList(){
        IModel persons = Model.ofList(service.getPersonsWithAddresses());
        return new PersonListPanel("personsList", persons, this);
    }

    private Component addressRadioListFormPanel(){
        addressRadioListFormPanel = new AddressRadioListFormPanel("addressRadioListFormPanel", currentAddresses, this);
        addressRadioListFormPanel.setOutputMarkupId(true);
        return addressRadioListFormPanel;
    }

    @Override
    public Component getComponentForAjaxUpdate() {
        return addressRadioListFormPanel;
    }

    @Override
    public void selectPerson(IModel<Person> personModel) {
        currentPerson = personModel.getObject();
        currentAddresses.setObject(currentPerson.getAddresses());
    }

    @Override
    public void getSelectedMainAddress(Address address) {
        service.setMainAddress(currentPerson, address);
    }
}
