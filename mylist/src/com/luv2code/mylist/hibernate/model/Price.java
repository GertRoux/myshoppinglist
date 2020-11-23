package com.luv2code.mylist.hibernate.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.luv2code.mylist.mvc.DateUtils;

@Entity
@Table(name="price")
public class Price implements Comparable<Price>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "date_of_purchase")
	private Date dateOfPurchase;
	
	@OneToOne(cascade = {CascadeType.DETACH,
						 CascadeType.MERGE,
						 CascadeType.PERSIST,
						 CascadeType.REFRESH})
	@JoinColumn(name = "retailer_id")
	private RetailerEntity retailer;
	
	@OneToOne(cascade = {CascadeType.DETACH,
			 CascadeType.MERGE,
			 CascadeType.PERSIST,
			 CascadeType.REFRESH})
	@JoinColumn(name = "product_id")
	private Product product;

	public Price() {
		
	}

	public Price(Double price, Date dateOfPurchase, RetailerEntity retailer, Product product) {
		super();
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
		this.retailer = retailer;
		this.product = product;
	}

	public Price(Double price, String dateOfPurchase, RetailerEntity retailer, Product product) {
		this.price = price;
		try {
			this.dateOfPurchase = DateUtils.parseDate(dateOfPurchase);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.retailer = retailer;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public RetailerEntity getRetailer() {
		return retailer;
	}

	public void setRetailer(RetailerEntity retailer) {
		this.retailer = retailer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "PriceEntity [id=" + id + ", price=" + price + ", dateOfPurchase=" + dateOfPurchase + ", retailer="
				+ retailer + ", product=" + product + "]";
	}

	@Override
	public int compareTo(Price o) {
		if (dateOfPurchase.before(o.dateOfPurchase)) {
			return 1;
		} else if (dateOfPurchase.after(o.dateOfPurchase)) {
			return -1;
		}
		return 0;
	}
	
}
