package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class PersonFormPanel extends GenericPanel<Person> {

    private IModel<Person> personModel;
    private PersonForm personForm;
    private PersonFormContext context;

    public PersonFormPanel(String id, IModel<Person> model, PersonFormContext personFormContext) {
        super(id, model);
        this.personModel = model;
        this.context = personFormContext;
        add(form());
    }

    private Component form(){
        personForm = new PersonForm("form", getModel());
        personForm.add(addressFormPanel());
        personForm.add(update());
        personForm.add(create());
        personForm.add(delete());
        return personForm;
    }

    private Component addressFormPanel(){
        return new AddressFormPanel("addressFormPanel", new PropertyModel<Address>(getModel(), "address"));
    }

    private Component update(){
        return new Button("update"){
            @Override
            public void onSubmit() {
                super.onSubmit();
            }
        };
    }

    private Component create(){
        return new Button("create"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                context.getService().addPerson(personModel.getObject());
            }
        };
    }

    private Component delete(){
        return new Button("delete"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                context.getService().removePerson(personModel.getObject());
            }
        };
    }
}
