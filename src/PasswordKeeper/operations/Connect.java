package PasswordKeeper.operations;

import PasswordKeeper.ConsoleHelper;

import java.sql.*;

public class Connect {
    private static final String USERNAME = "root", PASSWORD = "12345678", CONNECTION_URL = "jdbc:mysql://localhost:3306/test";

    public static Connection connection(){
        while(true) {
            try {
                Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
                ConsoleHelper.writeMessage("Connection success.");
                return connection;
            } catch (SQLException | NullPointerException e) {
                ConsoleHelper.writeMessage(String.format("Can`t connect. Choose what to do:%n1 - Retry%n2 - Exit"));
                String s = ConsoleHelper.readMessage();
                if (s != null) {
                    switch (s){
                        case "1":
                            continue;
                        case "2":
                            break;
                    }
                }
                e.printStackTrace();
            }
        }
    }
}
