package de.kacperbak.chapter10RadioListView;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class RadioListViewPageTest extends AbstractWicketTest{

    @Test
    public void testRender() throws Exception {
        tester.startPage(RadioListViewPage.class);
        tester.assertRenderedPage(RadioListViewPage.class);
    }
}
