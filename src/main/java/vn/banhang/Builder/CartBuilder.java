package vn.banhang.Builder;

import java.util.Calendar;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Product;
import vn.banhang.Model.User;

public interface CartBuilder {
	CartBuilder setId(int id);
	CartBuilder setName(String name);
	CartBuilder setPhone(String phone);
	CartBuilder setLocation(String location);
	CartBuilder setProduct(Product product);
	CartBuilder setUser(User user);
	CartBuilder setPrice(double price);
	CartBuilder setAmount(int amount);
	CartBuilder setOrder_date(Calendar order_date);
	CartBuilder setDelivery_date(Calendar delivery_date);
	CartBuilder setStatus(String Status);
	Cart builder();
}
