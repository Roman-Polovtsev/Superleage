package com.company.repository.Hall;

import com.company.domain.Hall;
import com.company.repository.DataBaseException;
import com.company.repository.DataBase;

public class SqlHallRepository implements HallRepository {
    private final DataBase dataBase;

    public SqlHallRepository() throws DataBaseException {
        dataBase = new DataBase();
        String tableName = "halls";
        dataBase.dropTable(tableName);
        String createTableQuery = "create table halls (hall_id serial primary key, address_id int, gameTime_id int, CONSTRAINT" +
                " fk_address FOREIGN KEY (address_id) REFERENCES addresses (address_id) ON DELETE CASCADE)" +
                "CONSTRAINT fk_gameTime FOREIGN KEY (gameTime_id) REFERENCES gameTimes (gameTime_id) ON DELETE CASCADE)";
        dataBase.createDB(tableName, createTableQuery);
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
