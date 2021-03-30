package PasswordKeeper;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {
    public static void delete() {
        HelpMethods.showDatabase();
        while (true) {
            try {
                String s = ConsoleHelper.readMessage();
                if (s != null) {

                    int i = Integer.parseInt(s);
                    PreparedStatement preparedStatement = Connect.connection().prepareStatement("delete from passwords where id = ?");
                    preparedStatement.setInt(1, i);
                    preparedStatement.executeUpdate();
                    break;

                } else {
                    ConsoleHelper.writeMessage("Wrong data. Try again.");
                    continue;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            HelpMethods.updateId();
        }
    }
}
