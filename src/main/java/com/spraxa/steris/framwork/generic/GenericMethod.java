package com.spraxa.steris.framwork.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GenericMethod {
	
	public WebDriver driver=null;
	public void launchBrowser(String browserName) {
		
		if(browserName.equals("ch")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public void inputTextBox(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void doubleClick(WebElement element) {
		Actions actObj=new Actions(driver);
		actObj.doubleClick(element).build().perform();
	}
	
	
	
}
