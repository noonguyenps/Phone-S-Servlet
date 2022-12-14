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
import vn.banhang.Model.Product;
import vn.banhang.Model.User;
import vn.banhang.service.CartService;
import vn.banhang.service.ProductService;
import vn.banhang.service.impl.CartServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.utils.Utils;


@WebServlet(urlPatterns = {"/api/add-to-cart"})
public class AddToCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String price = req.getParameter("price");
		String amount = req.getParameter("amount");
		
		ProductService productService = new ProductServiceImpl();
		CartService cartService = new CartServiceImpl();
		
		if(Utils.kiemTraDangNhap(req, resp)) {
			int pid = Integer.parseInt(id);
			Double pPrice = Double.parseDouble(price);
			int pAmount = Integer.parseInt(amount);
			Map<Integer, Cart> obj = (Map<Integer, Cart>)session.getAttribute("cart");
			Cart existedCartItem = obj.get(Integer.valueOf(pid));
			if(existedCartItem == null ) {
				existedCartItem = new Cart();
				existedCartItem.setProduct( productService.get(pid) );
				existedCartItem.setPrice(pPrice);
				existedCartItem.setAmount(pAmount);
				existedCartItem.setStatus("incart");
				existedCartItem.setUser((User)session.getAttribute("user"));
				cartService.add(existedCartItem);
				obj.put(pid, existedCartItem);
			}
			else {
				existedCartItem.setAmount( existedCartItem.getAmount() + pAmount );
				existedCartItem.setPrice(pPrice);
				cartService.update(existedCartItem);
			}
			session.setAttribute("cart", obj);
			
			PrintWriter out = resp.getWriter();
			
			Double charge=0.0; int quantity=0;
			for(Cart cart: obj.values()) {
				charge+= cart.getPrice()*cart.getAmount();
				quantity+= cart.getAmount();
			}
			session.setAttribute("cartQuantity", quantity);
			session.setAttribute("cartCharge", charge);
			
		}else {
			resp.sendRedirect(req.getContextPath() + "/login?next=api/add-to-cart?id=" + id + "&price=" + price + "&amount=" + amount);
		}
	}
}
