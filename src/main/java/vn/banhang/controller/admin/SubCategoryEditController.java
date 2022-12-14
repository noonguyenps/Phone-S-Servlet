package vn.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.banhang.Model.Category;
import vn.banhang.Model.SubCategory;
import vn.banhang.service.CategoryService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/sub_category/edit"})
public class SubCategoryEditController extends HttpServlet{
	SubCategoryService subCateServcie = new SubCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			int id = Integer.parseInt(req.getParameter("id"));
			SubCategory subCate = subCateServcie.get(id);
			req.setAttribute("subCategory", subCate);
			RequestDispatcher Dispatcher = req.getRequestDispatcher("/views/admin/sub_category/edit-sub_category.jsp");
			Dispatcher.forward(req, resp);
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/sub_category/edit");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService cateService = new CategoryServiceImpl();
		SubCategory subCate = new SubCategory();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		boolean flagCateIDKhongTonTai;
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					subCate.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("id")) {
					subCate.setId(Integer.parseInt(item.getString("UTF-8")));
				}else if (item.getFieldName().equals("category_id")) {
					int cate_id = Integer.parseInt(item.getString());
					if(cateService.getByID(cate_id) != null) {
						Category cate = cateService.getByID(cate_id);
						subCate.setCategory(cate);
					}
				}
			}
			if(subCate.getCategory() == null) {
				req.setAttribute("messageCSS", "alert alert-danger");
				req.setAttribute("message", "CategoryID không tồn tại!!!");
				req.getRequestDispatcher("/views/admin/sub_category/edit-sub_category.jsp").forward(req, resp);
			}else {
				subCateServcie.edit(subCate);
				resp.sendRedirect(req.getContextPath() + "/admin/sub_category/manage");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
