package com.company.repository.Hall;

import com.company.domain.EnableGameTime;
import com.company.repository.DataBase;
import com.company.repository.DataBaseException;
import com.company.util.PoolConnector;

import java.sql.*;
import java.time.DayOfWeek;

//todo
public class SqlGameTimeRepository implements GameTimeRepository {
    private final DataBase dataBase;
    private final SqlDaysGameTimeRelation gameTimeRelation;
    private final SqlDaysRepository daysRepository;
    private final String tableName;
    private final String query;
    private static final String TABLE_NAME_QUERY = "gameTimes";
    private static final String CREATE_TABLE_QUERY = "create table gameTimes (gameTime_id serial primary key, startTime Time, endTime Time)";

    public SqlGameTimeRepository() throws DataBaseException {
        this(new DataBase(), TABLE_NAME_QUERY, CREATE_TABLE_QUERY);
    }

    public SqlGameTimeRepository(final DataBase dataBase, final String tableName, final String query) throws DataBaseException {
        this.dataBase = dataBase;
        this.daysRepository = SqlDaysRepository.getInstance();
        this.tableName = tableName;
        this.query = query;
        init();
        this.gameTimeRelation = SqlDaysGameTimeRelation.getInstance(new DataBase(new PoolConnector()));
    }

    public void init() throws DataBaseException {
        dataBase.dropTable(tableName);
        dataBase.createDB(tableName, query);
    }


    @Override
    public long getID() {
        return 0;
    }

    @Override
    public void save(EnableGameTime gameTime) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into gameTimes (gameTime_id,startTime,endTime ) values (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) gameTime.getID());
            statement.setTime(2, Time.valueOf(gameTime.getBegin()));
            statement.setTime(3, Time.valueOf(gameTime.getEnd()));
            statement.addBatch();
            statement.execute();
            connection.close();
            gameTimeRelation.save(gameTime.getID(), gameTime.getDayOfWeek().getValue());
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during saving gameTime to DB: %s \nwith query %s", gameTime, sql), e);
        }
    }

    @Override
    public EnableGameTime getById(long id) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "select * from gameTimes left join gameTime_days as relation on gameTimes.gameTime_id = relation.gameTime_id left join daysOfWeek on relation.day_id = daysOfWeek.day_id where gameTimes.gameTime_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            long gameTime_id = resultSet.getLong("gameTime_id");
            Time begin = resultSet.getTime("startTime");
            Time end = resultSet.getTime("endTime");
            String day = resultSet.getString("name");
            connection.close();
            return new EnableGameTime(gameTime_id, begin.toLocalTime(), end.toLocalTime(), DayOfWeek.valueOf(day));
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during getting gameTime from DB by ID: %s \nwith query %s", id, sql), e);
        }
    }

    @Override
    public void delete(EnableGameTime gameTime) {

    }
}
