package Model.Persistence;

import Model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserPersistence extends AbstractPersistence<User> {
    public User getUserName (String username) {

        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // Create a criteria to search for a user with the specified username
        Criteria criteria = session.createCriteria(User.class);

        // Add the username as a search criterion
        criteria.add(Restrictions.eq("username", username));

        // Retrieve the user with the specified username
        User user =(User) criteria.uniqueResult();

        session.close();

        return user;
    }
}
