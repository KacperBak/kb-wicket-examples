package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.wrappedbeans.WrappedAddress;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class AddressListItemPanelTest extends AbstractWicketTest{

    private final static String PANEL = "panel";

    @Test
    public void testRender(){
        Address address = new Address("test", "test", 0, 0);
        WrappedAddress wrappedAddress = new WrappedAddress(address);
        tester.startComponentInPage(new AddressListItemPanel(PANEL, new Model<WrappedAddress>(wrappedAddress)));
        tester.assertComponent(PANEL, AddressListItemPanel.class);
    }
}
