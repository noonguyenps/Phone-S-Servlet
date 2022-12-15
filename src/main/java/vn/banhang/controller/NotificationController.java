package vn.banhang.controller;

import vn.banhang.Model.Notification;
import vn.banhang.Model.User;
import vn.banhang.service.NotificationService;
import vn.banhang.service.UserService;
import vn.banhang.service.impl.NotificationServiceImpl;
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
@WebServlet(urlPatterns = { "/profile/notification" })
public class NotificationController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        NotificationService notificationService = new NotificationServiceImpl();
        List<Notification> notifications = notificationService.getNotificationByUserID(user.getId());
        req.setAttribute("user",user);
        req.setAttribute("notifications",notifications);
        req.getRequestDispatcher("/views/myNotification.jsp").forward(req, resp);
    }
}
