package com.flipcart.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.flipcart.base.BaseClass;
import com.flipcart.pages.LoginPage;
import com.flipcart.utilities.ObjectsRepo;
import com.flipcart.utilities.ReadConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Login extends ObjectsRepo {
	
	@BeforeClass
	public void setup() throws Exception 
	{
		server = BaseClass.startAppiumServer();
		driver = BaseClass.getDriver();
		logger.info("Application Opened.");
	}
	
	@Test
	public void loginTest() throws Exception 
	{

		ReadConfig read = new ReadConfig();
	
		LoginPage loginpage = new LoginPage();
		
		loginpage.loginpage(driver,read.getLangauge());
		
		loginpage.enterUsername(driver, read.getUsername());
		logger.info("Username entered.");
		
		loginpage.clickOnSubmit(driver);
		logger.info("Cliked on Button.");
		
		loginpage.enterPassword(driver, read.getPassword());
		logger.info("Password entered.");
		
		loginpage.clickOnSubmit(driver);
		logger.info("Cliked on Button.");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}
	
	@AfterClass
	public void close(ITestResult result) 
	{	
		driver.quit();
		server.stop();
	}
	
	
}
