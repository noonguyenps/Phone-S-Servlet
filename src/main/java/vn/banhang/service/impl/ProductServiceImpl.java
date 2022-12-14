package vn.banhang.service.impl;

import java.util.Calendar;
import java.util.List;

import javafx.util.Pair;
import vn.banhang.Model.Product;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.dao.ProductDAO;
import vn.banhang.dao.impl.ProductDAOImpl;
import vn.banhang.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDAO dao = new ProductDAOImpl();
	
	
	@Override
	public List<Product> getSixProduct() {
		return dao.getSixProduct();
	}

	@Override
	public List<Product> getSevenProduct(){
		return dao.getSevenProduct();
	}
	
	@Override
	public List<Product> getAllProduct(){
		return dao.getAllProduct();
	}
	
	@Override
	public List<Product> getProductBySubCate(int subCateId){
		return dao.getProductBySubCate(subCateId);
	}
	
	@Override
	public List<Review> getProductReview(int id){
		return dao.getProductReview(id);
	}
	
	@Override
	public void addReview(Review review) {
		dao.addReview(review);
	}
	
	
	@Override
	public List<Product> searchProduct(String kw){
		return dao.searchProduct(kw);
	}
	
	@Override
	public List<Product> getProductByCate(int CateId){
		return dao.getProductByCate(CateId);
	}
	
	@Override
	public List<Product> getThreeProduct() {
		return dao.getThreeProduct();
	}
	
	
	@Override
	public Pair< Integer, List<Product>> getAllShopProduct(Shop shop, int page) {
		return dao.getAllShopProduct(shop, page);
	}

	@Override
	public Pair< Integer, List<Product>> searchProductShop(Shop shop, String kw, int subCateId, String status, int page) {
		// TODO Auto-generated method stub
		return dao.searchProductShop(shop, kw, subCateId, status, page);
	}

	@Override
	public Pair< Integer, List<Product>> searchProductShop(Shop shop, String kw, String status, int page) {
		// TODO Auto-generated method stub
		return dao.searchProductShop(shop, kw, status, page);
	}

	@Override
	public Product get(int id) {
		return dao.get(id);
	}

	@Override
	public void update(Product product) {
		dao.update(product);
		
	}

	@Override
	public void add(Product product) {
		dao.add(product);
		
	}

	@Override
	public List<Object[]> statsQuantityShop(Shop shop, Calendar from, Calendar to) {
		// TODO Auto-generated method stub
		return dao.statsQuantityShop(shop, from, to);
	}

	@Override
	public Object[] statsDeliveriedProduct(int id) {
		return dao.statsDeliveriedProduct(id);
	}

	@Override
	public long countPendingOrder(int id) {
		return dao.countPendingOrder(id);
	}

	@Override
	public long countCanceledOrder(int id) {
		return dao.countCanceledOrder(id);
	}


}
