package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.banhang.Model.Category;
import vn.banhang.service.CategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/category/delete"})
public class CategoryDeleteController extends HttpServlet{
	CategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 4399621604632614040L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			int id = Integer.parseInt(req.getParameter("id"));
			Category cate = cateService.getByID(id);
			String cname = cate.getName();
			if(checkSubCate(cate)) {
				List<Category> cateList = cateService.getCategories();
				req.setAttribute("categoryList", cateList);
				req.setAttribute("messageCSS", "alert alert-danger");
				req.setAttribute("message", "Không thể xóa vì vẫn còn danh mục tồn tại trong danh mục này");
				req.getRequestDispatcher("/views/admin/category/manage-category.jsp").forward(req, resp);
			} else {
				cateService.delete(cname);
				resp.sendRedirect(req.getContextPath() + "/admin/category/manage");
			}
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/category/delete");
	}
	public boolean checkSubCate(Category cate) {
		if(cate.getSubCategories().isEmpty())
			return false;
		return true;
	}
}
