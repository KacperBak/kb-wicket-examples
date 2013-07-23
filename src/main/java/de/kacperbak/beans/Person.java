package de.kacperbak.beans;

import java.io.Serializable;
import java.util.List;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class Person implements Serializable {

    private String name;
    private int age;
    private Address mainAddress;
    private int checkNumber;
    private List<Address> addresses;


    public Person(String name, int age, Address mainAddress,int checkNumber) {
        this.name = name;
        this.age = age;
        this.mainAddress = mainAddress;
        this.checkNumber = checkNumber;
    }

    public Person(String name, int age, int checkNumber,Address mainAddress, List<Address> addresses) {
        this.addresses = addresses;
        this.age = age;
        this.checkNumber = checkNumber;
        this.mainAddress = mainAddress;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "addresses=" + addresses +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mainAddress=" + mainAddress +
                ", checkNumber=" + checkNumber +
                '}';
    }
}
