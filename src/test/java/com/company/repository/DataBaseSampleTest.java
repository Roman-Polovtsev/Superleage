package com.company.repository;

import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataBaseSampleTest {
    DataBaseSample sample = new DataBaseSample("postgres","29031996roman");


    public void getConnection(){
        try {
            String url = "jdbc:postgresql://localhost/superlegue";
            Connection connection = DriverManager.getConnection(url, "postgres", "29031996roman");
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public static void main(String[] args) {
        DataBaseSample sample = new DataBaseSample("postgres","29031996roman");
        sample.getConnection();

    }


}