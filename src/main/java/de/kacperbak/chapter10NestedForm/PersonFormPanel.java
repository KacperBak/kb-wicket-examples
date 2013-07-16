package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class PersonFormPanel extends GenericPanel<Person> {

    private PersonForm personForm;

    public PersonFormPanel(String id, IModel<Person> model) {
        super(id, model);
        add(form());
    }

    private Component form(){
        personForm = new PersonForm("form", getModel());
        personForm.add(addressFormPanel());
        return personForm;
    }

    private Component addressFormPanel(){
        return new AddressFormPanel("addressFormPanel", new PropertyModel<Address>(getModel(), "address"));
    }
}
