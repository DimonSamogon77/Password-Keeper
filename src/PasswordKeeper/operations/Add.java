package PasswordKeeper.operations;

import PasswordKeeper.Frame;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {

    public static void add(){
        String site = Frame.getSite();
        String password = Frame.getPassword();
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
