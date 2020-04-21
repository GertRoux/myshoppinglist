package com.luv2code.mylist.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.mylist.hibernate.model.RetailerEntity;

@Repository
public class RetailerDAOImpl implements RetailerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveRetailer(RetailerEntity retailer) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//if(primaryKey/id) empty then INSERT new customer else UPDATE existing customer
		session.saveOrUpdate(retailer);
	}

	@Override
	public List<RetailerEntity> getAllRetailers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create query... sort by last name
		Query<RetailerEntity> theQuery = session.createQuery("from RetailerEntity order by name", RetailerEntity.class);
		
		// get customers from result list
		List<RetailerEntity> retailers = theQuery.getResultList();
		
		//return customers list
		return retailers;
	}

	@Override
	public List<RetailerEntity> searchRetailers(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from RetailerEntity where lower(name) like :theName", RetailerEntity.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Retailer", RetailerEntity.class);            
        }
        
        // execute query and get result list
        List<RetailerEntity> retailers = theQuery.getResultList();
                
        // return the results        
        return retailers;
	}

	@Override
	public RetailerEntity getRetailerForId(int retailerId) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		RetailerEntity retailer = currentSession.get(RetailerEntity.class, retailerId);
		
		return retailer;
	}

	@Override
	public void deleteRetailerForId(int retailerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from RetailerEntity where id=:retailerId");
		theQuery.setParameter("retailerId", retailerId);
		theQuery.executeUpdate();
		
	}

}
