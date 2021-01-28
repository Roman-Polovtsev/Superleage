package com.company.repository.Hall;

import com.company.domain.EnableGameTime;
import com.company.repository.DataBaseSample;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlGameTimeRepository implements GameTimeRepository {
    private final DataBaseSample dataBase;
    private final String tableNameQuery = "gameTimes";
    private final String createTableQuery = "create table gameTimes (gameTime_id serial primary key, startTime Time, endTime Time)";

    public SqlGameTimeRepository() throws SQLException {
        dataBase = new DataBaseSample();
        dataBase.dropTable(tableNameQuery);
        dataBase.createDB(tableNameQuery, createTableQuery);
    }


    @Override
    public long getID() {
        return 0;
    }

    @Override
    public void save(EnableGameTime gameTime) {

    }

    @Override
    public EnableGameTime getById(long id) {
        return null;
    }

    @Override
    public void delete(EnableGameTime gameTime) {

    }
}
