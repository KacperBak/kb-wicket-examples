package de.kacperbak.chapter9forms;

import de.kacperbak.beans.Address;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class PersonPage extends BasePage {

    private IModel<Address> currentAddress;

    public PersonPage() {
        currentAddress = Model.of(service.getAddresses().get(0));
        add(new PersonForm("personForm", service, currentAddress));
        add(new AddressForm("addressForm", currentAddress));
    }
}
