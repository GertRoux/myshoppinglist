package com.luv2code.mylist.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.mylist.hibernate.model.Price;
import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.mvc.dao.PriceDAO;
import com.luv2code.mylist.mvc.dao.ProductDAO;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDAO priceDAO;

	@Override
	@Transactional
	public List<Price> getAllPrices() {
		return priceDAO.getAllPrices();
	}

	@Override
	@Transactional
	public Price getPriceForId(int priceId) {
		return priceDAO.getPriceForId(priceId);
	}

	@Override
	@Transactional
	public List<Price> searchPrices(String theSearchName) {
		return priceDAO.searchPrices(theSearchName);
	}

	@Override
	@Transactional
	public void deletePriceForId(int priceId) {
		priceDAO.deletePriceForId(priceId);
	}

	@Override
	@Transactional
	public void savePrice(Price price) {
		priceDAO.savePrice(price);
	}

}
