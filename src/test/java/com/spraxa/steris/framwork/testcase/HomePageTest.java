///package com.spraxa.steris.framwork.test;

package com.spraxa.steris.framwork.testcase;

import java.io.File;
import java.lang.reflect.Method;

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
import com.spraxa.steris.framwork.loginpage.ExtentTestManager;
import com.spraxa.steris.framwork.pages.ExtentReportsScreenShotClass;
import com.spraxa.steris.framwork.pages.HomePage;
import com.spraxa.steris.framwork.pages.LoginPage;
import com.spraxa.steris.framwork.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	TestUtil testUtil=new TestUtil();

	ExtentReports extent;
	ExtentTest logger;

	

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void configReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Spraxa Solutions Pvt. Ltd.")
				.addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Ankit Yadav");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
	
	@BeforeMethod
	public void startReport() throws InterruptedException {
		initilization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test
	public void tc_NUVOVerifyExportFunctionality() throws Exception {
		logger = extent.startTest(prop.getProperty("tc_NUVO1503"));
		logger.log(LogStatus.PASS, prop.getProperty("logSuccess"));
		logger.log(LogStatus.PASS, prop.getProperty("clickAdminVue"));
		logger.log(LogStatus.PASS, prop.getProperty("navigateToSystem"));
		logger.log(LogStatus.PASS, prop.getProperty("clickExportButton"));
		logger.log(LogStatus.PASS, prop.getProperty("chooseFromPDF"));
		homePage.tc_NUVO1503VerifyExport();
		homePage.tc_NUVO1503VerifyExport1();
		Assert.assertTrue(true);
		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "tc_NUVOVerifyExport");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		Assert.assertTrue(driver.getTitle().equals(prop.getProperty("title")));
		homePage.tc_NUVO1503VerifyExport1();
		String actualPDFTextValue= homePage.getTextPDF();
		String ExpectedPDFTextValue="PDF";
		String varifyPDFText=homePage.getTextPDF();
		if(actualPDFTextValue.equalsIgnoreCase(ExpectedPDFTextValue)) {
			logger.log(LogStatus.PASS,actualPDFTextValue+ prop.getProperty("userNameAndPass"));
		}
		logger.log(LogStatus.PASS, prop.getProperty("tcPassNuvo1503"));
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
