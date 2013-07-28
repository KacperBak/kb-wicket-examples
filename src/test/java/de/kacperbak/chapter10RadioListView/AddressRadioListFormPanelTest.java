package de.kacperbak.chapter10RadioListView;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class AddressRadioListFormPanelTest extends AbstractWicketTest{

    private static final String PANEL = "panel";

    @Test
    public void testRender() throws Exception {
        IModel<List<? extends Address>> model = Model.ofList(new ArrayList<Address>());
        tester.startComponentInPage(new AddressRadioListFormPanel(PANEL, model, null));
    }
}
