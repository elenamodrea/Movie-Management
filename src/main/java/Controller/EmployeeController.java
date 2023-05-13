package Controller;

import Model.Film;
import Model.Persistence.FilmPersistence;
import Model.Dictionary;
import Model.Documents;
import View.Employee;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeController implements Observer{
    private Employee employee;
    private FilmPersistence filmPersistence;
    private Dictionary dictionary;
    public EmployeeController(){
        this.employee=new Employee();
        this.filmPersistence=new FilmPersistence();
        dictionary=new Dictionary();
        dictionary.addObserver(this);
        actions();

    }
    private void actions(){
        employee.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(employee.getComboBox().getSelectedIndex());
                }
        );
        employee.getBACKButton().addActionListener(e-> {
            new LoginController();
            employee.getFrame().dispose();
        });

        employee.getCreateFilmButton().addActionListener(e-> {
           new EmployeeCRUDController(null);
           employee.getFrame().dispose();
        });
        employee.getDownloadButton().addActionListener(e-> {
            download();
        });
        employee.getFiltrareButton().addActionListener(e-> {
            filter();
        });
        employee.getSearchButton().addActionListener(e-> {
            search();
        });
        employee.getSelectFilmButton().addActionListener(e-> {
            select();
        });
        employee.getShowAllButton().addActionListener(e-> {
            show();
        });
        employee.getSortareButton().addActionListener(e-> {
            sort();
        });
        employee.getDeleteFilmButton().addActionListener(e-> {
            delete();
        });
    }
    private void clear(){
        for(int i=0;i<100;i++){
            for(int j=0;j<4;j++){
                employee.getObjects()[i][j]="";
            }
        }
    }
    private void download(){
        String format=employee.getTextField3().getText();
        List<Film> films= filmPersistence.findAll();
        Documents documents=new Documents();
        if(format.equals("csv")||format.equals("json")||format.equals("xml")||format.equals("txt")){
            if(format.equals("csv")){
                documents.createCSVFile(documents.convertFilmListToStringArrayList(films));
            }
            else if(format.equals("json")){
                documents.createJSONFile(films);
            }
            else if(format.equals("xml")){
                documents.createXmlDocument("FilmXMLFile.xml",films);

            }
            else{
                documents.writeToTXTFIle(documents.convertFilmListToStringArrayList(films));
            }
        }
        else JOptionPane.showMessageDialog(new JFrame(), "Invalid input. You have to write: csv, json, xml or txt!");


    }
    private void filter(){
        int typeIndex= employee.getComboBox2().getSelectedIndex();
        String[] type=new String[]{"none","artistic","serial"};
        int categoryIndex= employee.getComboBox3().getSelectedIndex();
        String[] category=new String[]{"none","comedie","romantic","drama","thriller"};
        String year= employee.getTextField1().getText();
         List<Film> list = filmPersistence.findAll();
            List<Film> finals = new ArrayList<>();
            for (Film f : list) {
                if (f.getTip().equals(type[typeIndex])) {
                    finals.add(f);
                }
            }
            if (!finals.isEmpty()) {
                list = finals;
                finals = new ArrayList<>();
            }
            for (Film f : list) {
                if (f.getCategorie().equals(category[categoryIndex])) {
                    finals.add(f);
                }
            }
            if (!finals.isEmpty()) {
                list = finals;
                finals = new ArrayList<>();
            } else {
                if (!category[categoryIndex].equals("none")) {
                    list = new ArrayList<>();
                }
            }
            for (Film f : list) {
                if (f.getAnRealizare().equals(year)) {
                    finals.add(f);
                }
            }
            if (!finals.isEmpty()) {
                list = finals;
            } else {
                if (!year.equals("")) {
                    list = new ArrayList<>();
                }
            }
            clear();
            int i=0;
            for (Film film : list) {
                employee.getObjects()[i][0]=film.getNume();
                employee.getObjects()[i][1]=film.getTip();
                employee.getObjects()[i][2]=film.getAnRealizare();
                employee.getObjects()[i++][3]=film.getCategorie();

            }
            employee.getFrame().repaint();
    }

    private void search(){
        String title=employee.getTextField2().getText();
        List<Film> filmList=filmPersistence.findAll();
        clear();

        int ok=0,i=0;
        for(Film film : filmList ){
            if(film.getNume().equals(title)){
                employee.getObjects()[i][0]=film.getNume();
                employee.getObjects()[i][1]=film.getTip();
                employee.getObjects()[i][2]=film.getAnRealizare();
                employee.getObjects()[i++][3]=film.getCategorie();
            }
        }
        employee.getFrame().repaint();
    }
    private void select(){
        int index= employee.getModel().getSelectedRow();
        String filmName= (String) employee.getObjects()[index][0];
        Film film=filmPersistence.getFilmbyName(filmName);
        new EmployeeCRUDController(film.getIdFilm());
        employee.getFrame().dispose();
    }
    private void show(){
        List<Film> list=filmPersistence.findAll();
        clear();
        int i=0;
        for (Film film: list)
        {
            employee.getObjects()[i][0]=film.getNume();
            employee.getObjects()[i][1]=film.getTip();
            employee.getObjects()[i][2]=film.getAnRealizare();
            employee.getObjects()[i++][3]=film.getCategorie();

        }
        employee.getFrame().repaint();
    }
    private void sortByYear(){

        FilmPersistence filmPersistence=new FilmPersistence();
        List<Film> list=filmPersistence.findAll();
        Comparator<Film> compareByYear = Comparator.comparingInt((Film o) -> Integer.parseInt(o.getAnRealizare()));
        Collections.sort(list, compareByYear);
        clear();
        int i=0;
        for (Film film: list){
            employee.getObjects()[i][0]=film.getNume();
            employee.getObjects()[i][1]=film.getTip();
            employee.getObjects()[i][2]=film.getAnRealizare();
            employee.getObjects()[i++][3]=film.getCategorie();

        }
        employee.getFrame().repaint();
    }
    private void sortByType(){
        FilmPersistence filmPersistence=new FilmPersistence();
        List<Film> list=filmPersistence.findAll();
        Comparator<Film> compareByType = Comparator.comparing(Film::getTip);
        Collections.sort(list, compareByType);
       clear();
       int i=0;
        for (Film film: list)
        {
            employee.getObjects()[i][0]=film.getNume();
            employee.getObjects()[i][1]=film.getTip();
            employee.getObjects()[i][2]=film.getAnRealizare();
            employee.getObjects()[i++][3]=film.getCategorie();

        }
        employee.getFrame().repaint();

    }
    private void sort(){
        int selectionIndex=employee.getComboBox1().getSelectedIndex();
        String[] selection=new String[]{"none","type","year"};
            if (selection[selectionIndex].equals("type")) {
                sortByType();
            } else if (selection[selectionIndex].equals("year")) {
                sortByYear();
            }

    }
    private void delete(){
        int index= employee.getModel().getSelectedRow();
        String filmName= (String) employee.getObjects()[index][0];
        Film film=filmPersistence.getFilmbyName(filmName);
        filmPersistence.delete(film.getIdFilm());
        JOptionPane.showMessageDialog(new JFrame(),dictionary.getMovieDeleted()[dictionary.getLanguage()]);
        show();
    }

    @Override
    public void update() {
        int i= dictionary.getLanguage();
        employee.getComboBox1().setModel((ComboBoxModel) new JComboBox(dictionary.getSortCombo()[i]));
        employee.getComboBox2().setModel((ComboBoxModel) new JComboBox(dictionary.getTypeCombo()[i]));
        employee.getComboBox3().setModel((ComboBoxModel) new JComboBox(dictionary.getCategortyCombo()[i]));
        employee.getSortareButton().setText(dictionary.getSortButton()[i]);
        employee.getTip().setText(dictionary.getType()[i]);
        employee.getCategory().setText(dictionary.getCategory()[i]);
        employee.getType1().setText(dictionary.getYear()[i]);
        employee.getFiltrareButton().setText(dictionary.getFilterButton()[i]);
        employee.getTitle1().setText(dictionary.getTitle()[i]);
        employee.getSearchButton().setText(dictionary.getSearchButton()[i]);
        employee.getDownloadButton().setText(dictionary.getDownloadButton()[i]);
        employee.getSelectFilmButton().setText(dictionary.getSelectMovieButton()[i]);
        employee.getCreateFilmButton().setText(dictionary.getCreateMovieButton()[i]);
        employee.getDeleteFilmButton().setText(dictionary.getDeleteUserButton()[i]);
        employee.getShowAllButton().setText(dictionary.getShowAllButton()[i]);
        employee.getBACKButton().setText(dictionary.getBackButton()[i]);
        JTableHeader header = employee.getModel().getTableHeader();
        TableColumnModel colModel = header.getColumnModel();
        for (int j = 0; j < colModel.getColumnCount(); j++) {
            TableColumn col = colModel.getColumn(j);
            col.setHeaderValue(dictionary.getMovieTable()[i][j]);
        }
        header.repaint();

    }
}
