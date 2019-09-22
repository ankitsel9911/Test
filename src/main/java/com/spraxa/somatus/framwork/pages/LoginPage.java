package com.spraxa.somatus.framwork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.spraxa.somatus.framwork.base.TestBase;

public class LoginPage extends TestBase {

///Page Factory - OR

	///// First Login to gmail account
	@FindBy(xpath = "//input[@name='identifier']")
	WebElement gmailUserName;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement gmailNext_BT;

	@FindBy(xpath = "//input[@name='password']")
	WebElement gmailPassword_ED;

	@FindBy(xpath = "//input[@name='userName']")
	public WebElement userName_EB;

	@FindBy(xpath = "//input[@name='Password']")
	public WebElement userPassword_EB;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	public WebElement clickLogin_BT;

	@FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
	WebElement authenticationFaild;

	@FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')]")
	WebElement weInvalidLoginContaint;

///Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPage() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();
	}

	public String invalidLoginContaint() {
		String val = weInvalidLoginContaint.getText();
		return val;
	}

	public HomePage login(String gmailUname, String gmailPass) throws InterruptedException {

		Thread.sleep(5000);
		gmailUserName.sendKeys(gmailUname);
		Thread.sleep(2000);
		gmailNext_BT.click();
		Thread.sleep(2000);
		gmailPassword_ED.sendKeys(gmailPass);
		Thread.sleep(2000);
		gmailNext_BT.click();
		Thread.sleep(4000);
		return new HomePage();
	}
}
