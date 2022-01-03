package com.example.app.exception;

public class ItemWasRegisteredPreviousException extends RuntimeException {

	public ItemWasRegisteredPreviousException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
