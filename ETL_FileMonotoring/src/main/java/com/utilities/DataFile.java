package com.utilities;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFile implements FilenameFilter {
	
	
	String FileForma;
	String Excluding=null;

	public DataFile(String Ex,String excl) {
		// TODO Auto-generated constructor stub
		this.FileForma=Ex;
		this.Excluding=excl;
	}
	
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		String regPat=FileForma;
		Pattern pa=Pattern.compile(regPat);
		Matcher ma=pa.matcher(name);
		return ma.matches() && !name.endsWith(Excluding);
	}

}
