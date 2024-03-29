//package com.spraxa.somatus.framwork.pages;
//
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import com.google.common.io.Files;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
// 
//public class ExtentReportsScreenShotClass{
//	ExtentReports extent;
//	ExtentTest logger;
//	WebDriver driver;
//	
//	
//	//@BeforeTest
//	
//
//        //This method is to capture the screenshot and return the path of the screenshot.
//	
//	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
//		String destination = System.getProperty("user.dir") + "/PassedTestsScreenshots/"+screenshotName+dateName+".png";
//		File finalDestination = new File(destination);
//		Files.copy(source, finalDestination);
//		return destination;
//	}
//		
//
//	
//	@AfterMethod
//	public void getResult(ITestResult result) throws Exception{
//		if(result.getStatus() == ITestResult.FAILURE){
//			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
//                        String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, result.getName());
//			//To add it in the extent report 
//			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
//		}else if(result.getStatus() == ITestResult.SKIP){
//			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//		}
//		// ending test
//		//endTest(logger) : It ends the current test and prepares to create HTML report
//		extent.endTest(logger);
//	}
//	
//
//	@AfterTest
//	public void endReport(){
//		// writing everything to document
//		//flush() - to write or update test information to your report. 
//                extent.flush();
//                //Call close() at the very end of your session to clear all resources. 
//                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
//                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
//                //Once this method is called, calling any Extent method will throw an error.
//                //close() - To close all the operation
//                extent.close();
//    }
//}