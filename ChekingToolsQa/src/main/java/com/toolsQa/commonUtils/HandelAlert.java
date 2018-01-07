package com.toolsQa.commonUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class HandelAlert {
     public static void acceptAlert(WebDriver driver){
    	 Alert al=driver.switchTo().alert();
    	 al.accept();
     }
     public static void cancelAlert(WebDriver driver){
    	 Alert al=driver.switchTo().alert();
    	 al.dismiss();
     }
}
