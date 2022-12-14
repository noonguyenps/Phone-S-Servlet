package vn.banhang.controller.seller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import vn.banhang.service.impl.CartServiceImpl;

@WebServlet(urlPatterns = {"/api/delivery"})
public class SellerDeliveryController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		String json = req.getReader().readLine();
		JsonObject jObj = gson.fromJson(json, JsonObject.class);
		int id = jObj.get("id").getAsInt();
		
		Map<String, Integer> mapper = new HashMap<String, Integer>();
		
		try {
			new CartServiceImpl().deliveryCart(id);
			mapper.put("error", 200);
			resp.getWriter().write(gson.toJson(mapper));
		}catch(Exception e) {
			e.printStackTrace();
			mapper.put("error", 404);
			resp.getWriter().write(gson.toJson(mapper));
		}
		
		
	}
}
