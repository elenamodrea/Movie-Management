package Controller;

import Model.Film;
import Model.Persistence.FilmPersistence;
import Model.Dictionary;
import Model.Documents;
import View.Manager;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.*;

public class ManagerController implements Observer {
    private Manager manager;
    private FilmPersistence filmPersistence;
    private Dictionary dictionary;
    public ManagerController(){
        this.manager=new Manager();
        this.filmPersistence=new FilmPersistence();
        this.dictionary=new Dictionary();
        dictionary.addObserver(this);
        grpahic();
        actions();

    }
    private void actions(){
        manager.getComboBox().addActionListener(
                e->{
                    dictionary.setLanguage(manager.getComboBox().getSelectedIndex());
                }
        );
        manager.getBACKButton().addActionListener(e-> {
            new LoginController();
            manager.getFrame().dispose();
        });
        manager.getDownloadButton().addActionListener(e-> {
            download();
        });
        manager.getFiltrareButton().addActionListener(e-> {
            filter();
        });
        manager.getSearchButton().addActionListener(e-> {
            search();
        });
        manager.getShowAllButton().addActionListener(e-> {
            show();
        });
        manager.getSortareButton().addActionListener(e-> {
            sort();
        });
    }
    private void clear(){
        for(int i=0;i<100;i++){
            for(int j=0;j<4;j++){
                manager.getObjects()[i][j]="";
            }
        }
    }
   private void download(){
       String format=manager.getTextField3().getText();
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
               documents.createXmlDocument("FilmXMLFileManager.xml",films);

           }
           else{
               documents.writeToTXTFIle(documents.convertFilmListToStringArrayList(films));
           }
       }
       else JOptionPane.showMessageDialog(new JFrame(), "Invalid input. You have to write: csv, json, xml or txt!");

   }
   private void filter(){
       int typeIndex= manager.getComboBox2().getSelectedIndex();
       String[] type=new String[]{"none","artistic","serial"};
       int categoryIndex= manager.getComboBox3().getSelectedIndex();
       String[] category=new String[]{"none","comedie","romantic","drama","thriller"};
       String year= manager.getTextField1().getText();
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
               manager.getObjects()[i][0]=film.getNume();
               manager.getObjects()[i][1]=film.getTip();
               manager.getObjects()[i][2]=film.getAnRealizare();
               manager.getObjects()[i++][3]=film.getCategorie();

           }
           manager.getFrame().repaint();

   }
   private void search(){
       String title=manager.getTextField2().getText();
       List<Film> filmList=filmPersistence.findAll();
       clear();

       int ok=0,i=0;
       for(Film film : filmList ){
           if(film.getNume().equals(title)){
               manager.getObjects()[i][0]=film.getNume();
               manager.getObjects()[i][1]=film.getTip();
               manager.getObjects()[i][2]=film.getAnRealizare();
               manager.getObjects()[i++][3]=film.getCategorie();
           }
       }
       manager.getFrame().repaint();
   }
    private void show(){
        List<Film> list=filmPersistence.findAll();
        clear();
        int i=0;
        for (Film film: list)
        {
            manager.getObjects()[i][0]=film.getNume();
            manager.getObjects()[i][1]=film.getTip();
            manager.getObjects()[i][2]=film.getAnRealizare();
            manager.getObjects()[i++][3]=film.getCategorie();

        }
        manager.getFrame().repaint();
    }
    private void sortByYear(){

        FilmPersistence filmPersistence=new FilmPersistence();
        List<Film> list=filmPersistence.findAll();
        Comparator<Film> compareByYear = Comparator.comparingInt((Film o) -> Integer.parseInt(o.getAnRealizare()));
        Collections.sort(list, compareByYear);
        clear();
        int i=0;
        for (Film film: list){
            manager.getObjects()[i][0]=film.getNume();
            manager.getObjects()[i][1]=film.getTip();
            manager.getObjects()[i][2]=film.getAnRealizare();
            manager.getObjects()[i++][3]=film.getCategorie();

        }
        manager.getFrame().repaint();
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
            manager.getObjects()[i][0]=film.getNume();
            manager.getObjects()[i][1]=film.getTip();
            manager.getObjects()[i][2]=film.getAnRealizare();
            manager.getObjects()[i++][3]=film.getCategorie();

        }
        manager.getFrame().repaint();

    }
    private void sort(){
        int selectionIndex=manager.getComboBox1().getSelectedIndex();
        String[] selection=new String[]{"none","type","year"};
        if (selection[selectionIndex].equals("type")) {
            sortByType();
        } else if (selection[selectionIndex].equals("year")) {
            sortByYear();
        }

    }

    @Override
    public void update() {
        int i= dictionary.getLanguage();
        manager.getComboBox1().setModel((ComboBoxModel) new JComboBox(dictionary.getSortCombo()[i]));
        manager.getComboBox2().setModel((ComboBoxModel) new JComboBox(dictionary.getTypeCombo()[i]));
        manager.getComboBox3().setModel((ComboBoxModel) new JComboBox(dictionary.getCategortyCombo()[i]));

        manager.getSortareButton().setText(dictionary.getSortButton()[i]);
        manager.getTip().setText(dictionary.getType()[i]);
        manager.getCategory().setText(dictionary.getCategory()[i]);
        manager.getType().setText(dictionary.getYear()[i]);
        manager.getFiltrareButton().setText(dictionary.getFilterButton()[i]);
        manager.getTitle().setText(dictionary.getTitle()[i]);
        manager.getSearchButton().setText(dictionary.getSearchButton()[i]);
        manager.getFormat().setText(dictionary.getFormat()[i]);
        manager.getDownloadButton().setText(dictionary.getDownloadButton()[i]);
        manager.getShowAllButton().setText(dictionary.getShowAllButton()[i]);
        manager.getBACKButton().setText(dictionary.getBackButton()[i]);
        JTableHeader header = manager.getModel().getTableHeader();
        TableColumnModel colModel = header.getColumnModel();
        for (int j = 0; j < colModel.getColumnCount(); j++) {
            TableColumn col = colModel.getColumn(j);
            col.setHeaderValue(dictionary.getMovieTable()[i][j]);
        }
        header.repaint();
    }

    private void grpahic(){
        Map<String,Integer> categories=new TreeMap<>();
        List<Film> films=filmPersistence.findAll();
        for(Film film: films){
            if (categories.containsKey(film.getCategorie())) {
            categories.put(film.getCategorie(),categories.get(film.getCategorie())+1);
        }
            else{
                categories.put(film.getCategorie(),1);
            }}
        for(String category: categories.keySet()){
            manager.getDataset().setValue(category,categories.get(category));
            System.out.println(category+" "+ categories.get(category));
        }
    }
}
