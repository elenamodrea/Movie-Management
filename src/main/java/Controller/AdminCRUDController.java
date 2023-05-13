package Controller;

import Model.Email;
import Model.Persistence.RandomID;
import Model.Persistence.UserPersistence;
import Model.Sms;
import Model.User;
import Model.Dictionary;
import View.AdminCRUD;

import javax.swing.*;

public class AdminCRUDController implements Observer{
    private AdminCRUD adminCRUD;
    private UserPersistence userPersistence;
    private String idUser;
    private Dictionary dictionary;

    public AdminCRUDController(String idUser) {
        this.idUser=idUser;
        adminCRUD=new AdminCRUD(idUser);
        userPersistence=new UserPersistence();
        dictionary=new Dictionary();
        dictionary.addObserver(this);
        actions();
        if(idUser!=null){
            see();
        }

    }
    private void actions(){
        adminCRUD.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(adminCRUD.getComboBox().getSelectedIndex());
                }
        );
        adminCRUD.getBACKButton().addActionListener(e-> {
            new AdminController();
            adminCRUD.getFrame().dispose();
        });
        adminCRUD.getCreateButton().addActionListener(e-> {
            create();
        });
        adminCRUD.getUpdateButton().addActionListener(e-> {
            updateUser();
        });

    }
    private void create(){
        RandomID randomID=new RandomID();
        User user=new User(randomID.getRandomID(), adminCRUD.getNume().getText(), adminCRUD.getPrenume().getText(), adminCRUD.getTelefon().getText(),
                adminCRUD.getAdresa().getText(), adminCRUD.getEmail().getText(), adminCRUD.getTipUser().getText(), adminCRUD.getUsername().getText(), adminCRUD.getParola().getText());
        userPersistence.create(user);
        JOptionPane.showMessageDialog(new JFrame(),dictionary.getUserCreated()[dictionary.getLanguage()]);

    }
    private void updateUser(){
        User user=userPersistence.get(idUser);
        Sms sms=new Sms();
        Email email=new Email();
        User user2=new User(user.getIdUser(), adminCRUD.getNume().getText(), adminCRUD.getPrenume().getText(), adminCRUD.getTelefon().getText(),
                adminCRUD.getAdresa().getText(), adminCRUD.getEmail().getText(), adminCRUD.getTipUser().getText(), adminCRUD.getUsername().getText(), adminCRUD.getParola().getText());

        if((!user.getUsername().equals(user2.getUsername()))||(!user.getParola().equals(user2.getParola()))){
            sms.sendSms(user.getTelefon());
            email.sendMail(user.getMail(),user.getMail(),"Your credentials had been changed");
        }
        userPersistence.update(user2);

        JOptionPane.showMessageDialog(new JFrame(),dictionary.getUserUpdated()[dictionary.getLanguage()]);

    }
    private void see(){
        User user=userPersistence.get(idUser);
        adminCRUD.setAdresa(user.getAdresa());
        adminCRUD.setEmail(user.getMail());
        adminCRUD.setNume(user.getNume());
        adminCRUD.setPrenume(user.getPrenume());
        adminCRUD.setTipUser(user.getTipUser());
        adminCRUD.setTelefon(user.getTelefon());
        adminCRUD.setUsername(user.getUsername());
        adminCRUD.setParola(user.getParola());
    }

    @Override
    public void update() {
        int i=dictionary.getLanguage();
        adminCRUD.getNumeL().setText(dictionary.getLastName()[i]);
        adminCRUD.getPrenumeL().setText(dictionary.getFirstName()[i]);
        adminCRUD.getAdresaL().setText(dictionary.getAddress()[i]);
        adminCRUD.getTelefonL().setText(dictionary.getTelephone()[i]);
        adminCRUD.getTipUserL().setText(dictionary.getType()[i]);
        adminCRUD.getEmailL().setText(dictionary.getEmail()[i]);
        adminCRUD.getUsernameL().setText(dictionary.getUsername()[i]);
        adminCRUD.getParolaL().setText(dictionary.getPasswword()[i]);
        adminCRUD.getCreateButton().setText(dictionary.getCreateButton()[i]);
        adminCRUD.getUpdateButton().setText(dictionary.getUpdateButton()[i]);
        adminCRUD.getBACKButton().setText(dictionary.getBackButton()[i]);
    }
}
