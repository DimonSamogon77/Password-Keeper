package PasswordKeeper;

import PasswordKeeper.operations.Add;
import PasswordKeeper.operations.Delete;
import PasswordKeeper.operations.Get;
import PasswordKeeper.operations.Update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Frame {
    private static final JFrame jFrame = getFrame();
    private static final JPanel jPanel = new JPanel();


    public static void execute() {
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
        ImageIcon icon = new ImageIcon("C:\\Users\\baran\\Desktop\\icon2.png");
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 100, 800, 200);
        jFrame.setTitle("PasswordKeeper");
        jFrame.setIconImage(icon.getImage());
        return jFrame;
    }

    public static String getSite() {
        return JOptionPane.showInputDialog(jFrame, "Enter site", "Site", JOptionPane.QUESTION_MESSAGE);
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
            return null;
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
}
