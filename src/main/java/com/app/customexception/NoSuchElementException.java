package com.app.customexception;

public class NoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

public NoSuchElementException(String msg) {
	super(msg);
}

}
