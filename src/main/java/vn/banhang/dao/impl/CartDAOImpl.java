package vn.banhang.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Shop;
import vn.banhang.dao.CartDAO;

public class CartDAOImpl implements CartDAO {
	private final static SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public List<Cart> getAllShopOrder(Shop shop) {
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);
			query.select(root);
			
			Predicate shopEqual = builder.equal(root.get("product").get("shop").as(Shop.class), shop);
			
			Predicate status1 = builder.equal(root.get("status").as(String.class), "pending");
			Predicate status2 = builder.equal(root.get("status").as(String.class), "deliveried");
			Predicate status3 = builder.equal(root.get("status").as(String.class), "canceled");
			
			query.where(shopEqual, builder.or(status1,status2,status3) );
			return session.createQuery(query).getResultList();
		}
	}
	
	@Override
	public List<Cart> shopSearch(Shop shop, String status, String kw, Calendar from, Calendar to) {
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);
			query.select(root);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			Predicate shopEqual = builder.equal(root.get("product").get("shop").as(Shop.class), shop);
			predicates.add(shopEqual);
			Predicate kwLike = builder.like(root.get("product").get("name").as(String.class), "%" + kw + "%");
			predicates.add(kwLike);
			Predicate statusLike = builder.like(root.get("status").as(String.class), "%"+ status +"%");
			predicates.add(statusLike);
			
			if(from != null) {
				Predicate geFrom = builder.greaterThanOrEqualTo(root.get("order_date").as(Calendar.class), from);
				predicates.add(geFrom);
			}
			if(to != null) {
				Predicate leTo = builder.lessThanOrEqualTo(root.get("order_date").as(Calendar.class), to);
				predicates.add(leTo);
			}
			
			query.where(predicates.toArray(new Predicate[] {}));
			return session.createQuery(query).getResultList();
		}
	}

	@Override
	public void deliveryCart(int id) {
		try(Session session = factory.openSession()){
			session.getTransaction().begin();
			
			Cart cart = session.get(Cart.class, id);
			cart.setStatus("deliveried");
			cart.setDelivery_date(Calendar.getInstance());
			session.saveOrUpdate(cart);
			
			session.getTransaction().commit();
		}
	}
	
	@Override
	public long countOrderByStatus(Shop shop, String status) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Long> q = builder.createQuery(Long.class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(cartRoot.get("product").get("shop").as(Shop.class), shop));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), status));
				
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.multiselect( builder.count(cartRoot.get("id")));
			return session.createQuery(q).getSingleResult();
			
		}
	}
	
	@Override
	public void add(Cart cart) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.save(cart);
			session.getTransaction().commit();
		}
		
	}
	
	@Override
	public void update(Cart cart) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.merge(cart);
			session.getTransaction().commit();
		}
	}

	@Override
	public List<Cart> getByUserID(int userID) {
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();	//builder dùng để tạo các biểu thức đk trong câu lệnh where
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);	//root là truy vấn gốc dùng để chỉ định các trường cho phần lọc dữ liệu của builer
			query.select(root); // Chỉ định loại kết quả truy vấn
			
			Predicate uID = builder.equal(root.get("user").get("id").as(int.class), userID);
			Predicate status1 = builder.equal(root.get("status").as(String.class), "pending");
			Predicate status2 = builder.equal(root.get("status").as(String.class), "deliveried");
			Predicate status3 = builder.equal(root.get("status").as(String.class), "canceled");
			
			
			query.where(uID, builder.or(status1,status2,status3)).orderBy(builder.desc(root.get("id")));
			
			List<Cart> cart = session.createQuery(query).getResultList();
			if(cart.size() != 0) {
				return cart;
			}else {
				return null;
			}
		}
	}
	@Override
	public List<Cart> getListInCartByUserID(int userID) {
		try(Session session = factory.openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();	//builder dùng để tạo các biểu thức đk trong câu lệnh where
			CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
			Root<Cart> root = query.from(Cart.class);	//root là truy vấn gốc dùng để chỉ định các trường cho phần lọc dữ liệu của builer
			query.select(root); // Chỉ định loại kết quả truy vấn

			Predicate uID = builder.equal(root.get("user").get("id").as(int.class), userID);
			Predicate status = builder.equal(root.get("status").as(String.class), "incart");
			query.where(uID, builder.or(status)).orderBy(builder.desc(root.get("id")));

			List<Cart> cart = session.createQuery(query).getResultList();
			if(cart.size() != 0) {
				return cart;
			}else {
				return null;
			}
		}
	}

}
