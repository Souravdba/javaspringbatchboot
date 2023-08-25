package com.swso;

import org.springframework.beans.factory.annotation.Autowired;

public class Engine {

	private String manufacture ;
	private int octane;
	public String getManufacture() {
		return manufacture;
	}
	
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getOctane() {
		return octane;
	}
	
	public void setOctane(int octane) {
		this.octane = octane;
	}
	
	public Engine() {
		// TODO Auto-generated constructor stub
	}
//	public Engine(String manufacture, int octane) {
//		Manufacture = manufacture;
//		Octane = octane;
//	}
	@Override
	public String toString() {
		return "Engine [Manufacture=" + manufacture + ", Octane=" + octane + "]";
	}
	
	
}
