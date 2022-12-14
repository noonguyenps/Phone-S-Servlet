package vn.banhang.service.impl;

import java.util.List;

import vn.banhang.Model.Cart;
import vn.banhang.Model.User;
import vn.banhang.dao.UserDAO;
import vn.banhang.dao.impl.UserDAOImpl;
import vn.banhang.service.UserService;

public class UserServiceImpl implements UserService {

	UserDAO dao = new UserDAOImpl();
	@Override
	public User get(String username, String password) {
		return dao.get(username, password);
	}
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	@Override
	public void insert(User user) {
		dao.insert(user);
	}
	@Override
	public void edit(User user) {
		dao.edit(user);
		
	}
	@Override
	public void delete(String username) {
		dao.delete(username);
	}
	@Override
	public User getByID(int id) {
		return dao.getByID(id);
	}
	@Override
	public Object[] cartStats(User user) {
		return dao.cartStats(user);
	}
	@Override
	public List<Cart> getCartByUser(User user) {
		return dao.getCartByUser(user);
	}

	@Override
	public List<User> existUser(String username, String phone, String email) {
		return dao.existUser(username, phone, email);
	}
}
