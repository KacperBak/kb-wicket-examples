package de.kacperbak.chapter10NestedForm;

import de.kacperbak.beans.Person;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 09.07.13
 */
public interface ComponentContext {

    /**
     *
     * @param personModel
     */
    public void selectPerson(IModel<Person> personModel);

    public Component getComponentForAjaxUpdate();
}
