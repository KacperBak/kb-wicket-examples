package de.kacperbak.wrappedbeans;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bakka
 * Date: 24.07.13
 */
public class WrappedPerson implements Serializable{

    private Person person;
    private List<WrappedAddress> wrappedAddresses;

    public WrappedPerson(Person person, List<WrappedAddress> wrappedAddress) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<WrappedAddress> getWrappedAddresses() {
        return wrappedAddresses;
    }

    public void setWrappedAddresses(List<WrappedAddress> wrappedAddresses) {
        this.wrappedAddresses = wrappedAddresses;
    }
}
