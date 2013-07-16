package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.chapter10formcomponentpanel.PersonListPanel;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * User: bakka
 * Date: 14.07.13
 */
public class NestedFormPage extends BasePage implements PersonListContext {

    private WebMarkupContainer container;
    private NestedPersonForm personForm;
    private IModel<Person> currentSelectedPerson;

    public NestedFormPage() {
        this.currentSelectedPerson = new Model<Person>();
        add(personsList());
        add(container());
    }

    private Component personsList(){
        return new PersonListPanel("personsList", new Model(service.getPersons()), this);
    }

    private Component personForm(){
        personForm = new NestedPersonForm("personForm", new CompoundPropertyModel<Person>(currentSelectedPerson)){
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };
        personForm.setOutputMarkupPlaceholderTag(true);
        return personForm;
    }

    private Component container(){
        container = new WebMarkupContainer("container");
        container.add(personForm());
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
}
