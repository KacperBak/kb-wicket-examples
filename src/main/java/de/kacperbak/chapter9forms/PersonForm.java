package de.kacperbak.chapter9forms;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.service.PersonService;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class PersonForm extends Form<Person> {

    private TextField<String> name;
    private TextField age;
    private TextField checkNumber;
    private Label status;

    private PersonService service;
    private IModel<Address> currentAddress;

    public PersonForm(String id, PersonService service, IModel<Address> currentAddress) {
        super(id);
        this.service = service;
        this.currentAddress = currentAddress;

        textFields();
        add(name);
        add(age);
        add(checkNumber);
        add(status = new Label("status", Model.of("waiting ...")));
        add(addresses());
    }

    private void textFields(){
        //input
        name = new TextField("name", Model.of(""));
        age = new TextField("age", Model.of(""));
        checkNumber = new TextField("checkNumber", Model.of(""));

        //requirements
        name.setRequired(true);
        age.setRequired(true);
        checkNumber.setRequired(true);
    }

    private Component addresses(){
        List<Address> choices = service.getAddresses();
        ChoiceRenderer<Address> addressRenderer = new ChoiceRenderer<Address>("city", "zip");
        DropDownChoice<Address> dropDownChoice = new DropDownChoice<Address>("addresses", currentAddress, choices, addressRenderer){
            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        };
        return dropDownChoice;
    }

    @Override
    protected void onSubmit() {
        String personName = name.getModelObject();
        int personAge = Integer.parseInt(age.getDefaultModelObjectAsString());
        int personNumber = Integer.parseInt(checkNumber.getDefaultModelObjectAsString());
        Address personAddress = currentAddress.getObject();

        service.addPerson(personName,personAge,personAddress,personNumber);
        status.setDefaultModel(Model.of(service.getPersons().toString()));
    }
}
