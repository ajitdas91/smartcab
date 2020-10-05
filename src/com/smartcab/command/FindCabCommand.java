package com.smartcab.command;

import java.io.Serializable;

public class FindCabCommand implements Serializable {
	protected String source;
	protected String dest;
	protected int capacity;

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

}
