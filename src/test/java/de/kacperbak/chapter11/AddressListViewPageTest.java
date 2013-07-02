package de.kacperbak.chapter11;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 19.06.13
 */
public class AddressListViewPageTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(AddressListViewPage.class);
        tester.assertRenderedPage(AddressListViewPage.class);
    }
}
