package dao;

import java.util.List;

import Entities.User;
import util.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserDao {

	/**
	 * Save User
	 *
	 * @param user
	 */
	public void saveUser(User user) {
		EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			entityManager.persist(user);
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}

	}

	/**
	 * Update User
	 *
	 * @param user
	 */
	public void updateUser(User user) {
		EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			entityManager.merge(user);
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}

	/**
	 * Delete User
	 *
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id) {

		EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();

			Query query = entityManager.createQuery("from User u where u.id = :id");
			query.setParameter("id", id);
			entityManager.remove(query.getResultList().get(0));
			transaction.commit();
			return  true;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}

	/**
	 * Get User
	 *
	 * @param id
	 * @return
	 */
	public User getUser(int id) {

		EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();

			Query query = entityManager.createQuery("from User u where u.id = :id");
			query.setParameter("id", id);
			transaction.commit();
			return (User) query.getResultList().get(0);
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}

	/**
	 * Get all Users
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<User> UserList = null;
		try {
			transaction.begin();

			UserList = entityManager.createQuery("from User", User.class).getResultList();
			transaction.commit();
			return UserList;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}

	}
}
