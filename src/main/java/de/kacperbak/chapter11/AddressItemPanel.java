package de.kacperbak.chapter11;

import de.kacperbak.beans.Address;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * User: bakka
 * Date: 19.06.13
 */
public abstract class AddressItemPanel extends GenericPanel<Address> {

    private IModel<Address> model;

    public AddressItemPanel(String id, IModel<Address> address) {
        super(id, new CompoundPropertyModel<Address>(address));
        this.model = getModel();

        add(selectAddress());
        add(new Label("checkNumber"));
        add(new Label("city"));
        add(new Label("zip"));
        add(new Label("nr"));
    }

    private Component selectAddress(){
        AjaxFallbackLink link = new AjaxFallbackLink("selectAddress") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                //In this context getModel() returns an Object!
                //So a typed model IModel<Address> is required to be passed
                selectCurrentAddress(model);
                addAjaxRequestTarget(target);
            }
        };
        return link;
    }

    /**
     * hook method
     * @param currentAddress
     */
    public abstract void selectCurrentAddress(IModel<Address> currentAddress);

    /**
     * hook method
     * @param target
     */
    public abstract void addAjaxRequestTarget(AjaxRequestTarget target);

    /**
     * if a component has more than one model, it should be detached with every request!
     */
    @Override
    protected void onDetach() {
        if(model != null){
            model.detach();
        }
        super.onDetach();
    }
}
