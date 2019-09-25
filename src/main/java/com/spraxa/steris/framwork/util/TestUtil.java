
package com.spraxa.steris.framwork.util;

import java.awt.image.BufferedImage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spraxa.steris.framwork.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 70;

	public void switchTOFrame() {
		driver.switchTo().frame("");
	}
	
	public void weClick(WebElement weElement) {
		weElement.click();
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

	public void actionClass(WebElement actObjDoubleClick) {
		Actions actObj = new Actions(driver);
		actObj.doubleClick(actObjDoubleClick).build().perform();
	}

	public  void actionForClick(WebElement actObjForClick) {
		Actions actObj = new Actions(driver);
		actObj.click(actObjForClick).build().perform();
	}

	public static void actionCropImage(WebElement cropTracker) {
		// Actions actObj=new Actions(driver);
		Actions crop = new Actions(driver);
		crop.moveToElement(cropTracker);
		// crop.clickAndHold(cropTracker).moveByOffset(30,
		// 50).release().build().perform();
		crop.dragAndDropBy(cropTracker, 100, 120).build().perform();
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
	
	public void cropImage(WebElement cropTracker) {
		Actions crop = new Actions(driver);
		crop.dragAndDropBy(cropTracker, 200,220).build().perform();
	}
	
	
}