package vn.banhang.service.impl;

import java.util.List;

import vn.banhang.Model.Category;
import vn.banhang.dao.CategoryDAO;
import vn.banhang.dao.impl.CategoryDAOImpl;
import vn.banhang.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO dao = new CategoryDAOImpl();
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return dao.getCategories();
	}
	@Override
	public Category get(String name) {
		return dao.get(name);
	}
	@Override
	public Category getByID(int id) {
		return dao.getByID(id);
	}
	@Override
	public void insert(Category category) {
		dao.insert(category);
	}
	@Override
	public void delete(String name) {
		dao.delete(name);
	}
	@Override
	public void edit(Category category) {
		dao.edit(category);
		
	}
	
}
