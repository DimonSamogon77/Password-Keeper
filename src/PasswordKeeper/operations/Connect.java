package PasswordKeeper.operations;

import PasswordKeeper.Frame;

import java.sql.*;

public class Connect {
    private static final String USERNAME = "root", PASSWORD = "12345678", CONNECTION_URL = "jdbc:mysql://localhost:3306/test";
    private static Connection instance;

    private Connect() {
    }

    public static Connection getInstance() throws SQLException {
        if (instance == null) {
            String[] data = Frame.loginMessage();
            instance = DriverManager.getConnection(CONNECTION_URL, data[0], data[1]);
        }
        return instance;
    }
}
