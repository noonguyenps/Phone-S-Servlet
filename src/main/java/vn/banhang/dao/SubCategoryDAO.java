package vn.banhang.dao;

import java.util.List;

import vn.banhang.Model.SubCategory;

public interface SubCategoryDAO {
	public List<SubCategory> getAllSubCategory();
	public SubCategory get(int id);
	public SubCategory getByName(String name);
	public void insert(SubCategory subCate);
	public void delete(String name);
	public void edit(SubCategory subCate);
}
