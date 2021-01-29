package com.company.repository.Hall;

import com.company.repository.DataBaseException;
import com.company.repository.DataBaseSample;

public class SqlDaysGameTimeRelation {
    DataBaseSample dataBase;

    public SqlDaysGameTimeRelation() throws DataBaseException {
        dataBase = new DataBaseSample();
        String tableNameQuery = "gameTime_days";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table gameTime_days (gameTime_id int , day_id int) CONSTRAINT fk_day_id" +
                " FOREIGN KEY day_id REFERENCES daysOfWeek(day_id) CONSTRAINT fk_gameTime_id\" +\n" +
                "                \" FOREIGN KEY gameTime_id REFERENCES gameTimes(gameTime_id) )";
        dataBase.createDB(tableNameQuery, createTableQuery);
    }
}
