package com.spraxa.steris.framwork.loginpage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.spraxa.steris.framwork.pages.HomePage;

public class TestListener extends HomePage implements ITestListener {
	
	public void onTestStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("I am in onStart method " + iTestContext.getName());
		 iTestContext.setAttribute("WebDriver", this.driver);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
