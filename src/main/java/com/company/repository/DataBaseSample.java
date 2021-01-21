package com.company.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSample {
    private final String user;
    private final String password;

    public DataBaseSample(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void getConnection() {
        try {
            String url = "jdbc:postgresql://localhost/superlegue";
            Connection connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }


}
