package com.smartcab.bo;

import java.io.Serializable;

public class CabBo implements Serializable {
	private int cabId;
	private String driverName;
	private String mobile;
	private String area;

	public CabBo(int cabId, String driverName, String mobile, String area) {
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
