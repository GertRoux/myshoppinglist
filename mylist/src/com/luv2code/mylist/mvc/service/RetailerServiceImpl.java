package com.luv2code.mylist.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.mylist.hibernate.model.RetailerEntity;
import com.luv2code.mylist.mvc.dao.RetailerDAO;

@Service
public class RetailerServiceImpl implements RetailerService {
	
	@Autowired
	private RetailerDAO retailerDAO;

	@Override
	@Transactional
	public List<RetailerEntity> getRetailers() {
		return retailerDAO.getAllRetailers();
	}

	@Override
	@Transactional
	public List<RetailerEntity> searchRetailers(String theSearchName) {
		return retailerDAO.searchRetailers(theSearchName);
	}

	@Override
	@Transactional
	public RetailerEntity getRetailerForId(int retailerId) {
		// TODO Auto-generated method stub
		return retailerDAO.getRetailerForId(retailerId);
	}

	@Override
	@Transactional 
	public void deleteRetailerForId(int retailerId) {
		retailerDAO.deleteRetailerForId(retailerId);
		
	}

	@Override
	@Transactional
	public void saveRetailer(RetailerEntity retailer) {
		retailerDAO.saveRetailer(retailer);
		
	}

}
