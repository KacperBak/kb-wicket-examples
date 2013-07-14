package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonFormComponentPanel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 07.07.13
 */
public class PersonFormComponentPanelTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startComponentInPage(new PersonFormComponentPanel("panel", new Model<Person>()));
        tester.assertComponent("panel", PersonFormComponentPanel.class);

    }
}
