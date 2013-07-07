package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Person;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 07.07.13
 */
public class NestedPersonFormPanelTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startComponentInPage(new NestedPersonFormPanel("panel", new Model<Person>()));
        tester.assertComponent("panel", NestedPersonFormPanel.class);

    }
}
