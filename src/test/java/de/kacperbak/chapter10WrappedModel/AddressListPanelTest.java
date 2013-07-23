package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: bakka
 * Date: 23.07.13
 */
public class AddressListPanelTest extends AbstractWicketTest{

    private static final String PANEL = "panel";

    @Test
    public void testRender(){
        Address address = new Address("test", "test", 0, 0);
        IModel model = Model.ofList(Arrays.asList(address));
        tester.startComponentInPage(new AddressListPanel(PANEL, model));
    }
}
