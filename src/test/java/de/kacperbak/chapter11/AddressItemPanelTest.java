package de.kacperbak.chapter11;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 19.06.13
 */
public class AddressItemPanelTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        IModel<Address> model = Model.of(new Address("Memmingen", "36", 87700, 0));
        AddressItemPanel panel = new AddressItemPanel("panel", model){
            @Override
            public void selectCurrentAddress(IModel<Address> currentAddress) {}

            @Override
            public void addAjaxRequestTarget(AjaxRequestTarget target) {}
        };
        tester.startComponentInPage(panel);
        tester.assertComponent("panel", Panel.class);
    }
}
