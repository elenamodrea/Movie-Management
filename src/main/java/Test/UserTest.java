package Test;
import org.junit.Test;
import Model.Persistence.HibernateUtil;
import Model.Persistence.UserPersistence;
import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mockito.Mockito;

import java.lang.reflect.ParameterizedType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class UserTest {
    UserPersistence userPersistence=new UserPersistence();

    @Test
    public void testCreate() {
        // Create a mock session object
        Session mockSession = mock(Session.class);

        // Create a mock transaction object
        Transaction mockTransaction = mock(Transaction.class);

        // Configure the session to return the mock transaction
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        // Create a test object
        User testObject = new User("1234","Popescu","Ion","0765241123","Cluj","ion@yahoo.com","admin","ion","123");


        // Set the session factory of the DAO to use the mock session
        HibernateUtil.setSessionFactory(mock(SessionFactory.class));
        when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

        // Call the create method with the test object
        userPersistence.create(testObject);

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
        User testObject = new User("1234","Popescu","Ion","0765241123","Cluj","ion@yahoo.com","admin","ion","123");



        // Set the session factory of the DAO to use the mock session
        HibernateUtil.setSessionFactory(mock(SessionFactory.class));
        when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

        // Call the update method with the test object
        userPersistence.update(testObject);

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
        User t=new User();
        t.setIdUser(id);
        Class<User> type= User.class;
        // mock the session factory and openSession() method
        HibernateUtil.setSessionFactory(mock(SessionFactory.class));
        when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);
        // mock the get() method to return an instance of YourClass with id = 1
        Mockito.when(mockSession.get(type, id)).thenReturn(t);
        // call the delete() method
        userPersistence.delete(id);
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
        User testObject = new User();
        testObject.setIdUser(testId);

        // Configure the session to return the test object when get() is called
        when(mockSession.get(User.class, testId)).thenReturn(testObject);


        // Set the session factory of the DAO to use the mock session
        HibernateUtil.setSessionFactory(mock(SessionFactory.class));
        when(HibernateUtil.getSessionFactory().openSession()).thenReturn(mockSession);

        // Call the get() method with the test ID
        User result = userPersistence.get(testId);

        // Verify that the session was used to get the test object
        verify(mockSession, times(1)).get(User.class, testId);

        // Verify that the transaction was committed
        verify(mockTransaction, times(1)).commit();

        // Verify that the returned object matches the test object
        assertEquals(testObject, result);
    }




        }

