package vn.banhang.service.impl;

import java.util.List;

import vn.banhang.Model.Shop;
import vn.banhang.dao.ShopDAO;
import vn.banhang.dao.impl.ShopDAOImpl;
import vn.banhang.service.ShopService;

public class ShopServiceImpl implements ShopService {
	ShopDAO dao = new ShopDAOImpl();
	
	@Override
	public void update(Shop shop) {
		dao.update(shop);
	}

	@Override
	public List<Object[]> top5Selling(Shop shop) {
		return dao.top5Selling(shop);
	}

	@Override
	public List<Shop> getAllShop() {
		return dao.getAllShop();
	}

	@Override
	public Shop get(String name) {
		return dao.get(name);
	}

	@Override
	public Shop getByID(int id) {
		return dao.getByID(id);
	}

	@Override
	public void insert(Shop shop) {
		dao.insert(shop);
	}

	@Override
	public void delete(String name) {
		dao.delete(name);
	}

	@Override
	public void edit(Shop shop) {
		dao.edit(shop);
	}

}
