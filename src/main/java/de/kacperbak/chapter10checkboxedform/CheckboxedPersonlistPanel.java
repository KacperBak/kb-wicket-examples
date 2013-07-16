package de.kacperbak.chapter10checkboxedform;

import de.kacperbak.beans.Person;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * User: bakka
 * Date: 16.07.13
 */
public class CheckboxedPersonlistPanel extends Panel {



    public CheckboxedPersonlistPanel(String id, IModel<?> model) {
        super(id, model);
    }

    /**
     * This is a helper class for wicket to handle the checkbox state in a consistent way
     */
    private class CheckedboxedPerson{
        private Person person;
        private boolean isChecked;

        private CheckedboxedPerson(boolean checked, Person person) {
            isChecked = checked;
            this.person = person;
        }

        private boolean isChecked() {
            return isChecked;
        }

        private void setChecked(boolean checked) {
            isChecked = checked;
        }

        private Person getPerson() {
            return person;
        }

        private void setPerson(Person person) {
            this.person = person;
        }

        @Override
        public String toString() {
            return "CheckedboxedPerson{" +
                    "isChecked=" + isChecked +
                    ", person=" + person +
                    '}';
        }
    }
}
