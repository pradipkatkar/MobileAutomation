package com.flipcart.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.flipcart.base.BaseClass;


public class Reporting extends ObjectsRepo implements IReporter {
	
	ExtentHtmlReporter htmlReporter;
	
	String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
	{
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/HtmlReport"+timeStamp+".html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		
		for(ISuite suite : suites) 
		{
			Map<String, ISuiteResult> result = suite.getResults();
			
			for(ISuiteResult r : result.values()) 
			{
				ITestContext context = r.getTestContext();
				
				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
			}
		}
		extent.flush();
	}

	public void buildTestNodes(IResultMap tests, Status status) {
		
		if(tests.size() > 0)
		{
			for(ITestResult result : tests.getAllResults() ) 
			{
				test = extent.createTest(result.getMethod().getMethodName());
				
				for(String group : result.getMethod().getGroups()) 
				test.assignCategory(group);
				
				String message = "Test" + status.toString().toLowerCase() + "ed";
				
				if(result.getThrowable() != null)
					message = result.getThrowable().getMessage();
				
				
				if(result.getStatus() == ITestResult.SUCCESS)
				{
					test.log(status, message);
				}
				
				else if(result.getStatus() == ITestResult.FAILURE)
				{
					try {		
					test.log(status, message).addScreenCaptureFromPath(BaseClass.getScreenshot(result.getMethod().getMethodName()));
					} 
					catch (IOException e) 
					{
					e.printStackTrace();
					}
				}
					
				
			}
		}
		
	}	
	
	
}
