package vn.banhang.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Category;
import vn.banhang.Model.Product;
import vn.banhang.Model.Shop;
import vn.banhang.Model.SubCategory;
import vn.banhang.dao.CategoryDAO;
import vn.banhang.dao.SubCategoryDAO;

public class SubCategoryDAOImpl implements SubCategoryDAO{
	private final static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@Override
	public List<SubCategory> getAllSubCategory() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SubCategory> q = builder.createQuery(SubCategory.class);
			Root<SubCategory> root = q.from(SubCategory.class);
			q.select(root);
			List<SubCategory> list = session.createQuery(q).getResultList();
			return list;
		}
	}

	@Override
	public SubCategory get(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			try {
				SubCategory subCate = session.get(SubCategory.class, id);
				return subCate;	
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
	}

	@Override
	public SubCategory getByName(String name) {
		try (Session session = factory.openSession()){
			String hql = "From SubCategory sc where sc.name =: name";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			if(query.list().isEmpty())
				return null;
			return (SubCategory)query.list().get(0);
		}
	}

	@Override
	public void insert(SubCategory subCate) {
		try(Session session = factory.openSession()){
			session.getTransaction().begin();
			session.save(subCate);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(String name) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "delete from SubCategory where name =:scname ";
			Query q = session.createQuery(hql);
			q.setParameter("scname", name);
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}

	@Override
	public void edit(SubCategory subCate) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "UPDATE SubCategory " +
					"SET name=:scname , category_id =: cate_id " +
					"WHERE id =: scid";
			Query q = session.createQuery(hql);
			q.setParameter("scname", subCate.getName());
			q.setParameter("cate_id", subCate.getCategory().getId());
			q.setParameter("scid", subCate.getId());
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}
	public static void main(String[] args) {
		SubCategoryDAO daoSubCate = new SubCategoryDAOImpl();
		CategoryDAO daoCate = new CategoryDAOImpl();
		Category c1 = daoCate.getByID(1);
		SubCategory sc1 = new SubCategory();
		sc1.setName("Test");
		sc1.setCategory(c1);
		daoSubCate.insert(sc1);
		
		daoSubCate.getAllSubCategory().forEach(sc -> System.out.println(sc.getName()));
		sc1.setName("Test2");
		daoSubCate.edit(sc1);
		daoSubCate.getAllSubCategory().forEach(sc -> System.out.println(sc.getName()));
		
	}
	
}
