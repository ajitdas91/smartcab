package com.smartcab.bo;

import java.io.Serializable;

public class TripDetailBo implements Serializable {
	protected String source;
	protected String dest;
	protected int capacity;
	protected int cabId;
	protected String driverName;
	protected String status;
	protected String name;
	protected String contactMobile;
	protected String emergencyContact;

	public TripDetailBo(String source, String dest, int capacity, int cabId,
			String driverName, String status, String name,
			String contactMobile, String emergencyContact) {
		this.source = source;
		this.dest = dest;
		this.capacity = capacity;
		this.cabId = cabId;
		this.driverName = driverName;
		this.status = status;
		this.name = name;
		this.contactMobile = contactMobile;
		this.emergencyContact = emergencyContact;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

}
