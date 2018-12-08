package com.mycode;

import java.util.Date;

public class ExceptionCommonResponse {

	public ExceptionCommonResponse(Date timeStamp, String details) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
	}
	Date timeStamp;
	String details;
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
