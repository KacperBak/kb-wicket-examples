package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class AddressFormPanelTest extends AbstractWicketTest{

    @Test
    public void testRender() throws Exception {
        IModel<Address> model = new Model<Address>(new Address("", "", 0, 0));
        tester.startComponentInPage(new AddressFormPanel("panel", model));
        tester.assertComponent("panel", AddressFormPanel.class);
    }
}
