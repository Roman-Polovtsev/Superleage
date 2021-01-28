package com.company.repository.Address;

import com.company.domain.Address;

public interface AddressRepository {

    long getID();

    void save(Address address);

    Address getById(long id);

    void delete (Address address);

}
