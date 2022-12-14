package vn.banhang.service.impl;

import java.util.Calendar;
import java.util.List;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Shop;
import vn.banhang.dao.CartDAO;
import vn.banhang.dao.impl.CartDAOImpl;
import vn.banhang.service.CartService;

public class CartServiceImpl implements CartService {
	CartDAO dao = new CartDAOImpl();

	@Override
	public List<Cart> getAllShopOrder(Shop shop) {
		return dao.getAllShopOrder(shop);
	}

	@Override
	public List<Cart> shopSearch(Shop shop, String status, String kw, Calendar from, Calendar to) {
		return dao.shopSearch(shop, status, kw, from, to);
	}

	@Override
	public void deliveryCart(int id) {
		dao.deliveryCart(id);
		
	}

	@Override
	public long countOrderByStatus(Shop shop, String status) {
		return dao.countOrderByStatus(shop, status);
	}

	@Override
	public void add(Cart cart) {
		dao.add(cart);
	}

	@Override
	public void update(Cart cart) {
		dao.update(cart);
	}

	@Override
	public List<Cart> getByUserID(int userID) {
		return dao.getByUserID(userID);
	}
	@Override
	public List<Cart> getInCartByUserID(int userID){
		return dao.getListInCartByUserID(userID);
	}

}
