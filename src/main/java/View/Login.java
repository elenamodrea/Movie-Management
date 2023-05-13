package View;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame  {
     private JTextField username;
     private JLabel usernameL;
    private JPanel Login;
     private JPasswordField password;
     private JLabel passwordL;
    private JButton LOGINButton;
    private JFrame frame;
    private JComboBox comboBox;





    public Login(){
        frame=new JFrame("Login");
        frame.setSize(300,300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
         Login=new JPanel();
        Login.setLayout(null);
        Login.setBackground(new Color(255,255,255));
        Login.setBounds(0,0,300,300);

        comboBox=new JComboBox(new String[]{"english","deutsch","spanish"});
        comboBox.setBounds(200, 10, 80, 15);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(new Color(169,169,169));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 9));
        Login.add(comboBox);

        username=new JTextField("");
        username.setBounds(120, 50, 150, 30);
        username.setForeground(Color.BLACK);
        username.setBackground(new Color(169,169,169));
        username.setFont(new Font("Verdana", Font.BOLD, 16));
        Login.add( username);

        usernameL = new JLabel("Username:");
        usernameL.setBounds(20, 50, 100, 30);
        usernameL.setForeground(Color.BLACK);
        usernameL.setFont(new Font("Verdana", Font.BOLD, 14));
        Login.add(usernameL);

        password=new JPasswordField();
        password.setBounds(120, 100, 150, 30);
        password.setForeground(Color.BLACK);
        password.setBackground(new Color(169,169,169));
        password.setFont(new Font("Verdana", Font.BOLD, 16));
        Login.add(password);

        passwordL = new JLabel("Password:");
        passwordL.setBounds(20, 100, 100, 30);
        passwordL.setForeground(Color.BLACK);
        passwordL.setFont(new Font("Verdana", Font.BOLD, 14));
        Login.add(passwordL);

        LOGINButton = new JButton("Login");
        LOGINButton.setBounds(70, 150, 150, 30);
        LOGINButton.setForeground(Color.BLACK);
        LOGINButton.setBackground(new Color(169,169,169));
        LOGINButton.setFont(new Font("Verdana", Font.BOLD, 16));
        Login.add(LOGINButton);

        frame.add(Login);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }

    public JButton getLOGINButton() {
        return LOGINButton;
    }

    public JTextField getUsername() {
        return username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JFrame getFrame() {
        return frame;
    }
    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setUsernameL(JLabel usernameL) {
        this.usernameL = usernameL;
    }

    public void setPasswordL(JLabel passwordL) {
        this.passwordL = passwordL;
    }

    public JLabel getUsernameL() {
        return usernameL;
    }

    public JPanel getLogin() {
        return Login;
    }

    public JLabel getPasswordL() {
        return passwordL;
    }
}
