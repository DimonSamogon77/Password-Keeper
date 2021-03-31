package PasswordKeeper.operations;

import PasswordKeeper.Frame;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {

    public static void add(){
        String[] data = Frame.addSite();
        String site = data[0];
        String password = data[1];
        try {
            PreparedStatement statement = Connect.getInstance().prepareStatement("insert into passwords (site, password) values(?, ?)");
            statement.setString(1, site);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
