package de.kacperbak.chapter10NestedForm;

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

    private IModel<Person> selectedPerson;

    public PersonListPanel(String id, IModel<List<Person>> model) {
        super(id, model);
        add(personList());
    }

    private Component personList(){
        ListView<Person> personList = new ListView<Person>("personList", getModelObject()) {
            @Override
            protected void populateItem(ListItem<Person> item) {
                item.add(personItemPanel(item));
            }
        };
        return personList;
    }

    private Component personItemPanel(ListItem<Person> item){
        return new PersonItemPanel("personItem", item.getModel()){
            @Override
            public void selectPerson(IModel<Person> personModel) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Component updateAjaxComponent() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }
}
