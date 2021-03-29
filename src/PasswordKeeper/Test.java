package PasswordKeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userName = "root";
        String password = "41617140";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password); Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from passwords");
            System.out.println("Choose:");
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+" - "+resultSet.getString("site"));
            }
            int id = Integer.parseInt(reader.readLine());
            resultSet = statement.executeQuery("select password from passwords where id ="+id);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }
    }
}
