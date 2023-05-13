package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    private String[] head={"Last name","First name","address","type","Username","Password"};
    private Object[][] objects=new Object[100][6];

    private JTable model;

    private JButton vizualizareUseriButton;
    private JButton BACKButton;
    private JButton selectUserButton;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JPanel Admin;
     private JComboBox comboBox1 = new JComboBox(new String[]{"admin","manager","employee"});
    private JButton filterButton;

    private JFrame frame;
    private JLabel userTableTitle;
    private JComboBox comboBox;




    public Admin(){


        frame=new JFrame("Admin");
        frame.setSize(1000,500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));

        Admin =new JPanel();
        Admin.setLayout(null);
        Admin.setBackground(new Color(255,255,255));
        Admin.setBounds(0,0,1000,500);



        model=new JTable(objects,head);
        JScrollPane scrollPane = new JScrollPane(model);
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(50, 50, 700, 350);
        Admin.add(scrollPane);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(890, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        Admin.add(comboBox);

        comboBox1.setEnabled(true);
        comboBox1.setBounds(800, 50, 150, 30);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBackground(new Color(169,169,169));
        comboBox1.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(comboBox1);


        filterButton = new JButton("Filter");
        filterButton.setBounds(800, 100, 150, 30);
        filterButton.setForeground(Color.BLACK);
        filterButton.setBackground(new Color(169,169,169));
        filterButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(filterButton);

        vizualizareUseriButton = new JButton("Show All");
        vizualizareUseriButton.setBounds(800, 150, 150, 30);
        vizualizareUseriButton.setForeground(Color.BLACK);
        vizualizareUseriButton.setBackground(new Color(169,169,169));
        vizualizareUseriButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(vizualizareUseriButton);

        selectUserButton = new JButton("Select User");
        selectUserButton.setBounds(800, 200, 150, 30);
        selectUserButton.setForeground(Color.BLACK);
        selectUserButton.setBackground(new Color(169,169,169));
        selectUserButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(selectUserButton);

        createUserButton = new JButton("Create User");
        createUserButton.setBounds(800, 250, 150, 30);
        createUserButton.setForeground(Color.BLACK);
        createUserButton.setBackground(new Color(169,169,169));
        createUserButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(createUserButton);

        deleteUserButton = new JButton("Delete User");
        deleteUserButton.setBounds(800, 300, 150, 30);
        deleteUserButton.setForeground(Color.BLACK);
        deleteUserButton.setBackground(new Color(169,169,169));
        deleteUserButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(deleteUserButton);

        BACKButton = new JButton("Back");
        BACKButton.setBounds(800, 350, 150, 30);
        BACKButton.setForeground(Color.BLACK);
        BACKButton.setBackground(new Color(169,169,169));
        BACKButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Admin.add(BACKButton);




        frame.add(Admin);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public JTable getModel() {
        return model;
    }

    public JButton getVizualizareUseriButton() {
        return vizualizareUseriButton;
    }

    public JButton getBACKButton() {
        return BACKButton;
    }


    public JButton getSelectUserButton() {
        return selectUserButton;
    }

    public JButton getCreateUserButton() {
        return createUserButton;
    }

    public JButton getDeleteUserButton() {
        return deleteUserButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    public Object[][] getObjects() {
        return objects;
    }

    public JFrame getFrame() {
        return frame;
    }
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setUserTableTitle(JLabel userTableTitle) {
        this.userTableTitle = userTableTitle;
    }

    public String[] getHead() {
        return head;
    }

    public void setHead(String[] head) {
        this.head = head;
    }
}
