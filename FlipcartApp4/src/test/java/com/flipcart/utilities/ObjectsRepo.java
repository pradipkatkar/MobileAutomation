package com.flipcart.utilities;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class ObjectsRepo {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static AppiumDriverLocalService server;
	public static AndroidDriver<MobileElement> driver;
	public static Logger logger = null;
}
