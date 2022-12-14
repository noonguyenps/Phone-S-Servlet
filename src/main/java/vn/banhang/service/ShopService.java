package vn.banhang.service;

import java.util.List;

import vn.banhang.Model.Shop;

public interface ShopService {
	public void update(Shop shop);
	public List<Object[]> top5Selling(Shop shop);
	public List<Shop >getAllShop();
	public Shop get(String name);
	public Shop getByID(int id);
	public void insert(Shop shop);
	public void delete(String name);
	public void edit(Shop shop);
}
