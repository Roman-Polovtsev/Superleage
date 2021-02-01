package com.company.repository.Address;

import com.company.domain.Address;
import com.company.repository.DataBaseException;
import com.company.repository.DataBase;

public class SQLAddressRepository implements AddressRepository {
    private final DataBase dataBase;

    public SQLAddressRepository() throws DataBaseException {
        dataBase = new DataBase();
        String tableNameQuery = "addresses";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table addresses (id serial primary key,city varchar(30), street varchar (20), building varchar(10))";
        dataBase.createDB(tableNameQuery, createTableQuery);
    }


    @Override
    public long getID() {
        return 0;
    }

    @Override
    public void save(Address address) {

    }

    @Override
    public Address getById(long id) {
        return null;
    }

    @Override
    public void delete(Address address) {

    }
}
