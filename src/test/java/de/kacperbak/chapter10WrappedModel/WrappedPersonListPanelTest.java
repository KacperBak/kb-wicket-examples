package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;
import de.kacperbak.wrappedbeans.WrappedAddress;
import de.kacperbak.wrappedbeans.WrappedPerson;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * User: bakka
 * Date: 25.07.13
 */
public class WrappedPersonListPanelTest extends AbstractWicketTest{

    private static final String PANEL = "panel";

    @Test
    public void testRender(){
        Address address = new Address("Memmingen", "55a", 87700, 101);
        WrappedPerson wrappedPerson = new WrappedPerson(new Person("name", 30, address, 201), Arrays.asList(new WrappedAddress(address)));
        IModel wrappedPersonModel = Model.ofList(Arrays.asList(wrappedPerson));
        tester.startComponentInPage(new WrappedPersonListPanel(PANEL, wrappedPersonModel, null));
    }
}
