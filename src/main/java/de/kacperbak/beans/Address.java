package de.kacperbak.beans;

import java.io.Serializable;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class Address implements Serializable {

    private int zip;
    private String city;
    private String nr;
    private int checkNumber;

    public Address(String city, String nr, int zip, int checkNumber) {
        this.city = city;
        this.nr = nr;
        this.zip = zip;
        this.checkNumber = checkNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "checkNumber=" + checkNumber +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                ", nr='" + nr + '\'' +
                '}';
    }
}
