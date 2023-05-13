package Controller;

import Model.Persistence.UserPersistence;
import Model.User;
import Model.Dictionary;
import View.Login;

import javax.swing.*;

public class LoginController implements Observer{
    private Login login;
    private UserPersistence userPersistence;
    private Dictionary dictionary;

    public LoginController() {
        login = new Login();
         userPersistence = new UserPersistence();
         dictionary = new Dictionary();
         dictionary.addObserver(this);
        actions();

    }

    private void actions() {
        login.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(login.getComboBox().getSelectedIndex());
                }
        );
        login.getLOGINButton().addActionListener(e->{

                User user = userPersistence.getUserName(login.getUsername().getText());
                if (user != null) {
                   ;
                    if (login.getPassword().getText().equals(user.getParola())) {
                        if (user.getTipUser().equals("admin")) {
                            new AdminController();
                            login.getFrame().dispose();
                            JOptionPane.showMessageDialog(new JFrame(), dictionary.getAdminMessage()[dictionary.getLanguage()]);
                        } else if (user.getTipUser().equals("manager")) {
                            new ManagerController();
                            login.getFrame().dispose();
                            JOptionPane.showMessageDialog(new JFrame(), dictionary.getManagerMessage()[dictionary.getLanguage()]);

                        } else {
                            new EmployeeController();
                            login.getFrame().dispose();
                            JOptionPane.showMessageDialog(new JFrame(), dictionary.getEmployeeMessage()[dictionary.getLanguage()]);

                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), dictionary.getLoginMessage()[dictionary.getLanguage()]);

                    }
                }

        });

        }


    @Override
    public void update() {
        int i= dictionary.getLanguage();
        login.getUsernameL().setText(dictionary.getUsername()[i]);
        login.getPasswordL().setText(dictionary.getPasswword()[i]);
        login.getLOGINButton().setText(dictionary.getLoginButton()[i]);
    }
}
