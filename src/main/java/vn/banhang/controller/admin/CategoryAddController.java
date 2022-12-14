package vn.banhang.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
import vn.banhang.Model.User;
import vn.banhang.service.CategoryService;
import vn.banhang.service.impl.CategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/admin/category/add"})
public class CategoryAddController extends HttpServlet{
	CategoryService cateService = new CategoryServiceImpl() ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemtraAdmin(req, resp)) {
			req.setAttribute("userAdmin", Utils.getUserAdmin(req, resp));
			RequestDispatcher Dispatcher = req.getRequestDispatcher("/views/admin/category/add-category.jsp");
			Dispatcher.forward(req, resp);
		}else
			resp.sendRedirect(req.getContextPath() + "/login?next=admin/category/add");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					category.setName(item.getString("UTF-8"));
				}  
			}
			if(cateService.get(category.getName()) == null) {
				cateService.insert(category);
				resp.sendRedirect(req.getContextPath() + "/admin/category/manage");
			}else {
				req.setAttribute("messageCSS", "alert alert-danger");
				req.setAttribute("message", "Tên này đã tồn tại vui lòng nhập lại tên Category khác !!!");
				req.getRequestDispatcher("/views/admin/category/add-category.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

