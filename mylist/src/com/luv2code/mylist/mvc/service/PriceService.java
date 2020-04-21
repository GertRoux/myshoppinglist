package com.luv2code.mylist.mvc.service;

import java.util.List;

import com.luv2code.mylist.hibernate.model.Price;


public interface PriceService {
	
	List<Price> getAllPrices();
	
	Price getPriceForId(int priceId);
	
	List<Price> searchPrices(String theSearchName);
	
	void deletePriceForId(int priceId);
	
	void savePrice(Price price);

}
