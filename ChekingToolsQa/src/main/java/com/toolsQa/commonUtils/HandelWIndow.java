package com.toolsQa.commonUtils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class HandelWIndow {

	public static void handelWIndowByTitle(WebDriver driver,String title){

		String pid=driver.getWindowHandle();
		Set<String> ids=driver.getWindowHandles();
		for(String id:ids){
			if(!id.equals(pid)){
				driver.switchTo().window(id);
				String winTitle=driver.getTitle();
				if(winTitle.equals(title)){
					driver.switchTo().window(id);
				}
			}
		}
	}
   public static void handelWIndowByNo(WebDriver driver,int windowNo){
	   Set<String> ids=driver.getWindowHandles();
	   Iterator<String> itr=ids.iterator();
	   for(int i=1;i<=ids.size();i++){  
	      String id=itr.next();
	      if(i==windowNo){
	    	  driver.switchTo().window(id);
	      }
	     
			
		}
	   
   }
}
