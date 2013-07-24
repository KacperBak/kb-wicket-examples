package de.kacperbak.wrappedbeans;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;

/**
 * User: bakka
 * Date: 24.07.13
 */
public class Wrapper {

    public static WrappedAddress wrapAddress(Address address){
        return new WrappedAddress(address);
    }

    public static Address unwrapAddress(WrappedAddress wrappedAddress){
        return wrappedAddress.getAddress();
    }

    public static WrappedPerson wrapPerson(Person person){
        return new WrappedPerson(person, Wrapper.wrapAddress(person.getMainAddress()));
    }

    public static Person unwrapPerson(WrappedPerson wrappedPerson){
        return wrappedPerson.getPerson();
    }
}
