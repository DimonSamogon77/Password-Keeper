package PasswordKeeper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {

    public static void get() {
        HelpMethods.showDatabase();
        try {
            String s = ConsoleHelper.readMessage();
            if (s != null) {
                int i = Integer.parseInt(s);
                PreparedStatement preparedStatement = Connect.connection().prepareStatement("select * from passwords where id = ?");
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    ConsoleHelper.writeMessage("--------------------");
                    ConsoleHelper.writeMessage(resultSet.getString("site") + " - " + resultSet.getString("password"));
                }
            } else {
                ConsoleHelper.writeMessage("Wrong data. Try again");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
