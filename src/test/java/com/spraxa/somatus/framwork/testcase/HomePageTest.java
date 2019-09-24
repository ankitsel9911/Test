package com.spraxa.somatus.framwork.testcase;

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
import com.spraxa.somatus.framwork.pages.HomePage;
import com.spraxa.somatus.framwork.pages.LoginPage;
import com.spraxa.somatus.framwork.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	ExtentReports extent;
	ExtentTest logger;
	String actualExpectedDisableButtonTextValueTextValue;
	String verifyDisableButtonText;

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void configReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Spraxa Solutions Pvt. Ltd.")
				.addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Ankit Yadav");
		//extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@BeforeMethod
	public void startReport() throws InterruptedException {
		initilization();

		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	//@Test
	public void tc003() {
		logger = extent.startTest(prop.getProperty("tc02StartTest"));
		logger.log(LogStatus.PASS, prop.getProperty("logSuccessful"));
		extent.endTest(logger);
	}

	@Test
	public void tc_01VerifyCareNoteSummaryButton() throws Exception {
		logger = extent.startTest(prop.getProperty("tc02StartTest"));
		logger.log(LogStatus.PASS, prop.getProperty("logSuccessful"));
		logger.log(LogStatus.PASS, prop.getProperty("selRequ"));
		logger.log(LogStatus.PASS, prop.getProperty("clickOnReq"));
		logger.log(LogStatus.PASS, prop.getProperty("clickOnProgramName"));
		logger.log(LogStatus.PASS, prop.getProperty("addActivity"));
		logger.log(LogStatus.PASS, prop.getProperty("addCareNote"));
		logger.log(LogStatus.PASS, prop.getProperty("fillAllRequiredField"));
		logger.log(LogStatus.PASS, prop.getProperty("clickCareNoteSummary"));
		homePage.verifyCareNoteSummaryButton();
		homePage.verifyCareNoteSummaryDetail();

		//String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "tc_02Verify");
		String screenshotPath = getScreenhot(driver, "tc_02Verify");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));

		String actualCareNoteSummary = homePage.getCareNoteSummary();
		String ExpectedCareNoteSummary = prop.getProperty("careNote");
		if (actualCareNoteSummary.equalsIgnoreCase(ExpectedCareNoteSummary)) {
			logger.log(LogStatus.PASS, actualCareNoteSummary + " - : " + prop.getProperty("userClick"));
		}
		extent.endTest(logger);
	}

	

	//@Test()
	public void tc_02VerifyAddCarePlan() throws Exception {
		logger = extent.startTest(prop.getProperty("verifyAddCarePlan"));
		logger.log(LogStatus.PASS, prop.getProperty("logSuccessful"));
		logger.log(LogStatus.PASS, prop.getProperty("selRequ"));
		logger.log(LogStatus.PASS, prop.getProperty("clickOnReq"));
		logger.log(LogStatus.PASS, prop.getProperty("clickOnActivities"));
		logger.log(LogStatus.PASS, prop.getProperty("addActivity"));
		logger.log(LogStatus.PASS, prop.getProperty("clickAddCarePlan"));
		homePage.VerifyAddCarePlan();
		String screenshotPath = getScreenhot(driver, "verifyAddCarePlan");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		logger.log(LogStatus.PASS, prop.getProperty("activities"));
		
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
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		//extent.close();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
