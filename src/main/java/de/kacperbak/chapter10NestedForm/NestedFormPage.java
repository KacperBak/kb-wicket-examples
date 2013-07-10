package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 04.07.13
 */
public class NestedFormPage extends BasePage implements ComponentContext {

    /**
     * The container wraps the personFormPanel so it can be refreshed via ajax!
     */
    private WebMarkupContainer container;

    private NestedPersonFormPanel personFormPanel;

    private PersonListPanel personListPanel;

    public NestedFormPage() {
        add(nestedForm());
        add(personList());
    }

    private Component nestedForm(){
        Form form = new Form("nestedForm"){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                service.addPerson(personFormPanel.getModelObject());
            }
        };
        form.add(container());
        return form;
    }

    private Component container(){
        container = new WebMarkupContainer("container");
        container.add(personFormPanel());
        container.setOutputMarkupPlaceholderTag(true);
        return container;
    }

    private Component personFormPanel(){
        personFormPanel = new NestedPersonFormPanel("personFormPanel", new Model<Person>(new Person("blub", 30, null, 99)));
        return personFormPanel;
    }

    private Component personList(){
        return personListPanel = new PersonListPanel("personList", new Model(service.getPersons()), this);
    }

    @Override
    public void selectPerson(IModel<Person> personModel) {
        personFormPanel.updateFormPanel(personModel);
    }

    @Override
    public Component getComponentForAjaxUpdate() {
        return container;
    }
}
