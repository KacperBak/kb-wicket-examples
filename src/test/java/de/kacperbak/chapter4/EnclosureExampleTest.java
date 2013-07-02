package de.kacperbak.chapter4;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 27.05.13
 */
public class EnclosureExampleTest extends AbstractWicketTest {

    @Test
    public void testRender() {
        tester.startPage(EnclosureExample.class);
        tester.assertRenderedPage(EnclosureExample.class);
    }
}
