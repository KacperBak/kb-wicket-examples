package de.kacperbak.panels;

import de.kacperbak.AbstractWicketTest;
import org.apache.wicket.model.Model;
import org.junit.Test;

/**
 * User: bakka
 * Date: 04.06.13
 */
public class PayLoadPanelTest extends AbstractWicketTest {

    @Test
    public void testRender() {
        tester.startComponentInPage(new PayLoadPanel("panel", Model.of(true), "text"));
        tester.assertComponent("panel", PayLoadPanel.class);
    }
}
