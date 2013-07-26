package de.kacperbak.wrappedbeans;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bakka
 * Date: 24.07.13
 */
public class Wrapper {

    public static List<WrappedPerson> wrappedPersons(List<Person> persons){
        List<WrappedPerson> result = new ArrayList<WrappedPerson>();
        for(Person person : persons){
            result.add(new WrappedPerson(person, wrappedAddresses(person.getAddresses())));
        }
        return result;
    }

    public static List<WrappedAddress> wrappedAddresses(List<Address> addresses){
        List<WrappedAddress> result = new ArrayList<WrappedAddress>();
        for(Address address : addresses){
            result.add(new WrappedAddress(address));
        }
        return result;
    }
}
