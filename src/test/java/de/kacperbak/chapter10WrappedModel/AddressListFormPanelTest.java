package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.wrappedbeans.WrappedAddress;
import de.kacperbak.wrappedbeans.Wrapper;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: bakka
 * Date: 23.07.13
 */
public class AddressListFormPanelTest extends AbstractWicketTest{

    private static final String PANEL = "panel";

    @Test
    public void testRender(){
        Address address = new Address("test", "test", 0, 0);
        IModel model = Model.ofList(Arrays.asList(new WrappedAddress(address)));
        tester.startComponentInPage(new AddressListFormPanel(PANEL, model, null));
    }
}
