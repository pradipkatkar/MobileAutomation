package com.flipcart.tests;

import org.testng.annotations.Test;

import com.flipcart.base.BaseClass;
import com.flipcart.pages.LoginPage;
import com.flipcart.pages.SearchingItemPage;
import com.flipcart.utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SearchingItem extends BaseClass {
	

	@BeforeTest
	public void Before() throws Exception 
	{
		server	= startAppiumServer();
		driver = getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test
	public void searchItem() throws Exception {	
		
		ReadConfig read = new ReadConfig();
		
		SearchingItemPage searchpage = new SearchingItemPage();
		
		LoginPage loginpage = new LoginPage();
		
		searchpage.searchitempage(driver,read.getLangauge());
		
		loginpage.enterUsername(driver, read.getUsername());
		loginpage.clickOnSubmit(driver);
		loginpage.enterPassword(driver, read.getPassword());
		loginpage.clickOnSubmit(driver);
		
		searchpage.getProductName(driver, read.getSearchProductName());
		searchpage.searchProduct(driver);	
	}
	
	@AfterTest
	public void After() 
	{
		driver.quit();
		server.stop();
	}
}
