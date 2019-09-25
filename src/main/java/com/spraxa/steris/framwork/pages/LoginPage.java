///package com.spraxa.steris.framwork.pages;

package com.spraxa.steris.framwork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.spraxa.steris.framwork.base.TestBase;

public class LoginPage extends TestBase {

///Page Factory - OR

//@FindBy(xpath = "//a[contains(text(),'Login')]")
//WebElement clickLoginButton_BT;

	@FindBy(xpath = "//input[@name='userName']")
	public WebElement userName_EB;

	@FindBy(xpath = "//input[@name='Password']")
	public WebElement userPassword_EB;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	public WebElement clickLogin_BT;

	@FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
	WebElement authenticationFaild;

///Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPage() {
		return driver.getTitle();
	}

	
	public String validateAuthenticationFaild() {
		String val= authenticationFaild.getText();
return val;
	}

	public HomePage login(String userNam, String userPass) throws InterruptedException {
		Thread.sleep(4000);
		userName_EB.sendKeys(userNam);
		userPassword_EB.sendKeys(userPass);
		clickLogin_BT.click();
		Thread.sleep(4000);
	//	String val = authenticationFaild.getText();
		return new HomePage();
	}

}