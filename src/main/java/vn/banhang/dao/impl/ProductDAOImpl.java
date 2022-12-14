package vn.banhang.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.util.Pair;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;

import javax.persistence.criteria.JoinType;


import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Product;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.Model.SubCategory;
import vn.banhang.Model.User;
import vn.banhang.dao.ProductDAO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Pair< Integer, List<Product> > getAllShopProduct(Shop shop, int page) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("shop").as(Shop.class), shop);
			q.where(p);
			
			List<Product> list = session.createQuery(q).getResultList();
			
			int start = (page-1)*5;
			int end = start+5;
			if( end > list.size() )
				end = list.size();
				
			
			return new Pair< Integer, List<Product> >(list.size(), list.subList(start, end));
		}
	}
	

	@Override
	public Pair< Integer, List<Product>> searchProductShop(Shop shop, String kw, int subCateId, String status, int page) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			
			Predicate p = builder.like(root.get("name").as(String.class), "%%");
			
			Predicate p1 = builder.equal(root.get("shop").as(Shop.class), shop);
			Predicate p2 = builder.like(root.get("name").as(String.class), "%" + kw + "%");
			Predicate p3 = builder.equal(root.get("subCategory").get("id").as(Integer.class), subCateId);
			
			Predicate p4 = p;
			
			if(status.equals("dangban")) {
				p4 = builder.equal(root.get("status").as(Integer.class), 1);
			}
			else if(status.equals("ngungban")) {
				p4 = builder.equal(root.get("status").as(Integer.class), 0);
			}
			else if(status.equals("taman")) {
				p4 = builder.equal(root.get("status").as(Integer.class), -1);
			}
			else if(status.equals("hethang")) {
				p4 = builder.equal(root.get("amount").as(Integer.class), 0);
			}
		
			
			q.where(builder.and(p1, p2, p3, p4));
			List<Product> list = session.createQuery(q).getResultList();
			
			int start = (page-1)*5;
			int end = start+5;
			if( end > list.size() )
				end = list.size();
			
			return new Pair< Integer, List<Product> >(list.size(), list.subList(start, end));
		}
	}
	
	public Pair< Integer, List<Product>> searchProductShop(Shop shop, String kw, String status, int page) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			
			Predicate p = builder.like(root.get("name").as(String.class), "%%");
			
			Predicate p1 = builder.equal(root.get("shop").as(Shop.class), shop);
			Predicate p2 = builder.like(root.get("name").as(String.class), "%" + kw + "%");
			
			Predicate p4 = p;
			
			if(status.equals("dangban")) {
				p4 = builder.equal(root.get("status").as(Integer.class), 1);
			}
			else if(status.equals("ngungban")) {
				p4 = builder.equal(root.get("status").as(Integer.class), 0);
			}
			else if(status.equals("taman")) {
				p4 = builder.equal(root.get("status").as(Integer.class), -1);
			}
			else if(status.equals("hethang")) {
				p4 = builder.equal(root.get("amount").as(Integer.class), 0);
			}
			
			q.where(builder.and(p1, p2, p4));
			List<Product> list = session.createQuery(q).getResultList();
			
			int start = (page-1)*5;
			int end = start+5;
			if( end > list.size() )
				end = list.size();
			
			return new Pair< Integer, List<Product> >(list.size(), list.subList(start, end));
		}
	}
	
	@Override
	public Product get(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Product product = session.get(Product.class, id);
			return product;
		}
	}
	
	@Override
	public void update(Product product) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.merge(product);
			session.getTransaction().commit();
		}
	}
	


	@Override
	public void add(Product product) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.save(product);
			session.getTransaction().commit();
		}
	}
	
	@Override
	public void addReview(Review review) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.save(review);
			session.getTransaction().commit();
		}
	}
	
	@Override
	public List<Product> getSixProduct() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			q.where(p);
			List<Product> list = session.createQuery(q).setMaxResults(6).getResultList();
			return list;
		}
	}
	
	@Override
	public List<Product> getSevenProduct() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			q.where(p);
			List<Product> list = session.createQuery(q).setMaxResults(7).getResultList();
			return list;
		}
	}
	
	@Override
	public List<Product> getThreeProduct() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			q.where(p);
			List<Product> list = session.createQuery(q).setMaxResults(3).getResultList();
			return list;
		}
	}
	
	@Override
	public List<Product> getAllProduct() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			q.where(p);
			List<Product> list = session.createQuery(q).getResultList();
			return list;
		}
	}
	
	
	@Override
	public List<Object[]> statsQuantityShop(Shop shop, Calendar from, Calendar to) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
			
			Root<Product> productRoot = q.from(Product.class);
			Root<Cart> cartRoot = q.from(Cart.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(productRoot.get("id"), cartRoot.get("product")));
			predicates.add(builder.equal(productRoot.get("shop").as(Shop.class), shop));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), "deliveried"));
			
			if(from != null) {
				Predicate geFrom = builder.greaterThanOrEqualTo(cartRoot.get("delivery_date").as(Calendar.class), from);
				predicates.add(geFrom);
			}
			if(to != null) {
				Predicate leTo = builder.lessThanOrEqualTo(cartRoot.get("delivery_date").as(Calendar.class), to);
				predicates.add(leTo);
			}
			
			q.where(predicates.toArray(new Predicate[] {}));
			
			
			q.multiselect(productRoot.get("name"),
							builder.sum(cartRoot.get("amount").as(Integer.class)),
							builder.sum(builder.prod(cartRoot.get("amount").as(Integer.class), cartRoot.get("price").as(Double.class))) );
			q.groupBy(productRoot.get("name"));
			List<Object[]> list = session.createQuery(q).getResultList();
			return list;
		}
	}

	public List<Product> getProductBySubCate(int subCateId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			Predicate p1 = builder.equal(root.get("subCategory").get("id").as(Integer.class), subCateId);
			q.where(builder.and(p, p1));
			List<Product> list = session.createQuery(q).getResultList();

			return list;
		}
	}
	

	public Object[] statsDeliveriedProduct(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(cartRoot.get("product").get("id").as(Integer.class), id));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), "deliveried"));
				
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.multiselect( builder.count(cartRoot.get("id")),
							builder.sum(cartRoot.get("amount")),
							builder.sum(builder.prod(cartRoot.get("amount").as(Integer.class), cartRoot.get("price").as(Double.class))));
			return session.createQuery(q).getSingleResult();
			
		}
	}
	
	public long countPendingOrder(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Long> q = builder.createQuery(Long.class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(cartRoot.get("product").get("id").as(Integer.class), id));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), "pending"));
				
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.multiselect( builder.count(cartRoot.get("id")));
			return session.createQuery(q).getSingleResult();
			
		}
	}
	
	public long countCanceledOrder(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Long> q = builder.createQuery(Long.class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(cartRoot.get("product").get("id").as(Integer.class), id));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), "canceled"));
				
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.multiselect( builder.count(cartRoot.get("id")));
			return session.createQuery(q).getSingleResult();
		}
	}
			

	
	@Override
	public List<Product> getProductByCate(int CateId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			Predicate p1 = builder.equal(root.get("subCategory").get("category").get("id").as(Integer.class), CateId);
			q.where(builder.and(p, p1));
			List<Product> list = session.createQuery(q).getResultList();
			return list;

		}
	}
	
	@Override
	public List<Product> searchProduct(String kw) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> pRoot = q.from(Product.class);


			Predicate p1 = builder.like(pRoot.get("name").as(String.class), "%" + kw + "%");
			Predicate p2 = builder.like(pRoot.get("description").as(String.class), "%" + kw + "%");
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.or(p1, p2));
			
			q.where(predicates.toArray(new Predicate[] {}));
			q.select(pRoot);
			List<Product> list = session.createQuery(q).getResultList();
			return list;
		}
	}
	
	@Override
	public List<Review> getProductReview(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){	
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Review> q = builder.createQuery(Review.class);
			Root<Product> pRoot = q.from(Product.class);
			Root<Review> rRoot = q.from(Review.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(pRoot.get("id"), rRoot.get("product")));
			predicates.add(builder.equal(rRoot.get("product").get("id").as(Integer.class), id));
			
			q.where(predicates.toArray(new Predicate[] {}));
			q.select(rRoot);
			List<Review> list = session.createQuery(q).getResultList();
			return list;
		}
	}

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> q = builder.createQuery(Product.class);
			Root<Product> root = q.from(Product.class);
			q.select(root);
			Predicate p = builder.equal(root.get("status").as(Integer.class), 1);
			q.where(p);
			List<Product> list = session.createQuery(q).getResultList();
			for(Product pt: list){
				String a = String.valueOf(pt.getPrice());
				System.out.println(String.format("%.0f",pt.getPrice()));
			}
		}
	}


}
