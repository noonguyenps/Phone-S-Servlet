package vn.banhang.Model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private double price;
	private int amount;
	private Calendar order_date;
	private Calendar delivery_date;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Calendar getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Calendar order_date) {
		this.order_date = order_date;
	}
	public Calendar getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Calendar delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cart(int id, String name, String phone, String location, Product product, User user, double price,
			int amount, Calendar order_date, Calendar delivery_date, String status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.product = product;
		this.user = user;
		this.price = price;
		this.amount = amount;
		this.order_date = order_date;
		this.delivery_date = delivery_date;
		this.status = status;
	}
	public Cart() {
		super();
	}
	
	
}
