package vn.banhang.Model;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import vn.banhang.Hibernate.HibernateUtil;

@Entity
@Table(name = "users")
public class User implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int is_seller;
	private int is_admin;
	private String name;
	private String gender;
	private Calendar birthdate;
	private String phone;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Review> reviews;
	
	@OneToOne(mappedBy = "user")
    private Shop shop;
	
	
	@OneToMany(mappedBy = "user")
	private Set<Cart> carts;

	@OneToMany(mappedBy = "user")
	private Set<Notification> notifications;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIs_seller() {
		return is_seller;
	}
	public void setIs_seller(int is_seller) {
		this.is_seller = is_seller;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Calendar getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public User(int id, String username, String password, int is_seller, int is_admin, String name, String gender,
				Calendar birthdate, String phone, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_seller = is_seller;
		this.is_admin = is_admin;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
	}
	public User() {
		super();
	}
	
	
	public User(int id, String username, String password, int is_seller, int is_admin, String name, String gender,
			Calendar birthdate, String phone, String email, Set<Review> reviews, Shop shop, Set<Cart> carts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_seller = is_seller;
		this.is_admin = is_admin;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
		this.reviews = reviews;
		this.shop = shop;
		this.carts = carts;
	}
}
