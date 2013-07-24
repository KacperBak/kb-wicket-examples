package de.kacperbak.wrappedbeans;

import de.kacperbak.beans.Address;

import java.io.Serializable;

/**
 * User: bakka
 * Date: 23.07.13
 */
public class WrappedAddress implements Serializable {

    private Boolean checked = new Boolean(false);
    private Address address;

    public WrappedAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }


    @Override
    public String toString() {
        return "WrappedAddress{" +
                "address=" + address +
                ", checked=" + checked +
                '}';
    }
}
