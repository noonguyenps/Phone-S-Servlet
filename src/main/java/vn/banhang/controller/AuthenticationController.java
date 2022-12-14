package vn.banhang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import vn.banhang.Model.User;
import vn.banhang.otp.GeneralCode;
import vn.banhang.otp.Smsrequest;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet(urlPatterns = {"/authentication"})
public class AuthenticationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/views/authen-edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User();

		HttpSession session = req.getSession();
		user = (User) session.getAttribute("user5");
		String otp = (String) session.getAttribute("otp");
		
		String code = req.getParameter("code");
		System.out.println(code);
		System.out.println(otp);
		
		System.out.println(otp + " : " + code);
	
		if(code.equalsIgnoreCase(otp))
		{
			userService.insert(user);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/authentication");
		}
	}
}
