package de.kacperbak.chapter9forms;

import de.kacperbak.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class SimpleFormExample extends BasePage {

    public SimpleFormExample() {
        add(simpleForm());
    }

    private Component simpleForm(){
        Form form = new Form("simpleForm"){
            @Override
            protected void onSubmit() {
                System.out.println(service.getPersons());
            }
        };
        return form;
    }
}
