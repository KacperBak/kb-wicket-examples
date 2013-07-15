package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10.CustomFeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.*;

/**
 * User: bakka
 * Date: 15.07.13
 */
public class NestedPersonForm extends Form<Person> {

    private TextField<String> nameTextField;
    private TextField<Integer> ageTextField;
    private TextField<Integer> checkNumberTextField;

    public NestedPersonForm(String id, IModel<Person> model) {
        super(id, model);
        add(nameTextField());
        add(ageTextField());
        add(checkNumberTextField());
        add(nameFeedback());
        add(ageFeedback());
        add(checkNumberFeedback());
    }

    private Component nameTextField(){
        nameTextField = new TextField<String>("nameTextField", new PropertyModel<String>(getModel(), "person"));
        nameTextField.setType(String.class);
        nameTextField.setRequired(true);
        return nameTextField;
    }

    private Component ageTextField(){
        ageTextField = new TextField<Integer>("ageTextField", new PropertyModel<Integer>(getModel(), "age"));
        ageTextField.setType(Integer.class);
        ageTextField.setRequired(true);
        return ageTextField;
    }

    private Component checkNumberTextField(){
        checkNumberTextField = new TextField<Integer>("checkNumberTextField", new PropertyModel<Integer>(getModel(), "checkNumber"));
        checkNumberTextField.setType(Integer.class);
        return checkNumberTextField;
    }

    private FeedbackPanel nameFeedback(){
        return new CustomFeedbackPanel("nameFeedback", new ComponentFeedbackMessageFilter(nameTextField));
    }

    private FeedbackPanel ageFeedback(){
        return new CustomFeedbackPanel("ageFeedback", new ComponentFeedbackMessageFilter(ageTextField));
    }

    private FeedbackPanel checkNumberFeedback(){
        return new CustomFeedbackPanel("checkNumberFeedback", new ComponentFeedbackMessageFilter(checkNumberTextField));
    }
}
