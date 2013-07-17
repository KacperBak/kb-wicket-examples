package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class PersonFormPanelTest extends AbstractWicketTest{

    @Test
    public void testRender() throws Exception {
        IModel<Person> personIModel = new Model<Person>(new Person("", 0, new Address("", "", 0, 0), 0));
        tester.startComponentInPage(new PersonFormPanel("panel", personIModel, null));
        tester.assertComponent("panel", PersonFormPanel.class);
    }
}
