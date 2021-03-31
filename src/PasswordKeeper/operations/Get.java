package PasswordKeeper.operations;

import PasswordKeeper.Frame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {

    public static void get() {
        try {
            String s = Frame.choose();
            int i = Integer.parseInt(Frame.choose());
            PreparedStatement preparedStatement = Connect.getInstance().prepareStatement("select * from passwords where id = ?");
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            String str = "";
            while (resultSet.next()) {
                str = resultSet.getString("site") + " - " + resultSet.getString("password");
            }
            Frame.showInfo(str);
        } catch (SQLException | NullPointerException e) {
            Frame.errorMessage();
            e.printStackTrace();
        }
    }
}
