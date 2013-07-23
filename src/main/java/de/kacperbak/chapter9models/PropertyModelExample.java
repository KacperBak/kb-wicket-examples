package de.kacperbak.chapter9models;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.service.PersonService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class PropertyModelExample extends WebPage{

    private PersonService service;

    private Person person;

    public PropertyModelExample() {
        person = service.createDefaultPerson();
        add(new Label("personName", new PropertyModel<Person>(person, "name")));
        add(new Label("personSurname", new PropertyModel<Person>(person, "surname")));

        //use Person to retrieve the Address data
        add(new Label("addressZip", new PropertyModel(person, "address.zip")));
        add(new Label("addressCity", new PropertyModel<Person>(person, "address.city")));

        //use Address to retrieve the Address data
        add(new Label("addressNr", new PropertyModel<Address>(person.getMainAddress(), "nr")));
    }
}
