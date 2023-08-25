package com.sou;

public class Address {
 String City;
 String State;
 int zipCode;
 public Address() {
	// TODO Auto-generated constructor stub
}
public Address(String city, String state, int zipCode) {
	City = city;
	State = state;
	this.zipCode = zipCode;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {
	return "Address [City=" + City + ", State=" + State + ", zipCode=" + zipCode + "]";
}
 
}
