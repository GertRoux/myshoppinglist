package com.luv2code.mylist.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.mylist.hibernate.model.Price;

@Repository
public class PriceDAOImpl implements PriceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePrice(Price price) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//if(primaryKey/id) empty then INSERT new customer else UPDATE existing customer
		session.saveOrUpdate(price);
	}

	@Override
	public List<Price> getAllPrices() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create query... sort by last name
		Query<Price> theQuery = session.createQuery("from Price order by dateOfPurchase", Price.class);
		
		// get customers from result list
		List<Price> prices = theQuery.getResultList();
		
		//return customers list
		return prices;
	}

	@Override
	public Price getPriceForId(int priceId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Price price = currentSession.get(Price.class, priceId);
		
		return price;
	}

	@Override
	public List<Price> searchPrices(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Price where lower(product.name) like :theName", Price.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Price", Price.class);            
        }
        
        // execute query and get result list
        List<Price> prices = theQuery.getResultList();
                
        // return the results        
        return prices;
	}

	@Override
	public void deletePriceForId(int priceId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Price where id=:priceId");
		theQuery.setParameter("priceId", priceId);
		theQuery.executeUpdate();
	}

}
