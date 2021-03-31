package PasswordKeeper.operations;

import PasswordKeeper.Frame;
import PasswordKeeper.HelpMethods;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {

    public static void delete() {
        try {
            String s = Frame.choose();
            if (s != null) {
                int i = Integer.parseInt(s);
                PreparedStatement preparedStatement = Connect.connection().prepareStatement("delete from passwords where id = ?");
                preparedStatement.setInt(1, i);
                preparedStatement.executeUpdate();
            } else {
                Frame.errorMessage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HelpMethods.updateId();
    }
}

