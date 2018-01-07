package com.toolsQa.commonUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebPage {
	
	public static void implyCityWait(WebDriver driver,int timeInSec){
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}
	
	public static void waitForELemntToClick(WebDriver driver,int timeINSec,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, timeINSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForELemntToSelect(WebDriver driver,int timeINSec,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, timeINSec);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForELemntToBevisible(WebDriver driver,int timeINSec,List<WebElement> elements){
		WebDriverWait wait=new WebDriverWait(driver, timeINSec);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
}
