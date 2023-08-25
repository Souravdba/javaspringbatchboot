package com.swaetl.task;

import org.apache.log4j.Logger;

public class FirstTask {
	private static Logger log = Logger.getLogger(FirstTask.class);
    
    /**
     * Execute this task
     * 
     */
    public void execute() {
        log.debug("FirstTask runs successfully...");
    }   

}
