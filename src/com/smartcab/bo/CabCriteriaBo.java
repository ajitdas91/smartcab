package com.smartcab.bo;

import java.io.Serializable;

public class CabCriteriaBo implements Serializable {
	protected String source;
	protected int capacity;
	protected String status;

	public CabCriteriaBo(String source, int capacity, String status) {
		super();
		this.source = source;
		this.capacity = capacity;
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
