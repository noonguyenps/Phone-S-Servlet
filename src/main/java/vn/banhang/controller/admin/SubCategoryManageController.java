package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.Model.SubCategory;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/sub_category","/admin/sub_category/manage"})
public class SubCategoryManageController extends HttpServlet{
	SubCategoryService subCateService = new SubCategoryServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2819492850772393335L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			List<SubCategory> subCateList = subCateService.getAllSubCategory();
			req.setAttribute("subCateList", subCateList);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/sub_category/manage-sub_category.jsp");
			rq.forward(req, resp);
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/sub_category/edit");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
