package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.catalina.User;

import model.users;

public class UserDao  extends AbstractEntityDao<users> {
	public UserDao() {
		super(users.class);
	}
	public void changePassword(String username, String oldpassword,String newpassword) throws Exception {

		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		String jpql="select u from users u where u.username = :username and u.password = :password";
		try {
			trans.begin();
			TypedQuery<users> query = em.createQuery(jpql, users.class);
			query.setParameter("username", username);
			query.setParameter("password", oldpassword);
			users user = query.getSingleResult();
			if (user == null) {
				throw new Exception("current password or username are incorrect");
			}
			user.setPassword(newpassword);
			em.merge(user);
			trans.commit();	
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	public users findByUserNameAndEmail(String username,String email) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql ="select u from users u where u.username=:username and u.email= :email";
		try {
			TypedQuery<users> query = em.createQuery(jpql, users.class);
			query.setParameter("username", username);
			query.setParameter("email", email);
			return query.getSingleResult();
		} finally {
			// TODO: handle exception
			em.close();
		}
	}
}
//tại sao old password là mật khẩu mới