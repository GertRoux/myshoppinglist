package com.luv2code.mylist.mvc.model;

public class Price {
	
	private Double price;
	
	private String dateOfPurchase;
	
	private String product;
	
	private String retailer;
	
	public Price() {
		
	}

	public Price(Double price, String dateOfPurchase, String product, String retailer) {
		super();
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
		this.product = product;
		this.retailer = retailer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	
	

}
