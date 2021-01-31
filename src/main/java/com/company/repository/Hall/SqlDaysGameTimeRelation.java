package com.company.repository.Hall;

import com.company.repository.DataBaseException;
import com.company.repository.DataBase;

public class SqlDaysGameTimeRelation {

    private static final String TABLE_NAME = "gameTime_days";
    private static final String DEFAULT_QUERY = "create table gameTime_days (gameTime_id int , day_id int) CONSTRAINT fk_day_id" +
            " FOREIGN KEY day_id REFERENCES daysOfWeek(day_id) CONSTRAINT fk_gameTime_id\" +\n" +
            "                \" FOREIGN KEY gameTime_id REFERENCES gameTimes(gameTime_id) )";
    private final DataBase dataBase;
    private final String tableName;
    private final String query;

    public SqlDaysGameTimeRelation() {
        this(new DataBase(), TABLE_NAME, DEFAULT_QUERY);
    }

    public SqlDaysGameTimeRelation(final DataBase dataBase, final String tableName, final String query) {
        this.dataBase = dataBase;
        this.tableName = tableName;
        this.query = query;
    }

    public void initDb() throws DataBaseException {
        dataBase.dropTable(tableName);
        dataBase.createDB(tableName, query);
    }
}
