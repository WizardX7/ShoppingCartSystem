package com.capgemini.shoppingCartSystem.orderservice.model;

public class OrderDetails {
	private int[] productIDs;
	private int[] quantities;
	
	public OrderDetails(int[] productIDs,int[] quantities, String userId) {
		this.productIDs=productIDs;
		this.setQuantities(quantities);
		//this.userId=userId;
		
	}
	public int[] getProductIDs() {
		return productIDs;
	}
	public void setProductIDs(int[] productIDs) {
		this.productIDs = productIDs;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

}
