package com.boot.app.FirstBootApp.handler;

import java.util.List;

/**
 * @author Faiyaz
 *
 */
public class ErrorResponse {

	private String msg;
	private List<String> details;
	
	public ErrorResponse(String string, List<String> details) {
       this.msg=string;
       this.details=details;
	}
   
	public String getMsg() {
		return msg;
	}
	
	public List<String> getDetails() {
		return details;
	}
}
