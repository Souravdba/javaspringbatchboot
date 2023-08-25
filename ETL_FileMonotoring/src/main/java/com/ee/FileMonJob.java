package com.ee;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.utilities.SearchFileToUPload;

public class FileMonJob {
	final static Logger logger = LogManager.getLogger(FileMonJob.class.getName());
	public void printAnotherMessage() throws IOException{
		logger.debug("Executing Upload");
        SearchFileToUPload.running();
    }

}
