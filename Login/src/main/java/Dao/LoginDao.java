package Dao;

import model.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.Connection;

public class LoginDao implements LoginDaoInterface {

    @Override
    public boolean registerUser(Login login) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // Check if user already exists
            String hqlCheck = "FROM Login WHERE userId = :userId";
            Query<Login> queryCheck = session.createQuery(hqlCheck, Login.class);
            queryCheck.setParameter("userId", login.getUserId());
            Login existingUser = queryCheck.uniqueResult();

            if (existingUser != null) {
                transaction.rollback();
                session.close();
                return false;
            }

            // Register the new user
            session.save(login);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean removeUser(String userId) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Find the user by ID
            String hqlFind = "FROM Login WHERE userId = :userId";
            Query<Login> queryFind = session.createQuery(hqlFind, Login.class);
            queryFind.setParameter("userId", userId);
            Login login = queryFind.uniqueResult();

            if (login != null) {
                session.delete(login);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean validateUser(String userId, String password) {
        Session session = Connection.getSessionFactory().openSession();

        try {
            // Validate user credentials
            String hqlValidate = "FROM Login WHERE userId = :userId AND password = :password";
            Query<Login> queryValidate = session.createQuery(hqlValidate, Login.class);
            queryValidate.setParameter("userId", userId);
            queryValidate.setParameter("password", password);
            Login login = queryValidate.uniqueResult();

            return login != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean verifyUserForPasswordChange(String userId, String email) {
        // Not required for this task
        return false;
    }

    @Override
    public boolean changePassword(String userId, String newPassword) {
        // Not required for this task
        return false;
    }
}
