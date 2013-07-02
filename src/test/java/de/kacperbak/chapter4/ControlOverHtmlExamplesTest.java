package de.kacperbak.chapter4;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 23.05.13
 */
public class ControlOverHtmlExamplesTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(ControlOverHtmlExamples.class);
        tester.assertRenderedPage(ControlOverHtmlExamples.class);
    }
}
