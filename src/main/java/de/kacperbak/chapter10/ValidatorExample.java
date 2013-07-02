package de.kacperbak.chapter10;

import de.kacperbak.beans.Address;
import de.kacperbak.pages.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * User: bakka
 * Date: 30.06.13
 */
public class ValidatorExample extends BasePage{

    private IModel<List<? extends Address>> addresses;

    private FormComponent<Integer> checkNumberTextField;
    private TextField cityTextField;
    private FormComponent<Integer> zipTextField;
    private TextField nrTextField;

    public ValidatorExample() {
        addresses = Model.ofList(service.getAddresses());
        add(addresses());
        add(form());
        add(feedbackMessage());
    }

    private Component addresses(){
        ListView<Address> listView = new ListView<Address>("addresses", addresses) {
            @Override
            protected void populateItem(ListItem<Address> item) {
                Address address = item.getModelObject();
                item.add(new Label("checkNumber", Model.of(address.getCheckNumber())));
                item.add(new Label("city", Model.of(address.getCity())));
                item.add(new Label("zip", Model.of(address.getZip())));
                item.add(new Label("nr", Model.of(address.getNr())));
            }
        };
        return listView;
    }

    private Component form(){
        Form<Address> form = new Form<Address>("form"){
            @Override
            protected void onSubmit() {
                addAddress();
                clearInputFields();
            }
        };
        form.add(checkNumberTextField());
        form.add(cityTextField());
        form.add(cityFieldFeedback());
        form.add(zipTextField());
        form.add(nrTextField());
        return form;
    }

    private void addAddress(){
        //extract values
        int checkNumber = extractIntegerNumberFromTextField(checkNumberTextField.getConvertedInput());
        String city = cityTextField.getDefaultModelObjectAsString();
        int zip = extractIntegerNumberFromTextField(zipTextField.getModelObject());
        String nr = nrTextField.getDefaultModelObjectAsString();

        //call service
        service.addAddress(new Address(city,nr,zip,checkNumber));
    }

    /**
     * IMPORTANT
     * getConvertedInput() and getModelObject()
     * returns type T from FormComponent<T> or TextField<T>
     */
    private int extractIntegerNumberFromTextField(Integer integer){
        return (integer == null) ? 0 : integer;
    }

    private void clearInputFields(){
        checkNumberTextField.setModel(new Model<Integer>());
        cityTextField.setModel(new Model<String>());
        zipTextField.setModel(new Model<Integer>());
        nrTextField.setModel(new Model<String>());
    }

    private Component checkNumberTextField(){
        /**
         * IMPORTANT
         * Conversion from TextField INPUT-VALUE to wicket Model<Integer> inferred
         */
        checkNumberTextField = new TextField("checkNumberTextField", new Model<Integer>());
        checkNumberTextField.setRequired(true);
        return checkNumberTextField;
    }

    private Component cityTextField(){
        cityTextField = new TextField("cityTextField", new Model<String>());
        cityTextField.add(new MemmingenCityValidator());
        cityTextField.setRequired(true);
        return cityTextField;
    }

    /**
     * IMPORTANT
     * Set explicit conversion from TextField INPUT-VALUE to WicketModel Model<Integer> -> setTyp(T)
     */
    private Component zipTextField(){
        zipTextField = new TextField("zipTextField", new Model<Integer>()).setType(Integer.class);
        zipTextField.add(new MemmingenZipValidator());
        return zipTextField;
    }

    private Component nrTextField(){
        nrTextField = new TextField("nrTextField", Model.of(""));
        return nrTextField;
    }

    /**
     * Catches all error messages from all validators
     * @return
     */
    private Component feedbackMessage(){
        FeedbackPanel panel = new FeedbackPanel("feedbackMessage");
        return panel;
    }

    /**
     * Cause ComponentFeedbackMessageFilter is used, only cityTextField messages are displayed
     * @return
     */
    private Component cityFieldFeedback(){
        return new CustomFeedbackPanel("cityFieldFeedback", new ComponentFeedbackMessageFilter(cityTextField));
    }
}
