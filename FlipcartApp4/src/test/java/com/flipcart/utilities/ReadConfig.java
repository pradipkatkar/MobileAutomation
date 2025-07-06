package com.flipcart.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\pradi\\eclipse-workspace\\FlipcartAppV3\\FlipcartApp3\\src\\main\\resources\\com\\flipcart\\properties\\global.properties");
		
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getLangauge() 
	{
		String lang = (String) prop.get("lang");
		return lang;
	}
	
	public String getUsername() 
	{
		String uname = (String) prop.get("gmail");
		return uname;
	}
	
	public String getPassword() 
	{
		String pwd = (String) prop.get("password");
		return pwd;
	}
	
	public String getSearchProductName() 
	{
		String pname = (String) prop.get("productsearchname");
		return pname;
	}

	public String getAppName() 
	{
		String appname = (String) prop.get("FlipcartApp");
		return appname;
	}
	
	public String getDeviceName() 
	{
		String devicename = (String) prop.get("device");
		return devicename;
	}
		
}
