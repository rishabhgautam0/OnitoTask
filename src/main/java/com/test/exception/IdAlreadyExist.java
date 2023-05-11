package com.test.exception;

@SuppressWarnings("serial")
public class IdAlreadyExist extends RuntimeException{

	public IdAlreadyExist(String msg) {
		super(msg);
	}
}
