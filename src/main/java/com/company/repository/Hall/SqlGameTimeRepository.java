package com.company.repository.Hall;

import com.company.domain.EnableGameTime;
import com.company.repository.DataBaseException;
import com.company.repository.DataBase;

//todo
public class SqlGameTimeRepository implements GameTimeRepository {
    private final DataBase dataBase;

    public SqlGameTimeRepository() throws DataBaseException {
        dataBase = new DataBase();
        String tableNameQuery = "gameTimes";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table gameTimes (gameTime_id serial primary key, startTime Time, endTime Time)";
        dataBase.createDB(tableNameQuery, createTableQuery);
        new SqlDaysRepository();
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
