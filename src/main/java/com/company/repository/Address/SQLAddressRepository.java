package com.company.repository.Address;

import com.company.domain.Address;
import com.company.repository.DataBaseSample;

import java.sql.SQLException;

public class SQLAddressRepository implements AddressRepository {
    private final DataBaseSample dataBase;

    public SQLAddressRepository() throws SQLException {
        dataBase = new DataBaseSample();
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
