package de.kacperbak.chapter10SubmitLink;

import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * User: bakka
 * Date: 03.07.13
 */
public class TwoFormsTwoSubmits extends BasePage {

    private IModel<String> firstName;
    private IModel<String> secondName;

    private TextField firstNameTextField;
    private TextField secondNameTextField;
    private Form firstNameForm;
    private Form secondNameForm;

    public TwoFormsTwoSubmits() {
        add(firstForm());
        add(secondForm());
        add(firstNameSubmit());
        add(secondNameSubmit());
    }

    private Component firstForm(){
        firstNameForm = new Form("firstForm");
        firstNameForm.add(firstNameTextField = new TextField("firstNameTextField", firstName = new Model<String>("")));
        firstNameForm.add(firstNameFeedback());
        firstNameTextField.setRequired(true);
        return firstNameForm;
    }

    private Component secondForm(){
        secondNameForm = new Form("secondForm");
        secondNameForm.add(secondNameTextField = new TextField("secondNameTextField", secondName = new Model<String>()));
        secondNameForm.add(secondNameFeedback());
        secondNameTextField.setRequired(true);
        return secondNameForm;
    }

    private Component firstNameSubmit(){
        return new SubmitLink("firstNameSubmit", firstNameForm);
    }

    private Component secondNameSubmit(){
        return new SubmitLink("secondNameSubmit", secondNameForm);
    }

    private Component firstNameFeedback(){
        return new FeedbackPanel("firstNameFeedback", new ComponentFeedbackMessageFilter(firstNameTextField));
    }

    private Component secondNameFeedback(){
        return new FeedbackPanel("secondNameFeedback", new ComponentFeedbackMessageFilter(secondNameTextField));
    }
}
