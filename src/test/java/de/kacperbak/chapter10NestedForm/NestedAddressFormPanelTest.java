package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 07.07.13
 */
public class NestedAddressFormPanelTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startComponentInPage(new NestedAddressFormPanel("panel", new Model<Address>()) );
        tester.assertComponent("panel", NestedAddressFormPanel.class);
    }
}
