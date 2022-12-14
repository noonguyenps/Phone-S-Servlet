package vn.banhang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Category;
import vn.banhang.Model.Product;
import vn.banhang.Model.SubCategory;
import vn.banhang.Model.User;
import vn.banhang.service.CategoryService;
import vn.banhang.service.ProductService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = {"/home"})
public class HomeController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		CategoryService categoryService = new CategoryServiceImpl();
		SubCategoryService subCategoryService = new SubCategoryServiceImpl();
		ProductService productService = new ProductServiceImpl();
		UserService userService = new UserServiceImpl();

		List<Product> sixProduct = productService.getSixProduct();
		req.setAttribute("listSixProduct", sixProduct);

		List<Product> sevenProduct = productService.getSevenProduct();
		req.setAttribute("listSevenProduct", sevenProduct);

		List<SubCategory> allSubCate = subCategoryService.getAllSubCategory();
		req.setAttribute("listSubCate", allSubCate);

		List<Category> allCate = categoryService.getCategories();
		req.setAttribute("listCate", allCate);


		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			req.setAttribute("cartQuantity", 0);
			req.setAttribute("cartCharge", 0);
		}else {
			Object[] obj = userService.cartStats(user);
			if(obj[0] == null)
				obj[0] = 0;
			if(obj[1]==null)
				obj[1]=0;
			session.setAttribute("cartQuantity", obj[0]);
			session.setAttribute("cartCharge", obj[1]);

			List<Cart> listCart = userService.getCartByUser(user);
			Map<Integer, Cart> map = new HashMap<Integer, Cart>();
			for(Cart cart: listCart) {
				map.put(cart.getProduct().getId(), cart);
			}
			session.setAttribute("cart", map);
			req.setAttribute("user", user);

		}
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
}
