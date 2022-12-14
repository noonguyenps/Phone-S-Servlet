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
import vn.banhang.Model.SubCategory;
import vn.banhang.service.CategoryService;
import vn.banhang.service.ProductService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;


@WebServlet(urlPatterns = {"/product"})
public class ProductController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String cid = req.getParameter("cid");
		String scid = req.getParameter("scid");

		CategoryService categoryService = new CategoryServiceImpl();
		SubCategoryService subCategoryService = new SubCategoryServiceImpl();
		ProductService productService = new ProductServiceImpl();
		
		List<Product> allProduct = null;
		if("0".equals(cid) && "0".equals(scid)) {
			allProduct = productService.getAllProduct();
			req.setAttribute("listAllProduct", allProduct);
		} else if("0".equals(cid) && !("0".equals(scid))) {
			allProduct = productService.getProductBySubCate(Integer.valueOf(scid));
			req.setAttribute("listAllProduct", allProduct);
		} else if(!("0".equals(cid)) && "0".equals(scid)) {
			allProduct = productService.getProductByCate(Integer.valueOf(cid));
			req.setAttribute("listAllProduct", allProduct);
		}
		List<SubCategory> allSubCate = subCategoryService.getAllSubCategory();
		req.setAttribute("listSubCate", allSubCate);
		List<Category> allCate = categoryService.getCategories();
		req.setAttribute("listCate", allCate);
		int pages = (int)Math.ceil( allProduct.size()/3.0 );
		req.setAttribute("pages", pages);
		req.setAttribute("start", 0);
		req.setAttribute("end", 2);
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}
}
