package de.kacperbak.chapter10SubmitLink;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 03.07.13
 */
public class TwoFormsTwoSubmitsTest extends AbstractWicketTest{
    @Test
    public void testRender(){

        tester.startPage(TwoFormsTwoSubmits.class);
        tester.assertRenderedPage(TwoFormsTwoSubmits.class);
    }
}
