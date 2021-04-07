package com.capgemini.shoppingCartSystem.userservice.exception;

public class NotAuthenticatedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthenticatedException(String s) {
		super(s);
	}
}
