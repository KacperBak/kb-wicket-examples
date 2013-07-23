package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 22.07.13
 */
public class WrappedModelPageTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(WrappedModelPage.class);
        tester.assertRenderedPage(WrappedModelPage.class);
    }
}
