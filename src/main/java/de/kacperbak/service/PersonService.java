package de.kacperbak.service;

import de.kacperbak.beans.Address;
import de.kacperbak.beans.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class PersonService implements Serializable {

    /**
     * singleton
     */
    private static PersonService service;

    /**
     * consts
     */
    private static int PERSON_AMOUNT = 2;
    private static int ADDRESS_AMOUNT = 1;

    private static int DEFAULT_INDEX =  -1;

    private ArrayList<Person> persons;
    private ArrayList<Address> addresses;
    private List<Person> personsWithAddresses;

    private PersonService() {
        this.addresses = createDefaultAddresses();
        this.persons = createDefaultPersons();
        this.personsWithAddresses = createPersonsWithAddresses();
    }

    private ArrayList<Person> createDefaultPersons(){
        ArrayList<Person> result = new ArrayList<Person>();
        result.add(new Person("Kacper", 30, addresses.get(0), 1));
        result.add(new Person("Max", 25, addresses.get(1), 2));
        result.add(new Person("Markus", 50, addresses.get(2), 3));
        return result;
    }

    private ArrayList<Address> createDefaultAddresses(){
        ArrayList<Address> result = new ArrayList<Address>();
        result.add(new Address("Augsburg", "46a", 86163, 100));
        result.add(new Address("Kempten", "2", 87443, 101));
        result.add(new Address("Memmingen", "30", 87700, 102));
        return result;
    }

    private ArrayList<Person> createPersonsWithAddresses(){
        ArrayList<Person> result = new ArrayList<Person>();

        Address augsburg = new Address("Augsburg", "46a", 86163, 200);
        Address kempten = new Address("Kempten", "36", 87435, 201);
        Address memmingen = new Address("Memmingen", "38", 87700, 202);
        Address murnau = new Address("Murnau", "10", 82418, 203);

        ArrayList<Address> kacper = new ArrayList<Address>();
        kacper.add(augsburg);
        kacper.add(memmingen);
        kacper.add(kempten);
        result.add(new Person("Kacper", 30, 100, augsburg, kacper));

        ArrayList<Address> micha = new ArrayList<Address>();
        micha.add(kempten);
        micha.add(augsburg);
        result.add(new Person("Micha", 28, 101, augsburg, micha));

        ArrayList<Address> max = new ArrayList<Address>();
        max.add(murnau);
        max.add(kempten);
        result.add(new Person("Max", 26, 102, kempten, max));
        return result;
    }

    private Person createPerson(int number){
        return new Person("Kacper", 30 + number, createDefaultAddress(), number);
    }

    private Address createDefaultAddress(){
        return new Address("Augsburg", "46a", 86163, 0);
    }

    public static PersonService getPersonService(){
        if(service == null){
            service = new PersonService();
        }
        return service;
    }

    public Person createDefaultPerson(){
        return new Person("Kacper", 30, createDefaultAddress(), 0);
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public void addPerson(String name, int age, Address address, int checkNumber){
        persons.add(new Person(name, age, address, checkNumber));
    }

    public void addAddress(Address address){
        addresses.add(address);
    }

    public Person findPersonByCheckNumber(int checkNumber){
        Person result = null;
        for(Person person : persons){
            if(person.getCheckNumber() == checkNumber){
                result = person;
            }
        }
        return result;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public boolean removePerson(Person person){
        return persons.remove(person);
    }

    public boolean removeAddress(Address address){
        return addresses.remove(address);
    }

    public List<Person> getPersonsWithAddresses() {
        return personsWithAddresses;
    }

    public Person findSelectedPerson(Person person){
        int personIndex = DEFAULT_INDEX;
        personIndex = this.personsWithAddresses.indexOf(person);
        return this.personsWithAddresses.get(personIndex);
    }

    public List<Address> getAddressesFromPerson(Person person){
        int personIndex = DEFAULT_INDEX;
        personIndex = this.personsWithAddresses.indexOf(person);
        return (personIndex != DEFAULT_INDEX) ? this.personsWithAddresses.get(personIndex).getAddresses() : null;
    }

    public void removeAddressFromPerson(Person selectedPerson, Address addressToRemove){
        int personIndex = DEFAULT_INDEX;
        int addressIndex = DEFAULT_INDEX;
        personIndex = this.personsWithAddresses.indexOf(selectedPerson);
        if(personIndex != DEFAULT_INDEX){
            addressIndex = this.personsWithAddresses.get(personIndex).getAddresses().indexOf(addressToRemove);
            if(addressIndex != DEFAULT_INDEX){
                this.personsWithAddresses.get(personIndex).getAddresses().remove(addressIndex);
            }
        }
    }


    public void setPersonsWithAddresses(List<Person> personsWithAddresses) {
        this.personsWithAddresses = personsWithAddresses;
    }

    public void setMainAddress(Person person, Address mainAddress){
        Person personToSetAddress = findSelectedPerson(person);
        personToSetAddress.setMainAddress(mainAddress);
    }
}
