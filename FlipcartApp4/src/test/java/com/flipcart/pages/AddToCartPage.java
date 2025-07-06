package com.flipcart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddToCartPage {
	
	public void addToCart(AndroidDriver<MobileElement> driver,String lang) throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+lang+"\"))");
		driver.findElement(By.xpath("//*[@text='"+lang+"']")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/tv_right_cta")).click();
	}
	
	/*
		driver.findElement(By.id("com.flipkart.android:id/phone_input")).sendKeys((String)prop.get("gmail"));
		
		driver.findElement(By.id("com.flipkart.android:id/button")).click();
		
		driver.findElement(By.xpath("//*[@text='Password']")).sendKeys((String)prop.get("password"));
		
		driver.findElement(By.id("com.flipkart.android:id/button")).click();
		
	*/
	
	public void getProductName(AndroidDriver<MobileElement> driver,String pname) throws Exception 
	{
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView")).sendKeys(pname);
		
	}
	
	public void searchRest(AndroidDriver<MobileElement> driver) throws Exception {
		
		driver.findElement(By.id("com.flipkart.android:id/txt_title")).click();
		
		driver.findElement(By.id("com.flipkart.android:id/allow_button")).click();
		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SAMSUNG 192 L Direct Cool Single Door 2 Star Refrigerator\"))");
		
		driver.findElement(By.xpath("//*[@text='SAMSUNG 192 L Direct Cool Single Door 2 Star Refrigerator']")).click();
	}
	
	public void addProductToCart(AndroidDriver<MobileElement> driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	
	public void goToCart(AndroidDriver<MobileElement> driver) 
	{
		driver.findElement(By.xpath("//*[@text='SKIP']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@text='GO TO CART']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
}
