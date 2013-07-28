package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.BasePage;
import de.kacperbak.service.PersonService;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * User: bakka
 * Date: 14.07.13
 */
public class NestedFormPage extends BasePage implements PersonListContext, PersonFormContext {

    private WebMarkupContainer container;
    private PersonFormPanel personFormPanel;
    private IModel<Person> currentSelectedPerson;

    public NestedFormPage() {
        this.currentSelectedPerson = new Model<Person>();
        add(personsList());
        add(container());
    }

    private Component personsList(){
        return new PersonListPanel("personsList", new Model(service.getPersons()), this);
    }

    private Component personFormPanel(){
        personFormPanel = new PersonFormPanel("personFormPanel", new CompoundPropertyModel<Person>(currentSelectedPerson), this);
        return personFormPanel;
    }

    private Component container(){
        container = new WebMarkupContainer("container");
        container.add(personFormPanel());
        container.setOutputMarkupId(true);
        return container;
    }

    @Override
    public Component getComponentForAjaxUpdate() {
        return container;
    }

    @Override
    public void selectPerson(IModel<Person> personModel) {
        currentSelectedPerson.setObject(personModel.getObject());
    }

    @Override
    public PersonService getService() {
        return service;
    }
}
