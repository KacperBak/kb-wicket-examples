package de.kacperbak.chapter10formcomponentpanel;

import de.kacperbak.beans.Person;
import de.kacperbak.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * User: bakka
 * Date: 04.07.13
 */
public class FormComponentPage extends BasePage implements PersonListContext {

    /**
     * The container wraps the personFormPanel so it can be refreshed via ajax!
     */
    private WebMarkupContainer container;
    private PersonFormComponentPanel personFormPanel;
    private PersonListPanel personListPanel;
    private Button updatePersonButton;
    private Button cancelButton;
    private Button deleteButton;
    private Button addButton;


    public FormComponentPage() {
        add(formContainer());
        add(personList());
    }

    private Component nestedForm(){
        Form form = new Form("nestedForm"){
            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };
        form.add(personFormPanel());
        form.add(addButton());
        form.add(deleteButton());
        form.add(updateButton());
        form.add(cancelButton());
        return form;
    }

    /**
     * To update a person the form has to be submitted
     * @return
     */
    private Component updateButton(){
        return updatePersonButton = new Button("updateButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
            }
        };
    }

    /**
     * Second button to cancel the form processing and clear the form
     * @return
     */
    private Component cancelButton(){
        cancelButton = new Button("cancelButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                personFormPanel.clearFormValues();
            }
        };
        //Reset default form processing: validation and model update
        cancelButton.setDefaultFormProcessing(false);
        return cancelButton;
    }

    private Component deleteButton(){
        deleteButton = new Button("deleteButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                service.removePerson(personFormPanel.getModelObject());
                personFormPanel.clearFormValues();
            }
        };
        deleteButton.setDefaultFormProcessing(false);
        return deleteButton;
    }

    private Component addButton(){
        addButton = new Button("addButton"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                service.addPerson(personFormPanel.getModelObject());
            }
        };
        return addButton;
    }

    private Component formContainer(){
        container = new WebMarkupContainer("container");
        container.add(nestedForm());
        container.setOutputMarkupPlaceholderTag(true);
        return container;
    }

    private Component personFormPanel(){
        personFormPanel = new PersonFormComponentPanel("personFormPanel", new Model<Person>());
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
