package com.company.repository;

import com.company.domain.PlayerDecorator.AbstractPerson;
import com.company.domain.PlayerDecorator.DefinedPerson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseSampleTest {
    DataBaseSample sample;


    public static void main(String[] args) throws SQLException {
        DataBaseSample sample = new DataBaseSample();
        AbstractPerson person = new DefinedPerson("roman", 1996);
        Connection connection = sample.getConnection();
        // sample.createDB(connection);
        // int persons = sample.insertRow(connection, "persons", person.getName(), person.getYearOfBirth());
        //int id = sample.deleteRow(connection, "id", 2);
        ResultSet persons1 = sample.readAllRows(connection, "persons");
        System.out.println(persons1);
        persons1.beforeFirst();
        while (persons1.next()) {
            System.out.println(persons1.getInt("yearofbirth"));
            System.out.println(persons1.getString("name"));
        }
        //System.out.println(persons1.getInt("yearofbirth"));
        // System.out.println(id);
        sample.closeConnection(connection);


    }


}