package com.flipcart.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	
	public void loginpage(AndroidDriver<MobileElement> driver,String lang) throws Exception 
	{	
		System.out.println(lang);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+lang+"\"));");
		driver.findElement(By.xpath("//*[@text='"+lang+"']")).click();
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().text(\"" + lang + "\"));");
		//driver.findElement(By.xpath("//*[@text='"+lang+"']")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")).click();
		
		//driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys((String) prop.get("gmail"));
		
		//driver.findElement(By.id("com.flipkart.android:id/button")).click();
		
		//driver.findElement(By.xpath("//*[@text='Password']")).sendKeys((String) prop.get("password"));
		
		//driver.findElement(By.id("com.flipkart.android:id/button")).click();
			
	}
	
	public void enterUsername(AndroidDriver<MobileElement> driver,String gmail) 
	{
		driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys(gmail);
	}
	
	public void enterPassword(AndroidDriver<MobileElement> driver,String pass) 
	{
		driver.findElement(By.xpath("//*[@text='Password']")).sendKeys((pass));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void clickOnSubmit(AndroidDriver<MobileElement> driver) 
	{
		driver.findElement(By.id("com.flipkart.android:id/button")).click();	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
}
