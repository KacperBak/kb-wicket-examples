package de.kacperbak.chapter9forms;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class AddressForm extends Form<Address> {

    private TextField<Address> city;
    private TextField<Address> zip;
    private TextField<Address> nr;
    private TextField<Address> checkNumber;

    public AddressForm(String id, IModel<Address> currentAddress) {
        super(id, new CompoundPropertyModel<Address>(currentAddress));
        add(city());
        add(zip());
        add(nr());
        add(checkNumber());
    }

    private Component city(){
        city = new TextField<Address>("city");
        city.setEnabled(false);
        return city;
    }

    private Component zip(){
        zip = new TextField<Address>("zip");
        zip.setEnabled(false);
        return zip;
    }

    private Component nr(){
        nr = new TextField<Address>("nr");
        nr.setEnabled(false);
        return nr;
    }

    private Component checkNumber(){
        checkNumber = new TextField<Address>("checkNumber");
        checkNumber.setEnabled(false);
        return checkNumber;
    }
}
