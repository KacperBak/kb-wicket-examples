package de.kacperbak.chapter9forms;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class PersonPageTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(PersonPage.class);
        tester.assertRenderedPage(PersonPage.class);
    }
}
