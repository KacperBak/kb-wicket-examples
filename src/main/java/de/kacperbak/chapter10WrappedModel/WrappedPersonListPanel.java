package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Person;
import de.kacperbak.chapter10formcomponentpanel.PersonItemPanel;
import de.kacperbak.chapter10formcomponentpanel.PersonListContext;
import de.kacperbak.wrappedbeans.WrappedPerson;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * User: bakka
 * Date: 24.07.13
 */
public class WrappedPersonListPanel extends GenericPanel<List<WrappedPerson>> {

    private WrappedPersonContext context;

    public WrappedPersonListPanel(String id, IModel<List<WrappedPerson>> model, WrappedPersonContext context) {
        super(id, model);
        this.context = context;
        add(personList());
    }

    private Component personList(){
        ListView<WrappedPerson> personList = new ListView<WrappedPerson>("personList", getModelObject()) {
            @Override
            protected void populateItem(ListItem<WrappedPerson> item) {
                item.add(personItemPanel(item.getModel()));
            }
        };
        return personList;
    }

    private Component personItemPanel(IModel<WrappedPerson> model){
        return new WrappedPersonItemPanel("personItem", model, context);
    }
}
