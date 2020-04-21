package com.luv2code.mylist.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.mvc.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProductForId(int productId) {
		return productDAO.getProductForId(productId);
	}

	@Override
	@Transactional
	public List<Product> searchProducts(String theSearchName) {
		return productDAO.searchProducts(theSearchName);
	}

	@Override
	@Transactional
	public void deleteProductForId(int productId) {
		productDAO.deleteProductForId(productId);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}

}
