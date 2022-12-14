package vn.banhang.Builder;

import java.util.Calendar;
import java.util.Set;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.Model.User;


public interface UserBuilder {
	UserBuilder setId(int id);
	UserBuilder setUsername(String username);
	UserBuilder setPassword(String password);
	UserBuilder setIs_admin(int is_admin);
	UserBuilder setIs_seller(int is_seller);
	UserBuilder setName(String name);
	UserBuilder setGender(String gender);
	UserBuilder setBirthdate(Calendar birthdate);
	UserBuilder setPhone(String phone);
	UserBuilder setEmail(String email);
	UserBuilder setReviews(Set<Review> review);
	UserBuilder setShop(Shop shop);
	UserBuilder setCarts(Set<Cart> cart);
	User build();
}
