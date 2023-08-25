package com.utilities;
import java.io.IOException;
import java.util.Properties;


public class Config {
	Properties configFile;
	public Config() {
		configFile= new Properties();
		try {
			configFile.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String Key)
	{
		String value=this.configFile.getProperty(Key);
		return value;
	}
}
