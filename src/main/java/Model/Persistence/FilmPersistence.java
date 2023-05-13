package Model.Persistence;

import Model.Film;
import Model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class FilmPersistence extends AbstractPersistence<Film> {
    public Film getFilmbyName (String nume) {

        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // Create a criteria to search for a user with the specified username
        Criteria criteria = session.createCriteria(Film.class);

        // Add the username as a search criterion
        criteria.add(Restrictions.eq("nume", nume));

        // Retrieve the user with the specified username
        Film film =(Film) criteria.uniqueResult();

        session.close();

        return film;
    }
}
