package com.ee;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.utilities.SearchFileToUPload;


public class AppMain {
	private static Logger logger = Logger.getLogger(AppMain.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 logger.debug("Starting...");
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("jobbing.xml");
		 
	}

}
