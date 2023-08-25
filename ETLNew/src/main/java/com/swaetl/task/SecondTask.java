package com.swaetl.task;

import org.apache.log4j.Logger;

public class SecondTask {
	private static Logger log = Logger.getLogger(SecondTask.class);
    
    /**
     * Execute this task
     * 
     */
    public void execute() {
        log.debug("SecondTask runs successfully...");
    }   
}
