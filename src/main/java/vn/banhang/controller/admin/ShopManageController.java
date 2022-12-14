package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = {"/admin/shop/manage","/admin/shop"})
public class ShopManageController extends HttpServlet{
	ShopService shopService = new ShopServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549369702282502968L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			List<Shop> shopList = shopService.getAllShop();
			req.setAttribute("shopList", shopList);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/shop/manage-shop.jsp");
			rq.forward(req, resp);
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/shop/manage");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
