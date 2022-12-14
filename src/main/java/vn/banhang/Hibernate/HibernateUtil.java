package vn.banhang.Hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;



import io.github.cdimascio.dotenv.Dotenv;
import vn.banhang.Model.*;

public class HibernateUtil 
{
	private final static SessionFactory FACTORY;

	static {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().ignoreIfMalformed().load();

		String url = dotenv.get("URL");
		String user = dotenv.get("USER");
		String pass = dotenv.get("PASS");

		Configuration conf = new Configuration();
		Properties pros = new Properties();

		pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");


		pros.put(Environment.URL, "jdbc:mysql://localhost:3306/shopdienthoai?useSSL=false");

		pros.put(Environment.USER, "root");
		pros.put(Environment.PASS, "64846");
		pros.put(Environment.HBM2DDL_AUTO,"update");

		conf.setProperties(pros);
		conf.addAnnotatedClass(Category.class);
		conf.addAnnotatedClass(SubCategory.class);
		conf.addAnnotatedClass(User.class);
		conf.addAnnotatedClass(Shop.class);
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Review.class);
		conf.addAnnotatedClass(Cart.class);
		conf.addAnnotatedClass(Notification.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);

	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
}