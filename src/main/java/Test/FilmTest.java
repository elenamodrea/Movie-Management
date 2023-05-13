package Test;

import Model.Film;
import Model.Persistence.FilmPersistence;
import Model.Persistence.HibernateUtil;
import Model.Persistence.UserPersistence;
import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FilmTest {

        FilmPersistence filmPersistence=new FilmPersistence();

        @Test
        public void testCreate() {
            // Create a mock session object
            Session mockSession = mock(Session.class);

            // Create a mock transaction object
            Transaction mockTransaction = mock(Transaction.class);

            // Configure the session to return the mock transaction
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);

            // Create a test object
             Film testObject=new Film("1234","Bridgerton","serial","2019","romantic");

            // Set the session factory of the DAO to use the mock session
            HibernateUtil.setSessionFactory(mock(SessionFactory.class));
            when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

            // Call the create method with the test object
            filmPersistence.create(testObject);

            // Verify that the session was used to save the test object
            verify(mockSession, times(1)).save(testObject);

            // Verify that the transaction was committed
            verify(mockTransaction, times(1)).commit();
        }
        @Test
        public void testUpdate() {
            // Create a mock session object
            Session mockSession = mock(Session.class);

            // Create a mock transaction object
            Transaction mockTransaction = mock(Transaction.class);

            // Configure the session to return the mock transaction
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);

            // Create a test object
            Film testObject=new Film("1234","Bridgerton","serial","2019","romantic");


            // Set the session factory of the DAO to use the mock session
            HibernateUtil.setSessionFactory(mock(SessionFactory.class));
            when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

            // Call the update method with the test object
            filmPersistence.update(testObject);

            // Verify that the session was used to update the test object
            verify(mockSession, times(1)).update(testObject);

            // Verify that the transaction was committed
            verify(mockTransaction, times(1)).commit();
        }
        @Test
        public void testDelete() {
            // Create a mock session object
            Session mockSession = mock(Session.class);

            // Create a mock transaction object
            Transaction mockTransaction = mock(Transaction.class);
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);
            String id="1";
            Film t=new Film();
            t.setIdFilm(id);
            Class<Film> type= Film.class;
            // mock the session factory and openSession() method
            HibernateUtil.setSessionFactory(mock(SessionFactory.class));
            when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

            // mock the get() method to return an instance of YourClass with id = 1
            Mockito.when(mockSession.get(type, id)).thenReturn(t);

            // call the delete() method

            filmPersistence.delete(id);

            // verify that session.delete() method was called with the right argument
            Mockito.verify(mockSession).delete(t);

            // verify that the transaction.commit() method was called
            Mockito.verify(mockTransaction).commit();

            // verify that session.close() method was called
            Mockito.verify(mockSession).close();
        }
        @Test
        public void testGet() {
            // Create a mock session object
            Session mockSession = mock(Session.class);

            // Create a mock transaction object
            Transaction mockTransaction = mock(Transaction.class);
            when(mockSession.beginTransaction()).thenReturn(mockTransaction);

            // Create a test object ID
            String testId = "123";

            // Create a test object to be returned by the session's get() method
            Film testObject = new Film();
            testObject.setIdFilm(testId);

            // Configure the session to return the test object when get() is called
            when(mockSession.get(Film.class, testId)).thenReturn(testObject);


            // Set the session factory of the DAO to use the mock session
            HibernateUtil.setSessionFactory(mock(SessionFactory.class));
            when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

            // Call the get() method with the test ID
            Film result = filmPersistence.get(testId);

            // Verify that the session was used to get the test object
            verify(mockSession, times(1)).get(Film.class, testId);

            // Verify that the transaction was committed
            verify(mockTransaction, times(1)).commit();

            // Verify that the returned object matches the test object
            assertEquals(testObject, result);
        }




    }
