package de.kacperbak.chapter10WrappedModel;

import de.kacperbak.wrappedbeans.WrappedAddress;

import java.util.List;

/**
 * User: bakka
 * Date: 24.07.13
 */
public interface AddressListFormContext {

    public void removeSelectedAddresses(List<WrappedAddress> selectedAddresses);
}
