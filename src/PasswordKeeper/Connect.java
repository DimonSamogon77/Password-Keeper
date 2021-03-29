package PasswordKeeper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private static final String USERNAME = "root", PASSWORD = "12345678", CONNECTION_URL = "jdbc:mysql://localhost:3306/test";

    public static Statement statement(){
        try{
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            return statement;
        }catch (SQLException ignored){

        }
        return null;
    }
}
