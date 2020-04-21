package com.luv2code.mylist.mvc.dao;

import java.util.List;

import com.luv2code.mylist.hibernate.model.Price;

public interface PriceDAO {
	
	void savePrice(Price price);
	
	List<Price> getAllPrices();

	Price getPriceForId(int priceId);

	List<Price> searchPrices(String theSearchName);

	void deletePriceForId(int priceId);

}
