package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

/**
 * User: bakka
 * Date: 14.07.13
 */
public class NestedFormPageTest extends AbstractWicketTest {

    @Test
    public void testRender(){
        tester.startPage(NestedFormPage.class);
        tester.assertRenderedPage(NestedFormPage.class);
    }
}
