package com.capgemini.shoppingCartSystem.orderservice.exception;

public class RecordNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String s) {
		super(s);
	}

}
