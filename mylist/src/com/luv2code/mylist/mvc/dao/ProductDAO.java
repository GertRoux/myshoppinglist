package com.luv2code.mylist.mvc.dao;

import java.util.List;

import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.hibernate.model.RetailerEntity;

public interface ProductDAO {
	
	void saveProduct(Product product);
	
	List<Product> getAllProducts();
		
	List<Product> searchProducts(String theSearchName);
	
	Product getProductForId(int productId);
	
	void deleteProductForId(int productId);

}
