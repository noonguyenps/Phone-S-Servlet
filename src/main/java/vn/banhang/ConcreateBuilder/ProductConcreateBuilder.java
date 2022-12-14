package vn.banhang.ConcreateBuilder;

import java.util.Set;

import vn.banhang.Builder.ProductBuilder;
import vn.banhang.Model.Cart;
import vn.banhang.Model.Product;
import vn.banhang.Model.Review;
import vn.banhang.Model.Shop;
import vn.banhang.Model.SubCategory;

public class ProductConcreateBuilder implements ProductBuilder{
	private int id;
	private String name;
	private String picture;
	private double price;
	private SubCategory subCategory;
	private int amount;
	private Shop shop;
	private int status;
	private String description;
	private Set<Review> reviews;
	private Set<Cart> carts;

	@Override
	public ProductBuilder setId(int id) {
		this.id = id;
		return this;
	}
	@Override
	public ProductBuilder setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public ProductBuilder setPicture(String picture) {
		this.picture = picture;
		return this;
	}
	@Override
	public ProductBuilder setPrice(double price) {
		this.price = price;
		return this;
	}
	@Override
	public ProductBuilder setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
		return this;
	}
	@Override
	public ProductBuilder setAmount(int amount) {
		this.amount = amount;
		return this;
	}
	@Override
	public ProductBuilder setShop(Shop shop) {
		this.shop = shop;
		return this;
	}
	@Override
	public ProductBuilder setStatus(int status) {
		this.status = status;
		return this;
	}
	@Override
	public ProductBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	@Override
	public ProductBuilder setReviews(Set<Review> reviews) {
		this.reviews = reviews;
		return this;
	}
	@Override
	public ProductBuilder setCarts(Set<Cart> carts) {
		this.carts = carts;
		return this;
	}
	@Override
	public Product builder() {
		return new Product( id, name, picture, price, subCategory, amount, shop,
				 status, description, reviews, carts);
	}
}
