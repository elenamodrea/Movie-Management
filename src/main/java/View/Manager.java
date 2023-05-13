package View;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Manager extends JPanel {
    private JPanel Manager;
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
    private JButton showAllButton;
    private JButton downloadButton;
    private JButton searchButton;

    private JFrame frame;
    private JLabel filmTableTitle;
    private JLabel type;
    private JLabel tip;
    private JLabel category;

    private JLabel title;
    private JLabel format;
    private JComboBox comboBox;
    private DefaultPieDataset dataset;
    private JFreeChart chart;
    private JFreeChart chart2;

    public Manager(){


        frame=new JFrame("Manager");
        frame.setSize(1000,750);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        Manager =new JPanel();
        Manager.setLayout(null);
        Manager.setBackground(new Color(255,255,255));
        Manager.setBounds(0,0,1000,700);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(890, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        Manager.add(comboBox);


        JScrollPane scrollPane = new JScrollPane(model);
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(50, 50, 700, 300);
        Manager.add(scrollPane);


        comboBox1.setEnabled(true);
        comboBox1.setBounds(800, 50, 150, 30);
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setBackground(new Color(169,169,169));
        comboBox1.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(comboBox1);


        sortareButton = new JButton("Sort");
        sortareButton.setBounds(800, 100, 150, 30);
        sortareButton.setForeground(Color.BLACK);
        sortareButton.setBackground(new Color(169,169,169));
        sortareButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(sortareButton);

        comboBox2.setEnabled(true);
        comboBox2.setBounds(800, 150, 150, 30);
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setBackground(new Color(169,169,169));
        comboBox2.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(comboBox2);

        tip = new JLabel("Type:");
        tip.setBounds(750, 150, 50, 30);
        tip.setForeground(Color.BLACK);
        tip.setFont(new Font("Verdana", Font.BOLD, 14));
        Manager.add(tip);

        comboBox3.setEnabled(true);
        comboBox3.setBounds(800, 200, 150, 30);
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setBackground(new Color(169,169,169));
        comboBox3.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(comboBox3);

        category = new JLabel("Category:");
        category.setBounds(750, 200, 50, 30);
        category.setForeground(Color.BLACK);
        category.setFont(new Font("Verdana", Font.BOLD, 14));
        Manager.add(category);

        textField1=new JTextField();
        textField1.setBounds(800, 250, 150, 30);
        textField1.setForeground(Color.BLACK);
        textField1.setBackground(new Color(169,169,169));
        textField1.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(textField1);

        type = new JLabel("Year:");
        type.setBounds(760, 250, 50, 30);
        type.setForeground(Color.BLACK);
        type.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(type);


        filtrareButton = new JButton("Filter");
        filtrareButton.setBounds(800, 300, 150, 30);
        filtrareButton.setForeground(Color.BLACK);
        filtrareButton.setBackground(new Color(169,169,169));
        filtrareButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(filtrareButton);

        textField2=new JTextField("");
        textField2.setBounds(800, 350, 150, 30);
        textField2.setForeground(Color.BLACK);
        textField2.setBackground(new Color(169,169,169));
        textField2.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(textField2);

        title = new JLabel("Title:");
        title.setBounds(750, 350, 50, 30);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Verdana", Font.BOLD, 14));
        Manager.add(title);


        searchButton = new JButton("Search");
        searchButton.setBounds(800, 400, 150, 30);
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(new Color(169,169,169));
        searchButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(searchButton);

        textField3=new JTextField("");
        textField3.setBounds(800, 450, 150, 30);
        textField3.setForeground(Color.BLACK);
        textField3.setBackground(new Color(169,169,169));
        textField3.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(textField3);

        format = new JLabel("Format:");
        format.setBounds(750, 450, 50, 30);
        format.setForeground(Color.BLACK);
        format.setFont(new Font("Verdana", Font.BOLD, 14));
        Manager.add(format);


        downloadButton = new JButton("Download");
        downloadButton.setBounds(800, 500, 150, 30);
        downloadButton.setForeground(Color.BLACK);
        downloadButton.setBackground(new Color(169,169,169));
        downloadButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(downloadButton);

        showAllButton = new JButton("Show all");
        showAllButton.setBounds(800, 550, 150, 30);
        showAllButton.setForeground(Color.BLACK);
        showAllButton.setBackground(new Color(169,169,169));
        showAllButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(showAllButton);


        BACKButton = new JButton("Back");
        BACKButton.setBounds(800, 600, 150, 30);
        BACKButton.setForeground(Color.BLACK);
        BACKButton.setBackground(new Color(169,169,169));
        BACKButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Manager.add(BACKButton);

         dataset = new DefaultPieDataset();


        // create a chart
        chart = ChartFactory.createPieChart("Movie Category Percentage", dataset, true, true, false);
        chart2= ChartFactory.createRingChart("Movie Category Ring Chart", dataset, true, true, false);

        // set the plot properties
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(null);
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);

        // set the plot properties
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setLabelGenerator(null);
        plot2.setNoDataMessage("No data available");
        plot2.setCircular(true);



        // create a chart panel and add it to the panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.GRAY);
        chartPanel.setForeground(Color.WHITE);
        chartPanel.setBounds(50, 400, 300, 300);
        Manager.add(chartPanel);

        // create a chart panel and add it to the panel
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setBackground(Color.GRAY);
        chartPanel2.setForeground(Color.WHITE);
        chartPanel2.setBounds(400, 400, 300, 300);
        Manager.add(chartPanel2);

        frame.add(Manager);
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

    public JButton getFiltrareButton() {
        return filtrareButton;
    }

    public JComboBox getComboBox3() {
        return comboBox3;
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

    public JButton getShowAllButton() {
        return showAllButton;
    }

    public JButton getDownloadButton() {
        return downloadButton;
    }

    public JButton getSearchButton() {
        return searchButton;
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

    public JLabel getType() {
        return type;
    }

    public JLabel getTip() {
        return tip;
    }

    public JLabel getCategory() {
        return category;
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getFormat() {
        return format;
    }

    public DefaultPieDataset getDataset() {
        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }

}
