package de.kacperbak.chapter10formcomponentpanel;

import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 09.07.13
 */
public interface ComponentContext {

    public void selectPerson(IModel<Person> personModel);

    public Component getComponentForAjaxUpdate();
}
