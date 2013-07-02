package de.kacperbak.chapter9models;

import de.kacperbak.beans.Person;
import de.kacperbak.service.PersonService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class CompoundPropertyModelExample extends WebPage{

    private PersonService service;

    private Person person;

    private CompoundPropertyModel<Person> personModel;

    private Label surnameLabel;

    public CompoundPropertyModelExample() {
        person = service.createDefaultPerson();

        personModel = new CompoundPropertyModel<Person>(person);
        setDefaultModel(personModel);

        /**
         * Get model from the page
         */
        add(new Label("name"));
        add(new Label("surname"));

        /**
         * id of the label
         * is equal to
         * the property expression
         * is equal to
         * html
         */
        add(new Label("address.zip"));

        /**
         * to unbound this you need "bind" method
         * and
         * the reference to the model!
         */
        add(new Label("addressCity", personModel.bind("address.city")));
    }
}
