package View;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCRUD extends JFrame {
     private JTextField nume;
    private JTextField prenume;
    private JTextField adresa;
    private JTextField telefon;
    private JTextField tipUser;
    private JTextField email;
    private JTextField username;
    private JLabel numeL;
    private JLabel prenumeL;
    private JLabel adresaL;
    private JLabel telefonL;
    private JLabel tipUserL;
    private JLabel emailL;
    private JLabel usernameL;
    private JLabel parolaL;
    private JButton updateButton;
    private JButton createButton;


    private JButton BACKButton;
    private JPanel AdminCRUD;
    private JTextField parola;

    private String userId;

    private JFrame frame;
    private JComboBox comboBox;

    public AdminCRUD(String userId){
        frame=new JFrame("AdminCRUD");
        frame.setSize(500,500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        AdminCRUD =new JPanel();
        AdminCRUD.setLayout(null);
        AdminCRUD.setBackground(new Color(255,255,255));
        AdminCRUD.setBounds(0,0,600,500);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(390, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        AdminCRUD.add(comboBox);

        nume=new JTextField("");
        nume.setBounds(120, 50, 150, 30);
        nume.setForeground(Color.BLACK);
        nume.setBackground(new Color(169,169,169));
        nume.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(nume);

        numeL = new JLabel("Last Name:");
        numeL.setBounds(20, 50, 100, 30);
        numeL.setForeground(Color.BLACK);
        numeL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(numeL);

        prenume=new JTextField("");
        prenume.setBounds(120, 100, 150, 30);
        prenume.setForeground(Color.BLACK);
        prenume.setBackground(new Color(169,169,169));
        prenume.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(prenume);

        prenumeL = new JLabel("First name:");
        prenumeL.setBounds(20, 100, 100, 30);
        prenumeL.setForeground(Color.BLACK);
        prenumeL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(prenumeL);

        adresa=new JTextField("");
        adresa.setBounds(120, 150, 150, 30);
        adresa.setForeground(Color.BLACK);
        adresa.setBackground(new Color(169,169,169));
        adresa.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(adresa);

        adresaL = new JLabel("Address:");
        adresaL.setBounds(20, 150, 100, 30);
        adresaL.setForeground(Color.BLACK);
        adresaL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(adresaL);

        telefon=new JTextField("");
        telefon.setBounds(120, 200, 150, 30);
        telefon.setForeground(Color.BLACK);
        telefon.setBackground(new Color(169,169,169));
        telefon.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(telefon);

        telefonL = new JLabel("Telephone:");
        telefonL.setBounds(20, 200, 100, 30);
        telefonL.setForeground(Color.BLACK);
        telefonL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(telefonL);

        tipUser=new JTextField("");
        tipUser.setBounds(120, 250, 150, 30);
        tipUser.setForeground(Color.BLACK);
        tipUser.setBackground(new Color(169,169,169));
        tipUser.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(tipUser);

        tipUserL = new JLabel("Type:");
        tipUserL.setBounds(20, 250, 100, 30);
        tipUserL.setForeground(Color.BLACK);
        tipUserL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(tipUserL);

        email=new JTextField("");
        email.setBounds(120, 300, 150, 30);
        email.setForeground(Color.BLACK);
        email.setBackground(new Color(169,169,169));
        email.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(email);

        emailL = new JLabel("Email:");
        emailL.setBounds(20, 300, 100, 30);
        emailL.setForeground(Color.BLACK);
        emailL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add(emailL);

        username=new JTextField("");
        username.setBounds(120, 350, 150, 30);
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(169,169,169));
        username.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(username);

        usernameL = new JLabel("Username:");
        usernameL.setBounds(20, 350, 100, 30);
        usernameL.setForeground(Color.BLACK);
        usernameL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add( usernameL);

        parola=new JTextField("");
        parola.setBounds(120, 400, 150, 30);
        parola.setForeground(Color.BLACK);
        parola.setBackground(new Color(169,169,169));
        parola.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(parola);

        parolaL = new JLabel("Password:");
        parolaL.setBounds(20, 400, 100, 30);
        parolaL.setForeground(Color.BLACK);
        parolaL.setFont(new Font("Verdana", Font.BOLD, 14));
        AdminCRUD.add( parolaL);

        createButton = new JButton("Create");
        createButton.setBounds(300, 350, 150, 30);
        createButton.setForeground(Color.BLACK);
        createButton.setBackground(new Color(169,169,169));
        createButton.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(createButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(300, 350, 150, 30);
        updateButton.setForeground(Color.BLACK);
        updateButton.setBackground(new Color(169,169,169));
        updateButton.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(updateButton);


        BACKButton = new JButton("Back");
        BACKButton.setBounds(300, 400, 150, 30);
        BACKButton.setForeground(Color.BLACK);
        BACKButton.setBackground(new Color(169,169,169));
        BACKButton.setFont(new Font("Verdana", Font.BOLD, 16));
        AdminCRUD.add(BACKButton);

        frame.add(AdminCRUD);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.userId=userId;
        if(userId==null){
            updateButton.setVisible(false);

        }
        else{
            createButton.setVisible(false);
        }



    }

    public JTextField getNume() {
        return nume;
    }

    public JTextField getPrenume() {
        return prenume;
    }

    public JTextField getAdresa() {
        return adresa;
    }

    public JTextField getTelefon() {
        return telefon;
    }

    public JTextField getTipUser() {
        return tipUser;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getUsername() {
        return username;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }


    public JButton getBACKButton() {
        return BACKButton;
    }

    public JTextField getParola() {
        return parola;
    }

    public String getUserId() {
        return userId;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setNume(String nume) {
        this.nume.setText(nume);
    }

    public void setPrenume(String prenume) {
        this.prenume.setText(prenume);
    }

    public void setAdresa(String adresa) {
        this.adresa.setText(adresa);
    }

    public void setTelefon(String telefon) {
        this.telefon.setText(telefon);
    }

    public void setTipUser(String tipUser) {
        this.tipUser.setText(tipUser);
    }

    public void setEmail(String email) {
        this.email.setText( email);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setParola(String parola) {
        this.parola.setText( parola);
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setNumeL(JLabel numeL) {
        this.numeL = numeL;
    }

    public void setPrenumeL(JLabel prenumeL) {
        this.prenumeL = prenumeL;
    }

    public void setAdresaL(JLabel adresaL) {
        this.adresaL = adresaL;
    }

    public void setTelefonL(JLabel telefonL) {
        this.telefonL = telefonL;
    }

    public void setTipUserL(JLabel tipUserL) {
        this.tipUserL = tipUserL;
    }

    public void setEmailL(JLabel emailL) {
        this.emailL = emailL;
    }

    public void setUsernameL(JLabel usernameL) {
        this.usernameL = usernameL;
    }

    public void setParolaL(JLabel parolaL) {
        this.parolaL = parolaL;
    }

    public JLabel getNumeL() {
        return numeL;
    }

    public JLabel getPrenumeL() {
        return prenumeL;
    }

    public JLabel getAdresaL() {
        return adresaL;
    }

    public JLabel getTelefonL() {
        return telefonL;
    }

    public JLabel getTipUserL() {
        return tipUserL;
    }

    public JLabel getEmailL() {
        return emailL;
    }

    public JLabel getUsernameL() {
        return usernameL;
    }

    public JLabel getParolaL() {
        return parolaL;
    }
}
