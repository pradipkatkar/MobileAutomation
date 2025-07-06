package com.flipcart.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.flipcart.base.BaseClass;

public class ScreenshotListener extends ObjectsRepo  implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {

		String path = BaseClass.getScreenshot(result.getMethod().getMethodName());
			try {
				//test.addScreenCaptureFromPath(path);
				test.fail(result.getName()).addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		//Reporting report = new Reporting();
		//extentReports =	report.generateReport();
	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
