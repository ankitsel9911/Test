package com.spraxa.somatus.framwork.testcase;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spraxa.somatus.framwork.base.TestBase;
import com.spraxa.somatus.framwork.pages.ExtentReportsScreenShotClass;
import com.spraxa.somatus.framwork.pages.HomePage;
import com.spraxa.somatus.framwork.pages.LoginPage;
import com.spraxa.somatus.framwork.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ExtentReports extent;
	ExtentTest logger;
	TestUtil testUtil;

	public LoginPageTest() {
		super();
	}
	
	@BeforeTest
	public void configReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Spraxa Solutions Pvt. Ltd.").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Ankit Yadav");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));	
	}
	
	@BeforeMethod
	public void startReport() {
		initilization();
		loginPage = new LoginPage();	
	}

	//@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
	}

	@Test()
	public void validLoginTest() throws Exception {
		logger = extent.startTest(prop.getProperty("validLogin"));
		logger.log(LogStatus.PASS, prop.getProperty("loginPage"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String varifyTitle=loginPage.validateLoginPage();
		String homePageTitle="Somatus | Patient Care";
		Assert.assertEquals(varifyTitle, homePageTitle, prop.getProperty("homePageTitle"));
		Thread.sleep(12000);
		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "validLogin");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		logger.log(LogStatus.PASS, prop.getProperty("logSuccessful"));
		extent.endTest(logger);
	}
	
	@Test()
	public void invalidloginTest() throws Exception {
		logger = extent.startTest(prop.getProperty("invalidLogin"));
		logger.log(LogStatus.PASS, prop.getProperty("enterUnamePname"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("invalidePass"));
	    String actualText= loginPage.invalidLoginContaint();
		String expectedLoginContaint= prop.getProperty("wrongUnamePname");
		Assert.assertEquals(actualText, expectedLoginContaint, prop.getProperty("invalidUnamePname"));
		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "invalidlogin");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
	if(actualText.equalsIgnoreCase(expectedLoginContaint)) {
		logger.log(LogStatus.PASS,actualText+ prop.getProperty("invalidUnameOrPass"));
	}else {
		logger.log(LogStatus.FAIL, prop.getProperty("invalidUnamePname"));
	}
	extent.endTest(logger);
	}

	@Test()
	public void verifyLoginPageTitle() throws Exception {
		logger = extent.startTest(prop.getProperty("verifyLoginTitle"));
		logger.log(LogStatus.PASS, prop.getProperty("validationLogin"));
		 String verifyTitle=loginPage.validateLoginPage();
		Assert.assertEquals(verifyTitle, prop.getProperty("verifyTitle"), prop.getProperty("homePageTitle"));
		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "verifyLoginPage");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		logger.log(LogStatus.PASS, prop.getProperty("verifyLoginTitle"));
		extent.endTest(logger);
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}

