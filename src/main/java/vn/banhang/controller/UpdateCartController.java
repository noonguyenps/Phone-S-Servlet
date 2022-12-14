package vn.banhang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.Cart;
import vn.banhang.service.CartService;
import vn.banhang.service.impl.CartServiceImpl;



@WebServlet(urlPatterns= {"/api/update-cart"})
public class UpdateCartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));

		HttpSession session = req.getSession();
		Map<Integer, Cart> map = (Map<Integer, Cart>)session.getAttribute("cart");
		Cart cartItem = map.get(id);
		cartItem.setAmount( Integer.parseInt(req.getParameter("amount")) );
		CartService cartService = new CartServiceImpl();
		cartService.update(cartItem);
		session.setAttribute("cart", map);
		int quantity=0;
		double charge=0.0;
		for(Cart item: map.values()) {
			quantity+= item.getAmount();
			charge+= item.getAmount()*item.getPrice();
		}
		session.setAttribute("cartQuantity", quantity);
		session.setAttribute("cartCharge", charge);
		PrintWriter out = resp.getWriter();
		out.println( Integer.toString(quantity) + "/" + Double.toString(charge) );
	}
}
