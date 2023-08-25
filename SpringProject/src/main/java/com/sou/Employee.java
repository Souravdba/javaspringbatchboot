package com.sou;

public class Employee {
	int id;
	String name;
	int sal;
	Address addrs;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Address addrs) {
		this.addrs = addrs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Address getAddrs() {
		return addrs;
	}

	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", addrs=" + addrs + "]";
	}
	
	
}
