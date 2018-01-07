package com.toolsQa.commonUtils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
	public static void selectELementByText(WebElement element,String text){
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void selectELementByValue(WebElement element,String Value){
		Select sel=new Select(element);
		sel.selectByValue(Value);
	}
	
	public static void selectElementBtIndex(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void verifyText(WebElement element,String text){
		Select sel=new Select(element);
		List<WebElement> allOptions=sel.getOptions();
		for(int i=0;i<allOptions.size();i++){
			String name=allOptions.get(i).getText();
			if(name.equals(text)){
				System.out.println("The text is present in the select box");
			}
		}
	}
}
