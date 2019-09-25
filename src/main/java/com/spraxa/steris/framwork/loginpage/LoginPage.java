package com.spraxa.steris.framwork.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spraxa.steris.framwork.generic.GenericMethod;

public class LoginPage extends GenericMethod{
	
	@FindBy(xpath = "//input[@name='userName']")
	private WebElement userName_ED;
	
	@FindBy(xpath = "//input[@name='Password']")
	private WebElement userPassword_ED;
	
	@FindBy(xpath = "//a[@id='button-1020']")
	private WebElement userLogin_BT;
	
	
//	
//	@FindBy(xpath = "//span[contains(text(),'Manage and share images and video captured during procedures')]")
//	private WebElement mediaVue_BT;
//	
//	@FindBy(xpath = "//div[@class='x-tab-guard x-tab-guard-after']")
//	
//	private WebElement mediaVueDetails;
	
	GenericMethod gm=new GenericMethod();
	
	public LoginPage(){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	
	
	public void validLogin() {
		gm.launchBrowser("ch");
		gm.getUrl("http://devnuvo.steris.com/Develop");
		gm.inputTextBox(userName_ED, "superadmin");
		gm.inputTextBox(userPassword_ED, "Steris10");
		gm.click(userLogin_BT);
		
		LoginPage login=PageFactory.initElements(gm.driver, LoginPage.class);
		login.validLogin();
	}
	
	
	

}
