package vn.banhang.service;

import java.util.List;

import vn.banhang.Model.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public Category get(String name);
	public Category getByID(int id);
	public void insert(Category category);
	public void delete(String name);
	public void edit(Category category);
}
