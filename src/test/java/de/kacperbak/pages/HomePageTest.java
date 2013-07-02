package de.kacperbak.pages;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class HomePageTest extends AbstractWicketTest{

    @Test
    public void testRender(){
        tester.startPage(HomePage.class);
        tester.assertRenderedPage(HomePage.class);
    }
}
