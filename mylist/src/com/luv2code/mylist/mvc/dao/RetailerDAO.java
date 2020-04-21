package com.luv2code.mylist.mvc.dao;

import java.util.List;

import com.luv2code.mylist.hibernate.model.RetailerEntity;

public interface RetailerDAO {
	
	void saveRetailer(RetailerEntity retailer);
	
	List<RetailerEntity> getAllRetailers();
	
	List<RetailerEntity> searchRetailers(String theSearchName);
	
	RetailerEntity getRetailerForId(int retailerId);
	
	void deleteRetailerForId(int retailerId);

}
