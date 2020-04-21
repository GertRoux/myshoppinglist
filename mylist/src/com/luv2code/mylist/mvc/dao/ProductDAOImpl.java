package com.luv2code.mylist.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.mylist.hibernate.model.Product;
import com.luv2code.mylist.hibernate.model.RetailerEntity;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProduct(Product product) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//if(primaryKey/id) empty then INSERT new customer else UPDATE existing customer
		session.saveOrUpdate(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create query... sort by last name
		Query<Product> theQuery = session.createQuery("from Product order by name", Product.class);
		
		// get customers from result list
		List<Product> products = theQuery.getResultList();
		
		//return customers list
		return products;
	}

	@Override
	public List<Product> searchProducts(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Product where lower(name) like :theName", Product.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Product", Product.class);            
        }
        
        // execute query and get result list
        List<Product> products = theQuery.getResultList();
                
        // return the results        
        return products;
	}

	@Override
	public Product getProductForId(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Product product = currentSession.get(Product.class, productId);
		
		return product;
	}

	@Override
	public void deleteProductForId(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", productId);
		theQuery.executeUpdate();

	}

}
