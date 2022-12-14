package vn.banhang.controller.seller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.banhang.Model.Shop;
import vn.banhang.Model.User;
import vn.banhang.service.ShopService;
import vn.banhang.service.impl.ShopServiceImpl;
import vn.banhang.utils.Constant;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/seller/edit-info"})
public class SellerEditInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemTraIsSeller(req, resp)) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			Shop shop = user.getShop();
			req.setAttribute("shop", shop);
			
			req.getRequestDispatcher("/views/seller/edit_shop_info.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login?next=seller/edit-info");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		ShopService shopService = new ShopServiceImpl();
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		Shop shop = user.getShop();
		
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for(FileItem item:items) {
				if(item.getFieldName().equals("location")) {
					shop.setLocation( item.getString("UTF-8") );
				}
				else if(item.getFieldName().equals("name")) {
					shop.setName(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("avatar")) {
					if(item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/seller/" + fileName);
						item.write(file);
						shop.setAvatar("seller/" + fileName);
					}
				}
			}
			
			shopService.update(shop);
			resp.sendRedirect(req.getContextPath() + "/seller");
	
		}catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

