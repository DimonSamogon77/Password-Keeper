package PasswordKeeper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void updatePassword() {
        HelpMethods.showDatabase();
        while (true) {
            try {
                String i = ConsoleHelper.readMessage();
                ConsoleHelper.writeMessage("--------------------");
                ConsoleHelper.writeMessage("Введите новый пароль:");
                String j = ConsoleHelper.readMessage();
                if (i != null && j != null) {
                    int i1 = Integer.parseInt(i);
                    int j1 = Integer.parseInt(j);
                    PreparedStatement preparedStatement = Connect.connection().prepareStatement("update passwords set password = ? where id  = ?");
                    preparedStatement.setInt(1, j1);
                    preparedStatement.setInt(2, i1);
                    preparedStatement.executeUpdate();
                    break;
                } else {
                    ConsoleHelper.writeMessage("Wrong data. Try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
