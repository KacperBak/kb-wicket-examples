package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.beans.Person;
import de.kacperbak.wrappedbeans.WrappedPerson;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 24.07.13
 */
public interface WrappedPersonContext {

    public void selectPerson(IModel<WrappedPerson> personModel);

    public Component getComponentForAjaxUpdate();
}
