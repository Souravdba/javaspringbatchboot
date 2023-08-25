package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HiveJob {
	final static Logger logger = LogManager.getLogger(HiveJob.class.getName());
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public  void mounting() throws SQLException {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		Config conf=new Config();
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
 
		Connection con = DriverManager.getConnection(conf.getProperty("hivejdbc"),conf.getProperty("hiveuser"),"");
		Statement stmt = con.createStatement();
		String tableName="cdrext";
		String location=conf.getProperty("exterDir")+reportDate;
		String sql = "alter table " + tableName +" set location '"+location+"'";
		
		logger.info("Running: " + sql);
		stmt.execute(sql);
		con.close();
	}

	
	public  void loading() throws SQLException
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		Config conf=new Config();
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
 
//		Connection con = DriverManager.getConnection("jdbc:hive2://192.168.99.100:10786/ml","hadoop","welcome");
		Connection con = DriverManager.getConnection(conf.getProperty("hivejdbc"),conf.getProperty("hiveuser"),conf.getProperty("hivepass"));
		Statement stmt = con.createStatement();
		String SrctableName="cdrext";
		String DsttableName="cdr";
		String nonstrict="set hive.exec.dynamic.partition.mode=nonstrict;";
		String dynamicpart="set hive.exec.dynamic.partition = true;";
//		String sql = "insert overwrite table " + DsttableName +" partition(yearmonthday)" 
//                      +" select `IMSI`,`IMEI`,`DeviceName`,`Longitude`,`Latitude`,"
//				      + "`SourceOSCategory` , `DeviceType` ,`MarketingVendor` ,"
//				      + "`CallDuration` ,`TimeStamp`,substring(`TimeStamp`,0,10) as ymd"+" from "+SrctableName;
		
		String sql = "insert overwrite table " + DsttableName +" partition(ymd="+reportDate 
                +") select `IMSI`,`IMEI`,`DeviceName`,`Longitude`,`Latitude`,"
			      + "`SourceOSCategory` , `DeviceType` ,`MarketingVendor` ,"
			      + "`CallDuration` ,`TimeStamp` from "+SrctableName;

		logger.info("Running: \n" + nonstrict+"\n"+dynamicpart+"\n"+sql);
		stmt.execute(dynamicpart);
		stmt.execute(nonstrict);
		stmt.executeUpdate(nonstrict+sql);
		con.close();
		
	}
}
