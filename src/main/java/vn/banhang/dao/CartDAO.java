package vn.banhang.dao;

import java.util.Calendar;
import java.util.List;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Shop;

public interface CartDAO {
	 public List<Cart> getAllShopOrder(Shop shop);
	 public List<Cart> shopSearch(Shop shop, String status, String kw, Calendar from, Calendar to);
	 public void deliveryCart(int id);
	 public long countOrderByStatus(Shop shop, String status);
	 public void add(Cart cart);
	 public void update(Cart cart);
	 public List<Cart> getByUserID(int userID);

	List<Cart> getListInCartByUserID(int userID);
}
