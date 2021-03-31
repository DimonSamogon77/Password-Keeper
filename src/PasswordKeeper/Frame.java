package PasswordKeeper;

import PasswordKeeper.operations.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Frame {
    private static JFrame jFrame;
    private static JPanel jPanel;


    public static void execute() {
        while(true) {
            try {
                Connect.getInstance();
                break;
            }catch (SQLException e){
                int res = JOptionPane.showConfirmDialog(null, "Incorrect data", "Error", JOptionPane.OK_CANCEL_OPTION);
                if(res == -1 || res == 2){
                    System.exit(0);
                }
                e.printStackTrace();
            }
        }
        jFrame = getFrame();
        jPanel = new JPanel();
        jFrame.add(jPanel);
        buttons();
        jPanel.revalidate();
    }

    public static void buttons() {
        JButton info = new JButton("Info");
        info.addActionListener(e -> showDB());
        jPanel.add(info);

        JButton add = new JButton("Add");
        add.addActionListener(e -> Add.add());
        jPanel.add(add);

        JButton get = new JButton("Get");
        get.addActionListener(e -> Get.get());
        jPanel.add(get);

        JButton update = new JButton("Update");
        update.addActionListener(e -> Update.updatePassword());
        jPanel.add(update);

        JButton delete = new JButton("Delete");
        delete.addActionListener(e -> Delete.delete());
        jPanel.add(delete);

        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            if(exitMessage() == 0){
                System.exit(0);
            }
        });
        jPanel.add(exit);

    }

    public static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 100, 800, 200);
        jFrame.setTitle("PasswordKeeper");
        return jFrame;
    }


    public static String getPassword() {
        return JOptionPane.showInputDialog(jFrame, "Enter Password", "Password", JOptionPane.QUESTION_MESSAGE);
    }

    public static String choose() {
        List<String> list  = HelpMethods.showDatabase();
        if(list != null) {
            Object[] data = new Object[list.size()];
            for (int i = 0; i < list.size(); i++) {
                data[i] = list.get(i);
            }
            String s = (String) JOptionPane.showInputDialog(jFrame, "Choose one", "Choose", JOptionPane.INFORMATION_MESSAGE, null, data, data[0]);
            String[] res = s.split(" ");
            return res[0];
        } else{
            errorMessage();
            return "-1";
        }
    }

    public static void showInfo(String s) {
        JOptionPane.showMessageDialog(jFrame, s, "Your password", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorMessage(){
        JOptionPane.showMessageDialog(jFrame, "Something went wrong","Error", JOptionPane.ERROR_MESSAGE);
    }

    public static int exitMessage(){
        return JOptionPane.showConfirmDialog(jFrame, "Are you sure?", "System message", JOptionPane.YES_NO_OPTION);
    }

    public static void showDB(){
        List<String> list  = HelpMethods.showDatabase();
        if(list != null) {
            String[] data = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                data[i] = list.get(i);
            }
            JScrollPane jScrollPane = new JScrollPane(new JList<>(data));
            JOptionPane.showMessageDialog(jFrame, jScrollPane, "DataBase", JOptionPane.INFORMATION_MESSAGE);
        } else{
            errorMessage();
        }
    }

    public static String[] loginMessage(){
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
        label.add(new JLabel("Login", SwingConstants.RIGHT));
        label.add(new JLabel("Password", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField username = new JTextField();
        controls.add(username);
        JPasswordField password = new JPasswordField();
        controls.add(password);
        panel.add(controls, BorderLayout.CENTER);

        JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);
        return new String[]{username.getText(), new String(password.getPassword())};
    }

    public static String[] addSite(){
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
        label.add(new JLabel("Site name", SwingConstants.RIGHT));
        label.add(new JLabel("Password", SwingConstants.RIGHT));
        panel.add(label, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField site = new JTextField();
        site.setDocument(new LimitedDocument(20));
        controls.add(site);
        JPasswordField password = new JPasswordField();
        password.setDocument(new LimitedDocument(30));
        controls.add(password);
        panel.add(controls, BorderLayout.CENTER);

        JOptionPane.showConfirmDialog(null, panel, "Adding", JOptionPane.OK_CANCEL_OPTION);
        return new String[]{site.getText(), new String(password.getPassword())};
    }
}