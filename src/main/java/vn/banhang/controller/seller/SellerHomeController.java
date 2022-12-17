package vn.banhang.controller.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.User;
import vn.banhang.service.CartService;
import vn.banhang.service.ProductService;
import vn.banhang.service.ShopService;
import vn.banhang.service.impl.CartServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.ShopServiceImpl;

@WebServlet(urlPatterns = {"/seller/home","/seller"})
public class SellerHomeController extends HttpServlet {

	private static final long serialVersionUID = -5103550605491265959L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(checkUser(req, resp) == false) {
			resp.sendRedirect(req.getContextPath() +  "/login?next=seller/home");
			return;
		}
		User user = (User)req.getSession().getAttribute("user");
		CartService cartService = new CartServiceImpl();
		ShopService shopService = new ShopServiceImpl();
		req.setAttribute("countDeliveried", cartService.countOrderByStatus(user.getShop(), "deliveried"));
		req.setAttribute("countPending", cartService.countOrderByStatus(user.getShop(), "pending"));
		req.setAttribute("countCanceled", cartService.countOrderByStatus(user.getShop(), "canceled"));
		req.setAttribute("top5Selling", shopService.top5Selling(user.getShop()));
		RequestDispatcher rq = req.getRequestDispatcher("/views/seller/seller_dashboard.jsp");
		rq.forward(req, resp);
	}
	
	public boolean checkUser(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getIs_seller()==0) {
			return false;
		}
		return true;
	}
}
