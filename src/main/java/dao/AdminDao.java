package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.Admin;
import util.HibernateUtil;
import util.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AdminDao {
	 public void saveUser(Admin admin) {
		 EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		 EntityTransaction transaction = entityManager.getTransaction();

		 try {
			 transaction.begin();

			 entityManager.persist(admin);
			 transaction.commit();
		 } finally {
			 if (transaction.isActive()) {
				 transaction.rollback();
			 }
			 entityManager.close();
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
