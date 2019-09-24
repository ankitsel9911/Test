package com.spraxa.somatus.framwork.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spraxa.somatus.framwork.base.TestBase;
import com.spraxa.somatus.framwork.util.TestUtil;

public class HomePage extends TestBase {
	TestUtil tUtil = new TestUtil();
	String strTelePhone = "Telephone";
	String homeVisit = "Home Visit";
	ExtentTest logger;
	// WebDriver driver;
	ExtentReports extent;

	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	///////////// TC_1//Verify Care Note Summary Button is disabled//////

	@FindBy(xpath = "//div[contains(text(),'Ankit Yadav')]")
	WebElement weSelectName;

	@FindBy(xpath = "//table/tbody/tr[2]/td[5]")
	WebElement wePatientName;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement weClickPrograms;

	@FindBy(xpath = "//button[contains(text(),'Care Note Summary')]")
	WebElement weCheckDisableButton;

	@FindBy(xpath = "//button[contains(text(),'Care Note Summary')]")
	WebElement weCheckDisable;

	public String getTextCheckDisableButton() {
		return weCheckDisableButton.getText();
	}

	public String getTextCheckEnabledButton() {
		return weCheckDisableButton.getText();
	}

	public void verifyCareNoteSummary() throws InterruptedException {
		Thread.sleep(4000);
		int intHome = new TestUtil().randomNumber(1, 3);
		Actions actObjRole = new Actions(driver);
		actObjRole.click(weSelectName).build().perform();
		actObjRole.sendKeys(Keys.ENTER, "Neha Aggarwal").build().perform();
		actObjRole.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//table/tbody/tr[+intHome+]/td[5]"));
		wePatientName.click();
		Thread.sleep(3000);
		weClickPrograms.click();
		boolean weEnabled = weCheckDisableButton.isDisplayed();
		Thread.sleep(5000);

	}

	/////////////////////////////////
	int intHome = new TestUtil().randomNumber(1, 3);
	@FindBy(xpath = "//td[contains(text(),'Shivam Taylor')]")
	WebElement weRequiredPatientName;

	@FindBy(xpath = "//table/tbody/tr[3]/td[1]")
	WebElement weProgramName;

	@FindBy(xpath = "//button[@class='add-program-button dropdown-toggle']")
	WebElement weAddActivity;

	@FindBy(xpath = "(//ul[@class='dropdown-menu show']/li)[3]//a")
	WebElement weAddCareNote;
	@FindBy(xpath = "//div[contains(text(),'Select...')]")
	WebElement weSelectMethod;

	@FindBy(xpath = "//div[@class='ql-container ql-snow']//p")
	WebElement weNoteComment;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement addTaskSaveButtonNote;

	@FindBy(xpath = "//button[contains(text(),'Care Note Summary')]")
	WebElement weCareNoteSummaryButton;

	@FindBy(xpath = "//div[@class='sc-EHOje ldTBTR sc-ifAKCX dvxQVR']")
	WebElement weCareNoteNext;

	@FindBy(xpath = "//div[@class='sc-bZQynM hzJOec sc-ifAKCX dvxQVR']")
	WebElement weCareNotePre;

	@FindBy(xpath = "//div[1]/p[2]")
	WebElement weEditNote;

	@FindBy(xpath = "//h2[contains(text(),'Care Note Summary')]")
	WebElement weVerifyCareNoteSummary;

	@FindBy(xpath = "//div[@class='sc-EHOje ldTBTR sc-ifAKCX dvxQVR']")
	WebElement weClickNextCareNote;

	public String getCareNoteSummary() {
		return weVerifyCareNoteSummary.getText();
	}

	public void verifyCareNoteSummaryButton() throws InterruptedException {
		Thread.sleep(4000);

		Actions actObjRole = new Actions(driver);
		actObjRole.click(weSelectName).build().perform();
		actObjRole.sendKeys(Keys.ENTER, "Neha Aggarwal").build().perform();
		actObjRole.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		weRequiredPatientName.click();
		tUtil.weClick(weRequiredPatientName);
		Thread.sleep(2000);
		tUtil.weClick(weProgramName);
		Thread.sleep(2000);
		tUtil.weClick(weAddActivity);
		Thread.sleep(3000);
		tUtil.weClick(weAddCareNote);
		Thread.sleep(2000);
		Actions actObjMethos = new Actions(driver);
		actObjMethos.click(weSelectMethod).build().perform();
		actObjMethos.sendKeys(Keys.ENTER, homeVisit).build().perform();
		actObjMethos.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		Actions actObjInteractionWith = new Actions(driver);
		actObjInteractionWith.click(weSelectMethod).build().perform();
		actObjInteractionWith.sendKeys(Keys.ENTER, "ggbgbg (DME Supplier)").build().perform();
		actObjInteractionWith.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);

		Actions actObjAddNoteComment = new Actions(driver);
		actObjAddNoteComment.click(weNoteComment).build().perform();
		actObjAddNoteComment.sendKeys(Keys.ENTER, "Only for testing..").build().perform();
		Thread.sleep(2000);

		Actions actObjType = new Actions(driver);
		actObjType.click(weSelectMethod).build().perform();
		actObjType.sendKeys(Keys.ENTER, "Medication Reconciliation/Review").build().perform();
		actObjType.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);

		Actions actObjSaveButtonNote = new Actions(driver);
		actObjSaveButtonNote.click(addTaskSaveButtonNote).build().perform();
		Thread.sleep(3000);
	}

	public void verifyCareNoteSummaryDetail() throws InterruptedException {
		Actions actObjSummaryButton = new Actions(driver);
		actObjSummaryButton.click(weCareNoteSummaryButton).build().perform();
		Thread.sleep(3000);

		Actions actObjCareNoteNext = new Actions(driver);
		actObjCareNoteNext.click(weCareNoteNext).build().perform();
		Thread.sleep(2000);
		actObjCareNoteNext.click(weCareNoteNext).build().perform();
		Thread.sleep(2000);
		actObjCareNoteNext.click(weCareNoteNext).build().perform();
		Thread.sleep(4000);

		actObjCareNoteNext.click(weCareNoteNext).build().perform();
		Thread.sleep(3000);
		Actions actObjCareNotePre = new Actions(driver);
		actObjCareNotePre.click(weCareNotePre).build().perform();

	}

	//////////////// TC003/////////////////////
	@FindBy(xpath = "//table[@class='ant-table-fixed']//tr[1]//td[1]")
	WebElement weCreatedOnF;

	@FindBy(xpath = "//table[@class='ant-table-fixed']//tr[2]//td[1]")
	WebElement weModifiedOn;

	public void VerifyOrderCareNotes() throws InterruptedException {
		Thread.sleep(4000);
		Actions actObjRole = new Actions(driver);
		actObjRole.click(weSelectName).build().perform();
		actObjRole.sendKeys(Keys.ENTER, "Neha Aggarwal").build().perform();
		actObjRole.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		weRequiredPatientName.click();
		Thread.sleep(2000);
		weProgramName.click();
		// CurrentDateAndTime();
		String firstDate = weCreatedOnF.getText();
		String secoundDate = weModifiedOn.getText();
		if (firstDate.equalsIgnoreCase(secoundDate)) {
			System.out.println(firstDate + "--letest date and old date are same test case fail " + secoundDate);

		} else {
			System.out.println(firstDate + "--letest date and old date are different  " + secoundDate);

		}
	}

	@FindBy(xpath = "//a[contains(text(),'Activities')]")
	private WebElement weActivities;

	@FindBy(xpath = "(//ul[@class='dropdown-menu show']/li)[6]//a")
	private WebElement weAddCarePlan;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	private WebElement wePatientError;

	@FindBy(xpath = "(//ul/div/li/input)[1]")
	private WebElement weCheckBoxAlcohol;

	@FindBy(xpath = "(//ul/div/li/input)[2]")
	private WebElement weCheckBoxAchieveGlycemic;

	@FindBy(xpath = "(//ul/div/li/input)[3]")
	private WebElement weCheckBoxAddressBarriers;

	@FindBy(xpath = "(//ul/div/li/input)[4]")
	private WebElement weCheckBox4;

	@FindBy(xpath = "(//ul/div/li/input)[5]")
	private WebElement weCheckBox5;

	@FindBy(xpath = "//button[contains(text(),'Generate')]")
	private WebElement weGenerate;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']/p")
	private WebElement weQuestionForDoctor;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement weErrorOk;

	public String weErrorPatient() {
		return wePatientError.getText();
	}

	public void VerifyAddCarePlan() throws InterruptedException {
		Actions actObjRole = new Actions(driver);
		actObjRole.click(weSelectName).build().perform();
		actObjRole.sendKeys(Keys.ENTER, "Neha Aggarwal").build().perform();
		actObjRole.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		weRequiredPatientName.click();
		
		Thread.sleep(2000);
		tUtil.weClick(weActivities);
		Thread.sleep(2000);
		tUtil.weClick(weAddActivity);
		Thread.sleep(2000);
		tUtil.weClick(weAddCarePlan);
		Thread.sleep(2000);
		tUtil.weClick(weCheckBoxAlcohol);
		Thread.sleep(2000);
		//tUtil.weClick(weCheckBoxAchieveGlycemic);
		//Thread.sleep(2000);
		//tUtil.weClick(weCheckBoxAddressBarriers);
		//Thread.sleep(2000);

		tUtil.weClick(weGenerate);
		Thread.sleep(12000);

	}

	public String CurrentDateAndTime() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String datetime = formatter.format(date);
		return datetime;
	}

}
