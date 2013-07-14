package de.kacperbak.chapter10formcomponentpanel;

import de.kacperbak.beans.Address;
import de.kacperbak.chapter10.CustomFeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.PatternValidator;


/**
 * User: bakka
 * Date: 04.07.13
 */
public class AddressFormComponentPanel extends FormComponentPanel<Address> {

    private TextField<Integer> zipTextField;
    private TextField<String> cityTextField;
    private TextField<String> nrTextField;
    private TextField<Integer> checkNumberTextField;

    public AddressFormComponentPanel(String id, IModel<Address> model) {
        super(id, model);
        add(zipTextField());
        add(cityTextField());
        add(nrTextField());
        add(checkNumberTextField());
        add(zipFeedback());
        add(cityFeedback());
        add(nrFeedback());
        add(checkNumberFeedback());
    }

    private Component zipTextField(){
        zipTextField = new TextField<Integer>("zipTextField", new Model<Integer>());
        zipTextField.setType(Integer.class);
        zipTextField.setRequired(true);
        zipTextField.add(new ZipValidator());
        return zipTextField;
    }

    private Component cityTextField(){
        cityTextField = new TextField<String>("cityTextField", new Model<String>());
        cityTextField.setType(String.class);
        cityTextField.setRequired(true);
        cityTextField.add(new CityValidator());
        return cityTextField;
    }

    private Component nrTextField(){
        nrTextField = new TextField<String>("nrTextField", new Model<String>());
        nrTextField.setType(String.class);
        nrTextField.setRequired(true);
        nrTextField.add(new PatternValidator("[0-9]*[a-zA-Z]?"));
        return nrTextField;
    }

    private Component checkNumberTextField(){
        checkNumberTextField = new TextField<Integer>("checkNumberTextField", new Model<Integer>(0));
        checkNumberTextField.setType(Integer.class);
        checkNumberTextField.add(new CheckNumberValidator());
        return checkNumberTextField;
    }
    
    private Component zipFeedback(){
        return new CustomFeedbackPanel("zipFeedback", new ComponentFeedbackMessageFilter(zipTextField));
    }
    
    private Component cityFeedback(){
        return new CustomFeedbackPanel("cityFeedback", new ComponentFeedbackMessageFilter(cityTextField));
    }
    
    private Component nrFeedback(){
        return new CustomFeedbackPanel("nrFeedback", new ComponentFeedbackMessageFilter(nrTextField));
    }
    
    private Component checkNumberFeedback(){
        return new CustomFeedbackPanel("checkNumberFeedback", new ComponentFeedbackMessageFilter(checkNumberTextField));
    }

    private class ZipValidator implements IValidator<Integer>{
        @Override
        public void validate(IValidatable<Integer> validatable) {
            int value = validatable.getValue();
            if(value < 0){
                ValidationError error = new ValidationError(this);
                validatable.error(error);
            }
        }
    }

    private class CityValidator implements IValidator<String>{
        @Override
        public void validate(IValidatable<String> validatable) {
            String value = validatable.getValue();
            if(value.length() < 5){
                validatable.error(new ValidationError(this));
            }
        }
    }

    private class CheckNumberValidator implements IValidator<Integer>{
        @Override
        public void validate(IValidatable<Integer> validatable) {
            int value = validatable.getValue();
            if(value < 100){
                ValidationError error = new ValidationError(this);
                error.setMessage("CheckNumber has to be larger than 100!");
                validatable.error(error);
            }
        }
    }

    /**
     * IMPORTANT: Enter this method after form validation has succeeded!!!
     * REMEMBER:
     * 1. validation
     * 2. model update <-- THATs the point
     * 3. callbacks: onSubmit, onError
     *
     * IMPORTANT this method has to be overriden if FormComponentPanel.class is used
     * to extract the values
     */
    @Override
    protected void convertInput() {
        //get converted input from textFields
        //getmodelObject
        int zip = zipTextField.getConvertedInput();
        String city = cityTextField.getConvertedInput();
        String number = nrTextField.getConvertedInput();
        int check = checkNumberTextField.getConvertedInput();

        //set converted input to model of component
        setConvertedInput(new Address(city,number,zip,check));
    }

    public void updateFormPanel(IModel<Address> model){
        setModel(model);
        Address address = model.getObject();
        cityTextField.setModel(new Model<String>(address.getCity()));
        zipTextField.setModel(new Model<Integer>(address.getZip()));
        nrTextField.setModel(new Model<String>(address.getNr()));
        checkNumberTextField.setModel(new Model<Integer>(address.getCheckNumber()));
    }

    public void clearFormValues(){
        setModel(new Model<Address>());
        cityTextField.setModel(new Model<String>());
        zipTextField.setModel(new Model<Integer>());
        nrTextField.setModel(new Model<String>());
        checkNumberTextField.setModel(new Model<Integer>());
    }


}
