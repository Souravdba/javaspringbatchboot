package com.swso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Vehicle {
    private int wheal;
    private int door;
    private Engine an;
	public int getWheal() {
		return wheal;
	}
	public void setWheal(int wheal) {
		this.wheal = wheal;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public Engine getAn() {
		return an;
	}
	public void setAn(Engine an) {
		this.an = an;
	}
	@Override
	public String toString() {
		return "Vehicle [wheal=" + wheal + ", door=" + door + ", an=" + an + "]";
	}
    
	
	
}
