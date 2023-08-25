package com.utilities;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class upload {
	
	public static boolean uploading(String src,String dst)
	{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.99.100:9000");
		FileSystem fs;
		try {
			fs = FileSystem.get(conf);
			Path dstpath=new Path("hdfs://192.168.99.100:9000"+dst);
			if(checkDir(dst)){
				fs.copyFromLocalFile(new Path(src), dstpath);
			}
			else
			{
				if(mkdi(dst))
				{
					fs.copyFromLocalFile(new Path(src), new Path(dst));
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}

	public static boolean checkDir(String loc)
	{
		Configuration conf = new Configuration();

		conf.set("fs.defaultFS", "hdfs://192.168.99.100:9000");
		FileSystem fs;
		try {
			fs = FileSystem.get(conf);
			Path path=new Path("hdfs://192.168.99.100:9000"+loc);
			fs.exists(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	public static boolean mkdi(String loc) throws IOException
	{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.99.100:9000");
		FileSystem fs= FileSystem.get(conf);;
		try {
			Path path=new Path("hdfs://192.168.99.100:9000"+loc);
			if(fs.exists(path))
			{
				throw new IOException(loc+" already exists");
				
			}
			else
			{
				fs.mkdirs(path);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			fs.close();
		}
		return true;
		
	}

	
}
