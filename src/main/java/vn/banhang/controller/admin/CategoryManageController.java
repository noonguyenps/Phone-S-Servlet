package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.Model.Category;
import vn.banhang.service.CategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/category/manage","/admin/category"})
public class CategoryManageController extends HttpServlet{
	CategoryService cateService = new CategoryServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7013871491114464147L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			List<Category> cateList = cateService.getCategories();
			req.setAttribute("categoryList", cateList);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/category/manage-category.jsp");
			rq.forward(req, resp);
		}else 
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/category/manage");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
