package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class hdfsfunc {
	final static Logger logger = LogManager.getLogger(hdfsfunc.class.getName());
	public static void uploading(File[] file, String dst) throws IOException {
		Configuration conf = new Configuration();
		Config con=new Config();
		
		conf.set("fs.defaultFS", con.getProperty("hadoopcluster"));
		conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
	    conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
		FileSystem fs;
		try {
			fs = FileSystem.get(conf);
			Path dstpath = new Path(con.getProperty("hadoopcluster") + dst);
			if (fs.exists(dstpath)) {
				logger.info(dstpath + " Dir already exists.");
				for (File fi : file) {
					logger.info("Uploading "+fi);
					fs.copyFromLocalFile(new Path(fi.getAbsolutePath().toString()), dstpath);
					logger.info(fi.getAbsolutePath().toString() +" Uploaded Successfully");
					logger.info("Marking as Success  "+fi.toString());
					File newname=new File(fi.getAbsoluteFile()+con.getProperty("FileMarkSuccess"));
					fi.renameTo(newname);
				}
				
				
			} else {
				logger.info(dstpath + " Does not exists");
				logger.info("Creating Dirctory " + dstpath);
				fs.mkdirs(dstpath);
				if (fs.exists(dstpath)) {
					logger.info(dstpath + " Dir Created Successfully");
					logger.info("Now Starting to upload");
					for (File fi : file) {
						logger.info("Uploading "+fi);
						fs.copyFromLocalFile(new Path(fi.getAbsolutePath().toString()), dstpath);
						logger.info(fi.getAbsolutePath().toString() +" Uploaded Successfully");
						logger.info("Marking as Success  "+fi.toString());
						File newname=new File(fi.getAbsoluteFile()+con.getProperty("FileMarkSuccess"));

						fi.renameTo(newname);
					}
					
				} else {
					logger.error("Directory  Creation Failed");
				}
			}

			fs.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
