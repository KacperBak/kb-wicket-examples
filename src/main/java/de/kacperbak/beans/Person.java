package de.kacperbak.beans;

import java.io.Serializable;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class Person implements Serializable {

    private String name;
    private int age;
    private Address address;
    private int checkNumber;


    public Person(String name, int age, Address address,int checkNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.checkNumber = checkNumber;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", checkNumber=" + checkNumber +
                '}';
    }
}
