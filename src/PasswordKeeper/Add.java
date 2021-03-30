package PasswordKeeper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {

    public static void add(){
        ConsoleHelper.writeMessage("Введите сайт:");
        String site = ConsoleHelper.readMessage();
        ConsoleHelper.writeMessage("Введите пароль:");
        String password = ConsoleHelper.readMessage();
        try {
            PreparedStatement statement = Connect.connection().prepareStatement("insert into passwords (site, password) values(?, ?)");
            statement.setString(1, site);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
