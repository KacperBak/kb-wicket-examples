package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.wrappedbeans.WrappedPerson;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 24.07.13
 */
public class WrappedPersonItemPanel extends Panel {

    private WrappedPersonContext context;

    private IModel<WrappedPerson> model;

    public WrappedPersonItemPanel(String id, IModel<WrappedPerson> model, WrappedPersonContext context) {
        super(id);
        this.model = model;
        this.context = context;
        add(select());
        add(new Label("name", new PropertyModel<WrappedPerson>(model, "person.name")));
        add(new Label("age", new PropertyModel<WrappedPerson>(model, "person.age")));
        add(new Label("pcn", new PropertyModel<WrappedPerson>(model, "person.checkNumber")));
        add(new Label("city", new PropertyModel<WrappedPerson>(model, "person.mainAddress.city")));
        add(new Label("zip", new PropertyModel<WrappedPerson>(model, "person.mainAddress.zip")));
        add(new Label("nr", new PropertyModel<WrappedPerson>(model, "person.mainAddress.nr")));
        add(new Label("acn", new PropertyModel<WrappedPerson>(model, "person.mainAddress.checkNumber")));
    }

    private Component select(){
        AjaxLink link = new AjaxLink("select") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                if(target != null){
                    context.selectPerson(model);
                    target.add(context.getComponentForAjaxUpdate());
                }
            }
        };
        return link;
    }
}
