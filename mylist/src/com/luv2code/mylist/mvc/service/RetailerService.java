package com.luv2code.mylist.mvc.service;

import java.util.List;

import com.luv2code.mylist.hibernate.model.RetailerEntity;

public interface RetailerService {
	
	List<RetailerEntity> getRetailers();
	
	List<RetailerEntity> searchRetailers(String theSearchName);
	
	RetailerEntity getRetailerForId(int retailerId);
	
	void deleteRetailerForId(int retailerId);
	
	void saveRetailer(RetailerEntity retailer);

}
