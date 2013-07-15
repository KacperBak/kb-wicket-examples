package de.kacperbak.chapter10formcomponentpanel;

import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 08.07.13
 */
public class PersonListPanel extends GenericPanel<List<Person>> {

    private PersonListContext context;

    public PersonListPanel(String id, IModel<List<Person>> model, PersonListContext context) {
        super(id, model);
        this.context = context;
        add(personList());
    }

    private Component personList(){
        ListView<Person> personList = new ListView<Person>("personList", getModelObject()) {
            @Override
            protected void populateItem(ListItem<Person> item) {
                item.add(personItemPanel(item.getModel()));
            }
        };
        return personList;
    }

    private Component personItemPanel(IModel<Person> model){
        return new PersonItemPanel("personItem", model, context);
    }
}
