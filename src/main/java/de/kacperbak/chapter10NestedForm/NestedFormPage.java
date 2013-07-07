package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 04.07.13
 */
public class NestedFormPage extends BasePage {

    private NestedPersonFormPanel personFormPanel;

    public NestedFormPage() {
        add(nestedForm());
    }

    private Component nestedForm(){
        Form form = new Form("nestedForm"){
            @Override
            protected void onSubmit() {
                super.onSubmit();
                service.addPerson(personFormPanel.getModelObject());
                printPersons(service.getPersons());
            }
        };
        form.add(personFormPanel = new NestedPersonFormPanel("personFormPanel", new Model<Person>(null)));
        return form;
    }

    private void printPersons(List<Person> personList){
        for(Person person : personList){
            System.out.println(person);
        }
    }

    private void printAddresses(List<Address> addressList){
        for (Address address : addressList){
            System.out.println(address);
        }
    }
}
