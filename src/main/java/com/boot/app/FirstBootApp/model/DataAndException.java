package com.boot.app.FirstBootApp.model;

import com.boot.app.FirstBootApp.exception.MyException;

public class DataAndException {

	private String name;
	private boolean status;
	private MyException exception;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public MyException getException() {
		return exception;
	}
	public void setException(MyException exception) {
		this.exception = exception;
	}
	@Override
	public String toString() {
		return "DataAndException [name=" + name + ", status=" + status + ", exception=" + exception + "]";
	}

}
