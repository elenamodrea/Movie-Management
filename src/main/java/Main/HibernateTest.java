package Main;

import Model.Film;
import Model.Persistence.FilmPersistence;
import Model.Persistence.HibernateUtil;
import Model.Persistence.RandomID;
import Model.Persistence.UserPersistence;
import Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTest {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        RandomID randomID= new RandomID();
        UserPersistence userPersistence=new UserPersistence();
        FilmPersistence filmPersistence=new FilmPersistence();
       /* User user1=new User(randomID.getRandomID(),"David","Rebeca","0765241148","Cluj-Napoca","davidrebeca@gmail.com","manager","rebeca","1234");
        User user2 = new User(randomID.getRandomID(), "Florean","Eusebiu","0762960665","Cluj-Napoca","eusebiuflorean@gmail.com","admin","sebi","1234");
        User user3 = new User(randomID.getRandomID(), "Modrea","Elena","0765241147","Cluj-Napoca","elenamodrea@yahoo.com","employee","elena","1234");
        userPersistence.create(user1);
        userPersistence.create(user2);
        userPersistence.create(user3);

        Film film1 = new Film(randomID.getRandomID(), "Closer","artistic","2004","drama");
        Film film2=new Film(randomID.getRandomID(), "Game Night","artistic","2018","comedie");
        Film film3 = new Film(randomID.getRandomID(), "Bridgerton","serial","2020","romantic");
        Film film4 = new Film(randomID.getRandomID(), "Hannibal","serial","2013","thriller");
        filmPersistence.create(film1);
        filmPersistence.create(film2);
        filmPersistence.create(film3);
        filmPersistence.create(film4);*/

        Film film1 = new Film(randomID.getRandomID(), "Papusa Chucky2","artistic","2008","thriller");
        Film film2=new Film(randomID.getRandomID(), "Joker1","artistic","2010","thriller");

        filmPersistence.create(film1);
        filmPersistence.create(film2);





    }
}
