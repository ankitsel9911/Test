package com.spraxa.steris.framwork.testcase;
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
public class Demo {
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	TestUtil testUtil=new TestUtil();

	ExtentReports extent;
	ExtentTest logger;
	
	
	
//	@Test(priority = 1)
//	public void verifyHomePageTitle() {
//		logger = extent.startTest(prop.getProperty("varifyLoginTitle"));
//		logger.log(LogStatus.PASS, prop.getProperty("homePageSucc"));
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "HexaVueConnect", prop.getProperty("titleNotMatch"));
//		logger.log(LogStatus.PASS, prop.getProperty("verifyHomeTitle"));
//		
//	}
//
//	// ⦁ NUVO-925-Verify Send to EMR
//	@Test()
//	public void tcNUVO925VerifySendToEMR() throws Exception {
//		logger = extent.startTest(prop.getProperty("tcNUVO925VerifySendToEMR"));
//		logger.log(LogStatus.PASS, prop.getProperty("logSuccess"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickOnMediaVeu"));
//		logger.log(LogStatus.PASS, prop.getProperty("DoubleClickAnyCase"));
//		logger.log(LogStatus.PASS, prop.getProperty("VerifySendToButton"));
//		//logger.log(LogStatus.PASS, prop.getProperty("selImage"));
//		logger.log(LogStatus.PASS, prop.getProperty("selSendToEMR"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickToEMR"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickYesPopup"));
//	
//
//		homePage.tcNUVO925SendToEMR();
//		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "LoginPage1");
//		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
//		Assert.assertTrue(driver.getTitle().equals(prop.getProperty("title")));
//		logger.log(LogStatus.PASS, prop.getProperty("testCasePass"));
//		
//	}
//
//	
//	////////////////// NUVO1843VedioEditing
//	@Test(priority = 1)
//	public void tcNUVO1843VerifyVideoEditingTools() throws Exception {
//		logger = extent.startTest(prop.getProperty("tcNUVO1843"));
//		logger.log(LogStatus.PASS,prop.getProperty("logSuccess"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickOnMediaVeu"));
//		logger.log(LogStatus.PASS, prop.getProperty("selAnyCase"));
//
//		homePage.NUVO1843VedioEditing();
//		Assert.assertTrue(driver.getTitle().equals(prop.getProperty("title")));
//		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "tcNUVO1843");
//		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
//		logger.log(LogStatus.PASS, prop.getProperty("testcasePassVedio"));
//	}
//	
//	/////////////////////////////////////
//	
//	@Test()
//	public void tcNOVO1983CropImage() throws Exception {
//		logger = extent.startTest(prop.getProperty("tcNOVO1983CropImage"));
//		logger.log(LogStatus.PASS, prop.getProperty("logSuccess"));
//		logger.log(LogStatus.PASS, prop.getProperty("showListOfMultiplaCases"));
//		logger.log(LogStatus.PASS, prop.getProperty("verifySendToButton"));
//		logger.log(LogStatus.PASS, prop.getProperty("sendToOption"));
//		homePage.tc1983CropImage();
//		Assert.assertTrue(driver.getTitle().equals(prop.getProperty("title")));
//		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "tcNOVO1983Crop");
//		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
//		logger.log(LogStatus.PASS, prop.getProperty("testCasePassedtcNOVO1983"));
//	}
//	
//	//////////Preserve Column State
//	@Test(priority = 1)
//	public void tcNUVO1959PreserveColumnState() throws Exception {
//		logger = extent.startTest(prop.getProperty("tcNUVO1959"));
//		logger.log(LogStatus.PASS, prop.getProperty("logSuccess"));
//		logger.log(LogStatus.PASS, prop.getProperty("unhideColumn"));
//		homePage.tcNUVO1959Select();
//		homePage.tcNUVO1959SelectMediaVue();		
//		logger.log(LogStatus.PASS, prop.getProperty("tcPass"));
//		String actualCaseIDTextValue= homePage.getCaseId();
//		String ExpectedPDFTextValue="Case Id";
//		String varifyCaseIDText=homePage.getCaseId();
//		if(actualCaseIDTextValue.equalsIgnoreCase(ExpectedPDFTextValue)) {
//			logger.log(LogStatus.PASS,actualCaseIDTextValue+ prop.getProperty(" colState"));
//		}
//		logger.log(LogStatus.PASS,prop.getProperty("tcPassedPreserveTest"));
//	}
//
//	//////////////////////////// PDF and Excel //////
//	@Test
//	public void tc_NUVOVerifyExportFunctionality() throws Exception {
//		logger = extent.startTest(prop.getProperty("tc_NUVO1503"));
//		logger.log(LogStatus.PASS, prop.getProperty("logSuccess"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickAdminVue"));
//		logger.log(LogStatus.PASS, prop.getProperty("navigateToSystem"));
//		logger.log(LogStatus.PASS, prop.getProperty("clickExportButton"));
//		logger.log(LogStatus.PASS, prop.getProperty("chooseFromPDF"));
//		homePage.tc_NUVO1503VerifyExport();
//		Assert.assertTrue(true);
//		String screenshotPath = ExtentReportsScreenShotClass.getScreenhot(driver, "tc_NUVOVerifyExport");
//		logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
//		Assert.assertTrue(driver.getTitle().equals(prop.getProperty("title")));
//		homePage.tc_NUVO1503VerifyExport1();
//		String actualPDFTextValue= homePage.getTextPDF();
//		String ExpectedPDFTextValue="PDF";
//		String varifyPDFText=homePage.getTextPDF();
//		if(actualPDFTextValue.equalsIgnoreCase(ExpectedPDFTextValue)) {
//			logger.log(LogStatus.PASS,actualPDFTextValue+ prop.getProperty("userNameAndPass"));
//		}
//		logger.log(LogStatus.PASS, prop.getProperty("tcPassNuvo1503"));
//	}
	

}
