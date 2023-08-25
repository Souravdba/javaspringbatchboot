package com.swasou.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompleteListner implements JobExecutionListener{

	@Override
	public void afterJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		if(arg0.getStatus() == BatchStatus.COMPLETED)
		{
			System.out.println("Batch Job completed");
		}
		
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
