package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 08.07.13
 */
public class PersonItemPanel extends Panel {

    private ComponentContext context;

    private IModel<Person> model;

    public PersonItemPanel(String id, IModel<Person> model, ComponentContext context) {
        super(id);
        this.model = model;
        this.context = context;
        add(select());
        add(new Label("name", model.getObject().getName()));
        add(new Label("age", model.getObject().getAge()));
        add(new Label("pcn", model.getObject().getCheckNumber()));
        add(new Label("city", model.getObject().getAddress().getCity()));
        add(new Label("zip", model.getObject().getAddress().getZip()));
        add(new Label("nr", model.getObject().getAddress().getNr()));
        add(new Label("acn", model.getObject().getAddress().getCheckNumber()));
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
