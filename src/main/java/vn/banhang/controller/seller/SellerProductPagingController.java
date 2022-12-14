package vn.banhang.controller.seller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns= {"/api/paging-seller"})
public class SellerProductPagingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String kw = req.getParameter("kw");
		req.setAttribute("kw", kw);
		String subCate = req.getParameter("subCate");
		req.setAttribute("subCateId", subCate);
		String status = req.getParameter("status");
		req.setAttribute("status", status);
		int page = Integer.parseInt(req.getParameter("page"));
		
		System.out.println(kw);System.out.println(subCate);System.out.println(status);
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		ProductService service = new ProductServiceImpl();
		SubCategoryService subCateService = new SubCategoryServiceImpl();
		Pair<Integer, List<Product>> pair;
		if(kw == null && subCate == null && status == null) {
			pair = service.getAllShopProduct(user.getShop(), page);
			req.setAttribute("listProduct", pair.getValue());
			req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
		}
		else {
			if(subCate.equals("")) {
				pair = service.searchProductShop(user.getShop(), kw, status, page);
				req.setAttribute("listProduct", pair.getValue());
				req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
			}
			else {
				int subCateId = Integer.parseInt(subCate);
				pair = service.searchProductShop(user.getShop(), kw, subCateId, status, page);
				req.setAttribute("listProduct", pair.getValue());
				req.setAttribute("pages", (int) Math.ceil(pair.getKey() / 5.0));
			}
		}

		req.setAttribute("pageActive", page);
		
		List<SubCategory> listSubCate = subCateService.getAllSubCategory();
		req.setAttribute("listSubCate", listSubCate);
		
		PrintWriter out = resp.getWriter();
		
		for(Product p:pair.getValue()) {
			String img = "http://localhost:8080/BanHang/image?fname=" + p.getPicture();
			out.println("<tr role=\"row\" class=\"filter\">\r\n" + 
					"										<td>\r\n" + 
					"										</td>\r\n" + 
					"										<td>\r\n" + Integer.toString(p.getId()) +
					"											\r\n" + 
					"										</td>\r\n" + 
					"										<td>\r\n" + p.getName() +
					"											 \r\n" + 
					"										</td>\r\n" + 
					"										\r\n" + 
					"										<td>\r\n" + 
					"											<c:url value=\"/image?fname="+ p.getPicture() + "\" var=\"imgUrl\"></c:url>\r\n" + 
					"											<img height=\"100\" width=\"100\" src=\'"  + img + "' />\r\n" + 
					"										</td>\r\n" + 
					"										\r\n" + 
					"										<td>\r\n" + Double.toString(p.getPrice()) +
					"											\r\n" + 
					"										</td>\r\n" + 
					"										\r\n" + 
					"										<td>\r\n" + p.getSubCategory().getName() +
					"											 \r\n" + 
					"										</td>\r\n" + 
					"										<td>\r\n" + Integer.toString(p.getAmount()) +
					"											 \r\n" + 
					"										</td>\r\n" + 
					"										<td>\r\n" + 
															(p.getStatus()==1? "Đang bán":p.getStatus()==0? "Ngưng bán":"Tạm ẩn") +
					"										</td>\r\n" + 
					"										<td>\r\n" + p.getDescription() +
					"											\r\n" + 
					"										</td>\r\n" + 
					"										<td>\r\n" + 
					"											<div class=\"margin-bottom-5\">\r\n" + 
					"												<a class=\"btn btn-sm yellow\" href=\"/BanHang/seller/edit-product?id=" +p.getId() + "\"><i class=\"fa fa-pencil\"></i> Edit</a>\r\n" + 
					"											</div>\r\n" + 
					"											<a class=\"btn btn-sm red filter-cancel\"><i class=\"fa fa-times\"></i> Delete</a>\r\n" + 
					"\r\n" + 
					"										</td>\r\n" + 
					"									</tr>");
		}
		
	}
}
