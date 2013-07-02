package de.kacperbak.panels;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

/**
 * User: bakka
 * Date: 04.06.13
 */
public class PropertyFilePanel extends Panel {

    public PropertyFilePanel(String id) {
        super(id);
        add(getPropertyLabel());
    }

    private Component getPropertyLabel(){
        return new Label("propertyFileValue", new ResourceModel("PROPERTY.KEY"));
    }
}
