package com.toolsQa.commonUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {

	public static void doMouseHoverOn(WebDriver driver,WebElement srcElement){
		Actions act=new Actions(driver);
		act.moveToElement(srcElement).perform();
	}
	/*
	 * @param this function is to handel the element clickable at point
	 * 
	 * */
	public static void moveToExactPoint(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		int xCord=element.getLocation().getX();
		int yCord=element.getLocation().getY();
		act.moveToElement(element, xCord, yCord).perform();
	}
	
	public static void openLinkInAnotherTAb(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.contextClick(element).sendKeys("t").perform();
	}
	
	public static void openAnotherTAb(WebDriver driver){
		Actions act=new Actions(driver);
		act.sendKeys(Keys.CONTROL,"t").perform();
	}
	
	public static void dragAndDrop(WebDriver driver,WebElement src,WebElement dst){
		Actions act=new Actions(driver);
		act.clickAndHold(src).moveToElement(dst).release().perform();
	}
}
