package PasswordKeeper.operations;

import PasswordKeeper.Frame;
import PasswordKeeper.HelpMethods;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {

    public static void delete() {
        try {
            int i = Integer.parseInt(Frame.choose());
            PreparedStatement preparedStatement = Connect.getInstance().prepareStatement("delete from passwords where id = ?");
            preparedStatement.setInt(1, i);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        HelpMethods.updateId();
    }
}

