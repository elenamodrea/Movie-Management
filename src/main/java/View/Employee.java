package View;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee extends JFrame  {
    private JPanel panel1;
    private String[] head={"name","type","year","category"};
    private Object[][] objects=new Object[100][4];

    private JTable model=new JTable(objects,head);
    private String[] fields1=new String[]{"none","type","year"};
    private JComboBox comboBox1=new JComboBox(fields1);
    private JButton sortareButton;
    private String[] fields2=new String[]{"none","artistic","series"};
    private JComboBox comboBox2=new JComboBox(fields2);
    private String[] fields3=new String[]{"none","comedy","romantic","drama","thriller"};
    private JComboBox comboBox3=new JComboBox(fields3);
    private JButton filtrareButton;

    private JTextField textField1;
     private JTextField textField2;
     private JTextField textField3;
    private JButton BACKButton;
    private JButton selectFilmButton;
    private JButton createFilmButton;
    private JButton deleteFilmButton;
    private JPanel Employee;
    private JButton showAllButton;
    private JButton searchButton;
    private JButton downloadButton;
    private JFrame frame;

    private JLabel filmTableTitle;
    private JLabel type;
    private JLabel tip;
    private JLabel category;
    private JLabel title;
    private JLabel format;
    private JComboBox comboBox;

    public Employee(){


        frame=new JFrame("Employee");
        frame.setSize(1000,850);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        Employee =new JPanel();
        Employee.setLayout(null);
        Employee.setBackground(new Color(255,255,255));
        Employee.setBounds(0,0,1000,850);


        JScrollPane scrollPane = new JScrollPane(model);
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(50, 50, 700, 750);
        Employee.add(scrollPane);


        comboBox1.setEnabled(true);
        comboBox1.setBounds(800, 50, 150, 30);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBackground(new Color(169,169,169));
        comboBox1.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(comboBox1);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(890, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        Employee.add(comboBox);

        sortareButton = new JButton("Sort");
        sortareButton.setBounds(800, 100, 150, 30);
        sortareButton.setForeground(Color.BLACK);
        sortareButton.setBackground(new Color(169,169,169));
        sortareButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(sortareButton);

        comboBox2.setEnabled(true);
        comboBox2.setBounds(800, 150, 150, 30);
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setBackground(new Color(169,169,169));
        comboBox2.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(comboBox2);

        tip = new JLabel("Type:");
        tip.setBounds(750, 150, 50, 30);
        tip.setForeground(Color.BLACK);
        tip.setFont(new Font("Verdana", Font.BOLD, 14));
        Employee.add(tip);

        comboBox3.setEnabled(true);
        comboBox3.setBounds(800, 200, 150, 30);
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setBackground(new Color(169,169,169));
        comboBox3.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(comboBox3);

        category = new JLabel("Category:");
        category.setBounds(750, 200, 50, 30);
        category.setForeground(Color.BLACK);
        category.setFont(new Font("Verdana", Font.BOLD, 14));
        Employee.add(category);

        textField1=new JTextField();
        textField1.setBounds(800, 250, 150, 30);
        textField1.setForeground(Color.BLACK);
        textField1.setBackground(new Color(169,169,169));
        textField1.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(textField1);

        type = new JLabel("Year:");
        type.setBounds(760, 250, 50, 30);
        type.setForeground(Color.BLACK);
        type.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(type);


        filtrareButton = new JButton("Filter");
        filtrareButton.setBounds(800, 300, 150, 30);
        filtrareButton.setForeground(Color.BLACK);
        filtrareButton.setBackground(new Color(169,169,169));
        filtrareButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(filtrareButton);

        textField2=new JTextField("");
        textField2.setBounds(800, 350, 150, 30);
        textField2.setForeground(Color.BLACK);
        textField2.setBackground(new Color(169,169,169));
        textField2.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(textField2);

        title = new JLabel("Title:");
        title.setBounds(750, 350, 50, 30);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Verdana", Font.BOLD, 14));
        Employee.add(title);


        searchButton = new JButton("Search");
        searchButton.setBounds(800, 400, 150, 30);
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(new Color(169,169,169));
        searchButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(searchButton);

        textField3=new JTextField("csv");
        textField3.setBounds(800, 450, 150, 30);
        textField3.setForeground(Color.BLACK);
        textField3.setBackground(new Color(169,169,169));
        textField3.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(textField3);

        format = new JLabel("Format:");
        format.setBounds(750, 450, 50, 30);
        format.setForeground(Color.BLACK);
        format.setFont(new Font("Verdana", Font.BOLD, 14));
        Employee.add(format);


        downloadButton = new JButton("Download");
        downloadButton.setBounds(800, 500, 150, 30);
        downloadButton.setForeground(Color.BLACK);
        downloadButton.setBackground(new Color(169,169,169));
        downloadButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(downloadButton);

        selectFilmButton = new JButton("Select Movie");
        selectFilmButton.setBounds(800, 550, 150, 30);
        selectFilmButton.setForeground(Color.BLACK);
        selectFilmButton.setBackground(new Color(169,169,169));
        selectFilmButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(selectFilmButton);

        createFilmButton = new JButton("Create Movie");
        createFilmButton.setBounds(800, 600, 150, 30);
        createFilmButton.setForeground(Color.BLACK);
        createFilmButton.setBackground(new Color(169,169,169));
        createFilmButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(createFilmButton);

        deleteFilmButton = new JButton("Delete Movie");
        deleteFilmButton.setBounds(800, 650, 150, 30);
        deleteFilmButton.setForeground(Color.BLACK);
        deleteFilmButton.setBackground(new Color(169,169,169));
        deleteFilmButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(deleteFilmButton);

        showAllButton = new JButton("Show all");
        showAllButton.setBounds(800, 700, 150, 30);
        showAllButton.setForeground(Color.BLACK);
        showAllButton.setBackground(new Color(169,169,169));
        showAllButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(showAllButton);


        BACKButton = new JButton("Back");
        BACKButton.setBounds(800, 750, 150, 30);
        BACKButton.setForeground(Color.BLACK);
        BACKButton.setBackground(new Color(169,169,169));
        BACKButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Employee.add(BACKButton);



        frame.add(Employee);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public Object[][] getObjects() {
        return objects;
    }

    public JTable getModel() {
        return model;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JButton getSortareButton() {
        return sortareButton;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JComboBox getComboBox3() {
        return comboBox3;
    }

    public JButton getFiltrareButton() {
        return filtrareButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JButton getBACKButton() {
        return BACKButton;
    }

    public JButton getSelectFilmButton() {
        return selectFilmButton;
    }

    public JButton getCreateFilmButton() {
        return createFilmButton;
    }

    public JButton getDeleteFilmButton() {
        return deleteFilmButton;
    }

    public JButton getShowAllButton() {
        return showAllButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getDownloadButton() {
        return downloadButton;
    }

    public JFrame getFrame() {
        return frame;
    }
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setFilmTableTitle(JLabel filmTableTitle) {
        this.filmTableTitle = filmTableTitle;
    }

    public void setType(JLabel type) {
        this.type = type;
    }

    public void setTip(JLabel tip) {
        this.tip = tip;
    }

    public void setCategory(JLabel category) {
        this.category = category;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setFormat(JLabel format) {
        this.format = format;
    }


    public JLabel getType1() {
        return type;
    }

    public JLabel getTip() {
        return tip;
    }

    public JLabel getCategory() {
        return category;
    }

    public JLabel getTitle1() {
        return title;
    }

    public JLabel getFormat() {
        return format;
    }
}
