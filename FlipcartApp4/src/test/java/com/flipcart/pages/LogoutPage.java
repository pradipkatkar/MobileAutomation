package com.flipcart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogoutPage {

	public void logoutpage(AndroidDriver<MobileElement> driver,String lang) throws Exception 
	{	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))");
		driver.findElement(By.xpath("//*[@text='"+lang+"']")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")).click();
	}
	
	/*
		driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys((String)(prop.get("gmail")));
		
		driver.findElement(By.id("com.flipkart.android:id/button")).click();
		
		driver.findElement(By.xpath("//*[@text='Password']")).sendKeys((String) prop.get("password"));
		
		driver.findElement(By.id("com.flipkart.android:id/button")).click();
		
	*/
	public void logoutrest(AndroidDriver<MobileElement> driver) {	
		
		driver.findElement(By.className("android.widget.ImageButton")).click();
		
		driver.findElement(By.xpath("//*[@text='My Account']")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Logout of this app\"))");
		
		driver.findElement(By.xpath("//*[@text='Logout of this app']")).click();
		
		driver.findElement(By.xpath("//*[@text='Yes']")).click();
			
	}
}
