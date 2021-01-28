package com.company.repository.Hall;

import com.company.domain.Hall;
import com.company.repository.DataBaseSample;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlHallRepository implements HallRepository {
    private final DataBaseSample dataBase;
    private final String tableName = "halls";
    private final String createTableQuery = "create table halls (hall_id serial primary key, address_id int, gameTime_id int, CONSTRAINT" +
            " fk_address FOREIGN KEY (address_id) REFERENCES addresses (address_id) ON DELETE CASCADE)" +
            "CONSTRAINT fk_gameTime FOREIGN KEY (gameTime_id) REFERENCES gameTimes (gameTime_id) ON DELETE CASCADE)";

    public SqlHallRepository() throws SQLException {
        dataBase = new DataBaseSample();
        dataBase.dropTable(tableName);
        dataBase.createDB(tableName,createTableQuery);
    }

    @Override
    public long getID() {
        return 0;
    }

    @Override
    public void save(Hall hall) {

    }

    @Override
    public Hall getById(long id) {
        return null;
    }

    @Override
    public void delete(Hall hall) {

    }
}
