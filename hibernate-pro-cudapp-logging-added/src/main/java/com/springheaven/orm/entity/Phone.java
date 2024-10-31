package com.springheaven.orm.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	
	private String mobileNo;
	private String officeNo;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	
	
	
}
