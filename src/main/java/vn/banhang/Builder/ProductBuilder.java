package vn.banhang.Builder;

import java.util.Set;

import vn.banhang.Model.Cart;
import vn.banhang.Model.Product;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.Model.SubCategory;

public interface ProductBuilder {
	ProductBuilder setId(int id);
	ProductBuilder setName(String name);
	ProductBuilder setPicture(String picture);
	ProductBuilder setPrice(double price);
	ProductBuilder setSubCategory(SubCategory subCategory);
	ProductBuilder setAmount(int amount);
	ProductBuilder setShop(Shop shop);
	ProductBuilder setStatus(int status);
	ProductBuilder setDescription(String description);
	ProductBuilder setReviews(Set<Review> reviews);
	ProductBuilder setCarts(Set<Cart> carts);
	Product builder();
}
