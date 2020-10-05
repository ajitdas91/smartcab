package com.smartcab.dto;

import java.io.Serializable;

public class CabDto implements Serializable {
	protected int cabId;
	protected String driverName;
	protected String mobile;
	protected String area;

	public CabDto(int cabId, String driverName, String mobile, String area) {
		super();
		this.cabId = cabId;
		this.driverName = driverName;
		this.mobile = mobile;
		this.area = area;
	}

	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
