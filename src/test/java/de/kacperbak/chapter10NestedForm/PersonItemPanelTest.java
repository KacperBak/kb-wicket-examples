package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 08.07.13
 */
public class PersonItemPanelTest extends AbstractWicketTest{

    private static final String PANEL = "panel";

    @Test
    public void testRender(){
        Address address = new Address("city", "46a", 80992, 1000);
        Person person = new Person("kacper", 30, address, 2000);
        PersonItemPanel panel = new PersonItemPanel(PANEL, new Model<Person>(person), null);
        tester.startComponentInPage(panel);
        tester.assertComponent(PANEL, PersonItemPanel.class);
    }
}
