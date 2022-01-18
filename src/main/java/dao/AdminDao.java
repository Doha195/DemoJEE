package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.Admin;
import util.HibernateUtil;

public class AdminDao {
	 public void saveUser(Admin admin) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(admin);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                //transaction.rollback();
	            }
	        }
	    }

	    public boolean validate(String username, String password) {

	        Transaction transaction = null;
	        Admin admin = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            admin = (Admin) session.createQuery("FROM Admin u WHERE u.username = :username").setParameter("username", username)
	                .uniqueResult();

	            if (admin != null && admin.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                //transaction.rollback();
	            }
	        }
	        return false;
	    }

}
