package vn.banhang.ConcreateBuilder;

import java.util.Calendar;

import vn.banhang.Builder.CartBuilder;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Product;
import vn.banhang.Model.User;

public class CartConcreateBuilder implements CartBuilder{
	private int id;
	private String name;
	private String phone;
	private String location;
	private Product product;
	private User user;
	private double price;
	private int amount;
	private Calendar order_date;
	private Calendar delivery_date;
	private String status;

	@Override
	public CartBuilder setId(int id) {
		this.id = id;
		return this;
	}
	@Override
	public CartBuilder setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public CartBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	@Override
	public CartBuilder setLocation(String location) {
		this.location = location;
		return this;
	}
	@Override
	public CartBuilder setProduct(Product product) {
		this.product = product;
		return this;
	}
	@Override
	public CartBuilder setUser(User user) {
		this.user = user;
		return this;
	}
	@Override
	public CartBuilder setPrice(double price) {
		this.price = price;
		return this;
	}
	@Override
	public CartBuilder setAmount(int amount) {
		this.amount = amount;
		return this;
	}
	@Override
	public CartBuilder setOrder_date(Calendar order_date) {
		this.order_date = order_date;
		return this;
	}
	@Override
	public CartBuilder setDelivery_date(Calendar delivery_date) {
		this.delivery_date = delivery_date;
		return this;
	}
	@Override
	public CartBuilder setStatus(String status) {
		this.status = status;
		return this;
	}
	@Override
	public Cart builder() {
		return new Cart( id, name, phone, location, product, user, price, amount, order_date, delivery_date, status);
	}
}
