package vn.banhang.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.util.Pair;
import vn.banhang.Model.Product;
import vn.banhang.Model.SubCategory;
import vn.banhang.Model.User;
import vn.banhang.service.ProductService;
import vn.banhang.service.SubCategoryService;
import vn.banhang.service.impl.ProductServiceImpl;
import vn.banhang.service.impl.SubCategoryServiceImpl;
import vn.banhang.utils.Utils;

@WebServlet(urlPatterns = {"/seller/product"})
public class SellerProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(Utils.kiemTraIsSeller(req, resp)) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			String kw = req.getParameter("kw");
			req.setAttribute("kw", kw);
			String subCate = req.getParameter("subCate");
			req.setAttribute("subCateId", subCate);
			String status = req.getParameter("status");
			req.setAttribute("status", status);
			
			System.out.println(kw);System.out.println(subCate);System.out.println(status);
			
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			
			ProductService service = new ProductServiceImpl();
			SubCategoryService subCateService = new SubCategoryServiceImpl();
			Pair<Integer, List<Product>> pair;
			if(kw == null && subCate == null && status == null) {
				pair = service.getAllShopProduct(user.getShop(), 1);
				req.setAttribute("listProduct", pair.getValue());
				req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
			}
			else {
				if(subCate.equals("")) {
					pair = service.searchProductShop(user.getShop(), kw, status, 1);
					req.setAttribute("listProduct", pair.getValue());
					req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
				}
				else {
					int subCateId = Integer.parseInt(subCate);
					pair = service.searchProductShop(user.getShop(), kw, subCateId, status, 1);
					req.setAttribute("listProduct", pair.getValue());
					req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
				}
			}

			req.setAttribute("pageActive", 1);
			
			List<SubCategory> listSubCate = subCateService.getAllSubCategory();
			req.setAttribute("listSubCate", listSubCate);
			
			
			
			req.getRequestDispatcher("/views/seller/products.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/login?next=seller/product");
		}
	}
}
