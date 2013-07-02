package de.kacperbak;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

/**
 * User: bakka
 * Date: 23.05.13
 */
public class AbstractWicketTest {

    protected WicketTester tester;

    @Before
    public void setUp()
    {
        tester = new WicketTester(new WicketApplication());
    }
}
