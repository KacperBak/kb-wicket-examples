package de.kacperbak.panels;

import de.kacperbak.AbstractWicketTest;
import org.apache.wicket.Localizer;
import org.junit.Test;

/**
 * User: bakka
 * Date: 04.06.13
 */
public class PropertyFilePanelTest extends AbstractWicketTest {

    @Test
    public void testRender(){
        PropertyFilePanel panel = new PropertyFilePanel("panel");
        tester.startComponentInPage(panel);
        tester.assertComponent("panel", PropertyFilePanel.class);
        tester.assertLabel("panel:propertyFileValue", Localizer.get().getString("PROPERTY.KEY", panel));
    }
}
