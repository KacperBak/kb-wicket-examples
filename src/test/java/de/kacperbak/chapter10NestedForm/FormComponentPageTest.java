package de.kacperbak.chapter10NestedForm;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.chapter10formcomponentpanel.FormComponentPage;
import org.junit.Test;

/**
 * User: bakka
 * Date: 07.07.13
 */
public class FormComponentPageTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(FormComponentPage.class);
        tester.assertRenderedPage(FormComponentPage.class);
    }
}
