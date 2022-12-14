package vn.banhang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.Model.Category;
import vn.banhang.Model.Product;
import vn.banhang.Model.Review;
import vn.banhang.Model.SubCategory;
import vn.banhang.service.CategoryService;
import vn.banhang.service.ProductService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;

@WebServlet(urlPatterns = {"/detail"})
public class ProductDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		String pid = req.getParameter("pid");
		

		CategoryService categoryService = new CategoryServiceImpl();
		SubCategoryService subCategoryService = new SubCategoryServiceImpl();
		ProductService productService = new ProductServiceImpl();
		
		Product product = productService.get(Integer.valueOf(pid));
		req.setAttribute("product", product);
		
		List<Product> threeProduct = productService.getThreeProduct();
		req.setAttribute("threeProduct", threeProduct);
		
		List<SubCategory> allSubCate = subCategoryService.getAllSubCategory();
		req.setAttribute("listSubCate", allSubCate);
		
		List<Category> allCate = categoryService.getCategories();
		req.setAttribute("listCate", allCate);
		
		List<Product> sixProduct = productService.getSixProduct();
		req.setAttribute("listSixProduct", sixProduct);
		
		List<Review> reviews = productService.getProductReview(Integer.valueOf(pid));
		req.setAttribute("reviews", reviews);
		
		RequestDispatcher rq = req.getRequestDispatcher("/views/productDetail.jsp");
		rq.forward(req, resp);
	}
}
