package vn.banhang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.Cart;
import vn.banhang.Model.User;
import vn.banhang.service.CartService;
import vn.banhang.service.impl.CartServiceImpl;

@WebServlet(urlPatterns= {"/order"})
public class OrderController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			resp.sendRedirect(req.getContextPath() +  "/login?next=/checkout");
			return;
		}
		CartService cartService = new CartServiceImpl();
		List<Cart> listCart = cartService.getByUserID(user.getId());
		req.setAttribute("listCart", listCart);
		
		req.getRequestDispatcher("/views/checkOrder.jsp").forward(req, resp);
	}
}
