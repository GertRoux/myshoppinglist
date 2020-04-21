package com.luv2code.mylist.mvc.service;

import java.util.List;

import com.luv2code.mylist.hibernate.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product getProductForId(int productId);
	
	List<Product> searchProducts(String theSearchName);
	
	void deleteProductForId(int productId);
	
	void saveProduct(Product product);
}
