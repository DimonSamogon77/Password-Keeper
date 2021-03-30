package PasswordKeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelpMethods {
    public static void showDatabase(){
        try {
            Statement statement = Connect.connection().createStatement();
            ConsoleHelper.writeMessage("--------------------");
            ConsoleHelper.writeMessage("Choose site:");
            ResultSet resultSet = statement.executeQuery("select * from passwords");
            while (resultSet.next()) {
                ConsoleHelper.writeMessage(resultSet.getString("id") + " - " + resultSet.getString("site"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateId(){
        try{
            Statement statement = Connect.connection().createStatement();
            ConsoleHelper.writeMessage("--------------------");
            statement.executeUpdate("alter table passwords drop id");
            statement.executeUpdate("alter table passwords add id MEDIUMINT(10) not null auto_increment primary key");
        }catch (SQLException e){
            e.printStackTrace();
        }
        showDatabase();
    }
}
