package Model;

import Controller.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Observer> observerList=new ArrayList<>();
    private String[] username = new String[]{"Username:","Nutzername:","Nombre:"};
    private String[] passwword =new String[]{"Password:","Passwort:","Contraseña:"};
    private String[] loginButton= new String[]{"Login","Anmeldung","Acceso"};
    private String[] loginMessage= new String[]{"Wrong username or password","Benutzername oder Passwort falsch",
                                                "Nombre de usuario o contraseña incorrectos"};
    private String[][] adminCombo=new String[][]{new String[]{"admin","manager","employee"},new String[]{"administrator","Manager","Mitarbeiter"},new String[]{"Administrador","Manager","Empleado"}};

    private String[][] sortCombo=new String[][]{new String[]{"none","type","year"},new String[]{"keiner","typ","jahr"},
                                                new String[]{"ninguna","tip","ano"}};
    private String[] sortButton=new String[]{"Sort","Sortieren","Ordenar"};
    private String[][] typeCombo=new String[][]{new String[]{"none","artistic","series"},new String[]{"keiner","künstlerisch","serie"},
                                                new String[]{"ninguna","artistico","serie"}};
    private String[][] categortyCombo= new String[][]{new String[]{"none","comedy","romantic","drama","thriller"},new String[]{"keiner","komodie","romantisch","drama","thriller"},
                                                      new String[]{"ninguna","comedia","romantico","drama","suspenso"}};
    private String[] type= new String[]{"Type:","Typ:","Tipo:"};
    private String[] category= new String[]{"Category:","Kategorie:","Categoria:"};
    private String[] year=new String[]{"Year:","Jahr:","Ano:"};
    private String[] filterButton= new String[]{"Filter","Filter","Filtrar"};
    private String[] title = new String[]{"Title:","Titel:","Titulo:"};
    private String[] searchButton= new String[]{"Search","Suschen","Buscar"};
    private String[] format=new String[]{"Format:","Format:","Formato:"};
    private String[] downloadButton= new String[]{"Download","Herunterladen","Descargar"};
    private String[] selectMovieButton=new String[]{"Select Movie","Film auswählen","Seleccionar película"};
    private String[] createMovieButton=new String[]{"Create Movie","Film ersteller","Crear película"};
    private String[] deleteMovieButton=new String[]{"Delete Movie","Film loschen","Borrar película"};
    private String[] showAllButton = new String[]{"Show all","Zeige alles","mostrar todo"};
    private String[] backButton = new String[]{"Back","Zurück","Atrás"};
    private String[][] movieTable= new String[][]{new String[]{"name","type","year","category"}, new String[]{"nome","typ","jahr","kategorie"},
                                                 new String[]{"nombre","tipo","ano","categoria"}};

    private String[] employeeMessage =new String[]{"Logged in successfully into employee interface","Erfolgreich in die Mitarbeiteroberfläche eingeloggt",
                                                   "Iniciado sesión con éxito en la interfaz de empleado"};
    private String[] createButton =new String[]{"Create","Erstellen","Crear"};
    private String[] updateButton = new String[]{"Update","Aktualisieren","Actualizar"};
    private String[] managerMessage =new String[]{"Logged in successfully into manager interface","Erfolgreich in die Manageroberfläche eingeloggt",
            "Iniciado sesión con éxito en la interfaz de manager"};

    private String[] adminMessage =new String[]{"Logged in successfully into employee interface","Erfolgreich in die Administratoroberfläche eingeloggt",
            "Iniciado sesión con éxito en la interfaz de administrador"};

    private String[] selectUserButton=new String[]{"Select User","Benutzer auswählen","Seleccionar usuario"};
    private String[] createUserButton=new String[]{"Create User","Benutzer ersteller","Crear usuario"};
    private String[] deleteUserButton=new String[]{"Delete User","Benutzer loschen","Borrar usuario"};

    private String[] lastName=new String[]{"Last name:","Nachname:","Apellido:"};
    private String[] firstName=new String[]{"First name:","Vorname:","Nombre;"};
    private String[] address= new String[]{"Address:","Adresse:","Direccion:"};
    private String[] telephone=new String[]{"Telephone:","Telefon","Telefono:"};
    private String[] email=new String[]{"Email:", "Email:","Correo electrónico:"};
   private String[][] userTable = new String[][]{new String[]{"Last name","First name","Address","Type","Username","Password"},
    new String[]{"Nachname","Vorname","Adresse","Typ","Nutzername","Passwort"},
    new String[]{"Apellido","Nombre","Direccion","Tipo","Nombre","Contraseña"}};
   private String[] userCreated= new String[]{"User created successfully","Benutzer erfolgreich erstellt","Usuario creado con éxito"};
   private String[] userDeleted= new String[]{"User deleted successfully","Benutzer erfolgreich gelöscht","Usuario eliminado con éxito"};
   private String[] userUpdated= new String[]{"User updated successfully","Benutzer erfolgreich aktualisiert","Usuario actualizado con éxito"};
    private String[] movieCreated= new String[]{"Movie created successfully","Film erfolgreich erstellt","Pelicula creado con éxito"};
    private String[] movieDeleted= new String[]{"Movie deleted successfully","Film erfolgreich gelöscht","Pelicula eliminado con éxito"};
    private String[] name=new String[]{"Name:", "Nome:","Nombre"};
    private String[] movieUpdated= new String[]{"Movie updated successfully","Film erfolgreich aktualisiert","Pelicula actualizado con éxito"};

    private int language;

    public void setLanguage(int language){
        this.language=language;
        notifyObservers();
    }
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void notifyObservers(){
        for(Observer observer: observerList){
            observer.update();
        }
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public String[] getUsername() {
        return username;
    }

    public String[] getPasswword() {
        return passwword;
    }

    public String[] getLoginButton() {
        return loginButton;
    }

    public String[] getLoginMessage() {
        return loginMessage;
    }

    public String[][] getSortCombo() {
        return sortCombo;
    }

    public String[] getSortButton() {
        return sortButton;
    }

    public String[][] getTypeCombo() {
        return typeCombo;
    }

    public String[][] getCategortyCombo() {
        return categortyCombo;
    }

    public String[] getType() {
        return type;
    }

    public String[] getCategory() {
        return category;
    }

    public String[] getYear() {
        return year;
    }

    public String[] getFilterButton() {
        return filterButton;
    }

    public String[] getTitle() {
        return title;
    }

    public String[] getSearchButton() {
        return searchButton;
    }

    public String[] getFormat() {
        return format;
    }

    public String[] getDownloadButton() {
        return downloadButton;
    }

    public String[] getSelectMovieButton() {
        return selectMovieButton;
    }

    public String[] getCreateMovieButton() {
        return createMovieButton;
    }

    public String[] getDeleteMovieButton() {
        return deleteMovieButton;
    }

    public String[] getShowAllButton() {
        return showAllButton;
    }

    public String[] getBackButton() {
        return backButton;
    }

    public String[][] getMovieTable() {
        return movieTable;
    }

    public String[] getEmployeeMessage() {
        return employeeMessage;
    }

    public String[] getCreateButton() {
        return createButton;
    }

    public String[] getUpdateButton() {
        return updateButton;
    }

    public String[] getManagerMessage() {
        return managerMessage;
    }

    public String[] getAdminMessage() {
        return adminMessage;
    }

    public String[] getSelectUserButton() {
        return selectUserButton;
    }

    public String[] getCreateUserButton() {
        return createUserButton;
    }

    public String[] getDeleteUserButton() {
        return deleteUserButton;
    }

    public String[] getLastName() {
        return lastName;
    }

    public String[] getFirstName() {
        return firstName;
    }

    public String[] getAddress() {
        return address;
    }

    public String[] getTelephone() {
        return telephone;
    }

    public String[] getEmail() {
        return email;
    }

    public String[][] getUserTable() {
        return userTable;
    }

    public int getLanguage() {
        return language;
    }

    public String[] getUserCreated() {
        return userCreated;
    }

    public String[] getUserDeleted() {
        return userDeleted;
    }

    public String[] getUserUpdated() {
        return userUpdated;
    }

    public String[] getMovieCreated() {
        return movieCreated;
    }

    public String[] getMovieDeleted() {
        return movieDeleted;
    }

    public String[] getMovieUpdated() {
        return movieUpdated;
    }

    public String[] getName() {
        return name;
    }

    public String[][] getAdminCombo() {
        return adminCombo;
    }
}
