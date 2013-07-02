package de.kacperbak.chapter9;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.chapter9forms.SimpleFormExample;
import org.junit.Test;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class FormExampleTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(SimpleFormExample.class);
        tester.assertRenderedPage(SimpleFormExample.class);
    }
}
