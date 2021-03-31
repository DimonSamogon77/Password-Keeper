package PasswordKeeper.operations;

import PasswordKeeper.Frame;
import PasswordKeeper.HelpMethods;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void updatePassword() {
        HelpMethods.showDatabase();
        try {
            int i = Integer.parseInt(Frame.choose());
            String j = Frame.getPassword();
            PreparedStatement preparedStatement = Connect.getInstance().prepareStatement("update passwords set password = ? where id  = ?");
            preparedStatement.setString(1, j);
            preparedStatement.setInt(2, i);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
