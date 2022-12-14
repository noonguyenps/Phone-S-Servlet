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
import vn.banhang.Model.SubCategory;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/sub_category/delete"})
public class SubCategoryDeleteController extends HttpServlet{
	SubCategoryService subCateService = new SubCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			int id = Integer.parseInt(req.getParameter("id"));
			SubCategory subCate = subCateService.get(id);
			if(kiemTraSubCateCoProduct(subCate)) {
				List<SubCategory> subCateList = subCateService.getAllSubCategory();
				req.setAttribute("subCateList", subCateList);
				req.setAttribute("messageCSS", "alert alert-danger");
				req.setAttribute("message", "Không thể xóa vì vẫn còn sản phẩm tồn tại trong SubCategory này");
				req.getRequestDispatcher("//views/admin/sub_category/manage-sub_category.jsp").forward(req, resp);
			}else {
				subCateService.delete(subCate.getName());
				resp.sendRedirect(req.getContextPath() + "/admin/sub_category/manage");
			}
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/ssub_category/delete");
		
		
	}
	public boolean kiemTraSubCateCoProduct(SubCategory subcate) {
		if(subcate.getProducts().size() == 0)
			return false;
		return true;
	}
}
