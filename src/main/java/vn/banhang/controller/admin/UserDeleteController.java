package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.service.UserService;
import vn.banhang.service.impl.UserServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = { "/admin/user/delete" })
public class UserDeleteController extends HttpServlet {
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			int id = Integer.parseInt(req.getParameter("id"));
			String username = userService.getByID(id).getUsername();
			userService.delete(username);
			resp.sendRedirect(req.getContextPath() + "/admin/user/manage");
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/user/delete");
		
	}
}
