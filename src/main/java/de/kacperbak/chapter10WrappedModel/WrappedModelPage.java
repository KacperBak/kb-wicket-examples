package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class WrappedModelPage extends BasePage implements PersonListContext{

    private IModel<Person> currentSelectedPerson;

    private AddressListPanel addressListPanel;

    public WrappedModelPage() {
        this.currentSelectedPerson = new Model<Person>();
        add(personsList());
        add(addressList());
    }

    private Component personsList(){
        IModel persons = Model.ofList(service.getPersonsWithAddresses());
        return new PersonListPanel("personsList", persons, this);
    }

    private Component addressList(){
        addressListPanel = new AddressListPanel("addressList", new PropertyModel<List<Address>>(currentSelectedPerson, "addresses"));
        addressListPanel.setOutputMarkupId(true);
        return addressListPanel;
    }

    @Override
    public Component getComponentForAjaxUpdate() {
        return addressListPanel;
    }

    @Override
    public void selectPerson(IModel<Person> personModel) {
        currentSelectedPerson.setObject(personModel.getObject());
    }
}
