package Controller;

import Model.Film;
import Model.Persistence.FilmPersistence;
import Model.Persistence.RandomID;
import Model.Dictionary;
import View.EmployeeCRUD;

import javax.swing.*;

public class EmployeeCRUDController implements Observer{
    private EmployeeCRUD employeeCRUD;
    private FilmPersistence filmPersistence;
    private String idFilm;
    private Dictionary dictionary;
    public EmployeeCRUDController(String idFilm){
        this.idFilm=idFilm;
        this.employeeCRUD=new EmployeeCRUD(idFilm);
        this.filmPersistence=new FilmPersistence();
        dictionary=new Dictionary();
        dictionary.addObserver(this);
        actions();
        if(idFilm!=null){
            see();
        }
    }
    private void actions(){
        employeeCRUD.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(employeeCRUD.getComboBox().getSelectedIndex());
                }
        );
        employeeCRUD.getBACKButton().addActionListener(e-> {
            new EmployeeController();
            employeeCRUD.getFrame().dispose();
        });
        employeeCRUD.getCreateButton().addActionListener(e-> {
            create();
        });
        employeeCRUD.getUpdateButton().addActionListener(e-> {
            updateFilm();
        });

    }
    private void create(){
        RandomID randomID=new RandomID();
        Film film= new Film(randomID.getRandomID(), employeeCRUD.getNume().getText(), employeeCRUD.getTip().getText(),
                employeeCRUD.getAnulRealizarii().getText(), employeeCRUD.getCategorie().getText());
        filmPersistence.create(film);
        JOptionPane.showMessageDialog(new JFrame(),dictionary.getMovieCreated()[dictionary.getLanguage()]);

    }
    private void updateFilm(){
        Film film=filmPersistence.get(idFilm);
        Film film2= new Film(film.getIdFilm(), employeeCRUD.getNume().getText(), employeeCRUD.getTip().getText(),
                employeeCRUD.getAnulRealizarii().getText(), employeeCRUD.getCategorie().getText());
        filmPersistence.update(film2);
        JOptionPane.showMessageDialog(new JFrame(),dictionary.getMovieUpdated()[dictionary.getLanguage()]);

    }
    private void see(){
        Film film=filmPersistence.get(idFilm);
        employeeCRUD.setNume(film.getNume());
        employeeCRUD.setCategorie(film.getCategorie());
        employeeCRUD.setAnulRealizarii(film.getAnRealizare());
        employeeCRUD.setTip(film.getTip());
    }

    @Override
    public void update() {
        int i=dictionary.getLanguage();
        employeeCRUD.getNumeL().setText(dictionary.getName()[i]);
        employeeCRUD.getTipL().setText(dictionary.getType()[i]);
        employeeCRUD.getCategorieL().setText(dictionary.getCategory()[i]);
        employeeCRUD.getAnulRealizariiL().setText(dictionary.getYear()[i]);
        employeeCRUD.getUpdateButton().setText(dictionary.getUpdateButton()[i]);
        employeeCRUD.getCreateButton().setText(dictionary.getCreateButton()[i]);
        employeeCRUD.getBACKButton().setText(dictionary.getBackButton()[i]);
    }
}
