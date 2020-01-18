package com.boot.app.FirstBootApp.exception;

public class MyException extends RuntimeException{

	public MyException(String message) {
		super(message);
	}
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
