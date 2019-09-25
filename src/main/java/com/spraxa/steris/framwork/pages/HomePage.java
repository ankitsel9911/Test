//div[@class='fa fa-trash actionIconsCaseDetail actionFilterIconsCaseDetail tooltip']

//a[@data-qtip='Delete']











//package com.spraxa.steris.framwork.pages;

package com.spraxa.steris.framwork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.utils.ExtentUtil;
import com.spraxa.steris.framwork.base.TestBase;
import com.spraxa.steris.framwork.util.TestUtil;

public class HomePage extends TestBase {

	TestUtil tUtil=new TestUtil();

	@FindBy(xpath = "//span[contains(text(),'Manage and share images and video captured during procedures')]")
	WebElement mediaVue_BT;
	
	@FindBy(xpath = "//div[contains(text(),'AdminVue')]")
	WebElement adminVue_BT;

	@FindBy(xpath = "//span[contains(text(),'Clear All')]")
	WebElement clearAllData_BT;
	
	@FindBy(xpath = "//h2[contains(text(),'Can not edit')]")
	WebElement DeleteVideo;

	@FindBy(xpath = "//a[@data-qtip='Next Page']")
		WebElement weNextPage;
	
	
	@FindBy(xpath = "(//tbody/tr/td[4]/div)[24]")
	WebElement sendToEMRData;
	
   ////1234b 56o
	@FindBy(xpath = "(//div[@class='thumbnail-container'])[1]")
	WebElement selectToImg;

	@FindBy(xpath = "(//span[@class='x-btn-arrow-el'])[5]")
	WebElement selectSendTo;

	@FindBy(xpath = "//span[contains(text(),'To EMR')]")
	WebElement clickTOEMR;

	@FindBy(xpath = "(//span[contains(text(),'To EMR')])[2]")
	WebElement saveToEMR;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement saveToEMRYes;

	@FindBy(xpath = "//div[@id='tool-1722-toolEl']")
	WebElement clickToClose;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[2]")
	WebElement clickToCancel;
	
	@FindBy(xpath = "(//div[@class='x-tool-tool-el x-tool-img x-tool-close '])[3]")
	WebElement weCancel;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[1]")
	WebElement weCancelBT;
	
	@FindBy(xpath = "//div[contains(text(),'No Media to display')]")
	WebElement successImageLabel;

	/////////////////////////////// Other////////////////////////////////////
	@FindBy(xpath = "(//tbody/tr/td[4]/div)[16]")
	WebElement clickEastlakeHV;

	@FindBy(xpath = "(//div[@class='thumbnail-container'])[2]")
	WebElement clickToImage;

	@FindBy(xpath = "//span[contains(text(),'Crop')]")
	WebElement cropImage;
	
	
	@FindBy(xpath="//div[@class='fa fa-trash actionIconsCaseDetail actionFilterIconsCaseDetail tooltip']")
	WebElement Deleteicon;

	@FindBy(xpath = "//canvas[@class='upper-canvas x-component x-fit-item x-component-default']")
	WebElement cropCanvasHeightWidth;
	
	@FindBy(xpath = "(//span[contains(text(),'Save')])[1]")
	WebElement cropAndSave;
	
	@FindBy(xpath = "(//span[contains(text(),'Save')])[4]")
	WebElement saveInfo;

	////////////////////////// ⦁ NUVO-1959/////////////////////////

	// @FindBy(xpath = "(//div[@unselectable='on' and
	// @class='x-column-header-trigger'])[3]")
	@FindBy(xpath = "//div[@id='gridcolumn-1091-triggerEl']")
	WebElement weSelect;

	@FindBy(xpath = "//span[contains(text(),'Columns')]")
	WebElement weMoveToElementColumns;

	@FindBy(xpath = "(//span[contains(text(),'Case ID')])[2]")
	WebElement weClickCaseId;

	@FindBy(xpath = "//div[contains(text(),'MediaVue')]")
	WebElement weNavigateBackToMediaVue;

	@FindBy(xpath = "//input[@placeholder='Search By: Patient Name, Physician Name, Procedure, MRN, Comments']")
	WebElement wePlaceHolder;
	
	@FindBy(xpath = "//div[contains(text(),'ScheduleVue')]")
	WebElement clickScheduleVue;
	
	@FindBy(xpath = "//div[contains(text(),'MediaVue')]")
	WebElement clickMediaVue;
	
	@FindBy(xpath = "//span[contains(text(),'Case ID')]")
	WebElement varifyCaseId;

	//////////////////////////// ⦁ NUVO-1843- Verify Video Editing
	//////////////////////////// Tools////////////////////
	
	;
	
	

	@FindBy(xpath = "(//div[contains(text(),'RETINAL 25_RETINAL 25')])[1]")
	WebElement doubleClickOnData;
	
	@FindBy(xpath = "//label[contains(text(),'MediaVue')]")
	WebElement navigetToTable;
	
	@FindBy(xpath = "(//div[contains(text(),'EGD')])[1]")
	WebElement clickOnRecordVedio;
    //2b and 134index 
	@FindBy(xpath = "(//div[@class='middlefilmstripClass']/div)[4]")
	WebElement doubleClickOnVedio;

	@FindBy(xpath = "//a[@data-qtip='Delete']")
	WebElement clickOnDeleteIcon;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement deleteMediaYesIcon;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement confirmToDelete;

	@FindBy(xpath = "//a[@data-qtip='Take photo']")
	WebElement takePhoto;

	@FindBy(xpath = "//a[@data-qtip='Download']")
	WebElement clickOnDownloadVedio;

	@FindBy(xpath = "//div[contains(text(),'Successfully deleted')]")
	WebElement successfullyDelete;
	
	@FindBy(xpath = "//span[contains(text(),'(Deleted)')]")
	WebElement weDelete;
	
	@FindBy(xpath = "//label[contains(text(),'Case')]")
	WebElement weNavigetToBack;

	///////////////// ⦁ NUVO-1503- Verify export functionality /////////////////////

	@FindBy(xpath = "//div[contains(text(),'AdminVue')]")
	WebElement clickAdminVue;

	@FindBy(xpath = "//div[contains(text(),'System Setup')]")
	WebElement clickSystemSetup;

	@FindBy(xpath = "//div[contains(text(),'Dropdown Values')]")
	WebElement clickDropdownValues;
	
	@FindBy(xpath = "(//span[@class='x-btn-arrow-el'])[2]")
	WebElement clickToSelectExcelPdf;
	
	@FindBy(xpath = "//span[contains(text(),'Excel')]")
	WebElement clickForExcel;
	
	@FindBy(xpath = "//span[contains(text(),'PDF')]")
	WebElement clickForPDF;
	

	public HomePage() {
// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String getTextPDF() {
		return clickForPDF.getText();
	}
	
	public String getCaseId() {
		return varifyCaseId.getText();
	}
	
	public String getInCompletPatientInformation() {
		return varifyCaseId.getText();
	}
	
	public void tc_NUVO1503VerifyExport() throws InterruptedException {
		//Reporter.log("Succefully Login");
		//mediaVue_BT.click();
		adminVue_BT.click();
		Reporter.log("Click On MediaVue Button");
		ExtentUtil.toLogStatus("Click On MediaVue Button");
		Thread.sleep(2000);
		tUtil.jsClick(clickAdminVue);
		Thread.sleep(2000);
		clickSystemSetup.click();
		Thread.sleep(2000);
		clickDropdownValues.click();
		Thread.sleep(2000);
		tUtil.actionForClick(clickToSelectExcelPdf);
		Thread.sleep(4000);
	}
		public void tc_NUVO1503VerifyExport1() throws InterruptedException {
			Thread.sleep(10000);
		clickForPDF.click();
		Thread.sleep(10000);
	}

	public void NUVO1843VedioEditing() throws InterruptedException {
		tUtil.weClick(mediaVue_BT);
		clearAllData_BT.click();
		Thread.sleep(2000);
		
		tUtil.jsClick(weNextPage);
		Thread.sleep(2000);
		tUtil.actionClass(clickOnRecordVedio);
		Thread.sleep(10000);
		tUtil.actionClass(doubleClickOnVedio);
		Thread.sleep(4000);
		//tUtil.actionClass(actObjDoubleClick);
		tUtil.actionForClick(clickOnDeleteIcon);
		Thread.sleep(4000);
		tUtil.actionForClick(saveToEMRYes);
		Thread.sleep(4000);
		tUtil.actionForClick(weOk);
		Thread.sleep(4000);
		tUtil.actionForClick(takePhoto);
		Thread.sleep(4000);
		tUtil.jsClick(clickOnDownloadVedio);
		Thread.sleep(4000);
		tUtil.actionForClick(weNavigetToBack);
	
	
	}

	public void tcNUVO1959Select() throws InterruptedException {
		mediaVue_BT.click();
		clearAllData_BT.click();
		tUtil.jsClick(weSelect);
		Thread.sleep(2000);
		tUtil.actionMoveToElement(weMoveToElementColumns);
		Thread.sleep(2000);
		tUtil.actionForClick(weClickCaseId);
		Thread.sleep(2000);
		wePlaceHolder.click();
		Thread.sleep(2000);
		tUtil.jsClick(weNavigateBackToMediaVue);
		Thread.sleep(3000);
		tUtil.jsClick(clickScheduleVue);
		//clickScheduleVue.click();
		Thread.sleep(5000);
	}
	public void tcNUVO1959SelectMediaVue() throws InterruptedException {
		tUtil.jsClick(clickMediaVue);
	}
//////////////////////////////
	public void tc1983CropImage() throws InterruptedException {
		tUtil.weClick(mediaVue_BT);
		clearAllData_BT.click();
		Thread.sleep(2000);
		tUtil.actionClass(clickEastlakeHV);
		Thread.sleep(4000);
		tUtil.actionClass(clickToImage);
		Thread.sleep(2000);
		//cropImage
		//tUtil.jsClick(cropImage);
		Thread.sleep(5000);
		tUtil.cropImage(cropCanvasHeightWidth);
		Thread.sleep(5000);
		tUtil.jsClick(cropImage);
		Thread.sleep(5000);
		tUtil.jsClick(cropAndSave);
		Thread.sleep(2000);
		tUtil.jsClick(saveInfo);
		Thread.sleep(2000);
		tUtil.jsClick(weOk);
	}

	public void tcNUVO925SendToEMR() throws InterruptedException {
		Thread.sleep(2000);
		tUtil.weClick(mediaVue_BT);
		Thread.sleep(2000);
		tUtil.weClick(clearAllData_BT);
		Thread.sleep(2000);
		//tUtil.jsClick(weNextPage);
		//tUtil.jsClick(weNextPage);
		tUtil.weClick(weNextPage);
		Thread.sleep(2000);
		tUtil.actionClass(sendToEMRData);
		Thread.sleep(2000);
		tUtil.weClick(selectToImg);
		Thread.sleep(2000);
		tUtil.actionForClick(selectSendTo);
		Thread.sleep(3000);
		tUtil.actionForClick(clickTOEMR);
		////// if that is change so there is showing error
		Thread.sleep(10000);
		tUtil.weClick(saveToEMR);
		Thread.sleep(2000);
		tUtil.actionForClick(saveToEMRYes);
		Thread.sleep(4000);
		tUtil.jsClick(weCancelBT);

	}
	
	@FindBy(xpath = "(//div[contains(text(),'RETINAL 25_RETINAL 25')])[3]")
	WebElement clickData;
	
	@FindBy(xpath = "(//div[@class='hovereffect'])[1]")
	WebElement clickImage;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement weOk;
	
	public void tcNUVO925SendToEMRinvalid() throws InterruptedException {
		Thread.sleep(2000);
		mediaVue_BT.click();
		Thread.sleep(2000);
		clearAllData_BT.click();
		Thread.sleep(2000);
		tUtil.actionClass(clickData);
		Thread.sleep(3000);
		clickImage.click();
		Thread.sleep(2000);
		tUtil.actionForClick(selectSendTo);
		Thread.sleep(10000);
		tUtil.actionForClick(clickTOEMR);
		//weOk.click();
		//clickToClose.click();
		
	}
	//div[contains(text(),'27130 PELVIS, HIP ; RP,RV, RCN Test')]
	
	public String verifyHomePageTitle() {
		  return driver.getTitle();
	  }
	
	public String verifyPopupDeleteMedia() {
		  return driver.getTitle();
	  }

	public void cancelBT() {
		tUtil.jsClick(clickToCancel);
	}

	public boolean verifyCorrectImageLabel() {
		return successImageLabel.isDisplayed();
	}

	public boolean verifyDeleteVedio() {
		return successfullyDelete.isDisplayed();
	}

}
























