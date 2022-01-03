package com.example.app.exception;

public class NoOrdersYetException extends RuntimeException {

	public NoOrdersYetException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
