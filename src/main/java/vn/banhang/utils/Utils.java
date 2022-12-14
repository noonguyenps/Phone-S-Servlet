package vn.banhang.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.banhang.Model.User;

public class Utils {
	public static boolean kiemTraIsSeller(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getIs_seller()==0) {
			return false;
		}
		return true;
	}
	public static boolean kiemTraDangNhap(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null)
			return false;
		return true;
	}
	public static boolean kiemtraAdmin(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getIs_admin()==0) {
			return false;
		}
		return true;
	}
	public static User getUserAdmin(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getIs_admin()==0) {
			return null;
		}
		return user;
	}
}
