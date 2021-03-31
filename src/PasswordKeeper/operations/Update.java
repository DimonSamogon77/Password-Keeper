package PasswordKeeper.operations;

import PasswordKeeper.Frame;
import PasswordKeeper.HelpMethods;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void updatePassword() {
        HelpMethods.showDatabase();
        while (true) {
            try {
                String i = Frame.choose();
                String j = Frame.getPassword();
                if (i != null && j != null) {
                    int i1 = Integer.parseInt(i);
                    PreparedStatement preparedStatement = Connect.getInstance().prepareStatement("update passwords set password = ? where id  = ?");
                    preparedStatement.setString(1, j);
                    preparedStatement.setInt(2, i1);
                    preparedStatement.executeUpdate();
                    break;
                } else {
                    Frame.errorMessage();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}