package vn.banhang.ConcreateBuilder;

import java.util.Calendar;
import java.util.Set;

import vn.banhang.Builder.UserBuilder;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.Model.User;

public class UserConcreateBuilder implements UserBuilder{
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
	private Set<Review> reviews;
	private Shop shop;
	private Set<Cart> carts;
	
	@Override
	public UserBuilder setId(int id) {
		this.id = id;
		return this;
	}
	@Override
	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	@Override
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	@Override
	public UserBuilder setIs_seller(int is_seller) {
		this.is_seller = is_seller;
		return this;
	}
	@Override
	public UserBuilder setIs_admin(int is_admin) {
		this.is_admin = is_admin;
		return this;
	}
	@Override
	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public UserBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}
	@Override
	public UserBuilder setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
		return this;
	}
	@Override
	public UserBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	@Override
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	@Override
	public UserBuilder setReviews(Set<Review> reviews) {
		this.reviews = reviews;
		return this;
	}
	@Override
	public UserBuilder setShop(Shop shop) {
		this.shop = shop;
		return this;
	}
	@Override
	public UserBuilder setCarts(Set<Cart> carts) {
		this.carts = carts;
		return this;
	}
	@Override
	public User build() {
		return new User( id, username, password, is_seller, is_admin, name, gender, 
					birthdate, phone, email, reviews, shop, carts);
	}
	
	
}
