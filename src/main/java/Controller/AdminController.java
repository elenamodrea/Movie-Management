package Controller;

import Model.Persistence.UserPersistence;
import Model.User;
import Model.Dictionary;
import View.Admin;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class AdminController implements Observer{
    private Admin admin;
    private UserPersistence userPersistence;
    private Dictionary dictionary;

    public AdminController() {
        this.admin=new Admin();
        this.userPersistence=new UserPersistence();
        dictionary=new Dictionary();
        dictionary.addObserver(this);
        actions();
    }
    private void actions(){
        admin.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(admin.getComboBox().getSelectedIndex());
                }
        );
        admin.getBACKButton().addActionListener(e-> {
              new LoginController();
            admin.getFrame().dispose();
            });
        admin.getCreateUserButton().addActionListener(e-> {

                new AdminCRUDController(null);
                admin.getFrame().dispose();

        });
        admin.getVizualizareUseriButton().addActionListener(e-> {
              getUsers();
        });

        admin.getFilterButton().addActionListener(e-> {
            filter();
        });

        admin.getSelectUserButton().addActionListener(e-> {
            selectUser();
        });
        admin.getDeleteUserButton().addActionListener(e-> {
            delete();
        });

    }
    private void clear(){
        for(int i=0;i<100;i++){
            for(int j=0;j<6;j++){
                admin.getObjects()[i][j]="";
            }
        }
    }
    private void getUsers(){
        clear();
        List<User> users=userPersistence.findAll();
        int i=0;

        for (User utilizator: users)
        {

            admin.getObjects()[i][0]=utilizator.getNume();
            admin.getObjects()[i][1]=utilizator.getPrenume();
            admin.getObjects()[i][2]=utilizator.getAdresa();
            admin.getObjects()[i][3]=utilizator.getTipUser();
            admin.getObjects()[i][4]=utilizator.getUsername();
            admin.getObjects()[i++][5]=utilizator.getParola();

        }
        admin.getFrame().repaint();
    }
    private void selectUser(){
        int index=admin.getModel().getSelectedRow();
        String userName= (String) admin.getObjects()[index][4];
        User user=userPersistence.getUserName(userName);
        new AdminCRUDController(user.getIdUser());
        admin.getFrame().dispose();
    }
    private void filter(){
        int typeIndex=admin.getComboBox1().getSelectedIndex();
        String[] type=new String[]{"admin","manager","employee"};
        clear();
            List<User> list = userPersistence.findAll();
            int i = 0;
            for (User utilizator : list) {
                if (utilizator.getTipUser().equals(type[typeIndex])) {
                    admin.getObjects()[i][0] = utilizator.getNume();
                    admin.getObjects()[i][1] = utilizator.getPrenume();
                    admin.getObjects()[i][2] = utilizator.getAdresa();
                    admin.getObjects()[i][3] = utilizator.getTipUser();
                    admin.getObjects()[i][4] = utilizator.getUsername();
                    admin.getObjects()[i++][5] = utilizator.getParola();

                }
            }
            admin.getFrame().repaint();

    }
    private void delete(){
        int index=admin.getModel().getSelectedRow();
        String userName= (String) admin.getObjects()[index][4];
        User user=userPersistence.getUserName(userName);
        userPersistence.delete(user.getIdUser());
        JOptionPane.showMessageDialog(new JFrame(),dictionary.getUserDeleted()[dictionary.getLanguage()]);
        getUsers();
    }

    @Override
    public void update() {
        int i= dictionary.getLanguage();
        admin.getComboBox1().setModel((ComboBoxModel) new JComboBox(dictionary.getAdminCombo()[i]));
        admin.getFilterButton().setText(dictionary.getFilterButton()[i]);
        admin.getVizualizareUseriButton().setText(dictionary.getShowAllButton()[i]);
        admin.getSelectUserButton().setText(dictionary.getSelectUserButton()[i]);
        admin.getCreateUserButton().setText(dictionary.getCreateUserButton()[i]);
        admin.getDeleteUserButton().setText(dictionary.getDeleteUserButton()[i]);
        admin.getBACKButton().setText(dictionary.getBackButton()[i]);
        JTableHeader header = admin.getModel().getTableHeader();
        TableColumnModel colModel = header.getColumnModel();
        for (int j = 0; j < colModel.getColumnCount(); j++) {
            TableColumn col = colModel.getColumn(j);
            col.setHeaderValue(dictionary.getUserTable()[i][j]);
        }
        header.repaint();
    }
}
