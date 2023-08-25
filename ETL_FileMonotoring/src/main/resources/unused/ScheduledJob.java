package com.ee;

import java.io.IOException;
import java.sql.SQLException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ee.FileMonJob;

public class ScheduledJob extends QuartzJobBean{
	 private AnotherJob anotherBean; 
	 


	public void setAnotherBean(AnotherJob anotherBean) {
		this.anotherBean = anotherBean;
	}


	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			anotherBean.printAnotherMessage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
