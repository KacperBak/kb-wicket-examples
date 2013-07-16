package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.chapter10.CustomFeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;


/**
 * User: bakka
 * Date: 16.07.13
 */
public class AddressForm extends Form<Address> {

    private TextField<Integer> zipTextField;
    private TextField<String> cityTextField;
    private TextField<String> nrTextField;
    private TextField<Integer> checkNumberTextField;

    public AddressForm(String id, IModel<Address> model) {
        super(id, model);
        add(zipTextField());
        add(cityTextField());
        add(nrTextField());
        add(checkNumberTextField());
        add(new CustomFeedbackPanel("zipFeedback", new ComponentFeedbackMessageFilter(zipTextField)));
        add(new CustomFeedbackPanel("cityFeedback", new ComponentFeedbackMessageFilter(cityTextField)));
        add(new CustomFeedbackPanel("nrFeedback", new ComponentFeedbackMessageFilter(nrTextField)));
        add(new CustomFeedbackPanel("checkNumberFeedback", new ComponentFeedbackMessageFilter(checkNumberTextField)));
    }

    private Component zipTextField(){
        zipTextField = new RequiredTextField<Integer>("zipTextField", new PropertyModel<Integer>(getModel(), "zip"));
        return zipTextField;
    }

    private Component cityTextField(){
        cityTextField = new RequiredTextField<String>("cityTextField", new PropertyModel<String>(getModel(), "city"));
        return cityTextField;
    }

    private Component nrTextField(){
        nrTextField = new RequiredTextField<String>("nrTextField", new PropertyModel<String>(getModel(), "nr"));
        return nrTextField;
    }

    private Component checkNumberTextField(){
        checkNumberTextField = new RequiredTextField<Integer>("checkNumberTextField", new PropertyModel<Integer>(getModel(), "checkNumber"));
        return checkNumberTextField;
    }
}
