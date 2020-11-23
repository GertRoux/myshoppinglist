package com.luv2code.mylist.mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.mylist.hibernate.model.Price;
import com.luv2code.mylist.mvc.dao.PriceDAO;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDAO priceDAO;

	@Override
	@Transactional
	public Map<String, List<Price>> getAllPrices() {
		Map<String, List<Price>> theResponse = new HashMap<String, List<Price>>();
		List<Price> prices = priceDAO.getAllPrices();
		Collections.sort(prices);
		for (Price price : prices) {
			if (theResponse.containsKey(price.getProduct().getName())) {
				theResponse.get(price.getProduct().getName()).add(price);
			} else {
				List<Price> value = new ArrayList<Price>();
				value.add(price);
				theResponse.put(price.getProduct().getName(),  value);
			}
		}
		
		return theResponse;
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
