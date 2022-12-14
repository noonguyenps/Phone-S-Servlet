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

import vn.banhang.Model.User;
import vn.banhang.service.ProductService;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/seller/stats"})
public class SellerStatsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemTraIsSeller(req, resp)) {
			User user = (User)req.getSession().getAttribute("user");
			ProductService productSerivce = new ProductServiceImpl();
			List<Object[]> stats = productSerivce.statsQuantityShop(user.getShop(), null, null);
			req.setAttribute("stats", stats);
			req.getRequestDispatcher("/views/seller/stats.jsp").forward(req, resp);;
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login?next=seller/stats");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Calendar from = null;
		Calendar to = null;
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		if( !req.getParameter("from").trim().equals("") )
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("from"));
				from = Calendar.getInstance();
				from.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		if( !req.getParameter("to").trim().equals("") )
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("to"));
				to = Calendar.getInstance();
				to.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		ProductService productSerivce = new ProductServiceImpl();
		List<Object[]> stats = productSerivce.statsQuantityShop(user.getShop(), from, to);
		req.setAttribute("stats", stats);
		req.setAttribute("from", req.getParameter("from"));
		req.setAttribute("to", req.getParameter("to"));
		req.getRequestDispatcher("/views/seller/stats.jsp").forward(req, resp);;
	}
}
