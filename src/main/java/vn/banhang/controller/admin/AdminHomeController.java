package vn.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.service.CategoryService;
import vn.banhang.service.ProductService;
import vn.banhang.service.ShopService;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.ShopServiceImpl;
import vn.banhang.service.impl.UserServiceImpl;
import vn.banhang.utils.Utils;


@WebServlet(urlPatterns = {"/admin/dashboard"})
public class AdminHomeController extends HttpServlet{
	CategoryService cateService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1331827823733149829L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("quantityCategory", cateService.getCategories().size());
			req.setAttribute("quantityProduct", productService.getAllProduct().size());
			req.setAttribute("quantityShop", shopService.getAllShop().size());
			req.setAttribute("quantityUser", userService.getAllUsers().size());
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/admin_dashboard.jsp");
			rq.forward(req, resp);
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/dashboard");
	}
}
