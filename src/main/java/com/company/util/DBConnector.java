package com.company.util;

import com.company.repository.DataBaseException;

import java.sql.Connection;

public interface DBConnector {

    Connection getConnection() throws DataBaseException;
}
