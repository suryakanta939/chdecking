package com.toolsQa.commonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandelFrame {
	
     public static void handelFrameByXpath(WebDriver driver,WebElement element){
    	 driver.switchTo().frame(element);
     }
     
     public static void hadelFrameBYIndex(WebDriver driver,int indexOfFrame){
    	 driver.switchTo().frame(indexOfFrame);
     }
     
     public static void handelFrameByText(WebDriver driver,String text){
    	 driver.switchTo().frame(text);
     }
     
     public static void backToMainWIndow(WebDriver driver){
    	 driver.switchTo().defaultContent();
     }
}
