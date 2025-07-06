package com.flipcart.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.flipcart.base.BaseClass;
import com.flipcart.pages.LoginPage;
import com.flipcart.pages.LogoutPage;
import com.flipcart.utilities.ObjectsRepo;
import com.flipcart.utilities.ReadConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Logout extends ObjectsRepo {

	
	@BeforeTest
	public void Before() throws Exception 
	{
		server	= BaseClass.startAppiumServer();
		driver = BaseClass.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@Test
	public void logoutTest() throws Exception 
	{
		ReadConfig read = new ReadConfig();
		
		LogoutPage logoutpage = new LogoutPage();
		logoutpage.logoutpage(driver,read.getLangauge());
		
		LoginPage loginpage = new LoginPage();
		loginpage.enterUsername(driver, read.getUsername());
		loginpage.clickOnSubmit(driver);
		loginpage.enterPassword(driver, read.getPassword());
		loginpage.clickOnSubmit(driver);
		
		logoutpage.logoutrest(driver);
	}
	
	@AfterTest
	public void After(ITestResult result) 
	{
		driver.quit();	
		server.stop();	
	}
	
	
}
