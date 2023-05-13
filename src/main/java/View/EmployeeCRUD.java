package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCRUD extends JFrame  {
    private JTextField nume;
    private JTextField tip;
    private JTextField categorie;
    private JTextField anulRealizarii;

    private JLabel numeL;
    private JLabel tipL;
    private JLabel categorieL;
    private JLabel anulRealizariiL;

    private JButton createButton;
    private JButton updateButton;

    private JButton BACKButton;

    private JPanel EmployeeCRUD;
    private JFrame frame;
    private String filmId;
    private JComboBox comboBox;
    public EmployeeCRUD(String filmId){
        frame=new JFrame("EmployeeCRUD");
        frame.setSize(500,300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        EmployeeCRUD =new JPanel();
        EmployeeCRUD.setLayout(null);
        EmployeeCRUD.setBackground(new Color(255,255,255));
        EmployeeCRUD.setBounds(0,0,600,500);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(390, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        EmployeeCRUD.add(comboBox);

        nume=new JTextField("");
        nume.setBounds(120, 50, 150, 30);
        nume.setForeground(Color.BLACK);
        nume.setBackground(new Color(169,169,169));
        nume.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(nume);

        numeL = new JLabel("Name:");
        numeL.setBounds(20, 50, 100, 30);
        numeL.setForeground(Color.BLACK);
        numeL.setFont(new Font("Verdana", Font.BOLD, 14));
        EmployeeCRUD.add(numeL);

        tip=new JTextField("");
        tip.setBounds(120, 100, 150, 30);
        tip.setForeground(Color.BLACK);
        tip.setBackground(new Color(169,169,169));
        tip.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(tip);

        tipL = new JLabel("Tip:");
        tipL.setBounds(20, 100, 100, 30);
        tipL.setForeground(Color.BLACK);
        tipL.setFont(new Font("Verdana", Font.BOLD, 14));
        EmployeeCRUD.add(tipL);

        categorie=new JTextField("");
        categorie.setBounds(120, 150, 150, 30);
        categorie.setForeground(Color.BLACK);
        categorie.setBackground(new Color(169,169,169));
        categorie.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(categorie);

        categorieL = new JLabel("Category:");
        categorieL.setBounds(20, 150, 100, 30);
        categorieL.setForeground(Color.BLACK);
        categorieL.setFont(new Font("Verdana", Font.BOLD, 14));
        EmployeeCRUD.add(categorieL);

        anulRealizarii=new JTextField("");
        anulRealizarii.setBounds(120, 200, 150, 30);
        anulRealizarii.setForeground(Color.BLACK);
        anulRealizarii.setBackground(new Color(169,169,169));
        anulRealizarii.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(anulRealizarii);

        anulRealizariiL = new JLabel("Year:");
        anulRealizariiL.setBounds(20, 200, 100, 30);
        anulRealizariiL.setForeground(Color.BLACK);
        anulRealizariiL.setFont(new Font("Verdana", Font.BOLD, 14));
        EmployeeCRUD.add(anulRealizariiL);



        createButton = new JButton("Create");
        createButton.setBounds(300, 150, 150, 30);
        createButton.setForeground(Color.BLACK);
        createButton.setBackground(new Color(169,169,169));
        createButton.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(createButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(300, 150, 150, 30);
        updateButton.setForeground(Color.BLACK);
        updateButton.setBackground(new Color(169,169,169));
        updateButton.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(updateButton);


        BACKButton = new JButton("Back");
        BACKButton.setBounds(300, 200, 150, 30);
        BACKButton.setForeground(Color.BLACK);
        BACKButton.setBackground(new Color(169,169,169));
        BACKButton.setFont(new Font("Verdana", Font.BOLD, 16));
        EmployeeCRUD.add(BACKButton);

        frame.add(EmployeeCRUD);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.filmId=filmId;
        if(filmId==null){

            updateButton.setVisible(false);


        }
        else{

            createButton.setVisible(false);

        }

    }

    public JTextField getNume() {
        return nume;
    }

    public JTextField getTip() {
        return tip;
    }

    public JTextField getCategorie() {
        return categorie;
    }

    public JTextField getAnulRealizarii() {
        return anulRealizarii;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getBACKButton() {
        return BACKButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setNume(String nume) {
        this.nume.setText(nume);
    }

    public void setTip(String tip) {
        this.tip.setText(tip);
    }

    public void setCategorie(String categorie) {
        this.categorie.setText(categorie);
    }

    public void setAnulRealizarii(String anulRealizarii) {
        this.anulRealizarii.setText(anulRealizarii);
    }
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setNumeL(JLabel numeL) {
        this.numeL = numeL;
    }

    public void setTipL(JLabel tipL) {
        this.tipL = tipL;
    }

    public void setCategorieL(JLabel categorieL) {
        this.categorieL = categorieL;
    }

    public void setAnulRealizariiL(JLabel anulRealizariiL) {
        this.anulRealizariiL = anulRealizariiL;
    }

    public JLabel getNumeL() {
        return numeL;
    }

    public JLabel getTipL() {
        return tipL;
    }

    public JLabel getCategorieL() {
        return categorieL;
    }

    public JLabel getAnulRealizariiL() {
        return anulRealizariiL;
    }
}

