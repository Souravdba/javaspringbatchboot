package com.utilities;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchFileToUPload {
	final static Logger logger = LogManager.getLogger(SearchFileToUPload.class.getName());

	public static void running() throws IOException {
		Config con = new Config();
		File ff = new File(con.getProperty("inputpath"));
		File[] ffl = ff
				.listFiles(new DataFile(con.getProperty("FileNameIncluded"), con.getProperty("FileNameExcluded")));
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
//		System.out.println("Searching File With Pattern:- " + con.getProperty("FileNameIncluded"));
		logger.info("Searching File" + ".*abcdef.*");
		

		if (ffl.length != 0) {
			logger.info("File Found: " + Arrays.toString(ffl));
			logger.info("Starting to Upload");
			hdfsfunc.uploading(ffl, con.getProperty("exterDir") + reportDate);

		} else {
			logger.info("No file found !!!");
		}

	}

}