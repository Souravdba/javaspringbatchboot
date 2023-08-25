package com.swso;

public class course {
   int duration;
   float points;
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public float getPoints() {
	return points;
}
public void setPoints(float points) {
	this.points = points;
}

public course() {
	// TODO Auto-generated constructor stub
}
public course(int duration, float points) {
	this.duration = duration;
	this.points = points;
}
@Override
public String toString() {
	return "course [duration=" + duration + ", points=" + points + "]";
}


   
}
