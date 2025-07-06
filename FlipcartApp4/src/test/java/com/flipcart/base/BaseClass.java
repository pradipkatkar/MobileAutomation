package com.flipcart.base;


import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.flipcart.utilities.ObjectsRepo;
import com.flipcart.utilities.ReadConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass extends ObjectsRepo {
	
			public static AppiumDriverLocalService startAppiumServer() 
			{
				boolean flag = isServerRunning(4723);
				
				if(!flag) 
				{
					server = AppiumDriverLocalService.buildDefaultService();
					server.start();
				}
				return server;
			}
	
			public static boolean isServerRunning(int port) {
				boolean isServerRun = false;
				
				ServerSocket serverSocket;
				
				try {
					serverSocket = new ServerSocket(port);
					serverSocket.close();
				} catch (IOException e) {
					isServerRun = true;
				}finally {
					serverSocket = null;
				}
				
				return isServerRun;
			}
			
			public static DesiredCapabilities capabilities() throws Exception 
			{
				ReadConfig rc = new ReadConfig();
				
				String appname = rc.getAppName();
				String device_name = rc.getDeviceName();
				
				File appDir = new File("src");
				File app = new File(appDir,appname);
				
				DesiredCapabilities cap = new DesiredCapabilities();
				
				//System.out.println("device_name ="+device_name);
				
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
				cap.setCapability(MobileCapabilityType.UDID, "RZ8M40MZXJT");
				
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
				
				cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	
				return cap;
				
 			}
			
			public static AndroidDriver<MobileElement> getDriver() throws Exception
			{
				DesiredCapabilities cap = capabilities();				
				driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
				
				logger = Logger.getLogger("eFlipcart");
				PropertyConfigurator.configure("Log4j.properties");
				
				return driver;
			}
		
			public static String getScreenshot(String name) 
			{
				String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
				
			    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    
			    String screenshotpath = System.getProperty("user.dir")+"/Screenshot/"+name+timeStamp+".png";
			    
			    File dest = new File(screenshotpath);
				
			    try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return screenshotpath;
			} 
}
