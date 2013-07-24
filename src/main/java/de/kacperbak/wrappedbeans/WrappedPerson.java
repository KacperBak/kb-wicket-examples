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

    private WrappedAddress wrappedAddress;

    public WrappedPerson(Person person, WrappedAddress wrappedAddress) {
        this.person = person;
        this.wrappedAddress = wrappedAddress;
    }

    public Person getPerson() {
        return person;
    }

    public String getName() {
        return person.getName();
    }

    public void setName(String name) {
        this.person.setName(name);
    }

    public int getAge() {
        return person.getAge();
    }

    public void setAge(int age) {
        this.person.setAge(age);
    }

    public int getCheckNumber() {
        return person.getCheckNumber();
    }

    public void setCheckNumber(int checkNumber) {
        this.person.setCheckNumber(checkNumber);
    }

    public WrappedAddress getMainAddress() {
        return Wrapper.wrapAddress(person.getMainAddress());
    }

    public void setMainAddress(WrappedAddress mainAddress) {
        this.person.setMainAddress(Wrapper.unwrapAddress(mainAddress));
    }

    public List<WrappedAddress> getAddresses() {
        ArrayList<WrappedAddress> result = new ArrayList<WrappedAddress>();
        for(Address address : person.getAddresses()){
            result.add(Wrapper.wrapAddress(address));
        }
        return result;
    }

    public void setAddresses(List<WrappedAddress> wrappedAddresses) {
        ArrayList<Address> result = new ArrayList<Address>();
        for(WrappedAddress wa : wrappedAddresses){
            result.add(Wrapper.unwrapAddress(wa));
        }
        this.person.setAddresses(result);
    }

}
