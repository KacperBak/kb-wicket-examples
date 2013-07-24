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
        add(new Label("name", model.getObject().getName()));
        add(new Label("age", model.getObject().getAge()));
        add(new Label("pcn", model.getObject().getCheckNumber()));
        add(new Label("city", model.getObject().getMainAddress().getAddress().getCity()));
        add(new Label("zip", model.getObject().getMainAddress().getAddress().getZip()));
        add(new Label("nr", model.getObject().getMainAddress().getAddress().getNr()));
        add(new Label("acn", model.getObject().getMainAddress().getAddress().getCheckNumber()));
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
