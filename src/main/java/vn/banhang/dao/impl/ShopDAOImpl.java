package vn.banhang.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Category;
import vn.banhang.Model.Product;
import vn.banhang.Model.Shop;
import vn.banhang.Model.User;
import vn.banhang.dao.ShopDAO;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.UserServiceImpl;

public class ShopDAOImpl implements ShopDAO {
	private final static SessionFactory factory = HibernateUtil.getSessionFactory();
	UserService userService = new UserServiceImpl();
	@Override
	public void update(Shop shop) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.merge(shop);
			session.getTransaction().commit();
		}
	}

	@Override
	public List<Object[]> top5Selling(Shop shop) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
			
			Root<Cart> cartRoot = q.from(Cart.class);
			Root<Product> productRoot = q.from(Product.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(builder.equal(productRoot.get("shop").as(Shop.class), shop));
			predicates.add(builder.equal(productRoot.get("id"), cartRoot.get("product")));
			predicates.add(builder.equal(cartRoot.get("status").as(String.class), "deliveried"));
				
			q.where(predicates.toArray(new Predicate[] {}));
			
			q.multiselect( productRoot.get("id"), 
							productRoot.get("name"),
							builder.count(cartRoot.get("id")),
							builder.sum(cartRoot.get("amount")),
							builder.sum(builder.prod(cartRoot.get("amount").as(Integer.class), cartRoot.get("price").as(Double.class))));
			q.groupBy(productRoot.get("id"), productRoot.get("name"));
			q.orderBy(builder.desc(builder.sum(cartRoot.get("amount"))));
			
			return session.createQuery(q).setMaxResults(5).getResultList();
		}
	}
	@Override
	public List<Shop> getAllShop() {
		try(Session session = factory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Shop> q = builder.createQuery(Shop.class);
			Root<Shop> shopRoot = q.from(Shop.class);
			q.select(shopRoot);
			return session.createQuery(q).getResultList();
		}
	}

	@Override
	public Shop get(String name) {
		try(Session session = factory.openSession()) {
			String hql = "From Shop s where s.name =: sname";
			Query q = session.createQuery(hql);
			q.setParameter("sname", name);
			return (Shop)q.getSingleResult();
		}
	}

	@Override
	public Shop getByID(int id) {
		try(Session session = factory.openSession()) {
			Shop shop = session.get(Shop.class, id);
			return shop;
		}
	}

	@Override
	public void insert(Shop shop) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			session.save(shop);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(String name) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "delete from Shop where name =:sname ";
			Query q = session.createQuery(hql);
			q.setParameter("sname", name);
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}

	@Override
	public void edit(Shop shop) {
		try(Session session = factory.openSession()) {
			session.getTransaction().begin();
			
			String hql = "UPDATE Shop " +
					"SET name=:sname , location =: slocation, avatar =: savatar " +
					"WHERE id =: sid";
			Query q = session.createQuery(hql);
			q.setParameter("sname", shop.getName());
			q.setParameter("slocation", shop.getLocation());
			q.setParameter("savatar", shop.getAvatar());
			q.setParameter("sid", shop.getId());
			q.executeUpdate();
			
			session.getTransaction().commit();
		}
	}
	
	public static void main(String[] args) {
		/*try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Shop shop = session.get(Shop.class, 1);
			List<Object[]> list = new ShopDAOImpl().top5Selling(shop);
			for(Object[] i:list) {
				System.out.println(i[0]);
				System.out.println(i[1]);
				System.out.println(i[2]);
				System.out.println(i[3]);
			}
		}*/
		ShopDAO dao = new ShopDAOImpl() ;
		UserService userService = new UserServiceImpl();
		System.out.println(dao.get("da huonh").getName());
		Shop s = new Shop();
		s.setAvatar("asdsad");
		s.setId(14);
		s.setLocation("234234");
		s.setName("test 4");
		s.setUser(userService.getByID(14));
		dao.insert(s);
	}

	
	
}
