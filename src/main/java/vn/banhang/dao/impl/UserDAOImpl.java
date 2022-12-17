package vn.banhang.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Cart;
import vn.banhang.Model.User;
import vn.banhang.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public User get(String username, String password) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			Query q = session.createQuery("FROM User u where u.username=:username and u.password=:password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			if(q.list().isEmpty())
				return null;
			return (User)q.list().get(0);
		}
	}
	@Override
	public List<User> getAllUsers() {
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			Query<User> query = session.createQuery("FROM User");
			List<User> users = query.list();
			session.close();
			return users;
		}
	}
	
	@Override
	public void insert(User user) {
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
		}
		
	}
	@Override
	public void edit(User user) {
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			session.getTransaction().begin();
			
			String hql = "UPDATE User " +
						"SET password =: ps, is_seller =: is, is_admin =: ia, name =: name, gender =: gd, birthdate =: bd, phone =: phone, email =: email " +
						"WHERE username =: us";
			Query q = session.createQuery(hql);
			
			q.setParameter("ps", user.getPassword());
			q.setParameter("is", user.getIs_seller());
			q.setParameter("ia", user.getIs_admin());
			q.setParameter("name", user.getName());
			q.setParameter("gd", user.getGender());
			q.setParameter("bd", user.getBirthdate());
			q.setParameter("phone", user.getPhone());
			q.setParameter("email", user.getEmail());
			q.setParameter("us", user.getUsername());
			q.executeUpdate();
			
			
			session.getTransaction().commit();
		}
	}
	@Override
	public void delete(String username) {
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			session.getTransaction().begin();
			
			String hql = "delete from User where username =:us ";
			Query q = session.createQuery(hql);
			q.setParameter("us", username);
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}
	@Override
	public User getByID(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			User user = session.get(User.class, id);
			return user;
		}
	}
	
	@Override
	public Object[] cartStats(User user) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			Predicate userEqual = builder.equal(cartRoot.get("user").as(User.class), user);
			Predicate incart = builder.equal(cartRoot.get("status").as(String.class), "incart");

			q.where(userEqual, incart);
			q.multiselect(builder.sum(cartRoot.get("amount")),
						  builder.sum( builder.prod(cartRoot.get("price"), cartRoot.get("amount")) ));
			return session.createQuery(q).getSingleResult();
			
		}
	}
	
	
	@Override
	public List<Cart> getCartByUser(User user) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cart> q = builder.createQuery(Cart.class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			Predicate userEqual = builder.equal(cartRoot.get("user").as(User.class), user);
			Predicate incart = builder.equal(cartRoot.get("status").as(String.class), "incart");
			
			q.where(userEqual, incart);
			List<Cart> list = session.createQuery(q).getResultList();
			return list;
		}
	}

	@Override
	public List<User> existUser(String username, String phone, String email) {
		try(Session session = HibernateUtil.getSessionFactory().openSession();) {
			Query query=session.createQuery("from User u where u.username=:us or u.email=:email or u.phone=:phone");
			query.setParameter("us",username);
			query.setParameter("email",email);
			query.setParameter("phone",phone);
			List<User> users = query.list();
			session.close();
			return users;
		}
	}
}
