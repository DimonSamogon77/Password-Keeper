package PasswordKeeper;

import PasswordKeeper.operations.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HelpMethods {
    public static List<String> showDatabase(){
        try {
            Statement statement = Connect.getInstance().createStatement();
            List<String> list = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select * from passwords");
            while (resultSet.next()) {
                list.add(resultSet.getString("id") + " - " + resultSet.getString("site"));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void updateId(){
        try{
            Statement statement = Connect.getInstance().createStatement();
            statement.executeUpdate("alter table passwords drop id");
            statement.executeUpdate("alter table passwords add id MEDIUMINT(10) not null auto_increment primary key");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
