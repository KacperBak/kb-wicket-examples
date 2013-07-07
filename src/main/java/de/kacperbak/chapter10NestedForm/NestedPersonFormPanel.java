package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.chapter10.CustomFeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * User: bakka
 * Date: 07.07.13
 */
public class NestedPersonFormPanel extends FormComponentPanel<Person> {

    private TextField<String> nameTextField;
    private TextField<Integer> ageTextField;
    private TextField<Integer> checkNumberTextField;
    private NestedAddressFormPanel addressFormPanel;

    public NestedPersonFormPanel(String id, IModel<Person> model) {
        super(id, model);
        add(nameTextField());
        add(ageTextField());
        add(checkNumberTextField());
        add(nameFeedback());
        add(ageFeedback());
        add(checkNumberFeedback());
        add(addressFormPanel());
    }

    private Component nameTextField(){
        nameTextField = new TextField<String>("nameTextField", new Model<String>());
        nameTextField.setType(String.class);
        nameTextField.setRequired(true);
        return nameTextField;
    }

    private Component ageTextField(){
        ageTextField = new TextField<Integer>("ageTextField", new Model<Integer>());
        ageTextField.setType(Integer.class);
        ageTextField.setRequired(true);
        return ageTextField;
    }

    private Component checkNumberTextField(){
        checkNumberTextField = new TextField<Integer>("checkNumberTextField", new Model<Integer>());
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

    private Component addressFormPanel(){
        return addressFormPanel = new NestedAddressFormPanel("addressFormPanel", new Model<Address>());
    }

    @Override
    protected void convertInput() {
        String name = nameTextField.getConvertedInput();
        int age = ageTextField.getConvertedInput();
        int check = checkNumberTextField.getConvertedInput();
        Address address = addressFormPanel.getConvertedInput();

        setConvertedInput(new Person(name, age, address, check));
    }
}
