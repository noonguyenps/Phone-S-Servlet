package vn.banhang.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Category;
import vn.banhang.Model.User;
import vn.banhang.dao.CategoryDAO;

public class CategoryDAOImpl implements CategoryDAO {
	private final static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public List<Category> getCategories(){
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Category> query = builder.createQuery(Category.class);
			Root<Category> root = query.from(Category.class);
			query.select(root);
			
			return session.createQuery(query).getResultList();
		}
	}
	@Override
	public Category get(String name) {
		try(Session session = factory.openSession()) {
			Query q = session.createQuery("FROM Category c where c.name=:cname");
			q.setParameter("cname", name);
			if(q.list().isEmpty())
				return null;
			return (Category)q.list().get(0);
		}
	}

	@Override
	public Category getByID(int id) {
		try(Session session = factory.openSession()) {
			try {
			Category category = session.get(Category.class, id);
				return category;
			} catch(Exception e) {
			}
			return null;
		}
	}

	@Override
	public void insert(Category category) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			session.save(category);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(String name) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "delete from Category where name =:cname ";
			Query q = session.createQuery(hql);
			q.setParameter("cname", name);
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
		
	}

	@Override
	public void edit(Category category) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "UPDATE Category " +
					"SET name=:cname " +
					"WHERE id =: cid";
			Query q = session.createQuery(hql);
			q.setParameter("cname", category.getName());
			q.setParameter("cid", category.getId());
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}
	public static void main(String[] args) {
		CategoryDAOImpl dao = new CategoryDAOImpl();
		//System.out.println(dao.getCategories());
		
		//System.out.println(dao.get("1").getName());
		/*Category c1 = new Category();
		c1.setName("NewP2");
		c1.setId(6);*/
		//dao.delete("NewP");
		//dao.getCategories().forEach(c -> System.out.println(c.getName()));
		if(dao.getByID(100) == null)
			System.out.println("null");
		else
			System.out.println(dao.getByID(100).getName());
		
	}

	
}
