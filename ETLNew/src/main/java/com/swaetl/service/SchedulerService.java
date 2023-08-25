package com.swaetl.service;

import com.swaetl.task.FirstTask;
import com.swaetl.task.SecondTask;

public class SchedulerService implements ISchedulerService {
	private FirstTask firstTask;
	private SecondTask secondTask;
	
	
	public FirstTask getFirstTask() {
		return firstTask;
	}
	public void setFirstTask(FirstTask firstTask) {
		this.firstTask = firstTask;
	}
	public SecondTask getSecondTask() {
		return secondTask;
	}
	public void setSecondTask(SecondTask secondTask) {
		this.secondTask = secondTask;
	}
	@Override
	public void executeFirstTask() {
		// TODO Auto-generated method stub
		 getFirstTask().execute();
		 getSecondTask().execute();
		
	}
	@Override
	public void executeSecondTask() {
		// TODO Auto-generated method stub
		
	}


}
