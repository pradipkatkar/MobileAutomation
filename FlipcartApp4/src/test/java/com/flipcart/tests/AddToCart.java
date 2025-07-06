package com.flipcart.tests;

import org.testng.annotations.Test;

import com.flipcart.base.BaseClass;
import com.flipcart.pages.AddToCartPage;
import com.flipcart.pages.LoginPage;
import com.flipcart.utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;


public class AddToCart extends BaseClass {
	
	
	@BeforeTest
	public void Before() throws Exception 
	{
		server	= startAppiumServer();
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test
	public void addToCart() throws Exception 
	{
		ReadConfig read = new ReadConfig();
			
		AddToCartPage addtocartpage = new AddToCartPage();
		
		LoginPage loginpage = new LoginPage();
		
		addtocartpage.addToCart(driver, read.getLangauge());

		loginpage.enterUsername(driver, read.getUsername());
		loginpage.clickOnSubmit(driver);
		loginpage.enterPassword(driver, read.getPassword());
		loginpage.clickOnSubmit(driver);
		
		addtocartpage.getProductName(driver, read.getSearchProductName());
		addtocartpage.searchRest(driver);
		addtocartpage.addProductToCart(driver);
		addtocartpage.goToCart(driver);
	
	}
	
	@AfterTest
	public void After() 
	{
		driver.quit();
		server.stop();
	}
	
	
}
