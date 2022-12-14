package vn.banhang.controller.seller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import vn.banhang.service.CartService;
import vn.banhang.service.CategoryService;
import vn.banhang.service.ProductService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.CartServiceImpl;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/seller/order"})
public class SellerOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemTraIsSeller(req, resp)) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			if(req.getQueryString()==null) {
				HttpSession session = req.getSession();
				User user = (User)session.getAttribute("user");
				
				CartService cartSerivce = new CartServiceImpl();
				List<Cart> list = cartSerivce.getAllShopOrder(user.getShop());
				req.setAttribute("listCart", list);
				req.getRequestDispatcher("/views/seller/orders.jsp").forward(req, resp);
			}
			else
				doGetWithParams(req, resp);

		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login?next=seller/order");
		}
	}

	protected void doGetWithParams(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String status = "", kw="";
		
		if(req.getParameter("status") != null)
			status = req.getParameter("status");
		if(req.getParameter("txtTenSanPham") != null)
			kw = req.getParameter("txtTenSanPham").trim();
		Calendar from = null;
		Calendar to = null;
		
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		if( req.getParameter("from")!=null && !req.getParameter("from").trim().equals("") )
			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("from"));
				from = Calendar.getInstance();
				from.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if( req.getParameter("to")!=null && !req.getParameter("to").trim().equals("") )
			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("to"));
				to = Calendar.getInstance();
				to.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		CartService cartService = new CartServiceImpl();
		List<Cart> list = cartService.shopSearch(user.getShop(), status, kw, from, to);
		req.setAttribute("listCart", list);
		
		req.setAttribute("kw", kw);
		req.setAttribute("status", status);
		req.setAttribute("from", req.getParameter("from"));
		req.setAttribute("to", req.getParameter("to"));
		
		req.getRequestDispatcher("/views/seller/orders.jsp").forward(req, resp);
	}
}
