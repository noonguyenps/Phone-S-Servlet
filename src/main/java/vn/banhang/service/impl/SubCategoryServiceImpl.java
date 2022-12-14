package vn.banhang.service.impl;

import java.util.List;

import vn.banhang.Model.SubCategory;
import vn.banhang.dao.SubCategoryDAO;
import vn.banhang.dao.impl.SubCategoryDAOImpl;
import vn.banhang.service.SubCategoryService;

public class SubCategoryServiceImpl implements SubCategoryService {
	private SubCategoryDAO dao = new SubCategoryDAOImpl();
	
	@Override
	public List<SubCategory> getAllSubCategory() {
		// TODO Auto-generated method stub
		return dao.getAllSubCategory();
	}

	@Override
	public SubCategory get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public SubCategory getByName(String name) {
		return dao.getByName(name);
	}

	@Override
	public void insert(SubCategory subCate) {
		dao.insert(subCate);
	}

	@Override
	public void delete(String name) {
		dao.delete(name);
	}

	@Override
	public void edit(SubCategory subCate) {
		dao.edit(subCate);
	}

}
