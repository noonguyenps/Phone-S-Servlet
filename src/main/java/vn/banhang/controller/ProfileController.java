package vn.banhang.controller;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Shop;
import vn.banhang.Model.User;
import vn.banhang.service.CartService;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.CartServiceImpl;
import vn.banhang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        req.setAttribute("user",user);
        req.getRequestDispatcher("/views/myProfile.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        UserService userService = new UserServiceImpl();

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String birthDate =  req.getParameter("birthdate");

        List<User> users = userService.existUser("12009932131231",phone,email);
        if(users.isEmpty()){
            user.setName(name);
            if(gender.equals("1")){
                user.setGender("male");
            }
            else {
                user.setGender("female");
            }
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

            userService.edit(user);
        }
        else req.setAttribute("message", "Tồn tại số điện thoại,hoặc email");
        req.getRequestDispatcher("/views/myProfile.jsp").forward(req, resp);
    }
}
