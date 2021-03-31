package PasswordKeeper.operations;

import PasswordKeeper.Frame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {

    public static void get() {
        try {
            String s = Frame.choose();
            if (s != null) {
                int i = Integer.parseInt(s);
                PreparedStatement preparedStatement = Connect.connection().prepareStatement("select * from passwords where id = ?");
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                String str = "";
                while(resultSet.next()){
                    str = resultSet.getString("site") + " - " + resultSet.getString("password");
                }
                Frame.showInfo(str);
            } else {
                Frame.errorMessage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
