package vn.banhang.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import vn.banhang.Model.Category;
import vn.banhang.Model.Shop;
import vn.banhang.Model.SubCategory;
import vn.banhang.Model.User;
import vn.banhang.otp.GeneralCode;
import vn.banhang.otp.Smsrequest;
import vn.banhang.otp.Twilioinitializer;
import vn.banhang.otp.Twilioproperties;
import vn.banhang.service.CategoryService;
import vn.banhang.service.ShopService;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.ShopServiceImpl;
import vn.banhang.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	UserService userService = new UserServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String isSeller = req.getParameter("isSeller");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String birthDate =  req.getParameter("birthdate");

		List<User> users = userService.existUser(username,phone,email);
		if(users.isEmpty()){
			if(isSeller.equals("1")){
				user.setIs_seller(1);
			}
			else
				user.setIs_seller(0);
			user.setIs_admin(0);
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			if(gender.equals("1")){
				user.setGender("male");
			}
			else {
				user.setGender("female");
			}
			System.out.println(gender);
			user.setPhone(phone);
			user.setEmail(email);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			try {
				cal.setTime(sdf.parse(birthDate));
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			user.setBirthdate(cal);

			userService.insert(user);
			if(isSeller.equals("1")){
				User user1 = userService.get(username,password);
				Shop shop = new Shop();
				shop.setName("default");
				shop.setLocation("default");
				shop.setUser(user1);
				shopService.insert(shop);
			}
			req.setAttribute("message", "Đăng lý thành công, hãy đăng nhập");
		}
		else req.setAttribute("message", "Tồn tại số điện thoại, tên đăng nhập hoặc email");
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
}