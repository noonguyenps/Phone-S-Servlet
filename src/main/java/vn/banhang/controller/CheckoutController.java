package vn.banhang.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Notification;
import vn.banhang.Model.User;
import vn.banhang.service.CartService;
import vn.banhang.service.NotificationService;
import vn.banhang.service.impl.CartServiceImpl;
import vn.banhang.service.impl.NotificationServiceImpl;

@WebServlet(urlPatterns= {"/checkout"})
public class CheckoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			resp.sendRedirect(req.getContextPath() +  "/login?next=/order");
			return;
		}
		CartService cartService = new CartServiceImpl();
		List<Cart> listCart = cartService.getInCartByUserID(user.getId());
		req.setAttribute("listCart", listCart);
		req.getRequestDispatcher("/views/payForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String location = req.getParameter("location");
		
		Calendar cal = Calendar.getInstance();
		CartService cartService = new CartServiceImpl();
		HttpSession session = req.getSession();
		
		Map<Integer, Cart> map = (Map<Integer, Cart>)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		for(Cart item: map.values()) {
			item.setName(name);
			item.setPhone(phone);
			item.setLocation(location);
			item.setOrder_date(cal);
			item.setStatus("pending");
			cartService.update(item);
			Notification notification = new Notification();
			notification.setSubject("Đơn hàng");
			notification.setMessage("Đơn hàng của bạn đang được xử lý");
			notification.setUser(user);
			notification.setCreateAt(new Date());
			notification.setTypeMess(1);
			NotificationService notificationService = new NotificationServiceImpl();
			notificationService.add(notification);
		}
		session.setAttribute("cart", null);
		session.setAttribute("cartQuantity", 0);
		session.setAttribute("cartCharge", 0);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
