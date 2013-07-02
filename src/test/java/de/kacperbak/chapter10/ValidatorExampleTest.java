package de.kacperbak.chapter10;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 30.06.13
 */
public class ValidatorExampleTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(ValidatorExample.class);
        tester.assertRenderedPage(ValidatorExample.class);
    }
}
