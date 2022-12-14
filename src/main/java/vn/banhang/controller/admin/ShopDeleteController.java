package vn.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.Model.Shop;
import vn.banhang.service.ShopService;
import vn.banhang.service.impl.ShopServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/shop/delete"})
public class ShopDeleteController extends HttpServlet{
	ShopService shopService = new ShopServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			int id = Integer.parseInt(req.getParameter("id"));
			Shop shop = shopService.getByID(id);
			shopService.delete(shop.getName());
			resp.sendRedirect(req.getContextPath() + "/admin/shop/manage");
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/shop/manage");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
