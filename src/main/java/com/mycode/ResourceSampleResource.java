package com.mycode;

import java.util.Date;

public class ResourceSampleResource {

	String type;
	Date purchasedate;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	@Override
	public String toString() {
		return "SampleResource [type=" + type + ", purchasedate=" + purchasedate + "]";
	}
	
	
}
