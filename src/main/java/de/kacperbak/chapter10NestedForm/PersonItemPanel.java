package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * User: bakka
 * Date: 08.07.13
 */
public abstract class PersonItemPanel extends Panel {

    private CompoundPropertyModel<Person> personModel;

    public PersonItemPanel(String id, IModel<Person> model) {
        super(id);
        setDefaultModel(personModel = new CompoundPropertyModel<Person>(model));
        add(select());
        add(new Label("name"));
        add(new Label("age"));
        add(new Label("pcn", personModel.bind("checkNumber")));
        add(new Label("city", personModel.bind("address.city")));
        add(new Label("zip", personModel.bind("address.zip")));
        add(new Label("nr", personModel.bind("address.nr")));
        add(new Label("acn", personModel.bind("address.checkNumber")));
    }

    private Component select(){
        AjaxLink link = new AjaxLink("select") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                if(target != null){
                    selectPerson(getModel());
                    target.add(updateAjaxComponent());
                }
            }
        };
        return link;
    }

    public abstract void selectPerson(IModel<Person> personModel);

    public abstract Component updateAjaxComponent();
}
