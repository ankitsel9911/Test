
package com.spraxa.steris.framwork.testcase;

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
import com.spraxa.steris.framwork.base.TestBase;
import com.spraxa.steris.framwork.pages.HomePage;
import com.spraxa.steris.framwork.pages.LoginPage;
import com.spraxa.steris.framwork.util.TestUtil;

public class LoginPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	public ExtentReports extent;
	public ExtentTest logger;
	public TestUtil testUtil;

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
	

	
	/*@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Spraxa Solutions Pvt. Ltd.").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Ankit Yadav");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		initilization();
		loginPage = new LoginPage();
		
	}
	

	//@BeforeMethod
	public void setUp() {

		initilization();
		loginPage = new LoginPage();
	}*/

	@Test()
	public void validLoginTest() throws Exception {
		logger = extent.startTest(prop.getProperty("validLogin"));
		logger.log(LogStatus.PASS, prop.getProperty("enterValid"));
		logger.log(LogStatus.PASS, prop.getProperty("clickOnLogin"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String varifyTitle=loginPage.validateLoginPage();
		String homePageTitle=prop.getProperty("title");
		Assert.assertEquals(varifyTitle, homePageTitle,  prop.getProperty("homePageTitleMatch"));
		logger.log(LogStatus.PASS,  prop.getProperty("successfulLogin"));
		extent.endTest(logger);
	}
	
	@Test()
	public void invalidloginTest() throws InterruptedException {
		logger = extent.startTest(prop.getProperty("invalidLogin"));
		logger.log(LogStatus.PASS, prop.getProperty("enterUnamePname"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("invalidePass"));
	    String actualText= loginPage.validateAuthenticationFaild();
		String expectedAuthentication=prop.getProperty("authenticationFailed");
		Assert.assertEquals(actualText, expectedAuthentication, prop.getProperty("invalidUnamePname"));
	if(actualText.equalsIgnoreCase(expectedAuthentication)) {
		logger.log(LogStatus.PASS,actualText+ prop.getProperty("invalidUnumPnum"));
	}else {
		logger.log(LogStatus.FAIL, prop.getProperty("validNamePass"));
	}
	extent.endTest(logger);
	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		logger = extent.startTest(prop.getProperty("varifyLoginPageTitle"));
		logger.log(LogStatus.PASS, prop.getProperty("loginPageValidation"));
		 String varifyTitle=loginPage.validateLoginPage();
		Assert.assertEquals(varifyTitle, prop.getProperty("title"), prop.getProperty("titleNotMatch"));
		logger.log(LogStatus.PASS, prop.getProperty("varifyLoginTitle"));
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
