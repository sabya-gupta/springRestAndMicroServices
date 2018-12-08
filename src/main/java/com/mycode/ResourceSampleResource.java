package com.mycode;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Desc about the resource object")
public class ResourceSampleResource {

	
	@Size(min = 5, max=10)
	@ApiModelProperty(notes="Must be between 5 and 10")
	String type;
	
	@Past
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
