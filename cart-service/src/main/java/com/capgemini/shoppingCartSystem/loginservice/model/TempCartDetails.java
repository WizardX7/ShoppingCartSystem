package com.capgemini.shoppingCartSystem.loginservice.model;

public class TempCartDetails {
	private int[] productIDs;
	private int[] quantities;
	private String userId;
	
	public TempCartDetails(int[] productIDs,int[] quantities, String userId) {
		this.productIDs=productIDs;
		this.quantities=quantities;
		this.userId=userId;
		
	}
	public int[] getProductIDs() {
		return productIDs;
	}
	public void setProductIDs(int[] productIDs) {
		this.productIDs = productIDs;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

}
