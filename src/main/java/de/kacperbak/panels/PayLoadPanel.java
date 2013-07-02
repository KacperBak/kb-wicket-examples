package de.kacperbak.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 04.06.13
 */
public class PayLoadPanel extends GenericPanel<Boolean> {


    public PayLoadPanel(String id, IModel<Boolean> model, String payLoadText) {
        super(id, model);
        add(new Label("payLoadLabel", payLoadText));
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        setVisible(getModelObject());
    }
}
