package com.swso;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;


public class student {
  String name;
  int Age;
  int Rln;
  course course1;

  
 public student() {
		// TODO Auto-generated constructor stub
	}
  
public student(String name, int age, int rln, course course1) {
	this.name = name;
	Age = age;
	Rln = rln;
	this.course1 = course1;
}



public course getCourse() {
	return course1;
}

@Resource(name="course1")
public void setCourse(course course1) {
	this.course1 = course1;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public int getRln() {
	return Rln;
}
public void setRln(int rln) {
	Rln = rln;
}
 
@Override
public String toString() {
	return "student [name=" + name + ", Age=" + Age + ", Rln=" + Rln + ", course=" + course1 + "]";
}




  
}
