package vn.banhang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.User;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet 
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserService service = new UserServiceImpl();
		User user = service.get(username, password);
		System.out.println(req.getParameter("next"));
		if(user == null) {
			req.setAttribute("message", "Sai tài khoản hoặc mật khẩu");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			String next = req.getParameter("next");
			session.setAttribute("user", user);
			if(next == null || next.equals("")) {
				resp.sendRedirect("home");
			}
			else {
				resp.sendRedirect( req.getContextPath() + "/" + req.getParameter("next") );
			}
				
		}
	}
}
