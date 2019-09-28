package com.spraxa.somatus.framwork.util;

import java.awt.image.BufferedImage;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	Actions actObj;
	public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 80;
	public static long IMPLICIT_WAIT = 80;
	public long WAIT_FOR_ACTIONA = 20;
	
	public void switchTOFrame() {
		driver.switchTo().frame("");
	}

	public void actionForSendKeys(WebElement forSendKeys, String value) {
		 actObj=new Actions(driver);
		actObj.sendKeys(value).build().perform();
	}
	
	public void actionWithSendkeys(WebElement weAction, String value, WebDriver driver) {
		Actions actObjRole = new Actions(driver);
		actObjRole.click(weAction).build().perform();
		actObjRole.sendKeys(Keys.ENTER, value).build().perform();
		actObjRole.sendKeys(Keys.ENTER).build().perform();
	}
	//////////////////Click ///////////////////
	public void weClick(WebElement weElement) {
		try {
			weElement.click();
		}catch(Exception e) {
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", weElement);
		}
		
		
	}
	
	public  void webDriverWait(String xpath) {
		WebElement sendIssue = (WebElement) new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		sendIssue.click();
	}

	public void jsClick(WebElement webObject) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webObject);
	}
	

	public void actionSelectclass(WebElement weSelect, String strVal) {
		Actions actProgramName=new Actions(driver);
		actProgramName.click(weSelect).build().perform();
		actProgramName.sendKeys(Keys.ENTER,strVal).build().perform();
		actProgramName.sendKeys(Keys.ENTER).build().perform();
		
		
	}

	public void actionClass(WebElement actObjDoubleClick) {
		 actObj = new Actions(driver);
		actObj.doubleClick(actObjDoubleClick).build().perform();
	}

	public  void actionForClick(WebElement actObjForClick) {
		 actObj = new Actions(driver);
		actObj.click(actObjForClick).build().perform();
	}
	
	public  void actionForEnterButton(WebElement actObjForClick) {
		 actObj = new Actions(driver);
		actObj.sendKeys(Keys.ENTER);
	}

	public void jsScroll(WebElement weScroll) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,10)");
	}
	
	public  void actionCropImage(WebElement cropTracker) {
		actObj = new Actions(driver);
		actObj.moveToElement(cropTracker);
		actObj.dragAndDropBy(cropTracker, 100, 120).build().perform();
	}
	
	public void jsSendKeys(WebElement weSendKeys, String strName) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		///executor.executeScript("arguments[0].click();", webObject);
		                       // JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click();", weSendKeys);
		executor.executeScript("document.getElementById(weSendKeys).value=strName;");
	}
	
	

	public void cropImage(BufferedImage buf, int x, int y, int width, int height) {
		BufferedImage croppedImage = buf.getSubimage(x, y, width, height);

	}

	public  void actionMoveToElement(WebElement target) {
		Actions actObj = new Actions(driver);
		actObj.moveToElement(target).build().perform();
	}

	public void validateText(WebElement we) {
		String strTxt=we.getText();
	}
	
	public void elementForClick(WebElement we) {
		we.click();
	}
	
	public void elementForSendKeys(WebElement we, String value) {
		we.sendKeys(value);
	}
	
	public void cropImage(WebElement cropTracker) {
		Actions crop = new Actions(driver);
		crop.dragAndDropBy(cropTracker, 200,220).build().perform();
	}
	
	
	
	public int randomNumber(int min, int max) {
		Random rn = new Random();
		int answer = rn.nextInt(min) + max;
		return answer;
	}
	
	public boolean varifyElementIsEnabled(WebElement we) {
		boolean elementIsEnabled=we.isEnabled();
		return elementIsEnabled;
		}
	
	
	public int random(int min, int max) {
//		Random rnd=new Random();
//		int rcnt=ThreadLocalRandom.current().nextInt(min, max);
//		return rcnt;

			Random objGenerator = new Random();
			int randomNumber = objGenerator.nextInt(((max - min) + 1)) + min;
			return randomNumber;

		}
	
	
	
	
	
}
