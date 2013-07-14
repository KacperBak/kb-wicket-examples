package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.chapter10formcomponentpanel.AddressFormComponentPanel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 07.07.13
 */
public class AddressFormComponentPanelTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startComponentInPage(new AddressFormComponentPanel("panel", new Model<Address>()) );
        tester.assertComponent("panel", AddressFormComponentPanel.class);
    }
}
